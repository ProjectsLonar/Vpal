package com.lonar.vendor.vendorportal.service;

import java.util.List;
import java.util.Locale;

import javax.jdo.annotations.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lonar.vendor.vendorportal.dao.LtMastSubDivisionsDao;
import com.lonar.vendor.vendorportal.model.BusinessException;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtMastSubDivisions;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.repository.LtMastDivisionsRepository;
import com.lonar.vendor.vendorportal.repository.LtMastSubDivisionsRepository;

@Service
public class LtMastSubDivisionsServiceImpl implements LtMastSubDivisionsService ,CodeMaster
{
	@Autowired
	LtMastSubDivisionsDao ltMastSubDivisionsDao;

	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	LtMastSubDivisionsRepository ltMastSubDivisionsRepository;
	
	@Autowired
	LtMastDivisionsRepository ltMastDivisionsRepository;
	
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	@Transactional
	@Override
	public List<LtMastSubDivisions> findAllActive() throws ServiceException
	{
		// TODO Auto-generated method stub
		return ltMastSubDivisionsDao.findAllActive();
	}

	@Transactional
	@Override
	public List<LtMastSubDivisions> findByDivisionId(Long divisionId) throws ServiceException
	{
		return ltMastSubDivisionsDao.findByDivisionId(divisionId);
	}

	@Transactional
	@Override
	public String checkDetails(LtMastSubDivisions ltMastSubDivisions) throws ServiceException 
	{
		String status=null;
	
		List<LtMastSubDivisions> subDivisionList = ltMastSubDivisionsDao.checkDetails(ltMastSubDivisions);
		for(LtMastSubDivisions subDivisions:subDivisionList)
		{
			if(subDivisions.getSubDivisionCode().equals(ltMastSubDivisions.getSubDivisionCode()))
			{
				if(ltMastSubDivisions.getSubDivisionId()!=subDivisions.getSubDivisionId())
				{
					status =  "Sub division code already exists";
				}
			}
		}
		return status;
	}

	@Transactional
	@Override
	public List<LtMastSubDivisions> checkDetailsUpdate(LtMastSubDivisions ltMastSubDivisions) throws ServiceException
	{
		// TODO Auto-generated method stub
		return ltMastSubDivisionsDao.checkDetails(ltMastSubDivisions);
	}

	@Transactional
	@Override
	public List<LtMastSubDivisions> findActiveByDivisionId(Long divisionId) throws ServiceException 
	{
		return ltMastSubDivisionsDao.findActiveByDivisionId(divisionId);
	}

	@Override
	public ResponseEntity<Status> update(LtMastSubDivisions ltMastSubDivisions) throws ServiceException {
			Status status = new Status();	
			if(ltMastDivisionsRepository.findOne(ltMastSubDivisions.getDivisionId())!=null &&
					ltMastSubDivisions.getSubDivisionId()!=null)
			{
				ltMastSubDivisions.setLastUpdatedBy(ltMastSubDivisions.getLastUpdateLogin());
				ltMastSubDivisions.setLastUpdateLogin(ltMastSubDivisions.getLastUpdateLogin());
				
				List<LtMastSubDivisions> ltMastSubDivisionsList=checkDetailsUpdate(ltMastSubDivisions);
				
				if( ltMastSubDivisionsList == null  || ltMastSubDivisionsList.size()<1 || ltMastSubDivisionsList.get(0).getSubDivisionId().equals(ltMastSubDivisions.getSubDivisionId()) )
				{
				
					ltMastSubDivisions = ltMastSubDivisionsRepository.save(ltMastSubDivisions);
					status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_SUCCESSFULLY);
					if(status.getMessage()==null)
					{
						status.setCode(SUCCESS);
						status.setMessage("Error in finding message! The action is completed successfully.");
					}
					
				}
				else
				{
					status.setCode(UPDATE_FAIL);
					status.setMessage("SubDivision name or code already exists");
					status.setData(ltMastSubDivisions);
					
				}
			}
			else
			{
				status.setCode(UPDATE_FAIL);
				status.setMessage(messageSource.getMessage("Please fill the mandatory fields", null, "Please fill the mandatory fields", Locale.getDefault()));
				status.setData(ltMastSubDivisions);
				
			}
			return new ResponseEntity<Status>(status, HttpStatus.OK);
		}

	@Override
	public LtMastSubDivisions getById(String id) throws ServiceException {
		LtMastSubDivisions ltMastSubDivisions = null;
			if(id!=null)
			{
				if (ltMastSubDivisionsRepository.exists(Long.parseLong(id)))
				{
					ltMastSubDivisions = ltMastSubDivisionsRepository.findOne(Long.parseLong(id));
				}
			}
			return ltMastSubDivisions;
	}

	@Override
	public List<LtMastSubDivisions> findAll() throws ServiceException {
		// TODO Auto-generated method stub
		return (List<LtMastSubDivisions>) ltMastSubDivisionsRepository.findAll();
	}

	@Override
	public ResponseEntity<Status> save(LtMastSubDivisions ltMastSubDivisions) throws ServiceException {
		String stat=null;
		Status status = new Status();
			
			if(ltMastSubDivisions.getDivisionId()!=null)
			{
				if(ltMastDivisionsRepository.findOne(ltMastSubDivisions.getDivisionId())!=null)
				{
					ltMastSubDivisions.setCreatedBy(ltMastSubDivisions.getLastUpdateLogin());
					ltMastSubDivisions.setLastUpdatedBy(ltMastSubDivisions.getLastUpdateLogin());
					ltMastSubDivisions.setLastUpdateLogin(ltMastSubDivisions.getLastUpdateLogin());
				
					stat=checkDetails(ltMastSubDivisions);
				
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
						status=ltMastCommonMessageService.getCodeAndMessage(DATA_ALREADY_EXISTS);
						if( status.getMessage()==null)
						{
							status.setCode(SUCCESS);
							status.setMessage("Error in finding message! The action is completed successfully.");
						}
						status.setMessage(stat);
					}
				}	
				else
				{
					status=ltMastCommonMessageService.getCodeAndMessage(INSERT_FAIL);
					return new ResponseEntity<Status>(status,HttpStatus.OK);
				}
			}
			else
			{
				status=ltMastCommonMessageService.getCodeAndMessage(INSERT_FAIL);
				status.setMessage(stat);
				status.setMessage(messageSource.getMessage("Division or Status Not Found", null, "Division or Starus Not Found", Locale.getDefault()));
				
			}

		
	
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Status> delete(String id) throws ServiceException {
		Status status = new Status();
		try 
		{
			if (ltMastSubDivisionsRepository.exists(Long.parseLong(id))) 
			{
				ltMastSubDivisionsRepository.delete(Long.parseLong(id));
				status=ltMastCommonMessageService.getCodeAndMessage(DELETE_SUCCESSFULLY);
				if(status.getMessage()==null)
				{
					status.setCode(SUCCESS);
					status.setMessage("Error in finding message! The action is completed successfully.");
				}
			}
			
		} 
		catch (org.springframework.dao.DataIntegrityViolationException e)
		{
				
				e.printStackTrace();
			return new ResponseEntity<Status>(status,HttpStatus.OK);
		} 
		catch (Exception e)
		{
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
		return new ResponseEntity<Status>(status,HttpStatus.OK);
	} 
		

		
	

	

}