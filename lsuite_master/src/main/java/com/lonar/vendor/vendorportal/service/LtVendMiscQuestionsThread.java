package com.lonar.vendor.vendorportal.service;

import java.util.Date;
import java.util.List;

import com.lonar.vendor.vendorportal.dao.LtVendCompanyDao;
import com.lonar.vendor.vendorportal.dao.LtVendCompanyMiscellaneousDao;
import com.lonar.vendor.vendorportal.dao.LtVendMiscQuestionsDao;
import com.lonar.vendor.vendorportal.model.LtCompanyVenMgmtMisc;
import com.lonar.vendor.vendorportal.model.LtCompanyVenMgmtMiscQues;
import com.lonar.vendor.vendorportal.model.LtVendCompanyMiscellaneous;
import com.lonar.vendor.vendorportal.model.LtVendMiscQuestions;
import com.lonar.vendor.vendorportal.repository.LtCompanyVenMgmtMiscQuesRepository;

public class LtVendMiscQuestionsThread extends Thread{

	public Long miscQuestionId;
	public LtVendMiscQuestions ltVendMiscQuestions;
	public LtVendCompanyMiscellaneousDao ltVendCompanyMiscellaneousDao;
	public LtVendMiscQuestionsDao ltVendMiscQuestionsDao;
	public LtCompanyVenMgmtMiscQuesRepository ltCompanyVenMgmtMiscQuesRepository;
	public LtVendCompanyDao ltVendCompanyDao;
	
	public LtVendMiscQuestionsThread(Long miscQuestionId, LtVendMiscQuestions ltVendMiscQuestions,
			LtVendCompanyMiscellaneousDao ltVendCompanyMiscellaneousDao, LtVendMiscQuestionsDao ltVendMiscQuestionsDao,
			LtCompanyVenMgmtMiscQuesRepository ltCompanyVenMgmtMiscQuesRepository,LtVendCompanyDao ltVendCompanyDao) {
		this.miscQuestionId = miscQuestionId;
		this.ltVendMiscQuestions = ltVendMiscQuestions;
		this.ltVendCompanyMiscellaneousDao = ltVendCompanyMiscellaneousDao;
		this.ltVendMiscQuestionsDao = ltVendMiscQuestionsDao;
		this.ltCompanyVenMgmtMiscQuesRepository = ltCompanyVenMgmtMiscQuesRepository;
		this.ltVendCompanyDao = ltVendCompanyDao;
	}

	public void run() 
    { 
		try {
		
			LtVendCompanyMiscellaneous ltVendCompanyMiscellaneous = ltVendCompanyMiscellaneousDao.getById(ltVendMiscQuestions.getCompMiscellaneousId());
			if(ltVendCompanyMiscellaneous!=null) {
				List<LtCompanyVenMgmtMisc> list = ltVendCompanyMiscellaneousDao.getCompanyVenMiscellaneousBycompanyId(ltVendCompanyMiscellaneous.getCompanyId());
				if(!list.isEmpty()) {
					for(LtCompanyVenMgmtMisc ltCompanyVenMgmtMisc : list) {
						String vendorStatus = ltVendCompanyDao.getVendorStatus(ltCompanyVenMgmtMisc.getVendorId());
						if(!vendorStatus.equals("VENDOR_ACTIVE")) {
							//if(ltVendMiscQuestionsDao.deletecompanyVenMgmtMiscQue(ltCompanyVenMgmtMisc.getCompVenMgmtMiscId())) 
							{
								 
								ltVendMiscQuestionsDao.deletecompanyVenMgmtMiscQue(ltCompanyVenMgmtMisc.getCompVenMgmtMiscId());
								
								 
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
						
						}else {
							List<LtVendMiscQuestions> ltVendMiscQuestionsList = 
									ltVendMiscQuestionsDao.getConfigDifference(ltCompanyVenMgmtMisc.getCompanyId(),ltCompanyVenMgmtMisc.getVendorId());
							if(!ltVendMiscQuestionsList.isEmpty()) {
								
								for(LtVendMiscQuestions ltVendMiscQuestion : ltVendMiscQuestionsList) {
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
    
    }catch(Exception e) {
    	e.printStackTrace();
    }
    }
}
