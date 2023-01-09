package com.lonar.vendor.vendorportal.service;

import java.util.List;

import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtMastValidation;
import com.lonar.vendor.vendorportal.model.LtMastVendorManagements;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

public interface LtMastVendorManagementsService extends CodeMaster
{

	List<LtMastVendorManagements> getAllVendorManagements() throws ServiceException;

	List<LtMastVendorManagements> getVendorManagementByVenId(Long vendorId) throws ServiceException;

	LtMastVendorManagements getVendorManagementById(Long vendorManagementId) throws ServiceException;

	Status save(LtMastVendorManagements ltMastVendorManagements) throws ServiceException;

	Status update(LtMastVendorManagements ltMastVendorManagements) throws ServiceException;

	Status delete(Long vendorManagementId) throws ServiceException;

	List<LtMastValidation> getValidationByTableName(String name) throws ServiceException;

	Status checkRecord(Long venId) throws ServiceException;

	Long getLtMastVendorManagementsCount(Long vendorId, LtMastVendorManagements input) throws ServiceException;

	List<LtMastVendorManagements> getLtMastVendorManagementsDataTable(Long vendorId, LtMastVendorManagements input) throws ServiceException;

}
