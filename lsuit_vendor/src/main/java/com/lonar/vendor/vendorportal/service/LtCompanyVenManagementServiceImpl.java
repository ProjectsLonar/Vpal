package com.lonar.vendor.vendorportal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lonar.vendor.vendorportal.dao.LtVendCompanyAttachmentsDao;
import com.lonar.vendor.vendorportal.dao.LtVendCompanyClientDetailsDao;
import com.lonar.vendor.vendorportal.dao.LtVendCompanyCocDao;
import com.lonar.vendor.vendorportal.dao.LtVendCompanyMgmtDdetailsDao;
import com.lonar.vendor.vendorportal.dao.LtVendCompanyMiscellaneousDao;
import com.lonar.vendor.vendorportal.dao.LtVendCompanySistConcernDao;
import com.lonar.vendor.vendorportal.model.CompanyMgmt;
import com.lonar.vendor.vendorportal.model.LtCompanyVenMgmtAttachment;
import com.lonar.vendor.vendorportal.model.LtCompanyVenMgmtCoc;
import com.lonar.vendor.vendorportal.model.LtCompanyVenMgmtInclude;
import com.lonar.vendor.vendorportal.model.LtCompanyVenMgmtMisc;
import com.lonar.vendor.vendorportal.model.LtCompanyVenMgmtMiscQues;
import com.lonar.vendor.vendorportal.model.LtVendCompanyAttachments;
import com.lonar.vendor.vendorportal.model.LtVendCompanyClientDetails;
import com.lonar.vendor.vendorportal.model.LtVendCompanyCoc;
import com.lonar.vendor.vendorportal.model.LtVendCompanyMgmtDdetails;
import com.lonar.vendor.vendorportal.model.LtVendCompanyMiscellaneous;
import com.lonar.vendor.vendorportal.model.LtVendCompanySistConcern;
import com.lonar.vendor.vendorportal.model.ServiceException;

@Service
public class LtCompanyVenManagementServiceImpl implements LtCompanyVenManagementService{

	@Autowired
	LtVendCompanyMiscellaneousDao ltVendCompanyMiscellaneousDao;
	
	@Autowired
	LtVendCompanyMgmtDdetailsDao ltVendCompanyMgmtDdetailsDao;
	
	@Autowired
	LtVendCompanyCocDao ltVendCompanyCocDao;
	
	@Autowired
	LtVendCompanyClientDetailsDao ltVendCompanyClientDetailsDao;
	
	@Autowired
	LtVendCompanyAttachmentsDao ltVendCompanyAttachmentsDao;
	
	@Autowired
	LtVendCompanySistConcernDao ltVendCompanySistConcernDao;
	
	@Override
	public ResponseEntity<List<CompanyMgmt>> getMasterMgmtBycompanyId(Long companyId,Long vendorId) throws ServiceException {
		List<CompanyMgmt> list = new ArrayList<>();
		
		LtCompanyVenMgmtMisc ltCompanyVenMgmtMisc =  ltVendCompanyMiscellaneousDao.getManagementBycompanyId(companyId,vendorId);
		if(ltCompanyVenMgmtMisc!=null) {
			CompanyMgmt companyMgmt = new CompanyMgmt();
		companyMgmt.setMasterName("LtVendCompanyMiscellaneous");
		companyMgmt.setIncludeVendor(ltCompanyVenMgmtMisc.getIncludeVendor());
		companyMgmt.setMandatoryTab(ltCompanyVenMgmtMisc.getMandatoryTab());
		list.add(companyMgmt);
		}
		List<LtCompanyVenMgmtInclude> l = ltVendCompanyMgmtDdetailsDao.getManagementBycompanyId(companyId,vendorId);
		if(!l.isEmpty()) {
			CompanyMgmt companyMgmt = new CompanyMgmt();
		companyMgmt.setMasterName("LtVendCompanyMgmtDdetails");
		companyMgmt.setIncludeVendor(l.get(0).getMgmtIncludeVendor());
		companyMgmt.setMandatoryTab(l.get(0).getMgmtMandatoryTab());
		list.add(companyMgmt);
		}
		List<LtCompanyVenMgmtCoc> l1 = ltVendCompanyCocDao.getManagementBycompanyId(companyId,vendorId);
		if(!l1.isEmpty()) {
			CompanyMgmt companyMgmt = new CompanyMgmt();
		companyMgmt.setMasterName("LtVendCompanyCoc");
		companyMgmt.setIncludeVendor(l1.get(0).getIncludeVendor());
		companyMgmt.setMandatoryTab(l1.get(0).getMandatoryTab());
		list.add(companyMgmt);
		}
		List<LtCompanyVenMgmtInclude> l2 = ltVendCompanyClientDetailsDao.getManagementBycompanyId(companyId,vendorId);
		if(!l2.isEmpty()) {
			CompanyMgmt companyMgmt = new CompanyMgmt(); 
		companyMgmt.setMasterName("LtVendCompanyClientDetails");
		companyMgmt.setIncludeVendor(l2.get(0).getClientIncludeVendor());
		companyMgmt.setMandatoryTab(l2.get(0).getClientMandatoryTab());
		list.add(companyMgmt);
		}
		List<LtCompanyVenMgmtAttachment> l3 = ltVendCompanyAttachmentsDao.getCompanyVenMgmtAttachmentByCompanyVendor(companyId,vendorId);
		if(!l3.isEmpty()) {
			CompanyMgmt companyMgmt = new CompanyMgmt(); 
		companyMgmt.setMasterName("LtVendCompanyAttachments");
		companyMgmt.setIncludeVendor(l3.get(0).getIncludeVendor());
		companyMgmt.setMandatoryTab(l3.get(0).getMandatoryTab());
		list.add(companyMgmt);
		}
		
		List<LtCompanyVenMgmtInclude> l4 = ltVendCompanySistConcernDao.getSistConcernBycompanyId(companyId,vendorId);
		if(!l4.isEmpty()) {
			CompanyMgmt companyMgmt = new CompanyMgmt(); 
		companyMgmt.setMasterName("LtVendCompanySistConcern");
		companyMgmt.setIncludeVendor(l4.get(0).getSistIncludeVendor());
		companyMgmt.setMandatoryTab(l4.get(0).getSistMandatoryTab());
		list.add(companyMgmt);
		}
		
		return new ResponseEntity<List<CompanyMgmt>>(list, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<LtCompanyVenMgmtAttachment>> getCompanyVenMgmtAttachmentByCompanyVendor(Long companyId,
			Long vendorId) throws ServiceException {
		List<LtCompanyVenMgmtAttachment> list = ltVendCompanyAttachmentsDao.getCompanyVenMgmtAttachmentByCompanyVendor(companyId,vendorId);
		return new ResponseEntity<List<LtCompanyVenMgmtAttachment>>(list, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<LtCompanyVenMgmtMiscQues>> getQuestionByCompanyVendor(Long companyId, Long vendorId)
			throws ServiceException {
		List<LtCompanyVenMgmtMiscQues> list = ltVendCompanyMiscellaneousDao.getQuestionByCompanyVendor(companyId,vendorId);
		return new ResponseEntity<List<LtCompanyVenMgmtMiscQues>>(list, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<CompanyMgmt>> getVendorMasterBycompanyId(Long companyId) throws ServiceException {
		List<CompanyMgmt> list = new ArrayList<>();

		LtVendCompanyMiscellaneous ltVendCompanyMiscellaneous =  ltVendCompanyMiscellaneousDao.getVendorMasterBycompanyId(companyId);
		if(ltVendCompanyMiscellaneous!=null) {
			CompanyMgmt companyMgmt = new CompanyMgmt();
		companyMgmt.setMasterName("LtVendCompanyMiscellaneous");
		companyMgmt.setIncludeVendor(ltVendCompanyMiscellaneous.getIncludeVendor());
		companyMgmt.setMandatoryTab(ltVendCompanyMiscellaneous.getMandatoryTab());
		list.add(companyMgmt);
		}
		List<LtVendCompanyMgmtDdetails> l = ltVendCompanyMgmtDdetailsDao.getBycompanyId(companyId);
		if(!l.isEmpty()) {
			CompanyMgmt companyMgmt = new CompanyMgmt();
		companyMgmt.setMasterName("LtVendCompanyMgmtDdetails");
		companyMgmt.setIncludeVendor(l.get(0).getIncludeVendor());
		companyMgmt.setMandatoryTab(l.get(0).getMandatoryTab());
		list.add(companyMgmt);
		}
		List<LtVendCompanyCoc> l1 = ltVendCompanyCocDao.getBycompanyId(companyId);
		if(!l1.isEmpty()) {
			CompanyMgmt companyMgmt = new CompanyMgmt();
		companyMgmt.setMasterName("LtVendCompanyCoc");
		companyMgmt.setIncludeVendor(l1.get(0).getIncludeVendor());
		companyMgmt.setMandatoryTab(l1.get(0).getMandatoryTab());
		list.add(companyMgmt);
		}
		List<LtVendCompanyClientDetails> l2 = ltVendCompanyClientDetailsDao.getBycompanyId(companyId);
		if(!l2.isEmpty()) {
			CompanyMgmt companyMgmt = new CompanyMgmt(); 
		companyMgmt.setMasterName("LtVendCompanyClientDetails");
		companyMgmt.setIncludeVendor(l2.get(0).getIncludeVendor());
		companyMgmt.setMandatoryTab(l2.get(0).getMandatoryTab());
		list.add(companyMgmt);
		}
		List<LtVendCompanyAttachments> l3 = ltVendCompanyAttachmentsDao.getBycompanyId(companyId);
		if(!l3.isEmpty()) {
			CompanyMgmt companyMgmt = new CompanyMgmt(); 
		companyMgmt.setMasterName("LtVendCompanyAttachments");
		companyMgmt.setIncludeVendor(l3.get(0).getIncludeVendor());
		companyMgmt.setMandatoryTab(l3.get(0).getMandatoryTab());
		list.add(companyMgmt);
		}
		
		List<LtVendCompanySistConcern> l4 = ltVendCompanySistConcernDao.getBycompanyId(companyId);
		if(!l4.isEmpty()) {
			CompanyMgmt companyMgmt = new CompanyMgmt(); 
		companyMgmt.setMasterName("LtVendCompanySistConcern");
		companyMgmt.setIncludeVendor(l4.get(0).getIncludeVendor());
		companyMgmt.setMandatoryTab(l4.get(0).getMandatoryTab());
		list.add(companyMgmt);
		}
		
		return new ResponseEntity<List<CompanyMgmt>>(list, HttpStatus.OK);
	}

}
