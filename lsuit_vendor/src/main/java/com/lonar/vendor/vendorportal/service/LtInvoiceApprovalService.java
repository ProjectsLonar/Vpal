package com.lonar.vendor.vendorportal.service;

import com.lonar.vendor.vendorportal.model.InvoiceApproval;
import com.lonar.vendor.vendorportal.model.LtInvoiceApprovalHistory;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

public interface LtInvoiceApprovalService 
{

	Status updateInvoiceStatusApproval(LtInvoiceApprovalHistory approvalHistory) throws ServiceException;

	InvoiceApproval getInvoiceApproval(Long invoiceId, Long apprId) throws ServiceException;

	/*LtVendorApproval getVendorApproval(Long vendorId, Long appId) throws ServiceException;

	List<LtVendorApproval> getVendorApprovalByVendorId(Long vendorId) throws ServiceException;

	List<LtVendorApproval> getInvoiceApprovalByInvoiceId(Long invoiceId) throws ServiceException;*/

}
