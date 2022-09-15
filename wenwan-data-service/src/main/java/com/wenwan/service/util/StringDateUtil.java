package com.wenwan.service.util;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Date;
import java.util.TimeZone;

public class StringDateUtil {

    public static String formatDate(Date date, String pattern){
        return DateFormatUtils.format(date, pattern, TimeZone.getTimeZone("GMT+8"));
    }

    public static Integer getToday(){
        return Integer.parseInt(formatDate(new Date(), "yyyyMMdd"));
    }
}
