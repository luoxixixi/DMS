package com.DMS.ghb.dao;

import java.util.List;

import com.DMS.ghb.entity.Documents;
import com.DMS.ghb.entity.Users;

public interface DocumentDao {
	public boolean saveDocument(Documents documents);
	public boolean deleteDocument(Documents documents);
	public boolean upataDocuments(Documents documents);
	public Documents getDocumentsByName(String name);
	public Documents getDocumentsById(String string);
	public List<Documents> getDocumentsAll();
	public List<Documents> getDocumentsByUser(Users users);
}
