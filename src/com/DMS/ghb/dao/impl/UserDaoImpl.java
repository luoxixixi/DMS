package com.DMS.ghb.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.DMS.ghb.dao.UserDao;
import com.DMS.ghb.entity.Users;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	@Override
	public boolean saveUser(Users users) {
		try {
			getHibernateTemplate().save(users);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean updataUsers(Users users) {
		try {
			getHibernateTemplate().update(users);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteUsers(Users users) {
		try {
			getHibernateTemplate().delete(users);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Users getUserById(long id) {
		try {
			Users users = getHibernateTemplate().get(Users.class, id);
			return users;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Users getUserByName(String name, String psw) {
		try {
			String hql ="from Users where userName=? and userPsw=?";
			List<Users> users = (List<Users>) getHibernateTemplate().find(hql, name,psw);
			if(users!=null&&users.size()>0){
				return users.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Users getUserByName(String name) {
		try {
			String hql ="from Users where userName=?";
			List<Users> users = (List<Users>) getHibernateTemplate().find(hql, name);
			if(users!=null&&users.size()>0){
				return users.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
