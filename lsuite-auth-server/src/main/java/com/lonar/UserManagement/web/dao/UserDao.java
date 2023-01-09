package com.lonar.UserManagement.web.dao;

import java.util.List;

import com.lonar.UserManagement.common.BusinessException;
import com.lonar.UserManagement.web.model.AuthTokenInfo;
import com.lonar.UserManagement.web.model.LtMastUsers;


public interface UserDao {

	LtMastUsers getUserById(Long id)  throws BusinessException;
	Long addNewUser(LtMastUsers user) throws BusinessException;
	Long removeUser(Long userId) throws BusinessException;
	List<LtMastUsers> getUserList() throws BusinessException;
	LtMastUsers findByUserName(String username) throws BusinessException;
	
	void saveLoginToken(AuthTokenInfo tokenInfo);
	AuthTokenInfo getTokenTimeDifferance(String accessToken) throws BusinessException;
	void updateLoginToken(AuthTokenInfo tokenInfo, String token) throws BusinessException;
	
	AuthTokenInfo getOldTokenTimeDifferance(String oldToken) throws BusinessException;
	List<LtMastUsers> findByUserNameAndEmailId(String userName, String emailId) throws BusinessException;
	boolean changePasswordUtility(Long userId, String password) throws BusinessException;
	void setPackageVariables(Long userId, Long companyId) throws BusinessException;
	
}
