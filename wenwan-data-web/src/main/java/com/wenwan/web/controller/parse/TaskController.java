package com.wenwan.web.controller.parse;

import com.wenwan.api.parse.ITaskApi;
import com.wenwan.common.api.APIResponse;
import com.wenwan.common.api.SearchResult;
import com.wenwan.model.parse.TaskGroupVo;
import com.wenwan.model.parse.TaskSqlVo;
import com.wenwan.service.api.parse.TaskService;
import com.wenwan.web.controller.BaseController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TaskController extends BaseController implements ITaskApi {

    @Autowired
    private TaskService taskService;

    @Override
    public APIResponse<Void> insertGroup(TaskGroupVo taskGroupVo) {
        taskService.insertGroup(taskGroupVo);
        return APIResponse.getOkJsonResult();
    }

    @Override
    public APIResponse<Void> updateGroup(TaskGroupVo taskGroupVo) {
        taskService.updateGroup(taskGroupVo);
        return APIResponse.getOkJsonResult();
    }

    @Override
    public APIResponse<Void> deleteGroup(Long groupId) {
        taskService.deleteGroup(groupId);
        return APIResponse.getOkJsonResult();
    }

    @Override
    public APIResponse<SearchResult<TaskGroupVo>> groupList(TaskGroupVo taskGroupVo) {
        taskService.groupList(taskGroupVo);
        return APIResponse.getOkJsonResult();
    }

    @Override
    public APIResponse<Void> insertSql(TaskSqlVo taskSqlVo) {
        taskService.insertSql(taskSqlVo);
        return APIResponse.getOkJsonResult();
    }

    @Override
    public APIResponse<Void> updateSql(TaskSqlVo taskSqlVo) {
        taskService.updateSql(taskSqlVo);
        return APIResponse.getOkJsonResult();
    }

    @Override
    public APIResponse<Void> deleteSql(Long sqlId) {
        taskService.deleteSql(sqlId);
        return APIResponse.getOkJsonResult();
    }

    @Override
    public APIResponse<SearchResult<TaskSqlVo>> sqlList(TaskSqlVo taskSqlVo) {
        taskService.sqlList(taskSqlVo);
        return APIResponse.getOkJsonResult();
    }
}
