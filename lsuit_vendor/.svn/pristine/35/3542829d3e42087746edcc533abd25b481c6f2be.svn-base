package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import com.lonar.vendor.vendorportal.model.LtMastValidation;
import com.lonar.vendor.vendorportal.model.LtMastVendorManagements;
import com.lonar.vendor.vendorportal.model.ServiceException;

public interface LtMastVendorManagementsDao
{

	List<LtMastVendorManagements> getAllVendorManagements() throws ServiceException;

	List<LtMastVendorManagements> getVendorManagementByVenId(Long vendorId) throws ServiceException;

	LtMastVendorManagements getVendorManagementById(Long vendorManagementId) throws ServiceException;

	boolean save(LtMastVendorManagements ltMastVendorManagements) throws ServiceException;

	boolean update(LtMastVendorManagements ltMastVendorManagements) throws ServiceException;

	boolean delete(Long vendorManagementId) throws ServiceException;

	boolean deleteByVendorId(Long vendorId) throws ServiceException;

	List<LtMastValidation> getValidationByTableName(String name) throws ServiceException;

	Long getLtMastVendorManagementsCount(Long vendorId, LtMastVendorManagements input) throws ServiceException;

	List<LtMastVendorManagements> getLtMastVendorManagementsDataTable(Long vendorId, LtMastVendorManagements input) throws ServiceException;

}
