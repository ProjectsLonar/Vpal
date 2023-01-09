package com.lonar.vendor.vendorportal.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.lonar.vendor.vendorportal.dao.LtMastEmployeesDao;
import com.lonar.vendor.vendorportal.dao.LtMastSysVariablesDao;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtMastEmployees;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.model.SysVariableWithValues;
import com.lonar.vendor.vendorportal.repository.LtMastEmployeesRepository;

@Service
public class LtMastEmployeesServiceImpl implements LtMastEmployeesService,CodeMaster
{
	@Autowired
	LtMastEmployeesDao ltMastEmployeesDao;
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	LtMastEmployeesRepository ltMastEmployeesRepository;
	
	@Autowired
	LtMastSysVariablesDao ltMastSysVariablesDao;
	
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	@Autowired
	LtMastSysVariablesService ltMastSysVariablesService;
	
	@Transactional
	@Override
	public ResponseEntity findBySupervisorEmpId(Long supervisorEmpId) throws ServiceException {
		List<LtMastEmployees>  employees =  ltMastEmployeesDao.findBySupervisorEmpId(supervisorEmpId);
		return new ResponseEntity(employees, HttpStatus.OK); 
	}

	@Transactional
	@Override
	public ResponseEntity findByEmployeeNumber(String employeeNumber) throws ServiceException{
		List<LtMastEmployees>  employees = ltMastEmployeesDao.findByEmployeeNumber(employeeNumber);
		return new ResponseEntity(employees, HttpStatus.OK); 
	}

	@Transactional
	@Override
	public ResponseEntity findByOfficialEmail(String officialEmail) throws ServiceException{
		
		List<LtMastEmployees>  employees = ltMastEmployeesDao.findByOfficialEmail(officialEmail);
		return new ResponseEntity(employees, HttpStatus.OK); 
	}

	@Transactional
	@Override
	public ResponseEntity findByPosition(String position) throws ServiceException{
		
		List<LtMastEmployees>  employees = ltMastEmployeesDao.findByPosition(position);
		return new ResponseEntity(employees, HttpStatus.OK); 
	}

	@Transactional
	@Override
	public ResponseEntity findAllActive() throws ServiceException{
		
		List<LtMastEmployees>  employees = ltMastEmployeesDao.findAllActive();
		return new ResponseEntity(employees, HttpStatus.OK); 
	}

	@Transactional
	@Override
	public ResponseEntity findLikeFirstName(String firstName) throws ServiceException{
		
		List<LtMastEmployees>  employees = ltMastEmployeesDao.findLikeFirstName(firstName);
		return new ResponseEntity(employees, HttpStatus.OK); 
	}

	@Transactional
	@Override
	public ResponseEntity findLikeName(String name) throws ServiceException{
		
		List<LtMastEmployees>  employees = ltMastEmployeesDao.findLikeName(name);
		return new ResponseEntity(employees, HttpStatus.OK); 
	}

	@Transactional
	@Override
	public ResponseEntity findUserNotEmployeeId() throws ServiceException{
		
		List<LtMastEmployees>  employees = ltMastEmployeesDao.findUserNotEmployeeId();
		return new ResponseEntity(employees, HttpStatus.OK); 
	}

	@Transactional
	@Override
	public ResponseEntity findByCostCenterId(Long costCenterId) throws ServiceException{
		
		List<LtMastEmployees>  employees = ltMastEmployeesDao.findByCostCenterId(costCenterId);
		return new ResponseEntity(employees, HttpStatus.OK); 
	}

	public ResponseEntity findByEmployeeName(String name) throws ServiceException{
		List<LtMastEmployees>  employees = ltMastEmployeesDao.findByEmployeeName(name);
		return new ResponseEntity(employees, HttpStatus.OK); 
	}

	@Transactional
	@Override
	public List<LtMastEmployees>  findByActiveLikeName(Long companyId, String name) throws ServiceException 
	{
		List<LtMastEmployees>  list= ltMastEmployeesDao.findByActiveLikeName(companyId, name);
		return list; 
	}

	@Transactional
	@Override
	public String checkDetails(LtMastEmployees ltMastEmployees) throws ServiceException 
	{
		String status=null;
	
		if(ltMastEmployees.getEmployeeNumber()!=null)
		{
			LtMastEmployees emp=ltMastEmployeesDao.getByEmployeeNumber(ltMastEmployees.getEmployeeNumber(),ltMastEmployees.getCompanyId());
			if(emp!=null)
			{
				if(ltMastEmployees.getEmployeeId()!=emp.getEmployeeId() &&
						!emp.getEmployeeId().equals(ltMastEmployees.getEmployeeId()))
				{
					status=messageSource.getMessage("Employee Number is already Exists", null,
						"Employee Number is already Exists", Locale.getDefault());
					return status;
				}
			}
		}
		if( ltMastEmployees.getOfficialEmail()!=null)
		{
			LtMastEmployees emp=ltMastEmployeesDao.getByofficialEmail(ltMastEmployees.getOfficialEmail(),ltMastEmployees.getCompanyId());
			if(emp!=null)
			{
				if(ltMastEmployees.getEmployeeId()!=emp.getEmployeeId() &&
						!emp.getEmployeeId().equals(ltMastEmployees.getEmployeeId()))
				{
					status=messageSource.getMessage("Employee official email is already Exists", null,
						"Employee official email is already Exists", Locale.getDefault());
					return status;
				}
			}
		}
		if(ltMastEmployees.getPersonalEmail()!=null)
		{
			LtMastEmployees emp=ltMastEmployeesDao.getByPersonalEmail(ltMastEmployees.getPersonalEmail(),ltMastEmployees.getCompanyId());
			if(emp!=null)
			{
				if(ltMastEmployees.getEmployeeId()!=emp.getEmployeeId() &&
						!emp.getEmployeeId().equals(ltMastEmployees.getEmployeeId()))
				{
					status=messageSource.getMessage("Employee Personal Email is already Exists", null,
						"Employee Personal Email is already Exists", Locale.getDefault());
					return status;
				}
			}
		}
		if(ltMastEmployees.getPassportNo()!=null )
		{
			LtMastEmployees emp=ltMastEmployeesDao.getByPassportNumber(ltMastEmployees.getPassportNo(),ltMastEmployees.getCompanyId());
			if(emp!=null)
			{
				if(ltMastEmployees.getEmployeeId()!=emp.getEmployeeId() &&
						!emp.getEmployeeId().equals(ltMastEmployees.getEmployeeId()))
				{
					status=messageSource.getMessage("Employee Passport number already exists", null,
					"Passport Number is already Exists", Locale.getDefault());
					return status;
				}
			}
		}
		if(ltMastEmployees.getPanNo()!=null)
		{
			LtMastEmployees emp=ltMastEmployeesDao.getByPanNumber(ltMastEmployees.getPanNo(),ltMastEmployees.getCompanyId());
			if(emp!=null)	
			{
				if(ltMastEmployees.getEmployeeId()!=emp.getEmployeeId() &&
						!emp.getEmployeeId().equals(ltMastEmployees.getEmployeeId()))
				{
					status=messageSource.getMessage("Pan number already Exists", null,
					"Pan Number already Exists", Locale.getDefault());
					return status;
				}
			}
		}
			
	
		return status;
	}

	@Transactional
	@Override
	public ResponseEntity getEmployeeDetailsByUserID(Long userId) throws ServiceException 
	{
		LtMastEmployees ltMastEmployees=null;
		List<LtMastEmployees> list= ltMastEmployeesDao.getEmployeeDetailsByUserID(userId);
		
		if(!list.isEmpty()|| list.size()>0)
		{
			
			ltMastEmployees=list.get(0);
			if(ltMastEmployees.getSupervisorEmpId()!=null)
			{
				List<LtMastEmployees> list1= ltMastEmployeesDao.getEmployeeDetailsByUserID(ltMastEmployees.getSupervisorEmpId());
				ltMastEmployees.setSupervisorEmpName(list1.get(0).getEmpName());
			}
			
		}
		return new ResponseEntity(ltMastEmployees, HttpStatus.OK); 
	}

	@Transactional
	@Override
	public ResponseEntity checkDetailsUpdate(LtMastEmployees ltMastEmployees) throws ServiceException 
	{
		
		List<LtMastEmployees> ltMastEmployees1 =  ltMastEmployeesDao.checkDetails(ltMastEmployees);
		return new ResponseEntity(ltMastEmployees1, HttpStatus.OK); 
	}

	@Transactional
	@Override
	public ResponseEntity getByEmpId(Long no) throws ServiceException 
	{
		List<LtMastEmployees>  employees = ltMastEmployeesDao.getByEmpId(no);
		return new ResponseEntity(employees, HttpStatus.OK); 
	}
	
	@Transactional
	@Override
	public ResponseEntity getLikeNameByDivisionId(String name, String divisionId) throws ServiceException {
		
		List<LtMastEmployees>  employees = ltMastEmployeesDao.getLikeNameByDivisionId(name, divisionId);
		return new ResponseEntity(employees, HttpStatus.OK); 
	}

	@Transactional
	@Override
	public Status save(LtMastEmployees ltMastEmployees,MultipartFile[] files) throws ServiceException
	{
		Status status = new Status();
		String stat = checkDetails(ltMastEmployees);
		if(stat == null)
		{
			
			ltMastEmployees.setLastUpdateDate(new Date());
			ltMastEmployees.setCreationDate(new Date());
			ltMastEmployees = ltMastEmployeesRepository.save(ltMastEmployees);
			//Long employeeId=ltMastEmployeesDao.save(ltMastEmployees);
			if(ltMastEmployees.getEmployeeId()!=null)
			{
				if(files.length> 0)
				{
				Status status1=imageUpload(files,ltMastEmployees);
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
					if(ltMastEmployeesDao.delete(ltMastEmployees.getEmployeeId()))
					{
						status=ltMastCommonMessageService.getCodeAndMessage(INSERT_FAIL);
						if(status.getMessage()==null)
						{
							status.setCode(EXCEPTION);
							status.setMessage("Error in finding message! The action was unsuccessful");
						}
						return status;
					}
					status=ltMastCommonMessageService.getCodeAndMessage(INSERT_FAIL);
					if(status.getMessage()==null)
					{
						status.setCode(EXCEPTION);
						status.setMessage("Error in finding message! The action was unsuccessful");
					}
					return status;
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
		return status;
	}

	@Transactional
	@Override
	public Status update(LtMastEmployees ltMastEmployees,MultipartFile[] files) throws ServiceException
	{
		Status status = new Status();
		String stat = checkDetails(ltMastEmployees);
		if(stat== null)
		{
			ltMastEmployees.setLastUpdateDate(new Date());
			ltMastEmployees = ltMastEmployeesRepository.save(ltMastEmployees);
			
				Status status1=null;
				if(files.length> 0)
				{
					status1=imageUpload(files,ltMastEmployees);
					if(status1.getCode()== INSERT_SUCCESSFULLY)
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
						status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_FAIL);
						if(status.getMessage()==null)
						{
							status.setCode(EXCEPTION);
							status.setMessage("Error in finding message! The action was unsuccessful");
						}
						
					}
					return status;
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
				status.setMessage(stat);
				status.setCode(EXCEPTION);
			}
		return status;
	}
	//----------------------------------------------------------------
	public Status imageUpload(MultipartFile[] files,LtMastEmployees ltMastEmployees) throws ServiceException
	{
		Status status=new Status();
		String fileName;
		String saveDirectory=null;
		SysVariableWithValues sysVariableWithValues=
				ltMastSysVariablesService.getBySysVariableName("FILE_UPLOAD_FOLDER_PATH",ltMastEmployees.getCompanyId());
	
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
             
            ltMastEmployees.setImagePath(saveDirectory + fileName);
           if( ltMastEmployeesDao.updatePath(ltMastEmployees))
           {
        	   buffStream.close();
               status=ltMastCommonMessageService.getCodeAndMessage(INSERT_SUCCESSFULLY);
               if( status.getMessage()==null)
               {
            	status.setCode(SUCCESS);
            	status.setMessage("Error in finding message! The action is completed successfully.");
               }
               status.setData(ltMastEmployees.getImagePath());
           }
           else
           {
        	   buffStream.close();
               status=ltMastCommonMessageService.getCodeAndMessage(INSERT_FAIL);
   			   if(status.getMessage()==null)
   				{
   					status.setCode(EXCEPTION);
   					status.setMessage("Error in finding message! The action was unsuccessful");
   				}
   			  return status;
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
	public ResponseEntity findAll(Long companyId) throws ServiceException
	{
		List<LtMastEmployees> list =  ltMastEmployeesDao.findAll(companyId);
		return new ResponseEntity(list, HttpStatus.OK); 
	}

	@Transactional
	@Override
	public ResponseEntity getLtMastEmployeesByID(Long empId) throws ServiceException 
	{
		
		LtMastEmployees ltMastEmployees = ltMastEmployeesDao.getLtMastEmployeesByID(empId);
		if(ltMastEmployees!=null && ltMastEmployees.getSupervisorEmpId()!=null){
		List<LtMastEmployees> list1= ltMastEmployeesDao.getEmployeeDetailsByUserID(ltMastEmployees.getSupervisorEmpId());
		if(!list1.isEmpty())
		{
			Optional<LtMastEmployees> chknull = Optional.ofNullable(list1.get(0));
		
			if(chknull.isPresent())
			{
				ltMastEmployees.setSupervisorEmpName(list1.get(0).getEmpName());
			}
		}
		}
		if(ltMastEmployees!=null && ltMastEmployees.getImagePath()!=null)
		{
			String saveDirectory = null;
			List<SysVariableWithValues> sysVariableWithValuesList=
					ltMastSysVariablesDao.getBySysVariableName("FILE_OPEN_PATH",ltMastEmployees.getCompanyId());
			
			if(sysVariableWithValuesList!=null && !sysVariableWithValuesList.isEmpty())
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
			String myFile = FilenameUtils.getBaseName(ltMastEmployees.getImagePath())
                + "." + FilenameUtils.getExtension(ltMastEmployees.getImagePath());
			ltMastEmployees.setImageName(myFile);
			ltMastEmployees.setImagePath(saveDirectory+myFile);
		}
		return new ResponseEntity(ltMastEmployees, HttpStatus.OK); 
	}
	
	@Override
	public ResponseEntity getEmployeeImgByID(Long empId) throws ServiceException {
		Status status = new Status();
		LtMastEmployees ltMastEmployees = ltMastEmployeesDao.getLtMastEmployeesByID(empId);
		
		System.out.println(ltMastEmployees);
		
		if(ltMastEmployees!=null && ltMastEmployees.getImagePath()!=null)
		{
			String saveDirectory = null;
			List<SysVariableWithValues> sysVariableWithValuesList=
					ltMastSysVariablesDao.getBySysVariableName("FILE_OPEN_PATH",ltMastEmployees.getCompanyId());
			
			System.out.println(sysVariableWithValuesList);
			
			if(sysVariableWithValuesList!=null && !sysVariableWithValuesList.isEmpty())
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
			String myFile = FilenameUtils.getBaseName(ltMastEmployees.getImagePath())
                + "." + FilenameUtils.getExtension(ltMastEmployees.getImagePath());
			ltMastEmployees.setImageName(myFile);
			ltMastEmployees.setImagePath(saveDirectory+myFile);
			status.setData(ltMastEmployees.getImagePath());
		}
		return new ResponseEntity<Status>(status,HttpStatus.OK);
	}
	

	@Transactional
	@Override
	public Long getCount(Long companyId, LtMastEmployees input) throws ServiceException
	{
		
		return ltMastEmployeesDao.getCount(companyId, input);
	}

	@Transactional
	@Override
	public List<LtMastEmployees> getDatatableRecords(Long companyId, LtMastEmployees input) throws ServiceException
	{
		if(input.getColumnNo()==1 && input.getSort().equals("asc"))
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
		if(input.getColumnNo()==8 && input.getSort().equals("desc"))
		{
			input.setColumnNo(18);
		}
		if(input.getColumnNo()==9 && input.getSort().equals("desc"))
		{
			input.setColumnNo(19);
		}
		if(input.getColumnNo()==0)
		{
			input.setColumnNo(1);
		}
		List<LtMastEmployees> empList=  ltMastEmployeesDao.getDatatableRecords(companyId, input);
		for (Iterator iterator = empList.iterator(); iterator.hasNext();) 
		{
			LtMastEmployees ltMastEmployees = (LtMastEmployees) iterator.next();
			if(ltMastEmployees.getSupervisorEmpId()!=null)
			{
				List<LtMastEmployees> supervisor = ltMastEmployeesDao.getEmployeeDetailsByUserID(ltMastEmployees.getSupervisorEmpId());
				if(supervisor.size() > 0 )
				{
				ltMastEmployees.setSupervisorEmpName(supervisor.get(0).getEmpName());
				}
			}
		}
		return empList;
	}

	@Override
	public ResponseEntity getLtMastEmployeesBySuperWID(long employeeId) throws ServiceException {
		
		return new ResponseEntity( ltMastEmployeesDao.getLtMastEmployeesBySuperWID(employeeId), HttpStatus.OK); 
	}

	@Override
	public Status updateProfile(MultipartFile[] files, LtMastEmployees emp) throws ServiceException 
	{
		Status status= new Status() ;
		if(files.length> 0)
		{
			Status status1=imageUpload(files,emp);
			if(status1.getCode()== INSERT_SUCCESSFULLY)
			{
				status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_SUCCESSFULLY);
				if( status.getMessage()==null)
				{
				status.setCode(SUCCESS);
				status.setMessage("Error in finding message! The action is completed successfully.");
				}
				status.setData(status1.getData());
			}
			else
			{
				status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_FAIL);
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
	public ResponseEntity<Status> delete(Long id)  {
		Status status = new  Status();
	
		try {
			ltMastEmployeesRepository.delete(id);
			if(!ltMastEmployeesRepository.exists(id)) {
			status=ltMastCommonMessageService.getCodeAndMessage(DELETE_SUCCESSFULLY);
			if(status.getMessage()==null)
			{
				status.setCode(SUCCESS);
				status.setMessage("Error in finding message! The action is completed successfully.");
			}
			}
			else {
				status=ltMastCommonMessageService.getCodeAndMessage(DELETE_FAIL);
				if(status.getMessage()==null)
				{
					status.setCode(FAIL);
					status.setMessage("Error in finding message! The action is completed unsuccessfully.");
				}
			}
		
		}catch(Exception e) {
			status=ltMastCommonMessageService.getCodeAndMessage(ENTITY_CANNOT_DELETE);
			if(status.getMessage()==null)
			{
				status.setCode(FAIL);
				status.setMessage("Error in finding message! The action is completed unsuccessfully.");
			}

		}
		return new ResponseEntity<Status>(status,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<LtMastEmployees>> getBuyerByDivId(String name, String divisionId)
			throws ServiceException {
		List<LtMastEmployees>  employees = ltMastEmployeesDao.getBuyerByDivId(name, divisionId);
		return new ResponseEntity(employees, HttpStatus.OK); 
	}

	@Override
	public ResponseEntity<List<LtMastEmployees>> getAllBuyerByDivId(String divisionId) throws ServiceException {
		List<LtMastEmployees>  employees = ltMastEmployeesDao.getAllBuyerByDivId( divisionId);
		return new ResponseEntity(employees, HttpStatus.OK); 
	}

	@Transactional
	@Override
	public ResponseEntity companyWiseEmp(Long compId) throws ServiceException
	{
		List<LtMastEmployees> list =  ltMastEmployeesDao.companyWiseEmp(compId);
		return new ResponseEntity(list, HttpStatus.OK); 
	}

	@Override
	public ResponseEntity<List<LtMastEmployees>> getLikeNameByComId(String name, Long companyId)
			throws ServiceException {
		List<LtMastEmployees>  employees = ltMastEmployeesDao.getLikeNameByComId(name,companyId);
		return new ResponseEntity(employees, HttpStatus.OK);
	}

	@Override
	public Status getCompanyByBuyer(Long buyerId) throws ServiceException {
		return ltMastEmployeesDao.getCompanyByBuyer(buyerId);
	}

	
	
}
