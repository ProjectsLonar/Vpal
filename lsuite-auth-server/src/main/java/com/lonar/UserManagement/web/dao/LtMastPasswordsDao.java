package com.lonar.UserManagement.web.dao;

import java.util.List;

import com.lonar.UserManagement.web.model.LtMastPasswords;


public interface LtMastPasswordsDao {
public List<LtMastPasswords> findByUserId(Long userID) throws Exception;
public List<LtMastPasswords> findByUserIdAndPassword(Long userID,String password) throws Exception;
public List<LtMastPasswords>	findAllActive() throws Exception;
}
