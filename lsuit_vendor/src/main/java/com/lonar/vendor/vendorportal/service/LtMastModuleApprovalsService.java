package com.lonar.vendor.vendorportal.service;

import com.lonar.vendor.vendorportal.model.ServiceException;

public interface LtMastModuleApprovalsService
{

	String checkforApprovals(Long vendorId) throws ServiceException;

}
