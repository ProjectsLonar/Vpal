package com.lonar.vendor.vendorportal.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lonar.vendor.vendorportal.dao.LtInvoiceApprovalDao;
import com.lonar.vendor.vendorportal.dao.LtInvoiceApprovalHistoryDao;
import com.lonar.vendor.vendorportal.dao.LtVendorApprovalDao;
import com.lonar.vendor.vendorportal.dao.LtVendorApprovalHistoryDao;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.InvoiceApproval;
import com.lonar.vendor.vendorportal.model.LtInvoiceApprovalHistory;
import com.lonar.vendor.vendorportal.model.LtVendorApproval;
import com.lonar.vendor.vendorportal.model.LtVendorApprovalHistory;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

@Service
public class LtVendorApprovalHistoryServiceImpl implements LtVendorApprovalHistoryService,CodeMaster{

	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	@Autowired
	LtVendorApprovalDao ltVendorApprovalDao;
	
	@Autowired
	LtVendorApprovalHistoryDao ltVendorApprovalHistoryDao;
	
	@Autowired
	LtInvoiceApprovalDao invoiceApprovalDao;
	
	@Autowired
	LtInvoiceApprovalHistoryDao ltInvoiceApprovalHistoryDao;
	
	@Override
	public void saveApprovalHistory(LtVendorApprovalHistory ltExpenseApprovalHistory) throws ServiceException 
	{
		Status status=new Status();
		ltExpenseApprovalHistory.setLastUpdateDate(new Date());
		List<LtVendorApproval> ltExpenseApprovalList =ltVendorApprovalDao.chkEmpApproval(ltExpenseApprovalHistory.getEmployeeId()
				,ltExpenseApprovalHistory.getVendorId());
		if(ltExpenseApprovalList.size()>0)
		{
			ltExpenseApprovalHistory.setStatus(APPROVED);
		}
		
		
		if (ltVendorApprovalHistoryDao.save(ltExpenseApprovalHistory))
		{
			status=ltMastCommonMessageService.getCodeAndMessage(INSERT_SUCCESSFULLY);
			if (status.getMessage() == null) 
			{
					status.setCode(SUCCESS);
					status.setMessage("Error in finding message! The action is completed successfully.");
			}
		}
		else {
			status=ltMastCommonMessageService.getCodeAndMessage(INSERT_FAIL);
				if (status.getMessage() == null) {
				status.setCode(EXCEPTION);
				status.setMessage("Error in finding message! The action was unsuccessful");
			}
		}
		
	}

	@Override
	public List<LtVendorApprovalHistory> getVendorApprovalHistoryByVendorId(Long vendorId) throws ServiceException {
		return ltVendorApprovalHistoryDao.getVendorApprovalHistoryByVendorId(vendorId);
	}

	@Override
	public ResponseEntity<Status> save(LtVendorApprovalHistory ltVendorApprovalHistory) throws ServiceException {
		Status status = new Status();
		ltVendorApprovalHistory.setLastUpdateDate(new Date());
		if (ltVendorApprovalHistoryDao.save(ltVendorApprovalHistory)) 
		{
			status=ltMastCommonMessageService.getCodeAndMessage(REMARK_SAVED);
			if (status.getMessage() == null) 
			{
				status.setCode(SUCCESS);
				status.setMessage("Error in finding message! The action is completed successfully.");
			}
		}
		else
		{
			status=ltMastCommonMessageService.getCodeAndMessage(INSERT_FAIL);
			if (status.getMessage() == null) {
				status.setCode(EXCEPTION);
				status.setMessage("Error in finding message! The action was unsuccessful");
			}
		}

		 return new ResponseEntity<Status>(status, HttpStatus.OK);
	}

	@Override
	public void saveInvoiceApprovalHistory(LtInvoiceApprovalHistory ltInvoiceApprovalHistory) throws ServiceException {
		Status status=new Status();
		ltInvoiceApprovalHistory.setLastUpdateDate(new Date());
		List<InvoiceApproval> invoiceApprovalList =invoiceApprovalDao.chkInvoiceEmpApproval(ltInvoiceApprovalHistory.getEmployeeId()
				,ltInvoiceApprovalHistory.getInvoiceHeaderId());
		
		if(invoiceApprovalList.size()>0)
		{
			ltInvoiceApprovalHistory.setStatus(APPROVED);
		}
		
		if (ltInvoiceApprovalHistoryDao.save(ltInvoiceApprovalHistory))
		{
			status=ltMastCommonMessageService.getCodeAndMessage(INSERT_SUCCESSFULLY);
			if (status.getMessage() == null) 
			{
					status.setCode(SUCCESS);
					status.setMessage("Error in finding message! The action is completed successfully.");
			}
		}
		else {
			status=ltMastCommonMessageService.getCodeAndMessage(INSERT_FAIL);
				if (status.getMessage() == null) {
				status.setCode(EXCEPTION);
				status.setMessage("Error in finding message! The action was unsuccessful");
			}
		}
		
	}

	@Override
	public List<LtInvoiceApprovalHistory> getInvoiceApprovalHistoryByInvoiceId(Long invoiceHeaderId)
			throws ServiceException {
		return ltInvoiceApprovalHistoryDao.getInvoiceApprovalHistoryByInvoiceHeaderId(invoiceHeaderId);
	}

}
