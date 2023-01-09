/*package com.lonar.vendor.vendorportal.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.jdo.annotations.Transactional;

import org.apache.commons.io.FilenameUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lonar.vendor.vendorportal.dao.LtMastCompanyDao;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtMastCompany;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.model.SysVariableWithValues;
import com.lonar.vendor.vendorportal.repository.LtMastCompanyRepository;


@Service
public class LtMastCompanyServiceImpl implements LtMastCompanyService,CodeMaster
{
	@Autowired
	LtMastCompanyDao ltMastCompanyDao;
	
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	@Autowired
	LtMastSysVariablesService ltMastSysVariablesService;
	
	@Autowired
	LtMastCompanyRepository ltMastCompanyRepository;
	
	@Transactional
	@Override
	public ResponseEntity getLtMastCompanyBycompanyId(Long companyId) throws ServiceException  {
		LtMastCompany ltMastCompany  = ltMastCompanyDao.getLtMastCompanyBycompanyId(companyId);
		if(ltMastCompany.getLogoPath()!=null)
		{
			String myFile = FilenameUtils.getBaseName(ltMastCompany.getLogoPath())
                + "." + FilenameUtils.getExtension(ltMastCompany.getLogoPath());
			ltMastCompany.setFileName(myFile);
		}
		return new ResponseEntity(ltMastCompany, HttpStatus.OK);
	}

	@Transactional
	@Override
	public ResponseEntity getAllLtMastCompany()  throws ServiceException {
		List<LtMastCompany> ltMastCompanyList=null;
		
			ltMastCompanyList= ltMastCompanyDao.getAllLtMastCompany();
		
		return new ResponseEntity<List<LtMastCompany>>(ltMastCompanyList, HttpStatus.OK);
		
	}

	@Transactional
	@Override
	public Status saveLtMastCustomers(LtMastCompany ltMastCompany,MultipartFile[] files)  throws ServiceException
	{
		Status status=new Status();
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
			ltMastCompany.setCreationDate(new Date());
			ltMastCompany.setLastUpdateDate(new Date());
			if(ltMastCompanyDao.save(ltMastCompany)) {
			if(ltMastCompany.getCompanyId() !=null )
			{
				ltMastCompany.setCompanyId(ltMastCompany.getCompanyId());
				Status status1=imageUpload(files,ltMastCompany);
				if(status1.getCode()==INSERT_SUCCESSFULLY)
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
					if(ltMastCompanyDao.delete(ltMastCompany.getCompanyId())){
					if(status1.getMessage()==null)
					{
						status1.setCode(EXCEPTION);
						status1.setMessage("Error in finding message! The action was unsuccessful");
					}
					return status1;
				}
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
		
		
		return status;
		
	}

	@Transactional
	@Override
	public Status update(LtMastCompany ltMastCompany,MultipartFile[] files)  throws ServiceException 
	{
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
				if(ltMastCompanyDao.update(ltMastCompany))
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
	
	public boolean chkNull(LtMastCompany ltMastCompany)
	{
		if(ltMastCompany.getCompanyName()==null || ltMastCompany.getAddress_1() == null || 
		   ltMastCompany.getAddress_2()==null || ltMastCompany.getAddress_3()==null ||
			ltMastCompany.getCity()== null || ltMastCompany.getState() == null ||
			ltMastCompany.getGstNumber()==null ||ltMastCompany.getPinCode() == null ||
			ltMastCompany.getPanNumber() == null||
			ltMastCompany.getLastUpdateLogin()==null || ltMastCompany.getStartDate()==null  || 
			ltMastCompany.getStatus()==null || ltMastCompany.getCreationDate()==null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
		
	public String checkForDuplicate(LtMastCompany ltMastCompany) throws ServiceException 
	{
		String stat=null;
		LtMastCompany company = ltMastCompanyDao.getByCompanyName(ltMastCompany);
		
		if(company!=null  )
		{
			if(ltMastCompany.getCompanyId()==null)
			{
				stat="Company Name Already exists."; 
			}
			else if(ltMastCompany.getCompanyId()!=company.getCompanyId() )
			{ stat="Company Name Already exists."; }
			
			return stat;
		}
		company = ltMastCompanyDao.getByPanNumber(ltMastCompany);
		
		if(company!=null  )
		{
			if(ltMastCompany.getCompanyId()==null)
			{
			 stat=" PAN Number Already exists."; 
			}
			else if(ltMastCompany.getCompanyId()!=company.getCompanyId() )
			{ stat=" PAN Number Already exists."; }
			
			return stat;
		}
		company = ltMastCompanyDao.getByGstNumber(ltMastCompany);
		if(company!=null  )
		{
			if(ltMastCompany.getCompanyId()==null){
			 stat=" GST Number Already exists."; 
			}
			else if(ltMastCompany.getCompanyId()!=company.getCompanyId() ){ 
				stat=" GST Number Already exists."; 
			}
			
			return stat;
		}
		
		
		return stat;
	}

	@Transactional
	@Override
	public ResponseEntity getLtMastCompanyLikecompanyName(String companyName) throws ServiceException {
		List<LtMastCompany> ltMastCompanyList=null;
		
			ltMastCompanyList=ltMastCompanyDao.getLtMastCompanyLikecompanyName(companyName);
	
		return new ResponseEntity<List<LtMastCompany>>(ltMastCompanyList, HttpStatus.OK);
	
	}

	@Transactional
	@Override
	public ResponseEntity<Status> delete(Long companyId) throws ServiceException 
	{
		Status status=new Status();
		
		
		if(ltMastCompanyDao.delete(companyId))
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
	
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}

	@Transactional
	@Override
	public Long getCount(LtMastCompany input) throws Exception {
		return ltMastCompanyDao.getCount(input);
	}

	@Transactional
	@Override
	public List<LtMastCompany> getDatatableRecords(LtMastCompany input) throws Exception
	{
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
		return ltMastCompanyDao.getDatatableRecords(input);
	}
	
	
	public Status imageUpload(MultipartFile[] files,LtMastCompany ltMastCompany) throws ServiceException
	{
		Status status=new Status();
		String fileName;
		String saveDirectory=null;
		SysVariableWithValues sysVariableWithValues=
				ltMastSysVariablesService.getBySysVariableName("IMAGE_UPLOAD_FOLDER_PATH");
	
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
           if( ltMastCompanyDao.update(ltMastCompany))
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

	@Transactional
	@Override
	public ResponseEntity getAllActiveLtMastCompany() throws ServiceException {
		List<LtMastCompany> ltMastCompanyList=null;
		
			ltMastCompanyList= ltMastCompanyDao.getAllActiveLtMastCompany();
		
		return new ResponseEntity<List<LtMastCompany>>(ltMastCompanyList, HttpStatus.OK);
	
	}

	@Transactional
	@Override
	public ResponseEntity<Status> save(LtMastCompany ltMastCompany, MultipartFile[] files) throws ServiceException, JsonParseException, JsonMappingException, IOException {
		String stat = null;
		Status status = new Status();
		
		JSONParser jsonparser = new JSONParser();
		JSONObject jsonInputObject = null;
		
		
			jsonInputObject = (JSONObject) jsonparser.parse(strltMastCompany);
			LtMastCompany ltMastCompany = new ObjectMapper().readValue(strltMastCompany,
					LtMastCompany.class);

		
			 stat = checkForDuplicate(ltMastCompany);
			if(stat == null)
			{
				ltMastCompany.setLastUpdateDate(new Date());
				ltMastCompany.setCreationDate(new Date());
				ltMastCompany = ltMastCompanyRepository.save(ltMastCompany);
				//Long employeeId=ltMastEmployeesDao.save(ltMastEmployees);
				if(ltMastCompany.getCompanyId()!=null)
				{
					if(files.length> 0)
					{
					Status status1=imageUpload(files,ltMastCompany);
					
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
						if(ltMastCompanyDao.delete(ltMastCompany.getCompanyId()))
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
					else
					{
						status=ltMastCommonMessageService.getCodeAndMessage(INSERT_SUCCESSFULLY);
			               if( status.getMessage()==null)
			               {
			            	status.setCode(SUCCESS);
			            	status.setMessage("Error in finding message! The action is completed successfully.");
			               }
						
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
			else
			{
				status.setMessage(stat);
				status.setCode(EXCEPTION);
			}
		
			
			return new ResponseEntity<Status>(status, HttpStatus.OK);
		}
			//status=ltMastCompanyService.save(ltMastCompany,files);
			
	
		
		
		
		
		

	
}
*/