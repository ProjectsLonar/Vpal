package com.lonar.vendor.vendorportal.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.lonar.vendor.vendorportal.model.CompanyMgmt;
import com.lonar.vendor.vendorportal.model.LtCompanyVenMgmtAttachment;
import com.lonar.vendor.vendorportal.model.LtCompanyVenMgmtMiscQues;
import com.lonar.vendor.vendorportal.model.ServiceException;

public interface LtCompanyVenManagementService {

	ResponseEntity<List<CompanyMgmt>> getMasterMgmtBycompanyId(Long companyId, Long vendorId) throws ServiceException;

	ResponseEntity<List<LtCompanyVenMgmtAttachment>> getCompanyVenMgmtAttachmentByCompanyVendor(Long companyId,
			Long vendorId) throws ServiceException;

	ResponseEntity<List<LtCompanyVenMgmtMiscQues>> getQuestionByCompanyVendor(Long companyId, Long vendorId) throws ServiceException;

	ResponseEntity<List<CompanyMgmt>> getVendorMasterBycompanyId(Long companyId) throws ServiceException;

}
