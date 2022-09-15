package com.wenwan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wenwan.common.api.SearchResult;
import com.wenwan.common.exception.BusinessException;
import com.wenwan.dao.entity.*;
import com.wenwan.model.parse.ParseRuleTableVo;
import com.wenwan.model.parse.TaskGroupVo;
import com.wenwan.model.parse.TaskSqlVo;
import com.wenwan.service.api.ServiceConfig;
import com.wenwan.service.api.parse.TaskService;
import com.wenwan.service.util.StringDateUtil;
import com.wenwan.service.util.UserStorage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl extends ServiceConfig<TaskGroup, TaskGroupVo> implements TaskService {

    @Override
    public int insertGroup(TaskGroupVo taskGroupVo) {
        TaskGroup taskGroup = new TaskGroup();
        BeanUtils.copyProperties(taskGroupVo, taskGroup);
        taskGroup.setOperator(UserStorage.get());
        taskGroup.setOperationDate(StringDateUtil.getToday());
        return taskGroupMapper.insert(taskGroup);
    }

    @Override
    public int updateGroup(TaskGroupVo taskGroupVo) {
        TaskGroup taskGroup = new TaskGroup();
        BeanUtils.copyProperties(taskGroupVo, taskGroup);
        taskGroup.setOperator(UserStorage.get());
        taskGroup.setOperationDate(StringDateUtil.getToday());
        return taskGroupMapper.updateById(taskGroup);
    }

    @Override
    public int deleteGroup(Long groupId) {
        return taskGroupMapper.deleteById(groupId);
    }

    @Override
    public SearchResult<TaskGroupVo> groupList(TaskGroupVo taskGroupVo) {
        Page<TaskGroup> page = new Page<>(taskGroupVo.getPageNo(), taskGroupVo.getPageSize());
        LambdaQueryWrapper<TaskGroup> wrapper = Wrappers.lambdaQuery(TaskGroup.class);
        addFilter(wrapper, taskGroupVo);
        taskGroupMapper.selectPage(page, wrapper);
        List<TaskGroupVo> rows = page.getRecords().stream().map(taskGroup -> {
            TaskGroupVo resultVo = new TaskGroupVo();
            BeanUtils.copyProperties(taskGroup, resultVo);
            return resultVo;
        }).collect(Collectors.toList());
        return new SearchResult<>(rows, page.getTotal());
    }

    @Override
    @Transactional
    public void insertSql(TaskSqlVo taskSqlVo) {
        LambdaQueryWrapper<TaskGroup> wrapper = Wrappers.lambdaQuery(TaskGroup.class).eq(TaskGroup::getCode, taskSqlVo.getTaskGroupCode());
        TaskGroup taskGroup = taskGroupMapper.selectOne(wrapper);
        if (taskGroup == null){
            throw new BusinessException("task group not exit, please check");
        }
        TaskSql taskSql = new TaskSql();
        BeanUtils.copyProperties(taskSqlVo, taskSql);
        taskSql.setOperator(UserStorage.get());
        taskSql.setOperationDate(StringDateUtil.getToday());
        taskSqlMapper.insert(taskSql);
        if (CollectionUtils.isEmpty(taskSqlVo.getTaskSqlParamVos())){
            return;
        }
        taskSqlVo.getTaskSqlParamVos().forEach(taskSqlParamVo -> {
            TaskSqlParam taskSqlParam = new TaskSqlParam();
            BeanUtils.copyProperties(taskSqlParamVo, taskSqlParam);
            taskSqlParam.setTaskSqlId(taskSql.getId());
            taskSqlParam.setOperator(UserStorage.get());
            taskSqlParam.setOperationDate(StringDateUtil.getToday());
            taskSqlParamMapper.insert(taskSqlParam);
        });
    }

    @Override
    public int updateSql(TaskSqlVo taskSqlVo) {
        TaskSql taskSql = new TaskSql();
        BeanUtils.copyProperties(taskSqlVo, taskSql);
        taskSql.setOperator(UserStorage.get());
        taskSql.setOperationDate(StringDateUtil.getToday());
        return taskSqlMapper.updateById(taskSql);
    }

    @Override
    public int deleteSql(Long sqlId) {
        return taskSqlMapper.deleteById(sqlId);
    }

    @Override
    public TaskSqlVo getDetail(Long sqlId) {
        TaskSql taskSql = taskSqlMapper.selectById(sqlId);
        TaskSqlVo taskSqlVo = new TaskSqlVo();
        BeanUtils.copyProperties(taskSql, taskSqlVo);
        return taskSqlVo;
    }

    @Override
    public SearchResult<TaskSqlVo> sqlList(TaskSqlVo taskSqlVo) {
        Page<TaskSql> page = new Page<>(taskSqlVo.getPageNo(), taskSqlVo.getPageSize());
        LambdaQueryWrapper<TaskSql> wrapper = Wrappers.lambdaQuery(TaskSql.class);
        taskSqlMapper.selectPage(page, wrapper);
        List<TaskSqlVo> rows = page.getRecords().stream().map(taskSql -> {
            TaskSqlVo resultVo = new TaskSqlVo();
            BeanUtils.copyProperties(taskSql, resultVo);
            return resultVo;
        }).collect(Collectors.toList());
        return new SearchResult<>(rows, page.getTotal());
    }

    @Override
    public Map<Long, List<ParseRuleTableVo>> getTableByParseRuleId(List<Long> parseRuleIds) {
        Map<Long, List<ParseRuleTableVo>> result = new HashMap<>();
        if (CollectionUtils.isEmpty(parseRuleIds)){
            return result;
        }
        List<ParseRuleTableVo> parseRuleTableVos = parseTableMappingMapper.getTableByParseRuleIds(parseRuleIds);
        result = parseRuleTableVos.stream().collect(Collectors.groupingBy(ParseRuleTableVo::getParseRuleId));
        return result;
    }

    @Override
    protected void addFilter(LambdaQueryWrapper<TaskGroup> wrapper, TaskGroupVo taskGroupVo) {
        if (StringUtils.isNotEmpty(taskGroupVo.getSearch())){
            wrapper.like(TaskGroup::getName, taskGroupVo.getName());
        }
    }
}
