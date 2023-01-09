package com.lonar.vendor.vendorportal.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lonar.vendor.vendorportal.controller.VendorBuyerDetails;
import com.lonar.vendor.vendorportal.dao.LtMastCommunicationTabDao;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtMastCommunicationTab;
import com.lonar.vendor.vendorportal.model.LtMastCommunicationTabDet;
import com.lonar.vendor.vendorportal.model.LtMastVendors;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.repository.LtMastCommunicationTabDetRepository;
import com.lonar.vendor.vendorportal.repository.LtMastCommunicationTabRepository;

@Service
public class LtMastCommunicationTabServiceImpl implements LtMastCommunicationTabService,CodeMaster{

	@Autowired
	LtMastCommunicationTabRepository ltMastCommunicationTabRepository;
	
	@Autowired
	LtMastCommunicationTabDetRepository ltMastCommunicationTabDetRepository;
	
	@Autowired
	LtMastCommunicationTabDao ltMastCommunicationTabDao;
	
	@Override
	public Status save(LtMastCommunicationTab ltMastCommunicationTab) throws ServiceException {
	
		Status status = new Status();
		
		LtMastCommunicationTab communicationTab = ltMastCommunicationTabDao.getByVendorBuyer(ltMastCommunicationTab.getVendorId(),ltMastCommunicationTab.getCompanyId());
		
		if(communicationTab!=null) {
			ltMastCommunicationTab.setLastUpdateDate(new Date());
			ltMastCommunicationTab.setCommunicationId(communicationTab.getCommunicationId());
			communicationTab = ltMastCommunicationTabRepository.save(ltMastCommunicationTab);
			
		}else {
			ltMastCommunicationTab.setLastUpdateDate(new Date());
			communicationTab = ltMastCommunicationTabRepository.save(ltMastCommunicationTab);
		}
		
			LtMastCommunicationTabDet ltMastCommunicationTabDet = new LtMastCommunicationTabDet();
			ltMastCommunicationTabDet.setCommunicationId(communicationTab.getCommunicationId());
			ltMastCommunicationTabDet.setBuyerMsg(ltMastCommunicationTab.getBuyerMsg());
			ltMastCommunicationTabDet.setVendorMsg(ltMastCommunicationTab.getVendorMsg());
			ltMastCommunicationTabDet.setLastUpdateDate(ltMastCommunicationTab.getLastUpdateDate());
			ltMastCommunicationTabDet.setLastUpdatedBy(ltMastCommunicationTab.getLastUpdatedBy());
			
			ltMastCommunicationTabDetRepository.save(ltMastCommunicationTabDet);
			if(ltMastCommunicationTabDet.getMessageId()!=null)
			{
					status.setCode(SUCCESS);
					status.setMessage("Message sent successfully.");
					status.setData(communicationTab.getCommunicationId());
				
			}
			else
			{
					status.setCode(EXCEPTION);
					status.setMessage("Message sending failed.");
				
			}
		return status;
	}

	@Override
	public List<LtMastCommunicationTab> getAllCommunicationByComId(Long companyId) throws ServiceException {
		return ltMastCommunicationTabDao.getAllCommunicationByComId(companyId);
	}

	@Override
	public List<LtMastCommunicationTab> getallvendorcommunication(Long commId) throws ServiceException {
		return ltMastCommunicationTabDao.getallvendorcommunication(commId);
	}

	@Override
	public List<LtMastCommunicationTab> getAllBuyerCommunication(Long vendorId) throws ServiceException {
		return ltMastCommunicationTabDao.getAllBuyerCommunication(vendorId);
	}

	@Override
	public Status getCommunicationId(Long vendorId, Long companyId) throws ServiceException {
		Status status = new Status();
		LtMastCommunicationTab communicationTab = ltMastCommunicationTabDao.getByVendorBuyer(vendorId,companyId);
		if(communicationTab!=null) {
			status.setCode(SUCCESS);
			status.setData(communicationTab.getCommunicationId());
		}else {
			status.setCode(FAIL);
		}
		return status;
	}

	@Override
	public Status getVendorNotificationCount(Long buyerId) throws ServiceException {
		return ltMastCommunicationTabDao.getVendorNotificationCount(buyerId);
	}

	@Override
	public Status getBuuyerNotificationCount(Long buyerId) throws ServiceException {
		return ltMastCommunicationTabDao.getBuuyerNotificationCount(buyerId);
	}

	@Override
	public Status updateVendorNotification(Long buyerId) throws ServiceException {
		return ltMastCommunicationTabDao.updateVendorNotification(buyerId);
	}

	@Override
	public Status updateBuuyerNotification(Long buyerId, Long vendorId) throws ServiceException {
		return ltMastCommunicationTabDao.updateBuuyerNotification(buyerId,vendorId);
	}

	@Override
	public List<LtMastVendors> getLikeNameByBuyerId(String name, Long buyerId) throws ServiceException {
		return ltMastCommunicationTabDao.getLikeNameByBuyerId(name,buyerId);
	}

	@Override
	public List<LtMastVendors> getLikeNameByBuyerName(String name) throws ServiceException {
		return ltMastCommunicationTabDao.getLikeNameByBuyerName(name);
	}

	@Override
	public List<VendorBuyerDetails> getVendorMsgByBuyerId(Long buyerId) throws ServiceException {
		return ltMastCommunicationTabDao.getVendorMsgByBuyerId(buyerId);
	}

}
