package com.lonar.vendor.vendorportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lonar.vendor.vendorportal.model.CompanyMgmt;
import com.lonar.vendor.vendorportal.model.LtCompanyVenMgmtAttachment;
import com.lonar.vendor.vendorportal.model.LtCompanyVenMgmtMiscQues;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.service.LtCompanyVenManagementService;

@RestController
@RequestMapping("/API/company")
public class LtCompanyVenManagement {
	
	@Autowired
	LtCompanyVenManagementService ltCompanyVenManagementService;
	
	
	@RequestMapping(value = "/getVendorMasterMgmtBycompanyId/{companyId}/{vendorId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CompanyMgmt>> getVendorMasterMgmtBycompanyId(@PathVariable("companyId") Long companyId,@PathVariable("vendorId") Long vendorId,@PathVariable("logTime") String logTime) throws ServiceException 
	{
		return ltCompanyVenManagementService.getMasterMgmtBycompanyId(companyId,vendorId);
	}
	
	@RequestMapping(value = "/getVendorMasterBycompanyId/{companyId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CompanyMgmt>> getVendorMasterBycompanyId(@PathVariable("companyId") Long companyId,@PathVariable("logTime") String logTime) throws ServiceException 
	{
		return ltCompanyVenManagementService.getVendorMasterBycompanyId(companyId);
	}
	
	@RequestMapping(value = "/getAttachmentByCompanyVendor/{companyId}/{vendorId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtCompanyVenMgmtAttachment>> getCompanyVenMgmtAttachmentByCompanyVendor(@PathVariable("companyId") Long companyId,@PathVariable("vendorId") Long vendorId,@PathVariable("logTime") String logTime) throws ServiceException 
	{
		return ltCompanyVenManagementService.getCompanyVenMgmtAttachmentByCompanyVendor(companyId,vendorId);
	}
	
	@RequestMapping(value = "/getQuestionByCompanyVendor/{companyId}/{vendorId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtCompanyVenMgmtMiscQues>> getQuestionByCompanyVendor(@PathVariable("companyId") Long companyId,@PathVariable("vendorId") Long vendorId,@PathVariable("logTime") String logTime) throws ServiceException 
	{
		return ltCompanyVenManagementService.getQuestionByCompanyVendor(companyId,vendorId);
	}

}
