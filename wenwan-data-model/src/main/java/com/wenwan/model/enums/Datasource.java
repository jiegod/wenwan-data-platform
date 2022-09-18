package com.wenwan.model.enums;

import com.wenwan.model.StaticLabel;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Datasource {
    MAIL("MAIL", "MAIL项目邮箱"),
    SZT("SZT", "深圳通");

    private String code;
    private String label;

    Datasource(String code, String label){
        this.code = code;
        this.label = label;
    }

    public static List<StaticLabel> getDatasourceLabel(){
        return Arrays.stream(Datasource.values()).map(aa ->new StaticLabel(aa.code, aa.label)).collect(Collectors.toList());
    }

    public String getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }
}
