package com.wenwan.service.api.common;

import com.wenwan.mysql.dao.entity.BusinessLog;

public interface FileTableService {
    boolean accept(String fileName);

    void toTable(BusinessLog businessLog);
}
