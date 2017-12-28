package com.cg.blog.util;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 日期工具类
 * @author root1
 * @date 2017年12月25日
 */
public class DateUtil {
	
	/**
	 * 日期对象转字符串
	 * @param date
	 * @param format
	 * @return
	 */
	public static String formatDate(Date date,String format){
        String result="";
        SimpleDateFormat sdf=new SimpleDateFormat(format);
        if(date!=null){
            result=sdf.format(date);
        }
        return result;
    }
	/**
	 * 按照yyyy-MM-dd hh:mm:ss 获取当前日期
	 * @return
	 */
	 public static String getCurrentDateStr() {
	        Date date=new Date();
	        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	        return sdf.format(date);
	 }
}
