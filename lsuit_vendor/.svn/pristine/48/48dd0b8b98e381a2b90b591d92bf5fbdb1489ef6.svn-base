package com.lonar.vendor.vendorportal.excelupload;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.lonar.vendor.vendorportal.model.CustomeDataTable;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;


@RestController
@RequestMapping("/API/upload")
public class LtMastFileUploadRestController 
{
	@Autowired
	LtMastFileUploadService ltMastFileUploadService;
	

	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST, consumes = "multipart/form-data")
	public ResponseEntity<Status> uploadFile(
			@RequestParam(value = "file", required = true) MultipartFile file,
			@RequestParam(value = "requestName", required = true) String requestName,
			@RequestParam(value = "requestorId", required = true) Long requestorId) throws ServiceException {

		Status status = new Status();
		status = ltMastFileUploadService.uploadFile(file,requestName,requestorId);
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getByRequestId/{reqId}", method =RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtInvoiceHeadersStg>> getByRequestId(@PathVariable("reqId") Long requestId) throws ServiceException{
		List<LtInvoiceHeadersStg> ltInvoiceHeadersStgList = ltMastFileUploadService.getByRequestId(requestId);
		return new ResponseEntity<List<LtInvoiceHeadersStg>>(ltInvoiceHeadersStgList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/createInvoice/{reqId}", method =RequestMethod.POST)
	public ResponseEntity<Status> createInvoice(@PathVariable("reqId") Long requestId) throws ServiceException{
		Status status = new Status();		
		status = ltMastFileUploadService.createInvoice(requestId);
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/datatable/{requestId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomeDataTable fileuploadStatusDataTable(@PathVariable("requestId") Long requestId,
			 LtInvoiceHeadersStg input, @PathVariable("logTime") String logTime) {
		CustomeDataTable customeDataTable = new CustomeDataTable();
		try {
			Long count = ltMastFileUploadService.getLtInvoiceHeadersStgCount(requestId, input);
			customeDataTable.setRecordsTotal(count);
			customeDataTable.setRecordsFiltered(count);
			List<LtInvoiceHeadersStg> ltPoLinesList = ltMastFileUploadService.getLtInvoiceHeadersStgData(requestId, input);
			customeDataTable.setData(ltPoLinesList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customeDataTable;
	}
}
