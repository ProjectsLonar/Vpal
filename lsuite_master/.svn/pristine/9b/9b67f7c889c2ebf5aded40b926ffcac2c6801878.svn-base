package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import com.lonar.vendor.vendorportal.model.LtMastDivisions;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.reports.DivisionSubDivision;
import com.lonar.vendor.vendorportal.reports.ReportParameters;


public interface LtMastDivisionsDao
{
	
	//public List<LtP2pDivisions> findByDivisionCode(String divisionCode) throws Exception;
	//public List<LtP2pDivisions> findByDivisionName(String divisionName) throws Exception;
	public List<LtMastDivisions>	findAllActive(Long companyId) throws ServiceException;
	public List<LtMastDivisions> findActiveLikeName(Long companyId, String divisionName) throws ServiceException;
	
	public List<LtMastDivisions> findByDivisionId(Long divisionId) throws ServiceException;
	public List<LtMastDivisions> checkDetails(LtMastDivisions ltMastDivisions) throws ServiceException;
	public LtMastDivisions getDivisionByDivisionId(Long divisionId)throws ServiceException;
	public List<LtMastDivisions> getDataTableRecords(Long companyId, LtMastDivisions input) throws ServiceException;
	public Long getCount(Long companyId, LtMastDivisions input) throws ServiceException;
	public List<DivisionSubDivision> getDataForReport(ReportParameters reportParameters) throws ServiceException;
	public List<LtMastDivisions> getAll(Long companyId)throws ServiceException;
	
}
