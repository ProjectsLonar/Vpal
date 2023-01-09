package com.lonar.vendor.vendorportal.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.lonar.vendor.vendorportal.config.ExceptionMessage;
import com.lonar.vendor.vendorportal.dao.LtMastVendorsDao;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtMastVendorAttachment;
import com.lonar.vendor.vendorportal.model.LtMastVendorCoc;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.model.SysVariableWithValues;
import com.lonar.vendor.vendorportal.service.LtMastCommonMessageService;
import com.lonar.vendor.vendorportal.service.LtMastSysVariablesService;
import com.lonar.vendor.vendorportal.service.LtMastVendorAttachmentService;
import com.lonar.vendor.vendorportal.service.LtMastVendorCocService;

@RestController
@RequestMapping("/API/VendorCoc")
public class LtMastVendorCocRestController implements CodeMaster{

	@Autowired
	LtMastVendorsDao ltMastVendorsDao;
	
	@Autowired
	LtMastSysVariablesService ltMastSysVariablesService;
	
	String saveDirectory;
	
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	@Autowired
	LtMastVendorAttachmentService ltMastVendorAttachmentService;
	
	@Autowired
	LtMastVendorCocService ltMastVendorCocService;
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	@RequestMapping(value = "/getByVendorId/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LtMastVendorCoc> getAttachmentByVendorIdAndType(@PathVariable("id") Long vendorId,@PathVariable("logTime") String logTime) throws ServiceException
	{
		LtMastVendorCoc ltMastVendorAttachment = 
				ltMastVendorCocService.getAttachmentByVendorId(vendorId);
				return new ResponseEntity<LtMastVendorCoc>(ltMastVendorAttachment, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/MultipalUpload", method = RequestMethod.POST)
	public ResponseEntity<Status> saveVendorFile(@RequestParam("file") MultipartFile[] files,
		 @RequestParam("vendorId") Long vendorId,  @RequestParam("userId") Long userId,
		 @RequestParam("isAgree") String isAgree) {

		List<LtMastVendorAttachment> ltMastVendorAttachmentList = new ArrayList<LtMastVendorAttachment>();

		Status status = new Status();
		String fileName = null;
		String msg = "";	
		Date currDate = new Date();

		try {
			Status status1 = ltMastVendorsDao.getCompanyByVendor(vendorId);
			Long companyId = Long.parseLong(status1.getData().toString());
			//Long companyId = (Long) status1.getData();
			if (files != null && files.length > 0) {
				SysVariableWithValues sysVariableWithValues = ltMastSysVariablesService
						.getBySysVariableName("FILE_UPLOAD_FOLDER_PATH",companyId);

				if (sysVariableWithValues != null) {
					if (sysVariableWithValues.getLtMastSysVariableValues().get(0) != null) {
						saveDirectory = sysVariableWithValues.getLtMastSysVariableValues().get(0).getUserValue();

					} else {
						saveDirectory = sysVariableWithValues.getLtMastSysVariables().getSystemValue();
					}
				}

				// saveDirectory="D:/eExpence/Upload/";

				File dir = new File(saveDirectory);
				if (!dir.exists()) {
					dir.mkdirs();
					if (!dir.isDirectory()) {
						status = ltMastCommonMessageService.getCodeAndMessage(NO_DIRECTIVE_EXISTS);
						if (status.getMessage() == null) {
							status.setCode(EXCEPTION);
							status.setMessage("Error in finding message! The action was unsuccessful");
						}

						return new ResponseEntity<Status>(status, HttpStatus.OK);
					}
				}

				
				for (int i = 0; i < files.length; i++) 
				{
					fileName = files[i].getOriginalFilename();

					try {

						ltMastVendorAttachmentList = ltMastVendorAttachmentService.getAllFilesByVendorId(vendorId);

						if (ltMastVendorAttachmentList.size() > 0) 
						{
							for (LtMastVendorAttachment ltMastVendorAttachment : ltMastVendorAttachmentList) 
							{

								if (!ltMastVendorAttachment.getFileName().equals(files[i].getOriginalFilename())) 
								{
									
									int res=jdbcTemplate.update("INSERT INTO LT_MAST_VENDOR_FILE_ATTACHMENT  "
											+ " (VENDOR_ATTACHMENT_ID, VENDOR_ID, FILE_NAME, FILE_PATH, LAST_UPDATED_BY,LAST_UPDATE_DATE, VENDOR_ATTACHMENT_TYPE)  "
											+ " VALUES (LT_MAST_VENDOR_FILE_ATTACH_S.nextval, ?, ? ,?, ?, ?, ?)",
											+ vendorId,fileName,saveDirectory,userId, currDate, "COC" );
											
											
									if(res==1)
									// For Update Fil
									break;

								} else {
									status.setCode(EXCEPTION);
									status.setMessage("File with same name already exists!");
									
									return new ResponseEntity<Status>(status, HttpStatus.OK);

								}

							}
						} 
						else 
						{
							
							int res=jdbcTemplate.update("INSERT INTO LT_MAST_VENDOR_FILE_ATTACHMENT  "
									+ " (VENDOR_ATTACHMENT_ID, VENDOR_ID, FILE_NAME, FILE_PATH, LAST_UPDATED_BY,LAST_UPDATE_DATE, VENDOR_ATTACHMENT_TYPE)  "
									+ " VALUES (LT_MAST_VENDOR_FILE_ATTACH_S.nextval, ?, ? ,?, ?, ?, ?)",
									+ vendorId,fileName,saveDirectory,userId, currDate, "COC" );
							
						}

						
						
						byte[] bytes = files[i].getBytes();

						BufferedOutputStream buffStream = new BufferedOutputStream(
								new FileOutputStream(new File(saveDirectory + fileName)));
						buffStream.write(bytes);

						int result=jdbcTemplate.update("INSERT INTO LT_MAST_VENDOR_COC  "
								+ " (COMP_CONDUCT_ID, VENDOR_ID, ATTACHMENT_COC,IS_AGREE,CREATED_BY,CREATION_DATE,LAST_UPDATE_LOGIN, LAST_UPDATED_BY,LAST_UPDATE_DATE)  "
								+ " VALUES (LT_MAST_VENDOR_COC_S.nextval, ?,?, ? ,?, ?,?,?,?)",
								+ vendorId,saveDirectory,isAgree,userId, new Date(),userId,userId,new Date());
						if(result==0) {
							status = ltMastCommonMessageService.getCodeAndMessage(INTERNAL_SERVER_ERROR);
						}
						
						buffStream.close();
						msg += "You have successfully uploaded " + fileName ;
						//status = ltMastCommonMessageService.getCodeAndMessage(FILE_UPLOADED_SUCESSFULLY);
						
						status.setMessage(msg);
						status.setCode(200);
						//status.setData(data);

						if (status.getMessage() == null) {
							status.setCode(SUCCESS);
							status.setMessage("Error in finding message! The action is completed successfully.");
						}
						return new ResponseEntity<Status>(status, HttpStatus.OK);

					} catch (Exception e) {
						e.printStackTrace();
						status = ltMastCommonMessageService.getCodeAndMessage(INTERNAL_SERVER_ERROR);
						if (status.getMessage() == null) {
							status.setCode(EXCEPTION);
							status.setMessage("Error in finding message! The action was unsuccessful");
						}

					}
				}

				
			} else {
				status = ltMastCommonMessageService.getCodeAndMessage(INPUT_IS_EMPTY);
				if (status.getMessage() == null) {
					status.setCode(EXCEPTION);
					status.setMessage("Error in finding message! The action was unsuccessful");
				}
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			try {
				status = ltMastCommonMessageService.getCodeAndMessage(INTERNAL_SERVER_ERROR);
				if (status.getMessage() == null) {
					status.setCode(EXCEPTION);
					status.setMessage("Error in finding message! The action was unsuccessful");
				}
				status.setMessage(e.getMessage());
			} catch (Exception o) {
				o.printStackTrace();
			}
			
		}
		return new ResponseEntity<Status>(status, HttpStatus.OK);

	}
	
	
	//==================================================================================================================================
			@RequestMapping(value = "/deleteFile/{id}/{logTime}", method= RequestMethod.GET, produces = "application/json")
		    public ResponseEntity<Status> delete(@PathVariable("id") Long vendorId,@PathVariable("logTime") String logTime)
			{
					Status status=new Status();
					try
					{
					 status =  ltMastVendorCocService.deleteLtMastVendorCoc(vendorId);
					}
					catch (org.springframework.dao.DataIntegrityViolationException e)
					{
						try
						{
							status=ltMastCommonMessageService.getCodeAndMessage(ENTITY_CANNOT_DELETE);
							if(status.getMessage()==null)
							{
								status.setCode(EXCEPTION);
								status.setMessage("Error in finding message! The action was unsuccessful");
							}
						}
						catch(Exception e1)
						{
							e1.printStackTrace();
						}
						
						return new ResponseEntity<Status>(status,HttpStatus.OK);
					} 
					catch(Exception e)
					{
						ExceptionMessage expMsg=new ExceptionMessage();
						status=expMsg.getExceptionMessage();
						e.printStackTrace();
					}
					return new ResponseEntity<Status>(status, HttpStatus.OK);
			}
	@RequestMapping(value = "/checkRecord/{id}/{logTime}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Status> checkRecord(@PathVariable("id") Long venId,@PathVariable("logTime") String logTime) throws ServiceException
	{
		Status status = new Status();
			 status =  ltMastVendorCocService.checkRecord(venId);
			return new ResponseEntity<Status>(status, HttpStatus.OK);
	}
}
