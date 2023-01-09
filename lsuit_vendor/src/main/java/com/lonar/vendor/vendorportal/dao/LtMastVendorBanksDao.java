package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import com.lonar.vendor.vendorportal.model.LtMastVendorBanks;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.reports.ReportParameters;

public interface LtMastVendorBanksDao 
{

	List<LtMastVendorBanks> getAllVendorBanks() throws ServiceException;

	LtMastVendorBanks getVendorBankByBankId(Long vendorBankId) throws ServiceException;

	LtMastVendorBanks getVendorBankByVendorId(Long vendorId) throws ServiceException;

	Long save(LtMastVendorBanks ltMastVendorBanks) throws ServiceException;

	boolean update(LtMastVendorBanks ltMastVendorBanks) throws ServiceException;

	boolean delete(Long vendorBankId) throws ServiceException;

	List<LtMastVendorBanks> findByVendorIdWithAddressId(Long vendorId, Long vendorAddId) throws ServiceException;

	List<LtMastVendorBanks> getAllVendorBankByVendorId(Long vendorId) throws ServiceException;

	boolean deleteByVendorId(Long vendorId) throws ServiceException;

	List<LtMastVendorBanks> getDataForReport(ReportParameters reportParameters) throws ServiceException;

	Long getLtMastVendorBanksCount(Long vendorAddressId, LtMastVendorBanks input) throws ServiceException;

	List<LtMastVendorBanks> getLtMastVendorBanksDataTable(Long vendorAddressId, LtMastVendorBanks input) throws ServiceException;

}
