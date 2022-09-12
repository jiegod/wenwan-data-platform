package com.wenwan.service.api.result;

import com.wenwan.common.api.APIResponse;
import com.wenwan.common.api.SearchResult;
import com.wenwan.model.result.LogVo;
import com.wenwan.model.result.SqlLogVo;

public interface LogService {
   SearchResult<LogVo> list(LogVo logVo);


   SearchResult<SqlLogVo> sqlLogList(SqlLogVo sqlLogVo);
}
