package com.lonar.UserManagement.web.service;

import java.util.List;

import com.lonar.UserManagement.web.model.CommonMasterWithValue;
import com.lonar.UserManagement.web.model.LtMastComnMaster;

public interface LtMastComnMasterService 
{

	public List<LtMastComnMaster> findByMasterName(String masterName) throws Exception ;

	public List<LtMastComnMaster> findByMasterDesc(String masterDesc) throws Exception;

	public List<LtMastComnMaster> findAllActive() throws Exception;

	public List<LtMastComnMaster> findActiveLikeName(String masterName) throws Exception;

	//*------------------------------
	public CommonMasterWithValue getById(String id) throws Exception;

	public List<LtMastComnMaster> getDataTable(LtMastComnMaster input) throws Exception;

	public Long getCount(LtMastComnMaster input) throws Exception;

	public LtMastComnMaster getLtMastComnMasterByID(Long commonMasterId) throws Exception;
	
	//public String checkCommonMasterDetails(LtMastComnMaster ltMastComnMaster) throws Exception;
}
