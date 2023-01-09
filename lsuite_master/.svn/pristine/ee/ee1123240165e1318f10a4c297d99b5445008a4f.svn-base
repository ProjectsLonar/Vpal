package com.lonar.vendor.vendorportal.controller;

import java.util.Date;
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
import com.lonar.vendor.vendorportal.model.LtMastEmailtoken;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.repository.LtMastEmailtokenRepository;
import com.lonar.vendor.vendorportal.service.LtMastCommonMessageService;
import com.lonar.vendor.vendorportal.service.LtMastEmailtokenService;



@RestController
@RequestMapping("/API/emailToken")
public class LtMastEmailtokenRestController implements CodeMaster
{
	final String restBaseUrl = "/API/costcenter";
	// static final Logger logger =
	static final Logger logger = Logger.getLogger(LtMastCostCentersRestController.class);


	@Autowired
	LtMastEmailtokenService ltMastEmailtokenService;
	
	@Autowired
	LtMastEmailtokenRepository ltMastEmailtokenRepository;
	
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	/*@Autowired
	Status status;*/

// ==============================================================================================================================
	@RequestMapping(value = "/dataTable/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomeDataTable getDataTable(LtMastEmailtoken input,@PathVariable("logTime") String logTime) {

		CustomeDataTable customeDataTable = new CustomeDataTable();
		try {
			Long count = ltMastEmailtokenService.getCount(input);

			customeDataTable.setRecordsTotal(count);
			customeDataTable.setRecordsFiltered(count);

			List<LtMastEmailtoken> ltMastEmailtokenList = ltMastEmailtokenService.getDataTable(input);

			customeDataTable.setData(ltMastEmailtokenList);

		} catch (Exception e) {
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
		return customeDataTable;

	}
// =======================================================================================================================
	@RequestMapping(value = "/getById/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LtMastEmailtoken> getLtMastEmailtokenById(@PathVariable("id") String emailtokenid,@PathVariable("logTime") String logTime) {
		
		LtMastEmailtoken ltMastEmailtoken = null;
		try {
			if (emailtokenid != null) {
				ltMastEmailtoken = ltMastEmailtokenService.getLtMastEmailtokenById(emailtokenid);
						;
			} else {

				return new ResponseEntity<LtMastEmailtoken>(ltMastEmailtoken, HttpStatus.OK);
			}
		} catch (NumberFormatException e) {
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		} catch (Exception e) {
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
		return new ResponseEntity<LtMastEmailtoken>(ltMastEmailtoken, HttpStatus.OK);
	}
	
// =======================================================================================================================
	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> updateLtMastEmailtoken(@RequestBody  LtMastEmailtoken ltMastEmailtoken)
	{
		Status status = new Status();
		try {
			if (ltMastEmailtoken.getEmailTokenId() != null) {

				ltMastEmailtoken.setEmailStatus("SENDING");
				ltMastEmailtoken.setSendDate(new Date());
				ltMastEmailtoken = ltMastEmailtokenRepository.save(ltMastEmailtoken);

				status = ltMastCommonMessageService.getCodeAndMessage(UPDATE_SUCCESSFULLY);
				if (status.getMessage() == null) {
					status.setCode(SUCCESS);
					status.setMessage("Error in finding message! The action is completed successfully.");
				}

			}

			else {
				status = ltMastCommonMessageService.getCodeAndMessage(INPUT_IS_EMPTY);
				}
			return new ResponseEntity<Status>(status, HttpStatus.OK);

		}

		catch (NullPointerException e) {
			e.printStackTrace();
			status = ltMastCommonMessageService.getCodeAndMessage(INPUT_IS_EMPTY);
			return new ResponseEntity<Status>(status, HttpStatus.OK);
		} catch (Exception e) {
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}

	}
	
}
