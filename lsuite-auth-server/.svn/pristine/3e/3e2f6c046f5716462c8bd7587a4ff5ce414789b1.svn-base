package com.lonar.UserManagement.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lonar.UserManagement.web.dao.UserDao;
import com.lonar.UserManagement.web.model.LtMastUsers;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Override
	public LtMastUsers getUserById(Long id) {
		return userDao.getUserById(id);
	}

	@Override
	public Long addNewUser(LtMastUsers user) {
		return userDao.addNewUser(user);
	}

	@Override
	public Long removeUser(Long userId) {
		return userDao.removeUser(userId);
	}

	@Override
	public List<LtMastUsers> getUserList() {
		return userDao.getUserList();
	}

	@Override
	public LtMastUsers findByUserName(String username) {
		return userDao.findByUserName(username);
	}

	
}
