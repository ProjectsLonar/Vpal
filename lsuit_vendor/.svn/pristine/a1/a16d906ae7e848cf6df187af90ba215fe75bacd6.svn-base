package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import com.lonar.vendor.vendorportal.model.CommonMasterWithValue;
import com.lonar.vendor.vendorportal.model.LtMastComnMaster;
import com.lonar.vendor.vendorportal.model.ServiceException;



public interface LtMastComnMasterDao 
{
	
	public List<LtMastComnMaster> findByMasterName(String masterName) throws ServiceException;
	
	public List<LtMastComnMaster> findByMasterDesc(String masterDesc) throws ServiceException;
	public List<LtMastComnMaster>	findAllActive() throws ServiceException;
	
	public List<LtMastComnMaster> findActiveLikeName(String masterName) throws ServiceException;

	//------------------------------------------------------------------------------
	public CommonMasterWithValue getById(String id) throws ServiceException;

	public List<LtMastComnMaster> getDataTable(LtMastComnMaster input) throws ServiceException;

	public Long getCount(LtMastComnMaster input) throws ServiceException;

	public LtMastComnMaster getLtMastComnMasterByID(Long commonMasterId) throws ServiceException;
}
