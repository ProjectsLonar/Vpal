package com.lonar.vendor.vendorportal.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import com.lonar.vendor.vendorportal.model.CommonMasterWithValue;
import com.lonar.vendor.vendorportal.model.LtMastComnMaster;
import com.lonar.vendor.vendorportal.model.LtMastComnMasterValues;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

public interface LtMastComnMasterService 
{

	public ResponseEntity findByMasterName(String masterName) throws ServiceException ;

	public ResponseEntity findByMasterDesc(String masterDesc) throws ServiceException;

	public ResponseEntity findAllActive() throws ServiceException;

	public ResponseEntity findActiveLikeName(String masterName) throws ServiceException;

	//*------------------------------
	public CommonMasterWithValue getById(String id) throws ServiceException;

	public List<LtMastComnMaster>  getDataTable(LtMastComnMaster input) throws ServiceException;

	public Long getCount(LtMastComnMaster input) throws ServiceException;

	public ResponseEntity getLtMastComnMasterByID(Long commonMasterId) throws ServiceException;

	public ResponseEntity saveMasterWithValue(CommonMasterWithValue commonMasterWithValue, BindingResult bindingResult);

	public ResponseEntity<Status> deleteLtMastComnMasterByID(String id) throws NumberFormatException, ServiceException;

	public ResponseEntity<Status> updateMasterWithValue(CommonMasterWithValue commonMasterWithValue) throws ServiceException;

	public ResponseEntity<Status> save(LtMastComnMaster ltMastComnMaster)  throws ServiceException;

	public ResponseEntity<Status> update(LtMastComnMaster ltMastComnMaster) throws ServiceException;

	public ResponseEntity<Status> delete(Long id)  throws ServiceException;

	public List<LtMastComnMasterValues> getLikeNameWithMaster(String masterName, String valueName) throws ServiceException;
	
	//public String checkCommonMasterDetails(LtMastComnMaster ltMastComnMaster) throws Exception;
}
