package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import com.lonar.vendor.vendorportal.model.LtMastGlAccounts;
import com.lonar.vendor.vendorportal.model.LtMastBillingAddresses;
import com.lonar.vendor.vendorportal.model.ServiceException;

public interface LtMastBillingAddressesDao 
{

	public List<LtMastBillingAddresses> getLikeBillingAddressCode(String name) throws ServiceException ;

	public List<LtMastBillingAddresses> getByBillingId(Long id) throws ServiceException;

	public List<LtMastBillingAddresses> getByBillingAddresses(String name) throws ServiceException;
	
	public List<LtMastBillingAddresses> getLikeBillingAddressByState(Long venId, String name) throws ServiceException ;

	public Long getCount(LtMastBillingAddresses input) throws ServiceException ;

	public List<LtMastBillingAddresses> getDatatableRecords(LtMastBillingAddresses input) throws ServiceException ;
}
