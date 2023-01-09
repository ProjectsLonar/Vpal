package com.lonar.vendor.vendorportal.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.lonar.vendor.vendorportal.model.CustomeDataTable;
import com.lonar.vendor.vendorportal.model.FilterTry;
import com.lonar.vendor.vendorportal.model.LtMastProdSubCategories;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

public interface LtMastProdSubCategoriesService 
{

	public  LtMastProdSubCategories  findByCategoryId(Long id) throws Exception;
	public  LtMastProdSubCategories  findByPaytermId(Long id) throws Exception;
	public List<LtMastProdSubCategories>	findAllActive() throws Exception;
	
	public List<LtMastProdSubCategories>	getAll() throws Exception;
	public List<LtMastProdSubCategories> findBySubCategoryName(String name) throws Exception;
	
	public List<LtMastProdSubCategories> findLikeSubCategoryName(String name) throws Exception;
	public List<LtMastProdSubCategories> getByProdSubCategory(FilterTry filterOb) throws Exception;
	public List<LtMastProdSubCategories> findActiveLikeSubCategoryName(String name) throws Exception;
	public List<LtMastProdSubCategories> findActiveLikeSubCategoryNameWithCategoryId(String name, Long categoryId) throws ServiceException;
	public List<LtMastProdSubCategories> findCategoryId(Long categoryId) throws Exception; //Created BY : DATTATRAY SALAPE ON 27-05-2017 
	public CustomeDataTable getDataTabledetails(Long approvalId) throws Exception;
	public ResponseEntity<Status> save(LtMastProdSubCategories ltMastProdSubCategories) throws ServiceException;
	public ResponseEntity<Status> update(LtMastProdSubCategories ltMastProdSubCategories) throws ServiceException;
	public ResponseEntity<Status> delete(Long id) throws ServiceException;
	public Long getCount(LtMastProdSubCategories input) throws ServiceException;
	public List<LtMastProdSubCategories> getDataTable(LtMastProdSubCategories input) throws ServiceException;
	public List<LtMastProdSubCategories> getLikeSubCategoryNameAndCategory(String trim, String id)  throws ServiceException;
}
