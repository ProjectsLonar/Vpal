package com.lonar.vendor.vendorportal.excelupload;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

public interface LtMastFileUploadService {

	Status uploadFile(MultipartFile file, String requestName, Long requestorId) throws ServiceException;

	List<LtInvoiceHeadersStg> getByRequestId(Long requestId) throws ServiceException;

	Status createInvoice(Long requestId) throws ServiceException;

	Long getLtInvoiceHeadersStgCount(Long requestId, LtInvoiceHeadersStg input) throws ServiceException;

	List<LtInvoiceHeadersStg> getLtInvoiceHeadersStgData(Long requestId, LtInvoiceHeadersStg input)
			throws ServiceException;
}
