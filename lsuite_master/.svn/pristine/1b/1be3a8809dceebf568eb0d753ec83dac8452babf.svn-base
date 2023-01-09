package com.lonar.vendor.vendorportal.controller;

import java.util.List;

import javax.validation.Valid;

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
import com.lonar.vendor.vendorportal.model.LtMastProductCategories;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.repository.LtMastProdSubCategoriesRepository;
import com.lonar.vendor.vendorportal.repository.LtMastProductCategoriesRepository;
import com.lonar.vendor.vendorportal.service.LtMastProductCategoriesService;

@RestController
@RequestMapping("/API/productcategories")
public class LtMastProductCategoriesRestController implements CodeMaster {
	
	@Autowired
	LtMastProductCategoriesRepository ltMastProductCategoriesRepository;
	@Autowired
	LtMastProductCategoriesService ltMastProductCategoriesService;
	//@Autowired
	//LtP2pProdSubcatPaytermsRepository ltP2pProdSubcatPaytermsRepository;
	@Autowired
	LtMastProdSubCategoriesRepository ltP2pProdSubCategoriesRepository;
	

	//-------------------------------------------------------------------------------------------------------
		@RequestMapping(value = "/dataTable/{companyId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public CustomeDataTable getDataTable( @PathVariable("companyId") Long companyId,LtMastProductCategories input,@PathVariable("logTime") String logTime) 
		{
			CustomeDataTable customeDataTable = new CustomeDataTable();
			try  {
					Long count=ltMastProductCategoriesService.getCount(input,companyId);
					
				    customeDataTable.setRecordsTotal(count);
				    customeDataTable.setRecordsFiltered(count);
				    
					List<LtMastProductCategories> ltP2pProdCategoriesList= ltMastProductCategoriesService.getDataTable(input,companyId);
					customeDataTable.setData(ltP2pProdCategoriesList);
				
			} 
			catch (Exception e) 
			{		
				e.printStackTrace();
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
			}
		
			return customeDataTable;
		}
		

	// -------------------Retrieve All ProductCategory details-----------------------------
	@RequestMapping(value = "/getAll/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastProductCategories>> listLtMastProductCategoriesAll(@PathVariable("logTime") String logTime) throws ServiceException {
		List<LtMastProductCategories> ltMastProductCategories = null;
		ltMastProductCategories = ltMastProductCategoriesService.findAll();
		return new ResponseEntity<List<LtMastProductCategories>>(ltMastProductCategories, HttpStatus.OK);
	}

	// -------------------Retrieve All Active ProductCategory details-----------------------------
	@RequestMapping(value = "/getAllActive/{companyId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastProductCategories>> listAllActiveLtMastProductCategories(@PathVariable("companyId") Long companyId,@PathVariable("logTime") String logTime) throws Exception {
		List<LtMastProductCategories> ltMastProductCategories = null;
		ltMastProductCategories =  ltMastProductCategoriesService.findAllActive(companyId);
		return new ResponseEntity<List<LtMastProductCategories>>(ltMastProductCategories, HttpStatus.OK);
	}

	// -------------------Retrieve Single ProductCategory details----------------------------
	@RequestMapping(value = "/getByID/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LtMastProductCategories> getLtMastProductCategoriesByID(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException {
		LtMastProductCategories ltMastProductCategories = null;
		ltMastProductCategories = ltMastProductCategoriesService.getById(id);			
		return new ResponseEntity<LtMastProductCategories>(ltMastProductCategories, HttpStatus.OK);
	}

	// -------------------Retrieve Active Like Category Name details----------------------------
	@RequestMapping(value = "/getActiveLikeName/{companyId}/{categoryName}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastProductCategories>> getActiveLikeCategoryName(@PathVariable("categoryName") String categoryName,
			@PathVariable("companyId") Long companyId,@PathVariable("logTime") String logTime) {
		
		List<LtMastProductCategories> ltMastProductCategoriesList = null;
		try {
			
			ltMastProductCategoriesList = ltMastProductCategoriesService.findActiveLikeCategoryName(categoryName.trim(),companyId);
		} catch (Exception e) {
			return new ResponseEntity<List<LtMastProductCategories>>(ltMastProductCategoriesList, HttpStatus.OK);
		}
		return new ResponseEntity<List<LtMastProductCategories>>(ltMastProductCategoriesList, HttpStatus.OK);
	}

	// -------------------Add and Update Product Category Details-----
	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> saveLtMastProductCategories(
			@RequestBody @Valid LtMastProductCategories ltMastProductCategories) throws ServiceException {
		try {
			return ltMastProductCategoriesService.save(ltMastProductCategories);
		}catch(Exception e) {
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
	}

	// -------------------Add and Update Product Category Details-----
	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> updateLtMastProductCategories(@RequestBody @Valid LtMastProductCategories ltMastProductCategories) throws ServiceException {
		try {
			return ltMastProductCategoriesService.update(ltMastProductCategories);
		}catch(Exception e) {
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
		}
	
	// -------------------Delete single Product Category Details-------------------------------
		@RequestMapping(value = "/deleteByID/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Status> deleteLtMastProductCategoriesByID(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException {
			try {
				return ltMastProductCategoriesService.delete(id);
			}catch(Exception e) {
					throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
			}
		}
	
}