package com.wenwan.api.parse;

import com.wenwan.common.api.APIResponse;
import com.wenwan.model.parse.TableInfoVo;
import com.wenwan.model.parse.TaskGroupVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/parse/task")
public interface ITaskApi {
    @PutMapping("/group/insert")
    @ApiOperation("新增任务组")
    APIResponse<Void> insertGroup(@RequestBody TaskGroupVo taskGroupVo);

    @PostMapping("/group/update")
    @ApiOperation("修改任务组")
    APIResponse<Void> updateGroup(@RequestBody TaskGroupVo taskGroupVo);

    @DeleteMapping("/group/delete/{groupId}")
    @ApiOperation("删除任务组")
    APIResponse<Void> deleteGroup(@PathVariable Long groupId);

    @PostMapping("/group/query")
    @ApiOperation("任务组list")
    APIResponse<List<TaskGroupVo>> queryTable(@RequestBody TaskGroupVo taskGroupVo);

}
