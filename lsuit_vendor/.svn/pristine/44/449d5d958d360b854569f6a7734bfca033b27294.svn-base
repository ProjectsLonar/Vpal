package com.lonar.vendor.vendorportal.service;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lonar.vendor.vendorportal.dao.LtMastVendorSisterConcernsDao;
import com.lonar.vendor.vendorportal.model.LtMastVendorSisterConcerns;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

@Service
public class LtMastVendorSisterConcernsServiceImpl implements LtMastVendorSisterConcernsService 
{
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	@Autowired
	LtMastVendorSisterConcernsDao ltMastVendorSisterConcernsDao;

	@Transactional
	@Override
	public List<LtMastVendorSisterConcerns> getAllVendorSisterConcerns() throws ServiceException {

		List<LtMastVendorSisterConcerns> ltMastVendorSisterConcernsList = new ArrayList<LtMastVendorSisterConcerns>();
		
			ltMastVendorSisterConcernsList = ltMastVendorSisterConcernsDao.getAllVendorSisterConcerns();
		

		return ltMastVendorSisterConcernsList;
	}

	@Transactional
	@Override
	public List<LtMastVendorSisterConcerns> getVendorSisConcByVenId(Long vendorId) throws ServiceException 
	{
		List<LtMastVendorSisterConcerns>  ltMastVendorSisterConcerns = new ArrayList<LtMastVendorSisterConcerns>();
		ltMastVendorSisterConcerns = ltMastVendorSisterConcernsDao.getVendorSisConcByVenId(vendorId);
	
		return ltMastVendorSisterConcerns;
	}
	
	
	@Transactional
	@Override
	public LtMastVendorSisterConcerns getVendorSisterConcernsById(Long vendorSisterConcernsId) throws ServiceException {
		
		LtMastVendorSisterConcerns ltMastVendorSisterConcerns = new LtMastVendorSisterConcerns();

		
			ltMastVendorSisterConcerns = ltMastVendorSisterConcernsDao
					.getVendorSisterConcernsById(vendorSisterConcernsId);
		
		return ltMastVendorSisterConcerns;
	}

	
	@Transactional
	@Override
	public Status save(LtMastVendorSisterConcerns ltMastVendorSisterConcerns) throws ServiceException {

		Status status = new Status();

		
			String isChecknull = checkNull(ltMastVendorSisterConcerns);
			if (isChecknull.equals("null")) {
				status = ltMastCommonMessageService.getCodeAndMessage(INPUT_IS_EMPTY);
				if (status.getMessage() == null) {
					status.setCode(EXCEPTION);
					status.setMessage("Error in finding message! The action was unsuccessful");
				}
			} else {
				if (ltMastVendorSisterConcernsDao.save(ltMastVendorSisterConcerns)) {
					status = ltMastCommonMessageService.getCodeAndMessage(INSERT_SUCCESSFULLY);
					if (status.getMessage() == null) {
						status.setCode(SUCCESS);
						status.setMessage("Error in finding message! The action is completed successfully.");
					}
				} else {
					status = ltMastCommonMessageService.getCodeAndMessage(INSERT_FAIL);
					if (status.getMessage() == null) {
						status.setCode(EXCEPTION);
						status.setMessage("Error in finding message! The action was unsuccessful");
					}
				}
			}

		
		return status;
	}

	
	@Transactional
	@Override
	public Status update(LtMastVendorSisterConcerns ltMastVendorSisterConcerns) throws ServiceException {
		Status status=new Status();
		
			if(ltMastVendorSisterConcerns.getVendorSisterConcernsId()!=null)
			{
				String isCheckNull=checkNull(ltMastVendorSisterConcerns);
				if(isCheckNull.equals("null"))
				{
					status=ltMastCommonMessageService.getCodeAndMessage(INPUT_IS_EMPTY);
					if(status.getMessage()==null)
					{
						status.setCode(EXCEPTION);
						status.setMessage("Error in finding message! The action was unsuccessful");
					}
				}
				else
				{
					if(ltMastVendorSisterConcernsDao.update(ltMastVendorSisterConcerns))
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

	
	@Transactional
	@Override
	public Status delete(Long vendorSisterConcernsId) throws ServiceException {
		Status status=new Status();
		
			if(ltMastVendorSisterConcernsDao.delete(vendorSisterConcernsId))
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
		
		return status;
	}
	
	
	public static String checkNull(LtMastVendorSisterConcerns ltMastVendorSisterConcerns)
	{
		if(
				ltMastVendorSisterConcerns.getLastUpdateLogin()==null )
		{
			return "null";
		}
		else
			return "notnull";
		
	}

	@Override
	public Status checkRecord(Long venId) throws ServiceException {
		Status status = new Status();
		List<LtMastVendorSisterConcerns>  list = ltMastVendorSisterConcernsDao.getVendorSisConcByVenId(venId);
	
		if(list.isEmpty()) {
			status.setCode(FAIL);
			status.setMessage("Please fill vendor sister concerns");
		}
		else {
			status.setCode(SUCCESS);
		}
		return status;
	}

	@Override
	public Long getLtMastVendorSisterConcernsCount(Long vendorId, LtMastVendorSisterConcerns input)
			throws ServiceException {
		return ltMastVendorSisterConcernsDao.getLtMastVendorSisterConcernsCount(vendorId,input);
	}

	@Override
	public List<LtMastVendorSisterConcerns> getLtMastVendorSisterConcernsDataTable(Long vendorId,
			LtMastVendorSisterConcerns input) throws ServiceException {
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
		if(input.getColumnNo()==8 && input.getSort().equals("desc"))
		{ input.setColumnNo(18); }
		
		if(input.getColumnNo()==0) {
			input.setColumnNo(1);
		}
		return ltMastVendorSisterConcernsDao.getLtMastVendorSisterConcernsDataTable(vendorId,input);
	}

	
	

}
