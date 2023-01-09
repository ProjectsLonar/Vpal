package com.lonar.vendor.vendorportal.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.jdo.annotations.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.lonar.vendor.vendorportal.dao.LtMastVendorAgreementAttachmentDao;
import com.lonar.vendor.vendorportal.dao.LtMastVendorsDao;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.model.SysVariableWithValues;

@Service
public class LtMastVendorAgreementAttachmentServiceImpl implements LtMastVendorAgreementAttachmentService
{
	@Autowired
	LtMastVendorsDao ltMastVendorsDao;
	
	@Autowired
	LtMastSysVariablesService ltMastSysVariablesService;

	@Autowired
	LtMastVendorAgreementAttachmentDao vendorAgreementAttachmentDao;
	
	private String saveAttachmentDirectory;
	
	
	
	@Transactional
	@Override
	public String multipleSave(MultipartFile[] files, Long vendorId,Long venAgreementId) throws ServiceException, IOException 
	{
		String fileName = null;
    	String msg = "";
    	Status status = ltMastVendorsDao.getCompanyByVendor(vendorId);
    	Long companyId = Long.parseLong(status.getData().toString());
		
		SysVariableWithValues sysVariableWithValues=
			ltMastSysVariablesService.getBySysVariableName("VENDOR_ATTACHMENT_FOLDER_PATH",companyId);

		if(sysVariableWithValues!=null)
		{
			if(sysVariableWithValues.getLtMastSysVariableValues().get(0)!=null)
			{
				saveAttachmentDirectory=sysVariableWithValues.getLtMastSysVariableValues().get(0).getUserValue();
			}
			else
			{
				saveAttachmentDirectory=sysVariableWithValues.getLtMastSysVariables().getSystemValue();
			}
		}
		File dir = new File(saveAttachmentDirectory);
		if (!dir.exists())
			dir.mkdirs();

		for(int i =0 ;i< files.length; i++)
		{
				fileName = files[i].getOriginalFilename();
				byte[] bytes = files[i].getBytes();
				BufferedOutputStream buffStream = 
                new BufferedOutputStream(new FileOutputStream(new File(saveAttachmentDirectory + fileName)));
				buffStream.write(bytes);
        
				
				/*if(!vendorAgreementAttachmentDao.multipleSave(vendorId,fileName,saveAttachmentDirectory))
				{
					return msg+="failed";
				}
				else*/
					msg+="success";
       	
		
				buffStream.close();
		}

		return msg;
	}

}
