package com.lonar.vendor.vendorportal.service;

import java.util.Date;
import java.util.List;

import org.springframework.core.env.Environment;

import com.lonar.vendor.vendorportal.dao.LtMastCommunicationTabDao;
import com.lonar.vendor.vendorportal.model.LtMastCommunicationTab;
import com.lonar.vendor.vendorportal.model.LtMastCommunicationTabDet;
import com.lonar.vendor.vendorportal.model.LtMastEmailtoken;
import com.lonar.vendor.vendorportal.model.LtMastVendors;
import com.lonar.vendor.vendorportal.model.SendBroadCastEmail;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.repository.LtMastCommunicationTabDetRepository;
import com.lonar.vendor.vendorportal.repository.LtMastCommunicationTabRepository;
import com.lonar.vendor.vendorportal.repository.LtMastEmailtokenRepository;

public class BroadcastMessageThread extends Thread {

 
	private LtMastEmailtokenRepository ltMastEmailtokenRepository;
 
	private LtMastCommunicationTabDao ltMastCommunicationTabDao;
 
	private LtMastCommunicationTabRepository ltMastCommunicationTabRepository;

	private LtMastCommunicationTabDetRepository ltMastCommunicationTabDetRepository;
	
	//@Autowired
	private Environment env;
	
	private List<LtMastVendors> vendorList;
	private SendBroadCastEmail emailList;

	public BroadcastMessageThread() {

	}

	public BroadcastMessageThread(List<LtMastVendors> vendorList, SendBroadCastEmail emailList,
			LtMastCommunicationTabDao ltMastCommunicationTabDao, LtMastCommunicationTabRepository ltMastCommunicationTabRepository,
			LtMastEmailtokenRepository ltMastEmailtokenRepository,
			LtMastCommunicationTabDetRepository ltMastCommunicationTabDetRepository,Environment env) {
		this.vendorList = vendorList;
		this.emailList = emailList;
		this.ltMastCommunicationTabDao=ltMastCommunicationTabDao;
		this.ltMastCommunicationTabRepository=ltMastCommunicationTabRepository;
		this.ltMastEmailtokenRepository=ltMastEmailtokenRepository;
		this.ltMastCommunicationTabDetRepository= ltMastCommunicationTabDetRepository;
		this.env = env;
	}

	public void run() {
		for (LtMastVendors ltMastVendors : vendorList) {
			if (emailList.getEmailFlag().equals("Y")) {
				LtMastEmailtoken ltMastEmailtoken = new LtMastEmailtoken();
				ltMastEmailtoken.setEmailStatus("SENDING");
				ltMastEmailtoken.setSendTo(ltMastVendors.getPrimaryEmail());
				ltMastEmailtoken.setEmailTemplate("mail");
				ltMastEmailtoken.setFailureCount(0L);
				ltMastEmailtoken.setEmailTitle(emailList.getSubject());
				ltMastEmailtoken.setEmailObject(
						"vendorName=" + emailList.getMessage() + "#$#$LoginURL=" + env.getProperty("LOGIN_URL"));

				ltMastEmailtoken.setExpiredWithin(1296000L);
				ltMastEmailtoken.setSendDate(new Date());
				ltMastEmailtoken.setAttachmentPath(emailList.getAttachmentPath());
				ltMastEmailtoken = ltMastEmailtokenRepository.save(ltMastEmailtoken);
			}

			/*
			 * LtMastCommunication ltMastCommunication = new LtMastCommunication();
			 * ltMastCommunication.setBuyerMsg(emailList.getMessage());
			 * ltMastCommunication.setCreationDate(new Date());
			 * ltMastCommunication.setCreatedBy(emailList.getLastUpdatedBy());
			 * ltMastCommunication.setBuyerId(emailList.getEmployeeId());
			 * ltMastCommunication.setVendorId(ltMastVendors.getVendorId());
			 * ltMastCommunicationRepository.save(ltMastCommunication);
			 */

			LtMastCommunicationTab communicationTab1 = null;
			try {
				communicationTab1 = ltMastCommunicationTabDao
						.getByVendorBuyer(ltMastVendors.getVendorId(), emailList.getCompanyId());
			} catch (ServiceException e) {
				e.printStackTrace();
			}
			if (communicationTab1 == null) {
				LtMastCommunicationTab communicationTab = new LtMastCommunicationTab();
				communicationTab.setBuyerMsg(emailList.getMessage());
				communicationTab.setLastUpdateDate(new Date());
				communicationTab.setCompanyId(emailList.getCompanyId());
				communicationTab.setLastUpdatedBy(emailList.getLastUpdatedBy());
				communicationTab.setBuyerId(emailList.getEmployeeId());
				communicationTab.setVendorId(ltMastVendors.getVendorId());
				communicationTab = ltMastCommunicationTabRepository.save(communicationTab);
				if (communicationTab.getCommunicationId() != null) {
					LtMastCommunicationTabDet ltMastCommunicationTabDet = new LtMastCommunicationTabDet();
					ltMastCommunicationTabDet.setCommunicationId(communicationTab.getCommunicationId());
					ltMastCommunicationTabDet.setBuyerMsg(emailList.getMessage());
					ltMastCommunicationTabDet.setLastUpdateDate(communicationTab.getLastUpdateDate());
					ltMastCommunicationTabDet.setLastUpdatedBy(emailList.getLastUpdatedBy());

					ltMastCommunicationTabDetRepository.save(ltMastCommunicationTabDet);
				}
			} else {
				communicationTab1.setLastUpdateDate(new Date());
				communicationTab1 = ltMastCommunicationTabRepository.save(communicationTab1);

				LtMastCommunicationTabDet ltMastCommunicationTabDet = new LtMastCommunicationTabDet();
				ltMastCommunicationTabDet.setCommunicationId(communicationTab1.getCommunicationId());
				ltMastCommunicationTabDet.setBuyerMsg(emailList.getMessage());
				ltMastCommunicationTabDet.setLastUpdateDate(communicationTab1.getLastUpdateDate());
				ltMastCommunicationTabDet.setLastUpdatedBy(emailList.getLastUpdatedBy());

				ltMastCommunicationTabDetRepository.save(ltMastCommunicationTabDet);
			}
		}
	}
}
