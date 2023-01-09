package com.lonar.UserManagement.web.service;

import java.util.List;

import com.lonar.UserManagement.web.model.LtMastUsers;

public interface UserService {

	LtMastUsers getUserById(Long id);
	Long addNewUser(LtMastUsers user);
	Long removeUser(Long userId) ;
	List<LtMastUsers> getUserList();
	LtMastUsers findByUserName(String username);
	
}
