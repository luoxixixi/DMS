package com.DMS.ghb.util;  
  
public class fileSizeTest {  
    public static String getPrintSize(long size) {  
        //����ֽ�������1024����ֱ����BΪ��λ�������ȳ���1024����3λ��̫��������  
        if (size < 1024) {  
            return String.valueOf(size) + "B";  
        } else {  
            size = size / 1024;  
        }  
        //���ԭ�ֽ�������1024֮������1024�������ֱ����KB��Ϊ��λ  
        //��Ϊ��û�е���Ҫʹ����һ����λ��ʱ��  
        //����ȥ�Դ�����  
        if (size < 1024) {  
            return String.valueOf(size) + "KB";  
        } else {  
            size = size / 1024;  
        }  
        if (size < 1024) {  
            //��Ϊ�����MBΪ��λ�Ļ���Ҫ�������1λС����  
            //��ˣ��Ѵ�������100֮����ȡ��  
            size = size * 100;  
            return String.valueOf((size / 100)) + "."  
                    + String.valueOf((size % 100)) + "MB";  
        } else {  
            //�������Ҫ��GBΪ��λ�ģ��ȳ���1024����ͬ���Ĵ���  
            size = size * 100 / 1024;  
            return String.valueOf((size / 100)) + "."  
                    + String.valueOf((size % 100)) + "GB";  
        }  
    }  
} 