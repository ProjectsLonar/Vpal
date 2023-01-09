package com.lonar.vendor.vendorportal.service;

import java.util.Date;
import java.util.List;

import com.lonar.vendor.vendorportal.dao.LtVendCompanyAttachmentsDao;
import com.lonar.vendor.vendorportal.dao.LtVendCompanyDao;
import com.lonar.vendor.vendorportal.model.LtCompanyVenMgmtAttachment;
import com.lonar.vendor.vendorportal.model.LtMastVendors;
import com.lonar.vendor.vendorportal.model.LtVendCompanyAttachments;
import com.lonar.vendor.vendorportal.repository.LtCompanyVenMgmtAttachmentRepository;

public class LtVendCompanyAttachmentsThread extends Thread{

	Long companyId;
	LtVendCompanyAttachmentsDao ltVendCompanyAttachmentsDao;
	LtCompanyVenMgmtAttachmentRepository ltCompanyVenMgmtAttachmentRepository;
	LtVendCompanyDao ltVendCompanyDao;
	public LtVendCompanyAttachmentsThread(Long companyId, LtVendCompanyAttachmentsDao ltVendCompanyAttachmentsDao,
			LtCompanyVenMgmtAttachmentRepository ltCompanyVenMgmtAttachmentRepository,LtVendCompanyDao ltVendCompanyDao) {
		this.companyId = companyId;
		this.ltVendCompanyAttachmentsDao = ltVendCompanyAttachmentsDao;
		this.ltCompanyVenMgmtAttachmentRepository = ltCompanyVenMgmtAttachmentRepository;
		this.ltVendCompanyDao = ltVendCompanyDao;
	}

	public void run() 
    { 
		try {
		List<LtVendCompanyAttachments> ltVendCompanyAttachments = ltVendCompanyAttachmentsDao.getBycompanyId(companyId);
		List<LtCompanyVenMgmtAttachment> list = ltVendCompanyAttachmentsDao.getCompanyVendAttachmentByCompanyId(companyId);
		if(!list.isEmpty()) {
			 
			for(LtCompanyVenMgmtAttachment ltCompanyVenMgmtAttachment : list) {
				
				Long vendorId = ltCompanyVenMgmtAttachment.getVendorId();
				String vendorStatus = ltVendCompanyDao.getVendorStatus(vendorId);
				if(!vendorStatus.equals("VENDOR_ACTIVE")) {
					
				//if(ltVendCompanyAttachmentsDao.deleteCompanyVendAttachmentByVendorCompanyId(companyId,vendorId)) {
					ltVendCompanyAttachmentsDao.deleteCompanyVendAttachmentByVendorCompanyId(companyId,vendorId);
					if(!ltVendCompanyAttachments.isEmpty()) {
						 
						ltVendCompanyAttachmentsDao.deleteVendorAttachment(companyId,vendorId);
					for(LtVendCompanyAttachments ltVendCompanyAttachment : ltVendCompanyAttachments) {
						 
						LtCompanyVenMgmtAttachment companyVenMgmtAttachment = new LtCompanyVenMgmtAttachment();
						companyVenMgmtAttachment.setCompAttachmentId(ltVendCompanyAttachment.getCompAttachmentId());
						companyVenMgmtAttachment.setCompanyId(companyId);
						companyVenMgmtAttachment.setVendorId(vendorId);
						companyVenMgmtAttachment.setIncludeVendor(ltVendCompanyAttachment.getIncludeVendor());
						companyVenMgmtAttachment.setMandatoryTab(ltVendCompanyAttachment.getMandatoryTab());
						companyVenMgmtAttachment.setAttachmentName(ltVendCompanyAttachment.getAttachmentName());
					//	companyVenMgmtAttachment.setAttachmentMandatory(ltVendCompanyAttachment.get);
						companyVenMgmtAttachment.setCreationDate(new Date());
						companyVenMgmtAttachment.setLastUpdateDate(new Date());
				
						ltCompanyVenMgmtAttachmentRepository.save(companyVenMgmtAttachment);
						//ltVendCompanyAttachmentsDao.deleteVendorAttachment(companyId,vendorId);
					  }
					}else {
						ltVendCompanyAttachmentsDao.deleteVendorAttachment(companyId,vendorId);
					}
					
				//}
				}else {
					 
					//1.get the different record from comapny whch is not in config
					List<LtVendCompanyAttachments> companyAttachmentList = ltVendCompanyAttachmentsDao.getDifference(companyId,vendorId);
					if(!companyAttachmentList.isEmpty()) {
						 
						for(LtVendCompanyAttachments companyAttachments : companyAttachmentList) {
							LtCompanyVenMgmtAttachment companyVenMgmtAttachment = new LtCompanyVenMgmtAttachment();
							companyVenMgmtAttachment.setCompAttachmentId(companyAttachments.getCompAttachmentId());
							companyVenMgmtAttachment.setCompanyId(companyId);
							companyVenMgmtAttachment.setVendorId(vendorId);
							companyVenMgmtAttachment.setIncludeVendor(companyAttachments.getIncludeVendor());
							companyVenMgmtAttachment.setMandatoryTab(companyAttachments.getMandatoryTab());
							companyVenMgmtAttachment.setAttachmentName(companyAttachments.getAttachmentName());
						//	companyVenMgmtAttachment.setAttachmentMandatory(ltVendCompanyAttachment.get);
							companyVenMgmtAttachment.setCreationDate(new Date());
							companyVenMgmtAttachment.setLastUpdateDate(new Date());
							
							ltCompanyVenMgmtAttachmentRepository.save(companyVenMgmtAttachment);
						}
					}
					/*List<LtCompanyVenMgmtAttachment> companyVenMgmtAttachment = 
							ltVendCompanyAttachmentsDao.getConfigDifference(companyId,vendorId);
					if(!companyVenMgmtAttachment.isEmpty()) {
							for(LtCompanyVenMgmtAttachment companyVenMgmtAttachmentObj : companyVenMgmtAttachment) {
								ltCompanyVenMgmtAttachmentRepository.delete(companyVenMgmtAttachmentObj.getCompanyVenAttachmentId());
							}
					}*/
					
				}//end of else
				
			}
		}else {
			 
			List<LtMastVendors> vendorList = ltVendCompanyAttachmentsDao.getVendorsByCompanyId(companyId);
			if(!ltVendCompanyAttachments.isEmpty()) {
				if(!vendorList.isEmpty()) {
					for(LtMastVendors ltMastVendors  : vendorList) {
						LtCompanyVenMgmtAttachment companyVenMgmtAttachment = new LtCompanyVenMgmtAttachment();
						//	companyVenMgmtAttachment.setCompAttachmentId(ltVendCompanyAttachment.getCompAttachmentId());
						companyVenMgmtAttachment.setCompanyId(companyId);
						companyVenMgmtAttachment.setVendorId(ltMastVendors.getVendorId());
						companyVenMgmtAttachment.setCompAttachmentId(ltVendCompanyAttachments.get(0).getCompAttachmentId());
						companyVenMgmtAttachment.setIncludeVendor(ltVendCompanyAttachments.get(0).getIncludeVendor());
						companyVenMgmtAttachment.setMandatoryTab(ltVendCompanyAttachments.get(0).getMandatoryTab());
						companyVenMgmtAttachment.setAttachmentName(ltVendCompanyAttachments.get(0).getAttachmentName());
						//	companyVenMgmtAttachment.setAttachmentMandatory(ltVendCompanyAttachment.get);
						companyVenMgmtAttachment.setCreationDate(new Date());
						companyVenMgmtAttachment.setLastUpdateDate(new Date());
			
						ltCompanyVenMgmtAttachmentRepository.save(companyVenMgmtAttachment);
					}
				}
			}
		}
    
    }catch(Exception e) {
    	e.printStackTrace();
    }
    }
}
