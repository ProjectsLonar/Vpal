/*package com.lonar.vendor.vendorportal.service;

import java.util.List;

import javax.jdo.annotations.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lonar.vendor.vendorportal.dao.LtMastCommunicationDao;
import com.lonar.vendor.vendorportal.model.LtMastCommunication;
import com.lonar.vendor.vendorportal.model.LtMastVendors;
import com.lonar.vendor.vendorportal.model.Status;

@Service
public class LtMastCommunicationServiceImpl implements LtMastCommunicationService {
	
	@Autowired
	LtMastCommunicationDao ltMastCommunicationDao;

	@Override
	@Transactional
	public Status save(LtMastCommunication LtMastCommunication) throws Exception {
		return ltMastCommunicationDao.save(LtMastCommunication);
	}

	@Override
	public List<LtMastCommunication> getAllCommunicationListByBuyerId(Long buyerId) throws Exception {
		return ltMastCommunicationDao.getAllCommunicationListByBuyerId(buyerId);
	}

	@Override
	public List<LtMastCommunication> getVendorBuyerCommunicationDetails(Long buyerId, Long vendorId) throws Exception {
		return ltMastCommunicationDao.getVendorBuyerCommunicationDetails(buyerId, vendorId);
	}

	@Override
	public Status getVendorNameById(Long vendorId) throws Exception {
		return ltMastCommunicationDao.getVendorNameById(vendorId);
	}

	@Override
	public Status getVendorNotificationCount(Long buyerId) throws Exception {
		return ltMastCommunicationDao.getVendorNotificationCount(buyerId);
	}

	@Override
	public Status getBuuyerNotificationCount(Long buyerId) throws Exception {
		return ltMastCommunicationDao.getBuuyerNotificationCount(buyerId);
	}

	@Override
	@Transactional
	public Status updateVendorNotification(Long buyerId) throws Exception {
		return ltMastCommunicationDao.updateVendorNotification(buyerId);
	}

	@Override
	@Transactional
	public Status updateBuuyerNotification(Long buyerId, Long vendorId) throws Exception {
		return ltMastCommunicationDao.updateBuuyerNotification(buyerId, vendorId);
	}

	@Override
	public List<LtMastVendors> getLikeNameByBuyerId(String name, Long buyerId) throws Exception {
		return ltMastCommunicationDao.getLikeNameByBuyerId(name, buyerId);
	}

	@Override
	public List<LtMastVendors> getLikeNameByBuyerName(String name) throws Exception {
		return ltMastCommunicationDao.getLikeNameByBuyerName(name);
	}

	@Override
	public List<LtMastCommunication> getAllCommunicationListByVendorId(Long vendorId) throws Exception {
		return ltMastCommunicationDao.getAllCommunicationListByVendorId(vendorId);
	}

}

*/