package com.DMS.ghb.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.DMS.ghb.dao.DocumentDao;
import com.DMS.ghb.entity.Documents;
import com.DMS.ghb.entity.Users;

public class DocumentDaoImpl extends HibernateDaoSupport implements DocumentDao {

	@Override
	public boolean saveDocument(Documents documents) {
		try {
			getHibernateTemplate().save(documents);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteDocument(Documents documents) {
		try {
			getHibernateTemplate().delete(documents);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Documents getDocumentsByName(String name) {
		try {
			String hql = "";
			getHibernateTemplate().find(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Documents getDocumentsById(String id) {
		try {
			Documents documents = getHibernateTemplate().get(Documents.class,
					id);
			return documents;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Documents> getDocumentsAll() {
		try {
			String hql = "from Documents where fileStatus ='9'";
			List<Documents> documents = (List<Documents>) getHibernateTemplate()
					.find(hql);
			if (documents != null && documents.size() > 0) {
				return documents;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Documents> getDocumentsByUser(Users users) {
		try {
			String hql = "from Documents where userId=?";
			List<Documents> documents = (List<Documents>) getHibernateTemplate()
					.find(hql, users.getUserId());
			if (documents != null && documents.size() > 0) {
				return documents;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
