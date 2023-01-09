package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import com.lonar.vendor.vendorportal.model.LtMastStates;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.reports.ReportParameters;

public interface LtMastStatesDao {

	Long getCount(LtMastStates input) throws ServiceException;

	List<LtMastStates> getStateDataTableRecords(LtMastStates input) throws ServiceException;

	List<LtMastStates> findAll() throws ServiceException;

	List<LtMastStates> findAllActive() throws ServiceException;

	LtMastStates getByID(Long id) throws ServiceException;

	List<LtMastStates> findActiveLikeStateName(String state) throws ServiceException;

	LtMastStates getByStateCode(String stateCode) throws ServiceException;

	LtMastStates getByStateName(String name) throws ServiceException;

	LtMastStates getByGstStateCode(String gstStateCode) throws ServiceException;

	List<LtMastStates> getDataForReport(ReportParameters reportParameters) throws ServiceException;

	

	

}
