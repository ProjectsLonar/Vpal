package com.lonar.UserManagement.web.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lonar.UserManagement.common.CommonMethod;
import com.lonar.UserManagement.common.ServiceException;
import com.lonar.UserManagement.web.dao.UserDao;
import com.lonar.UserManagement.web.model.CodeMaster;
import com.lonar.UserManagement.web.model.LtMastPasswords;
import com.lonar.UserManagement.web.model.LtMastUsers;
import com.lonar.UserManagement.web.model.ResponceEntity;
import com.lonar.UserManagement.web.model.Status;
import com.lonar.UserManagement.web.repository.LtMastPasswordsRepository;
import com.lonar.UserManagement.web.repository.LtMastUsersRepository;
import com.lonar.UserManagement.web.service.LoginService;
import com.lonar.UserManagement.web.service.LtMastCommonMessageService;
import com.lonar.UserManagement.web.service.LtMastPasswordsService;

@RestController
@RequestMapping(value="/oauth", produces = MediaType.APPLICATION_JSON_VALUE )
public class LoginController implements CodeMaster{

	@Autowired
	UserDao userDao;
	
	 @Autowired
	 private LoginService loginService ;
		
	 @Autowired
	 LtMastPasswordsRepository ltMastPasswordsRepository;
	 
	 @Autowired
	 LtMastCommonMessageService ltMastCommonMessageService;
	 
	 @Autowired
	 LtMastUsersRepository ltMastUsersRepository;
	 
	 @Autowired
	 LtMastPasswordsService ltMastPasswordsService;
	/*
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public ResponceEntity logoutUser (HttpServletRequest request, HttpServletResponse response) {
		return loginService.logoutUser(request, response);
		
		@RequestMapping(method = RequestMethod.POST, value = "/tokens/revokeRefreshToken/{tokenId:.*}")
		@ResponseBody
		public String revokeRefreshToken(@PathVariable String tokenId) {
		    if (tokenStore instanceof JdbcTokenStore){
		        ((JdbcTokenStore) tokenStore).removeRefreshToken(tokenId);
		    }
		    return tokenId;
		}
	}*/
	
	@RequestMapping(value="/tokenextend/{logTime}", method = RequestMethod.GET)
	public String tokenExtend(@RequestParam("token") String token,@PathVariable("logTime") String logTime) {
		return loginService.tokenExtend(token);
	}
	
	
	@RequestMapping(value="/dologin", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE )
	@ResponseBody
	public ResponceEntity loginUser(@RequestBody LtMastUsers user,  HttpServletResponse response) throws ServiceException {
		
		return loginService.loginUser(user, response);
	}
	

	@RequestMapping(value="/tokenexpired/{logTime}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE )
	public ResponceEntity handleInvalidTokan(@PathVariable("logTime") String logTime) {
		ResponceEntity entity = new ResponceEntity();
		entity.setCode(501);
		entity.setMessage("Tokan Expired");
		return entity;
	}
	
	@RequestMapping(value="/mytokendetails/{logTime}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE )
	public ResponceEntity getTokenTimeDifferance(@RequestParam("token") String token,@PathVariable("logTime") String logTime) {
		ResponceEntity entity = new ResponceEntity();
		entity.setData(loginService.getTokenTimeDifferance(token));
		entity.setCode(200);
		entity.setMessage("OK");
		return entity ;
	}
	
	@RequestMapping(value = "/changePassword", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> changePassword(@RequestBody String jsonInputString) throws ParseException
	{
		Status status = new Status();
		status =loginService.changePassword(jsonInputString);
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/changePasswordByReset", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> changePasswordByReset(@RequestBody String jsonInputString) {
		JSONParser parser = new JSONParser();
		JSONObject newJObject = null;
		Status status = new Status();
		LtMastUsers ltMastUsers = new LtMastUsers();
		try {
			if (jsonInputString.length() == 0) {
				status.setCode(INPUT_IS_EMPTY);
				status.setMessage("Please fill all mandatory fields.");
			
				new ResponseEntity<Status>(status, HttpStatus.OK);
			}
			newJObject = (JSONObject) parser.parse(jsonInputString);

			
			if (ltMastUsersRepository.exists(Long.parseLong(newJObject.get("userid").toString()))) {
				ltMastUsers = ltMastUsersRepository.findOne(Long.parseLong(newJObject.get("userid").toString()));
			} else {
				status.setCode(NO_RESULT);
				status.setMessage("login.NO_RESULT");
				
				return new ResponseEntity<Status>(status, HttpStatus.OK);
				
			}

			List<LtMastPasswords> ltMastPasswordsList = ltMastPasswordsService.findByUserId(ltMastUsers.getUserId());
			for (LtMastPasswords ltMastPasswords : ltMastPasswordsList) {
				
				if (ltMastPasswords.getPassword().equals(newJObject.get("changepassword").toString())) {

					status.setCode(PASS_USED_PREV);
					status.setMessage("Password is already used.");
					
					return new ResponseEntity<Status>(status, HttpStatus.OK);
					
				}
			}

			ltMastUsers.setPassword(newJObject.get("changepassword").toString());
			ltMastUsers.setChangePwd("Y");
			
			ltMastUsers.setPasswordDate(new CommonMethod().convertStringtoSqlDate(new CommonMethod().getTodayDate()));
			ltMastUsers.setLastUpdateLogin(Long.parseLong(newJObject.get("userid").toString()));
			ltMastUsers.setLastUpdatedBy(Long.parseLong(newJObject.get("userid").toString()));
			ltMastUsers.setLastUpdateDate(
					new CommonMethod().convertStringtoSqlDateTime(new CommonMethod().getTodayDate()));
		
			
			LtMastUsers ltMastUsers1 =  ltMastUsersRepository.findOne(Long.parseLong(newJObject.get("userid").toString()));
			if(ltMastUsers1!=null) {
			 if(!ltMastUsers1.getStatus().toUpperCase().equals("ACTIVE") ){
				ltMastUsers.setStatus("ACTIVE");
			}
			}
			
			
			if( ltMastUsersRepository.save(ltMastUsers)!=null)
			{
			
				if (ltMastPasswordsList.size() >= 5 && !ltMastPasswordsList.isEmpty())
					ltMastPasswordsRepository.delete(ltMastPasswordsList.get(0).getPasswordid());

				LtMastPasswords ltMastPasswords = new LtMastPasswords();
				ltMastPasswords.setUserId(ltMastUsers.getUserId());
				ltMastPasswords.setPassword(newJObject.get("changepassword").toString());
				ltMastPasswords.setPwdSequence((long) newJObject.get("changepassword").toString().length());
				ltMastPasswords.setCreatedBy(ltMastUsers.getUserId());
				ltMastPasswords.setCreationDate(new Date());
			//ltMastPasswords = ltMastPasswordsRepository.save(ltMastPasswords);

			status.setCode(PASS_CHANGE_SUCCESSFULLY);
			status.setMessage("Password changed successfully.");
			return new ResponseEntity<Status>(status, HttpStatus.OK);
			}else {
				status.setCode(INTERNAL_SERVER_ERROR);
				status.setMessage("Internal server error.");
				
				return new ResponseEntity<Status>(status, HttpStatus.OK);
			}
		} catch (ParseException e) {
			e.printStackTrace();
			status.setCode(INPUT_IS_EMPTY);
			status.setMessage("Please fill all mandatory fields.");
		
			return new ResponseEntity<Status>(status, HttpStatus.OK);

		} catch (NullPointerException e) {
			e.printStackTrace();
			status.setCode(INPUT_IS_EMPTY);
			status.setMessage("Please fill all mandatory fields.");
			
			return new ResponseEntity<Status>(status, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			status.setCode(INTERNAL_SERVER_ERROR);
			status.setMessage("Internal server error.");
			
			return new ResponseEntity<Status>(status, HttpStatus.OK);

		}
	}
	
	@RequestMapping(value = "/emailValidater/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> emailValidater(@PathVariable String id) throws Exception {
		Status status = new Status();
		status =loginService.emailValidater(id);
		return new ResponseEntity<Status>(status, HttpStatus.OK);
		
		
	}
	
	@RequestMapping(value = "/resetPassword", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> resetPassword(@RequestBody String jsonInputString) {
		Status status = loginService.resetPassword(jsonInputString);
		return new ResponseEntity<Status>(status, HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/changePasswordUtility", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> changePasswordUtility(@RequestBody String jsonInputString) throws ParseException, ServiceException
	{
		Status status = new Status();
		status =loginService.changePasswordUtility(jsonInputString);
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}
	


	
}
