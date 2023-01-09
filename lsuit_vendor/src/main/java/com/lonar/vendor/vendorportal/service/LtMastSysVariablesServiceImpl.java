package com.lonar.vendor.vendorportal.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jdo.annotations.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lonar.vendor.vendorportal.dao.LtMastSysVariableValuesDao;
import com.lonar.vendor.vendorportal.dao.LtMastSysVariablesDao;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtMastSysVariableValues;
import com.lonar.vendor.vendorportal.model.LtMastSysVariables;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.model.SysVariableWithValues;
import com.lonar.vendor.vendorportal.repository.LtMastSysVariableValuesRepository;
import com.lonar.vendor.vendorportal.repository.LtMastSysVariablesRepository;


@Service
public class LtMastSysVariablesServiceImpl implements LtMastSysVariablesService,CodeMaster
{
	@Autowired
	LtMastSysVariablesDao ltMastSysVariablesDao;
	
	@Autowired
	LtMastSysVariablesRepository ltMastSysVariablesRepository;
	
	@Autowired
	LtMastSysVariableValuesRepository ltMastSysVariableValuesRepository;
	
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	@Autowired
	LtMastSysVariableValuesDao ltMastSysVariableValuesDao;
	
	@Transactional
	@Override
	public SysVariableWithValues getBySysVariableName(String name,Long companyId) throws ServiceException 
	{
		List<SysVariableWithValues> sysVariableWithValuesList=
				ltMastSysVariablesDao.getBySysVariableName(name,companyId);
		
		if(sysVariableWithValuesList.isEmpty())
			return null;
		else
			return sysVariableWithValuesList.get(0);
	}

	@Transactional
	@Override
	public ResponseEntity save(SysVariableWithValues sysVariableWithValues) throws ServiceException 
	{
		Status status = new Status();

		LtMastSysVariables ltMastSysVariables = sysVariableWithValues.getLtMastSysVariables();

		if (ltMastSysVariables.getVariableName() != null && ltMastSysVariables.getVariableCode() != null
				&& ltMastSysVariables.getStartDate() != null && ltMastSysVariables.getLastUpdateLogin() != null) 
		{
			String stat = checkForDuplicate(sysVariableWithValues.getLtMastSysVariables());
			if (stat.equals("null"))
			{

				ltMastSysVariables.setCreatedBy(ltMastSysVariables.getLastUpdateLogin());
				ltMastSysVariables.setLastUpdatedBy(ltMastSysVariables.getLastUpdateLogin());
				ltMastSysVariables.setLastUpdateLogin(ltMastSysVariables.getLastUpdateLogin());
				ltMastSysVariables.setLastUpdateDate(new Date());
				ltMastSysVariables = ltMastSysVariablesRepository.save(ltMastSysVariables);
				if (ltMastSysVariables.getVariableId() != null) {
					if (sysVariableWithValues.getLtMastSysVariableValues() != null) {

						for (LtMastSysVariableValues ltMastSysVariableValues : sysVariableWithValues
								.getLtMastSysVariableValues()) {
							ltMastSysVariableValues.setVariableId(ltMastSysVariables.getVariableId());
							ltMastSysVariableValues.setCreatedBy(ltMastSysVariables.getLastUpdateLogin());
							ltMastSysVariableValues.setLastUpdatedBy(ltMastSysVariables.getLastUpdateLogin());
							ltMastSysVariableValues.setLastUpdateLogin(ltMastSysVariables.getLastUpdateLogin());
							ltMastSysVariableValues.setLastUpdateDate(new Date());
							ltMastSysVariableValuesRepository.save(ltMastSysVariableValues);
						}
						status = ltMastCommonMessageService.getCodeAndMessage(INSERT_SUCCESSFULLY);
						if (status.getMessage() == null) {
							status.setCode(EXCEPTION);
							status.setMessage("Error in finding message! The action was unsuccessful");
						}
					} else {
						status = ltMastCommonMessageService.getCodeAndMessage(INSERT_SUCCESSFULLY);
						if (status.getMessage() == null) {
							status.setCode(SUCCESS);
							status.setMessage("Error in finding message! The action was unsuccessful");
						}
					}
				} else {
					status = ltMastCommonMessageService.getCodeAndMessage(INSERT_FAIL);
					if (status.getMessage() == null) {
						status.setCode(EXCEPTION);
						status.setMessage("Error in finding message! The action was unsuccessful");
					}
				}
			} else {
				status.setMessage(stat);
				status.setCode(EXCEPTION);
			}
		} else {
			status = ltMastCommonMessageService.getCodeAndMessage(INPUT_IS_EMPTY);
			if (status.getMessage() == null) {
				status.setCode(EXCEPTION);
				status.setMessage("Error in finding message! The action was unsuccessful");
			}

		}

		return new ResponseEntity(status, HttpStatus.OK);
	}

	@Transactional
	@Override
	public ResponseEntity update (SysVariableWithValues sysVariableWithValues) throws ServiceException 
	{
		Status status = new Status();
		LtMastSysVariables ltMastSysVariables=sysVariableWithValues.getLtMastSysVariables();
		if(ltMastSysVariables.getVariableId()!=null)
		{
			String stat = checkForDuplicate(sysVariableWithValues.getLtMastSysVariables());
			if (stat.equals("null"))
			{

			
			ltMastSysVariables.setLastUpdateDate(new Date());
			ltMastSysVariables.setLastUpdatedBy(ltMastSysVariables.getLastUpdateLogin());
			ltMastSysVariables.setLastUpdateLogin(ltMastSysVariables.getLastUpdateLogin());
		
			ltMastSysVariables = ltMastSysVariablesRepository.save(ltMastSysVariables);
		
		
			if(sysVariableWithValues.getLtMastSysVariableValues()!=null)
			{
				for(LtMastSysVariableValues ltMastSysVariableValues:sysVariableWithValues.getLtMastSysVariableValues())
				{
					if(ltMastSysVariableValues.getVariableValuesId()!=null)
					{
						ltMastSysVariableValues.setLastUpdateDate(new Date());
						ltMastSysVariableValues.setVariableId(ltMastSysVariables.getVariableId());
						ltMastSysVariableValues.setLastUpdatedBy(ltMastSysVariables.getLastUpdateLogin());
						ltMastSysVariableValues.setLastUpdateLogin(ltMastSysVariables.getLastUpdateLogin());
						ltMastSysVariableValues =ltMastSysVariableValuesRepository.save(ltMastSysVariableValues);
						if(ltMastSysVariableValues.getVariableValuesId()== null)
						{
							status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_FAIL);
							if(status.getMessage()==null)
							{
							status.setCode(EXCEPTION);
							status.setMessage("Error in finding message! The action was unsuccessful");
							}
						}
					}
					else
					{
						ltMastSysVariableValues.setLastUpdateDate(new Date());
						ltMastSysVariableValues.setCreatedBy(ltMastSysVariables.getLastUpdateLogin());
						ltMastSysVariableValues.setVariableId(ltMastSysVariables.getVariableId());
						ltMastSysVariableValues.setLastUpdatedBy(ltMastSysVariables.getLastUpdateLogin());
						ltMastSysVariableValues.setLastUpdateLogin(ltMastSysVariables.getLastUpdateLogin());
						ltMastSysVariableValues = ltMastSysVariableValuesRepository.save(ltMastSysVariableValues);
						if(ltMastSysVariableValues != null)
						{
							status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_FAIL);
							if(status.getMessage()==null)
							{
							status.setCode(EXCEPTION);
							status.setMessage("Error in finding message! The action was unsuccessful");
							}
						}
					}
				}
				status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_SUCCESSFULLY);
				if(status.getMessage()==null)
				{
				status.setCode(SUCCESS);
				status.setMessage("Error in finding message! The action was unsuccessful");
				}
				
			}
			else
			{
				status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_SUCCESSFULLY);
				if(status.getMessage()==null)
				{
				status.setCode(SUCCESS);
				status.setMessage("Error in finding message! The action was unsuccessful");
				}
			}
			
			
			
			}
			else {
				status.setMessage(stat);
				status.setCode(EXCEPTION);
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
		return new ResponseEntity(status, HttpStatus.OK);
	}
	//=================================================================================
	
	public String checkForDuplicate(LtMastSysVariables ltMastSysVariables) throws ServiceException 
	{
		LtMastSysVariables ltMastSysVariables1 = ltMastSysVariablesDao.getByCode(ltMastSysVariables);
			if(ltMastSysVariables1!=null)
			{
				if(ltMastSysVariables1.getVariableId()!=ltMastSysVariables.getVariableId())
				{
					return "Same Variable Code already Exist";
				}
			}
			
		 ltMastSysVariables1 = ltMastSysVariablesDao.getByName(ltMastSysVariables);
		if(ltMastSysVariables1!=null)
		{
			if(ltMastSysVariables1.getVariableId()!=ltMastSysVariables.getVariableId())
			{
				return "Same Variable Name already Exist";
			}
		}
		
		
	
		
		return "null";
	}

	@Override
	public Long getCount(LtMastSysVariables input) throws Exception 
	{
		// TODO Auto-generated method stub
		return ltMastSysVariablesDao.getCount(input);
	}

	@Override
	public List<LtMastSysVariables> getDatatableRecords(LtMastSysVariables input) throws Exception 
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
		if(input.getColumnNo()==8 && input.getSort().equals("asc"))
		{
			input.setColumnNo(18);
		}
		return ltMastSysVariablesDao.getDatatableRecords(input);
	}

	@Override
	public ResponseEntity<List<LtMastSysVariables>> getAll() throws ServiceException {
		List<LtMastSysVariables> ltMastSysVariables =new ArrayList<LtMastSysVariables>();
	
			ltMastSysVariables = (List<LtMastSysVariables>) ltMastSysVariablesRepository.findAll();
		
	
		return new ResponseEntity<List<LtMastSysVariables>>(ltMastSysVariables, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Status> delete(String id) throws ServiceException {
		LtMastSysVariables ltMastSysVariables = null;
		Status status=new Status();
		if (ltMastSysVariablesRepository.exists(Long.parseLong(id)))
			{
				ltMastSysVariables=ltMastSysVariablesRepository.findOne(Long.parseLong(id));
				List<LtMastSysVariableValues> list=
						ltMastSysVariableValuesDao.getByVariableId(ltMastSysVariables.getVariableId());
				if(list!=null)
				{
					for(LtMastSysVariableValues ltMastSysVariableValues:list)
					{
						ltMastSysVariableValuesRepository.delete(ltMastSysVariableValues.getVariableValuesId());
					}
					ltMastSysVariablesRepository.delete(Long.parseLong(id));
				}
				
			}
			else
			{
				status=ltMastCommonMessageService.getCodeAndMessage(NO_RESULT);
				return new ResponseEntity<Status>(status,HttpStatus.OK);

			}
			status=ltMastCommonMessageService.getCodeAndMessage(DELETE_SUCCESSFULLY);
			return new ResponseEntity<Status>(status,HttpStatus.OK);
			

		}

	@Override
	public ResponseEntity<Status> deleteLtMastSysVariableValuesByID(Long id) throws ServiceException {
		Status status=new Status();
		
			ltMastSysVariableValuesRepository.delete(id);	
			status=ltMastCommonMessageService.getCodeAndMessage(DELETE_SUCCESSFULLY);
		return new ResponseEntity<Status>(status,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Status> saveSysVariable(LtMastSysVariables ltMastSysVariables) throws ServiceException {

		Status status = new Status();

		if (ltMastSysVariables.getVariableName() != null && ltMastSysVariables.getVariableCode() != null
				&& ltMastSysVariables.getStartDate() != null && ltMastSysVariables.getLastUpdateLogin() != null) 
		{
			String stat = checkForDuplicate(ltMastSysVariables);
			if (stat.equals("null"))
			{

				ltMastSysVariables.setCreatedBy(ltMastSysVariables.getLastUpdateLogin());
				ltMastSysVariables.setLastUpdatedBy(ltMastSysVariables.getLastUpdateLogin());
				ltMastSysVariables.setLastUpdateLogin(ltMastSysVariables.getLastUpdateLogin());
				ltMastSysVariables.setLastUpdateDate(new Date());
				ltMastSysVariables = ltMastSysVariablesRepository.save(ltMastSysVariables);
				if (ltMastSysVariables.getVariableId() != null) 
				{
						status = ltMastCommonMessageService.getCodeAndMessage(INSERT_SUCCESSFULLY);
						if (status.getMessage() == null) {
							status.setCode(SUCCESS);
							status.setMessage("Error in finding message! The action was unsuccessful");
						}
						status.setData(ltMastSysVariables.getVariableId());
				} else {
					status = ltMastCommonMessageService.getCodeAndMessage(INSERT_FAIL);
					if (status.getMessage() == null) {
						status.setCode(EXCEPTION);
						status.setMessage("Error in finding message! The action was unsuccessful");
					}
				}
			} else {
				status.setMessage(stat);
				status.setCode(EXCEPTION);
			}
		} else {
			status = ltMastCommonMessageService.getCodeAndMessage(INPUT_IS_EMPTY);
			if (status.getMessage() == null) {
				status.setCode(EXCEPTION);
				status.setMessage("Error in finding message! The action was unsuccessful");
			}

		}

		return new ResponseEntity(status, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Status> updateSysVariable(LtMastSysVariables ltMastSysVariables) throws ServiceException {
		Status status = new Status();
		if(ltMastSysVariables.getVariableId()!=null)
		{
			String stat = checkForDuplicate(ltMastSysVariables);
			if (stat.equals("null"))
			{

			
			ltMastSysVariables.setLastUpdateDate(new Date());
			ltMastSysVariables.setLastUpdatedBy(ltMastSysVariables.getLastUpdateLogin());
			ltMastSysVariables.setLastUpdateLogin(ltMastSysVariables.getLastUpdateLogin());
		
			ltMastSysVariables = ltMastSysVariablesRepository.save(ltMastSysVariables);
				status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_SUCCESSFULLY);
				if(status.getMessage()==null)
				{
				status.setCode(SUCCESS);
				status.setMessage("Error in finding message! The action was unsuccessful");
				}
				status.setData(ltMastSysVariables.getVariableId());
			}
			else {
				status.setMessage(stat);
				status.setCode(EXCEPTION);
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
		return new ResponseEntity(status, HttpStatus.OK);
	}

	@Override
	public List<LtMastSysVariables> getSysvariableProperties() throws ServiceException {
		// TODO Auto-generated method stub
		return ltMastSysVariablesDao.getSysvariableProperties();
	} 
	
}
