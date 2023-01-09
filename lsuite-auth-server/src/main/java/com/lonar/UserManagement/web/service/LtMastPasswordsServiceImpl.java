package com.lonar.UserManagement.web.service;

import java.util.List;

import javax.jdo.annotations.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lonar.UserManagement.web.dao.LtMastPasswordsDao;
import com.lonar.UserManagement.web.model.LtMastPasswords;

@Service
public class LtMastPasswordsServiceImpl implements LtMastPasswordsService {
	@Autowired
	LtMastPasswordsDao ltMastPasswordsDao;

	@Transactional
	@Override
	public List<LtMastPasswords> findByUserId(Long userID) throws Exception{
		// TODO Auto-generated method stub
		return ltMastPasswordsDao.findByUserId(userID);
	}

	@Transactional
	@Override
	public List<LtMastPasswords> findByUserIdAndPassword(Long userID, String password) throws Exception{
		// TODO Auto-generated method stub
		return ltMastPasswordsDao.findByUserIdAndPassword(userID, password);
	}

	@Transactional
	@Override
	public List<LtMastPasswords> findAllActive() throws Exception{
		// TODO Auto-generated method stub
		return ltMastPasswordsDao.findAllActive();
	}

}
