package com.lonar.vendor.vendorportal.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lonar.vendor.vendorportal.model.BusinessException;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.CustomeDataTable;
import com.lonar.vendor.vendorportal.model.FilterTry;
import com.lonar.vendor.vendorportal.model.LtMastProdSubCategories;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.repository.LtMastGlAccountsRepository;
import com.lonar.vendor.vendorportal.repository.LtMastProductCategoriesRepository;
import com.lonar.vendor.vendorportal.repository.LtMastProdSubCategoriesRepository;
import com.lonar.vendor.vendorportal.service.LtMastProdSubCategoriesService;


@RestController
@RequestMapping("/API/prodsubcategories")
public class LtMastProdSubCategoriesRestController implements CodeMaster{

	final String restBaseUrl = "/API/prodsubcategories";
	static final Logger logger = Logger.getLogger(LtMastProdSubCategoriesRestController.class);
	
	@Autowired
	LtMastProdSubCategoriesRepository  ltP2pProdSubCategoriesRepository;
	
	@Autowired
	LtMastProdSubCategoriesService ltP2pProdSubCategoriesService;
	
	@Autowired
	LtMastGlAccountsRepository ltP2pGlAccountsRepository;
	
	@Autowired
	LtMastProductCategoriesRepository ltP2pProductCategoriesRepository;
	
	//-------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/dataTable/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomeDataTable getDataTable( @PathVariable("id") Long companyId,LtMastProdSubCategories input,@PathVariable("logTime") String logTime) 
	{
		CustomeDataTable customeDataTable = new CustomeDataTable();
		try  {
				Long count=ltP2pProdSubCategoriesService.getCount(input,companyId);
				
			    customeDataTable.setRecordsTotal(count);
			    customeDataTable.setRecordsFiltered(count);
			    
				List<LtMastProdSubCategories> ltP2pProdSubCategoriesList= ltP2pProdSubCategoriesService.getDataTable(input,companyId);
				
				customeDataTable.setData(ltP2pProdSubCategoriesList);
			
		} 
		catch (Exception e) 
		{		
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
	
		return customeDataTable;
	}
	
		@RequestMapping(value = "/datatablerows/{subCatId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public CustomeDataTable getDataTable(@PathVariable("subCatId") Long subCatId,@PathVariable("logTime") String logTime) {
			CustomeDataTable dataTable = new CustomeDataTable();
			try {
				dataTable = ltP2pProdSubCategoriesService.getDataTabledetails(subCatId);
				return dataTable;
			} catch (Exception e) {
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
			}
		}
		
		// -------------------Add and Update Product Category Details-------------------------------------------
		
		@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Status> saveLtP2pProductSubCategories(@RequestBody LtMastProdSubCategories ltMastProdSubCategories) throws ServiceException 
		{
			try {
				return ltP2pProdSubCategoriesService.save(ltMastProdSubCategories);	
			}catch(Exception e) {
					throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
			}
				
		}
		//------------------------------------------------------------------------------------------------------
		@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Status> updateLtP2pProductSubCategories(@RequestBody LtMastProdSubCategories ltMastProdSubCategories) throws ServiceException 
		{
			try {
				return ltP2pProdSubCategoriesService.update(ltMastProdSubCategories);	
			}catch(Exception e) {
					throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
			}
				
		}
		
		// -------------------Delete single Product Sub Category Details-------------------------------
		@RequestMapping(value = "/deleteByID/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Status> deleteLtP2pProdSubCategoriesByID(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException 
		{
			try {
				return ltP2pProdSubCategoriesService.delete(id);
			}catch(Exception e) {
					throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
			}
		}	
		// -------------------Retrieve Single Products----------------------------

		@RequestMapping(value = "/getbyproudsubcategory/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<LtMastProdSubCategories> getLtP2pProductsSubCategoryByID(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) {
			LtMastProdSubCategories ltP2pProdSubCategories = null;
			try {
					ltP2pProdSubCategories = ltP2pProdSubCategoriesService.findByCategoryId(id);
					return new ResponseEntity<LtMastProdSubCategories>(ltP2pProdSubCategories, HttpStatus.OK);
				}catch (Exception e) {
					e.printStackTrace();
					return new ResponseEntity<LtMastProdSubCategories>(ltP2pProdSubCategories, HttpStatus.OK);
			}
		}
		
		//------------------------------------------------------------------------------------------------
		@RequestMapping(value = "/getAll/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<LtMastProdSubCategories>> getAll(@PathVariable("logTime") String logTime){
			List<LtMastProdSubCategories> ltP2pProdSubCategories = null;
			try {
					ltP2pProdSubCategories = ltP2pProdSubCategoriesService.getAll();
					return new ResponseEntity<List<LtMastProdSubCategories>>(ltP2pProdSubCategories, HttpStatus.OK);
			}  catch (Exception e)  {
				return new ResponseEntity<List<LtMastProdSubCategories>>(ltP2pProdSubCategories, HttpStatus.OK);
			}
		}
		
		//---------------------------------------------------------------------------------------------------------
		@RequestMapping(value = "/getLikeName/{companyId}/{subcategoryName}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<LtMastProdSubCategories>> getLikeSubCategoryName(@PathVariable("subcategoryName") String subCategoryName,
				@PathVariable("companyId") Long companyId,@PathVariable("logTime") String logTime){
			List<LtMastProdSubCategories> ltP2pProdSubCategoriesList = null;
			try {
				ltP2pProdSubCategoriesList = ltP2pProdSubCategoriesService.findLikeSubCategoryName(subCategoryName.trim(),companyId);
				return new ResponseEntity<List<LtMastProdSubCategories>>(ltP2pProdSubCategoriesList, HttpStatus.OK);
			} catch(Exception e) {
			return new ResponseEntity<List<LtMastProdSubCategories>>(ltP2pProdSubCategoriesList, HttpStatus.OK);
			}
		}
		
		//---------------------------------------------------------------------------------------------------------
		@RequestMapping(value = "/getLikeNameandcategory/{id}/{subcategoryName}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<LtMastProdSubCategories>> getLikeSubCategoryNameAndCategory(@PathVariable("subcategoryName") String subCategoryName,
				@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException{
		List<LtMastProdSubCategories> ltP2pProdSubCategoriesList =
				ltP2pProdSubCategoriesService.findActiveLikeSubCategoryNameWithCategoryId(subCategoryName.trim(),id);
				return new ResponseEntity<List<LtMastProdSubCategories>>(ltP2pProdSubCategoriesList, HttpStatus.OK);
			
	
		}
	//----------------------------------------------------------------------------------------------------------------------
		@RequestMapping(value = "/getByProdSubCategory", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<LtMastProdSubCategories>> getByProdSubCategory(@RequestBody FilterTry filterOb) {
			List<LtMastProdSubCategories> ltP2pProdSubCategoriesList = null;
			try {
				ltP2pProdSubCategoriesList = ltP2pProdSubCategoriesService.getByProdSubCategory(filterOb);
				return new ResponseEntity<List<LtMastProdSubCategories>>(ltP2pProdSubCategoriesList, HttpStatus.OK);
			} catch(Exception e) {
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
			}
		}
		
				
				
}
