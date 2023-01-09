package com.lonar.vendor.vendorportal.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.lonar.vendor.vendorportal.model.LtInvoiceApprovalHistory;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

public interface LtInvoiceApprovalHistoryService 
{

	ResponseEntity<Status> save(LtInvoiceApprovalHistory ltInvoiceApprovalHistory) throws ServiceException;

	List<LtInvoiceApprovalHistory> getInvoiceApprovalHistoryByInvoiceId(Long invoiceHeaderId) throws ServiceException;

}
