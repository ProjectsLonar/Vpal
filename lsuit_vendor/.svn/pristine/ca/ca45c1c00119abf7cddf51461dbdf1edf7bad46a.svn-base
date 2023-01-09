package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.lonar.vendor.vendorportal.model.LtMastProductCategories;
import com.lonar.vendor.vendorportal.model.LtMastProducts;
import com.lonar.vendor.vendorportal.model.ServiceException;

public interface LtMastProductsDao {
	
	public List<LtMastProducts> findByProductCode(String productCode) throws ServiceException;
	public List<LtMastProducts> findByProductName(String productName) throws ServiceException;
	public List<LtMastProducts> findAllActive() throws ServiceException;
	public List<LtMastProducts> findByCategoryIdAndGlAccountId(Long categoryId,Long glaccountId) throws Exception;
	public List<LtMastProducts> findActiveLikeName(String productName) throws ServiceException;
	public List<LtMastProducts> findByGlAccountId(Long glAccountId) throws Exception;
	public List<LtMastProducts> findActiveLikeProductNameWithCategoryId(String productName,long categoryId) throws Exception;
	public	List<LtMastProductCategories> findLikeProductCategoryLineType(String lineType,String categoryName) throws Exception;
	public List<LtMastProducts> findLikeNameWithProductCategory(String productName,Long categoryId) throws Exception;
	public List<LtMastProducts> findBySubCategoryId(Long subCategoryId) throws Exception;
	public Long getNextCodeSequence() throws Exception;
	public ResponseEntity<List<LtMastProducts>> getAll() throws ServiceException;
	public LtMastProducts findOne(Long id) throws ServiceException;
	public Long getCount(LtMastProducts input) throws ServiceException;
	public List<LtMastProducts> getDataTable(LtMastProducts input) throws ServiceException;
	
}
