package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import com.lonar.vendor.vendorportal.model.LtMastProductType;
import com.lonar.vendor.vendorportal.model.ServiceException;

public interface LtMastProductTypeDao {

	Long getCount(LtMastProductType input, Long companyId) throws ServiceException;

	List<LtMastProductType> getDataTable(LtMastProductType input, Long companyId) throws ServiceException;

	LtMastProductType save(LtMastProductType ltMastProductType) throws ServiceException;

	LtMastProductType update(LtMastProductType ltMastProductType) throws ServiceException;

	LtMastProductType delete(Long id) throws ServiceException;

	LtMastProductType findById(Long id) throws ServiceException;

	List<LtMastProductType> getAll() throws ServiceException;

	List<LtMastProductType> getLikeProductType(String name, Long companyId) throws ServiceException;

	List<LtMastProductType> getByProductTypeName(String productTypeName, Long companyId) throws ServiceException;

	List<LtMastProductType> getByProductTypeCode(String productTypeCode, Long companyId) throws ServiceException;

	List<LtMastProductType> getAllActive(Long companyId) throws ServiceException;


}
