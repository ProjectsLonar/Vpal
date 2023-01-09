package com.lonar.vendor.vendorportal.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lonar.vendor.vendorportal.model.BusinessException;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.CustomeDataTable;
import com.lonar.vendor.vendorportal.model.LtMastDivisionEmployeeGrade;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.service.LtMastDivisionEmployeeGradeService;

@RestController
@RequestMapping("/API/employeegrade")
public class LtMastDivisionEmployeeGradeRestController implements CodeMaster {
	final String restBaseUrl = "/API/employeegrade";
	static final Logger logger = Logger.getLogger(LtMastDivisionEmployeeGradeRestController.class);
	
	@Autowired
	LtMastDivisionEmployeeGradeService ltP2pDivisionEmployeeGradeService;
	
	//@PreAuthorize("hasPermission(null, '#/employee/employee', 'View')")
		@RequestMapping(value = "/dataTable/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public CustomeDataTable getLtMastEmployeesDivisionDataTable(LtMastDivisionEmployeeGrade input,@PathVariable("logTime") String logTime) 
		{
			CustomeDataTable customeDataTable = new CustomeDataTable();
			try 
			{
				Long count=ltP2pDivisionEmployeeGradeService.getCount(input);
				customeDataTable.setRecordsTotal(count);
				customeDataTable.setRecordsFiltered(count);
				List<LtMastDivisionEmployeeGrade> ltMastBuildingList= ltP2pDivisionEmployeeGradeService.getDatatableRecords(input);
				customeDataTable.setData(ltMastBuildingList);	
			} 
			catch (Exception e) 
			{
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
			}
			return customeDataTable;
		}
	// -------------------Retrieve All Bank details-----------------------------
	//@PreAuthorize("hasPermission(null, '#/divisionGradeApproval/divisionGradeApproval', 'View') ")
	@RequestMapping(value = "/getAll/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastDivisionEmployeeGrade>> listLtP2pDivisionEmployeeGradeAll(@PathVariable("logTime") String logTime) throws ServiceException {
		List<LtMastDivisionEmployeeGrade> list = ltP2pDivisionEmployeeGradeService.getAll();
		 return new ResponseEntity<List<LtMastDivisionEmployeeGrade>>(list, HttpStatus.OK);
		
	}

	// -------------------Retrieve All Active Bank details-----------------------------
	//@PreAuthorize("hasPermission(null, '#/divisionGradeApproval/divisionGradeApproval', 'View') ")
	@RequestMapping(value = "/getAllActive/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastDivisionEmployeeGrade>> listAllActiveLtP2pDivisionEmployeeGrade(@PathVariable("logTime") String logTime) throws ServiceException {
		return (ResponseEntity<List<LtMastDivisionEmployeeGrade>>) ltP2pDivisionEmployeeGradeService.findAllActive();
			
	}

	// -------------------Retrieve Single Bank details----------------------------
	//@PreAuthorize("hasPermission(null, '#/divisionGradeApproval/divisionGradeApproval', 'View') ")
	@RequestMapping(value = "/getByID/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LtMastDivisionEmployeeGrade> getLtP2pDivisionEmployeeGradeByID(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException {
		LtMastDivisionEmployeeGrade ltP2pDivisionEmployeeGrade =ltP2pDivisionEmployeeGradeService.getLtP2pDivisionEmployeeGradeByID(id);
		return new ResponseEntity<LtMastDivisionEmployeeGrade>(ltP2pDivisionEmployeeGrade, HttpStatus.OK);
		
	}

	@RequestMapping(value = "/getActiveLikeDivisionName/{name}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastDivisionEmployeeGrade>> getActiveLikeDivisionName(
			@PathVariable("name") String name,@PathVariable("logTime") String logTime) throws ServiceException {
		return (ResponseEntity<List<LtMastDivisionEmployeeGrade>>) ltP2pDivisionEmployeeGradeService.findActiveLikeDivisionName(name.trim());
		
	}

	// -------------------Create and Update Bank details-----------------
	//@PreAuthorize("hasPermission(null, '#/divisionGradeApproval/divisionGradeApproval', 'Add') ")
	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> saveLtP2pDivisionEmployeeGrade(
			@RequestBody @Valid LtMastDivisionEmployeeGrade ltP2pDivisionEmployeeGrade) throws ServiceException {
		try {
			return ltP2pDivisionEmployeeGradeService.save(ltP2pDivisionEmployeeGrade);
		}catch(Exception e) {
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
	}

	// -------------------Create and Update Bank details-----------------
	//@PreAuthorize("hasPermission(null, '#/divisionGradeApproval/divisionGradeApproval', 'Add') ")
	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> updateLtP2pDivisionEmployeeGrade(@RequestBody @Valid LtMastDivisionEmployeeGrade ltP2pDivisionEmployeeGrade) throws ServiceException
	{
		try {
			return ltP2pDivisionEmployeeGradeService.update(ltP2pDivisionEmployeeGrade);
		}catch(Exception e) {
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
	}
	// -------------------Retrieve Single Bank details----------------------------
	//@PreAuthorize("hasPermission(null, '#/divisionGradeApproval/divisionGradeApproval', 'Delete') ")
	@RequestMapping(value = "/deleteByID/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> deleteLtP2pDivisionEmployeeGradeByID(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException {
		try {
			return ltP2pDivisionEmployeeGradeService.delete(id);
		}catch(Exception e) {
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
	}

}