package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import com.lonar.vendor.vendorportal.model.LtMastPersonType;
import com.lonar.vendor.vendorportal.model.ServiceException;

public interface LtMastPersonTypeDao {

	Long getCount(LtMastPersonType input, Long companyId) throws ServiceException;

	List<LtMastPersonType> getDataTable(LtMastPersonType input, Long companyId) throws ServiceException;

	LtMastPersonType save(LtMastPersonType ltMastPersonType) throws ServiceException;

	LtMastPersonType update(LtMastPersonType ltMastPersonType) throws ServiceException;

	LtMastPersonType delete(Long id) throws ServiceException;

	LtMastPersonType findById(Long id) throws ServiceException;

	List<LtMastPersonType> getAll() throws ServiceException;

	List<LtMastPersonType> getLikePersonTypeName(String personType, Long companyId) throws ServiceException;

	List<LtMastPersonType> getByPersonTypeName(String personTypeName, Long companyId) throws ServiceException;

	List<LtMastPersonType> getByPersonTypeCode(String personTypeCode, Long companyId) throws ServiceException;

	List<LtMastPersonType> getAllActive(Long companyId) throws ServiceException;


}
