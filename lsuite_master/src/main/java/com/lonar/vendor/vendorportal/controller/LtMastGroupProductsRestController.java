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

import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtMastGroupProducts;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.service.LtMastGroupProductsService;

@RestController
@RequestMapping("/API/groupproducts")
public class LtMastGroupProductsRestController  implements CodeMaster{
	final String restBaseUrl = "/API/groupproducts";
	static final Logger logger = Logger.getLogger(LtMastGroupProductsRestController.class);
	
	@Autowired
	LtMastGroupProductsService ltP2pGroupProductsService;
	

	 
	/*@PreAuthorize("hasPermission(null, '#/product/product', 'View')")
	@JsonView(DataTablesOutput.View.class)
	@RequestMapping(value = "/dataTable", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public DataTablesOutput<LtP2pGroupProducts> getLtP2pGroupProductsDataTable(@Valid DataTablesInput input) {
		String apiUrl = "/dataTable";
		DataTablesOutput<LtP2pGroupProducts> ltP2pGroupProducts = ltP2pGroupProductsRepository.findAll(input);
		String startDate = "";
		String endDate = "";
		if (input.getColumn("startDate")!=null)
			startDate = input.getColumn("startDate").getSearch().getValue();
		if (input.getColumn("endDate")!=null)
			endDate = input.getColumn("endDate").getSearch().getValue();
		if (startDate.length() == 0 && endDate.length() == 0)
			ltP2pGroupProducts = ltP2pGroupProductsRepository.findAll(input);
		else {

			Specification<LtP2pGroupProducts> sp = new UserSpecification<LtP2pGroupProducts>()
					.ltP2pUsersWithDateRange(startDate, endDate);
			input.getColumn("startDate").setSearchable(false);
			input.getColumn("startDate").getSearch().setValue("");
			input.getColumn("endDate").setSearchable(false);
			input.getColumn("endDate").getSearch().setValue("");
			ltP2pGroupProducts = ltP2pGroupProductsRepository.findAll(input, sp);
		}
		List<LtP2pGroupProducts> ltP2pGroupProductsList = ltP2pGroupProducts.getData();
		for (LtP2pGroupProducts ltP2pGroupProducts2 : ltP2pGroupProductsList) {
			LtP2pProducts ltP2pProducts = new LtP2pProducts();
			if (!Objects.isNull(ltP2pGroupProducts2.getParentProductId())
					|| ltP2pGroupProducts2.getParentProductId() != 0L)
				if (ltP2pGroupProductsRepository.exists(ltP2pGroupProducts2.getParentProductId()))
					ltP2pProducts = ltP2pProductsRepository.findOne(ltP2pGroupProducts2.getParentProductId());
			if (ltP2pProducts != null) {
				ltP2pGroupProducts2.setProductCode(ltP2pProducts.getProductCode());
				ltP2pGroupProducts2.setProductName(ltP2pProducts.getProductName());
				ltP2pGroupProducts2.setUOM(ltP2pProducts.getUom());
			}

		}
		ltP2pGroupProducts.setData(ltP2pGroupProductsList);
		return ltP2pGroupProducts;
	}*/
	

	// -------------------Retrieve All GroupProduct details-----------------------------
	@RequestMapping(value = "/getAll/{logTime}", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastGroupProducts>> listLtP2pGroupProductsAll(@PathVariable("logTime") String logTime) throws ServiceException {
		return (ResponseEntity<List<LtMastGroupProducts>>) ltP2pGroupProductsService.getAll();
		
	}
	
	// -------------------Retrieve All Active GroupProduct details-----------------------------
	@RequestMapping(value = "/getAllActive/{logTime}", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastGroupProducts>> listAllActiveLtP2pGroupProducts(@PathVariable("logTime") String logTime) throws ServiceException {
		return (ResponseEntity<List<LtMastGroupProducts>>) ltP2pGroupProductsService.findAllActive();
				
			}
			
	// -------------------Retrieve Single GroupProduct details----------------------------
	@RequestMapping(value = "/getByID/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LtMastGroupProducts> getLtP2pGroupProductsByID(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException {
		LtMastGroupProducts ltP2pGroupProducts =   ltP2pGroupProductsService.getById(id);
		return new ResponseEntity<LtMastGroupProducts>(ltP2pGroupProducts, HttpStatus.OK);
		
	}

		@RequestMapping(value = "/getByParentProductID/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<LtMastGroupProducts>> getLtP2pGroupProductsByProductID(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException {
			List<LtMastGroupProducts> ltP2pGroupProducts =   ltP2pGroupProductsService.findByParentProductId(id);
			return new ResponseEntity<List<LtMastGroupProducts>>(ltP2pGroupProducts, HttpStatus.OK);
		}
	//-------------------------------------------------------------------------------------	
		@RequestMapping(value = "/saveGroupProducts", method = RequestMethod.POST , consumes = 		MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Status> saveGroupProducts(@RequestBody LtMastGroupProducts ltP2pGroupProducts) throws ServiceException {
				return ltP2pGroupProductsService.saveGroupProducts(ltP2pGroupProducts);
		}
	
		//-------------------------------------------------------------------------------------	
		@RequestMapping(value = "/updateGroupProducts", method = RequestMethod.POST , consumes = 		MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Status> updateGroupProducts(@RequestBody LtMastGroupProducts ltP2pGroupProducts) throws ServiceException {
					return ltP2pGroupProductsService.updateGroupProducts(ltP2pGroupProducts);
			}
	
	// -------------------Delete Single GroupProduct details----------------------------
	@RequestMapping(value = "/deleteByID/{id}/{logTime}", method = RequestMethod.GET, produces = 		MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> deleteLtP2pGroupProductsByID(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) throws ServiceException {
		return ltP2pGroupProductsService.deleteGroupProducts(id);
		
	}

}