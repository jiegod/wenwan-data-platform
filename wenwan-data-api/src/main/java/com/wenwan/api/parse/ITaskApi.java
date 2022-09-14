package com.wenwan.api.parse;

import com.wenwan.common.api.APIResponse;
import com.wenwan.common.api.SearchResult;
import com.wenwan.model.parse.TableInfoVo;
import com.wenwan.model.parse.TaskGroupVo;
import com.wenwan.model.parse.TaskSqlVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/parse/task")
@Api(description = "任务组相关api")
public interface ITaskApi {
    @PutMapping("/group/insert")
    @ApiOperation("新增任务组")
    APIResponse<String> insertGroup(@RequestBody TaskGroupVo taskGroupVo);

    @PostMapping("/group/update")
    @ApiOperation("修改任务组")
    APIResponse<String> updateGroup(@RequestBody TaskGroupVo taskGroupVo);

    @DeleteMapping("/group/delete/{groupId}")
    @ApiOperation("删除任务组")
    APIResponse<String> deleteGroup(@PathVariable Long groupId);

    @PostMapping("/group/list")
    @ApiOperation("任务组list")
    APIResponse<SearchResult<TaskGroupVo>> groupList(@RequestBody TaskGroupVo taskGroupVo);

    @PutMapping("/sql/insert")
    @ApiOperation("新增SQL")
    APIResponse<String> insertSql(@RequestBody TaskSqlVo taskSqlVo);

    @PostMapping("/sql/update")
    @ApiOperation("修改SQL")
    APIResponse<String> updateSql(@RequestBody TaskSqlVo taskSqlVo);

    @DeleteMapping("/sql/delete/{sqlId}")
    @ApiOperation("删除SQL")
    APIResponse<String> deleteSql(@PathVariable Long sqlId);

    @GetMapping("/sql/detail/{sqlId}")
    APIResponse<TaskSqlVo> getDetail(@PathVariable Long sqlId);

    @PostMapping("/sql/list")
    @ApiOperation("Sql-list")
    APIResponse<SearchResult<TaskSqlVo>> sqlList(@RequestBody TaskSqlVo taskSqlVo);

}
