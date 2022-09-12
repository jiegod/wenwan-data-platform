package com.wenwan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wenwan.common.api.SearchResult;
import com.wenwan.dao.entity.TaskGroup;
import com.wenwan.dao.entity.TaskSql;
import com.wenwan.model.parse.TaskGroupVo;
import com.wenwan.model.parse.TaskSqlVo;
import com.wenwan.service.api.BaseService;
import com.wenwan.service.api.parse.TaskService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl extends BaseService implements TaskService {

    @Override
    public int insertGroup(TaskGroupVo taskGroupVo) {
        TaskGroup taskGroup = new TaskGroup();
        BeanUtils.copyProperties(taskGroupVo, taskGroup);
        return taskGroupMapper.insert(taskGroup);
    }

    @Override
    public int updateGroup(TaskGroupVo taskGroupVo) {
        TaskGroup taskGroup = new TaskGroup();
        BeanUtils.copyProperties(taskGroupVo, taskGroup);
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
        taskGroupMapper.selectPage(page, wrapper);
        List<TaskGroupVo> rows = page.getRecords().stream().map(taskGroup -> {
            TaskGroupVo resultVo = new TaskGroupVo();
            BeanUtils.copyProperties(taskGroup, resultVo);
            return resultVo;
        }).collect(Collectors.toList());
        return new SearchResult<>(rows, page.getTotal());
    }

    @Override
    public int insertSql(TaskSqlVo taskSqlVo) {
        TaskSql taskSql = new TaskSql();
        BeanUtils.copyProperties(taskSqlVo, taskSql);
        return taskSqlMapper.insert(taskSql);
    }

    @Override
    public int updateSql(TaskSqlVo taskSqlVo) {
        TaskSql taskSql = new TaskSql();
        BeanUtils.copyProperties(taskSqlVo, taskSql);
        return taskSqlMapper.updateById(taskSql);
    }

    @Override
    public int deleteSql(Long sqlId) {
        return taskSqlMapper.deleteById(sqlId);
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
}
