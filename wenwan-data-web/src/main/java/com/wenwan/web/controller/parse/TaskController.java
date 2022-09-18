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
    public APIResponse<String> insertGroup(TaskGroupVo taskGroupVo) {
        taskService.insertGroup(taskGroupVo);
        return APIResponse.getOkJsonResult();
    }

    @Override
    public APIResponse<String> updateGroup(TaskGroupVo taskGroupVo) {
        taskService.updateGroup(taskGroupVo);
        return APIResponse.getOkJsonResult();
    }

    @Override
    public APIResponse<String> deleteGroup(Long groupId) {
        taskService.deleteGroup(groupId);
        return APIResponse.getOkJsonResult();
    }

    @Override
    public APIResponse<SearchResult<TaskGroupVo>> groupList(TaskGroupVo taskGroupVo) {
        return APIResponse.getOkJsonResult(taskService.groupList(taskGroupVo));
    }

    @Override
    public APIResponse<String> insertSql(TaskSqlVo taskSqlVo) {
        taskService.insertSql(taskSqlVo);
        return APIResponse.getOkJsonResult();
    }

    @Override
    public APIResponse<String> updateSql(TaskSqlVo taskSqlVo) {
        taskService.updateSql(taskSqlVo);
        return APIResponse.getOkJsonResult();
    }

    @Override
    public APIResponse<String> deleteSql(Long sqlId) {
        taskService.deleteSql(sqlId);
        return APIResponse.getOkJsonResult();
    }

    @Override
    public APIResponse<TaskSqlVo> getDetail(Long sqlId) {
        return APIResponse.getOkJsonResult(taskService.getDetail(sqlId));
    }

    @Override
    public APIResponse<SearchResult<TaskSqlVo>> sqlList(TaskSqlVo taskSqlVo) {
        return APIResponse.getOkJsonResult(taskService.sqlList(taskSqlVo));
    }
}
