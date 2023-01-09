package com.lonar.vendor.vendorportal.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lonar.vendor.vendorportal.model.BusinessException;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtMastProductDivisions;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.service.LtMastProductDivisionsService;

@RestController
@RequestMapping("/API/productdivision")
public class LtMastProductDivisionsRestController implements CodeMaster{
	final String restBaseUrl = "/API/productdivision";
	static final Logger logger = Logger.getLogger(LtMastProductDivisionsRestController.class);
	
	@Autowired
	LtMastProductDivisionsService ltP2pProductDivisionsService;
	

	
	// -------------------Retrieve All Product division details-----------------------------
	//@PreAuthorize("hasPermission(null, '#/product/product', 'View')")
	@RequestMapping(value = "/getAll/{logTime}", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastProductDivisions>> listLtP2pProductDivisionsAll(@PathVariable("logTime") String logTime) throws ServiceException {
		return (ResponseEntity<List<LtMastProductDivisions>>) ltP2pProductDivisionsService.getAll();
	
	}
	
	// -------------------Retrieve All Product division details-----------------------------
		//@PreAuthorize("hasPermission(null, '#/product/product', 'View')")
		@RequestMapping(value = "/getAllByProductId/{id}/{logTime}", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<LtMastProductDivisions>> listLtP2pProductDivisionsAllByProdId(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException {
			List<LtMastProductDivisions> list =  ltP2pProductDivisionsService.findByProductId(id);
			return new ResponseEntity<List<LtMastProductDivisions>>(list, HttpStatus.OK);
		}
	// -------------------Retrieve All Active Product division details-----------------------------
	//@PreAuthorize("hasPermission(null, '#/product/product', 'View')")
	@RequestMapping(value = "/getAllActive/{logTime}", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastProductDivisions>> listAllActiveLtP2pProductDivisions(@PathVariable("logTime") String logTime) throws ServiceException {
		return (ResponseEntity<List<LtMastProductDivisions>>) ltP2pProductDivisionsService.findAllActive();
	
			}
			
	// -------------------Retrieve Single Product division details----------------------------
	//@PreAuthorize("hasPermission(null, '#/product/product', 'View')")
	@RequestMapping(value = "/getByID/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LtMastProductDivisions> getLtP2pProductDivisionsByID(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException {
		LtMastProductDivisions ltP2pProductDivisions =  ltP2pProductDivisionsService.getById(id);
		return new ResponseEntity<LtMastProductDivisions>(ltP2pProductDivisions, HttpStatus.OK);
	}

	
	// -------------------Create and save Product division details-----------------
	//@PreAuthorize("hasPermission(null, '#/product/product', 'Add')")
	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> saveLtP2pProductDivisions(@RequestBody @Valid LtMastProductDivisions ltP2pProductDivisions) throws ServiceException {
		try {
			return ltP2pProductDivisionsService.save(ltP2pProductDivisions);
		}catch(Exception e) {
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
	}
	
	// -------------------Create and save Product division details-----------------
	//@PreAuthorize("hasPermission(null, '#/product/product', 'Add')")
	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> updateLtP2pProductDivisions(@RequestBody @Valid LtMastProductDivisions ltP2pProductDivisions, BindingResult bindingResult) throws ServiceException {
		try {
			return ltP2pProductDivisionsService.update(ltP2pProductDivisions);	
		}catch(Exception e) {
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
	}
	
	// -------------------Delete Single Product division details----------------------------
	//@PreAuthorize("hasPermission(null, '#/product/product', 'Delete')")
	@RequestMapping(value = "/deleteByID/{id}/{logTime}", method = RequestMethod.GET, produces = 		MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> deleteLtP2pProductDivisionsByID(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException {
		try {
			return ltP2pProductDivisionsService.delete(id);	
		}catch(Exception e) {
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
	}


}