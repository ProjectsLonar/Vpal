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
import com.lonar.vendor.vendorportal.model.LtP2pProductPayterms;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.service.LtP2pProductPaytermsService;

@RestController
@RequestMapping("/API/productpayterm")
public class LtMastProductPaytermsRestController implements CodeMaster {
	
	
	
	@Autowired
	LtP2pProductPaytermsService ltP2pProductPaytermsService;
	// -------------------Retrieve All Tax details-----------------------------
		//@PreAuthorize("hasPermission(null, '#/tax/taxes', 'View')")
		@RequestMapping(value = "/getAll/{logTime}", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<LtP2pProductPayterms>> listAll(@PathVariable("logTime") String logTime) throws ServiceException {
			List<LtP2pProductPayterms> list =  ltP2pProductPaytermsService.getAll();
			return new ResponseEntity<List<LtP2pProductPayterms>>(list, HttpStatus.OK);
		}

		

		// -------------------Retrieve All Active Tax details-----------------------------
		//@PreAuthorize("hasPermission(null, '#/tax/taxes', 'View')")
		@RequestMapping(value = "/getAllActive/{logTime}", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<LtP2pProductPayterms>> listAllActive(@PathVariable("logTime") String logTime) throws ServiceException {
			List<LtP2pProductPayterms> list =  ltP2pProductPaytermsService.findAllActive();
			return new ResponseEntity<List<LtP2pProductPayterms>>(list, HttpStatus.OK);		
			}
					
		// -------------------Retrieve Single Tax details----------------------------
		//@PreAuthorize("hasPermission(null, '#/tax/taxes', 'View')")
		@RequestMapping(value = "/getByID/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<LtP2pProductPayterms> getByID(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException {
			LtP2pProductPayterms list =  ltP2pProductPaytermsService.getById(id);
			return new ResponseEntity<LtP2pProductPayterms>(list, HttpStatus.OK);		
		}

		// -------------------Retrieve Single Tax details----------------------------
		//@PreAuthorize("hasPermission(null, '#/tax/taxes', 'View')")
		@RequestMapping(value = "/getByProductID/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<LtP2pProductPayterms>> getByProductID(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException {
			List<LtP2pProductPayterms>  list =  ltP2pProductPaytermsService.findByProductId(id);
			return new ResponseEntity<List<LtP2pProductPayterms>>(list, HttpStatus.OK);			
				}
		
		// -------------------Create and update Tax details-----------------
		//@PreAuthorize("hasPermission(null, '#/tax/taxes', 'Add')")
		@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Status> save(@RequestBody @Valid LtP2pProductPayterms ltP2pProductPayterms) throws ServiceException {
			try {
				return ltP2pProductPaytermsService.save(ltP2pProductPayterms);
			}catch(Exception e) {
					throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
			}
			}
		// -------------------Create and update Tax details-----------------
		//@PreAuthorize("hasPermission(null, '#/tax/taxes', 'Add')")
		@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Status> update(@RequestBody @Valid LtP2pProductPayterms ltP2pProductPayterms) throws ServiceException {
			try {
				return ltP2pProductPaytermsService.update(ltP2pProductPayterms);
			}catch(Exception e) {
					throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
			}
		}
		
		// -------------------Create and update Tax details-----------------
		//@PreAuthorize("hasPermission(null, '#/tax/taxes', 'Add')")
		@RequestMapping(value = "/delete/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Status> delete(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException {
			try {
				return ltP2pProductPaytermsService.delete(id);
			}catch(Exception e) {
					throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
			}
		}

}
