package com.lonar.UserManagement.web.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.parser.ParseException;

import com.lonar.UserManagement.common.ServiceException;
import com.lonar.UserManagement.web.model.AuthTokenInfo;
import com.lonar.UserManagement.web.model.LtMastUsers;
import com.lonar.UserManagement.web.model.ResponceEntity;
import com.lonar.UserManagement.web.model.Status;

public interface LoginService {

	ResponceEntity loginUser(LtMastUsers user,  HttpServletResponse response) ;
	ResponceEntity logoutUser (HttpServletRequest request, HttpServletResponse response);
	String tokenExtend(String token);
	
	AuthTokenInfo getTokenTimeDifferance(String token);
	Status changePassword(String jsonInputString) throws ParseException;
	Status emailValidater(String id);
	Status resetPassword(String jsonInputString);
	Status changePasswordUtility(String jsonInputString) throws ServiceException;
	
}
