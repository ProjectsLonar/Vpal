package com.lonar.vendor.vendorportal.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.lonar.vendor.vendorportal.model.LtMastProductCategories;
import com.lonar.vendor.vendorportal.model.LtMastProducts;
import com.lonar.vendor.vendorportal.model.LtMastGroupProducts;
import com.lonar.vendor.vendorportal.model.LtMastProductDivisions;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

public interface LtMastProductsService {

	public List<LtMastProducts> findByProductCode(String productCode) throws Exception;

	public List<LtMastProducts> findByProductName(String productName) throws Exception;

	public List<LtMastProducts> findAllActive() throws ServiceException;

	public List<LtMastProducts> findByCategoryIdAndGlAccountId(Long categoryId, Long glaccountId) throws Exception;

	public List<LtMastProducts> findActiveLikeName(String productName, Long companyId) throws ServiceException;

	public List<LtMastProducts> findByGlAccountId(Long glAccountId) throws Exception;

	public List<LtMastProducts> findActiveLikeProductNameWithCategoryId(String productName, long categoryId)
			throws Exception;

	public List<LtMastProductCategories> findLikeProductCategoryLineType(String lineType, String categoryName)
			throws Exception;

	public List<LtMastProducts> findLikeNameWithProductCategory(String productName, Long categoryId) throws Exception;

	public List<LtMastProducts> findBySubCategoryId(Long subProductId) throws Exception;

	public Long getNextCodeSequence() throws Exception;

	public ResponseEntity<List<LtMastProducts>> getAll() throws ServiceException;

	public ResponseEntity<LtMastProducts> findOne(Long id) throws ServiceException;

	public ResponseEntity<Status> save(LtMastProducts ltMastProducts, MultipartFile uploadfile) throws ServiceException;

	public ResponseEntity<Status> saveProductDivision(LtMastProductDivisions ltP2pProductDivisions) throws ServiceException;

	public ResponseEntity<Status> saveGroupProducts(LtMastGroupProducts ltP2pGroupProducts) throws ServiceException;

	public Long getCount(LtMastProducts input, Long companyId) throws ServiceException;

	public List<LtMastProducts> getDataTable(LtMastProducts input, Long companyId) throws ServiceException;

	public ResponseEntity<Status> update(LtMastProducts ltMastProducts, MultipartFile multipartFile) throws ServiceException;

	public ResponseEntity<Status> delete(Long id) throws ServiceException;

	public List<LtMastProducts> listActiveLikeNameByCategory(String trim, Long catId, Long subcatId) throws ServiceException;

}
