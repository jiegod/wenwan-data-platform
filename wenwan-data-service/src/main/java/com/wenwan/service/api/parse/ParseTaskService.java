package com.wenwan.service.api.parse;

import com.wenwan.mysql.dao.entity.BusinessLog;

public interface ParseTaskService {
    void incrParse();
    void fullParse(String fileType);

    void parseTask(BusinessLog businessLog);
}
