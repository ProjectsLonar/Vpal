package com.lonar.UserManagement.web.service;

import java.util.List;

import com.lonar.UserManagement.web.model.LtMastPasswords;

public interface LtMastPasswordsService {

	public List<LtMastPasswords> findByUserId(Long userID) throws Exception;

	public List<LtMastPasswords> findByUserIdAndPassword(Long userID, String password) throws Exception;

	public List<LtMastPasswords> findAllActive() throws Exception;
}
