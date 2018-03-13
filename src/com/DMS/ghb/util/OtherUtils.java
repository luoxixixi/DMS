package com.DMS.ghb.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class OtherUtils {
	public static final String[] IMG={"JPG","JPEG","GIF","PNG","BMP"};
	
	
	
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
	
	public static boolean equalsImg(String name){
		for (String string : IMG) {
			if(name.equals(string)){
				return true;
			}
		}
		return false;
	}
	public static String getUrlStr(String path) throws UnsupportedEncodingException{
		String[] split = path.split("\\\\");
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < split.length; i++) {
			String s=new String(split[i].getBytes("UTF-8"),"ISO8859-1");
			builder.append("/").append(s);
		}
		return builder.toString();
	}
	
    public static void  copyFile(FileInputStream ins,File toFile) throws IOException{
        FileOutputStream out = new FileOutputStream(toFile);
        byte[] b = new byte[1024];
        int n=0;
        while((n=ins.read(b))!=-1){
            out.write(b, 0, n);
        }
        
        ins.close();
        out.close();
    }
}
