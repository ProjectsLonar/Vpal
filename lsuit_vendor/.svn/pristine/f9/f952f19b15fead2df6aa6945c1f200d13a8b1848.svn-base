package com.lonar.vendor.vendorportal.service;

import java.util.List;

import com.lonar.vendor.vendorportal.model.VendorApproval;
import com.lonar.vendor.vendorportal.model.InvoiceApproval;
import com.lonar.vendor.vendorportal.model.ServiceException;

public interface LtVendorInboxService 
{

	Long getCount(String status1, String approvalId, VendorApproval input) throws ServiceException;

	List<VendorApproval> getByStatus(String status1, String approvalId, VendorApproval input) throws ServiceException;
	
	List<VendorApproval> getVendorApprovalNotification(String status, Long empId) throws ServiceException;

	Long getInvoiceCount(String status1, String approvalId, InvoiceApproval input) throws ServiceException;

	List<InvoiceApproval> getInvoiceByStatus(String status1, String approvalId, InvoiceApproval input) throws ServiceException;

}
