package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import com.lonar.vendor.vendorportal.model.LtCompanyVenMgmtInclude;
import com.lonar.vendor.vendorportal.model.LtVendCompanyClientDetails;
import com.lonar.vendor.vendorportal.model.ServiceException;

public interface LtVendCompanyClientDetailsDao 
{

	List<LtVendCompanyClientDetails> getBycompanyId(Long companyId) throws ServiceException;

	List<LtVendCompanyClientDetails> getAllActive() throws ServiceException;

	List<LtVendCompanyClientDetails> getAll() throws ServiceException;

	LtVendCompanyClientDetails getById(Long id) throws ServiceException;

	List<LtCompanyVenMgmtInclude> getManagementBycompanyId(Long companyId, Long vendorId) throws ServiceException;

}
