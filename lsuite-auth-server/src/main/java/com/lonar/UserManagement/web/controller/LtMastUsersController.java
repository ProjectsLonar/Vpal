package com.lonar.UserManagement.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lonar.UserManagement.common.BusinessException;
import com.lonar.UserManagement.common.ServiceException;
import com.lonar.UserManagement.web.model.CodeMaster;
import com.lonar.UserManagement.web.model.CustomeDataTable;
import com.lonar.UserManagement.web.model.LtMastAuditRecords;
import com.lonar.UserManagement.web.model.LtMastRoles;
import com.lonar.UserManagement.web.model.LtMastUserRoles;
import com.lonar.UserManagement.web.model.LtMastUsers;
import com.lonar.UserManagement.web.model.Status;
import com.lonar.UserManagement.web.service.LtMastUsersService;


@RestController
@RequestMapping(value = "/api/users")
@PropertySource(value = "classpath:serverurl.properties", ignoreResourceNotFound = true)
public class LtMastUsersController implements CodeMaster {
	final String restBaseUrl = "/API/users";

	static final Logger logger = Logger.getLogger(LtMastUsersController.class);
	
	@Autowired
	LtMastUsersService ltMastUsersService;
 
	
	@RequestMapping(value = "/datatable/{companyId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomeDataTable getDataTable(@PathVariable("companyId") Long companyId,LtMastUsers input,@PathVariable("logTime") String logTime) {
		try {
			return ltMastUsersService.getLtMastUsersDataTable(input,companyId);
		}catch(Exception e) {
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
		
	}
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST )
	public ResponseEntity<Status> saveUser(@RequestBody LtMastUsers user) {
		Status status = new Status();
		try {
			status =  ltMastUsersService.saveUser(user);
			
		}catch(Exception e) {
			 
			status.setCode(INTERNAL_SERVER_ERROR);
			status.setMessage("User creation fail!! Email Id already exists");
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
				//return status;
		}
		return new ResponseEntity<Status>(status, HttpStatus.OK);
		
		
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST )
	public ResponseEntity<Status> updateUser(@RequestBody LtMastUsers user) {
		Status status = new Status();
		try {
			status = ltMastUsersService.updateUser(user);
		}catch(Exception e) {
			e.printStackTrace();
			status.setCode(INTERNAL_SERVER_ERROR);
			status.setMessage(e.getMessage());
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getbyid/{id}/{logTime}", method = RequestMethod.GET)
	public ResponseEntity<LtMastUsers> getLtMastUsersByID(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) {
		try {
			return ltMastUsersService.getLtMastUsersByID(id);
		}catch(Exception e) {
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
		
	}	
	
	@RequestMapping(value = "/activeroles/{logTime}", method = RequestMethod.GET)
	public ResponseEntity<List<LtMastRoles>> getActiveRoles(@PathVariable("logTime") String logTime) {
		try {
			return ltMastUsersService.getActiveRoles();
		}catch(Exception e) {
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
		
	}	
	
	@RequestMapping(value = "/rolesave", method = RequestMethod.POST )
	public ResponseEntity<Status> saveUser(@RequestBody LtMastUserRoles user) {
		try {
			return ltMastUsersService.saveUserRole(user);
		}catch(Exception e) {
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
		
	}
	
	@RequestMapping(value = "/roledatatable/{logTime}", method = RequestMethod.GET)
	public CustomeDataTable getUsersRoleDataTable( LtMastUserRoles input,@PathVariable("logTime") String logTime) {
		try {
			return ltMastUsersService.getUsersRoleDataTable(input);
		}catch(Exception e) {
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
	
		
	}
 
	
	
	@RequestMapping(value = "/deleteById/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> deleteUsersByID(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) {
		Status status = null;
		try {
			 status = ltMastUsersService.deleteById(id);
		}catch(Exception e) {
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}

	@RequestMapping(value = "/getActiveLikeUserName/{userName}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastUsers>> listActiveLikeUserName(@PathVariable("userName") String userName,@PathVariable("logTime") String logTime) {
		
		List<LtMastUsers> ltMastUsers =new ArrayList<LtMastUsers>();
		try {
			ltMastUsers =  ltMastUsersService.findByActiveLikeUserName(userName);
			if (ltMastUsers.isEmpty()) {
				return new ResponseEntity<List<LtMastUsers>>(ltMastUsers, HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("ERROR "+ e );
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
		return new ResponseEntity<List<LtMastUsers>>(ltMastUsers, HttpStatus.OK);
	}
	
	
	//=============================================================================================================
		@RequestMapping(value = "/getaAuditRecords/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<LtMastAuditRecords>> getLtMastUserAudit(@PathVariable("id") Long userId,@PathVariable("logTime") String logTime)
				throws ServiceException {
			List<LtMastAuditRecords> list = ltMastUsersService.getLtMastUserAudit(userId);
			return new ResponseEntity<List<LtMastAuditRecords>>(list, HttpStatus.OK);
		}


}