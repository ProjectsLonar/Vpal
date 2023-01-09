package com.lonar.vendor.vendorportal.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtMastVendorAgreements;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

public interface LtMastVendorAgreementsService extends CodeMaster
{

	List<LtMastVendorAgreements> getAllVendorAgrrement() throws ServiceException;

	LtMastVendorAgreements getVendorAgreementById(Long vendorId) throws ServiceException;

	Status save(LtMastVendorAgreements vendorAggreement) throws ServiceException;

	Status update(LtMastVendorAgreements vendorAggreement ,MultipartFile[] files) throws Exception;

	Status delete(Long vendorAgreementId) throws ServiceException;

	List<LtMastVendorAgreements> getAllVendorAgrrementByVendorId(Long vendorId) throws ServiceException;

	Status saveWithAttachment(LtMastVendorAgreements vendorAggreement, MultipartFile[] files) throws ServiceException;

	Long getLtMastVendorAgreementsCount(LtMastVendorAgreements input, Long companyId) throws ServiceException;

	List<LtMastVendorAgreements> getLtMastVendorAgreementsDataTable(LtMastVendorAgreements input, Long companyId) throws ServiceException;

	Long getLtMastVendorAgreementsCountByVenId(LtMastVendorAgreements input, Long vendorId) throws ServiceException;

	List<LtMastVendorAgreements> getLtMastVendorAgreementsDataTableByVenId(LtMastVendorAgreements input, Long vendorId) throws ServiceException;

	Status deleteAttachment(Long vendorAgreementId) throws ServiceException;

}
