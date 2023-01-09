package com.lonar.vendor.vendorportal.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.lonar.vendor.vendorportal.dao.LtMastSysVariablesDao;
import com.lonar.vendor.vendorportal.dao.LtVendCompanyAttachmentsDao;
import com.lonar.vendor.vendorportal.dao.LtVendCompanyClientDetailsDao;
import com.lonar.vendor.vendorportal.dao.LtVendCompanyCocDao;
import com.lonar.vendor.vendorportal.dao.LtVendCompanyDao;
import com.lonar.vendor.vendorportal.dao.LtVendCompanyMgmtDdetailsDao;
import com.lonar.vendor.vendorportal.dao.LtVendCompanyMiscellaneousDao;
import com.lonar.vendor.vendorportal.dao.LtVendCompanySistConcernDao;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.CompanyMgmt;
import com.lonar.vendor.vendorportal.model.LtVendCompany;
import com.lonar.vendor.vendorportal.model.LtVendCompanyAttachments;
import com.lonar.vendor.vendorportal.model.LtVendCompanyClientDetails;
import com.lonar.vendor.vendorportal.model.LtVendCompanyCoc;
import com.lonar.vendor.vendorportal.model.LtVendCompanyMgmtDdetails;
import com.lonar.vendor.vendorportal.model.LtVendCompanyMiscellaneous;
import com.lonar.vendor.vendorportal.model.LtVendCompanySistConcern;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.model.SysVariableWithValues;



@Service
public class LtVendCompanyServiceImpl implements LtVendCompanyService,CodeMaster
{
	@Autowired
	LtVendCompanyDao ltVendCompanyDao;
	
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	@Autowired
	LtMastSysVariablesService ltMastSysVariablesService;
	
	/*@Autowired
	LtMastCompanyRepository ltMastCompanyRepository;*/

	@Autowired
	LtVendCompanyMiscellaneousDao ltVendCompanyMiscellaneousDao;
	
	@Autowired
	LtVendCompanyMgmtDdetailsDao ltVendCompanyMgmtDdetailsDao;
	
	@Autowired
	LtVendCompanyCocDao ltVendCompanyCocDao;
	
	@Autowired
	LtVendCompanyClientDetailsDao ltVendCompanyClientDetailsDao;
	
	@Autowired
	LtVendCompanyAttachmentsDao ltVendCompanyAttachmentsDao;
	
	@Autowired
	LtVendCompanySistConcernDao ltVendCompanySistConcernDao;
	
	@Autowired
	LtMastSysVariablesDao ltMastSysVariablesDao;
	
	@Override
	public ResponseEntity getLtMastCompanyBycompanyId(Long companyId) throws ServiceException {
		LtVendCompany ltVendCompany  = ltVendCompanyDao.getLtVendCompanyBycompanyId(companyId);
		if(ltVendCompany.getLogoPath()!=null)
		{
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
			
			
			String myFile = FilenameUtils.getBaseName(ltVendCompany.getLogoPath())
                + "." + FilenameUtils.getExtension(ltVendCompany.getLogoPath());
			
			ltVendCompany.setFileName(myFile);
			ltVendCompany.setLogoPath(saveDirectory+myFile);
		}
		return new ResponseEntity(ltVendCompany, HttpStatus.OK);
	}

	@Override
	public ResponseEntity getAllLtVendMastCompany() throws ServiceException {
		List<LtVendCompany> ltMastCompanyList= ltVendCompanyDao.getAllLtVendCompany();
	
	return new ResponseEntity<List<LtVendCompany>>(ltMastCompanyList, HttpStatus.OK);
	}

	@Override
	public ResponseEntity getLtVendMastCompanyLikecompanyName(String companyName) throws ServiceException {
		List<LtVendCompany> ltMastCompanyList=ltVendCompanyDao.getLtVendCompanyLikecompanyName(companyName);

	return new ResponseEntity<List<LtVendCompany>>(ltMastCompanyList, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Status> delete(Long companyId) throws ServiceException {
		Status status=new Status();
		try {
		if(ltVendCompanyDao.delete(companyId))
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
			if(status.getMessage()==null)
			{
				status.setCode(EXCEPTION);
				status.setMessage("Error in finding message! The action was unsuccessful");
			}
		}
		}catch(Exception e) {
			//e.printStackTrace();
			status=ltMastCommonMessageService.getCodeAndMessage(CANNOT_DELETE);
			if(status.getMessage()==null)
			{
				status.setCode(EXCEPTION);
				status.setMessage("Error in finding message! The action was unsuccessful");
			}
		}
	
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}

	@Override
	public Long getCount(Long companyId,LtVendCompany input) throws Exception {
		return ltVendCompanyDao.getCount(companyId,input);
	}

	@Override
	public List<LtVendCompany> getDatatableRecords(Long companyId,LtVendCompany input) throws Exception {
		if(input.getColumnNo()==1 && input.getSort().equals("desc"))
		{
			input.setColumnNo(11);
		}
		if(input.getColumnNo()==2 && input.getSort().equals("desc"))
		{
			input.setColumnNo(12);
		}
		if(input.getColumnNo()==3 && input.getSort().equals("desc"))
		{
			input.setColumnNo(13);
		}
		if(input.getColumnNo()==4 && input.getSort().equals("desc"))
		{
			input.setColumnNo(14);
		}
		if(input.getColumnNo()==5 && input.getSort().equals("desc"))
		{
			input.setColumnNo(15);
		}
		if(input.getColumnNo()==6 && input.getSort().equals("desc"))
		{
			input.setColumnNo(16);
		}
		
		if(input.getColumnNo()==7 && input.getSort().equals("desc"))
		{
			input.setColumnNo(17);
		}
		
		if(input.getColumnNo()==8 && input.getSort().equals("asc"))
		{
			input.setColumnNo(18);
		}
		return ltVendCompanyDao.getDatatableRecords(companyId,input);
	}

	@Override
	public Status update(LtVendCompany ltMastCompany, MultipartFile[] files) throws ServiceException {
		Status status=new Status();
		if(ltMastCompany.getCompanyId()!=null)
		{
			if(chkNull(ltMastCompany))
			{
				status=ltMastCommonMessageService.getCodeAndMessage(INPUT_IS_EMPTY);
				if(status.getMessage()==null)
				{
					status.setCode(EXCEPTION);
					status.setMessage("Error in finding message! The action was unsuccessful");
				}
			}
			
			String stat=checkForDuplicate(ltMastCompany);
			
			if( stat== null)
			{
				ltMastCompany.setLastUpdateDate(new Date());
				if(ltVendCompanyDao.update(ltMastCompany))
				{
					Status status1=null;
					if(files.length> 0)
					{
					 status1=imageUpload(files,ltMastCompany);
					
					if(status1.getCode()==INSERT_SUCCESSFULLY)
					{
						status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_SUCCESSFULLY);
						if( status.getMessage()==null)
						{
						status.setCode(SUCCESS);
						status.setMessage("Error in finding message! The action is completed successfully.");
						}
					}
					else
					{
						if(status1.getMessage()==null)
						{
						status1.setCode(EXCEPTION);
						status1.setMessage("Error in finding message! The action was unsuccessful");
						}
						return status1;
					}
					}
					else
					{
						status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_SUCCESSFULLY);
						if( status.getMessage()==null)
						{
						status.setCode(SUCCESS);
						status.setMessage("Error in finding message! The action is completed successfully.");
						}
						
					}
				}
				else
				{
					status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_FAIL);
					if( status.getMessage()==null)
					{
						status.setCode(SUCCESS);
						status.setMessage("Error in finding message! The action is completed successfully.");
					}
					return status;
				}
			}
			else
			{
				status.setCode(FAIL);
				status.setMessage(stat);
			}
		}
		else
		{
			status=ltMastCommonMessageService.getCodeAndMessage(INPUT_IS_EMPTY);
			if(status.getMessage()==null)
			{
				status.setCode(EXCEPTION);
				status.setMessage("Error in finding message! The action was unsuccessful");
			}
		}
		return status;
	}

	@Override
	public ResponseEntity getAllActiveLtVendMastCompany() throws ServiceException {
		List<LtVendCompany> ltMastCompanyList=ltVendCompanyDao.getAllActiveLtVendMastCompany();

		return new ResponseEntity<List<LtVendCompany>>(ltMastCompanyList, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Status> save(LtVendCompany ltVendCompany, MultipartFile[] files)
			throws ServiceException, JsonParseException, JsonMappingException, IOException {
		Status status=new Status();
		if(chkNull(ltVendCompany))
		{
			status=ltMastCommonMessageService.getCodeAndMessage(INPUT_IS_EMPTY);
			if(status.getMessage()==null)
			{
				status.setCode(EXCEPTION);
				status.setMessage("Error in finding message! The action was unsuccessful");
			}
		}
			
		String stat=checkForDuplicate(ltVendCompany);
		if( stat== null)
		{
			ltVendCompany.setCreationDate(new Date());
			ltVendCompany.setLastUpdateDate(new Date());
			if(ltVendCompanyDao.save(ltVendCompany)) {
			if(ltVendCompany.getCompanyId() !=null )
			{
				ltVendCompany.setCompanyId(ltVendCompany.getCompanyId());
				if(files.length > 0) 
				{
				Status status1=imageUpload(files,ltVendCompany);
				if(status1.getCode()==INSERT_SUCCESSFULLY)
				{
					status=ltMastCommonMessageService.getCodeAndMessage(INSERT_SUCCESSFULLY);
					if( status.getMessage()==null)
					{
						status.setCode(SUCCESS);
						status.setMessage("Error in finding message! The action is completed successfully.");
					}
					status.setData(ltVendCompany.getCompanyId());
				}
				else
				{
					if(ltVendCompanyDao.delete(ltVendCompany.getCompanyId())){
					if(status1.getMessage()==null)
					{
						status1.setCode(EXCEPTION);
						status1.setMessage("Error in finding message! The action was unsuccessful");
					}
					return new ResponseEntity<Status>(status1, HttpStatus.OK);
				
				}
			  }
			}else {
				status=ltMastCommonMessageService.getCodeAndMessage(INSERT_SUCCESSFULLY);
				if( status.getMessage()==null)
				{
					status.setCode(SUCCESS);
					status.setMessage("Error in finding message! The action is completed successfully.");
				}
				status.setData(ltVendCompany.getCompanyId());
			}
		}
		else
		{
			status=ltMastCommonMessageService.getCodeAndMessage(INSERT_FAIL);
			if( status.getMessage()==null)
			{
				status.setCode(SUCCESS);
				status.setMessage("Error in finding message! The action was unsuccessful.");
			}
		}
			}
		}
		else
		{
			status.setCode(FAIL);
			status.setMessage(stat);
			
		}
		
		return new ResponseEntity<Status>(status, HttpStatus.OK);
		
	}
	
	public boolean chkNull(LtVendCompany ltMastCompany)
	{
		if(ltMastCompany.getCompanyName()==null || 
			ltMastCompany.getCity()== null || ltMastCompany.getStateId() == null 
			||ltMastCompany.getPinCode() == null ||
			ltMastCompany.getPanNumber() == null||
			ltMastCompany.getLastUpdateLogin()==null || ltMastCompany.getStartDate()==null  || 
			ltMastCompany.getStatus()==null || ltMastCompany.getCreationDate()==null||ltMastCompany.getBusinessGroupId()==null)
		{
			return true;
		}
		else
		{
			
			
			return false;
		}
	}
		
	public String checkForDuplicate(LtVendCompany ltMastCompany) throws ServiceException 
	{
		String stat=null;
		LtVendCompany company = ltVendCompanyDao.getByCompanyName(ltMastCompany);
		if(company!=null  )
		{
			if(ltMastCompany.getCompanyId()==null)
			{
				stat="Company Name Already exists."; 
			}
			else if(!ltMastCompany.getCompanyId().equals(company.getCompanyId()) )
			{
				stat="Company Name Already exists."; }
			
			return stat;
		}
		company = ltVendCompanyDao.getByPanNumber(ltMastCompany);
		
		if(company!=null  )
		{
			if(ltMastCompany.getCompanyId()==null)
			{
			 stat=" PAN Number Already exists."; 
			}
			else if(!ltMastCompany.getCompanyId().equals(company.getCompanyId()) )
			{
				stat=" PAN Number Already exists."; }
			
			return stat;
		}
		company = ltVendCompanyDao.getByGstNumber(ltMastCompany);
		if(company!=null  )
		{
			if(ltMastCompany.getCompanyId()==null){
			 stat=" GST Number Already exists."; 
			}
			else if(!ltMastCompany.getCompanyId().equals(company.getCompanyId()) )
			{
				stat=" GST Number Already exists."; 
			}
			
			return stat;
		}
		
		
		return stat;
	}
	
	
	public Status imageUpload(MultipartFile[] files,LtVendCompany ltMastCompany) throws ServiceException
	{
		Status status=new Status();
		String fileName;
		String saveDirectory=null;
		SysVariableWithValues sysVariableWithValues=
				ltMastSysVariablesService.getBySysVariableName("IMAGE_UPLOAD_FOLDER_PATH",ltMastCompany.getCompanyId());
	
		if(sysVariableWithValues!=null)
		{
			if(sysVariableWithValues.getLtMastSysVariableValues().get(0)!=null)
			{
				saveDirectory=sysVariableWithValues.getLtMastSysVariableValues().get(0).getUserValue();
			}
			else
			{
				saveDirectory=sysVariableWithValues.getLtMastSysVariables().getSystemValue();
			}
		}	
		File dir = new File(saveDirectory);
		if (!dir.exists())
		{
			dir.mkdirs();
			if(!dir.isDirectory())
			{
				status=ltMastCommonMessageService.getCodeAndMessage(NO_DIRECTIVE_EXISTS);
				if(status.getMessage()==null)
				{
					status.setCode(EXCEPTION);
					status.setMessage("Error in finding message! The action was unsuccessful");
				}
			
				return status;
			}
		}	
	
		
		for(int i =0 ;i< files.length; i++)
		{
        try 
        {
            fileName = files[i].getOriginalFilename();
            byte[] bytes = files[i].getBytes();
            BufferedOutputStream buffStream = 
                    new BufferedOutputStream(new FileOutputStream(new File(saveDirectory + fileName)));
            buffStream.write(bytes);
             
            ltMastCompany.setLogoPath(saveDirectory + fileName);
           if( ltVendCompanyDao.update(ltMastCompany))
           {
        	   buffStream.close();
               status=ltMastCommonMessageService.getCodeAndMessage(INSERT_SUCCESSFULLY);
               if( status.getMessage()==null)
               {
            	status.setCode(SUCCESS);
            	status.setMessage("Error in finding message! The action is completed successfully.");
               }
              
           }
           else
           {
               status=ltMastCommonMessageService.getCodeAndMessage(INSERT_FAIL);
   			   if(status.getMessage()==null)
   				{
   					status.setCode(EXCEPTION);
   					status.setMessage("Error in finding message! The action was unsuccessful");
   				}
            }
        	
        } 
        catch (Exception e)
        {
        	e.printStackTrace();
        	 status=ltMastCommonMessageService.getCodeAndMessage(INTERNAL_SERVER_ERROR);
			if(status.getMessage()==null)
			{
				status.setCode(EXCEPTION);
				status.setMessage("Error in finding message! The action was unsuccessful");
			}
        }
	}
		return status;
		
		
	}

	@Override
	public Status deleteAttachment(Long companyId) throws ServiceException {
		Status status = new Status();
		if(ltVendCompanyDao.deleteAttachment(companyId)) {
			status=ltMastCommonMessageService.getCodeAndMessage(DELETE_SUCCESSFULLY);
			if(status.getMessage()==null)
			{
				status.setCode(SUCCESS);
				status.setMessage("Error in finding message! The action was successful");
			}
		}else {
			 status=ltMastCommonMessageService.getCodeAndMessage(DELETE_FAIL);
 			   if(status.getMessage()==null)
 				{
 					status.setCode(EXCEPTION);
 					status.setMessage("Error in finding message! The action was unsuccessful");
 				}
		}
		return status;
	}

	
		@Override
		public ResponseEntity<List<CompanyMgmt>> getMasterMgmtBycompanyId(Long companyId) throws ServiceException
		{
			
			List<CompanyMgmt> list = new ArrayList<>();
			
			LtVendCompanyMiscellaneous ltVendCompanyMiscellaneous =  ltVendCompanyMiscellaneousDao.getBycompanyId(companyId);
			if(ltVendCompanyMiscellaneous!=null) {
				CompanyMgmt companyMgmt = new CompanyMgmt();
			companyMgmt.setMasterName("LtVendCompanyMiscellaneous");
			companyMgmt.setIncludeVendor(ltVendCompanyMiscellaneous.getIncludeVendor());
			companyMgmt.setMandatoryTab(ltVendCompanyMiscellaneous.getMandatoryTab());
			list.add(companyMgmt);
			}
			List<LtVendCompanyMgmtDdetails> l = ltVendCompanyMgmtDdetailsDao.getBycompanyId(companyId);
			if(!l.isEmpty()) {
				//list.clear(); 
				CompanyMgmt companyMgmt = new CompanyMgmt();
			companyMgmt.setMasterName("LtVendCompanyMgmtDdetails");
			companyMgmt.setIncludeVendor(l.get(0).getIncludeVendor());
			companyMgmt.setMandatoryTab(l.get(0).getMandatoryTab());
			list.add(companyMgmt);
			}
			List<LtVendCompanyCoc> l1 = ltVendCompanyCocDao.getBycompanyId(companyId);
			if(!l1.isEmpty()) {
				CompanyMgmt companyMgmt = new CompanyMgmt();
			companyMgmt.setMasterName("LtVendCompanyCoc");
			companyMgmt.setIncludeVendor(l1.get(0).getIncludeVendor());
			companyMgmt.setMandatoryTab(l1.get(0).getMandatoryTab());
			list.add(companyMgmt);
			}
			List<LtVendCompanyClientDetails> l2 = ltVendCompanyClientDetailsDao.getBycompanyId(companyId);
			if(!l2.isEmpty()) {
				CompanyMgmt companyMgmt = new CompanyMgmt(); 
			companyMgmt.setMasterName("LtVendCompanyClientDetails");
			companyMgmt.setIncludeVendor(l2.get(0).getIncludeVendor());
			companyMgmt.setMandatoryTab(l2.get(0).getMandatoryTab());
			list.add(companyMgmt);
			}
			List<LtVendCompanyAttachments> l3 = ltVendCompanyAttachmentsDao.getBycompanyId(companyId);
			if(!l3.isEmpty()) {
				CompanyMgmt companyMgmt = new CompanyMgmt(); 
			companyMgmt.setMasterName("LtVendCompanyAttachments");
			companyMgmt.setIncludeVendor(l3.get(0).getIncludeVendor());
			companyMgmt.setMandatoryTab(l3.get(0).getMandatoryTab());
			list.add(companyMgmt);
			}
			
			List<LtVendCompanySistConcern> l4 = ltVendCompanySistConcernDao.getBycompanyId(companyId);
			if(!l4.isEmpty()) {
				CompanyMgmt companyMgmt = new CompanyMgmt(); 
			companyMgmt.setMasterName("LtVendCompanySistConcern");
			companyMgmt.setIncludeVendor(l4.get(0).getIncludeVendor());
			companyMgmt.setMandatoryTab(l4.get(0).getMandatoryTab());
			list.add(companyMgmt);
			}
			
			
			return new ResponseEntity<List<CompanyMgmt>>(list, HttpStatus.OK);
		}
	

	
}
