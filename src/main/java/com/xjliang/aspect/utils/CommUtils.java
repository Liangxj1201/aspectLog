package com.xjliang.aspect.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CommUtils {

    public static final String format = "yyyy-MM-dd HH:mm:ss";

    public static String getTimeStr() {
        Calendar cal = Calendar.getInstance();
        return new SimpleDateFormat(format).format(cal.getTime());
    }
}
