package com.lonar.vendor.vendorportal.service;

import java.util.List;

import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtMastVendorContacts;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

public interface LtMastVendorContactsService extends CodeMaster
{

	List<LtMastVendorContacts> getAllVendorsContact() throws ServiceException;

	LtMastVendorContacts getVendorContactByContactId(Long vendorContactId) throws ServiceException;

	Status save(LtMastVendorContacts vendorContact) throws ServiceException;

	Status update(LtMastVendorContacts vendorContact) throws ServiceException;

	Status delete(Long vendorContactId)throws ServiceException;

	List<LtMastVendorContacts> getVendorContactByAddressIdAndVendorId(String vendorAddrId, String vendorId) throws ServiceException;

	Long getLtMastVendorContactsCount(Long vendorAddressId, LtMastVendorContacts input) throws ServiceException;

	List<LtMastVendorContacts> getLtMastVendorContactsDataTable(Long vendorAddressId, LtMastVendorContacts input) throws ServiceException;

}
