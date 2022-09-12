package com.wenwan.service.api.parse;

import com.wenwan.common.api.SearchResult;
import com.wenwan.model.parse.TaskGroupVo;
import com.wenwan.model.parse.TaskSqlVo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface TaskService {
    int insertGroup(TaskGroupVo taskGroupVo);

    int updateGroup(TaskGroupVo taskGroupVo);

    int deleteGroup(@PathVariable Long groupId);

    SearchResult<TaskGroupVo> groupList(TaskGroupVo taskGroupVo);

    void insertSql(TaskSqlVo taskSqlVo);

    int updateSql(TaskSqlVo taskSqlVo);

    int deleteSql(Long sqlId);

    SearchResult<TaskSqlVo> sqlList(@RequestBody TaskSqlVo taskSqlVo);
}
