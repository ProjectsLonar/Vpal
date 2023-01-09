package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import com.lonar.vendor.vendorportal.model.LtCompanyVenMgmtMisc;
import com.lonar.vendor.vendorportal.model.LtVendCompanyMiscellaneous;
import com.lonar.vendor.vendorportal.model.ServiceException;

public interface LtVendCompanyMiscellaneousDao 
{

	LtVendCompanyMiscellaneous getBycompanyId(Long companyId) throws ServiceException;

	List<LtVendCompanyMiscellaneous> getAll() throws ServiceException;

	List<LtVendCompanyMiscellaneous> getAllActive() throws ServiceException;

	LtVendCompanyMiscellaneous getById(Long id) throws ServiceException;

	List<LtCompanyVenMgmtMisc> getCompanyVenMiscellaneousBycompanyId(Long companyId) throws ServiceException;

	boolean deleteMiscQuestions(Long companyId) throws ServiceException;

	List<LtCompanyVenMgmtMisc> getDraftCompanyVenMiscellaneousBycompanyId(Long companyId) throws ServiceException;

}
