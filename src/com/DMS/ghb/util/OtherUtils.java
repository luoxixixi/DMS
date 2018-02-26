package com.DMS.ghb.util;

public class OtherUtils {
	public static long getLong(String num) {
		if (num != null) {
			try {
				return Long.parseLong(num);
			} catch (Exception e) {
				return 0L;
			}
		}
		return 0L;
	}

}
