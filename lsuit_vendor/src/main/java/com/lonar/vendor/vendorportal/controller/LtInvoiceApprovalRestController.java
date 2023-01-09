package com.lonar.vendor.vendorportal.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lonar.vendor.vendorportal.model.BulkIdWithName;
import com.lonar.vendor.vendorportal.model.BusinessException;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.InboxBulkInput;
import com.lonar.vendor.vendorportal.model.InvoiceApproval;
import com.lonar.vendor.vendorportal.model.LtInvoiceApprovalHistory;
import com.lonar.vendor.vendorportal.model.LtInvoiceHeaders;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.service.LtInvoiceApprovalHistoryService;
import com.lonar.vendor.vendorportal.service.LtInvoiceApprovalService;
import com.lonar.vendor.vendorportal.service.LtInvoiceHeadersService;
import com.lonar.vendor.vendorportal.service.LtVendorApprovalHistoryService;

@RestController
@RequestMapping("/API/invoiceapproval")
public class LtInvoiceApprovalRestController implements CodeMaster
{

	@Autowired
	LtInvoiceHeadersService ltInvoiceHeadersService;

	@Autowired
	LtInvoiceApprovalService ltInvoiceApprovalService;
	
	//@Autowired
	//LtInvoiceApprovalService invoiceApprovalService;
	
	@Autowired
	LtVendorApprovalHistoryService ltVendorApprovalHistoryService;
	
	@Autowired
	LtInvoiceApprovalHistoryService ltInvoiceApprovalHistoryService;
	
	@RequestMapping(value = "/updateInvoiceStatusApproval", method = RequestMethod.POST,consumes = "application/json")
	public ResponseEntity<Status> updateInvoiceStatusApproval( @RequestBody LtInvoiceApprovalHistory approvalHistory )
	{
		Status status=new Status();
		try {
			status=ltInvoiceApprovalService.updateInvoiceStatusApproval(approvalHistory);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getApprovalHistoryByInvoiceId/{invoiceHeaderId}/{logTime}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<LtInvoiceApprovalHistory>> getExpenseApprovalHistoryByExpHeaderId(@PathVariable("invoiceHeaderId") Long invoiceHeaderId,@PathVariable("logTime") String logTime) throws ServiceException
    {
          List<LtInvoiceApprovalHistory> ltInvoiceApprovalHistory=
        		  ltInvoiceApprovalHistoryService.getInvoiceApprovalHistoryByInvoiceId(invoiceHeaderId);

          return new ResponseEntity<List<LtInvoiceApprovalHistory>>(ltInvoiceApprovalHistory, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/save", method= RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Status> save(@RequestBody LtInvoiceApprovalHistory ltInvoiceApprovalHistory) throws ServiceException
	{
		return ltInvoiceApprovalHistoryService.save(ltInvoiceApprovalHistory);
	}

	@RequestMapping(value = "/getInvoiceApproval/{invoiceId}/{approvalId}/{logTime}", method = RequestMethod.GET,produces = "application/json")
	public ResponseEntity<Status> getInvoiceApproval(@PathVariable("invoiceId") Long invoiceId, @PathVariable("approvalId") Long apprId,@PathVariable("logTime") String logTime)
	{
		Status status = new Status();
		InvoiceApproval invoiceApproval=null;
		try
		{
			invoiceApproval=ltInvoiceApprovalService.getInvoiceApproval(invoiceId, apprId);
			status.setData(invoiceApproval);
			if(invoiceApproval != null) {
				status.setCode(1);
			}
			status.setCode(2);
		}
		catch(Exception e)
		{
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/saveBulkInvoice", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> saveBulkInvoice(@RequestBody InboxBulkInput inboxBulkInput) {
		Status status = new Status();
		List<String> responseMessage = new ArrayList<String>();
		try {
			List<BulkIdWithName> invoiceIdList = inboxBulkInput.getExpenseList();

			LtInvoiceApprovalHistory ltInvoiceApprovalHistory = new LtInvoiceApprovalHistory();
			for (BulkIdWithName bulkIdWithName : invoiceIdList) {
				ltInvoiceApprovalHistory.setLastUpdateDate(new Date());
				// ltExpenseApprovalHistory.setNote(inboxBulkInput.getNote());
				ltInvoiceApprovalHistory.setStatus(inboxBulkInput.getAction());
				ltInvoiceApprovalHistory.setInvoiceApprovalId(bulkIdWithName.getInvoiceApprovalId());
				ltInvoiceApprovalHistory.setInvoiceHeaderId(bulkIdWithName.getInvoiceId());
				ltInvoiceApprovalHistory.setRemark(inboxBulkInput.getNote());
				ltInvoiceApprovalHistory.setEmployeeId(inboxBulkInput.getApprovalId());

				if (inboxBulkInput.getAction().equals(APPROVED)) {
					ltInvoiceApprovalHistory.setStatus(APPROVED);
				} else if (inboxBulkInput.getAction().equals(REJECTED)) {
					ltInvoiceApprovalHistory.setStatus(REJECTED);
				} else if (inboxBulkInput.getAction().equals(FEEDBACK_AWAITED)) {
					ltInvoiceApprovalHistory.setStatus(FEEDBACK_AWAITED);
				}

				//LtMastVendors ltMastVendors = ltMastVendorsService.getVendorById(bulkIdWithName.getVendorId());
				LtInvoiceHeaders ltInvoiceHeader =  ltInvoiceHeadersService.getInvoiceById(bulkIdWithName.getInvoiceId());
				status = ltInvoiceApprovalService.updateInvoiceStatusApproval(ltInvoiceApprovalHistory);
				responseMessage.add(ltInvoiceHeader.getInvoiceNum() + " " + status.getMessage());
				
			}
			status.setData(responseMessage);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}
}
