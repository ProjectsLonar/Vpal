package com.lonar.vendor.vendorportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lonar.vendor.vendorportal.dao.LtMastModuleApprovalsDao;
import com.lonar.vendor.vendorportal.model.ServiceException;

@Service
public class LtMastModuleApprovalsServiceImpl implements LtMastModuleApprovalsService {

	@Autowired
	LtMastModuleApprovalsDao ltMastModuleApprovalsDao;
	
	@Override
	public String checkforApprovals(Long vendorId) throws ServiceException 
	{
		return ltMastModuleApprovalsDao.checkforApprovals(vendorId);
	}

}
