package com.lonar.vendor.vendorportal.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import com.lonar.vendor.vendorportal.model.LtMastBranches;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;


public interface LtMastBranchesService {

	public List<LtMastBranches> findByBranchCode(String branchCode) throws ServiceException;

	public List<LtMastBranches> findByBranchName(String branchName) throws ServiceException;

	public List<LtMastBranches> findAllActive() throws ServiceException;

	public List<LtMastBranches> findActiveLikeBranchName(String branchName) throws ServiceException;

	public String isFeildsExists(LtMastBranches ltMastBranches) throws ServiceException;
	
	public List<LtMastBranches> updateBranches(LtMastBranches ltMastBranches) throws ServiceException;
	
	public String isGstExists(LtMastBranches ltMastBranches) throws ServiceException;

	public List<LtMastBranches> checkAlreadyUsed(LtMastBranches ltMastBranch) throws ServiceException;

	public List<LtMastBranches> findAll() throws ServiceException;

	public LtMastBranches getLtMastBranchesByID(Long  branchId) throws ServiceException;

	public Long getCount(LtMastBranches input) throws ServiceException;

	public List<LtMastBranches> getBranchDataTableRecords(LtMastBranches input) throws ServiceException;

	public ResponseEntity<Status> save(LtMastBranches ltMastBranches, BindingResult bindingResult) throws ServiceException;

	public ResponseEntity<Status> update(LtMastBranches ltMastBranches) throws ServiceException;

	public ResponseEntity<Status> delete(String id) throws ServiceException;
}
