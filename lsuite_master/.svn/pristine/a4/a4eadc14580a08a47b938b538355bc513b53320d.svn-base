package com.lonar.vendor.vendorportal.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.lonar.vendor.vendorportal.model.LtMastPositionMaster;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

public interface LtMastPositionMasterService {

	Long getCount(LtMastPositionMaster input, Long companyId) throws ServiceException;

	List<LtMastPositionMaster> getDataTable(LtMastPositionMaster input, Long companyId) throws ServiceException;

	ResponseEntity<Status> save(LtMastPositionMaster ltMastPositionMaster) throws ServiceException;

	ResponseEntity<Status> update(LtMastPositionMaster ltMastPositionMaster) throws ServiceException;

	ResponseEntity<Status> delete(Long id) throws ServiceException;

	LtMastPositionMaster findById(Long id) throws ServiceException;

	List<LtMastPositionMaster> getAll() throws ServiceException;

	List<LtMastPositionMaster> getLikePositionName(String trim, Long companyId) throws ServiceException;

}
