package com.lonar.vendor.vendorportal.service;

import java.util.List;

import com.lonar.vendor.vendorportal.model.LtInvoiceLineTaxes;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

public interface LtInvoiceLineTaxesService {

	LtInvoiceLineTaxes getInvoiceLineTaxesById(Long id) throws ServiceException;

	List<LtInvoiceLineTaxes> getAllInvoiceLinesByHeaderId(Long id) throws ServiceException;

	List<LtInvoiceLineTaxes> getAllInvoiceLinesByLineId(Long id) throws ServiceException;

	Status save(List<LtInvoiceLineTaxes> ltInvoiceLineTaxesList) throws ServiceException;

	Status update(LtInvoiceLineTaxes ltInvoiceLineTaxes) throws ServiceException;

	Status delete(Long vendorId) ;

}
