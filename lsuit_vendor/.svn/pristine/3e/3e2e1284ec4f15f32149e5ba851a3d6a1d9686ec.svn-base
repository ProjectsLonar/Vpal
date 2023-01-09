package com.lonar.vendor.vendorportal.service;

import java.util.List;

import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtMastVendorClients;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

public interface LtMastVendorClientsService extends CodeMaster {

	List<LtMastVendorClients> getAllVendorClients() throws ServiceException;

	List<LtMastVendorClients> getVendorClientsByVendorId(Long vendorId) throws ServiceException;

	Status save(LtMastVendorClients ltMastVendorClients) throws ServiceException;

	Status update(LtMastVendorClients ltMastVendorClients) throws ServiceException;

	Status delete(Long vendorClientsId) throws ServiceException;

	LtMastVendorClients getVendorClientsById(Long vendorClientsId) throws ServiceException;

	Status checkRecord(Long venId) throws ServiceException;

	Long getVendorClientsByVendorIdDataTableCount(Long vendorId, LtMastVendorClients input) throws ServiceException;

	List<LtMastVendorClients> getVendorClientsByVendorIdDataTable(Long vendorId, LtMastVendorClients input)
			throws ServiceException;

}
