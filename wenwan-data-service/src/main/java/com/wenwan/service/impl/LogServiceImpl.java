package com.wenwan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.wenwan.common.api.SearchResult;
import com.wenwan.mysql.dao.entity.BusinessLog;
import com.wenwan.mysql.dao.entity.ResultTable;
import com.wenwan.mysql.dao.entity.SqlLog;
import com.wenwan.model.result.LogVo;
import com.wenwan.model.result.SqlLogVo;
import com.wenwan.service.api.MapperConfigService;
import com.wenwan.service.api.parse.ParseTaskService;
import com.wenwan.service.api.result.LogService;
import com.wenwan.service.component.BusinessMapperStrategy;
import com.wenwan.service.constant.BusinessLogType;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class LogServiceImpl extends MapperConfigService<SqlLog, SqlLogVo> implements LogService {

    @Autowired
    private Map<BusinessLogType, BusinessMapperStrategy> businessLogMap;

    @Autowired
    private ParseTaskService parseTaskService;

    @Override
    public SearchResult<LogVo> list(LogVo logVo) {
        return businessLogMap.get(BusinessLogType.valueOf(logVo.getBusinessLog())).list(logVo);
    }

    @Override
    public SearchResult<SqlLogVo> sqlLogList(SqlLogVo sqlLogVo) {
        LambdaQueryWrapper<SqlLog> wrapper = Wrappers.lambdaQuery(SqlLog.class);
        addFilter(wrapper, sqlLogVo);
        List<SqlLog> sqlLogs = sqlLogMapper.selectList(wrapper);
        List<SqlLogVo> result = sqlLogs.stream().map(sqlLog -> {
            SqlLogVo sqlLogVo1 = new SqlLogVo();
            BeanUtils.copyProperties(sqlLog, sqlLogVo1);
            return sqlLogVo1;
        }).collect(Collectors.toList());
        return new SearchResult<>(result, result.size());
    }

    @Override
    public void reParse(String businessLog, Long businessLogId) {
        BusinessLog bl = businessLogMap.get(BusinessLogType.valueOf(businessLog)).getBusinessLog(businessLogId);
        parseTaskService.parseTask(bl.getParseRuleCode(), bl.getFileId(), bl.getParseRuleId());
    }

    @Override
    public String resultTable(String businessLog, Long fileId) {
        ResultTable resultTable = businessLogMap.get(BusinessLogType.valueOf(businessLog)).getResultTable(fileId);
        if(resultTable!=null){
            return resultTable.getContent();
        }
        return null;
    }

    @Override
    public ResponseEntity<Resource> downloadFile(String businessLog, Long businessLogId) {
        BusinessLog log = businessLogMap.get(BusinessLogType.valueOf(businessLog)).getBusinessLog(businessLogId);
        String filePath = log.getFilePath();
        Path file = Paths.get(filePath);

        try {
            Resource resource = new UrlResource(file.toUri());
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                    .body(resource);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }


    @Override
    protected void addFilter(LambdaQueryWrapper<SqlLog> wrapper, SqlLogVo sqlLogVo) {
        wrapper.eq(sqlLogVo.getFileId()!=null,SqlLog::getFileId, sqlLogVo.getFileId());
    }
}
