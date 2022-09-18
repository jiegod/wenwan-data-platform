package com.wenwan.service.api.parse;

import com.wenwan.model.enums.Datasource;

public interface EmailParseService {

    void incrParse();

    void fullParse(Datasource dataSource, String labels);

}
