package com.DMS.ghb.service.impl;

import java.util.List;

import com.DMS.ghb.dao.StudentDao;
import com.DMS.ghb.entity.Students;
import com.DMS.ghb.service.StudentService;

public class StudentServiceImpl implements StudentService{
	private StudentDao dao;

	public StudentDao getDao() {
		return dao;
	}

	public void setDao(StudentDao dao) {
		this.dao = dao;
	}

	@Override
	public Students getStudentByNum(long num) {
		return dao.getStudentsByNum(num);
	}

	@Override
	public boolean saveStudent(Students students) {
		boolean saveStu = dao.saveStu(students);
		return saveStu;
	}

	@Override
	public boolean updataStudents(Students students) {
		boolean updataStu = dao.updataStu(students);
		return updataStu;
	}

	@Override
	public boolean deleteStudents(Students students) {
		boolean deleteStu = dao.deleteStu(students);
		return deleteStu;
	}

	@Override
	public List<Students> getAllStu() {
		return dao.getAllStu();
	}

	@Override
	public Students getStuById(String id) {
		return dao.getStuById(id);
	}

}
