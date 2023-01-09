package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import com.lonar.vendor.vendorportal.model.LtMastDivisions;
import com.lonar.vendor.vendorportal.model.ServiceException;


public interface LtMastDivisionsDao
{
	
	//public List<LtP2pDivisions> findByDivisionCode(String divisionCode) throws Exception;
	//public List<LtP2pDivisions> findByDivisionName(String divisionName) throws Exception;
	public List<LtMastDivisions>	findAllActive() throws ServiceException;
	public List<LtMastDivisions> findActiveLikeName(String divisionName) throws ServiceException;
	
	public List<LtMastDivisions> findByDivisionId(Long divisionId) throws ServiceException;
	public List<LtMastDivisions> checkDetails(LtMastDivisions ltMastDivisions) throws ServiceException;
	public LtMastDivisions getDivisionByDivisionId(Long divisionId)throws ServiceException;
	public List<LtMastDivisions> getDataTableRecords(LtMastDivisions input) throws ServiceException;
	public Long getCount(LtMastDivisions input) throws ServiceException;
	
}
