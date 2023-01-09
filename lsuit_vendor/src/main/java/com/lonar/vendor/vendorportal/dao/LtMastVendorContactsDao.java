package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import com.lonar.vendor.vendorportal.model.LtMastVendorContacts;
import com.lonar.vendor.vendorportal.model.ServiceException;

public interface LtMastVendorContactsDao 
{

	List<LtMastVendorContacts> getAllVendorsContact() throws ServiceException;

	LtMastVendorContacts getVendorContactByContactId(Long vendorContactId) throws ServiceException;

	Long save(LtMastVendorContacts vendorContact)throws ServiceException;

	boolean update(LtMastVendorContacts vendorContact) throws ServiceException;

	boolean delete(Long vendorContactId) throws ServiceException;

	List<LtMastVendorContacts> getVendorContactByAddressIdAndVendorId(String vendorAddrId, String vendorId) throws ServiceException;

	List<LtMastVendorContacts> getVendorContactByVendorId(Long vendorId) throws ServiceException;

	boolean deleteByVendorId(Long vendorId) throws ServiceException;

	Long getLtMastVendorContactsCount(Long vendorAddressId, LtMastVendorContacts input) throws ServiceException;

	List<LtMastVendorContacts> getLtMastVendorContactsDataTable(Long vendorAddressId, LtMastVendorContacts input) throws ServiceException;

	

}
