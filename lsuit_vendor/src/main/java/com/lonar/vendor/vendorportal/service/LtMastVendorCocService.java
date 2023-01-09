package com.lonar.vendor.vendorportal.service;


import com.lonar.vendor.vendorportal.model.LtMastVendorCoc;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

public interface LtMastVendorCocService {

	LtMastVendorCoc getAttachmentByVendorId(Long vendorId) throws ServiceException;

	Status checkRecord(Long venId) throws ServiceException;

	Status deleteLtMastVendorCoc(Long vendorAttachmentId) throws ServiceException;

}
