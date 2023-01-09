package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import com.lonar.vendor.vendorportal.model.LtMastBranches;
import com.lonar.vendor.vendorportal.model.LtMastCostCenters;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.reports.ReportParameters;


public interface LtMastBranchesDao {
	
	public LtMastBranches findByBranchId(Long branchId) throws ServiceException;

	public List<LtMastBranches> findByBranchCode(String branchCode) throws ServiceException;

	public List<LtMastBranches> findByBranchName(String branchName) throws ServiceException;

	public List<LtMastBranches> findAllActive(Long companyId) throws ServiceException;

	public List<LtMastBranches> findActiveLikeBranchName(String branchName, Long companyId) throws ServiceException;

	public List<LtMastBranches> isFeildsExists(LtMastBranches ltMastBranches) throws ServiceException;
	
	public List<LtMastBranches> updateBranch(LtMastBranches ltMastBranches) throws ServiceException ;

	public List<LtMastBranches> checkAlreadyUsed(LtMastBranches ltMastBranch)throws ServiceException ;

	public List<LtMastBranches> findAll(Long companyId) throws ServiceException ;

	public LtMastBranches getLtMastBranchesByID(Long branchId) throws ServiceException ;

	public Long getCount(Long companyId, LtMastBranches input) throws ServiceException ;

	public List<LtMastBranches> getBranchDataTableRecords(Long companyId, LtMastBranches input) throws ServiceException ;

	public List<LtMastBranches> getAllActiveBillingAddress(Long companyId) throws ServiceException ;

	public List<LtMastBranches> getAllActiveShippingAddress(Long companyId) throws ServiceException ;

	public List<LtMastBranches> getAllActiveBillingAddrByBuyer(Long id) throws ServiceException ;

	public List<LtMastBranches> getAllActiveShippingAddrByBuyer(Long id) throws ServiceException ;

	public List<LtMastBranches> getLtMastBranchesByCompID(Long id) throws ServiceException ;

	public List<LtMastBranches> getLtMastLikeNameByCompanyId(Long id, String trim) throws ServiceException ;

	public LtMastBranches getForAuditByID(Long branchId) throws ServiceException ;

	public List<LtMastBranches> getDataForReport(ReportParameters reportParameters) throws ServiceException ;

}
