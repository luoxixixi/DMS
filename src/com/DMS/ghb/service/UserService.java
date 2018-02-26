package com.DMS.ghb.service;

import com.DMS.ghb.entity.Users;

public interface UserService {
	public boolean saveUser(Users users);

	public boolean updataUsers(Users users);

	public boolean deleteUsers(Users users);

	public Users getUserById(long id);

	public Users getUserByName(String name, String psw);

	public Users getUserByName(String name);
}
