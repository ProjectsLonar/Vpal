package com.lonar.vendor.vendorportal.service;

import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.lonar.vendor.vendorportal.model.DashboardDetails;
import com.lonar.vendor.vendorportal.model.LtInvoiceHeaders;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

public interface LtInvoiceHeadersService
{

	Long getLtInvoiceHeadersCount(LtInvoiceHeaders input) throws ServiceException;

	List<LtInvoiceHeaders> getLtInvoiceHeadersDataTable(LtInvoiceHeaders input) throws ServiceException;

	Long getLtInvoiceHeadersCountByVendorId(LtInvoiceHeaders input, Long venId) throws ServiceException;

	List<LtInvoiceHeaders> getLtInvoiceHeadersDataTableByVendorId(LtInvoiceHeaders input, Long venId) throws ServiceException;

	List<DashboardDetails> getCountAndStatusByVendorId(Long vendorId) throws ServiceException;

	List<LtInvoiceHeaders> getAllInvoice() throws ServiceException;

	List<LtInvoiceHeaders> getAllInvoiceByInitiator(Long initiatorId) throws ServiceException;

	Status save(LtInvoiceHeaders vendors) throws ServiceException;

	Status update(LtInvoiceHeaders vendors) throws ServiceException;

	Status delete(Long vendorId) throws ServiceException;

	LtInvoiceHeaders getInvoiceById(Long id) throws ServiceException;
	
	
	String checkforApprovals(Long invoiceHeaderId) throws ServiceException;
	
	Status submitForApproval(Date date, Long invoiceHeaderId, String status, Object object) throws ServiceException;
	
	LtInvoiceHeaders getInvoiceStatusById(Long invoiceHeaderId) throws ServiceException;
	
	boolean checkStatusIsPending(Long invoiceHeaderId, Long approvalId) throws ServiceException;

	List<DashboardDetails> getInvoiceAmtByUserId(Long userId) throws ServiceException;

	Long getLtInvoiceHeadersCountById(LtInvoiceHeaders input, Long id) throws ServiceException;

	List<LtInvoiceHeaders> getLtInvoiceHeadersDataTableById(LtInvoiceHeaders input, Long id) throws ServiceException;

	
	

}
