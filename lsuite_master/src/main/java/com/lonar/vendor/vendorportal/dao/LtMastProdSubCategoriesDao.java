package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import com.lonar.vendor.vendorportal.model.FilterTry;
import com.lonar.vendor.vendorportal.model.LtMastProdSubCategories;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.reports.ReportParameters;

public interface LtMastProdSubCategoriesDao 
{
	public List<LtMastProdSubCategories> findByCategoryId(Long id) throws Exception;

	public List<LtMastProdSubCategories> findCategoryId(Long categoryId) throws Exception; //Created BY : DATTATRAY SALAPE ON 27-05-2017 
	public List<LtMastProdSubCategories>	findAllActive() throws Exception;
	
	public List<LtMastProdSubCategories>	getAll() throws Exception;

	public List<LtMastProdSubCategories> findBySubCategoryName(String name) throws Exception;
		public List<LtMastProdSubCategories> getByProdSubCategory(FilterTry filterOb) throws Exception;
	public List<LtMastProdSubCategories> findLikeSubCategoryName(String name, Long companyId) throws Exception;
	public List<LtMastProdSubCategories> findActiveLikeSubCategoryName(String name) throws Exception;
	public List<LtMastProdSubCategories> 	findActiveLikeSubCategoryNameWithCategoryId(String name,Long categoryId) throws ServiceException;
	//List<LtP2pProdSubcatPayterms> getAllProdSubcatPayterms(Long subprodCatId) throws Exception;
    Long getProdSubcatPaytermsDataTableCount(Long subprodCatId) throws Exception;

	public List<LtMastProdSubCategories> getDataTable(LtMastProdSubCategories input, Long companyId) throws ServiceException;

	//public Long getProdSubcatPaytermsDataTableCount(LtP2pProdSubCategories input) throws ServiceException;

	public Long getCount(LtMastProdSubCategories input, Long companyId) throws ServiceException;

	public LtMastProdSubCategories findActiveLikeSubCategoryCodeWithCategoryId(String subCategoryCode, Long categoryId) throws ServiceException;

	public List<LtMastProdSubCategories> getDataForReport(ReportParameters reportParameters) throws ServiceException;
}
