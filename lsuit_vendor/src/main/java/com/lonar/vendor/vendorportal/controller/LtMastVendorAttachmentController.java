package com.lonar.vendor.vendorportal.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.lonar.vendor.vendorportal.config.ExceptionMessage;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtMastVendorAttachment;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.model.SysVariableWithValues;
import com.lonar.vendor.vendorportal.service.LtMastCommonMessageService;
import com.lonar.vendor.vendorportal.service.LtMastSysVariablesService;
import com.lonar.vendor.vendorportal.service.LtMastVendorAttachmentService;
import com.lonar.vendor.vendorportal.service.LtMastVendorsService;

@RestController
@RequestMapping("/API/vendorAttachment")
@PropertySource(value = "classpath:serverurl.properties", ignoreResourceNotFound = true)
public class LtMastVendorAttachmentController implements CodeMaster {

final String restBaseUrl = "/API/vendorAttachment";
	
	Status status=new Status();
	
	ExceptionMessage expMsg=new ExceptionMessage();
	static final Logger logger = Logger.getLogger(LtMastVendorAttachmentController.class);

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;

	@Autowired
	LtMastVendorAttachmentService ltMastVendorAttachmentService;

	@Autowired
	LtMastSysVariablesService ltMastSysVariablesService;
	
	@Autowired
	LtMastVendorsService ltMastVendorsService;

	@Autowired
	private Environment env;
	
	@Autowired
	private MessageSource messageSource;

	private String saveDirectory;

	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String displayForm() {
		return "file_upload_form";
	}

//===================================================================================================================================
	@RequestMapping(value = "/getAllFilesByVendorId/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastVendorAttachment>> getAllLtMastVendorAttachmentByVendorId(@PathVariable("id") Long vendorId,@PathVariable("logTime") String logTime)
	{
		List<LtMastVendorAttachment> ltMastVendorAttachment = new ArrayList<LtMastVendorAttachment>();
		try 
		{
			if (vendorId != null) {
				ltMastVendorAttachment = ltMastVendorAttachmentService.getAllFilesByVendorId(vendorId);
				return new ResponseEntity<List<LtMastVendorAttachment>>(ltMastVendorAttachment, HttpStatus.OK);
			}
		} catch (Exception e) {

			e.printStackTrace();
			return new ResponseEntity<List<LtMastVendorAttachment>>(ltMastVendorAttachment, HttpStatus.OK);
		}
		return new ResponseEntity<List<LtMastVendorAttachment>>(ltMastVendorAttachment, HttpStatus.OK);

	}

	//===================================================================================================================================
		@RequestMapping(value = "/getByVendorIdAndType/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<LtMastVendorAttachment> getAttachmentByVendorIdAndType(@PathVariable("id") Long vendorId,@PathVariable("logTime") String logTime) throws ServiceException
		{
			LtMastVendorAttachment ltMastVendorAttachment = 
			 ltMastVendorAttachmentService.getAttachmentByVendorIdAndType(vendorId);
					return new ResponseEntity<LtMastVendorAttachment>(ltMastVendorAttachment, HttpStatus.OK);
		}
//==================================================================================================================================
		@RequestMapping(value = "/MultipalFileUpload", method = RequestMethod.POST)
		public ResponseEntity<Status> saveFiles(@RequestParam("file") MultipartFile[] files,
			 @RequestParam("expenceHeaderId") Integer expenceHeaderId,
				@RequestParam("attachmentType") String[] attachmentType) {

			List<LtMastVendorAttachment> ltMastVendorAttachmentList = new ArrayList<LtMastVendorAttachment>();

			Status status = new Status();
			String fileName = null;
			String msg = "";
			
			String[] attachType  = null;
			String[] filenm  = null;

			

			try {
				Status status1 = ltMastVendorsService.getCompanyByVendor(Long.parseLong(expenceHeaderId.toString()));
				Long companyId = (Long) status1.getData();
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
							Long expenceHeaderIdLong = (long) expenceHeaderId;

							ltMastVendorAttachmentList = ltMastVendorAttachmentService.getAllFilesByVendorId(expenceHeaderIdLong);

							if (ltMastVendorAttachmentList.size() > 0) 
							{
								for (LtMastVendorAttachment ltMastVendorAttachment : ltMastVendorAttachmentList) 
								{

									if (!ltMastVendorAttachment.getFileName().equals(files[i].getOriginalFilename())
											&& !ltMastVendorAttachment.getVendorAttachmentType().equals(attachmentType[i])) {

										// For Update File
										jdbcTemplate.update(
												"INSERT INTO lt_mast_exp_file_upload(expense_attachment_id,expence_header_id,file_name,file_path,attachment_type)"
														+ " VALUES(lt_mast_exp_file_upload_s.nextval,?,?,?,?)",
												expenceHeaderId, fileName, saveDirectory, attachmentType[i]);
										break;

									} else {
										status.setCode(EXCEPTION);
										status.setMessage("Attachment by the same name already exists!");
										return new ResponseEntity<Status>(status, HttpStatus.OK);

									}

								}
							} else {
								
								

								jdbcTemplate.update(
										"INSERT INTO lt_mast_exp_file_upload(expense_attachment_id,expence_header_id,file_name,file_path,attachment_type)"
												+ " VALUES(lt_mast_exp_file_upload_s.nextval,?,?,?,?)",
										expenceHeaderId, fileName, saveDirectory, attachmentType[i]);

								
							}

							byte[] bytes = files[i].getBytes();

							BufferedOutputStream buffStream = new BufferedOutputStream(
									new FileOutputStream(new File(saveDirectory + fileName)));
							buffStream.write(bytes);

							buffStream.close();
							msg += "You have successfully uploaded " + fileName + "<br/>";
							status = ltMastCommonMessageService.getCodeAndMessage(FILE_UPLOADED_SUCESSFULLY);

							if (status.getMessage() == null) {
								status.setCode(SUCCESS);
								status.setMessage("Error in finding message! The action is completed successfully.");
							}

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
		
//=========================================================================================================================================
		@RequestMapping(value = "/delete", method = RequestMethod.POST)
		public @ResponseBody Status deleteFileHandler(@RequestParam("name") String[] fileName) 
		{
			String message = "";
			for (int i = 0; i < fileName.length; i++)
			{
				try 
				{
					File file = new File(env.getProperty("FILE_UPLOAD_FOLDER_PATH")
							+ fileName[i].toString().substring(1, fileName[i].toString().length()));
					if (file.exists())
					{
						if (file.delete()) 
						{
							logger.debug("Deleted file " + fileName[i].toString());
							if (message.length() == 0)
								message = "Deleted file " + fileName[i].toString();
							else
								message = ", Deleted file " + fileName[i].toString();
						} 
						else 
						{
							if (message.length() == 0)
								message = fileName[i].toString() + " File not found";
							else
								message = "," + fileName[i].toString() + " File not found";
						}
					}
				} 
				catch (Exception e)
				{
					if (message.length() == 0)
						message = "Not Deleted file " + fileName[i].toString();
					else
						message = ", Not Deleted file " + fileName[i].toString();
				}
			}
			return new Status(INSERT_SUCCESSFULLY, message);
		}
//==================================================================================================================================
		@RequestMapping(value = "/deleteFile/{id}/{logTime}", method= RequestMethod.GET, produces = "application/json")
	    public ResponseEntity<Status> delete(@PathVariable("id") Long vendorAttachmentId,@PathVariable("logTime") String logTime)
		{
				Status status=new Status();
				try
				{
				 status =  ltMastVendorAttachmentService.deleteLtMastVendorAttachmentFile(vendorAttachmentId);
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

//==================================================================================================================================
	@RequestMapping(value = "/saveAttachment", method = RequestMethod.POST)
	public ResponseEntity<Status> saveAttachments(@RequestParam("name") String[] names,
			@RequestParam("ltMastVendorAttachment") String ltMastVendorAttachment, @RequestParam("file") MultipartFile[] files) {
		String apiUrl = "/saveAttach";
		return ltMastVendorAttachmentService.saveAttachments(apiUrl, names, ltMastVendorAttachment, files);
	}
	
//==================================================================================================================================
	
	@RequestMapping(value = "/MultipalUpload", method = RequestMethod.POST)
	public ResponseEntity<Status> saveVendorFile(@RequestParam("file") MultipartFile[] files,
		 @RequestParam("vendorId") Long vendorId,  @RequestParam("userId") Long userId,
		 @RequestParam("attachmentType") String attachmentType) {

		List<LtMastVendorAttachment> ltMastVendorAttachmentList = new ArrayList<LtMastVendorAttachment>();

		Status status = new Status();
		String fileName = null;
		String msg = "";	
		Date currDate = new Date();

		try {
			Status status1 = ltMastVendorsService.getCompanyByVendor(vendorId);
			
			Long companyId = Long.parseLong(status1.getData().toString());
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
											+ vendorId,fileName,saveDirectory,userId, currDate, attachmentType );
											
											
									if(res==1)
									// For Update Fil
									break;

								} else {
									status.setCode(EXCEPTION);
									status.setMessage("File with same name already exists!");
									return new ResponseEntity<Status>(status, HttpStatus.OK);

								}

							}
						} else {
							
							

							/*int res=jdbcTemplate.update("INSERT INTO LT_MAST_VENDOR_FILE_ATTACHMENT "
									+ "(VENDOR_ATTACHMENT_ID,VENDOR_ID,FILE_NAME,FILE_PATH)"
					        		+ " VALUES(LT_MAST_VENDOR_FILE_ATTACH_S.nextval,?,?,?)", 
					        		vendorId,fileName,saveDirectory );*/

							int res=jdbcTemplate.update("INSERT INTO LT_MAST_VENDOR_FILE_ATTACHMENT  "
									+ " (VENDOR_ATTACHMENT_ID, VENDOR_ID, FILE_NAME, FILE_PATH, LAST_UPDATED_BY,LAST_UPDATE_DATE, VENDOR_ATTACHMENT_TYPE)  "
									+ " VALUES (LT_MAST_VENDOR_FILE_ATTACH_S.nextval, ?, ? ,?, ?, ?, ?)",
									+ vendorId,fileName,saveDirectory,userId, currDate, attachmentType );
							

							
						}

						byte[] bytes = files[i].getBytes();

						BufferedOutputStream buffStream = new BufferedOutputStream(
								new FileOutputStream(new File(saveDirectory + fileName)));
						buffStream.write(bytes);

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
	
	@RequestMapping(value = "/checkRecord/{id}/{logTime}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Status> checkRecord(@PathVariable("id") Long venId,@PathVariable("logTime") String logTime) throws ServiceException
	{
		Status status = new Status();
		status =  ltMastVendorAttachmentService.checkRecord(venId);
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}
}