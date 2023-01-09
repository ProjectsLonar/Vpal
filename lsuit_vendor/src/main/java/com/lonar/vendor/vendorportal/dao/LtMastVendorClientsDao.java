package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import com.lonar.vendor.vendorportal.model.LtMastVendorClients;
import com.lonar.vendor.vendorportal.model.ServiceException;

public interface LtMastVendorClientsDao {

	List<LtMastVendorClients> getAllVendorClients() throws ServiceException;

	List<LtMastVendorClients> getVendorClientsByVendorId(Long vendorId) throws ServiceException;

	boolean save(LtMastVendorClients ltMastVendorClients) throws ServiceException;

	boolean update(LtMastVendorClients ltMastVendorClients) throws ServiceException;

	boolean delete(Long vendorClientsId) throws ServiceException;

	LtMastVendorClients getVendorClientsById(Long vendorClientsId) throws ServiceException;

	boolean deleteByVendorId(Long vendorId) throws ServiceException;

	Long getVendorClientsByVendorIdDataTableCount(Long vendorId, LtMastVendorClients input) throws ServiceException;

	List<LtMastVendorClients> getVendorClientsByVendorIdDataTable(Long vendorId, LtMastVendorClients input)
			throws ServiceException;

}
