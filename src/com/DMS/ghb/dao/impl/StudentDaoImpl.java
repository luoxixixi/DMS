package com.DMS.ghb.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.DMS.ghb.dao.StudentDao;
import com.DMS.ghb.entity.Students;

public class StudentDaoImpl extends HibernateDaoSupport implements StudentDao {

	@Override
	public boolean saveStu(Students students) {
		try {
			getHibernateTemplate().save(students);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updataStu(Students students) {
		try {
			getHibernateTemplate().update(students);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteStu(Students students) {
		try {
			getHibernateTemplate().delete(students);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Students getStudentsByNum(long num) {
		try {
			String hql = "from Students where stuNum=?";
			List<Students> students = (List<Students>) getHibernateTemplate()
					.find(hql, num);
			if (students != null && students.size() > 0) {
				return students.get(0);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Students> getAllStu() {
		try {
			String hql = "from Students";
			List<Students> students = (List<Students>) getHibernateTemplate()
					.find(hql);
			return students;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Students getStuById(String id) {
		try {
			Students students = getHibernateTemplate().get(Students.class, id);
			return students;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
