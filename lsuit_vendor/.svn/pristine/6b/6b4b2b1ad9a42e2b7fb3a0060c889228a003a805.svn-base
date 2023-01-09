package com.lonar.vendor.vendorportal.service;

import java.util.List;

import com.lonar.vendor.vendorportal.model.LtInvoiceLines;
import com.lonar.vendor.vendorportal.model.LtPoLines;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

public interface LtInvoiceLineService
{

	Long getLtInvoiceLinesCount(LtInvoiceLines input) throws ServiceException;

	List<LtInvoiceLines> getLtInvoiceLinesDataTable(LtInvoiceLines input) throws ServiceException;

	LtInvoiceLines getInvoiceLineById(Long id) throws ServiceException;

	List<LtInvoiceLines> getAllInvoiceLinesByHeaderId(Long id) throws ServiceException;

	Status save(LtInvoiceLines ltInvoiceLines) throws ServiceException;

	Status update(LtInvoiceLines ltInvoiceLines) throws ServiceException;

	Status delete(Long vendorId);

	Long getLtInvoiceLinesCountByHeader(LtInvoiceLines input, Long id) throws ServiceException;

	List<LtInvoiceLines> getLtInvoiceLinesDataTableByHeader(LtInvoiceLines input, Long id) throws ServiceException;

	Status loadLines(List<Long> poLinelist, Long invoiceHeaderId) throws ServiceException;

}
