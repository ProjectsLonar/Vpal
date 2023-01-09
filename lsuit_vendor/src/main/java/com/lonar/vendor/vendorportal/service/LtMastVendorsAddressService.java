package com.lonar.vendor.vendorportal.service;

import java.util.List;

import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtMastVendorAddress;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

public interface LtMastVendorsAddressService extends CodeMaster
{

	List<LtMastVendorAddress> getAllVendorsAddress()throws ServiceException;

	LtMastVendorAddress getVendorAddById(Long vendorAddId)throws ServiceException;

	Status save(LtMastVendorAddress vendorsAdd) throws ServiceException;

	Status update(LtMastVendorAddress vendorsAdd)throws ServiceException;

	Status delete(Long vendorAddId) throws ServiceException;

	List<LtMastVendorAddress> getAllVendorsAddressByVendorId(Long vendorId) throws ServiceException;

	List<LtMastVendorAddress> getAllActiveVendorsAddressByVendorId(Long vendorId) throws ServiceException;

	List<LtMastVendorAddress> getAllActiveShippingAddressByVendId(Long vendorId) throws ServiceException;

	Status checkRecord(Long venId) throws ServiceException;

	Long getLtMastVendorAddressCount(Long vendorId, LtMastVendorAddress input) throws ServiceException;

	List<LtMastVendorAddress> getLtMastVendorAddressDataTable(Long vendorId, LtMastVendorAddress input) throws ServiceException;

}
