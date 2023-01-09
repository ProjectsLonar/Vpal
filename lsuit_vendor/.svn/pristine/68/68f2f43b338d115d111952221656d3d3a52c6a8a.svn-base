package com.lonar.vendor.vendorportal.dao;

import java.util.Date;
import java.util.List;

import com.lonar.vendor.vendorportal.model.InvoiceApproval;
import com.lonar.vendor.vendorportal.model.LtInvoiceApprovalHistory;
import com.lonar.vendor.vendorportal.model.LtVendorApproval;
import com.lonar.vendor.vendorportal.model.ServiceException;

public interface LtInvoiceApprovalDao 
{

	boolean updateStatusApproval(LtInvoiceApprovalHistory approvalHistory) throws ServiceException;

	boolean updateAllStatusApproval(LtInvoiceApprovalHistory approvalHistory) throws ServiceException;

	 List<InvoiceApproval> chkInvoiceEmpApproval(Long employeeId, Long invoiceId) throws ServiceException;

	boolean submitForApproval(Date submissionDate, Long invoiceHeaderId, String status, Date approvedDate, Long lastLogin) throws ServiceException;

	String getCurrLevelByInvoiceApprovalId(Long invoiceApprovalId) throws ServiceException;

	boolean upDateStatus(Long invoiceHeaderId, String noAction, String currentLevel) throws ServiceException;

	InvoiceApproval getInvoiceApproval(Long invoiceId, Long apprId) throws ServiceException;

	

}
