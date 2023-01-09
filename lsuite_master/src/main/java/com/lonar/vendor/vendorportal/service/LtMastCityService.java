package com.lonar.vendor.vendorportal.service;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.lonar.vendor.vendorportal.model.LtMastAuditRecords;
import com.lonar.vendor.vendorportal.model.LtMastCity;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

public interface LtMastCityService {

	Long getCount(LtMastCity input) throws ServiceException;
	
	List<LtMastCity> getCityDataTableRecords(LtMastCity input) throws ServiceException;
	
	ResponseEntity<Status> update(LtMastCity ltMastCity) throws ServiceException,IOException;
	
	ResponseEntity<Status> save(LtMastCity ltMastCity) throws ServiceException,IOException;
	
	List<LtMastCity> findAll() throws ServiceException;;
	
	List<LtMastCity> findAllActive() throws ServiceException;;
	
	LtMastCity getByID(Long id) throws ServiceException;;
	
	List<LtMastCity> findActiveLikeCityName(String trim) throws ServiceException;;
	
	ResponseEntity<Status> delete(Long id) throws ServiceException;

	List<LtMastAuditRecords> getLtMastCityAudit(Long cityId) throws ServiceException;

	List<LtMastAuditRecords> getDifference(LtMastCity ltMastCity)  throws ServiceException,IOException;
	
	
}
