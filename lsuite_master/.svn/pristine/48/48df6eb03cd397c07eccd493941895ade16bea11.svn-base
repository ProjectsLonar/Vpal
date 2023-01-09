package com.lonar.vendor.vendorportal.config;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.lonar.vendor.vendorportal.model.BusinessException;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.service.LtMastCommonMessageService;


@RestControllerAdvice
public class HandleGlobalException implements CodeMaster
{
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	
	
	static final Logger logger = Logger.getLogger(HandleGlobalException.class);
	
	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<Status> handleBusinessException(BusinessException e){
		ltMastCommonMessageService.saveLog(e.getException());
		e.getException().printStackTrace();
		logger.error("Error in  ", e.getException());
		
		 Status status = ltMastCommonMessageService.getCodeAndMessage(e.getCode());
		
		/*status.setCode(e.getCode());
		if(e.getMessage() == null){
			status.setMessage("Internal Server Error!!!");
		}else{
			status.setMessage(e.getMessage());
		}*/
		return new ResponseEntity<Status>(status, HttpStatus.EXPECTATION_FAILED );
	}
	
	@ExceptionHandler(ServiceException.class)
	public ResponseEntity<Status> handleServiceException(ServiceException e){
		ltMastCommonMessageService.saveLog(e.getException());
		e.getException().printStackTrace();
		e.printStackTrace();
		logger.error("Error in  ", e.getException());
		
		 Status status =  ltMastCommonMessageService.getCodeAndMessage(e.getCode());
		
		/*status.setCode(e.getCode());
		if(e.getMessage() == null){
			status.setMessage("Internal Server Error!!!");
		}else{
			status.setMessage(e.getMessage());
		}*/
		return new ResponseEntity<Status>(status, HttpStatus.EXPECTATION_FAILED );
	}

}
