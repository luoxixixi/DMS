package com.DMS.ghb.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.DMS.ghb.dao.PapersDao;
import com.DMS.ghb.entity.Papers;

public class PapersDaoImpl extends HibernateDaoSupport implements PapersDao {

	@Override
	public boolean savePapers(Papers papers) {
		try {
			getHibernateTemplate().save(papers);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updataPapers(Papers papers) {
		try {
			getHibernateTemplate().update(papers);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deletePapers(Papers papers) {
		try {
			getHibernateTemplate().delete(papers);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Papers getPapersById(long id) {
		try {
			Papers papers = getHibernateTemplate().get(Papers.class, id);
			return papers;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Papers> getPapersAll() {
		try {
			String hql = "from Papers";
			List<Papers> papers = (List<Papers>) getHibernateTemplate().find(
					hql);
			if(papers!=null&&papers.size()>0){
				return papers;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Papers> getPapersByUSer(long stuId) {
		try {
			String hql="from Papers where stuId =?";
			List<Papers> papers = (List<Papers>) getHibernateTemplate().find(hql, stuId);
			if(papers!=null&&papers.size()>0){
				return papers;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
