package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import com.lonar.vendor.vendorportal.model.LtMastBranches;
import com.lonar.vendor.vendorportal.model.ServiceException;


public interface LtMastBranchesDao {
	
	public LtMastBranches findByBranchId(Long branchId) throws ServiceException;

	public List<LtMastBranches> findByBranchCode(String branchCode) throws ServiceException;

	public List<LtMastBranches> findByBranchName(String branchName) throws ServiceException;

	public List<LtMastBranches> findAllActive() throws ServiceException;

	public List<LtMastBranches> findActiveLikeBranchName(String branchName) throws ServiceException;

	public List<LtMastBranches> isFeildsExists(LtMastBranches ltMastBranches) throws ServiceException;
	
	public List<LtMastBranches> updateBranch(LtMastBranches ltMastBranches) throws ServiceException ;

	public List<LtMastBranches> checkAlreadyUsed(LtMastBranches ltMastBranch)throws ServiceException ;

	public List<LtMastBranches> findAll() throws ServiceException ;

	public LtMastBranches getLtMastBranchesByID(Long branchId) throws ServiceException ;

	public Long getCount(LtMastBranches input) throws ServiceException ;

	public List<LtMastBranches> getBranchDataTableRecords(LtMastBranches input) throws ServiceException ;
}
