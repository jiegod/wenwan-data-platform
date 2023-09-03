package com.wenwan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.wenwan.common.api.SearchResult;
import com.wenwan.model.parse.request.ResultTableQuery;
import com.wenwan.model.parse.result.TargetTableResult;
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
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
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
import java.util.Set;
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
    public TargetTableResult resultTable(ResultTableQuery query) {
        TargetTableResult result = new TargetTableResult();
        BusinessLog resultTable = businessLogMap.get(BusinessLogType.valueOf(query.getBusinessLog())).getBusinessLog(query.getBusinessLogId());
        if (resultTable != null && StringUtils.isNotEmpty(resultTable.getResultTable())) {
            String [] db = resultTable.getResultTable().split("\\.");
            int size = commonService.count(db[0], db[1]);
            List<Map<String, String>> resultData = commonService.executeDynamicQuery(getSql(resultTable.getResultTable(), query.getPageNo(), query.getPageSize()));
            if (CollectionUtils.isNotEmpty(resultData)) {
                Set<String> header = resultData.get(0).keySet();
                result.setRows(resultData);
                result.setHeader(header);
                result.setSize(size);
                result.setPageNo(query.getPageNo());
                result.setPageSize(query.getPageSize());
            }
        }
        return result;
    }
    private String getSql(String table, Integer pageNo, Integer pageSize) {
        Integer from = (pageNo - 1) * pageSize;
        return "select * from " + table + " limit " + from + "," + pageSize;
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
