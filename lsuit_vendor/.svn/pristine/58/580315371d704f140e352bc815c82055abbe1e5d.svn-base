package com.lonar.vendor.vendorportal.service;

import java.util.List;

import com.lonar.vendor.vendorportal.model.LtInvoiceAccounting;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

public interface LtInvoiceAccountingService 
{

	LtInvoiceAccounting getInvoiceAccountingById(Long id) throws ServiceException;

	List<LtInvoiceAccounting> getInvoiceAccountingByHeaderId(Long id) throws ServiceException;

	List<LtInvoiceAccounting> getInvoiceAccountingByLineId(Long id) throws ServiceException;

	Status save(LtInvoiceAccounting ltInvoiceAccounting) throws ServiceException;

	Status update(LtInvoiceAccounting ltInvoiceAccounting) throws ServiceException;

	Status delete(Long id);

}
