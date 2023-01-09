package com.lonar.vendor.vendorportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lonar.vendor.vendorportal.model.BroadcastService;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.StatusCodeName;

@RestController
@RequestMapping("/API/broadcast")
public class BroadcastController {

	@Autowired
	BroadcastService broadcastService;
	
	@RequestMapping(value = "/getmailidbystatus/{status}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<String> getMailIdByStatus(@PathVariable("status") String status,@PathVariable("logTime") String logTime) throws ServiceException
	{
		List<String> list =  broadcastService.getMailIdByStatus(status);
		return list;
	}
	
	@RequestMapping(value = "/getallstatus/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<StatusCodeName> getAllStatus(@PathVariable("logTime") String logTime) throws ServiceException 
	{
			return broadcastService.getAllStatus();
	}
	
}
