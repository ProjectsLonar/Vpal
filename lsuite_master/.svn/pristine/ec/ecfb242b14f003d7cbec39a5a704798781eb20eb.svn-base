package com.lonar.vendor.vendorportal.service;

import java.util.List;

import com.lonar.vendor.vendorportal.model.LtMastPositionMaster;
import com.lonar.vendor.vendorportal.model.ServiceException;

public interface LtMastPositionMasterDao {

	Long getCount(LtMastPositionMaster input, Long companyId) throws ServiceException;

	List<LtMastPositionMaster> getDataTable(LtMastPositionMaster input, Long companyId) throws ServiceException;

	LtMastPositionMaster save(LtMastPositionMaster ltMastPositionMaster) throws ServiceException;

	LtMastPositionMaster update(LtMastPositionMaster ltMastPositionMaster) throws ServiceException;

	LtMastPositionMaster delete(Long id) throws ServiceException;

	LtMastPositionMaster findById(Long id) throws ServiceException;

	List<LtMastPositionMaster> getAll() throws ServiceException;

	List<LtMastPositionMaster> getLikePositionName(String position, Long companyId) throws ServiceException;

	List<LtMastPositionMaster> getByPositionName(String positionName, Long companyId) throws ServiceException;

	List<LtMastPositionMaster> getByPositionCode(String positionCode, Long companyId) throws ServiceException;

}
