package com.lonar.vendor.vendorportal.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtMastVendors;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

public interface LtMastVendorsService extends CodeMaster
{

	List<LtMastVendors> getAllVendors() throws ServiceException;

	LtMastVendors getVendorById(Long vendorId) throws ServiceException;

	Status save(LtMastVendors vendors)throws ServiceException;

	Status update(LtMastVendors vendors)throws ServiceException;

	Status delete(Long vendorId)throws ServiceException;

	List<LtMastVendors> getAllActiveVendors() throws ServiceException;

	List<LtMastVendors> getActiveVendorByName(Long companyId, String vendorName) throws ServiceException;

	Long getLtMastVendorsCount(Long companyId, LtMastVendors input) throws ServiceException;

	List<LtMastVendors> getLtMastVendorsDataTable(Long companyId, LtMastVendors input) throws ServiceException;

	List<LtMastVendors> getActiveVendorByNameAndDivId(String vendorName, Long divId) throws ServiceException;

	List<LtMastVendors> getVendorByDivId(Long divId) throws ServiceException;

	Status submitForApproval(Date date, Long vendorId, String inprocess, Object object) throws ServiceException;

	LtMastVendors getStatusVendorById(Long vendorId)  throws ServiceException;

	List<LtMastVendors> getAllVendorsByCompanyId(Long companyId) throws ServiceException;

	LtMastVendors getByEMailId(String primaryEmail,Long companyId) throws ServiceException;

	Long getLtMastVendorsCountByInitiatorId(LtMastVendors input, Long initiatorId) throws ServiceException;

	List<LtMastVendors> getLtMastVendorsDataTableByInitiatorId(LtMastVendors input, Long initiatorId) throws ServiceException;

	List<LtMastVendors> getAllVendorsByInitiator(Long initiatorId) throws ServiceException;

	Status checkRecord(Long venId) throws ServiceException;

	LtMastVendors getPanByvendorbyid(Long vendorId) throws ServiceException;

	Status getCompanyByVendor(Long venId) throws ServiceException;

	String checkforApprovals(Long vendorId) throws ServiceException;

	Status getVendorNameById(Long vendorId) throws ServiceException;

	ResponseEntity<Status> saveVendorInvite(String vendorsList, MultipartFile[] files) throws ServiceException, JsonParseException, JsonMappingException, IOException;

	List<LtMastVendors> getVendorByName(Long companyId, String vendorName) throws ServiceException;

	Status saveWithAttachment(LtMastVendors ltMastVendor, MultipartFile[] files) throws ServiceException;

	Status updateWithAttachment(LtMastVendors ltMastVendor, MultipartFile[] files) throws ServiceException;

	Status updateAttachment(Long vendorId, MultipartFile[] files) throws ServiceException;

	LtMastVendors getByRegistrationMailId(String registrationEmail, Long companyId) throws ServiceException;



	//ResponseEntity<Status> saveVendorInvite(List<LtMastVendors> ltMastVendorsList, MultipartFile[] files) throws ServiceException;

}
