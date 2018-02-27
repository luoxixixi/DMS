package com.DMS.ghb.util;

import java.io.File;

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
	public static void main(String[] args) {
		File file = new File("E:\\JEEworkspace\\HBNUDMS\\WebContent\\upload\\03c0446e-b85e-4552-8a11-e6b36f00b27c---a.xlsx");
		boolean delete = file.delete();
		System.out.println(delete);
	}

}
