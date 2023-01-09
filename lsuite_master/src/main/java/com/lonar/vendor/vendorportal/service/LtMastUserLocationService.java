package com.lonar.vendor.vendorportal.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.lonar.vendor.vendorportal.model.LtMastLogger;
import com.lonar.vendor.vendorportal.model.LtMastUserLocation;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

public interface LtMastUserLocationService 
{

	List<LtMastUserLocation> getAllLtMastUserLocation() throws ServiceException;

	List<LtMastUserLocation> findAllActive() throws ServiceException;

	LtMastUserLocation getByID(Long id) throws ServiceException;

	ResponseEntity<Status> save(LtMastUserLocation ltMastUserLocation) throws ServiceException;

	ResponseEntity<Status> update(LtMastUserLocation ltMastUserLocation) throws ServiceException;

	ResponseEntity<Status> delete(Long id) throws ServiceException;

	List<LtMastUserLocation> listAllActiveUserLocationByLocId(Long id) throws ServiceException;

	List<LtMastUserLocation> listAllActiveUserLocationByUserId(Long id) throws ServiceException;

	Long getCount(LtMastUserLocation input) throws ServiceException;

	List<LtMastUserLocation> getDatatableRecords(LtMastUserLocation input) throws ServiceException; 

}
