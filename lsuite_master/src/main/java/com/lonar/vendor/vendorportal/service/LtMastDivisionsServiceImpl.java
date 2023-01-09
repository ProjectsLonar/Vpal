package com.lonar.vendor.vendorportal.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.jdo.annotations.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lonar.vendor.vendorportal.dao.LtMastDivisionsDao;
import com.lonar.vendor.vendorportal.dao.LtMastSubDivisionsDao;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.DivisionWithSubDivision;
import com.lonar.vendor.vendorportal.model.LtMastDivisions;
import com.lonar.vendor.vendorportal.model.LtMastSubDivisions;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.repository.LtMastDivisionsRepository;
import com.lonar.vendor.vendorportal.repository.LtMastSubDivisionsRepository;

@Service
public  class LtMastDivisionsServiceImpl implements LtMastDivisionsService ,CodeMaster
{
	@Autowired
	LtMastDivisionsDao ltMastDivisionsDao;
	
	@Autowired
	LtMastSubDivisionsDao ltMastSubDivisionsDao;
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	LtMastDivisionsRepository ltMastDivisionsRepository;
	
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	@Autowired
	LtMastSubDivisionsService ltMastSubDivisionsService;
	
	@Autowired
	LtMastSubDivisionsRepository ltMastSubDivisionsRepository;
	/*@Override
	public List<LtP2pDivisions> findByDivisionCode(String divisionCode) throws Exception{
		// TODO Auto-generated method stub
		return ltP2pDivisionsDao.findByDivisionCode(divisionCode);
	}*/

	/*@Override
	public List<LtP2pDivisions> findByDivisionName(String divisionName) throws Exception{
		// TODO Auto-generated method stub
		return ltP2pDivisionsDao.findByDivisionName(divisionName);
	}*/
	@Transactional
	@Override
	public List<LtMastDivisions> findAllActive(Long companyId) throws ServiceException{
		List<LtMastDivisions> ltMastDivisions =new ArrayList<LtMastDivisions>();
	
		ltMastDivisions = ltMastDivisionsDao.findAllActive(companyId);
			
		return ltMastDivisions;
		
	}

	@Transactional
	@Override
	public List<LtMastDivisions> findActiveLikeName(Long companyId, String divisionName) throws ServiceException{
		return  ltMastDivisionsDao.findActiveLikeName(companyId, divisionName);
	}

	@Transactional
	@Override
	public ResponseEntity findByDivisionId(Long divisionId) throws ServiceException {
		return (ResponseEntity) ltMastDivisionsDao.findByDivisionId(divisionId);
	}

	@Transactional
	@Override
	public String checkDetails(LtMastDivisions ltMastDivisions) throws ServiceException
	{
		String stat=null;
		List<LtMastDivisions> list= ltMastDivisionsDao.checkDetails(ltMastDivisions);
		for(LtMastDivisions divisions:list)
		{
			if(ltMastDivisions.getDivisionName().equals(divisions.getDivisionName()))
			{
				
				if(ltMastDivisions.getDivisionId()!=divisions.getDivisionId() 
						&& !divisions.getDivisionId().equals(ltMastDivisions.getDivisionId()))
				{
					stat=messageSource.getMessage("Division name already exists.", null,
						"Division name already exists.", Locale.getDefault());
				}
			}
			else if(ltMastDivisions.getDivisionCode().equals(divisions.getDivisionCode()))
			{
				if(ltMastDivisions.getDivisionId()!=divisions.getDivisionId()
						&& !divisions.getDivisionId().equals(ltMastDivisions.getDivisionId()))
				{
					stat=messageSource.getMessage("Division code already exists.", null,
						"Division code already exists.", Locale.getDefault());
				}
			}
		}
		return stat;
	}

	@Transactional
	@Override
	public ResponseEntity getDivisionByDivisionId(Long divisionId) throws ServiceException 
	{
		LtMastDivisions ltMastDivisions = null;
		
			if (ltMastDivisionsRepository.exists(divisionId))
			{
				ltMastDivisions = ltMastDivisionsDao.getDivisionByDivisionId(divisionId);
			
				List<LtMastSubDivisions> subDivisionList=
						ltMastSubDivisionsDao.findByDivisionId(ltMastDivisions.getDivisionId());
				if(subDivisionList!=null)
				{
					ltMastDivisions.setLtMastSubDivisionsList(subDivisionList);
				}
			}

			else 
			{
				return new ResponseEntity<LtMastDivisions>(ltMastDivisions, HttpStatus.OK);
			}
		
		return new ResponseEntity(ltMastDivisions, HttpStatus.OK);
		
	}

	@Override
	public Long getCount(Long companyId, LtMastDivisions input) throws Exception {
		// TODO Auto-generated method stub
		return ltMastDivisionsDao.getCount(companyId, input);
	}

	@Override
	public List<LtMastDivisions> getDataTableRecords(Long companyId, LtMastDivisions input) throws Exception {
		
		if(input.getColumnNo()==2 && input.getSort().equals("desc"))
		{ input.setColumnNo(12); }
		if(input.getColumnNo()==3 && input.getSort().equals("desc"))
		{ input.setColumnNo(13); }
		if(input.getColumnNo()==4 && input.getSort().equals("desc"))
		{ input.setColumnNo(14); }
		if(input.getColumnNo()==5 && input.getSort().equals("desc"))
		{ input.setColumnNo(15); }
		if(input.getColumnNo()==6 && input.getSort().equals("desc"))
		{ input.setColumnNo(16); }
		if(input.getColumnNo()==7 && input.getSort().equals("desc"))
		{ input.setColumnNo(17); }
		return ltMastDivisionsDao.getDataTableRecords(companyId, input);
	}

	@Transactional
	@Override
	public List<LtMastDivisions> getAll(Long companyId) throws ServiceException {
		List<LtMastDivisions> ltMastDivisions =ltMastDivisionsDao.getAll(companyId);
		
		//ltMastDivisions = (List<LtMastDivisions>) ltMastDivisionsRepository.findAll();
	
		return ltMastDivisions;
	}

	@Override
	public ResponseEntity<Status> save(DivisionWithSubDivision divisionWithSubDivision) throws ServiceException {
		Status status = new Status();
		String stat=null;
		
			LtMastDivisions ltMastDivisions=divisionWithSubDivision.getLtMastDivisions();
			
			if(ltMastDivisions.getDivisionCode()==null || ltMastDivisions.getDivisionName()==null || 
					ltMastDivisions.getStartDate()==null 	)
			{
				status=ltMastCommonMessageService.getCodeAndMessage(INSERT_FAIL);
				return new ResponseEntity<Status>(status, HttpStatus.OK);
			}
			
			
			ltMastDivisions.setCreatedBy(ltMastDivisions.getLastUpdateLogin());
			ltMastDivisions.setLastUpdateLogin(ltMastDivisions.getLastUpdateLogin());
			ltMastDivisions.setLastUpdatedBy(ltMastDivisions.getLastUpdateLogin());
			ltMastDivisions.setLastUpdateDate(new Date());
			stat=checkDetails(ltMastDivisions);
			if(stat == null  ) 
			{
			
				ltMastDivisions = ltMastDivisionsRepository.save(ltMastDivisions);
				
				List<LtMastSubDivisions> ltMastSubDivisionsList=divisionWithSubDivision.getLtMastSubDivisionsList();
				if(ltMastSubDivisionsList!=null || ltMastSubDivisionsList.size()>0)
				{
					for(LtMastSubDivisions ltMastSubDivisions:ltMastSubDivisionsList)
					{
						ltMastSubDivisions.setDivisionId(ltMastDivisions.getDivisionId());
						ltMastSubDivisions.setCreatedBy(ltMastSubDivisions.getLastUpdateLogin());
						ltMastSubDivisions.setLastUpdatedBy(ltMastSubDivisions.getLastUpdateLogin());
						ltMastSubDivisions.setLastUpdateLogin(ltMastSubDivisions.getLastUpdateLogin());
				
						stat=ltMastSubDivisionsService.checkDetails(ltMastSubDivisions);
						if( stat==null)
						{
							
							ltMastSubDivisions = ltMastSubDivisionsRepository.save(ltMastSubDivisions);
							status=ltMastCommonMessageService.getCodeAndMessage(INSERT_SUCCESSFULLY);
							if( status.getMessage()==null)
							{
								status.setCode(SUCCESS);
								status.setMessage("Error in finding message! The action is completed successfully.");
							}
							
						}
						else
						{
							status=ltMastCommonMessageService.getCodeAndMessage(Data_Exist);
							status.setCode(Data_Exist);//76
							status.setMessage(stat);
						}
					}//end of for
				
				}
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
				status.setMessage(stat);
				status.setData(ltMastDivisions);
		
			}
			return new ResponseEntity<Status>(status, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Status> update(LtMastDivisions ltMastDivisions) throws ServiceException {
		Status status = new Status();
		String stat=null;
	
			if(ltMastDivisions.getDivisionCode()==null && ltMastDivisions.getDivisionName()==null && 
					ltMastDivisions.getStartDate()==null && ltMastDivisions.getDivisionId()==null	)
			{
				status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_FAIL);
				return new ResponseEntity<Status>(status, HttpStatus.OK);
			}
				
			stat=checkDetails(ltMastDivisions);
			if( stat == null )
			{
				ltMastDivisions.setLastUpdateLogin(ltMastDivisions.getLastUpdateLogin());
				ltMastDivisions.setLastUpdatedBy(ltMastDivisions.getLastUpdateLogin());
				ltMastDivisions.setLastUpdateDate(new Date());	
				ltMastDivisions = ltMastDivisionsRepository.save(ltMastDivisions);
				status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_SUCCESSFULLY);
				if(status.getMessage()==null)
				{
					status.setCode(SUCCESS);
					status.setMessage("Error in finding message! The action is completed successfully.");
				}
				status.setData(ltMastDivisions.getDivisionId());
			}
			else
			{
				status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_FAIL);
				status.setMessage(stat);
				status.setData(ltMastDivisions);
			}
			return new ResponseEntity<Status>(status, HttpStatus.OK);

		
	}

	@Override
	public ResponseEntity<Status> delete(String id) throws ServiceException{
		Status status = new Status();
	
			if (ltMastDivisionsRepository.exists(Long.parseLong(id))) 
			{
				if (ltMastSubDivisionsService.findByDivisionId(Long.parseLong(id)).isEmpty()) 
				{
					ltMastDivisionsRepository.delete(Long.parseLong(id));
				} 
				else
				{
					List<LtMastSubDivisions> ltMastSubDivisionsList = ltMastSubDivisionsService
							.findByDivisionId(Long.parseLong(id));
					if (ltMastSubDivisionsList != null) 
					{
						for (LtMastSubDivisions ltMastSubDivisions : ltMastSubDivisionsList) 
						{
							try {
								ltMastSubDivisionsRepository.delete(ltMastSubDivisions.getSubDivisionId());
							} catch (Exception e) {
								
								e.printStackTrace();
							}
						}
					}

					ltMastDivisionsRepository.delete(Long.parseLong(id));
					
				}
				status=ltMastCommonMessageService.getCodeAndMessage(DELETE_SUCCESSFULLY);
				if(status.getMessage()==null)
				{
					status.setCode(SUCCESS);
					status.setMessage("Error in finding message! The action is completed successfully.");
				}
								
			}
			else 
			{
					status=ltMastCommonMessageService.getCodeAndMessage(ENTITY_CANNOT_DELETE);
			}
			return new ResponseEntity<Status>(status, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Status> saveDivision(LtMastDivisions ltMastDivisions) throws ServiceException 
	{
		Status status = new Status();
		String stat=null;
		
			
			if(ltMastDivisions.getDivisionCode()==null || ltMastDivisions.getDivisionName()==null || 
					ltMastDivisions.getStartDate()==null 	)
			{
				status=ltMastCommonMessageService.getCodeAndMessage(INSERT_FAIL);
				return new ResponseEntity<Status>(status, HttpStatus.OK);
			}
			
			
			ltMastDivisions.setCreatedBy(ltMastDivisions.getLastUpdateLogin());
			ltMastDivisions.setLastUpdateLogin(ltMastDivisions.getLastUpdateLogin());
			ltMastDivisions.setLastUpdatedBy(ltMastDivisions.getLastUpdateLogin());
			ltMastDivisions.setLastUpdateDate(new Date());
			stat=checkDetails(ltMastDivisions);
			if(stat == null  ) 
			{
			
				ltMastDivisions = ltMastDivisionsRepository.save(ltMastDivisions);
				if(ltMastDivisions.getDivisionId()!=null) {
				status=ltMastCommonMessageService.getCodeAndMessage(INSERT_SUCCESSFULLY);
				if( status.getMessage()==null)
				{
					status.setCode(SUCCESS);
					status.setMessage("Error in finding message! The action is completed successfully.");
				}
				status.setData(ltMastDivisions.getDivisionId());
				}else
				{
					status=ltMastCommonMessageService.getCodeAndMessage(INSERT_FAIL);
					status.setMessage(stat);
					status.setData(ltMastDivisions);
			
				}
			}	
			else
			{
				status=ltMastCommonMessageService.getCodeAndMessage(INSERT_FAIL);
				status.setMessage(stat);
				status.setData(ltMastDivisions);
		
			}
			return new ResponseEntity<Status>(status, HttpStatus.OK);
	}

	
	
	
	
}
