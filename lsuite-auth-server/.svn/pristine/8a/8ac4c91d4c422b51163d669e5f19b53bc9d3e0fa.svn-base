package com.lonar.UserManagement.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lonar.UserManagement.common.BusinessException;
import com.lonar.UserManagement.web.model.CodeMaster;
import com.lonar.UserManagement.web.model.CustomeDataTable;
import com.lonar.UserManagement.web.model.LtMastUsers;
import com.lonar.UserManagement.web.service.LtMastUsersService;

@RestController
@RequestMapping("/api/utility")
public class LtMastUtilityController implements CodeMaster {
	
	@Autowired
	LtMastUsersService ltMastUsersService;
	
	@RequestMapping(value = "/datatable/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomeDataTable getUtilityDataTable(LtMastUsers input,@PathVariable("logTime") String logTime) {
		try {
			return ltMastUsersService.getLtMastUsersUtilityDataTable(input);
		}catch(Exception e) {
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
		
	}

}
