package com.lonar.vendor.vendorportal.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lonar.vendor.vendorportal.model.BusinessException;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtMastAuditRecords;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.service.LtMastAuditRecordsService;

@RestController
@RequestMapping("/API/auditRecords")
public class LtMastAuditRecordsRestController implements CodeMaster{
	
	@Autowired
	LtMastAuditRecordsService ltMastAuditRecordsService;
	
	@RequestMapping(value = "/update",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> updateLtMastAuditRecords(@RequestBody @Valid List<LtMastAuditRecords> ltMastAuditRecordsList,
			BindingResult bindingResult) throws ServiceException, IOException {
		try {
		return ltMastAuditRecordsService.update(ltMastAuditRecordsList);
		}catch(Exception e) {
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}

	}
	
	
	@RequestMapping(value = "/getByMaster/{masterName}/{logTime}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LtMastAuditRecords> getByMaster(@PathVariable("masterName") String masterName,@PathVariable("logTime") String logTime) throws ServiceException, IOException {
		try {
		return ltMastAuditRecordsService.getByMaster(masterName);
		}catch(Exception e) {
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}

	}
	

}
