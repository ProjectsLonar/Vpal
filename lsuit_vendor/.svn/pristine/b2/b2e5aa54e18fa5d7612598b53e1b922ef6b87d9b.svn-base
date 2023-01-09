package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import com.lonar.vendor.vendorportal.model.LtInvoiceLineTaxes;
import com.lonar.vendor.vendorportal.model.ServiceException;

public interface LtInvoiceLineTaxesDao {

	LtInvoiceLineTaxes getInvoiceLineTaxesById(Long id) throws ServiceException;

	List<LtInvoiceLineTaxes> getAllInvoiceLinesByHeaderId(Long id) throws ServiceException;

	List<LtInvoiceLineTaxes> getAllInvoiceLinesByLineId(Long id) throws ServiceException;

	void deleteTax(Long invoiceHeaderId) throws ServiceException;

}
