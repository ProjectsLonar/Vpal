package com.lonar.vendor.vendorportal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lonar.vendor.vendorportal.dao.LtMastVendorMiscInfoDao;
import com.lonar.vendor.vendorportal.model.LtMastVendorMiscInfo;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

@Service
public class LtMastVendorMiscInfoServiceImpl implements LtMastVendorMiscInfoService
{
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;

	@Autowired
	LtMastVendorMiscInfoDao  ltMastVendorMiscInfoDao;
	
	@Transactional
	@Override
	public List<LtMastVendorMiscInfo> getAllVendorMiscInfo() throws ServiceException
	{
		List<LtMastVendorMiscInfo> venBankList=new ArrayList<LtMastVendorMiscInfo>();
		
		venBankList=ltMastVendorMiscInfoDao.getAllVendorMiscInfo();
		
		return venBankList;
	}

	@Transactional
	@Override
	public List<LtMastVendorMiscInfo> getVendorMiscByVenId(Long vendorId) throws ServiceException
	{
		List<LtMastVendorMiscInfo> ltMastVendorMiscInfo=new ArrayList<LtMastVendorMiscInfo>();
		
			ltMastVendorMiscInfo=ltMastVendorMiscInfoDao.getVendorMiscByVenId(vendorId);
		
		return ltMastVendorMiscInfo;
	}
	
	
	@Transactional
	@Override
	public LtMastVendorMiscInfo getVendorMiscInfoById(Long vendorMiscInfoId) throws ServiceException
	{
		LtMastVendorMiscInfo ltMastVendorMiscInfo=new LtMastVendorMiscInfo();
		
		ltMastVendorMiscInfo=ltMastVendorMiscInfoDao.getVendorMiscInfoById(vendorMiscInfoId);
	
	return ltMastVendorMiscInfo;
	}
	

	@Transactional
	@Override
	public Status save(LtMastVendorMiscInfo ltMastVendorMiscInfo) throws ServiceException 
	{
		Status status=new Status();
		
			String chknull=checkNull(ltMastVendorMiscInfo);
			if(chknull.equals("null"))
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
				if(ltMastVendorMiscInfoDao.save(ltMastVendorMiscInfo))
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
					status=ltMastCommonMessageService.getCodeAndMessage(INSERT_FAIL);
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
	public Status update(LtMastVendorMiscInfo ltMastVendorMiscInfo) throws ServiceException
	{
		Status status=new Status();
		
		String chknull=checkNull(ltMastVendorMiscInfo);
		if(chknull.equals("null"))
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
			if(ltMastVendorMiscInfoDao.update(ltMastVendorMiscInfo))
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
		
	
	return status;
	}

	@Transactional
	@Override
	public Status delete(Long vendorMiscInfoId) throws ServiceException
	{
		Status status=new Status();
		
		if(ltMastVendorMiscInfoDao.delete(vendorMiscInfoId))
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
	
	public static String checkNull(LtMastVendorMiscInfo ltMastVendorMiscInfo)
	{
		if( ltMastVendorMiscInfo.getCreatedBy()==null ||ltMastVendorMiscInfo.getCreationDate()==null ||
				ltMastVendorMiscInfo.getLastUpdateLogin()==null)
		{
			return "null";
		}
		else
			return "notnull";
		
	}

	

}
