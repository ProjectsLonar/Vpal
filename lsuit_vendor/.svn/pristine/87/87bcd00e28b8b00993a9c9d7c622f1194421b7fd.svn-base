package com.lonar.vendor.vendorportal.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jdo.annotations.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lonar.vendor.vendorportal.dao.LtMastVendorsAddressDao;
import com.lonar.vendor.vendorportal.model.LtMastVendorAddress;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

@Service
public class LtMastVendorsAddressServiceImpl implements LtMastVendorsAddressService
{

	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	@Autowired
	LtMastVendorsAddressDao ltMastVendorsAddressDao;
	
	@Override
	public Long getLtMastVendorAddressCount(Long vendorId, LtMastVendorAddress input) throws ServiceException {
		return ltMastVendorsAddressDao.getLtMastVendorAddressCount(vendorId,input);
	}

	@Override
	public List<LtMastVendorAddress> getLtMastVendorAddressDataTable(Long vendorId, LtMastVendorAddress input)
			throws ServiceException {
		
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
		if(input.getColumnNo()==10 && input.getSort().equals("desc"))
		{ input.setColumnNo(20); }
		if(input.getColumnNo()==11 && input.getSort().equals("asc"))
		{ input.setColumnNo(21); }
		if(input.getColumnNo()==0) {
			input.setColumnNo(11);
		}
		return ltMastVendorsAddressDao.getLtMastVendorAddressDataTable(vendorId,input);
	}

	
	@Transactional
	@Override
	public List<LtMastVendorAddress> getAllVendorsAddress() throws ServiceException 
	{
		 List<LtMastVendorAddress> vendorAddList=new ArrayList<LtMastVendorAddress>();
		vendorAddList=ltMastVendorsAddressDao.getAllVendors();
			return vendorAddList;
	}

	@Transactional
	@Override
	public List<LtMastVendorAddress> getAllVendorsAddressByVendorId(Long vendorId) throws ServiceException 
	{
		 List<LtMastVendorAddress> vendorAddList=new ArrayList<LtMastVendorAddress>();
		vendorAddList=ltMastVendorsAddressDao.getAllVendorsAddressByVendorId(vendorId);
		return vendorAddList;
	}
	
	@Override
	public List<LtMastVendorAddress> getAllActiveVendorsAddressByVendorId(Long vendorId) throws ServiceException
	{
		 List<LtMastVendorAddress> vendorAddList=new ArrayList<LtMastVendorAddress>();
		vendorAddList=ltMastVendorsAddressDao.getAllActiveVendorsAddressByVendorId(vendorId);
		return vendorAddList;
	}
	
	@Transactional
	@Override
	public LtMastVendorAddress getVendorAddById(Long vendorAddId) throws ServiceException 
	{
		LtMastVendorAddress vendorAdd=new LtMastVendorAddress();
		vendorAdd=ltMastVendorsAddressDao.getVendorById(vendorAddId);
		return vendorAdd;
	}

	@Transactional
	@Override
	public Status save(LtMastVendorAddress vendorsAdd) throws ServiceException 
	{
		Status status=new Status();
			String chknull=checkNull(vendorsAdd);
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
				vendorsAdd.setCreationDate(new Date());	
				vendorsAdd.setLastUpdateDate(new Date());
				vendorsAdd.setLastUpdatedBy(vendorsAdd.getLastUpdateLogin());
			if (ltMastVendorsAddressDao.save(vendorsAdd) != null) 
			{

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
	public Status update(LtMastVendorAddress vendorsAdd) throws ServiceException
	{
		Status status=new Status();
		
			if(vendorsAdd.getVendorAddId()!=null)
			{
				String chknull=checkNull(vendorsAdd);
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
					vendorsAdd.setLastUpdateDate(new Date());
					vendorsAdd.setLastUpdatedBy(vendorsAdd.getLastUpdateLogin());
					if(ltMastVendorsAddressDao.update(vendorsAdd))
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
	public Status delete(Long vendorAddId) throws ServiceException
	{
		Status status=new Status();
			if(ltMastVendorsAddressDao.delete(vendorAddId))
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
	
	
	
	public static String checkNull(LtMastVendorAddress vendorsAdd)
	{
		if(vendorsAdd.getVendorId()==null || vendorsAdd.getStartDate()==null || vendorsAdd.getAddressCode()==null 
				|| vendorsAdd.getAddress1()==null || vendorsAdd.getCity()==null || vendorsAdd.getStateId()==null || vendorsAdd.getPrimaryAddress()==null ||
				vendorsAdd.getCreatedBy()==null ||  vendorsAdd.getLastUpdateLogin()==null)
		{
			return "null";
		}
		else
			return "notnull";
		
	}

	@Override
	public List<LtMastVendorAddress> getAllActiveShippingAddressByVendId(Long vendorId) throws ServiceException {
		return ltMastVendorsAddressDao.getAllActiveShippingAddressByVendId(vendorId);
	}

	@Override
	public Status checkRecord(Long venId) throws ServiceException {
		Status status = new Status();
		List<LtMastVendorAddress> list=ltMastVendorsAddressDao.getAllVendorsAddressByVendorId(venId);
		if(list.isEmpty()) {
			status.setCode(FAIL);
			status.setMessage("Please fill vendor address details");
		}
		else {
			status.setCode(SUCCESS);
		}
		return status;
	}

	
	

	

}
