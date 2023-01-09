package com.lonar.vendor.vendorportal.dao;

import com.lonar.vendor.vendorportal.model.LtInvoiceApprovalHistory;
import com.lonar.vendor.vendorportal.model.LtVendorApprovalHistory;
import com.lonar.vendor.vendorportal.model.ServiceException;

public interface LtMastModuleApprovalsDao 
{

	String checkforApprovals(Long vendorId) throws ServiceException;

	boolean chkIsAprovedByAnyOne(LtVendorApprovalHistory approvalHistory) throws ServiceException;
	
	boolean chkInvoiceIsAprovedByAnyOne(LtInvoiceApprovalHistory approvalHistory) throws ServiceException;
	
	

}
