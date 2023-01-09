package com.lonar.UserManagement.web.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import javax.jdo.annotations.Transactional;

import org.apache.tika.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.lonar.UserManagement.web.dao.LtMastEmployeesDao;
import com.lonar.UserManagement.web.model.CodeMaster;
import com.lonar.UserManagement.web.model.LtMastEmployees;
import com.lonar.UserManagement.web.model.Status;
import com.lonar.UserManagement.web.model.SysVariableWithValues;
import com.lonar.UserManagement.web.repository.LtMastEmployeesRepository;


@Service
public class LtMastEmployeesServiceImpl implements LtMastEmployeesService,CodeMaster
{
	@Autowired
	LtMastEmployeesDao ltMastEmployeesDao;
	
	/*@Autowired
	LtMastCostCentersDao ltMastCostCentersDao;
	
	@Autowired
	LtMastBranchesDao ltMastBranchesDao;*/

	@Autowired
	LtMastEmployeesRepository ltMastEmployeesRepository;
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	@Autowired
	LtMastSysVariablesService ltMastSysVariablesService;
	
	@Transactional
	@Override
	public List<LtMastEmployees> findBySupervisorEmpId(Long supervisorEmpId) throws Exception{
		// TODO Auto-generated method stub
		return ltMastEmployeesDao.findBySupervisorEmpId(supervisorEmpId);
	}

	@Transactional
	@Override
	public List<LtMastEmployees> findByEmployeeNumber(String employeeNumber) throws Exception{
		// TODO Auto-generated method stub
		return ltMastEmployeesDao.findByEmployeeNumber(employeeNumber);
	}

	@Transactional
	@Override
	public List<LtMastEmployees> findByOfficialEmail(String officialEmail) throws Exception{
		// TODO Auto-generated method stub
		return ltMastEmployeesDao.findByOfficialEmail(officialEmail);
	}

	@Transactional
	@Override
	public List<LtMastEmployees> findByPosition(String position) throws Exception{
		// TODO Auto-generated method stub
		return ltMastEmployeesDao.findByPosition(position);
	}

	@Transactional
	@Override
	public List<LtMastEmployees> findAllActive() throws Exception{
		// TODO Auto-generated method stub
		return ltMastEmployeesDao.findAllActive();
	}

	@Transactional
	@Override
	public List<LtMastEmployees> findLikeFirstName(String firstName) throws Exception{
		// TODO Auto-generated method stub
		return ltMastEmployeesDao.findLikeFirstName(firstName);
	}

	@Transactional
	@Override
	public List<LtMastEmployees> findLikeName(String name) throws Exception{
		// TODO Auto-generated method stub
		return ltMastEmployeesDao.findLikeName(name);
	}

	@Transactional
	@Override
	public List<LtMastEmployees> findUserNotEmployeeId() throws Exception{
		// TODO Auto-generated method stub
		return ltMastEmployeesDao.findUserNotEmployeeId();
	}

	@Transactional
	@Override
	public List<LtMastEmployees> findByCostCenterId(Long costCenterId) throws Exception{
		// TODO Auto-generated method stub
		return ltMastEmployeesDao.findByCostCenterId(costCenterId);
	}

	public List<LtMastEmployees> findByEmployeeName(String name) throws Exception{
		return ltMastEmployeesDao.findByEmployeeName(name);
	}

	@Transactional
	@Override
	public List<LtMastEmployees>  findByActiveLikeName(String name) throws Exception 
	{
		List<LtMastEmployees>  list= ltMastEmployeesDao.findByActiveLikeName(name);
		/*for (Iterator iterator = list.iterator(); iterator.hasNext();)
		{
			LtMastEmployees ltMastEmployees = (LtMastEmployees) iterator.next();
			ltMastEmployees.setEmpName(ltMastEmployees.getTitle()+" "+ltMastEmployees.getFirstName()+
					"  "+ltMastEmployees.getLastName()+" "+"("+ltMastEmployees.getEmployeeNumber()+")");
			if(ltMastEmployees.getBranchId()!=null )
			{
				ltMastEmployees.setLocationName(ltMastBranchesDao.findByBranchId(ltMastEmployees.getBranchId()).getBranchName());
				
			}
			if(ltMastEmployees.getCostCenterId()!=null)
			{
				ltMastEmployees.setCostCenterName(ltMastCostCentersDao.findByCostCenterId(ltMastEmployees.getCostCenterId()).getCostCenterName());
			}
		}*/
		
		return list;
	}

	@Transactional
	@Override
	public String checkDetails(LtMastEmployees ltMastEmployees) throws Exception 
	{
		String status=null;
	
		if(ltMastEmployees.getEmployeeNumber()!=null)
		{
			LtMastEmployees emp=ltMastEmployeesDao.getByEmployeeNumber(ltMastEmployees.getEmployeeNumber());
			if(emp!=null)
			{
				if(ltMastEmployees.getEmployeeId()!=emp.getEmployeeId() &&
						!ltMastEmployees.getEmployeeId().equals(emp.getEmployeeId()))
				{
					status=messageSource.getMessage("Employee Number is already Exists", null,
						"Employee Number is already Exists", Locale.getDefault());
					return status;
				}
			}
		}
		if( ltMastEmployees.getOfficialEmail()!=null)
		{
			LtMastEmployees emp=ltMastEmployeesDao.getByofficialEmail(ltMastEmployees.getOfficialEmail());
			if(emp!=null)
			{
				if(ltMastEmployees.getEmployeeId()!=emp.getEmployeeId() &&
						!ltMastEmployees.getEmployeeId().equals(emp.getEmployeeId()))
				{
					status=messageSource.getMessage("Employee official email is already Exists", null,
						"Employee official email is already Exists", Locale.getDefault());
					return status;
				}
			}
		}
		if(ltMastEmployees.getPersonalEmail()!=null)
		{
			LtMastEmployees emp=ltMastEmployeesDao.getByPersonalEmail(ltMastEmployees.getPersonalEmail());
			if(emp!=null)
			{
				if(ltMastEmployees.getEmployeeId()!=emp.getEmployeeId() &&
						!ltMastEmployees.getEmployeeId().equals(emp.getEmployeeId()))
				{
					status=messageSource.getMessage("Employee Personal Email is already Exists", null,
						"Employee Personal Email is already Exists", Locale.getDefault());
					return status;
				}
			}
		}
		if(ltMastEmployees.getPassportNo()!=null )
		{
			LtMastEmployees emp=ltMastEmployeesDao.getByPassportNumber(ltMastEmployees.getPassportNo());
			if(emp!=null)
			{
				if(ltMastEmployees.getEmployeeId()!=emp.getEmployeeId() &&
						!ltMastEmployees.getEmployeeId().equals(emp.getEmployeeId()))
				{
					status=messageSource.getMessage("Employee Passport number already exists", null,
					"Passport Number is already Exists", Locale.getDefault());
					return status;
				}
			}
		}
		if(ltMastEmployees.getPanNo()!=null)
		{
			LtMastEmployees emp=ltMastEmployeesDao.getByPanNumber(ltMastEmployees.getPanNo());
			if(emp!=null)	
			{
				if(ltMastEmployees.getEmployeeId()!=emp.getEmployeeId() &&
						!ltMastEmployees.getEmployeeId().equals(emp.getEmployeeId()))
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
	public LtMastEmployees getEmployeeDetailsByUserID(Long userId) throws Exception 
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
		return ltMastEmployees;
	}

	@Transactional
	@Override
	public List<LtMastEmployees> checkDetailsUpdate(LtMastEmployees ltMastEmployees) throws Exception 
	{
		// TODO Auto-generated method stub
		return ltMastEmployeesDao.checkDetails(ltMastEmployees);
	}

	@Transactional
	@Override
	public List<LtMastEmployees> getByEmpId(Long no) throws Exception 
	{
		// TODO Auto-generated method stub
		return ltMastEmployeesDao.getByEmpId(no);
	}
	
	@Transactional
	@Override
	public List<LtMastEmployees> getLikeNameByDivisionId(String name, String divisionId) throws Exception {
		// TODO Auto-generated method stub
		return ltMastEmployeesDao.getLikeNameByDivisionId(name, divisionId);
	}

	@Transactional
	@Override
	public Status save(LtMastEmployees ltMastEmployees,MultipartFile[] files) throws Exception
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
	public Status update(LtMastEmployees ltMastEmployees,MultipartFile[] files) throws Exception
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
	public Status imageUpload(MultipartFile[] files,LtMastEmployees ltMastEmployees) throws Exception
	{
		Status status=new Status();
		String fileName;
		String saveDirectory=null;
		SysVariableWithValues sysVariableWithValues=
				ltMastSysVariablesService.getBySysVariableName("FILE_UPLOAD_FOLDER_PATH");
	
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
	public List<LtMastEmployees> findAll() throws Exception
	{
		// TODO Auto-generated method stub
		return ltMastEmployeesDao.findAll();
	}

	@Transactional
	@Override
	public LtMastEmployees getLtMastEmployeesByID(Long empId) throws Exception 
	{
		// TODO Auto-generated method stub
		LtMastEmployees ltMastEmployees = ltMastEmployeesDao.getLtMastEmployeesByID(empId);
		if(ltMastEmployees.getSupervisorEmpId()!=null){
		List<LtMastEmployees> list1= ltMastEmployeesDao.getEmployeeDetailsByUserID(ltMastEmployees.getSupervisorEmpId());
		Optional<LtMastEmployees> chknull = Optional.ofNullable(list1.get(0));
		if(chknull.isPresent())
		{
		ltMastEmployees.setSupervisorEmpName(list1.get(0).getEmpName());
		}
		}
		/*if(ltMastEmployees.getImagePath()!=null)
		{
			String myFile = FilenameUtils.getName(ltMastEmployees.getImagePath())
                + "." + FilenameUtils.getExtension(ltMastEmployees.getImagePath());
			ltMastEmployees.setImageName(myFile);
		}*/
		return ltMastEmployees;
	}

	@Transactional
	@Override
	public Long getCount(LtMastEmployees input) throws Exception
	{
		// TODO Auto-generated method stub
		return ltMastEmployeesDao.getCount(input);
	}

	@Transactional
	@Override
	public List<LtMastEmployees> getDatatableRecords(LtMastEmployees input) throws Exception
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
		
		if(input.getColumnNo()==7 && input.getSort().equals("asc"))
		{
			input.setColumnNo(17);
		}
		if(input.getColumnNo()==8 && input.getSort().equals("asc"))
		{
			input.setColumnNo(18);
		}
		if(input.getColumnNo()==9 && input.getSort().equals("asc"))
		{
			input.setColumnNo(19);
		}
		if(input.getColumnNo()==0)
		{
			input.setColumnNo(1);
		}
		List<LtMastEmployees> empList=  ltMastEmployeesDao.getDatatableRecords(input);
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
	public List<LtMastEmployees> getLtMastEmployeesBySuperWID(long employeeId) throws Exception {
		// TODO Auto-generated method stub
		
		return ltMastEmployeesDao.getLtMastEmployeesBySuperWID(employeeId);
	}

	@Override
	public Status updateProfile(MultipartFile[] files, LtMastEmployees emp) throws Exception 
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

	
	
}
