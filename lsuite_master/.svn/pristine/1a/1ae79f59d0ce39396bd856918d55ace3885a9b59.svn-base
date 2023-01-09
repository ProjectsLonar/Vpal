package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import com.lonar.vendor.vendorportal.model.LtMastAuditRecords;
import com.lonar.vendor.vendorportal.model.LtMastCity;
import com.lonar.vendor.vendorportal.model.ServiceException;

public interface LtMastCityDao {

	Long getCount(LtMastCity input) throws ServiceException;

	List<LtMastCity> getCityDataTableRecords(LtMastCity input) throws ServiceException;

	List<LtMastCity> findAll() throws ServiceException;

	List<LtMastCity> findAllActive() throws ServiceException;

	LtMastCity getById(Long id) throws ServiceException;

	List<LtMastCity> findActiveLikeCityName(String state) throws ServiceException;

	LtMastCity getByCityCode(String trim, Long stateId) throws ServiceException;

	LtMastCity getByCityName(String trim, Long stateId) throws ServiceException;

	LtMastCity getForAuditByID(Long cityId) throws ServiceException;

	void updateAuditId(float auditId,Long cityId) throws ServiceException;

	List<LtMastAuditRecords> getLtMastCityAudit(Long cityId) throws ServiceException;
	

}
