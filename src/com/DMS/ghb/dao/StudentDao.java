package com.DMS.ghb.dao;

import com.DMS.ghb.entity.Students;

public interface StudentDao {
	public boolean saveStu(Students students);
	public boolean updataStu(Students students);
	public boolean deleteStu(Students students);
	public Students getStudentsByNum(long num);
    
}
