package com.DMS.ghb.dao;

import java.util.List;

import com.DMS.ghb.entity.Students;
import com.DMS.ghb.entity.Teachers;

public interface TeacherDao {
	public boolean saveTeacher(Teachers teachers);
	public boolean updataTeacher(Teachers teachers);
	public boolean deleteTeacher(Teachers teachers);
	public List<Teachers> getTeacher();
	public Teachers getTeacerByPhone(String phone);
	public Teachers getTeachersByStu(Students students);
}
