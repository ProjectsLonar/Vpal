package com.lonar.vendor.vendorportal.controller;

import java.util.ArrayList;
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

import com.lonar.vendor.vendorportal.config.ExceptionMessage;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.CustomeDataTable;
import com.lonar.vendor.vendorportal.model.LtMastVendorClients;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.service.LtMastCommonMessageService;
import com.lonar.vendor.vendorportal.service.LtMastVendorClientsService;

@RestController
@RequestMapping("/API/VendorClients")
public class LtMastVendorClientsRestController implements CodeMaster {

	final String restBaseUrl = "/API/VendorClients";
	static final Logger logger = Logger.getLogger(LtMastVendorClientsRestController.class);
	Status status = new Status();
	ExceptionMessage expMsg = new ExceptionMessage();

	@Autowired
	LtMastVendorClientsService ltMastVendorClientsService;

	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;

	@RequestMapping(value = "/getAll/{logTime}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<LtMastVendorClients>> getAllVendorClients(@PathVariable("logTime") String logTime)
			throws Exception {
		List<LtMastVendorClients> ltMastVendorClients = new ArrayList<LtMastVendorClients>();
		try {
			ltMastVendorClients = ltMastVendorClientsService.getAllVendorClients();
		} catch (Exception e) {
			logger.error("ERROR " + e);
			e.printStackTrace();
		}
		return new ResponseEntity<List<LtMastVendorClients>>(ltMastVendorClients, HttpStatus.OK);
	}

	@RequestMapping(value = "/getVendorClientsById/{id}/{logTime}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<LtMastVendorClients> getByVendorClientsId(@PathVariable("id") Long vendorClientsId,
			@PathVariable("logTime") String logTime) {
		LtMastVendorClients ltMastVendorClients = new LtMastVendorClients();
		try {
			ltMastVendorClients = ltMastVendorClientsService.getVendorClientsById(vendorClientsId);
		} catch (Exception e) {
			logger.error("ERROR " + e);
			e.printStackTrace();
		}
		return new ResponseEntity<LtMastVendorClients>(ltMastVendorClients, HttpStatus.OK);
	}

	@RequestMapping(value = "/getvendorclientsbyvendorid/{id}/{logTime}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<LtMastVendorClients>> getByVendorClientsByVendorId(@PathVariable("id") Long vendorId,@PathVariable("logTime") String logTime)
	{
			List<LtMastVendorClients> ltMastVendorClients=new ArrayList<LtMastVendorClients>();
			try
			{
				ltMastVendorClients =  ltMastVendorClientsService.getVendorClientsByVendorId(vendorId);
			}
			catch(Exception e)
			{
				logger.error("ERROR "+ e );
				e.printStackTrace();
			}
			return new ResponseEntity<List<LtMastVendorClients>>(ltMastVendorClients, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getvendorclientsbyvendoriddatatable/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomeDataTable getByVendorClientsByVendorIdDataTable(@PathVariable("id") Long vendorId,
			LtMastVendorClients input, @PathVariable("logTime") String logTime) {
		CustomeDataTable customeDataTable = new CustomeDataTable();
		try {
			Long count = ltMastVendorClientsService.getVendorClientsByVendorIdDataTableCount(vendorId, input);
			customeDataTable.setRecordsTotal(count);
			customeDataTable.setRecordsFiltered(count);
			List<LtMastVendorClients> ltMastVendorClientsList = ltMastVendorClientsService
					.getVendorClientsByVendorIdDataTable(vendorId, input);
			customeDataTable.setData(ltMastVendorClientsList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customeDataTable;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Status> save(@RequestBody LtMastVendorClients ltMastVendorClients) {
		try {
			status = ltMastVendorClientsService.save(ltMastVendorClients);
		} catch (Exception e) {
			status = expMsg.getExceptionMessage();
			logger.error("ERROR " + e);
			e.printStackTrace();
		}
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Status> update(@RequestBody LtMastVendorClients ltMastVendorClients) {
		try {
			status = ltMastVendorClientsService.update(ltMastVendorClients);
		} catch (Exception e) {
			status = expMsg.getExceptionMessage();
			logger.error("ERROR " + e);
			e.printStackTrace();
		}
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}

	@RequestMapping(value = "/delete/{id}/{logTime}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Status> delete(@PathVariable("id") Long ltMastVendorClients,
			@PathVariable("logTime") String logTime) {
		try {
			status = ltMastVendorClientsService.delete(ltMastVendorClients);
		} catch (org.springframework.dao.DataIntegrityViolationException e) {
			logger.error("ERROR " + e);
			e.printStackTrace();
			status = ltMastCommonMessageService.getCodeAndMessage(ENTITY_CANNOT_DELETE);
			return new ResponseEntity<Status>(status, HttpStatus.OK);
		} catch (Exception e) {
			status = expMsg.getExceptionMessage();
			logger.error("ERROR " + e);
			e.printStackTrace();
		}

		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}

	@RequestMapping(value = "/checkRecord/{id}/{logTime}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Status> checkRecord(@PathVariable("id") Long venId, @PathVariable("logTime") String logTime)
			throws ServiceException {
		status = ltMastVendorClientsService.checkRecord(venId);
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}

}
