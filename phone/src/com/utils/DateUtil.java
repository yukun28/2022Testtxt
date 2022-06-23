package com.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2019/7/19.
 */
public class DateUtil {
    public static Date stringToDate(String s,String patten){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(patten);
        try {
            return simpleDateFormat.parse(s);
        } catch (ParseException e) {
            return null;
        }
    }
}
