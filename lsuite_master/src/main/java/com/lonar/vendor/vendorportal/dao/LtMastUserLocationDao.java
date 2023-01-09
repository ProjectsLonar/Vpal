package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import com.lonar.vendor.vendorportal.model.LtMastUserLocation;
import com.lonar.vendor.vendorportal.model.ServiceException;

public interface LtMastUserLocationDao {

	List<LtMastUserLocation> getAllLtMastUserLocation() throws ServiceException;

	List<LtMastUserLocation> findAllActive() throws ServiceException;

	LtMastUserLocation getByID(Long id) throws ServiceException;

	List<LtMastUserLocation> listAllActiveUserLocationByLocId(Long id) throws ServiceException;

	List<LtMastUserLocation> listAllActiveUserLocationByUserId(Long id) throws ServiceException;

	List<LtMastUserLocation> getDatatableRecords(LtMastUserLocation input) throws ServiceException;

	Long getCount(LtMastUserLocation input) throws ServiceException;

}
