package com.lonar.vendor.vendorportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lonar.vendor.vendorportal.dao.LtMastVendorBanksDao;
import com.lonar.vendor.vendorportal.model.LtMastVendorBanks;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

@Service
public class LtMastVendorBanksServiceImpl implements LtMastVendorBanksService
{

	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	@Autowired
	LtMastVendorBanksDao ltMastVendorBanksDao;
	
	@Transactional
	@Override
	public List<LtMastVendorBanks> getAllVendorBanks() throws ServiceException 
	{
		List<LtMastVendorBanks> venBankList=ltMastVendorBanksDao.getAllVendorBanks();
		return venBankList;
	}
	
	 @Transactional
	 @Override
	 public List<LtMastVendorBanks> findByVendorIdWithAddressId(Long vendorId,Long vendorAddId) throws ServiceException 
	    {
		  List<LtMastVendorBanks> vendorBank=ltMastVendorBanksDao.findByVendorIdWithAddressId(vendorId,vendorAddId);
	        return vendorBank;
	    }
	

	@Transactional
	@Override
	public LtMastVendorBanks getVendorBankByBankId(Long vendorBankId) throws ServiceException 
	{
		LtMastVendorBanks venBank=ltMastVendorBanksDao.getVendorBankByBankId(vendorBankId);
		return venBank;
	}

	@Transactional
	@Override
	public LtMastVendorBanks getVendorBankByVendorId(Long vendorId) throws ServiceException 
	{
		LtMastVendorBanks venBank=ltMastVendorBanksDao.getVendorBankByVendorId(vendorId);
		return venBank;
	}

	@Transactional
	@Override
	public Status save(LtMastVendorBanks ltMastVendorBanks) throws ServiceException 
	{
		Status status=new Status();
			String chknull=checkNull(ltMastVendorBanks);
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
				if(ltMastVendorBanksDao.save(ltMastVendorBanks) != null)
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
	public Status update(LtMastVendorBanks ltMastVendorBanks) 
	{
		Status status=new Status();
		try
		{
			if(ltMastVendorBanks.getVendorBankId()!=null)
			{
				String chknull=checkNull(ltMastVendorBanks);
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
					if(ltMastVendorBanksDao.update(ltMastVendorBanks))
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
		}	
		catch(Exception e)
		{
			try
			{
				status=ltMastCommonMessageService.getCodeAndMessage(INTERNAL_SERVER_ERROR);
				if(status.getMessage()==null)
				{
					status.setCode(EXCEPTION);
					status.setMessage("Error in finding message! The action was unsuccessful");
				}
			}catch(Exception o)
			{
					status.setCode(EXCEPTION);
					status.setMessage("Error in finding message! The action was unsuccessful");
					o.printStackTrace();
			}
			e.printStackTrace();
		}
		return status;
	}

	@Transactional
	@Override
	public Status delete(Long vendorBankId) throws ServiceException
	{
		Status status=new Status();
		
			if(ltMastVendorBanksDao.delete(vendorBankId))
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
	
	
	public static String checkNull(LtMastVendorBanks ltMastVendorBanks)
	{
		if(ltMastVendorBanks.getVendorId()==null || ltMastVendorBanks.getStartDate()==null || 
				 ltMastVendorBanks.getBankName()==null || 
				ltMastVendorBanks.getBankBranch()==null || ltMastVendorBanks.getIfscCode()==null || 
				ltMastVendorBanks.getBankAccountNo()==null ||ltMastVendorBanks.getLastUpdateLogin()==null)
		{
			return "null";
		}
		else
			return "notnull";
		
	}

	@Override
	public Long getLtMastVendorBanksCount(Long vendorAddressId, LtMastVendorBanks input) throws ServiceException {
		return ltMastVendorBanksDao.getLtMastVendorBanksCount(vendorAddressId,input);
	}

	@Override
	public List<LtMastVendorBanks> getLtMastVendorBanksDataTable(Long vendorAddressId, LtMastVendorBanks input)
			throws ServiceException {
		if(input.getColumnNo()==1 && input.getSort().equals("desc"))
		{ input.setColumnNo(11); }
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
		if(input.getColumnNo()==8 && input.getSort().equals("asc"))
		{ input.setColumnNo(18); }
		if(input.getColumnNo()==0) {
			input.setColumnNo(8);
		}
		return ltMastVendorBanksDao.getLtMastVendorBanksDataTable(vendorAddressId,input);
	}

}
