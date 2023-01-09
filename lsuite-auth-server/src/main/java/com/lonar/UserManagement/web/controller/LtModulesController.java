package com.lonar.UserManagement.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lonar.UserManagement.common.BusinessException;
import com.lonar.UserManagement.web.model.CodeMaster;
import com.lonar.UserManagement.web.model.LtMastModules;
import com.lonar.UserManagement.web.model.Status;
import com.lonar.UserManagement.web.service.LtMastModulesService;

@RestController
@RequestMapping("/module")
public class LtModulesController implements CodeMaster {

	@Autowired
	LtMastModulesService ltMastModulesService;
	
	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> addLtMastModules(@RequestBody LtMastModules ltMastModules) {
		Status status = new Status();
		try {
			status = ltMastModulesService.save(ltMastModules);
		} catch (Exception e) {
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}
}
