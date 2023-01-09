package com.lonar.vendor.vendorportal.dao;

import com.lonar.vendor.vendorportal.model.ServiceException;

public interface LtMastVendorAgreementAttachmentDao 
{

	boolean multipleSave(Long vendorId,Long vendorAttachmentId, String fileName, String saveAttachmentDirectory) throws ServiceException;

	boolean deleteFile(Long vendorAttachmentId) throws ServiceException;

	boolean multipleUpdate(Long vendorId, Long longValue, String fileName, String saveDirectory) throws ServiceException;
}
