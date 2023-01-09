package com.lonar.vendor.vendorportal.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.lonar.vendor.vendorportal.dao.LtVendCompanyCocDao;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtVendCompanyCoc;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.model.SysVariableWithValues;
import com.lonar.vendor.vendorportal.repository.LtVendCompanyCocRepository;

@Service
public class LtVendCompanyCocServiceImpl implements LtVendCompanyCocService,CodeMaster{

	@Autowired
	LtVendCompanyCocDao ltVendCompanyCocDao;
	
	@Autowired
	LtVendCompanyCocRepository ltVendCompanyCocRepository;
	
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	@Autowired
	LtMastSysVariablesService ltMastSysVariablesService;
	
	
	@Override
	public List<LtVendCompanyCoc> getBycompanyId(Long companyId) throws ServiceException {
		List<LtVendCompanyCoc> list  = ltVendCompanyCocDao.getBycompanyId(companyId);;
		if(!list.isEmpty()  && list.get(0).getCodeConductId()!=null)
		{
			String myFile = FilenameUtils.getBaseName(list.get(0).getCodeConductId())
                + "." + FilenameUtils.getExtension(list.get(0).getCodeConductId());
			list.get(0).setImgName(myFile);
		}
		return list;
	}

	@Override
	public LtVendCompanyCoc getById(Long id) throws ServiceException {
		// TODO Auto-generated method stub
		return ltVendCompanyCocDao.getById(id);
	}

	@Override
	public List<LtVendCompanyCoc> getAll() throws ServiceException {
		// TODO Auto-generated method stub
		return ltVendCompanyCocDao.getAll();
	}

	@Override
	public List<LtVendCompanyCoc> getAllActive() throws ServiceException {
		// TODO Auto-generated method stub
		return ltVendCompanyCocDao.getAllActive();
	}

	@Override
	public ResponseEntity<Status> save(LtVendCompanyCoc ltVendCompanyCoc, MultipartFile[] files) throws ServiceException {
		Status status = new Status();
		if(ltVendCompanyCoc.getStartDate()==null || ltVendCompanyCoc.getLastUpdateLogin() == null )
		{
			status=ltMastCommonMessageService.getCodeAndMessage(INPUT_IS_EMPTY);
			if( status.getMessage()==null) {
				status.setCode(EXCEPTION);
				status.setMessage("Error in finding message! The action is completed unsuccessfully.");
			}
		}
		ltVendCompanyCoc.setCreationDate(new Date());
		ltVendCompanyCoc.setLastUpdateDate(new Date());
		ltVendCompanyCoc.setCreatedBy(ltVendCompanyCoc.getLastUpdateLogin());
		ltVendCompanyCoc.setLastUpdateLogin(ltVendCompanyCoc.getLastUpdateLogin());
		ltVendCompanyCoc.setLastUpdatedBy(ltVendCompanyCoc.getLastUpdateLogin()); 
		ltVendCompanyCoc = ltVendCompanyCocRepository.save(ltVendCompanyCoc);
		if(ltVendCompanyCoc.getCompConductId()!=null)
		{
			if(files.length <= 0 ) 
			{
				status=ltMastCommonMessageService.getCodeAndMessage(INSERT_SUCCESSFULLY);
				if( status.getMessage()==null) {
					status.setCode(SUCCESS);
					status.setMessage("Error in finding message! The action is completed successfully.");
				}
				status.setData(ltVendCompanyCoc.getCompConductId());
			}
			else
			{
				Status status1=imageUpload(files,ltVendCompanyCoc);
				
				if(status1.getCode()== INSERT_SUCCESSFULLY)
				{
					status=ltMastCommonMessageService.getCodeAndMessage(INSERT_SUCCESSFULLY);
		               if( status.getMessage()==null)
		               {
		            	status.setCode(SUCCESS);
		            	status.setMessage("Error in finding message! The action is completed successfully.");
		               }
		               status.setData(ltVendCompanyCoc.getCompConductId());
				}
				else
				{
					if(ltVendCompanyCocDao.delete(ltVendCompanyCoc.getCompConductId()))
					{
						status=ltMastCommonMessageService.getCodeAndMessage(INSERT_FAIL);
						if(status.getMessage()==null)
						{
							status.setCode(EXCEPTION);
							status.setMessage("Error in finding message! The action was unsuccessful");
						}
					}
				}
			}
		}else
		{
			status=ltMastCommonMessageService.getCodeAndMessage(INSERT_FAIL);
			if( status.getMessage()==null) {
				status.setCode(EXCEPTION);
				status.setMessage("Error in finding message! The action is completed unsuccessfully.");
			}
		}
		    return new ResponseEntity<Status>(status, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Status> update(LtVendCompanyCoc ltVendCompanyCoc, MultipartFile[] files) throws ServiceException {
		Status status = new Status();
		if(ltVendCompanyCoc.getCompConductId()!=null) {
		
			ltVendCompanyCoc.setLastUpdateDate(new Date());
			ltVendCompanyCoc.setLastUpdateLogin(ltVendCompanyCoc.getLastUpdateLogin());
			ltVendCompanyCoc.setLastUpdatedBy(ltVendCompanyCoc.getLastUpdateLogin()); 
			ltVendCompanyCoc = ltVendCompanyCocRepository.save(ltVendCompanyCoc);
			if(ltVendCompanyCoc.getCompConductId()!=null)
			{
				if(files.length < 0) {
				status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_SUCCESSFULLY);
				if( status.getMessage()==null) {
					status.setCode(SUCCESS);
					status.setMessage("Error in finding message! The action is completed successfully.");
				}
			 }
			else {
					Status status1=imageUpload(files,ltVendCompanyCoc);
					
					if(status1.getCode()== INSERT_SUCCESSFULLY)
					{
						status=ltMastCommonMessageService.getCodeAndMessage(INSERT_SUCCESSFULLY);
			               if( status.getMessage()==null)
			               {
			            	status.setCode(SUCCESS);
			            	status.setMessage("Error in finding message! The action is completed successfully.");
			               }
					}
					else
					{
						if(ltVendCompanyCocDao.delete(ltVendCompanyCoc.getCompConductId()))
						{
							status=ltMastCommonMessageService.getCodeAndMessage(INSERT_FAIL);
							if(status.getMessage()==null)
							{
								status.setCode(EXCEPTION);
								status.setMessage("Error in finding message! The action was unsuccessful");
							}
						}
					}
				}
			}
			else
			{
				status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_FAIL);
				if( status.getMessage()==null) {
					status.setCode(EXCEPTION);
					status.setMessage("Error in finding message! The action is completed unsuccessfully.");
				}
			}
		}else {
			status=ltMastCommonMessageService.getCodeAndMessage(INPUT_IS_EMPTY);
			if( status.getMessage()==null) {
				status.setCode(EXCEPTION);
				status.setMessage("Error in finding message! The action is completed unsuccessfully.");
			}
		}
		    return new ResponseEntity<Status>(status, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Status> delete(Long id) throws ServiceException {
		Status status = new Status();
		ltVendCompanyCocRepository.delete(id);
		if (!ltVendCompanyCocRepository.exists(id))
		{
			status=ltMastCommonMessageService.getCodeAndMessage(DELETE_SUCCESSFULLY);
			if( status.getMessage()==null) {
				status.setCode(SUCCESS);
				status.setMessage("Error in finding message! The action is completed successfully.");
			}
		} 
		else 
		{
			status=ltMastCommonMessageService.getCodeAndMessage(ENTITY_CANNOT_DELETE);
			if( status.getMessage()==null) {
				status.setCode(EXCEPTION);
				status.setMessage("Error in finding message! The action is completed unsuccessfully.");
			}
		} 
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}

	
	

	public Status imageUpload(MultipartFile[] files,LtVendCompanyCoc ltVendCompanyCoc) throws ServiceException
	{
		Status status=new Status();
		String fileName;
		String saveDirectory=null;
		SysVariableWithValues sysVariableWithValues=
				ltMastSysVariablesService.getBySysVariableName("IMAGE_UPLOAD_FOLDER_PATH",ltVendCompanyCoc.getCompanyId());
	
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
             
            ltVendCompanyCoc.setCodeConductId(saveDirectory + fileName);
           if( ltVendCompanyCocDao.update(ltVendCompanyCoc))
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
} 
