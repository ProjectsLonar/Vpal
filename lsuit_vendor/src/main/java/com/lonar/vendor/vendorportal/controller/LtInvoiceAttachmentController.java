package com.lonar.vendor.vendorportal.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
import com.lonar.vendor.vendorportal.dao.LtMastUsersDao;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtInvoiceAttachment;
import com.lonar.vendor.vendorportal.model.LtMastUsers;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.model.SysVariableWithValues;
import com.lonar.vendor.vendorportal.service.LtMastCommonMessageService;
import com.lonar.vendor.vendorportal.service.LtInvoiceAttachmentService;
import com.lonar.vendor.vendorportal.service.LtMastSysVariablesService;

@RestController
@RequestMapping("/API/invoiceAttachment")
@PropertySource(value = "classpath:serverurl.properties", ignoreResourceNotFound = true)
public class LtInvoiceAttachmentController implements CodeMaster {

final String restBaseUrl = "/API/invoiceAttachment";
	
	Status status=new Status();
	
	ExceptionMessage expMsg=new ExceptionMessage();
	static final Logger logger = Logger.getLogger(LtInvoiceAttachmentController.class);

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;

	@Autowired
	LtInvoiceAttachmentService ltInvoiceAttachmentService;

	@Autowired
	LtMastSysVariablesService ltMastSysVariablesService;
	
	@Autowired
	LtMastUsersDao ltMastUsersDao;

	@Autowired
	private Environment env;
	
	@Autowired
	private MessageSource messageSource;

	private String saveDirectory;

	@RequestMapping(value = "/show/{logTime}", method = RequestMethod.GET)
	public String displayForm(@PathVariable("logTime") String logTime) {
		return "file_upload_form";
	}

//===================================================================================================================================
	@RequestMapping(value = "/getallfilesbyinvoiceid/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtInvoiceAttachment>> getAllFilesByInvoiceId(@PathVariable("id") Long invoiceId,@PathVariable("logTime") String logTime)
	{
		List<LtInvoiceAttachment> ltMastInvoiceAttachment = new ArrayList<LtInvoiceAttachment>();
		try 
		{
			if (invoiceId != null) {
				ltMastInvoiceAttachment = ltInvoiceAttachmentService.getAllFilesByInvoiceHeaderId(invoiceId);
				return new ResponseEntity<List<LtInvoiceAttachment>>(ltMastInvoiceAttachment, HttpStatus.OK);
			}
		} catch (Exception e) {

			e.printStackTrace();
			return new ResponseEntity<List<LtInvoiceAttachment>>(ltMastInvoiceAttachment, HttpStatus.OK);
		}
		return new ResponseEntity<List<LtInvoiceAttachment>>(ltMastInvoiceAttachment, HttpStatus.OK);

	}

	//===================================================================================================================================
		@RequestMapping(value = "/getByInvoiceIdAndType/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<LtInvoiceAttachment> getByInvoiceIdAndType(@PathVariable("id") Long invoiceId,@PathVariable("logTime") String logTime) throws ServiceException
		{
			LtInvoiceAttachment ltMastInvoiceAttachment = 
					ltInvoiceAttachmentService.getAttachmentByInvoiceIdAndType(invoiceId);
					return new ResponseEntity<LtInvoiceAttachment>(ltMastInvoiceAttachment, HttpStatus.OK);
		}
//==================================================================================================================================
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
	    public ResponseEntity<Status> delete(@PathVariable("id") Long invoiceAttachmentId,@PathVariable("logTime") String logTime)
		{
				String apiUrl = "/deleteFile"+invoiceAttachmentId;
				Status status=new Status();
				try
				{
				 status =  ltInvoiceAttachmentService.deleteLtMastVendorAttachmentFile(invoiceAttachmentId);
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
					logger.info("Output " + restBaseUrl + apiUrl + " "
							+ messageSource.getMessage("cannotdelete", null, "Default", Locale.getDefault())
							+ " HttpStatus.OK");
					return new ResponseEntity<Status>(status,HttpStatus.OK);
				} 
				catch(Exception e)
				{
					ExceptionMessage expMsg=new ExceptionMessage();
					status=expMsg.getExceptionMessage();
					e.printStackTrace();
				}
				logger.info("Output " + apiUrl + invoiceAttachmentId +status+ " HttpStatus.OK ");
				return new ResponseEntity<Status>(status, HttpStatus.OK);
		}

//==================================================================================================================================
	/*@RequestMapping(value = "/saveAttachment", method = RequestMethod.POST)
	public ResponseEntity<Status> saveAttachments(@RequestParam("name") String[] names,
			@RequestParam("ltMastVendorAttachment") String ltMastVendorAttachment, @RequestParam("file") MultipartFile[] files) {
		String apiUrl = "/saveAttach";
		return ltMastVendorAttachmentService.saveAttachments(apiUrl, names, ltMastVendorAttachment, files);
	}*/
	
//==================================================================================================================================
	
	@RequestMapping(value = "/MultipalUpload", method = RequestMethod.POST)
	public ResponseEntity<Status> saveInvoiceFile(@RequestParam("file") MultipartFile[] files,
		 @RequestParam("invoiceId") Long invoiceId,  @RequestParam("userId") Long userId,
		 @RequestParam("attachmentTypeId") Long attachmentTypeId) {

		List<LtInvoiceAttachment> ltMastInvoiceAttachmentList = new ArrayList<LtInvoiceAttachment>();

		Status status = new Status();
		String fileName = null;
		String msg = "";	
		Date currDate = new Date();

		try {
			LtMastUsers ltMastUsers = ltMastUsersDao.getLtMastUsersByID(userId);
			if (files != null && files.length > 0) {
				SysVariableWithValues sysVariableWithValues = ltMastSysVariablesService
						.getBySysVariableName("FILE_UPLOAD_FOLDER_PATH",ltMastUsers.getCompanyId());

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

						ltMastInvoiceAttachmentList = ltInvoiceAttachmentService.getAllFilesByInvoiceHeaderId(invoiceId);

						if (ltMastInvoiceAttachmentList.size() > 0) 
						{
							for (LtInvoiceAttachment ltMastInvoiceAttachment : ltMastInvoiceAttachmentList) 
							{

								if (!ltMastInvoiceAttachment.getFileName().equals(files[i].getOriginalFilename())) 
								{
									int res=jdbcTemplate.update("INSERT INTO LT_INVOICE_ATTACHMENT  "
											+ "  (INVOICE_ATTACHMENT_ID, INVOICE_ID, FILE_NAME, FILE_PATH, LAST_UPDATED_BY,LAST_UPDATE_DATE, ATTACHMENT_TYPE_ID)  "
											+ " VALUES (LT_INVOICE_ATTACHMENT_S.nextval, ?, ? ,?, ?, ?, ?) ",
											+  invoiceId,fileName,saveDirectory,userId, currDate, attachmentTypeId );		
									
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
							int res=jdbcTemplate.update("INSERT INTO LT_INVOICE_ATTACHMENT  "
									+ "  (INVOICE_ATTACHMENT_ID, INVOICE_ID, FILE_NAME, FILE_PATH, LAST_UPDATED_BY,LAST_UPDATE_DATE, ATTACHMENT_TYPE_ID)  "
									+ " VALUES (LT_INVOICE_ATTACHMENT_S.nextval, ?, ? ,?, ?, ?, ?) ",
									+  invoiceId,fileName,saveDirectory,userId, currDate, attachmentTypeId );
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
}