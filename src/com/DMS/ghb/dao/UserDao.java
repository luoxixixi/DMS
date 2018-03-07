package com.DMS.ghb.dao;

import com.DMS.ghb.entity.Users;

public interface UserDao {
	public boolean saveUser(Users users);
	public boolean updataUsers(Users users);
	public boolean deleteUsers(Users users);
	public Users getUserById(String id);
	public Users getUserByName(String name,String psw);
	public Users getUserByName(String name);
}
