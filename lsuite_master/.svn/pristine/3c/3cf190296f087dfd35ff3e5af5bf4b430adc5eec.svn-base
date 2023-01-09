package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import com.lonar.vendor.vendorportal.model.LtMastPositionMaster;
import com.lonar.vendor.vendorportal.model.LtMastUnitMaster;
import com.lonar.vendor.vendorportal.model.ServiceException;

public interface LtMastUnitMasterDao {

	Long getCount(LtMastUnitMaster input, Long companyId) throws ServiceException;

	List<LtMastUnitMaster> getDataTable(LtMastUnitMaster input, Long companyId) throws ServiceException;

	LtMastUnitMaster save(LtMastUnitMaster ltMastUnitMaster) throws ServiceException;

	LtMastUnitMaster update(LtMastUnitMaster ltMastUnitMaster) throws ServiceException;

	LtMastPositionMaster delete(Long id) throws ServiceException;

	LtMastUnitMaster findById(Long id) throws ServiceException;

	List<LtMastUnitMaster> getAll() throws ServiceException;

	List<LtMastUnitMaster> getLikeUnitName(String unit, Long companyId) throws ServiceException;

	List<LtMastUnitMaster> getByUnitName(String unitName, Long companyId) throws ServiceException;

	List<LtMastUnitMaster> getByUnitCode(String unitCode, Long companyId) throws ServiceException;

	List<LtMastUnitMaster> getAllActive(Long companyId) throws ServiceException;

}
