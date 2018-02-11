package com.DMS.ghb.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
	/**
	 * 或得当前时间
	 * @return yyyy/MM/dd HH:mm
	 */
	public static String timeNow(){
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		String timeNow = format.format(date);
		return timeNow;
	}
	/**
	 * 获得今日日期
	 */
	public static String simpleTimeNow(){
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		String timeNow = format.format(date);
		return timeNow;
	}
}
