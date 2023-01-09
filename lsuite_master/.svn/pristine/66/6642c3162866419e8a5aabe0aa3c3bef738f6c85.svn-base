package com.lonar.vendor.vendorportal.service;

import java.util.Date;
import java.util.List;

import com.lonar.vendor.vendorportal.dao.LtVendCompanyDao;
import com.lonar.vendor.vendorportal.dao.LtVendCompanyMiscellaneousDao;
import com.lonar.vendor.vendorportal.dao.LtVendMiscQuestionsDao;
import com.lonar.vendor.vendorportal.model.LtCompanyVenMgmtMisc;
import com.lonar.vendor.vendorportal.model.LtCompanyVenMgmtMiscQues;
import com.lonar.vendor.vendorportal.model.LtMastVendors;
import com.lonar.vendor.vendorportal.model.LtVendCompanyMiscellaneous;
import com.lonar.vendor.vendorportal.model.LtVendMiscQuestions;
import com.lonar.vendor.vendorportal.repository.LtCompanyVenMgmtMiscQuesRepository;
import com.lonar.vendor.vendorportal.repository.LtCompanyVenMgmtMiscRepository;

public class LtVendCompanyMiscellaneousThread extends Thread{

	public LtVendCompanyMiscellaneousDao ltVendCompanyMiscellaneousDao;
	public LtVendCompanyDao ltVendCompanyDao;
	public LtCompanyVenMgmtMiscRepository ltCompanyVenMgmtMiscRepository;
	public LtCompanyVenMgmtMiscQuesRepository ltCompanyVenMgmtMiscQuesRepository;
	public LtVendMiscQuestionsDao ltVendMiscQuestionsDao;
	public Long companyId = null ;
	
	
	public LtVendCompanyMiscellaneousThread(LtVendCompanyMiscellaneousDao ltVendCompanyMiscellaneousDao,
			LtVendCompanyDao ltVendCompanyDao, LtCompanyVenMgmtMiscRepository ltCompanyVenMgmtMiscRepository,
			LtCompanyVenMgmtMiscQuesRepository ltCompanyVenMgmtMiscQuesRepository,LtVendMiscQuestionsDao ltVendMiscQuestionsDao,
			Long companyId) {
		this.ltVendCompanyMiscellaneousDao = ltVendCompanyMiscellaneousDao;
		this.ltVendCompanyDao = ltVendCompanyDao;
		this.ltCompanyVenMgmtMiscRepository = ltCompanyVenMgmtMiscRepository;
		this.ltCompanyVenMgmtMiscQuesRepository = ltCompanyVenMgmtMiscQuesRepository;
		this.ltVendMiscQuestionsDao = ltVendMiscQuestionsDao;
		this.companyId = companyId;
	}
	
	public void run() 
    { 
		try {
		LtVendCompanyMiscellaneous ltVendCompanyMiscellaneous = ltVendCompanyMiscellaneousDao.getBycompanyId(companyId);
		List<LtCompanyVenMgmtMisc> list = ltVendCompanyMiscellaneousDao.getCompanyVenMiscellaneousBycompanyId(companyId);
		if(!list.isEmpty()) {
			for(LtCompanyVenMgmtMisc ltCompanyVenMgmtMisc : list ) {
				String vendorStatus = ltVendCompanyDao.getVendorStatus(ltCompanyVenMgmtMisc.getVendorId());
				if(!vendorStatus.equals("VENDOR_ACTIVE")) {
					if(ltVendCompanyMiscellaneous!=null) {
						ltCompanyVenMgmtMisc.setIncludeVendor(ltVendCompanyMiscellaneous.getIncludeVendor());
						ltCompanyVenMgmtMisc.setMandatoryTab(ltVendCompanyMiscellaneous.getMandatoryTab());
					}else {
						ltCompanyVenMgmtMisc.setIncludeVendor("N");
						ltCompanyVenMgmtMisc.setMandatoryTab("N");
						ltVendCompanyMiscellaneousDao.deleteMiscQuestions(companyId);
						ltVendMiscQuestionsDao.deleteCompanyQueByCompanyIdVendorId(companyId, ltCompanyVenMgmtMisc.getVendorId());
					}
					ltCompanyVenMgmtMisc.setLastUpdateDate(new Date());
					ltCompanyVenMgmtMiscRepository.save(ltCompanyVenMgmtMisc);
				}else {
					if(ltVendCompanyMiscellaneous!=null) {
						ltCompanyVenMgmtMisc.setIncludeVendor(ltVendCompanyMiscellaneous.getIncludeVendor());
						ltCompanyVenMgmtMisc.setMandatoryTab(ltVendCompanyMiscellaneous.getMandatoryTab());
						ltCompanyVenMgmtMisc.setLastUpdateDate(new Date());
						ltCompanyVenMgmtMisc.setCompMiscellaneousId(ltVendCompanyMiscellaneous.getCompMiscellaneousId());
						ltCompanyVenMgmtMisc = ltCompanyVenMgmtMiscRepository.save(ltCompanyVenMgmtMisc);
						if(ltCompanyVenMgmtMisc.getCompVenMgmtMiscId()!=null) {
							List<LtVendMiscQuestions> questionList = ltVendMiscQuestionsDao.getBycompanyMiscId(ltVendCompanyMiscellaneous.getCompMiscellaneousId());
							if(!questionList.isEmpty()) {
							
								for(LtVendMiscQuestions ltVendMiscQuestion : questionList) {
									LtCompanyVenMgmtMiscQues ltCompanyVenMgmtMiscQues = new LtCompanyVenMgmtMiscQues();
									ltCompanyVenMgmtMiscQues.setCompVenMgmtMiscId(ltCompanyVenMgmtMisc.getCompVenMgmtMiscId());
									ltCompanyVenMgmtMiscQues.setMiscQuestionId(ltVendMiscQuestion.getMiscQuestionId());
									ltCompanyVenMgmtMiscQues.setCompMiscellaneousId(ltVendMiscQuestion.getCompMiscellaneousId());
									ltCompanyVenMgmtMiscQues.setQuestion(ltVendMiscQuestion.getQuestion());
									ltCompanyVenMgmtMiscQues.setMandQuestionId(ltVendMiscQuestion.getMandQuestionId());
									ltCompanyVenMgmtMiscQues.setStartDate(ltVendMiscQuestion.getStartDate());
									ltCompanyVenMgmtMiscQues.setEndDate(ltVendMiscQuestion.getEndDate());
									ltCompanyVenMgmtMiscQues.setLastUpdateDate(new Date());
									ltCompanyVenMgmtMiscQues.setCreationDate(new Date());
								
									ltCompanyVenMgmtMiscQuesRepository.save(ltCompanyVenMgmtMiscQues);
								}
							}
						}
					}
				}
			}
		}else if(ltVendCompanyMiscellaneous.getIncludeVendor().equals("Y")){
			List<LtMastVendors> vendorList =ltVendCompanyDao.getAllActiveVendorsByCompany(companyId);
			for(LtMastVendors ltMastVendors : vendorList ) {
				LtCompanyVenMgmtMisc ltCompanyVenMgmtMisc = new LtCompanyVenMgmtMisc();
				ltCompanyVenMgmtMisc.setVendorId(ltMastVendors.getVendorId());
				ltCompanyVenMgmtMisc.setCompanyId(companyId);
				ltCompanyVenMgmtMisc.setIncludeVendor(ltVendCompanyMiscellaneous.getIncludeVendor());
				ltCompanyVenMgmtMisc.setMandatoryTab(ltVendCompanyMiscellaneous.getMandatoryTab());
				ltCompanyVenMgmtMisc.setStartDate(new Date());
				ltCompanyVenMgmtMisc.setLastUpdateDate(new Date());
				ltCompanyVenMgmtMisc.setCompMiscellaneousId(ltVendCompanyMiscellaneous.getCompMiscellaneousId());
				ltCompanyVenMgmtMisc = ltCompanyVenMgmtMiscRepository.save(ltCompanyVenMgmtMisc);
				if(ltCompanyVenMgmtMisc.getCompVenMgmtMiscId()!=null) {
					List<LtVendMiscQuestions> questionList = ltVendMiscQuestionsDao.getBycompanyMiscId(ltVendCompanyMiscellaneous.getCompMiscellaneousId());
					if(!questionList.isEmpty()) {
						
						for(LtVendMiscQuestions ltVendMiscQuestion : questionList) {
							LtCompanyVenMgmtMiscQues ltCompanyVenMgmtMiscQues = new LtCompanyVenMgmtMiscQues();
							ltCompanyVenMgmtMiscQues.setCompVenMgmtMiscId(ltCompanyVenMgmtMisc.getCompVenMgmtMiscId());
							ltCompanyVenMgmtMiscQues.setMiscQuestionId(ltVendMiscQuestion.getMiscQuestionId());
							ltCompanyVenMgmtMiscQues.setCompMiscellaneousId(ltVendMiscQuestion.getCompMiscellaneousId());
							ltCompanyVenMgmtMiscQues.setQuestion(ltVendMiscQuestion.getQuestion());
							ltCompanyVenMgmtMiscQues.setMandQuestionId(ltVendMiscQuestion.getMandQuestionId());
							ltCompanyVenMgmtMiscQues.setStartDate(ltVendMiscQuestion.getStartDate());
							ltCompanyVenMgmtMiscQues.setEndDate(ltVendMiscQuestion.getEndDate());
							ltCompanyVenMgmtMiscQues.setLastUpdateDate(new Date());
							ltCompanyVenMgmtMiscQues.setCreationDate(new Date());
							
							ltCompanyVenMgmtMiscQuesRepository.save(ltCompanyVenMgmtMiscQues);
						}
					}
				}
				
			}
			
		}
    }catch(Exception e) {
    	
    }
    
    }
}
