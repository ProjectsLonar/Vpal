package com.lonar.vendor.vendorportal.service;

import java.util.List;

import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtMastVendorHsnSacCodes;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

public interface LtMastVendorHsnSacCodesService extends CodeMaster
{

	List<LtMastVendorHsnSacCodes> getAllVendorHsnSacCodes()throws ServiceException;

	LtMastVendorHsnSacCodes getByHsnId(Long vendorHsnId) throws ServiceException;

	Status save(LtMastVendorHsnSacCodes vendorhsnSacCode) throws ServiceException;

	Status update(LtMastVendorHsnSacCodes vendorhsnSacCode) throws ServiceException;

	Status delete(Long vendorHsnId) throws ServiceException;

	List<LtMastVendorHsnSacCodes> getByVendorIdAndAddrId(Long vendorId, Long addrId) throws ServiceException;

	Long getLtMastVendorHsnSacCodesCount(Long vendorAddressId, LtMastVendorHsnSacCodes input) throws ServiceException;

	List<LtMastVendorHsnSacCodes> getLtMastVendorHsnSacCodesDataTable(Long vendorAddressId,
			LtMastVendorHsnSacCodes input) throws ServiceException;

}
