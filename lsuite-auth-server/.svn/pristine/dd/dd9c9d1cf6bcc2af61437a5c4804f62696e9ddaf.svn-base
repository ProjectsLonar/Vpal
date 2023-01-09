package com.lonar.UserManagement.web.controller;

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

import com.lonar.UserManagement.common.BusinessException;
import com.lonar.UserManagement.common.ServiceException;
import com.lonar.UserManagement.web.model.CodeMaster;
import com.lonar.UserManagement.web.model.CustomeDataTable;
import com.lonar.UserManagement.web.model.LtMastAuditRecords;
import com.lonar.UserManagement.web.model.Status;
import com.lonar.UserManagement.web.service.LtMastAuditRecordsService;

@RestController
@RequestMapping("/api/auditRecords")
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
	
	@RequestMapping(value = "/dataTable/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomeDataTable getDataTable(LtMastAuditRecords input,@PathVariable("id") Long auditId,@PathVariable("logTime") String logTime) 
	{
		CustomeDataTable customeDataTable = new CustomeDataTable();
		try 
		{
				Long count=ltMastAuditRecordsService.getCount(input,auditId);
				customeDataTable.setRecordsTotal(count);
			    customeDataTable.setRecordsFiltered(count);
			    List<LtMastAuditRecords> ltMastAuditRecordsList= ltMastAuditRecordsService.getLtMastAuditRecordsData(input,auditId);
				
			    customeDataTable.setData(ltMastAuditRecordsList);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
		return customeDataTable;
	}


}
