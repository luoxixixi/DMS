package com.DMS.ghb.service.impl;

import com.DMS.ghb.dao.UserDao;
import com.DMS.ghb.entity.Users;
import com.DMS.ghb.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao dao;

	@Override
	public boolean saveUser(Users users) {
		boolean saveUser = dao.saveUser(users);
		return saveUser;
	}

	@Override
	public boolean updataUsers(Users users) {
		boolean updataUsers = dao.updataUsers(users);
		return updataUsers;
	}

	@Override
	public boolean deleteUsers(Users users) {
		boolean deleteUsers = dao.deleteUsers(users);
		return deleteUsers;
	}

	@Override
	public Users getUserById(long id) {
		dao.getUserById(id);
		return null;
	}

	@Override
	public Users getUserByName(String name, String psw) {
		return dao.getUserByName(name, psw);
	}

	public UserDao getDao() {
		return dao;
	}

	public void setDao(UserDao dao) {
		this.dao = dao;
	}

	@Override
	public Users getUserByName(String name) {
		return dao.getUserByName(name);
	}

}
