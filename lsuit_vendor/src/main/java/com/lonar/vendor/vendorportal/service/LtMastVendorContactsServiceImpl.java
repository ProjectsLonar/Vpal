package com.lonar.vendor.vendorportal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lonar.vendor.vendorportal.dao.LtMastVendorContactsDao;
import com.lonar.vendor.vendorportal.model.LtMastVendorContacts;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

@Service
public class LtMastVendorContactsServiceImpl implements LtMastVendorContactsService
{

	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	@Autowired
	LtMastVendorContactsDao ltMastVendorContactsDao;
	
	@Transactional
	@Override
	public List<LtMastVendorContacts> getAllVendorsContact() throws ServiceException 
	{
		List<LtMastVendorContacts> venContactList=new ArrayList<LtMastVendorContacts>();
		
			venContactList=ltMastVendorContactsDao.getAllVendorsContact();
		
		return venContactList;
	}

	@Transactional
	@Override
	public LtMastVendorContacts getVendorContactByContactId(Long vendorContactId) throws ServiceException
	{
		LtMastVendorContacts venContact=new LtMastVendorContacts();
		
			venContact=ltMastVendorContactsDao.getVendorContactByContactId(vendorContactId);
		
		return venContact;
	}

	@Transactional
	@Override
	public List<LtMastVendorContacts> getVendorContactByAddressIdAndVendorId(String vendorAddrId, String vendorId)
			throws ServiceException 
	{
		List<LtMastVendorContacts> venContactList=new ArrayList<LtMastVendorContacts>();
		
		venContactList=ltMastVendorContactsDao.getVendorContactByAddressIdAndVendorId(vendorAddrId,vendorId);
	
		return venContactList;
	}
	
	@Transactional
	@Override
	public Status save(LtMastVendorContacts vendorContact) throws ServiceException 
	{
		Status status=new Status();
		
			String chknull=checkNull(vendorContact);
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
				if(ltMastVendorContactsDao.save(vendorContact) != null)
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
	public Status update(LtMastVendorContacts vendorContact) throws ServiceException
	{
		Status status=new Status();
		
			if(vendorContact.getVendorContactId()!=null)
			{
				String chknull=checkNull(vendorContact);
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
					if(ltMastVendorContactsDao.update(vendorContact))
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
	public Status delete(Long vendorContactId) throws ServiceException 
	{
		Status status=new Status();
		
			if(ltMastVendorContactsDao.delete(vendorContactId))
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
	
	public static String checkNull(LtMastVendorContacts ltMastVendorContacts)
	{
		if( ltMastVendorContacts.getStartDate()==null || 
		 ltMastVendorContacts.getLastUpdateLogin()==null)
		{
			return "null";
		}
		else
			return "notnull";
		
	}

	@Override
	public Long getLtMastVendorContactsCount(Long vendorAddressId, LtMastVendorContacts input) throws ServiceException {
		return ltMastVendorContactsDao.getLtMastVendorContactsCount(vendorAddressId,input);
	}

	@Override
	public List<LtMastVendorContacts> getLtMastVendorContactsDataTable(Long vendorAddressId, LtMastVendorContacts input)
			throws ServiceException {
		if(input.getColumnNo()==1 && input.getSort().equals("asc"))
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
		if(input.getColumnNo()==8 && input.getSort().equals("desc"))
		{ input.setColumnNo(18); }
		if(input.getColumnNo()==9 && input.getSort().equals("desc"))
		{ input.setColumnNo(19); }
		if(input.getColumnNo()==0) {
			input.setColumnNo(1);
		}
		return ltMastVendorContactsDao.getLtMastVendorContactsDataTable(vendorAddressId,input);
	}

	

}
