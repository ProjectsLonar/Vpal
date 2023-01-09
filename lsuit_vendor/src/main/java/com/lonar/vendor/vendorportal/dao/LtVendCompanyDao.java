package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import com.lonar.vendor.vendorportal.model.LtVendCompany;

public interface LtVendCompanyDao 
{

	LtVendCompany getLtVendCompanyBycompanyId(Long companyId);

	List<LtVendCompany> getAllLtVendCompany();

	List<LtVendCompany> getLtVendCompanyLikecompanyName(String companyName);

	boolean delete(Long companyId);

	Long getCount(LtVendCompany input);

	List<LtVendCompany> getDatatableRecords(LtVendCompany input);

	boolean update(LtVendCompany ltMastCompany);

	LtVendCompany getByCompanyName(LtVendCompany ltMastCompany);

	LtVendCompany getByPanNumber(LtVendCompany ltMastCompany);

	LtVendCompany getByGstNumber(LtVendCompany ltMastCompany);

	boolean save(LtVendCompany ltVendCompany);

	

}
