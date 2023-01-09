package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import com.lonar.vendor.vendorportal.model.LtMastVendorHsnSacCodes;
import com.lonar.vendor.vendorportal.model.ServiceException;

public interface LtMastVendorHsnSacCodesDao 
{

	List<LtMastVendorHsnSacCodes> getAllVendorHsnSacCodes() throws ServiceException;

	LtMastVendorHsnSacCodes getByHsnId(Long vendorHsnId) throws ServiceException;

	Long save(LtMastVendorHsnSacCodes vendorhsnSacCode) throws ServiceException;

	boolean update(LtMastVendorHsnSacCodes vendorhsnSacCode) throws ServiceException;

	boolean delete(Long vendorHsnId) throws ServiceException;

	List<LtMastVendorHsnSacCodes> getByVendorIdAndAddrId(Long vendorId, Long addrId) throws ServiceException;

	List<LtMastVendorHsnSacCodes> getVendorHsnByVendorId(Long vendorId) throws ServiceException;

	boolean deleteByvendorId(Long vendorId) throws ServiceException;

	boolean checkforDuplicate(LtMastVendorHsnSacCodes vendorhsnSacCode) throws ServiceException;

	Long getLtMastVendorHsnSacCodesCount(Long vendorAddressId, LtMastVendorHsnSacCodes input) throws ServiceException;

	List<LtMastVendorHsnSacCodes> getLtMastVendorHsnSacCodesDataTable(Long vendorAddressId,
			LtMastVendorHsnSacCodes input) throws ServiceException;

}
