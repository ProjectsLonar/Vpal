package com.lonar.vendor.vendorportal.excelupload;

import java.util.List;

import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

public interface LtMastFileUploadDao {

	boolean save(LtInvoiceHeadersStg ltInvoiceHeadersStg) throws ServiceException;

	Long getRequestId() throws ServiceException;

	List<LtInvoiceHeadersStg> getByRequestId(Long requestId) throws ServiceException;

	Status createInvoiceProcedure(Long requestId) throws ServiceException;

	Long getLtInvoiceHeadersStgCount(Long requestId, LtInvoiceHeadersStg input) throws ServiceException;

	List<LtInvoiceHeadersStg> getLtInvoiceHeadersStgData(Long requestId, LtInvoiceHeadersStg input)
			throws ServiceException;

}
