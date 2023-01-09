package com.lonar.vendor.vendorportal.controller;

import java.util.List;

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
import com.lonar.vendor.vendorportal.model.LtMastProdSubcatPayterms;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.service.LtMastProdSubcatPaytermsService;

@RestController
@RequestMapping("/API/payterms")
public class LtMastProdSubcatPaytermsRestController implements CodeMaster{

	@Autowired
	LtMastProdSubcatPaytermsService ltP2pProdSubcatPaytermsService;
	
	@RequestMapping(value = "/getAll/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastProdSubcatPayterms>> getAll(@PathVariable("logTime") String logTime) throws ServiceException {
		List<LtMastProdSubcatPayterms> list =  ltP2pProdSubcatPaytermsService.getAll();
		return new ResponseEntity<List<LtMastProdSubcatPayterms>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getAllActive/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastProdSubcatPayterms>> getAllActive(@PathVariable("logTime") String logTime) throws ServiceException {
		List<LtMastProdSubcatPayterms> list =  ltP2pProdSubcatPaytermsService.getAllActive();
		return new ResponseEntity<List<LtMastProdSubcatPayterms>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getAllBySubCatId/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastProdSubcatPayterms>> getAllBySubCatId(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException {
		List<LtMastProdSubcatPayterms> list =  ltP2pProdSubcatPaytermsService.getAllBySubCatId(id);
		return new ResponseEntity<List<LtMastProdSubcatPayterms>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getLikeTermCat/{category}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastProdSubcatPayterms>> getLikeTermCat(@PathVariable("category") String category,@PathVariable("logTime") String logTime) throws ServiceException {
		List<LtMastProdSubcatPayterms> list =  ltP2pProdSubcatPaytermsService.getLikeTermCat(category);
		return new ResponseEntity<List<LtMastProdSubcatPayterms>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getLikeTermName/{name}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastProdSubcatPayterms>> getLikeTermName(@PathVariable("name") String name,@PathVariable("logTime") String logTime) throws ServiceException {
		List<LtMastProdSubcatPayterms> list =  ltP2pProdSubcatPaytermsService.getLikeTermName(name);
		return new ResponseEntity<List<LtMastProdSubcatPayterms>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getById/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LtMastProdSubcatPayterms> getById(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException {
		LtMastProdSubcatPayterms list =  ltP2pProdSubcatPaytermsService.getById(id);
		return new ResponseEntity<LtMastProdSubcatPayterms>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/savePayterms", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> saveLtP2pProductSubCategoriesPayterms(@RequestBody LtMastProdSubcatPayterms prodSubcatPayterms) throws ServiceException {
		try {
			return ltP2pProdSubcatPaytermsService.save(prodSubcatPayterms);
		}catch(Exception e) {
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
	}

	@RequestMapping(value = "/updatePayterms", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> updateLtP2pProductSubCategoriesPayterms(@RequestBody LtMastProdSubcatPayterms prodSubcatPayterms) throws ServiceException {
		try {
			return ltP2pProdSubcatPaytermsService.update(prodSubcatPayterms);
		}catch(Exception e) {
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
	}
	
	@RequestMapping(value = "/deletePayterms/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> deleteLtP2pProductSubCategoriesPayterms(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException {
		try {
			return ltP2pProdSubcatPaytermsService.delete(id);
		}catch(Exception e) {
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
	}
}
