package com.lonar.vendor.vendorportal.dao;

import java.util.Date;
import java.util.List;

import com.lonar.vendor.vendorportal.model.DashboardDetails;
import com.lonar.vendor.vendorportal.model.InvoiceApproval;
import com.lonar.vendor.vendorportal.model.LtInvoiceHeaders;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

public interface LtInvoiceHeadersDao
{

	Long getLtInvoiceHeadersCount(LtInvoiceHeaders input, Long companyId) throws ServiceException;

	List<LtInvoiceHeaders> getLtInvoiceHeadersDataTable(LtInvoiceHeaders input, Long companyId) throws ServiceException;

	Long getLtInvoiceHeadersCountByVendorId(LtInvoiceHeaders input, Long venId) throws ServiceException;

	List<LtInvoiceHeaders> getLtInvoiceHeadersDataTableByVendorId(LtInvoiceHeaders input, Long venId) throws ServiceException;

	List<DashboardDetails> getCountAndStatusByVendorId(Long vendorId) throws ServiceException;

	List<LtInvoiceHeaders> getAllInvoice() throws ServiceException;

	List<LtInvoiceHeaders> getAllInvoiceByInitiator(Long initiatorId) throws ServiceException;

	Long save(LtInvoiceHeaders ltInvoiceHeaders) throws ServiceException;

	boolean update(LtInvoiceHeaders ltInvoiceHeaders) throws ServiceException;

	LtInvoiceHeaders getInvoiceById(Long id) throws ServiceException;

	LtInvoiceHeaders getByInvoiceNumber(String invoiceNum) throws ServiceException;
	
	List<LtInvoiceHeaders> getInprocessInvoiceList(String inprogressStr) throws ServiceException;
	
	InvoiceApproval getApprovalLevel(Long invoiceHeaderId) throws ServiceException;
	
	List<InvoiceApproval> getApprovalList(Long invoiceHeaderId, String currentApprovalLevel) throws ServiceException;
	
	String getNextApprovalLevel(Long invoiceHeaderId, String currentApprovalLavel) throws ServiceException;

	boolean submitForApproval(Date date, Long invoiceHeaderId, String state, Object object) throws ServiceException;
	
	boolean upDateStatus(Long invoiceHeaderId, String pending, String currentApprovalLavel) throws ServiceException;

	void updateCurrentApprovalLevel(Long invoiceHeaderId, String currentApprovalLavel) throws ServiceException;
	
	String checkforApprovals(Long invoiceHeaderId) throws ServiceException;
	
	Status invoiceSubmitForApproval(Date date, Long invoiceHeaderId, String status, Object object) throws ServiceException;
	
	boolean chkForApprovers(Long invoiceHeaderId) throws ServiceException;
	
	boolean loadApprovers(LtInvoiceHeaders ltInvoiceHeaders) throws ServiceException;
	
	LtInvoiceHeaders getInvoiceStatusById(Long invoiceHeaderId) throws ServiceException;
	
	boolean checkStatusIsPending(Long invoiceHeaderId, Long approvalId) throws ServiceException;

	LtInvoiceHeaders getByInvNumVendAndAddr(String invoiceNum, Long vendorId, Long vendorAddId) throws ServiceException;

	boolean delete(Long invoiceHeaderId) throws ServiceException;

	List<DashboardDetails> getInvoiceAmtByUserId(Long userId) throws ServiceException;

	Status callInvoiceValidationProc(Long invoiceHeaderId) throws ServiceException;

	void loadLines(LtInvoiceHeaders ltInvoiceHeaders);
}
