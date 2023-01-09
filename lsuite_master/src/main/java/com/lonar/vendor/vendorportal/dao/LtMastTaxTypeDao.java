package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import com.lonar.vendor.vendorportal.model.LtMastTaxType;
import com.lonar.vendor.vendorportal.model.ServiceException;

public interface LtMastTaxTypeDao {

	Long getCount(LtMastTaxType input, Long companyId) throws ServiceException;

	List<LtMastTaxType> getDataTable(LtMastTaxType input, Long companyId) throws ServiceException;

	LtMastTaxType save(LtMastTaxType ltMastTaxType) throws ServiceException;

	LtMastTaxType update(LtMastTaxType ltMastTaxType) throws ServiceException;

	LtMastTaxType delete(Long id) throws ServiceException;

	LtMastTaxType findById(Long id) throws ServiceException;

	List<LtMastTaxType> getAll() throws ServiceException;

	List<LtMastTaxType> getLikeTaxName(String name, Long companyId) throws ServiceException;

	List<LtMastTaxType> getByTaxTypeName(String taxTypeName, Long companyId)  throws ServiceException;

	List<LtMastTaxType> getByTaxTypeCode(String taxTypeCode, Long companyId) throws ServiceException;

}
