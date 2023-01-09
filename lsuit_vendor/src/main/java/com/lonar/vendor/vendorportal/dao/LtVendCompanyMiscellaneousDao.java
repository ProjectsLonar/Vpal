package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import com.lonar.vendor.vendorportal.model.LtCompanyVenMgmtMisc;
import com.lonar.vendor.vendorportal.model.LtCompanyVenMgmtMiscQues;
import com.lonar.vendor.vendorportal.model.LtVendCompanyMiscellaneous;
import com.lonar.vendor.vendorportal.model.ServiceException;

public interface LtVendCompanyMiscellaneousDao 
{

	LtVendCompanyMiscellaneous getBycompanyId(Long companyId) throws ServiceException;

	List<LtVendCompanyMiscellaneous> getAll() throws ServiceException;

	List<LtVendCompanyMiscellaneous> getAllActive() throws ServiceException;

	LtVendCompanyMiscellaneous getById(Long id) throws ServiceException;

	LtCompanyVenMgmtMisc getManagementBycompanyId(Long companyId, Long vendorId) throws ServiceException;

	List<LtCompanyVenMgmtMiscQues> getQuestionByCompanyVendor(Long companyId, Long vendorId) throws ServiceException;

	LtVendCompanyMiscellaneous getVendorMasterBycompanyId(Long companyId) throws ServiceException;

}
