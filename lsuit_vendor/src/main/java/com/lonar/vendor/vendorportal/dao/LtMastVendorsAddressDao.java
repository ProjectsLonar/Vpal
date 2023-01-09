package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import com.lonar.vendor.vendorportal.model.LtMastVendorAddress;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.reports.ReportParameters;

public interface LtMastVendorsAddressDao 
{

	List<LtMastVendorAddress> getAllVendors() throws ServiceException;

	LtMastVendorAddress getVendorById(Long vendorAddId) throws ServiceException;

	Long save(LtMastVendorAddress vendorsAdd) throws ServiceException;

	boolean update(LtMastVendorAddress vendorsAdd) throws ServiceException;

	boolean delete(Long vendorAddId) throws ServiceException;

	List<LtMastVendorAddress> getAllVendorsAddressByVendorId(Long vendorId) throws ServiceException;

	List<LtMastVendorAddress> getAllActiveVendorsAddressByVendorId(Long vendorId) throws ServiceException;

	boolean deleteByVendorId(Long vendorId) throws ServiceException;

	List<LtMastVendorAddress> getAllActiveShippingAddressByVendId(Long vendorId) throws ServiceException;

	List<LtMastVendorAddress> getDataForReport(ReportParameters reportParameters) throws ServiceException;

	Long getLtMastVendorAddressCount(Long vendorId, LtMastVendorAddress input) throws ServiceException;

	List<LtMastVendorAddress> getLtMastVendorAddressDataTable(Long vendorId, LtMastVendorAddress input) throws ServiceException;

}
