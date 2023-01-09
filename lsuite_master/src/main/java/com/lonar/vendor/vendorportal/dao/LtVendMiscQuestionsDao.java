package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import com.lonar.vendor.vendorportal.model.LtCompanyVenMgmtMisc;
import com.lonar.vendor.vendorportal.model.LtCompanyVenMgmtMiscQues;
import com.lonar.vendor.vendorportal.model.LtVendMiscQuestions;
import com.lonar.vendor.vendorportal.model.ServiceException;

public interface LtVendMiscQuestionsDao
{

	List<LtVendMiscQuestions> getBycompanyMiscId(Long companyMiscId) throws ServiceException;

	List<LtVendMiscQuestions> getAll() throws ServiceException;

	List<LtVendMiscQuestions> getAllActive() throws ServiceException;

	List<LtVendMiscQuestions> getById(Long id) throws ServiceException;

	List<LtVendMiscQuestions> getMiscQueBycompanyId(Long companyId) throws ServiceException;

	List<LtCompanyVenMgmtMiscQues> getLtCompanyVenMgmtMiscQuesByQueId(Long compMiscellaneousId) throws ServiceException;

	List<LtCompanyVenMgmtMisc> getLtCompanyVenMgmtMiscQuesBy(Long compVenMgmtMiscId) throws ServiceException;

	boolean deletecompanyVenMgmtMiscQue(Long compVenMgmtMiscId) throws ServiceException;

	List<LtVendMiscQuestions> getMiscQueBycompanyVendorId(Long companyId, Long vendorId) throws ServiceException;

	boolean deleteCompanyQueByCompanyId(Long companyId, Long miscQueId) throws ServiceException;

	List<LtCompanyVenMgmtMiscQues> getCompVenMgmtMiscQuesByParent(Long compVenMgmtMiscId) throws ServiceException;

	boolean deleteVendorQueByCompanyId(Long comId, Long miscQueId) throws ServiceException;

	List<LtVendMiscQuestions> getConfigDifference(Long companyId, Long vendorId) throws ServiceException;

	boolean deleteCompanyQueByCompanyIdVendorId(Long companyId, Long vendorId) throws ServiceException;

	

}
