package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import com.lonar.vendor.vendorportal.controller.VendorBuyerDetails;
import com.lonar.vendor.vendorportal.model.LtMastCommunicationTab;
import com.lonar.vendor.vendorportal.model.LtMastVendors;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

public interface LtMastCommunicationTabDao {

	LtMastCommunicationTab getByVendorBuyer(Long vendorId,Long companyId) throws ServiceException;

	List<LtMastCommunicationTab> getAllCommunicationByComId(Long companyId) throws ServiceException;

	List<LtMastCommunicationTab> getallvendorcommunication(Long commId) throws ServiceException;

	List<LtMastCommunicationTab> getAllBuyerCommunication(Long vendorId) throws ServiceException;

	Status getVendorNotificationCount(Long buyerId) throws ServiceException;

	Status getBuuyerNotificationCount(Long buyerId) throws ServiceException;

	Status updateVendorNotification(Long buyerId) throws ServiceException;

	Status updateBuuyerNotification(Long buyerId, Long vendorId) throws ServiceException;

	List<LtMastVendors> getLikeNameByBuyerId(String name, Long buyerId) throws ServiceException;

	List<LtMastVendors> getLikeNameByBuyerName(String name) throws ServiceException;

	List<VendorBuyerDetails> getVendorMsgByBuyerId(Long buyerId) throws ServiceException;

}
