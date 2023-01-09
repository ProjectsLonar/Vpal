package com.lonar.vendor.vendorportal.service;

import java.util.List;

import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtMastVendorMiscInfo;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

public interface LtMastVendorMiscInfoService extends CodeMaster
{

	List<LtMastVendorMiscInfo> getAllVendorMiscInfo() throws ServiceException;

	List<LtMastVendorMiscInfo >getVendorMiscByVenId(Long vendorId)throws ServiceException;
	
	LtMastVendorMiscInfo getVendorMiscInfoById(Long vendorMiscInfoId) throws ServiceException;

	Status save(LtMastVendorMiscInfo ltMastVendorMiscInfo)  throws ServiceException ;

	Status update(LtMastVendorMiscInfo ltMastVendorMiscInfo)throws ServiceException;

	Status delete(Long vendorMiscInfoId) throws ServiceException;

	

}
