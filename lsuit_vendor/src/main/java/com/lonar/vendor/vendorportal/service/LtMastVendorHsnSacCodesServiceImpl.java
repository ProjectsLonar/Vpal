package com.lonar.vendor.vendorportal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lonar.vendor.vendorportal.dao.LtMastVendorHsnSacCodesDao;
import com.lonar.vendor.vendorportal.model.LtMastVendorHsnSacCodes;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

@Service
public class LtMastVendorHsnSacCodesServiceImpl implements LtMastVendorHsnSacCodesService
{

	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	@Autowired
	LtMastVendorHsnSacCodesDao ltMastVendorHsnSacCodesDao;
	
	@Transactional
	@Override
	public List<LtMastVendorHsnSacCodes> getAllVendorHsnSacCodes() throws ServiceException 
	{
		List<LtMastVendorHsnSacCodes> venHsnSacCodeList=new ArrayList<LtMastVendorHsnSacCodes>();
		venHsnSacCodeList=ltMastVendorHsnSacCodesDao.getAllVendorHsnSacCodes();
		
		return venHsnSacCodeList;
	}

	@Transactional
	@Override
	public LtMastVendorHsnSacCodes getByHsnId(Long vendorHsnId) throws ServiceException
	{
		LtMastVendorHsnSacCodes venHsnSacCode=new LtMastVendorHsnSacCodes();
		venHsnSacCode=ltMastVendorHsnSacCodesDao.getByHsnId(vendorHsnId);
		
		return venHsnSacCode;
	}

	@Transactional
	@Override
	public List<LtMastVendorHsnSacCodes> getByVendorIdAndAddrId(Long vendorId, Long addrId) throws ServiceException
	{
		return ltMastVendorHsnSacCodesDao.getByVendorIdAndAddrId(vendorId,addrId);
	}
	
	@Transactional
	@Override
	public Status save(LtMastVendorHsnSacCodes vendorhsnSacCode) throws ServiceException
	{
		Status status=new Status();	
		String chknull=checkNull(vendorhsnSacCode);
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
					if(ltMastVendorHsnSacCodesDao.save(vendorhsnSacCode) != null)
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
				//}
				/*else
				{
					status=ltMastCommonMessageService.getCodeAndMessage(DUPLICATE_CODE);
					if(status.getMessage()==null)
					{
						status.setCode(EXCEPTION);
						status.setMessage("Error in finding message! The action was unsuccessful");
					}
					
				}*/
			}
			
		
		return status;
	}

	@Transactional
	@Override
	public Status update(LtMastVendorHsnSacCodes vendorhsnSacCode) throws ServiceException 
	{
		Status status=new Status();
		
			if(vendorhsnSacCode.getVendorHsnId()!=null)
			{
				String chknull=checkNull(vendorhsnSacCode);
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
					if(ltMastVendorHsnSacCodesDao.update(vendorhsnSacCode))
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
	public Status delete(Long vendorHsnId) throws ServiceException 
	{
		Status status=new Status();
		
			if(ltMastVendorHsnSacCodesDao.delete(vendorHsnId))
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
	
	
	public static String checkNull(LtMastVendorHsnSacCodes vendorhsnSacCode)
	{
		if( vendorhsnSacCode.getStartDate()==null ||  vendorhsnSacCode.getLastUpdateLogin()==null ||
				vendorhsnSacCode.getHsnSacCode()==null)
		{
			return "null";
		}
		else
			return "notnull";
		
	}

	@Override
	public Long getLtMastVendorHsnSacCodesCount(Long vendorAddressId, LtMastVendorHsnSacCodes input)
			throws ServiceException {
		return ltMastVendorHsnSacCodesDao.getLtMastVendorHsnSacCodesCount(vendorAddressId,input);
	}

	@Override
	public List<LtMastVendorHsnSacCodes> getLtMastVendorHsnSacCodesDataTable(Long vendorAddressId,
			LtMastVendorHsnSacCodes input) throws ServiceException {
		if(input.getColumnNo()==2 && input.getSort().equals("desc"))
		{ input.setColumnNo(12); }
		if(input.getColumnNo()==3 && input.getSort().equals("desc"))
		{ input.setColumnNo(13); }
		if(input.getColumnNo()==4 && input.getSort().equals("desc"))
		{ input.setColumnNo(14); }
		if(input.getColumnNo()==0) {
			input.setColumnNo(5);
		}
		return ltMastVendorHsnSacCodesDao.getLtMastVendorHsnSacCodesDataTable(vendorAddressId,input);
	}

	

}
