package com.DMS.ghb.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
	/**
	 * ��õ�ǰʱ��
	 * @return yyyy/MM/dd HH:mm
	 */
	public static String timeNow(){
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		String timeNow = format.format(date);
		return timeNow;
	}
	/**
	 * ��ý�������
	 */
	public static String simpleTimeNow(){
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		String timeNow = format.format(date);
		return timeNow;
	}
}
