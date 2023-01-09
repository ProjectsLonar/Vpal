package com.lonar.vendor.vendorportal.dao;

import java.util.Date;
import java.util.List;

import com.lonar.vendor.vendorportal.model.LtVendorApproval;
import com.lonar.vendor.vendorportal.model.LtVendorApprovalHistory;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.reports.LtVendorApprovalSummary;
import com.lonar.vendor.vendorportal.reports.ReportParameters;

public interface LtVendorApprovalDao 
{

	boolean updateStatusApproval(LtVendorApprovalHistory approvalHistory) throws ServiceException;

	boolean updateAllStatusApproval(LtVendorApprovalHistory approvalHistory) throws ServiceException;

	List<LtVendorApproval> chkEmpApproval(Long employeeId, Long vendorId) throws ServiceException;

	LtVendorApproval getVendorApproval(Long vendorId, Long appId) throws ServiceException;

	List<LtVendorApproval> getVendorApprovalByVendorId(Long vendorId) throws ServiceException;

	boolean chkForApprovers(Long vendorId) throws ServiceException;

	boolean submitForApproval(Date submissionDate, Long vendorId, String status, Date approvedDate) throws ServiceException;

	String getCurrLevelByVendorApprovalId(Long vendorApprovalId) throws ServiceException;

	List<LtVendorApproval> chkCurrentApprover(Long vendorId) throws ServiceException;

	boolean updateVendorStatusApproval(LtVendorApprovalHistory approvalHistory) throws ServiceException;

	List<LtVendorApproval> getInvoiceApprovalByInvoiceId(Long invoiceId) throws ServiceException;

	List<LtVendorApprovalSummary> getDataForReport(ReportParameters reportParameters) throws ServiceException;

}
