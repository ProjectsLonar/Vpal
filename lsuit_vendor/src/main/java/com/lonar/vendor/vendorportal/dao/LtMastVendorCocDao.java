package com.lonar.vendor.vendorportal.dao;

import com.lonar.vendor.vendorportal.model.LtMastVendorCoc;
import com.lonar.vendor.vendorportal.model.ServiceException;

public interface LtMastVendorCocDao 
{

	LtMastVendorCoc getAttachmentByVendorId(Long vendorId) throws ServiceException;

	boolean deleteLtMastVendorCoc(Long vendorAttachmentId) throws ServiceException;

	

}
