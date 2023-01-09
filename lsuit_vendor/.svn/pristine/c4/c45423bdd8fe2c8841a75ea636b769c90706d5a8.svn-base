package com.lonar.vendor.vendorportal.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.lonar.vendor.vendorportal.model.VendorApproval;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.lonar.vendor.vendorportal.model.InvoiceApproval;
import com.lonar.vendor.vendorportal.model.LtInvoiceHeaders;
import com.lonar.vendor.vendorportal.model.LtMastEmailtoken;
import com.lonar.vendor.vendorportal.model.LtMastVendors;
import com.lonar.vendor.vendorportal.model.SendBroadCastEmail;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

public interface LtMastEmailtokenService 
{

	void makeEntryInEmailToken(List<VendorApproval> expenseApprovals, String emailTemplate,
			LtMastVendors ltMastVendors, String string) throws ServiceException,ParseException;

	List<LtMastEmailtoken> findAllActive() throws ServiceException;

	void updateStatus(Long emailTokenId, String string, Integer i) throws ServiceException;

	Status sendMail(SendBroadCastEmail emailList)throws ServiceException;

	void makeInvoiceEntryInEmailToken(List<InvoiceApproval> invoiceApprovalsList, String emailTemplate,
			LtInvoiceHeaders ltInvoiceHeaders, String string) throws ServiceException,ParseException;

	Status sendBroadCastMessage(SendBroadCastEmail emailList) throws ServiceException;

	Status sendBroadCastMsgAndEmail(String emailList, MultipartFile[] files) throws ServiceException, JsonParseException, JsonMappingException, IOException;

}
