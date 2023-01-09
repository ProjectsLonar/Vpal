package com.lonar.vendor.vendorportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lonar.vendor.vendorportal.dao.LtVendorInboxDao;
import com.lonar.vendor.vendorportal.model.VendorApproval;
import com.lonar.vendor.vendorportal.model.InvoiceApproval;
import com.lonar.vendor.vendorportal.model.ServiceException;

@Service
public class LtVendorInboxServiceImpl implements LtVendorInboxService{

	@Autowired
	LtVendorInboxDao ltVendorInboxDao;
	
	@Override
	public Long getCount(String status1, String approvalId, VendorApproval input) throws ServiceException 
	{
		return ltVendorInboxDao.getCount(status1,approvalId,input);
	}

	@Override
	public List<VendorApproval> getByStatus(String status1, String approvalId, VendorApproval input)
			throws ServiceException 
	{
		if(input.getColumnNo()==2 && input.getSort().equals("desc"))
		{
			input.setColumnNo(12);
		}
		if(input.getColumnNo()==3 && input.getSort().equals("desc"))
		{
			input.setColumnNo(13);
		}
		if(input.getColumnNo()==4 && input.getSort().equals("desc"))
		{
			input.setColumnNo(14);
		}
		if(input.getColumnNo()==5 && input.getSort().equals("desc"))
		{
			input.setColumnNo(15);
		}
		if(input.getColumnNo()==6 && input.getSort().equals("asc"))
		{
			input.setColumnNo(16);
		}
		if(input.getColumnNo()==0 || input.getColumnNo()==1)
		{
			input.setColumnNo(4);
		}
		List<VendorApproval> list= ltVendorInboxDao.getByStatus(status1,approvalId,input);
		for(VendorApproval obj : list) {
			if(obj.getStatusValue().toUpperCase().equals("PENDING")) {
				obj.setAction("Approve/Reject");
			}else {
				obj.setAction("View");
			}
		}
		return list;
	}

	@Override
	public List<VendorApproval> getVendorApprovalNotification(String status, Long empId) throws ServiceException {
		return ltVendorInboxDao.getVendorApprovalNotification(status, empId);
	}

	@Override
	public Long getInvoiceCount(String status1, String approvalId, InvoiceApproval input) throws ServiceException {
		return ltVendorInboxDao.getInvoiceCount(status1,approvalId,input);
	}

	@Override
	public List<InvoiceApproval> getInvoiceByStatus(String status1, String approvalId, InvoiceApproval input)
			throws ServiceException {
		if(input.getColumnNo()==2 && input.getSort().equals("desc"))
		{
			input.setColumnNo(12);
		}
		if(input.getColumnNo()==3 && input.getSort().equals("desc"))
		{
			input.setColumnNo(13);
		}
		if(input.getColumnNo()==4 && input.getSort().equals("desc"))
		{
			input.setColumnNo(14);
		}
		if(input.getColumnNo()==5 && input.getSort().equals("asc"))
		{
			input.setColumnNo(15);
		}
		if(input.getColumnNo()==0 || input.getColumnNo()==1)
		{
			input.setColumnNo(4);
		}
		List<InvoiceApproval> list= ltVendorInboxDao.getInvoiceByStatus(status1,approvalId,input);
		for(InvoiceApproval obj : list) {
			if(obj.getStatus().toUpperCase().equals("PENDING")) {
				obj.setAction("Approve/Reject");
			}else {
				obj.setAction("View");
			}
		}
		return list;
	}

}
