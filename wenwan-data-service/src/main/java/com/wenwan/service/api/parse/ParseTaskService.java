package com.wenwan.service.api.parse;

public interface ParseTaskService {
    void incrParse();

    void parseTask(String parseRuleCode, Long fileId, Long parseRuleId);

    void cnsjFullParse();
    void cwjzFullParse();
    void cwqrdFullParse();
    void cwyspFullParse();
    void dwbzjFullParse();
    void dzdFullParse();
}
