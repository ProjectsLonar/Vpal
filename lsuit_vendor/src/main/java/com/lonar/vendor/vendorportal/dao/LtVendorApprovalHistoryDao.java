package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import com.lonar.vendor.vendorportal.model.LtVendorApprovalHistory;
import com.lonar.vendor.vendorportal.model.ServiceException;

public interface LtVendorApprovalHistoryDao {

	boolean save(LtVendorApprovalHistory approvalHistory) throws ServiceException;

	List<LtVendorApprovalHistory> getVendorApprovalHistoryByVendorId(Long vendorId) throws ServiceException;

}
