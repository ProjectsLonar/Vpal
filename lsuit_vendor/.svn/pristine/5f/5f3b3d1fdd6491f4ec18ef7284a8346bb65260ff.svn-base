package com.lonar.vendor.vendorportal.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.jdo.annotations.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lonar.vendor.vendorportal.dao.LtMastVendorAttachmentDao;
import com.lonar.vendor.vendorportal.dao.LtMastVendorsDao;
import com.lonar.vendor.vendorportal.model.LtMastVendorAttachment;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.model.SysVariableWithValues;
import com.lonar.vendor.vendorportal.repository.LtMastVendorAttachmentRepository;

@Service
public class LtMastVendorAttachmentServiceImpl implements LtMastVendorAttachmentService 
{
	@Autowired
	LtMastVendorsDao ltMastVendorsDao;
	
	@Autowired
	LtMastVendorAttachmentDao ltMastVendorAttachmentDao;
	
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	@Autowired
	LtMastSysVariablesService ltMastSysVariablesService;
	
	@Autowired
	LtMastVendorAttachmentRepository ltMastVendorAttachmentRepository;
	
	private String saveDirectory;
	
	@Autowired
	private Environment env;
	
	@Autowired
	private MessageSource messageSource;
	
//====================================================================================================================================
	@Transactional
	@Override
	public List<LtMastVendorAttachment> getAllFilesByVendorId(Long vendorId) throws ServiceException 
	{
		return ltMastVendorAttachmentDao.getAllFilesByVendorId(vendorId);
	}

	@Transactional
	@Override
	public Status delete(String expenceHeaderId) throws ServiceException
	{
		Status status = new Status();

		if (ltMastVendorAttachmentDao.delete(expenceHeaderId)) {
			status = ltMastCommonMessageService.getCodeAndMessage(DELETE_SUCCESSFULLY);
			if (status.getMessage() == null) {
				status.setCode(SUCCESS);
				status.setMessage("Error in finding message! The action is completed successfully.");
			}
		} else {
			status = ltMastCommonMessageService.getCodeAndMessage(DELETE_FAIL);
			if (status.getMessage() == null) {
				status.setCode(EXCEPTION);
				status.setMessage("Error in finding message! The action was unsuccessful");
			}
		}

		return status;
	}
	
//====================================================================================================================================
	@Transactional
	@Override
	public Status deleteLtMastVendorAttachment(Long expenseFileUploadId) throws ServiceException {
		Status status = new Status();
		if(ltMastVendorAttachmentDao.deleteLtMastVendorAttachment(expenseFileUploadId))
		{
			status=ltMastCommonMessageService.getCodeAndMessage(DELETE_SUCCESSFULLY);
			if( status.getMessage()==null)
			{
				status.setCode(SUCCESS);
				status.setMessage("Error in finding message! The action is completed successfully.");
			}
		}
		else
		{
			status=ltMastCommonMessageService.getCodeAndMessage(DELETE_FAIL);
			if( status.getMessage()==null)
			{
				status.setCode(FAIL);
				status.setMessage("Error in finding message! The action is completed UnSuccessfully.");
			}
		}
		return status;
	}

//====================================================================================================================================
	@Transactional
	@Override
	public ResponseEntity<Status> saveAttachments(String apiUrl, String[] names, String ltMastVendorAttachment,
			MultipartFile[] files) 
	{
		String openFilePath = "";
		SysVariableWithValues sysVariableWithValues;
		try {
			sysVariableWithValues = ltMastSysVariablesService.getBySysVariableName("EXPENSE_ATTACH_OPEN_PATH",null);
			if (sysVariableWithValues != null) {
				if (sysVariableWithValues.getLtMastSysVariableValues().get(0) != null) {
					openFilePath = sysVariableWithValues.getLtMastSysVariableValues().get(0).getUserValue()
							+ "VendorAttachment/";
				} else {
					openFilePath = sysVariableWithValues.getLtMastSysVariables().getSystemValue() + "VendorAttachment/";
				}
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Status status = new Status();
		// String fileName = null;
		List<String> fileUploadMsg = new ArrayList<>();

		ObjectMapper objectMapper = new ObjectMapper();

		List<LtMastVendorAttachment> ltMastVendorAttachmentList = new ArrayList<LtMastVendorAttachment>();

		try {

			Class<?> clz = Class.forName("com.lonar.mast.model.LtMastVendorAttachment");

			JavaType type = objectMapper.getTypeFactory().constructCollectionType(List.class, clz);
			ltMastVendorAttachmentList = objectMapper.readValue(ltMastVendorAttachment, type);

			
			// File dir = new File(env.getProperty("FILE_UPLOAD_FOLDER_PATH") +
			// "ExpAttach/");
			String filePath = null;
			Status status1 = ltMastVendorsDao.getCompanyByVendor(ltMastVendorAttachmentList.get(0).getVendorId());
			Long companyId = (Long) status1.getData();
			sysVariableWithValues = ltMastSysVariablesService.getBySysVariableName("FILE_UPLOAD_FOLDER_PATH",companyId);
			if (sysVariableWithValues != null) {
				if (sysVariableWithValues.getLtMastSysVariableValues().get(0) != null) {
					filePath = sysVariableWithValues.getLtMastSysVariableValues().get(0).getUserValue()
							+ "VendorAttachment/";
				} else {
					filePath = sysVariableWithValues.getLtMastSysVariables().getSystemValue() + "VendorAttachment/";
				}
			}
			File dir = new File(filePath);
			if (!dir.exists())
				dir.mkdirs();

			for (int i = 0; i < files.length; i++) {
				LtMastVendorAttachment ltMastVendorAttachmentObject = ltMastVendorAttachmentList.get(i);
				MultipartFile file = files[i];

				try {
					byte[] bytes = file.getBytes();

					// Create the file on server
					String[] fileFrags = file.getOriginalFilename().split("\\.");
					String extension = fileFrags[fileFrags.length - 1];

					if (names[i].length() > 255) {
						names[i] = names[i].substring(0, 240 - extension.length()) + "." + extension;
					}

					File serverFilePath = new File(new String(filePath + names[i]).replaceAll("&amp;", ""));

					BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFilePath));

					stream.write(bytes);

					stream.close();

					ltMastVendorAttachmentObject.getFilePath().replaceAll("&amp;", "");

					if (ltMastVendorAttachmentObject.getFilePath().length() > 255) {

						ltMastVendorAttachmentObject.setFilePath(
								ltMastVendorAttachmentObject.getFilePath().substring(0, 240 - extension.length()) + "."
										+ extension);

					}

					ltMastVendorAttachmentObject.setCreationDate(new Date());

					ltMastVendorAttachmentObject
							.setFilePath(openFilePath + "/" + ltMastVendorAttachmentObject.getFileName());

					//For Validation
					List<LtMastVendorAttachment> ltMastVendorAttachmentList1 = new ArrayList<LtMastVendorAttachment>();
					
					ltMastVendorAttachmentList1 = ltMastVendorAttachmentDao.getAllFilesByVendorId(ltMastVendorAttachmentObject.getVendorId());
					
					/*for (Iterator iterator = ltMastVendorAttachmentList1.iterator(); iterator.hasNext();) {
						LtMastVendorAttachment ltMastVendorAttachment2 = (LtMastVendorAttachment) iterator.next();

						if (!ltMastVendorAttachment2.getVendorAttachmentType()
								.equals(ltMastVendorAttachmentObject.getVendorAttachmentType())
								&& !ltMastVendorAttachment2.getFileName()
										.equals(ltMastVendorAttachmentObject.getFileName())) {

							ltMastVendorAttachmentRepository.save(ltMastVendorAttachmentObject);

							status = ltMastCommonMessageService.getCodeAndMessage(FILE_UPLOADED_SUCESSFULLY);
							fileUploadMsg.add(names[i] + " " + messageSource.getMessage("fileuploadedsucessfully", null,
									"Default", Locale.getDefault()));

							break;
						} else {
							status = ltMastCommonMessageService
									.getCodeAndMessage(SAME_FILE_NAME_AND_ATTACHMENT_TYPE_ALREADY_EXIST);
							if (status.getMessage() == null) {
								status.setCode(FAIL);
								status.setMessage("Same file name and attachment type already exists");

							}
							break;

						}
					}*/
					
					ltMastVendorAttachmentRepository.save(ltMastVendorAttachmentObject);

					status = ltMastCommonMessageService.getCodeAndMessage(FILE_UPLOADED_SUCESSFULLY);
					fileUploadMsg.add(names[i] + " " + messageSource.getMessage("fileuploadedsucessfully", null,
							"Default", Locale.getDefault()));
					
					// }
				} catch (MaxUploadSizeExceededException e) {
					e.printStackTrace();
					status = ltMastCommonMessageService.getCodeAndMessage(INTERNAL_SERVER_ERROR);

				} catch (Exception e) {
					e.printStackTrace();
					status = ltMastCommonMessageService.getCodeAndMessage(INTERNAL_SERVER_ERROR);

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			status = ltMastCommonMessageService.getCodeAndMessage(INTERNAL_SERVER_ERROR);

		}
		// status.setCode(INSERT_SUCCESSFULLY);

		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}
//====================================================================================================================================
	@Transactional
	@Override
	public Status deleteLtMastVendorAttachmentFile(Long vendorAttachmentId) {
		Status status = new Status();
		if(ltMastVendorAttachmentDao.deleteLtMastVendorAttachmentFile(vendorAttachmentId))
		{
			status=ltMastCommonMessageService.getCodeAndMessage(DELETE_SUCCESSFULLY);
			if( status.getMessage()==null)
			{
				status.setCode(SUCCESS);
				status.setMessage("Error in finding message! The action is completed successfully.");
			}
			status.setMessage("The attachment has been deleted successfully.");
		}
		else
		{
			status=ltMastCommonMessageService.getCodeAndMessage(DELETE_FAIL);
			if( status.getMessage()==null)
			{
				status.setCode(FAIL);
				status.setMessage("Error in finding message! The action is completed UnSuccessfully.");
			}
		}
		return status;
	}

	@Override
	public LtMastVendorAttachment getAttachmentByVendorIdAndType(Long vendorId) throws ServiceException {
		return ltMastVendorAttachmentDao.getAttachmentByVendorIdAndType(vendorId);
	}

	@Override
	public Status checkRecord(Long venId) throws ServiceException {
		Status status = new Status();
		List<LtMastVendorAttachment> list=ltMastVendorAttachmentDao.getAllFilesByVendorId(venId);		
		if(list==null) {
			status.setCode(FAIL);
			status.setMessage("Please fill all the mandatory attachments");
		}
		else {
			status.setCode(SUCCESS);
		}
		return status;
	}
	
	
//====================================================================================================================================
}
