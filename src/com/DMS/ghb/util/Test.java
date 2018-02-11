package com.DMS.ghb.util;
//
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.DMS.ghb.dao.impl.AnnouncementDaoImpl;
import com.DMS.ghb.dao.impl.StudentDaoImpl;
import com.DMS.ghb.dao.impl.TeacherDaoImpl;
import com.DMS.ghb.entity.Students;
import com.DMS.ghb.entity.Teachers;
//
public class Test {
	public static void main(String[] args) {
		 ApplicationContext factory = new ClassPathXmlApplicationContext(
		 "applicationContext.xml");
		 
		StudentDaoImpl dao =(StudentDaoImpl) factory.getBean("studentDaoImpl");
		TeacherDaoImpl dao1 =(TeacherDaoImpl) factory.getBean("teacherDaoImpl");
//		UserDaoImpl dao2 =(UserDaoImpl) factory.getBean("userDaoImpl");
		AnnouncementDaoImpl dao3 =(AnnouncementDaoImpl) factory.getBean("announcementDaoImpl");
//		DocumentDaoImpl dao6 =(DocumentDaoImpl) factory.getBean("documentDaoImpl");
//		PapersDaoImpl dao8 =(PapersDaoImpl) factory.getBean("papersDaoImpl");
//		Users users = new Users();
//		users.setUserId(1L);
//		users.setUserName("111111");
//		users.setType("1");
//		users.setUserPsw("sss");
//		Students students = new Students();
//		students.setName("ssssssssssssss");
//		students.setStuNum(123456789);
//		students.setYears("2017");
		Teachers teachers = new Teachers();
		teachers.setName("ssssss");
		teachers.setPhone("13888888888");
		dao1.saveTeacher(teachers);
//		students.setTeachers(teachers);
//		dao.saveStu(students);
		
//        Students studentsByNum = dao.getStudentsByNum(123456789);
//        System.out.println(studentsByNum.getTeachers().getName());
	}

}
