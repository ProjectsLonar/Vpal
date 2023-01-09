package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import com.lonar.vendor.vendorportal.model.LtMastTaxes;
import com.lonar.vendor.vendorportal.model.ServiceException;

public interface LtMastTaxesDao {
	public List<LtMastTaxes> findByTaxName(String taxName) throws ServiceException;
	public List<LtMastTaxes> findByTaxCategoryId(Long taxCategoryId) throws ServiceException;
	public List<LtMastTaxes>	findAllActive() throws ServiceException;
	public List<LtMastTaxes> findActiveLikeTaxName(String taxName) throws ServiceException;
	public LtMastTaxes getById(Long id) throws ServiceException;
	public List<LtMastTaxes> getAll() throws ServiceException;
	public Long getCount(LtMastTaxes input) throws ServiceException;
	public List<LtMastTaxes> getDatatableRecords(LtMastTaxes input) throws ServiceException;
}
