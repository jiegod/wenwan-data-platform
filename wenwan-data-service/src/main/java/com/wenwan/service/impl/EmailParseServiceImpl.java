package com.wenwan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.wenwan.dao.entity.BusinessLog;
import com.wenwan.dao.entity.ParseRule;
import com.wenwan.dao.entity.SourceFile;
import com.wenwan.model.FilePattern;
import com.wenwan.model.enums.Datasource;
import com.wenwan.service.api.MapperConfigService;
import com.wenwan.service.api.parse.ParseRuleService;
import com.wenwan.service.api.parse.EmailParseService;
import com.wenwan.service.util.StringDateUtil;
import com.wenwan.service.util.UserStorage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmailParseServiceImpl extends MapperConfigService implements EmailParseService {

    @Autowired
    private ParseRuleService parseRuleService;

    // todo 目前只实现全量加载，但是sourceFile数据量会很大，后续必须实现增量，需要记录游标
    @Override
    @Transactional
    public void incrParse() {

    }

    @Override
    @Transactional
    public void fullParse(Datasource dataSource, String labels) {
        List<Long> labelList=null;
        if(StringUtils.isNotBlank(labels)){
            labelList = Arrays.stream(labels.split(",")).map(Long::parseLong).collect(Collectors.toList());
        }
        LambdaQueryWrapper<SourceFile> wrapper = Wrappers.lambdaQuery(SourceFile.class).orderByDesc(SourceFile::getId);
        SourceFile sourceFile = sourceFileMapper.selectOne(wrapper);
        Long maxFileId=sourceFile.getId();
        List<ParseRule> parseRules = parseRuleService.all4Parse(dataSource);
        for (ParseRule rule: parseRules) {
            FilePattern filePattern=new FilePattern();
            filePattern.setFileNameRegular(rule.getFileNameRegular());
            filePattern.setSenderRegular(rule.getSenderRegular());
            filePattern.setReceiverRegular(rule.getReceiverRegular());
            filePattern.setThemeRegular(rule.getThemeRegular());
            filePattern.setFilePathRegular(rule.getFilePathRegular());
            filePattern.setId(maxFileId);
            filePattern.setLabels(labelList);
            List<SourceFile> files = sourceFileMapper.regexp4Parse(filePattern);
            files.forEach(file->{
                insertToBusinessLog(rule,dataSource.getCode(),file,1);
            });
        }
        //未匹配的放入business_log，标记为加载失败
        FilePattern filePattern=new FilePattern();
        filePattern.setId(maxFileId);
        filePattern.setLabels(labelList);
        List<SourceFile> files = sourceFileMapper.regexp4Parse(filePattern);
        files.forEach(file->{
            insertToBusinessLog(null,dataSource.getCode(),file,2);
        });
    }

    private void insertToBusinessLog(ParseRule rule,String dataSource, SourceFile file,Integer loadingStatus) {
        //todo 后续从rule里娶business_log表
        BusinessLog businessLog=new BusinessLog();
        if(rule!=null){
            businessLog.setParseRuleId(rule.getId());
            businessLog.setParseRuleCode(rule.getCode());
            businessLog.setFileType(rule.getFileType());
        }
        businessLog.setFileId(file.getId());
        businessLog.setReceiver(file.getReceiver());
        businessLog.setSender(file.getSender());
        businessLog.setTheme(file.getTheme());
        businessLog.setReceiveDate(file.getReceiveDate());
        businessLog.setContent(file.getContent());
        businessLog.setFileName(file.getFileName());
        businessLog.setFilePath(file.getFilePath());
        businessLog.setDataSource(dataSource);
        businessLog.setLoadingStatus(loadingStatus);
        businessLog.setParseStatus(0);
        businessLog.setTableStatus(0);
        businessLog.setOperator(UserStorage.get());
        businessLog.setOperationDate(StringDateUtil.getToday());
        //todo 后续需要支持batch insert
        businessLogMapper.insert(businessLog);
    }
}
