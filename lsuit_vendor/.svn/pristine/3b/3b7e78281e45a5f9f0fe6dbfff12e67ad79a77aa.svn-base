package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import com.lonar.vendor.vendorportal.model.LtMastVendorAgreements;
import com.lonar.vendor.vendorportal.model.ServiceException;

public interface LtMastVendorAgreementsDao 
{

	List<LtMastVendorAgreements> getAllVendorAgrrement() throws ServiceException;

	LtMastVendorAgreements getVendorAgreementById(Long vendorAggId) throws ServiceException;

	Long save(LtMastVendorAgreements vendorAggreement) throws ServiceException;

	boolean update(LtMastVendorAgreements vendorAggreement) throws ServiceException;

	boolean delete(Long vendorAgreementId) throws ServiceException;

	List<LtMastVendorAgreements> getAllVendorAgrrementByVendorId(Long vendorId) throws ServiceException;

	boolean deleteByVendor(Long vendorId)  throws ServiceException;

	Long getLtMastVendorAgreementsCount(LtMastVendorAgreements input, Long companyId) throws ServiceException;

	List<LtMastVendorAgreements> getAgreementsDataTable(LtMastVendorAgreements input,Long companyId) throws ServiceException;

	Long getLtMastVendorAgreementsCountByVenId(LtMastVendorAgreements input, Long vendorId) throws ServiceException;

	List<LtMastVendorAgreements> getLtMastVendorAgreementsDataTable(LtMastVendorAgreements input, Long vendorId) throws ServiceException;

	boolean deleteAttachment(Long vendorAgreementId) throws ServiceException;

}
