package com.lonar.vendor.vendorportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lonar.vendor.vendorportal.model.BusinessException;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtVendorApproval;
import com.lonar.vendor.vendorportal.model.LtVendorApprovalHistory;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.service.LtVendorApprovalHistoryService;
import com.lonar.vendor.vendorportal.service.LtVendorApprovalService;

@RestController
@RequestMapping("/API/approval")
public class LtVendorApprovalRestController implements CodeMaster
{

	@Autowired
	LtVendorApprovalService ltVendorApprovalService;
	
	@Autowired
	LtVendorApprovalHistoryService ltVendorApprovalHistoryService;
	
	@RequestMapping(value = "/chkForApprovalByVendorIdAppID/{vendorId}/{appId}/{logTime}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Status> getVendorApprovalByVendorId(@PathVariable("vendorId") Long vendorId,
    		@PathVariable("appId") Long appId,@PathVariable("logTime") String logTime)
    {
           Status status = new Status();
           LtVendorApproval ltVendorApproval=null;
            try
            {
            	ltVendorApproval=ltVendorApprovalService.getVendorApproval(vendorId, appId);
            	if(ltVendorApproval!=null)
            	{
            		status.setCode(0);
            		status.setMessage("Approval present");
            	}
            	else
            	{
            		status.setCode(1);
            		status.setMessage("Approval absent");
            	}
            }
            catch(Exception e)
            {
            	throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
            }
          
            return new ResponseEntity<Status>(status, HttpStatus.OK);
    }
	
	
	@RequestMapping(value = "/updateStatusApproval", method = RequestMethod.POST,consumes = "application/json")
	public ResponseEntity<Status> updateStatusApproval( @RequestBody LtVendorApprovalHistory approvalHistory )
	{
		Status status=new Status();
		try {
			status=ltVendorApprovalService.updateStatusApproval(approvalHistory);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getVendorApproval/{vendorId}/{approvalId}/{logTime}", method = RequestMethod.GET,produces = "application/json")
	public ResponseEntity<Status> getExpenseApproval(@PathVariable("vendorId") Long vendorId, @PathVariable("approvalId") Long apprId,@PathVariable("logTime") String logTime)
	{
		Status status = new Status();
		LtVendorApproval ltVendorApproval=null;
		try
		{
			ltVendorApproval=ltVendorApprovalService.getVendorApproval(vendorId, apprId);
			status.setData(ltVendorApproval);
			if(ltVendorApproval != null) {
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
	
	//@PreAuthorize("hasPermission(null, '#/expenses/expenseDemo', 'View') or hasPermission(null, '#/myAdvance/advanceDemo', 'View')")
	@RequestMapping(value = "/getApprovalByVendorId/{id}/{logTime}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<LtVendorApproval>> getVendorApprovalByVendorId(@PathVariable("id") Long vendorId,@PathVariable("logTime") String logTime) throws ServiceException
    {
            List<LtVendorApproval> ltVendorApproval=
            			ltVendorApprovalService.getVendorApprovalByVendorId(vendorId);
            return new ResponseEntity<List<LtVendorApproval>>(ltVendorApproval, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/getApprovalHistoryByVendorId/{id}/{logTime}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<LtVendorApprovalHistory>> getExpenseApprovalHistoryByExpHeaderId(@PathVariable("id") Long vendorId,@PathVariable("logTime") String logTime) throws ServiceException
    {
          List<LtVendorApprovalHistory> ltVendorApprovalHistoryList=
        		  ltVendorApprovalHistoryService.getVendorApprovalHistoryByVendorId(vendorId);

          return new ResponseEntity<List<LtVendorApprovalHistory>>(ltVendorApprovalHistoryList, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/save", method= RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Status> save(@RequestBody LtVendorApprovalHistory ltVendorApprovalHistory) throws ServiceException
	{
		return ltVendorApprovalHistoryService.save(ltVendorApprovalHistory);
	}
	
	
	@RequestMapping(value = "/getApprovalByInvoiceId/{id}/{logTime}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<LtVendorApproval>> getInvoiceApprovalByInvoiceId(@PathVariable("id") Long invoiceId,@PathVariable("logTime") String logTime) throws ServiceException
    {
            List<LtVendorApproval> ltVendorApproval=
            			ltVendorApprovalService.getInvoiceApprovalByInvoiceId(invoiceId);
            return new ResponseEntity<List<LtVendorApproval>>(ltVendorApproval, HttpStatus.OK);
    }
}
