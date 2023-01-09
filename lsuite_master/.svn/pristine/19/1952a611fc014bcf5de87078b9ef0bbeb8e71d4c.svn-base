package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import com.lonar.vendor.vendorportal.model.LtMastTaxes;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.reports.ReportParameters;

public interface LtMastTaxesDao {
	public List<LtMastTaxes> findByTaxName(String taxName) throws ServiceException;
	public List<LtMastTaxes> findByTaxCategoryId(Long taxCategoryId) throws ServiceException;
	public List<LtMastTaxes>	findAllActive(Long companyId) throws ServiceException;
	public List<LtMastTaxes> findActiveLikeTaxName(String taxName, Long companyId) throws ServiceException;
	public LtMastTaxes getById(Long id) throws ServiceException;
	public List<LtMastTaxes> getAll(Long companyId) throws ServiceException;
	public Long getCount(Long companyId, LtMastTaxes input) throws ServiceException;
	public List<LtMastTaxes> getDatatableRecords(Long companyId, LtMastTaxes input) throws ServiceException;
	public List<LtMastTaxes> findByTaxNameAndRate(String taxName, Double taxRate, Long companyId) throws ServiceException;
	public List<LtMastTaxes> getDataForReport(ReportParameters reportParameters) throws ServiceException;
}
