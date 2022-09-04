package com.wenwan.web.controller.parse;

import com.wenwan.api.parse.ITaskApi;
import com.wenwan.common.api.APIResponse;
import com.wenwan.common.api.SearchResult;
import com.wenwan.model.parse.TaskGroupVo;
import com.wenwan.model.parse.TaskSqlVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TaskController implements ITaskApi {
    @Override
    public APIResponse<Void> insertGroup(TaskGroupVo taskGroupVo) {
        return null;
    }

    @Override
    public APIResponse<Void> updateGroup(TaskGroupVo taskGroupVo) {
        return null;
    }

    @Override
    public APIResponse<Void> deleteGroup(Long groupId) {
        return null;
    }

    @Override
    public APIResponse<SearchResult<TaskGroupVo>> groupList(TaskGroupVo taskGroupVo) {
        return null;
    }

    @Override
    public APIResponse<Void> insertSql(TaskSqlVo taskSqlVo) {
        return null;
    }

    @Override
    public APIResponse<Void> updateSql(TaskSqlVo taskSqlVo) {
        return null;
    }

    @Override
    public APIResponse<Void> deleteSql(Long sqlId) {
        return null;
    }

    @Override
    public APIResponse<SearchResult<TaskSqlVo>> sqlList(TaskSqlVo taskSqlVo) {
        return null;
    }
}
