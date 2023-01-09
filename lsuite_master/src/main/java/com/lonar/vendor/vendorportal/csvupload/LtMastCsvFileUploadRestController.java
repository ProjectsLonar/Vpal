package com.lonar.vendor.vendorportal.csvupload;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.service.LtMastSysVariablesService;


@RestController
@RequestMapping("/API/fileUpload")
public class LtMastCsvFileUploadRestController 
{
	@Autowired
	private MessageSource messageSource;

	@Autowired
	LtMastCsvFileUploadService ltMastCsvFileUploadService;
	
	@Autowired
	LtMastSysVariablesService ltMastSysVariablesService;

	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST, consumes = "multipart/form-data")
	public ResponseEntity<Status> uploadFile(
			@RequestParam(value = "file", required = true) CommonsMultipartFile csvFile,
			@RequestParam(value = "requestName", required = true) String requestName,
			@RequestParam(value = "requestorId", required = true) String requestorId) {

		int retValue = 0;
		BufferedReader bufferedReader = null;
		Status status = new Status();
		//HttpHeaders headers = new HttpHeaders();
		String fileName = null;
		String fileExtention = " ";
		try 
		{
			int reqId = Integer.valueOf(requestorId);
		if (!csvFile.isEmpty())
		{
			fileName = csvFile.getOriginalFilename();
				bufferedReader = new BufferedReader(new InputStreamReader(csvFile.getInputStream()));
			 
				List<LtMastFileTableMapping> mappingList = ltMastCsvFileUploadService.getMappingTableDetails(requestName);
				fileExtention = fileName.substring(fileName.lastIndexOf('.'));

				if (fileExtention.equals(".csv"))
				{
					if (mappingList.size() > 0) 
					{

						retValue = ltMastCsvFileUploadService.saveFileDemo(bufferedReader, mappingList, requestName, reqId, fileName);
						if (retValue == 1) {
							status.setCode(1);
							status.setMessage(messageSource.getMessage("fileUploadSuccessfully", null, " File Uploaded Successfully.",
									Locale.getDefault()));
							return new ResponseEntity<Status>(status, HttpStatus.OK);

						} 
						else if (retValue == -2) {
							status.setCode(2);
							status.setMessage(
									messageSource.getMessage("fileUploadFailed", null, "column doesnt match", Locale.getDefault()));
							
							return new ResponseEntity<Status>(status, HttpStatus.PRECONDITION_FAILED);

						} 
						else if (retValue == -3) {
							status.setCode(2);
							status.setMessage(messageSource.getMessage("fileUploadFailed", null,
									"Incorrect column order", Locale.getDefault()));
							
							return new ResponseEntity<Status>(status, HttpStatus.UNPROCESSABLE_ENTITY);

						} else if (retValue == -4) {
							status.setCode(2);
							status.setMessage(messageSource.getMessage("fileUploadFailed", null,
									"Duplicate column order found", Locale.getDefault()));
							
							return new ResponseEntity<Status>(status, HttpStatus.BAD_REQUEST);

						} 
						else if (retValue == -1) 
						{
							status.setCode(2);
							status.setMessage(
									messageSource.getMessage("fileUploadFailed", null, "Invalid column order", Locale.getDefault()));
							
							return new ResponseEntity<Status>(status, HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE);

						} 
						else {
							status.setCode(2);
							status.setMessage(
									messageSource.getMessage("fileUploadFailed", null, "Failed", Locale.getDefault()));
						
							return new ResponseEntity<Status>(status, HttpStatus.BAD_REQUEST);

						}
					} 
					else{
						status.setCode(3);
						status.setMessage(messageSource.getMessage("invalid", null, "Invalid File Format", Locale.getDefault()));
						
						return new ResponseEntity<Status>(status, HttpStatus.NO_CONTENT);
					}

				} else {
					status.setCode(3);
					status.setMessage(
							messageSource.getMessage("invalidfileFormat", null, "Invalid File Format", Locale.getDefault()));
					
					return new ResponseEntity<Status>(status, HttpStatus.BAD_REQUEST);
				}

			} else {
			status.setCode(3);
			status.setMessage(messageSource.getMessage("inputempty", null, "Empty File", Locale.getDefault()));
			
			return new ResponseEntity<Status>(status, HttpStatus.NO_CONTENT);
		}
		}catch (Exception e) {
			e.printStackTrace();
			status.setCode(2);
			status.setMessage(messageSource.getMessage( e.getMessage() , null, e.getMessage(), Locale.getDefault()));
			
			return new ResponseEntity<Status>(status, HttpStatus.NO_CONTENT);
		}
	}
	
	
	@RequestMapping(value = "/csvFile/{requestName}", method = RequestMethod.GET)
	public ResponseEntity<Status> downloadFile(@PathVariable("requestName") String requestName)
	{
		Status status = new Status();
		try 
		{
			List<LtMastFileTableMapping> mappingList = ltMastCsvFileUploadService.getDownloadFilePath(requestName);
			if(mappingList.size()>0){
			status.setCode(40);
			status.setData(mappingList.get(0).getCsvFileFormat());
			}
			
			return new ResponseEntity<Status>(status, HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
			status.setCode(0);
			status.setMessage(messageSource.getMessage( e.getMessage() , null, e.getMessage(), Locale.getDefault()));
			
			return new ResponseEntity<Status>(status, HttpStatus.NO_CONTENT);
		}
	}

}
