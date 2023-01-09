package com.lonar.vendor.vendorportal.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.lonar.vendor.vendorportal.model.LtVendCompanyMgmtDdetails;
import com.lonar.vendor.vendorportal.model.Status;

public interface LtVendCompanyMgmtDdetailsService 
{

	List<LtVendCompanyMgmtDdetails> getBycompanyId(Long companyId);

	LtVendCompanyMgmtDdetails getById(Long id);

	List<LtVendCompanyMgmtDdetails> getAll();

	List<LtVendCompanyMgmtDdetails> getAllActive();

	ResponseEntity<Status> save(LtVendCompanyMgmtDdetails ltVendCompanyMgmtDdetails);

	ResponseEntity<Status> update(LtVendCompanyMgmtDdetails ltVendCompanyMgmtDdetails);

	ResponseEntity<Status> delete(Long parseLong);

}
