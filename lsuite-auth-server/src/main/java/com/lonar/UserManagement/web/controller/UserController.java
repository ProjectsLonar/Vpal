package com.lonar.UserManagement.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lonar.UserManagement.web.model.LtMastUsers;
import com.lonar.UserManagement.web.service.UserService;

@RestController
@RequestMapping(value="/api/users", produces = MediaType.APPLICATION_JSON_VALUE )
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value="/id/{id}/{logTime}", method = RequestMethod.GET)
	public LtMastUsers getUserById(@PathVariable Long id,@PathVariable("logTime") String logTime) {
		LtMastUsers mastUsers = userService.getUserById(id);
		return mastUsers;
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST )
	public Long addNewUser(@RequestBody LtMastUsers user) {
		return userService.addNewUser(user);
	}
	
	@RequestMapping(value="/delete/{userId}/{logTime}", method = RequestMethod.DELETE)
	public Long deleteUser(@PathVariable Long userId,@PathVariable("logTime") String logTime) {
		 return userService.removeUser(userId);
	}
	
	@RequestMapping(value="/list/{logTime}", method = RequestMethod.GET )
	public List<LtMastUsers> getUsers(@PathVariable("logTime") String logTime) {
		return userService.getUserList();
	}
	
	
}
