package com.lonar.vendor.vendorportal.service;

import java.util.List;
import java.util.Locale;

import javax.jdo.annotations.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.lonar.vendor.vendorportal.dao.LtMastSubDivisionsDao;
import com.lonar.vendor.vendorportal.model.LtMastSubDivisions;
import com.lonar.vendor.vendorportal.model.ServiceException;

@Service
public class LtMastSubDivisionsServiceImpl implements LtMastSubDivisionsService 
{
	@Autowired
	LtMastSubDivisionsDao ltMastSubDivisionsDao;

	@Autowired
	private MessageSource messageSource;
	
	@Transactional
	@Override
	public List<LtMastSubDivisions> findAllActive() throws Exception
	{
		// TODO Auto-generated method stub
		return ltMastSubDivisionsDao.findAllActive();
	}

	@Transactional
	@Override
	public List<LtMastSubDivisions> findByDivisionId(Long divisionId) throws ServiceException
	{
		// TODO Auto-generated method stub
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
					status=messageSource.getMessage("SubDivisionCode already Exists", null,
						"SubDivisionCode already Exists", Locale.getDefault());
				}
			}
		}
		return status;
	}

	@Transactional
	@Override
	public List<LtMastSubDivisions> checkDetailsUpdate(LtMastSubDivisions ltMastSubDivisions) throws Exception
	{
		// TODO Auto-generated method stub
		return ltMastSubDivisionsDao.checkDetails(ltMastSubDivisions);
	}

	@Transactional
	@Override
	public List<LtMastSubDivisions> findActiveByDivisionId(Long divisionId) throws Exception 
	{
		return ltMastSubDivisionsDao.findActiveByDivisionId(divisionId);
	}

	

}