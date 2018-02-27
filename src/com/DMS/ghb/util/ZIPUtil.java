package com.DMS.ghb.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import com.DMS.ghb.entity.Documents;

public class ZIPUtil {
	public static void creatZIP(List<Documents> documents,String realPath) {
		ZipOutputStream out = null;
		try {

			FileOutputStream a = new FileOutputStream("ep10_13.zip");
			// ����ѹ���ļ�
			out = new ZipOutputStream(new BufferedOutputStream(a));
			for (int i = 0; i < documents.size(); i++) { // �������������ÿ���ļ����д���
				System.out.println("Writing file" + documents.get(i).getFileName());
				BufferedInputStream in = new BufferedInputStream(
						new FileInputStream(realPath + "\\" + documents.get(i)
								.getFileContentType()));
				out.putNextEntry(new ZipEntry(documents.get(i)
						.getFileContentType())); // ���� ZipEntry ����
				int b;
				while ((b = in.read()) != -1)
					out.write(b); // ��Դ�ļ���������ѹ���ļ���д��
				in.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
