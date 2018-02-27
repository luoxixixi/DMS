package com.DMS.ghb.service;

import java.util.List;

import com.DMS.ghb.entity.Teachers;

public interface TeacherService {
	public boolean saveTeachers(Teachers teachers);
	public Teachers getTeacherByPhone(String phone);
	public List<Teachers> getTeachers();
	public Teachers getTeacerById(String id);
	public boolean updataTeachers(Teachers teachers);
	public boolean deleteTeachers(Teachers teachers);
	
}
