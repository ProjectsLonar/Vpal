package com.lonar.vendor.vendorportal.controller;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.lonar.vendor.vendorportal.model.SendBroadCastEmail;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.service.LtMastEmailtokenService;

@RestController
@RequestMapping("/API/emailToken")
public class LtMastEmailtokenRestController 
{

	Status status = new Status();
	
	@Autowired
	LtMastEmailtokenService ltMastEmailtokenService;
	
	@RequestMapping(value = "/save", method= RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Status> sendMail(@RequestBody SendBroadCastEmail emailList) throws ServiceException{
		Status status =  ltMastEmailtokenService.sendMail(emailList);
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/sendBroadCastMessageAndMail", method= RequestMethod.POST)
	public ResponseEntity<Status> sendBroadCastMessage(@RequestParam("SendBroadCastEmail") String emailList,
			@RequestParam("file") MultipartFile[] files) throws ServiceException, ParseException, JsonParseException, JsonMappingException, IOException
	{
		 
		Status status =  ltMastEmailtokenService.sendBroadCastMsgAndEmail(emailList,files);
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/sendBroadCastMessage", method= RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Status> sendBroadCastMessage(@RequestBody SendBroadCastEmail emailList) throws ServiceException{
		 
		Status status =  ltMastEmailtokenService.sendBroadCastMessage(emailList);
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}
}
