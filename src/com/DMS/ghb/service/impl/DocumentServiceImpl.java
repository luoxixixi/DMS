package com.DMS.ghb.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.struts2.ServletActionContext;

import com.DMS.ghb.dao.DocumentDao;
import com.DMS.ghb.entity.Documents;
import com.DMS.ghb.entity.Users;
import com.DMS.ghb.service.DocumentService;
import com.DMS.ghb.util.TimeUtil;

public class DocumentServiceImpl implements DocumentService {
	private DocumentDao dao;

	public DocumentDao getDao() {
		return dao;
	}

	public void setDao(DocumentDao dao) {
		this.dao = dao;
	}

	@Override
	public List<Documents> getDocumentsByUser(String Userid) {
		Users users = new Users();
		users.setUserId(Userid);
		List<Documents> documentsByUser = dao.getDocumentsByUser(users);
		return documentsByUser;
	}

	@Override
	public Documents getDocumentsById(Documents id) {
		Documents documentsById = dao.getDocumentsById(id.getDocId());
		return documentsById;
	}

	@Override
	public List<Documents> getDocuments() {
		List<Documents> documentsAll = dao.getDocumentsAll();
		if (documentsAll != null) {
			return documentsAll;
		}
		return null;
	}

	@Override
	public boolean deleteDocuments(Documents documents) {
		dao.deleteDocument(documents);
		return false;
	}

	@Override
	public boolean saveDocuments(Documents files, File file) {

		OutputStream os = null;
		InputStream is = null;
		FileChannel fc = null;
		if (!file.exists()) {
			file.mkdirs();
		}
		String uuid = UUID.randomUUID().toString() + "---";
		System.out.println("fileFileName: " + files.getFileName());
		System.out.println(files.getFileContentType());
		String root = ServletActionContext.getServletContext().getRealPath(
				"/upload");
		try {
			is = new FileInputStream(file);
			File fileTem = new File(root, uuid + files.getFileName());
			if (!fileTem.getParentFile().exists()) {
				fileTem.getParentFile().mkdirs();
			}
			os = new FileOutputStream(fileTem);
			byte[] buffer = new byte[1024];
			while (-1 != (is.read(buffer, 0, buffer.length))) {
				os.write(buffer);
			}
			files.setFileType(files.getFileContentType());
			files.setFileContentType(uuid + files.getFileName());
			files.setUpTime(TimeUtil.timeNow());
			files.setFileSize(file.length() + "");
			return dao.saveDocument(files);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				os.close();
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return false;

	}

	@Override
	public List<Documents> getByName(Documents documents) {
		Documents documentsByName = dao.getDocumentsByName(documents
				.getFileName());
		List<Documents> list = new ArrayList<Documents>();
		list.add(documentsByName);
		return list;
	}
}
