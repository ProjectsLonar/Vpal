package com.lonar.vendor.vendorportal.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lonar.vendor.vendorportal.dao.LtInvoiceAttachmentDao;
import com.lonar.vendor.vendorportal.model.LtInvoiceAttachment;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.service.LtMastCommonMessageService;
import com.lonar.vendor.vendorportal.service.LtInvoiceAttachmentService;

@Service
public class LtInvoiceAttachmentServiceImpl implements LtInvoiceAttachmentService {
	
	@Autowired
	LtInvoiceAttachmentDao ltMastInvoiceAttachmentDao;
	
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;

	@Override
	public List<LtInvoiceAttachment> getAllFilesByInvoiceHeaderId(Long invoiceId) throws ServiceException {
		return ltMastInvoiceAttachmentDao.getAllFilesByInvoiceId(invoiceId);
	}

	@Override
	public LtInvoiceAttachment getAttachmentByInvoiceIdAndType(Long invoiceId) throws ServiceException {
		return ltMastInvoiceAttachmentDao.getAttachmentByInvoiceIdAndType(invoiceId);
	}

	@Override
	@Transactional
	public Status deleteLtMastVendorAttachmentFile(Long invoiceAttachmentId) {
		Status status = new Status();
		if(ltMastInvoiceAttachmentDao.deleteLtMastInvoiceAttachmentFile(invoiceAttachmentId))
		{
			status=ltMastCommonMessageService.getCodeAndMessage(ATTACHEMENT_DELETED_SUCCESS);
			if( status.getMessage()==null)
			{
				status.setCode(SUCCESS);
				status.setMessage("Error in finding message! The action is completed successfully.");
			}
		}
		else
		{
			status=ltMastCommonMessageService.getCodeAndMessage(ATTACHEMENT_DELETED_FAIL);
			if( status.getMessage()==null)
			{
				status.setCode(FAIL);
				status.setMessage("Error in finding message! The action is completed UnSuccessfully.");
			}
		}
		return status;
	}

}
