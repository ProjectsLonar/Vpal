package com.lonar.vendor.vendorportal.service;

import java.util.List;

import com.lonar.vendor.vendorportal.controller.VendorBuyerDetails;
import com.lonar.vendor.vendorportal.model.DashboardDetails;
import com.lonar.vendor.vendorportal.model.LtPoHeaders;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

public interface LtPoHeadersService 
{

	Long getLtPoHeaderCount(LtPoHeaders input, Long companyId) throws ServiceException;

	List<LtPoHeaders> getLtPoHeaderDataTable(LtPoHeaders input, Long companyId)  throws ServiceException;

	List<LtPoHeaders> getAllPoHeaders()  throws ServiceException;

	List<LtPoHeaders> getAllActivePoHeaders()  throws ServiceException;

	LtPoHeaders getPoHeaderById(Long poHeaderId)  throws ServiceException;

	Status save(LtPoHeaders ltPoHeaders)  throws ServiceException;

	Status update(LtPoHeaders ltPoHeaders)  throws ServiceException;


	Long getLtPoHeaderCountByVendorId(LtPoHeaders input, Long venId) throws ServiceException;

	List<LtPoHeaders> getLtPoHeadersDataTableByVendorId(LtPoHeaders input, Long venId) throws ServiceException;

	DashboardDetails getAmountByVendorId(Long vendorId) throws ServiceException;

	List<DashboardDetails> getCountAndStatusByVendorId(Long vendorId) throws ServiceException;

	List<LtPoHeaders> getTopFivePoById(Long vendorId) throws ServiceException;

	Status viewFile(String name) throws ServiceException;
	
	List<DashboardDetails> getStatusCountByBuyerId(Long buyerId, Long companyId) throws ServiceException;
	
	List<VendorBuyerDetails> getVendorMsgByBuyerId(Long buyerId) throws ServiceException;
	
	List<Object> getQtrStatusCountByBuyerId(Long buyerId, Long year) throws ServiceException;

	Status acknowldge(LtPoHeaders ltPoHeaders) throws ServiceException;

	List<LtPoHeaders> getActivePoHeadersByPoNumber(Long companyId, Long userId, String poNumber) throws ServiceException;

	Status createPOPDFReport(Long poHeaderId,long companyId);

}
