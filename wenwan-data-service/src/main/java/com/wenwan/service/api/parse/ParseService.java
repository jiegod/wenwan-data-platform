package com.wenwan.service.api.parse;

import com.wenwan.model.enums.Datasource;

public interface ParseService {

    void incrParse();

    void fullParse(Datasource dataSource, String labels);
}
