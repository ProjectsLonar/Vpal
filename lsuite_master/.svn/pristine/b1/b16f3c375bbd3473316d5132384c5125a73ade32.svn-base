package com.lonar.vendor.vendorportal.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lonar.vendor.vendorportal.dao.LtVendCompanyDao;
import com.lonar.vendor.vendorportal.dao.LtVendCompanyMiscellaneousDao;
import com.lonar.vendor.vendorportal.dao.LtVendMiscQuestionsDao;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtCompanyVenMgmtMisc;
import com.lonar.vendor.vendorportal.model.LtCompanyVenMgmtMiscQues;
import com.lonar.vendor.vendorportal.model.LtVendCompanyMiscellaneous;
import com.lonar.vendor.vendorportal.model.LtVendMiscQuestions;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.repository.LtCompanyVenMgmtMiscQuesRepository;
import com.lonar.vendor.vendorportal.repository.LtVendCompanyMiscellaneousRepository;
import com.lonar.vendor.vendorportal.repository.LtVendMiscQuestionsRepository;

@Service
public class LtVendMiscQuestionsServiceImpl implements LtVendMiscQuestionsService , CodeMaster{

	@Autowired
	LtVendCompanyDao ltVendCompanyDao;
	
	@Autowired
	LtVendMiscQuestionsDao ltVendMiscQuestionsDao;
	
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	@Autowired
	LtVendMiscQuestionsRepository  ltVendMiscQuestionsRepository;
	
	@Autowired
	LtVendCompanyMiscellaneousDao ltVendCompanyMiscellaneousDao;
	
	@Autowired
	LtCompanyVenMgmtMiscQuesRepository ltCompanyVenMgmtMiscQuesRepository;
	
	@Autowired
	LtVendCompanyMiscellaneousRepository ltVendCompanyMiscellaneousRepository;
	
	@Override
	public List<LtVendMiscQuestions> getBycompanyMiscId(Long companyMiscId) throws ServiceException {
		return ltVendMiscQuestionsDao.getBycompanyMiscId(companyMiscId);
	}

	@Override
	public List<LtVendMiscQuestions> getById(Long id) throws ServiceException {
		return ltVendMiscQuestionsDao.getById(id);
	}
	
	@Override
	public List<LtVendMiscQuestions> getAll() throws ServiceException {
		return ltVendMiscQuestionsDao.getAll();
	}

	@Override
	public List<LtVendMiscQuestions> getAllActive() throws ServiceException {
		return ltVendMiscQuestionsDao.getAllActive();
	}

	@Override
	public ResponseEntity<Status> save(LtVendMiscQuestions ltVendMiscQuestions) throws ServiceException {
		Status status = new Status();
		if(ltVendMiscQuestions.getStartDate()==null || ltVendMiscQuestions.getLastUpdateLogin() == null )
		{
			status=ltMastCommonMessageService.getCodeAndMessage(INPUT_IS_EMPTY);
			if( status.getMessage()==null) {
				status.setCode(EXCEPTION);
				status.setMessage("Error in finding message! The action is completed unsuccessfully.");
			}
		}
		ltVendMiscQuestions.setCreationDate(new Date());
		ltVendMiscQuestions.setLastUpdateDate(new Date());
		ltVendMiscQuestions.setCreatedBy(ltVendMiscQuestions.getLastUpdateLogin());
		ltVendMiscQuestions.setLastUpdateLogin(ltVendMiscQuestions.getLastUpdateLogin());
		ltVendMiscQuestions.setLastUpdatedBy(ltVendMiscQuestions.getLastUpdateLogin()); 
		ltVendMiscQuestions = ltVendMiscQuestionsRepository.save(ltVendMiscQuestions);
			if(ltVendMiscQuestions.getMiscQuestionId()!=null)
			{
				LtVendMiscQuestionsThread vendMiscQuestionsThread =
						new LtVendMiscQuestionsThread(ltVendMiscQuestions.getMiscQuestionId(),ltVendMiscQuestions,
								ltVendCompanyMiscellaneousDao,ltVendMiscQuestionsDao,ltCompanyVenMgmtMiscQuesRepository,ltVendCompanyDao);
				Thread t1 =new Thread(vendMiscQuestionsThread);  
				t1.start();
				
				
				//updateCompanyVenMiscQuestion(ltVendMiscQuestions.getMiscQuestionId(),ltVendMiscQuestions);
				status=ltMastCommonMessageService.getCodeAndMessage(INSERT_SUCCESSFULLY);
				if( status.getMessage()==null) {
					status.setCode(SUCCESS);
					status.setMessage("Error in finding message! The action is completed successfully.");
				}
			}
			else
			{
				status=ltMastCommonMessageService.getCodeAndMessage(INSERT_FAIL);
				if( status.getMessage()==null) {
					status.setCode(EXCEPTION);
					status.setMessage("Error in finding message! The action is completed unsuccessfully.");
				}
			}
		    return new ResponseEntity<Status>(status, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Status> update(LtVendMiscQuestions ltVendMiscQuestions) throws ServiceException {
		Status status = new Status();
		if(ltVendMiscQuestions.getMiscQuestionId()!=null) {
		
			ltVendMiscQuestions.setLastUpdateDate(new Date());
			ltVendMiscQuestions.setLastUpdateLogin(ltVendMiscQuestions.getLastUpdateLogin());
			ltVendMiscQuestions.setLastUpdatedBy(ltVendMiscQuestions.getLastUpdateLogin()); 
			ltVendMiscQuestions = ltVendMiscQuestionsRepository.save(ltVendMiscQuestions);
			if(ltVendMiscQuestions.getMiscQuestionId()!=null)
			{
				LtVendMiscQuestionsThread vendMiscQuestionsThread =
						new LtVendMiscQuestionsThread(ltVendMiscQuestions.getMiscQuestionId(),ltVendMiscQuestions,
								ltVendCompanyMiscellaneousDao,ltVendMiscQuestionsDao,ltCompanyVenMgmtMiscQuesRepository,ltVendCompanyDao);
				Thread t1 =new Thread(vendMiscQuestionsThread);  
				t1.start();
				//updateCompanyVenMiscQuestion(ltVendMiscQuestions.getMiscQuestionId(),ltVendMiscQuestions);
				status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_SUCCESSFULLY);
				if( status.getMessage()==null) {
					status.setCode(SUCCESS);
					status.setMessage("Error in finding message! The action is completed successfully.");
				}
			}
			else
			{
				status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_FAIL);
				if( status.getMessage()==null) {
					status.setCode(EXCEPTION);
					status.setMessage("Error in finding message! The action is completed unsuccessfully.");
				}
			}
		}else {
			status=ltMastCommonMessageService.getCodeAndMessage(INPUT_IS_EMPTY);
			if( status.getMessage()==null) {
				status.setCode(EXCEPTION);
				status.setMessage("Error in finding message! The action is completed unsuccessfully.");
			}
		}
		    return new ResponseEntity<Status>(status, HttpStatus.OK);
	}

	private void updateCompanyVenMiscQuestion(Long getMiscQuestionId, LtVendMiscQuestions ltVendMiscQuestions) throws ServiceException {
			
		LtVendCompanyMiscellaneous ltVendCompanyMiscellaneous = ltVendCompanyMiscellaneousDao.getById(ltVendMiscQuestions.getCompMiscellaneousId());
			if(ltVendCompanyMiscellaneous!=null) {
				List<LtCompanyVenMgmtMisc> list = ltVendCompanyMiscellaneousDao.getCompanyVenMiscellaneousBycompanyId(ltVendCompanyMiscellaneous.getCompanyId());
				if(!list.isEmpty()) {
					for(LtCompanyVenMgmtMisc ltCompanyVenMgmtMisc : list) {
						List<LtCompanyVenMgmtMisc> companyVenMgmtMiscQue = 
								ltVendMiscQuestionsDao.getLtCompanyVenMgmtMiscQuesBy(ltCompanyVenMgmtMisc.getCompVenMgmtMiscId());
						if(companyVenMgmtMiscQue!=null) {
							if(ltVendMiscQuestionsDao.deletecompanyVenMgmtMiscQue(ltCompanyVenMgmtMisc.getCompVenMgmtMiscId())) 
							{
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
			
			
			}
		
		
	}

	@Override
	public ResponseEntity<Status> delete(Long miscQueId,Long comId) throws ServiceException {
		Status status = new Status();
		ltVendMiscQuestionsDao.deleteCompanyQueByCompanyId(comId,miscQueId);
		ltVendMiscQuestionsDao.deleteVendorQueByCompanyId(comId,miscQueId);
		if(ltVendMiscQuestionsRepository.exists(miscQueId)) {
			ltVendMiscQuestionsRepository.delete(miscQueId);
		}
		if (!ltVendMiscQuestionsRepository.exists(miscQueId))
		{
			status=ltMastCommonMessageService.getCodeAndMessage(DELETE_SUCCESSFULLY);
		} 
		else 
		{
			status=ltMastCommonMessageService.getCodeAndMessage(ENTITY_CANNOT_DELETE);
		}
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}

	@Override
	public List<LtVendMiscQuestions> getMiscQueBycompanyId(Long companyId) throws ServiceException {
		return ltVendMiscQuestionsDao.getMiscQueBycompanyId(companyId);
	}

	@Override
	public List<LtVendMiscQuestions> getMiscQueBycompanyVendorId(Long companyId, Long vendorId)
			throws ServiceException {
		return ltVendMiscQuestionsDao.getMiscQueBycompanyVendorId(companyId,vendorId);
	}

	

}
