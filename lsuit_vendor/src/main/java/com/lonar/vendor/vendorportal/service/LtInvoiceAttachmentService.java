package com.lonar.vendor.vendorportal.service;

import java.util.List;

import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtInvoiceAttachment;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

public interface LtInvoiceAttachmentService extends CodeMaster
{
	
	public List<LtInvoiceAttachment> getAllFilesByInvoiceHeaderId(Long invoiceId) throws ServiceException;
	
	public LtInvoiceAttachment getAttachmentByInvoiceIdAndType(Long invoiceId) throws ServiceException;
	
	public Status deleteLtMastVendorAttachmentFile(Long invoiceAttachmentId);

	/*Status delete(String expenceHeaderId) throws ServiceException;

	public Status deleteLtMastVendorAttachment(Long expenseFileUploadId)throws ServiceException;

	public ResponseEntity<Status> saveAttachments(String apiUrl, String[] names, String ltMastVendorAttachment,MultipartFile[] files);

	public Status deleteLtMastVendorAttachmentFile(Long vendorAttachmentId);

	*/

	

}
