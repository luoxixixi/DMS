package com.DMS.ghb.util;

import java.text.ParseException;
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
	/**
	 * 获得今日日期
	 * yyyyMMddHHmm
	 */
	public static String getTimeNow(){
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmm");
		String timeNow = format.format(date);
		return timeNow;
	}
	/**
	 * 字符串转成日期
	 * @param time
	 * @return
	 */
	public static long getLongTime(String time){
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		try {
			Date parse = format.parse(time);
			return parse.getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
