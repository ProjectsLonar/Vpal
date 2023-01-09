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

import com.lonar.vendor.vendorportal.model.CustomeDataTable;
import com.lonar.vendor.vendorportal.model.DashboardDetails;
import com.lonar.vendor.vendorportal.model.LtPoHeaders;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.service.LtPoHeadersService;

@RestController
@RequestMapping("/API/poheader")
public class LtMastPoHeadersRestController {

	@Autowired
	LtPoHeadersService ltPoHeadersService;

	@RequestMapping(value = "/dataTable/{companyId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomeDataTable getLtMastVendorsDataTable(LtPoHeaders input,@PathVariable("companyId") Long companyId,@PathVariable("logTime") String logTime) {
		CustomeDataTable customeDataTable = new CustomeDataTable();
		try {
			Long count = ltPoHeadersService.getLtPoHeaderCount(input,companyId);
			customeDataTable.setRecordsTotal(count);
			customeDataTable.setRecordsFiltered(count);
			List<LtPoHeaders> ltMastCommonMessageList = ltPoHeadersService.getLtPoHeaderDataTable(input,companyId);
			customeDataTable.setData(ltMastCommonMessageList);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return customeDataTable;

	}

	@RequestMapping(value = "/dataTableByVendor/{venId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomeDataTable getLtMastVendorsDataTableByVendorId(LtPoHeaders input, @PathVariable("venId") Long venId,@PathVariable("logTime") String logTime) {
		CustomeDataTable customeDataTable = new CustomeDataTable();
		try {
			Long count = ltPoHeadersService.getLtPoHeaderCountByVendorId(input, venId);
			customeDataTable.setRecordsTotal(count);
			customeDataTable.setRecordsFiltered(count);
			List<LtPoHeaders> ltMastCommonMessageList = ltPoHeadersService.getLtPoHeadersDataTableByVendorId(input,
					venId);
			customeDataTable.setData(ltMastCommonMessageList);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return customeDataTable;

	}

	@RequestMapping(value = "/viewfile/{name}/{logTime}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Status> viewFile(@PathVariable("name") String name,@PathVariable("logTime") String logTime) throws ServiceException {
		Status status = ltPoHeadersService.viewFile(name);
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}

	@RequestMapping(value = "/list/{logTime}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<LtPoHeaders>> getAllPoHeaders(@PathVariable("logTime") String logTime) throws ServiceException {
		List<LtPoHeaders> poHeaderList = ltPoHeadersService.getAllPoHeaders();
		return new ResponseEntity<List<LtPoHeaders>>(poHeaderList, HttpStatus.OK);
	}

	@RequestMapping(value = "/getactivePoHeaders/{logTime}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<LtPoHeaders>> getAllActivePoHeaders(@PathVariable("logTime") String logTime) throws ServiceException {
		List<LtPoHeaders> poHeaderList = ltPoHeadersService.getAllActivePoHeaders();
		return new ResponseEntity<List<LtPoHeaders>>(poHeaderList, HttpStatus.OK);
	}

	@RequestMapping(value = "/getPoByPoNumber/{companyId}/{userId}/{number}/{logTime}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<LtPoHeaders>> getActivePoHeadersByPoNumber(@PathVariable("companyId") Long companyId,
			@PathVariable("userId") Long userId, @PathVariable("number") String poNumber,@PathVariable("logTime") String logTime) throws ServiceException {
		List<LtPoHeaders> poHeaderList = ltPoHeadersService.getActivePoHeadersByPoNumber(companyId, userId, poNumber);
		return new ResponseEntity<List<LtPoHeaders>>(poHeaderList, HttpStatus.OK);
	}

	@RequestMapping(value = "/getpobyid/{id}/{logTime}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<LtPoHeaders> getPoHeaderById(@PathVariable("id") Long poHeaderId,@PathVariable("logTime") String logTime) throws ServiceException {
		LtPoHeaders vendor = ltPoHeadersService.getPoHeaderById(poHeaderId);
		return new ResponseEntity<LtPoHeaders>(vendor, HttpStatus.OK);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Status> save(@RequestBody LtPoHeaders ltPoHeaders) throws ServiceException {
		Status status = new Status();
		status = ltPoHeadersService.save(ltPoHeaders);
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Status> update(@RequestBody LtPoHeaders ltPoHeaders) throws ServiceException {
		Status status = new Status();
		status = ltPoHeadersService.update(ltPoHeaders);
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}

	@RequestMapping(value = "/acknowldge", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Status> acknowldge(@RequestBody LtPoHeaders ltPoHeaders) throws ServiceException {
		Status status = new Status();
		status = ltPoHeadersService.acknowldge(ltPoHeaders);
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}

	@RequestMapping(value = "/getamountbyvendorId/{vendorId}/{logTime}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<DashboardDetails> getAmountByVendorId(@PathVariable("vendorId") Long vendorId,@PathVariable("logTime") String logTime)
			throws ServiceException {
		DashboardDetails vendor = ltPoHeadersService.getAmountByVendorId(vendorId);
		return new ResponseEntity<DashboardDetails>(vendor, HttpStatus.OK);
	}

	@RequestMapping(value = "/getstatuscountbyvendorId/{vendorId}/{logTime}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<DashboardDetails>> getCountAndStatusByVendorId(@PathVariable("vendorId") Long vendorId,@PathVariable("logTime") String logTime)
			throws ServiceException {
		List<DashboardDetails> vendor = ltPoHeadersService.getCountAndStatusByVendorId(vendorId);
		return new ResponseEntity<List<DashboardDetails>>(vendor, HttpStatus.OK);
	}

	@RequestMapping(value = "/gettopfivebyid/{id}/{logTime}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<LtPoHeaders>> getTopFivePoById(@PathVariable("id") Long vendorId,@PathVariable("logTime") String logTime)
			throws ServiceException {
		List<LtPoHeaders> vendor = ltPoHeadersService.getTopFivePoById(vendorId);
		return new ResponseEntity<List<LtPoHeaders>>(vendor, HttpStatus.OK);
	}

	@RequestMapping(value = "/getstatuscountbybuyerid/{buyerId}/{companyId}/{logTime}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<DashboardDetails>> getStatusCountByBuyerId(@PathVariable("buyerId") Long buyerId,
			@PathVariable("companyId") Long companyId,@PathVariable("logTime") String logTime) throws ServiceException {
		List<DashboardDetails> vendor = ltPoHeadersService.getStatusCountByBuyerId(buyerId, companyId);
		return new ResponseEntity<List<DashboardDetails>>(vendor, HttpStatus.OK);
	}

	@RequestMapping(value = "/getvendormsgbybuyerid/{buyerId}/{logTime}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<VendorBuyerDetails>> getVendorMsgByBuyerId(@PathVariable("buyerId") Long buyerId,@PathVariable("logTime") String logTime)
			throws ServiceException {
		List<VendorBuyerDetails> vendor = ltPoHeadersService.getVendorMsgByBuyerId(buyerId);
		return new ResponseEntity<List<VendorBuyerDetails>>(vendor, HttpStatus.OK);
	}

	@RequestMapping(value = "/getqtrstatuscountbybuyerid/{buyerId}/{year}/{logTime}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Object>> getQtrStatusCountByBuyerId(@PathVariable("buyerId") Long buyerId,
			@PathVariable("year") Long year,@PathVariable("logTime") String logTime) throws ServiceException {
		List<Object> vendor = ltPoHeadersService.getQtrStatusCountByBuyerId(buyerId, year);
		return new ResponseEntity<List<Object>>(vendor, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/createPOPDFReport/{poHeaderId}/{companyId}/{logTime}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Status> createPOPDFReport(@PathVariable("poHeaderId") Long poHeaderId,@PathVariable("companyId") long companyId,@PathVariable("logTime") String logTime){
		Status status = ltPoHeadersService.createPOPDFReport(poHeaderId,companyId);
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}
 
}
