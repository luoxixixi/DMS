package com.DMS.ghb.service;

import java.io.File;
import java.util.List;

import com.DMS.ghb.entity.Documents;

public interface DocumentService {
	public boolean saveDocuments(Documents documents,File file);
	public boolean saveDoc(Documents documents);
	public boolean upataDocuments(Documents documents);
	public List<Documents> getDocumentsByUser(String Userid);
	public Documents getDocumentsById(String id);
	public List<Documents> getDocuments();
	public boolean deleteDocuments(Documents documents);
	public List<Documents> getByName(Documents documents);
	public List<Documents> getHisDoc();
}
