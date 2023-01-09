/*package com.lonar.vendor.vendorportal.service;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.lonar.vendor.vendorportal.model.LtMastCompany;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

import net.minidev.json.parser.ParseException;

public interface LtMastCompanyService 
{

	ResponseEntity getLtMastCompanyBycompanyId(Long companyId) throws ServiceException;

	ResponseEntity getAllLtMastCompany() throws ServiceException;

	Status saveLtMastCustomers(LtMastCompany ltMastCompany,MultipartFile[] files) throws ServiceException;

	//Status update(LtMastCompany ltMastCompany) throws Exception;

	ResponseEntity getLtMastCompanyLikecompanyName(String companyName) throws ServiceException;

	ResponseEntity<Status> delete(Long parseLong) throws ServiceException;

	Long getCount(LtMastCompany input) throws Exception;

	List<LtMastCompany> getDatatableRecords(LtMastCompany input) throws Exception;

	Status update(LtMastCompany ltMastCompany, MultipartFile[] files) throws ServiceException;

	ResponseEntity getAllActiveLtMastCompany() throws ServiceException;

	ResponseEntity<Status> save(LtMastCompany ltMastCompany, MultipartFile[] files) throws ServiceException, JsonParseException, JsonMappingException, IOException, ParseException;

}
*/