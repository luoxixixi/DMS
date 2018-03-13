package com.DMS.ghb.util;
//
import java.util.UUID;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.DMS.ghb.dao.impl.AnnouncementDaoImpl;
import com.DMS.ghb.dao.impl.StudentDaoImpl;
import com.DMS.ghb.dao.impl.TeacherDaoImpl;
import com.DMS.ghb.dao.impl.UserDaoImpl;
import com.DMS.ghb.entity.Teachers;
import com.DMS.ghb.entity.Users;
//
public class Test {
	public static void main(String[] args) {
//		 ApplicationContext factory = new ClassPathXmlApplicationContext(
//		 "applicationContext.xml");
//		 
//		StudentDaoImpl dao =(StudentDaoImpl) factory.getBean("studentDaoImpl");
//		TeacherDaoImpl dao1 =(TeacherDaoImpl) factory.getBean("teacherDaoImpl");
//		UserDaoImpl dao2 =(UserDaoImpl) factory.getBean("userDaoImpl");
//		AnnouncementDaoImpl dao3 =(AnnouncementDaoImpl) factory.getBean("announcementDaoImpl");
//		DocumentDaoImpl dao6 =(DocumentDaoImpl) factory.getBean("documentDaoImpl");
//		PapersDaoImpl dao8 =(PapersDaoImpl) factory.getBean("papersDaoImpl");
//		Users users = new Users();
//		users.setUserId(UUID.randomUUID().toString());
//		users.setUserName("111");
//		users.setType("3");
//		users.setUserPsw("1");
//		dao2.saveUser(users);
//		Students students = new Students();
//		students.setName("ssssssssssssss");
//		students.setStuNum(123456789);
//		students.setYears("2017");
//		Teachers teachers = new Teachers();
//		teachers.setName("111");
//		teachers.setPhone("@zhuren");
//		dao1.saveTeacher(teachers);
//		students.setTeachers(teachers);
//		dao.saveStu(students);
		String i = "学生文件\\信工学院\\信息工程\\5";
		String[] split = i.split("\\\\");
		System.out.println(split.length);
		for (String string : split) {
			System.out.println(string);
		}
//        Students studentsByNum = dao.getStudentsByNum(123456789);
//        System.out.println(studentsByNum.getTeachers().getName());
	}

}
