package com.wenwan.service.api.parse;

import com.wenwan.common.api.SearchResult;
import com.wenwan.model.parse.ParseRuleTableVo;
import com.wenwan.model.parse.TaskGroupVo;
import com.wenwan.model.parse.TaskSqlVo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

public interface TaskService {
    int insertGroup(TaskGroupVo taskGroupVo);

    int updateGroup(TaskGroupVo taskGroupVo);

    int deleteGroup(@PathVariable Long groupId);

    SearchResult<TaskGroupVo> groupList(TaskGroupVo taskGroupVo);

    void insertSql(TaskSqlVo taskSqlVo);

    Long updateSql(TaskSqlVo taskSqlVo);

    int deleteSql(Long sqlId);

    TaskSqlVo getDetail(Long sqlId);

    SearchResult<TaskSqlVo> sqlList(@RequestBody TaskSqlVo taskSqlVo);

    Map<Long, List<ParseRuleTableVo>> getTableByParseRuleId(List<Long> parseRuleIds);
}
