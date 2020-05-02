package com.thankson.common.util.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期时间相关工具
 * @author Thankson
 * @date 2020年2月19日
 */
public class DateUtils {

	public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	
	/**
	 * 获取当前标准格式化日期时间
	 * @return
	 */
	public static String getDateTime() {
		return getDateTime(new Date());
	}
	
	/**
	 * 标准格式化日期时间
	 * @param date
	 * @return
	 */
	public static String getDateTime(Date date) {
		return (new SimpleDateFormat(DATE_FORMAT)).format(date);
	}
}
