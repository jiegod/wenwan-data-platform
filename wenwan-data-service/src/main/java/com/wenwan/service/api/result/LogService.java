package com.wenwan.service.api.result;

import com.wenwan.common.api.SearchResult;
import com.wenwan.model.result.LogVo;
import com.wenwan.model.result.SqlLogVo;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;

public interface LogService {
   SearchResult<LogVo> list(LogVo logVo);


   SearchResult<SqlLogVo> sqlLogList(SqlLogVo sqlLogVo);

    void reParse(String businessLog, Long businessLogId);

    String resultTable(String businessLog, Long fileId);

    ResponseEntity<Resource> downloadFile(String businessLog, Long businessLogId);
}
