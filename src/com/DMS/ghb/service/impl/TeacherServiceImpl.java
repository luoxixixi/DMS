package com.DMS.ghb.service.impl;

import java.util.List;

import com.DMS.ghb.dao.TeacherDao;
import com.DMS.ghb.entity.Teachers;
import com.DMS.ghb.service.TeacherService;

public class TeacherServiceImpl implements TeacherService {
	private TeacherDao dao;

	public TeacherDao getDao() {
		return dao;
	}

	public void setDao(TeacherDao dao) {
		this.dao = dao;
	}

	@Override
	public Teachers getTeacherByPhone(String phone) {
		return dao.getTeacerByPhone(phone);
	}

	@Override
	public boolean saveTeachers(Teachers teachers) {
		boolean saveTeacher = dao.saveTeacher(teachers);
		return saveTeacher;
	}

	@Override
	public List<Teachers> getTeachers() {
		List<Teachers> teacher = dao.getTeacher();
		if (teacher != null) {
			return teacher;
		}
		return null;
	}

	@Override
	public boolean updataTeachers(Teachers teachers) {
		boolean updataTeacher = dao.updataTeacher(teachers);
		return updataTeacher;
	}

	@Override
	public boolean deleteTeachers(Teachers teachers) {
		boolean deleteTeacher = dao.deleteTeacher(teachers);
		return deleteTeacher;
	}
}
