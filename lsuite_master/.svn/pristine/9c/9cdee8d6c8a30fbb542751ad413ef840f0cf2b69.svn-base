package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import com.lonar.vendor.vendorportal.model.LtCompanyVenMgmtAttachment;
import com.lonar.vendor.vendorportal.model.LtMastVendors;
import com.lonar.vendor.vendorportal.model.LtVendCompanyAttachments;
import com.lonar.vendor.vendorportal.model.ServiceException;

public interface LtVendCompanyAttachmentsDao 
{

	List<LtVendCompanyAttachments> getBycompanyId(Long companyId) throws ServiceException;

	LtVendCompanyAttachments getById(Long id) throws ServiceException;

	List<LtVendCompanyAttachments> getAll() throws ServiceException;

	List<LtVendCompanyAttachments> getAllActive() throws ServiceException;

	List<LtCompanyVenMgmtAttachment> getCompanyVendAttachmentByCompanyId(Long companyId) throws ServiceException;

	boolean deleteCompanyVendAttachmentByVendorCompanyId(Long companyId, Long vendorId) throws ServiceException;

	List<LtMastVendors> getVendorsByCompanyId(Long companyId) throws ServiceException;

	boolean deleteVendorAttachment(Long companyId, Long vendorId) throws ServiceException;

	List<LtVendCompanyAttachments> getDifference(Long companyId,Long vendorId) throws ServiceException;

	List<LtCompanyVenMgmtAttachment> getConfigDifference(Long companyId, Long vendorId) throws ServiceException;

	

}
