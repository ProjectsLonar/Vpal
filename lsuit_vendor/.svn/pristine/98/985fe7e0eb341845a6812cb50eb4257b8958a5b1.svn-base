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
import com.lonar.vendor.vendorportal.model.CustomeDataTable;
import com.lonar.vendor.vendorportal.model.InboxBulkInput;
import com.lonar.vendor.vendorportal.model.InvoiceApproval;
import com.lonar.vendor.vendorportal.model.LtMastVendors;
import com.lonar.vendor.vendorportal.model.LtVendorApprovalHistory;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.model.VendorApproval;
import com.lonar.vendor.vendorportal.service.LtMastVendorsService;
import com.lonar.vendor.vendorportal.service.LtVendorApprovalService;
import com.lonar.vendor.vendorportal.service.LtVendorInboxService;

@RestController
@RequestMapping("/API/Inbox")
public class LtVendorInboxRestController implements CodeMaster {

	@Autowired
	LtVendorInboxService ltVendorInboxService;
	
	@Autowired
	LtMastVendorsService ltMastVendorsService;

	@Autowired
	LtVendorApprovalService ltVendorApprovalService;
	
	
	
	@RequestMapping(value = "/dataTable/{approvalId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomeDataTable getVendorApprovalVDataTableByApprId(VendorApproval input,
			@PathVariable("approvalId") String approvalId, @PathVariable("logTime") String logTime) {
		String status1 = PENDING;
		CustomeDataTable customeDataTable = new CustomeDataTable();
		try {
			Long count = ltVendorInboxService.getCount(status1, approvalId, input);

			customeDataTable.setRecordsTotal(count);
			customeDataTable.setRecordsFiltered(count);

			List<VendorApproval> expenseApprovalList = ltVendorInboxService.getByStatus(status1, approvalId, input);
			customeDataTable.setData(expenseApprovalList);

		} catch (Exception e) {
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
		return customeDataTable;
	}

	// -----------------------------------------------------------------------------------------------
	@RequestMapping(value = "/saveBulk", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> saveBulk(@RequestBody InboxBulkInput inboxBulkInput) {
		Status status = new Status();
		List<String> responseMessage = new ArrayList<String>();
		try {
			List<BulkIdWithName> expenseIdList = inboxBulkInput.getExpenseList();

			LtVendorApprovalHistory ltVendorApprovalHistory = new LtVendorApprovalHistory();
			for (BulkIdWithName bulkIdWithName : expenseIdList) {
				ltVendorApprovalHistory.setLastUpdateDate(new Date());
				// ltExpenseApprovalHistory.setNote(inboxBulkInput.getNote());
				ltVendorApprovalHistory.setStatus(inboxBulkInput.getAction());
				ltVendorApprovalHistory.setVendorApprovalId(bulkIdWithName.getVendorApprovalId());
				ltVendorApprovalHistory.setVendorId(bulkIdWithName.getVendorId());
				ltVendorApprovalHistory.setRemark(inboxBulkInput.getNote());
				ltVendorApprovalHistory.setEmployeeId(inboxBulkInput.getApprovalId());

				if (inboxBulkInput.getAction().equals(APPROVED)) {
					ltVendorApprovalHistory.setStatus(APPROVED);
				} else if (inboxBulkInput.getAction().equals(REJECTED)) {
					ltVendorApprovalHistory.setStatus(REJECTED);
				} else if (inboxBulkInput.getAction().equals(FEEDBACK_AWAITED)) {
					ltVendorApprovalHistory.setStatus(FEEDBACK_AWAITED);
				}

				LtMastVendors ltMastVendors = ltMastVendorsService.getVendorById(bulkIdWithName.getVendorId());

				status = ltVendorApprovalService.updateStatusApproval(ltVendorApprovalHistory);
				responseMessage.add(ltMastVendors.getVendorName() + " " + status.getMessage());
				
			}
			status.setData(responseMessage);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}

	@RequestMapping(value = "/approvalnotification/{empId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<VendorApproval> getVendorApprovalNotification(@PathVariable("empId") Long empId,
			@PathVariable("logTime") String logTime) {
		String status = PENDING;
		try {

			List<VendorApproval> expenseApprovalList = ltVendorInboxService.getVendorApprovalNotification(status,
					empId);
			return expenseApprovalList;
		} catch (Exception e) {
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
	}

	@RequestMapping(value = "/invoicedataTable/{approvalId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomeDataTable getInvoiceDataTableByApprId(InvoiceApproval input,
			@PathVariable("approvalId") String approvalId, @PathVariable("logTime") String logTime) {
		String status1 = PENDING;
		CustomeDataTable customeDataTable = new CustomeDataTable();
		try {
			Long count = ltVendorInboxService.getInvoiceCount(status1, approvalId, input);

			customeDataTable.setRecordsTotal(count);
			customeDataTable.setRecordsFiltered(count);

			List<InvoiceApproval> invoiceApprovalList = ltVendorInboxService.getInvoiceByStatus(status1, approvalId,
					input);
			customeDataTable.setData(invoiceApprovalList);

		} catch (Exception e) {
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
		return customeDataTable;
	}

	
	
}
