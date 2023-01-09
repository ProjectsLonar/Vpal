package com.lonar.vendor.vendorportal.service;

import java.util.List;

import com.lonar.vendor.vendorportal.model.LtVendorApproval;
import com.lonar.vendor.vendorportal.model.LtVendorApprovalHistory;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

public interface LtVendorApprovalService 
{

	Status updateStatusApproval(LtVendorApprovalHistory approvalHistory) throws ServiceException;

	LtVendorApproval getVendorApproval(Long vendorId, Long appId) throws ServiceException;

	List<LtVendorApproval> getVendorApprovalByVendorId(Long vendorId) throws ServiceException;

	List<LtVendorApproval> getInvoiceApprovalByInvoiceId(Long invoiceId) throws ServiceException;

}
