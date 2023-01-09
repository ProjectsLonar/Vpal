package com.lonar.vendor.vendorportal.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lonar.vendor.vendorportal.dao.LtMastSysVariablesDao;
import com.lonar.vendor.vendorportal.dao.LtMastVendorCocDao;
import com.lonar.vendor.vendorportal.dao.LtMastVendorsDao;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtMastVendorCoc;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.model.SysVariableWithValues;

@Service
public class LtMastVendorCocServiceImpl implements LtMastVendorCocService, CodeMaster{

	@Autowired
	LtMastVendorsDao ltMastVendorsDao;
	
	@Autowired
	LtMastVendorCocDao ltMastVendorCocDao;
	
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	@Autowired
	LtMastSysVariablesDao ltMastSysVariablesDao;
	
	@Override
	public LtMastVendorCoc getAttachmentByVendorId(Long vendorId) throws ServiceException {
		LtMastVendorCoc ltMastVendorCoc =  ltMastVendorCocDao.getAttachmentByVendorId(vendorId);
		if(ltMastVendorCoc!=null) {
			Status status = ltMastVendorsDao.getCompanyByVendor(vendorId);
			Long companyId = Long.parseLong(status.getData().toString());
			
			String saveDirectory = null;
			List<SysVariableWithValues> sysVariableWithValuesList=
				ltMastSysVariablesDao.getBySysVariableName("FILE_OPEN_PATH",companyId);
		
			if(sysVariableWithValuesList!=null)
			{
				if(sysVariableWithValuesList.get(0).getLtMastSysVariableValues().get(0)!=null)
				{
					saveDirectory=sysVariableWithValuesList.get(0).getLtMastSysVariableValues().get(0).getUserValue();
				}
				else
				{
					saveDirectory=sysVariableWithValuesList.get(0).getLtMastSysVariables().getSystemValue();
				}
			}
			/*String myFile = FilenameUtils.getBaseName(ltMastVendorCoc.getAttachmentCoc())
                + "." + FilenameUtils.getExtension(ltMastVendorCoc.getAttachmentCoc());*/
			if(saveDirectory!=null) {
				ltMastVendorCoc.setAttachmentCoc(saveDirectory);
			}
		}
		return ltMastVendorCoc;
	}


	@Override
	public Status checkRecord(Long venId) throws ServiceException {
		Status status = new Status();
		LtMastVendorCoc list=ltMastVendorCocDao.getAttachmentByVendorId(venId);
		if(list==null) {
			status.setCode(FAIL);
			status.setMessage("Please fill vendor Coc details");
		}
		else {
			status.setCode(SUCCESS);
		}
		return status;
	}


	@Override
	public Status deleteLtMastVendorCoc(Long vendorId) throws ServiceException {
		Status status = new Status();
		if( ltMastVendorCocDao.deleteLtMastVendorCoc(vendorId)) {
			status=ltMastCommonMessageService.getCodeAndMessage(DELETE_SUCCESSFULLY);
			if(status.getMessage()==null)
			{
				status.setCode(SUCCESS);
				status.setMessage("Error in finding message! The action was successful");
			}
		}else {
			status=ltMastCommonMessageService.getCodeAndMessage(ENTITY_CANNOT_DELETE);
			if(status.getMessage()==null)
			{
				status.setCode(EXCEPTION);
				status.setMessage("Error in finding message! The action was unsuccessful");
			}
		}
		return status;
	}

}
