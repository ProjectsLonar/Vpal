package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import com.lonar.vendor.vendorportal.model.LtMastVendors;
import com.lonar.vendor.vendorportal.model.LtVendCompany;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.reports.ReportParameters;

public interface LtVendCompanyDao 
{

	LtVendCompany getLtVendCompanyBycompanyId(Long companyId) throws ServiceException;

	List<LtVendCompany> getAllLtVendCompany() throws ServiceException;

	List<LtVendCompany> getLtVendCompanyLikecompanyName(String companyName) throws ServiceException;

	boolean delete(Long companyId) throws ServiceException;

	Long getCount(Long companyId, LtVendCompany input) throws ServiceException;

	List<LtVendCompany> getDatatableRecords(Long companyId, LtVendCompany input) throws ServiceException;

	boolean update(LtVendCompany ltMastCompany) throws ServiceException;

	LtVendCompany getByCompanyName(LtVendCompany ltMastCompany) throws ServiceException;

	LtVendCompany getByPanNumber(LtVendCompany ltMastCompany) throws ServiceException;

	LtVendCompany getByGstNumber(LtVendCompany ltMastCompany) throws ServiceException;

	boolean save(LtVendCompany ltVendCompany) throws ServiceException;

	List<LtVendCompany> getAllActiveLtVendMastCompany() throws ServiceException;

	boolean deleteAttachment(Long companyId) throws ServiceException;

	List<LtVendCompany> getDataForReport(ReportParameters reportParameters) throws ServiceException;

	String getVendorStatus(Long vendorId) throws ServiceException;

	List<LtMastVendors> getAllActiveVendorsByCompany(Long companyId) throws ServiceException;

	

}
