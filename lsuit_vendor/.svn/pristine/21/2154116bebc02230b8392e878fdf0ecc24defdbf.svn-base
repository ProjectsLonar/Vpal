package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import com.lonar.vendor.vendorportal.model.BusinessException;
import com.lonar.vendor.vendorportal.model.LtMastUsers;
import com.lonar.vendor.vendorportal.security.AuthTokenInfo;


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
	
}
