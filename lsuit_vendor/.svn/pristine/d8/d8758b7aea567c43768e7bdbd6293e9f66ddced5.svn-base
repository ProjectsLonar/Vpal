package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import com.lonar.vendor.vendorportal.model.LtMastVendorMiscInfo;
import com.lonar.vendor.vendorportal.model.ServiceException;

public interface LtMastVendorMiscInfoDao 
{

	List<LtMastVendorMiscInfo> getAllVendorMiscInfo() throws ServiceException;

	List<LtMastVendorMiscInfo> getVendorMiscByVenId(Long vendorId) throws ServiceException;
	
	LtMastVendorMiscInfo getVendorMiscInfoById(Long vendorMiscInfoId) throws ServiceException;

	boolean save(LtMastVendorMiscInfo ltMastVendorMiscInfo) throws ServiceException;

	boolean update(LtMastVendorMiscInfo ltMastVendorMiscInfo) throws ServiceException;

	boolean delete(Long vendorMiscInfoId) throws ServiceException;

	boolean deleteByVendorId(Long vendorId) throws ServiceException;

	

	
}
