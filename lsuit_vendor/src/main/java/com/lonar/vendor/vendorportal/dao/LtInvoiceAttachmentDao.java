package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import com.lonar.vendor.vendorportal.model.LtInvoiceAttachment;
import com.lonar.vendor.vendorportal.model.ServiceException;

public interface LtInvoiceAttachmentDao
{
	public List<LtInvoiceAttachment> getAllFilesByInvoiceId(Long vendorId) throws ServiceException;
	
	public LtInvoiceAttachment getAttachmentByInvoiceIdAndType(Long invoiceId) throws ServiceException;
	
	public boolean deleteLtMastInvoiceAttachmentFile(Long invoiceAttachmentId);

	/*boolean delete(String expenseFileUploadId) throws ServiceException;

	public boolean deleteLtMastVendorAttachment(Long expenseFileUploadId)throws ServiceException;


	*/

}
