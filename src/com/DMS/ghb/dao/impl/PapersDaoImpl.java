package com.DMS.ghb.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.DMS.ghb.dao.PapersDao;
import com.DMS.ghb.entity.Company;
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
			return true;
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
	public Papers getPapersById(String id) {
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
			if (papers != null && papers.size() > 0) {
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
			String hql = "from Papers where stuId =?";
			List<Papers> papers = (List<Papers>) getHibernateTemplate().find(
					hql, stuId);
			if (papers != null && papers.size() > 0) {
				return papers;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Papers getStuPaper(String stuId, String mId) {
		try {
			String SQL = "select p.papersId "
					+ "from Papers p,Students s, Mission m "
					+ "where s.stuId=? and m.id=? "
					+ "and p.students.stuId=s.stuId "
					+ "and p.mission.id=m.id";
			List<String> id = (List<String>) getHibernateTemplate().find(SQL,
					stuId, mId);
			if (id != null && id.size() > 0) {
				return getPapersById(id.get(0));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
