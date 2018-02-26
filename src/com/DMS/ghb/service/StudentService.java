package com.DMS.ghb.service;

import java.util.List;

import com.DMS.ghb.entity.Students;

public interface StudentService {
	public Students getStudentByNum(long num);

	public boolean saveStudent(Students students);

	public boolean updataStudents(Students students);

	public boolean deleteStudents(Students students);
	
	public List<Students> getAllStu();
	
	public Students getStuById(String id);
}
