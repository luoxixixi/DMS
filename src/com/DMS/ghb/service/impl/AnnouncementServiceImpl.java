package com.DMS.ghb.service.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.struts2.ServletActionContext;

import com.DMS.ghb.dao.AnnouncementDao;
import com.DMS.ghb.entity.Announcement;
import com.DMS.ghb.service.AnnouncementService;

public class AnnouncementServiceImpl implements AnnouncementService {
	private AnnouncementDao dao;

	public AnnouncementDao getDao() {
		return dao;
	}

	public void setDao(AnnouncementDao dao) {
		this.dao = dao;
	}

	@Override
	public boolean saveAnnouncement(Announcement announcements) {
		String annfileName = UUID.randomUUID().toString();
		String root = ServletActionContext.getServletContext().getRealPath(
				"/announcement");
		FileWriter fw = null;
		File f = new File(root+"/"+annfileName + ".txt");
		try {
			 if (!f.getParentFile().exists()) {  
	                f.getParentFile().mkdirs();  
	            }  
	        f.createNewFile();  
			fw = new FileWriter(f);
			BufferedWriter out = new BufferedWriter(fw);
			out.write(announcements.getBody(), 0, announcements.getBody()
					.length());
			out.close();
			announcements.setBody(annfileName + ".txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		boolean b = dao.saveAnn(announcements);
		return b;
	}

	@Override
	public List<Announcement> getAnnouncementByUser(String Userid) {
		List<Announcement> annByUser = dao.getAnnByUser(Userid);
		if (annByUser == null) {
			annByUser= new ArrayList<Announcement>();
		}
		return annByUser;
	}

	@Override
	public Announcement getAnnouncementById(String id) {

		Announcement annById = dao.getAnnById(id);
		try {
//			String encoding = "GBK";
			String root = ServletActionContext.getServletContext().getRealPath(
					"/announcement");
			File file = new File(root+"/"+annById.getBody());
			if (file.isFile() && file.exists()) { // 判断文件是否存在
				InputStreamReader read = new InputStreamReader(
						new FileInputStream(file));
				BufferedReader bufferedReader = new BufferedReader(read);
				StringBuffer buffer = new StringBuffer();
				String lineTxt = null;
				while ((lineTxt = bufferedReader.readLine()) != null) {
					buffer.append(lineTxt);
				}
				read.close();
				annById.setBody(buffer.toString());
				return annById;
			} else {
				System.out.println("找不到指定的文件");
			}
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
		}

		return null;
	
	}

	@Override
	public List<Announcement> getAnnouncement() {
		List<Announcement> annAll = dao.getAnnAll();
		if (annAll != null) {
			return annAll;
		}
		return null;
	}

	@Override
	public boolean deleteAnnouncement(String id) {
		String root = ServletActionContext.getServletContext().getRealPath(
				"/announcement");
		Announcement annById = dao.getAnnById(id);
		String path =root+"\\"+annById.getBody();
		File file = new File(path);
		boolean delete = file.delete();
		boolean deleteAnn = dao.deleteAnn(annById);
		return deleteAnn&&delete;
	}

}
