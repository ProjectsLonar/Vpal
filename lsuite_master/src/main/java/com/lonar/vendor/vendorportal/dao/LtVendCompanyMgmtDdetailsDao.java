package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import com.lonar.vendor.vendorportal.model.LtCompanyVenMgmtInclude;
import com.lonar.vendor.vendorportal.model.LtVendCompanyMgmtDdetails;
import com.lonar.vendor.vendorportal.model.ServiceException;

public interface LtVendCompanyMgmtDdetailsDao 
{

	List<LtVendCompanyMgmtDdetails> getBycompanyId(Long companyId);

	LtVendCompanyMgmtDdetails getById(Long id);

	List<LtVendCompanyMgmtDdetails> getAll();

	List<LtVendCompanyMgmtDdetails> getAllActive();
	
	List<LtCompanyVenMgmtInclude> getManagementBycompanyId(Long companyId) throws ServiceException;

}
