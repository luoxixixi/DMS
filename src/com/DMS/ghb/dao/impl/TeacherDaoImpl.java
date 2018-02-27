package com.DMS.ghb.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.DMS.ghb.dao.TeacherDao;
import com.DMS.ghb.entity.Students;
import com.DMS.ghb.entity.Teachers;

public class TeacherDaoImpl extends HibernateDaoSupport implements TeacherDao {

	@Override
	public boolean saveTeacher(Teachers teachers) {
		try {
			getHibernateTemplate().save(teachers);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updataTeacher(Teachers teachers) {
		try {
			getHibernateTemplate().update(teachers);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteTeacher(Teachers teachers) {
		try {
			getHibernateTemplate().delete(teachers);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Teachers getTeacerByPhone(String phone) {
		try {
			String hql = "from Teachers where phone=?";
			List<Teachers> teachers = (List<Teachers>) getHibernateTemplate()
					.find(hql, phone);
			if (teachers != null && teachers.size() > 0) {
				return teachers.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Teachers getTeachersByStu(Students students) {
		try {
			Teachers teachers = getHibernateTemplate().get(Teachers.class,
					students.getTeachers().getTeaId());
			return teachers;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Teachers> getTeacher() {
		try {
			String hql = "from Teachers";
			List<Teachers> teachers = (List<Teachers>) getHibernateTemplate()
					.find(hql);
			if (teachers != null && teachers.size() > 0) {
				return teachers;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Teachers getTeacerById(String id) {
		try {
			Teachers teachers = getHibernateTemplate().get(Teachers.class, id);
			return teachers;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
