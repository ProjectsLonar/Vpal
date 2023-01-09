package com.lonar.vendor.vendorportal.service;

import java.util.List;

import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtMastVendorBanks;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

public interface LtMastVendorBanksService extends CodeMaster
{

	List<LtMastVendorBanks> getAllVendorBanks() throws ServiceException ;

	LtMastVendorBanks getVendorBankByBankId(Long vendorBankId) throws ServiceException ;

	LtMastVendorBanks getVendorBankByVendorId(Long vendorId) throws ServiceException;

	Status save(LtMastVendorBanks ltMastVendorBanks) throws ServiceException;

	Status update(LtMastVendorBanks ltMastVendorBanks) throws ServiceException;

	Status delete(Long vendorBankId) throws ServiceException;

	List<LtMastVendorBanks> findByVendorIdWithAddressId(Long vendorId, Long vendorAddId) throws ServiceException;

	Long getLtMastVendorBanksCount(Long vendorAddressId, LtMastVendorBanks input) throws ServiceException;

	List<LtMastVendorBanks> getLtMastVendorBanksDataTable(Long vendorAddressId, LtMastVendorBanks input) throws ServiceException;

}
