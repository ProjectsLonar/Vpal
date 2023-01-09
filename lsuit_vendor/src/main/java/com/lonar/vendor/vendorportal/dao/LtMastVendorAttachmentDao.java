package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import com.lonar.vendor.vendorportal.model.LtMastVendorAttachment;
import com.lonar.vendor.vendorportal.model.ServiceException;

public interface LtMastVendorAttachmentDao
{
	
	public List<LtMastVendorAttachment> getAllFilesByVendorId(Long vendorId) throws ServiceException;

	boolean delete(String expenseFileUploadId) throws ServiceException;

	public boolean deleteLtMastVendorAttachment(Long expenseFileUploadId)throws ServiceException;

	public boolean deleteLtMastVendorAttachmentFile(Long vendorAttachmentId);

	public LtMastVendorAttachment getAttachmentByVendorIdAndType(Long vendorId) throws ServiceException;

	

}
