package com.lonar.vendor.vendorportal.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.lonar.vendor.vendorportal.model.LtMastUnitMaster;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

public interface LtMastUnitMasterService {

	Long getCount(LtMastUnitMaster input, Long companyId) throws ServiceException;

	List<LtMastUnitMaster> getDataTable(LtMastUnitMaster input, Long companyId) throws ServiceException;

	ResponseEntity<Status> save(LtMastUnitMaster ltMastUnitMaster) throws ServiceException;

	ResponseEntity<Status> update(LtMastUnitMaster ltMastUnitMaster) throws ServiceException;

	ResponseEntity<Status> delete(Long id) throws ServiceException;

	LtMastUnitMaster findById(Long id) throws ServiceException;

	List<LtMastUnitMaster> getAll() throws ServiceException;

	List<LtMastUnitMaster> getLikeUnitName(String trim, Long companyId) throws ServiceException;

	List<LtMastUnitMaster> getAllActive(Long companyId) throws ServiceException;

	

}
