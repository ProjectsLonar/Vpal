package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import com.lonar.vendor.vendorportal.model.LtInvoiceLines;
import com.lonar.vendor.vendorportal.model.LtPoLines;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

public interface LtInvoiceLinesDao 
{

	Long getLtInvoiceLinesCount(LtInvoiceLines input) throws ServiceException;

	List<LtInvoiceLines> getLtInvoiceLinesDataTable(LtInvoiceLines input) throws ServiceException;

	LtInvoiceLines getInvoiceLineById(Long id) throws ServiceException;

	List<LtInvoiceLines> getAllInvoiceLinesByHeaderId(Long id) throws ServiceException;

	Long save(LtInvoiceLines ltInvoiceLines) throws ServiceException;

	boolean updateAmount(LtInvoiceLines ltInvoiceLines) throws ServiceException;

	Long getLtInvoiceLinesCountByHeader(LtInvoiceLines input, Long id) throws ServiceException;

	List<LtInvoiceLines> getLtInvoiceLinesDataTableByHeader(LtInvoiceLines input, Long id) throws ServiceException;

	boolean deleteByHeaderId(Long invoiceHeaderId) throws ServiceException;

	Status loadLines(List<LtPoLines> poLinelist, Long invoiceHeaderId) throws ServiceException;

	boolean updateFlag(LtInvoiceLines ltInvoiceLines) throws ServiceException;

}
