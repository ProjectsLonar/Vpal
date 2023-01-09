package com.lonar.vendor.vendorportal.service;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.lonar.vendor.vendorportal.model.CompanyMgmt;
import com.lonar.vendor.vendorportal.model.LtVendCompany;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;


public interface LtVendCompanyService 
{
	ResponseEntity getLtMastCompanyBycompanyId(Long companyId) throws ServiceException;

	ResponseEntity getAllLtVendMastCompany() throws ServiceException;

	//ResponseEntity<Status> save (LtVendMastCompany ltMastCompany,MultipartFile[] files) throws ServiceException;

	//Status update(LtMastCompany ltMastCompany) throws Exception;

	ResponseEntity getLtVendMastCompanyLikecompanyName(String companyName) throws ServiceException;

	ResponseEntity<Status> delete(Long parseLong) throws ServiceException;

	Long getCount(Long companyId, LtVendCompany input) throws Exception;

	List<LtVendCompany> getDatatableRecords(Long companyId, LtVendCompany input) throws Exception;

	Status update(LtVendCompany ltMastCompany, MultipartFile[] files) throws ServiceException;

	ResponseEntity getAllActiveLtVendMastCompany() throws ServiceException;

	ResponseEntity<Status> save(LtVendCompany ltVendMastCompany, MultipartFile[] files) throws ServiceException, JsonParseException, JsonMappingException, IOException, Exception;

	Status deleteAttachment(Long companyId) throws ServiceException;

	ResponseEntity<List<CompanyMgmt>> getMasterMgmtBycompanyId(Long companyId) throws ServiceException;

//	ResponseEntity<List<CompanyMgmt>> getMasterMgmtBycompanyId(Long companyId) throws ServiceException;


}
