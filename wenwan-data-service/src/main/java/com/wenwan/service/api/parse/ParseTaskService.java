package com.wenwan.service.api.parse;

public interface ParseTaskService {

    void parseTask(String parseRuleCode, Long fileId, Long parseRuleId);

    void fullParse(String param);

    void cnsjFullParse();
    void cwjzFullParse();
    void cwqrdFullParse();
    void cwyspFullParse();
    void dwbzjFullParse();
    void dzdFullParse();
}
