package com.lonar.vendor.vendorportal.service;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lonar.vendor.vendorportal.dao.LtMastProductCategoriesDao;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.CustomeDataTable;
import com.lonar.vendor.vendorportal.model.LtMastProductCategories;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.repository.LtMastProductCategoriesRepository;

@Service
public class LtMastProductCategoriesServiceImpl implements LtMastProductCategoriesService, CodeMaster {
	
	static final Logger logger = Logger.getLogger(LtMastProductCategoriesServiceImpl.class);
	
	@Autowired
	LtMastProductCategoriesDao ltP2pProductCategoriesDao;
	
	@Autowired
	LtMastProductCategoriesRepository ltMastProductCategoriesRepository;
	
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	//@Autowired
	//LtP2pCategoryQuestionnaireRepository categoryQuestionnaireRepository;

	@Override
	public List<LtMastProductCategories> findByCategoryName(String categoryName,Long companyId) throws Exception{
		return ltP2pProductCategoriesDao.findByCategoryName(categoryName,companyId);
	}

	@Override
	public List<LtMastProductCategories> findAllActive(Long companyId) throws Exception{
		return ltP2pProductCategoriesDao.findAllActive(companyId);
	}

	@Override
	public List<LtMastProductCategories> findActiveLikeCategoryName(String categoryName,Long companyId) throws Exception{
		return ltP2pProductCategoriesDao.findActiveLikeCategoryName(categoryName,companyId);
	}

	@Override
	public List<LtMastProductCategories> findLikeCategoryName(String categoryName) throws Exception{
		return ltP2pProductCategoriesDao.findLikeCategoryName(categoryName);
	}

	@Override
	public List<LtMastProductCategories> findBycategoryCode(String categoryCode) throws Exception{
		return ltP2pProductCategoriesDao.findBycategoryCode(categoryCode);
	}

	@Override
	public Long getNextCodeSequence() throws Exception {
		// TODO Auto-generated method stub
		return ltP2pProductCategoriesDao.getNextCodeSequence();
	}

	@Override
	public CustomeDataTable categoryquestionnairedataTable(Long categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LtMastProductCategories> findAll() throws ServiceException {
		// TODO Auto-generated method stub
		return ltP2pProductCategoriesDao.findAll();
	}

	@Override
	public LtMastProductCategories getById(Long id) throws ServiceException {
		return ltP2pProductCategoriesDao.getById(id);
	}

	@Override
	public ResponseEntity<Status> save(LtMastProductCategories ltMastProductCategories) throws ServiceException 
	{
		Status status = new Status();
		
		List<LtMastProductCategories> ltMastProductCategoriesList=null;
		try {
			ltMastProductCategoriesList = ltP2pProductCategoriesDao.findActiveLikeCategoryName(ltMastProductCategories.getCategoryName(),
					ltMastProductCategories.getCompanyId());
						
		} catch (Exception e) {
			e.printStackTrace();
		}

		ltMastProductCategoriesList = ltP2pProductCategoriesDao.findActiveLikeCategoryCode(ltMastProductCategories.getCategoryCode(),
				ltMastProductCategories.getCompanyId());
		if (!ltMastProductCategoriesList.isEmpty() && 
				!ltMastProductCategoriesList.get(0).getCategoryId().equals(ltMastProductCategories.getCategoryId())) 
		{
			status.setCode(FAIL);
			status.setMessage("Category code already exists.");

			return new ResponseEntity<Status>(status, HttpStatus.OK);
		}
		
			if (!ltMastProductCategoriesList.isEmpty() && (ltMastProductCategories.getCategoryId() == null ? true
					: !ltMastProductCategories.getCategoryId()
							.equals(ltMastProductCategoriesList.get(0).getCategoryId()))) 
			{
				status.setCode(FAIL);
				status.setMessage("Category name already exists.");

				return new ResponseEntity<Status>(status, HttpStatus.OK);

			}
			
			
/*
			if (ltMastProductCategories.getCategoryId() == null) {
				Long nextSequence = ltMastProductCategoriesService.getNextCodeSequence();
				ltMastProductCategories.setCategoryCode(new CommonMethod().codeGenertor(
						LtMastProductCategories.getCategoryName().substring(0, 3).toUpperCase().replaceAll(" ", "_"),
						String.valueOf(nextSequence), "0", 8));
			}*/

			ltMastProductCategories.setLastUpdateDate(new Date());
			ltMastProductCategories.setCreationDate(new Date());
			ltMastProductCategories.setCreatedBy(ltMastProductCategories.getCreatedBy());
			ltMastProductCategories.setLastUpdatedBy(ltMastProductCategories.getLastUpdatedBy());
			ltMastProductCategories.setLastUpdateLogin(ltMastProductCategories.getLastUpdateLogin());
			ltMastProductCategories = ltMastProductCategoriesRepository.save(ltMastProductCategories);
			if(ltMastProductCategories.getCategoryId()!=null) {
				status=ltMastCommonMessageService.getCodeAndMessage(INSERT_SUCCESSFULLY);
				if(status.getMessage()==null) {
					status.setCode(SUCCESS);
					status.setMessage("Error in finding message! The action is completed successfully.");
				}
			
			status.setData(ltMastProductCategories.getCategoryId());
			return new ResponseEntity<Status>(status, HttpStatus.OK);
			
			}
			else {
				status=ltMastCommonMessageService.getCodeAndMessage(INSERT_FAIL);
				if(status.getMessage()==null) {
					status.setCode(FAIL);
					status.setMessage("Error in finding message! The action is completed unsuccessfully.");
				}
			}
		
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Status> update(LtMastProductCategories ltMastProductCategories) throws ServiceException {
		Status status = new Status();
		
		List<LtMastProductCategories> ltMastProductCategoriesList=null;
		try {
			ltMastProductCategoriesList = ltP2pProductCategoriesDao
						.findByCategoryName(ltMastProductCategories.getCategoryName(),ltMastProductCategories.getCompanyId());
		} catch (Exception e) {
			e.printStackTrace();
		}

			if (!ltMastProductCategoriesList.isEmpty() && (ltMastProductCategories.getCategoryId() == null ? true
					: !ltMastProductCategories.getCategoryId()
							.equals(ltMastProductCategoriesList.get(0).getCategoryId()))) 
			{
				status.setCode(FAIL);
				status.setMessage("Category name already exists.");

				return new ResponseEntity<Status>(status, HttpStatus.OK);

			}
			ltMastProductCategories.setLastUpdateDate(new Date());
			ltMastProductCategories.setLastUpdatedBy(ltMastProductCategories.getLastUpdatedBy());
			ltMastProductCategories.setLastUpdateLogin(ltMastProductCategories.getLastUpdateLogin());
			ltMastProductCategories = ltMastProductCategoriesRepository.save(ltMastProductCategories);
			if(ltMastProductCategories.getCategoryId()!=null) {
				status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_SUCCESSFULLY);
				if(status.getMessage()==null) {
					status.setCode(SUCCESS);
					status.setMessage("Error in finding message! The action is completed successfully.");
				}
			
			status.setData(ltMastProductCategories.getCategoryId());
			
			}
			else {
				status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_FAIL);
				if(status.getMessage()==null) {
					status.setCode(FAIL);
					status.setMessage("Error in finding message! The action is completed unsuccessfully.");
				}
			}
		
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Status> delete(Long id) throws ServiceException {
		Status status = new Status();
		try {
			if (ltMastProductCategoriesRepository.exists(id)) {
				ltMastProductCategoriesRepository.delete(id);
				status=ltMastCommonMessageService.getCodeAndMessage(DELETE_SUCCESSFULLY);
				if(status.getMessage()==null) {
					status.setCode(SUCCESS);
					status.setMessage("Error in finding message! The action is completed successfully.");
				}
			} 
			else {
			status=ltMastCommonMessageService.getCodeAndMessage(ENTITY_CANNOT_DELETE);
			if(status.getMessage()==null) {
				status.setCode(FAIL);
				status.setMessage("Error in finding message! The action is completed unsuccessfully.");
			}
			
		}
		}catch(Exception e) {
			status=ltMastCommonMessageService.getCodeAndMessage(ENTITY_CANNOT_DELETE);
			if(status.getMessage()==null) {
				status.setCode(FAIL);
				status.setMessage("Error in finding message! The action is completed unsuccessfully.");
			}
		}
			return new ResponseEntity<Status>(status, HttpStatus.OK);
		
	}

	@Override
	public Long getCount(LtMastProductCategories input,Long companyId) throws ServiceException {
				return ltP2pProductCategoriesDao.getCount(input,companyId);
	}

	@Override
	public List<LtMastProductCategories> getDataTable(LtMastProductCategories input,Long companyId) throws ServiceException {
		if(input.getColumnNo()==2 && input.getSort().equals("desc"))
		{ input.setColumnNo(12); }
		if(input.getColumnNo()==3 && input.getSort().equals("desc"))
		{ input.setColumnNo(13); }
		if(input.getColumnNo()==4 && input.getSort().equals("desc"))
		{ input.setColumnNo(14); }
		if(input.getColumnNo()==5 && input.getSort().equals("desc"))
		{ input.setColumnNo(15); }
		if(input.getColumnNo()==6 && input.getSort().equals("desc"))
		{ input.setColumnNo(16); }
		if(input.getColumnNo()==7 && input.getSort().equals("desc"))
		{ input.setColumnNo(17); }
		
		if(input.getColumnNo()==0 )
		{ input.setColumnNo(7); }
		List<LtMastProductCategories> list= ltP2pProductCategoriesDao.getDataTable(input,companyId);
		return list;
	}

	/*@Override
	public ResponseEntity<Status> saveCategoryQuestionnaire(LtP2pCategoryQuestionnaire categoryQuestionnaire) {
		Status status = new Status();
		try {
			
			if(categoryQuestionnaire.getCategoryQuestionId() != null){
				categoryQuestionnaire.setCreationDate(new Date());
				categoryQuestionnaire.setLastUpdateDate(new Date());
				categoryQuestionnaire.setCreatedBy(categoryQuestionnaire.getLastUpdatedBy());
			}else{
				categoryQuestionnaire.setCreationDate(new Date());
				categoryQuestionnaire.setLastUpdateDate(new Date());
				categoryQuestionnaire.setCreatedBy(categoryQuestionnaire.getLastUpdatedBy());
			}
			categoryQuestionnaireRepository.save(categoryQuestionnaire);
			status.setCode(INSERT_SUCCESSFULLY);
			status.setMessage("Data added successfully");
			return new ResponseEntity<Status>(status, HttpStatus.OK);
		} catch (Exception e) {
			status.setCode(INTERNAL_SERVER_ERROR);
			status.setMessage("Internal server error");
			logger.error("Error in  ", e);
			e.printStackTrace();
			return new ResponseEntity<Status>(status, HttpStatus.EXPECTATION_FAILED);
		}
	}

	@Override
	/*public ResponseEntity<Status> deleteCategoryQuestionnaireById(Long conditnTemplateId) {
		Status status = new Status();
		try {
			categoryQuestionnaireRepository.delete(conditnTemplateId);
			status.setCode(SUCCESSFULLY_DELETE);
			status.setMessage("Data deleted successfully");
			return new ResponseEntity<Status>(status, HttpStatus.OK);
		} catch (Exception e) {
			status.setCode(INTERNAL_SERVER_ERROR);
			status.setMessage("Internal server error");
			logger.error("Error in  ", e);
			e.printStackTrace();
			return new ResponseEntity<Status>(status, HttpStatus.EXPECTATION_FAILED);
		}
	}

	@Override
	public ResponseEntity<LtP2pCategoryQuestionnaire> getCategoryQuestionnaireById(Long conditnTemplateId) {
		LtP2pCategoryQuestionnaire categoryQuestionnaire = null;
		try {
			categoryQuestionnaire = ltP2pProductCategoriesDao.getConditionTemplateById(conditnTemplateId);
			return new ResponseEntity<LtP2pCategoryQuestionnaire>(categoryQuestionnaire, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error in /API/conditiontemplate/conditionTemplate/"+conditnTemplateId, e);
			e.printStackTrace();
			return new ResponseEntity<LtP2pCategoryQuestionnaire>(categoryQuestionnaire, HttpStatus.EXPECTATION_FAILED);
		}
	}

	@Override
	public CustomeDataTable categoryquestionnairedataTable(Long categoryId) {
		CustomeDataTable dataTable = new CustomeDataTable();
		try {
			Long count = ltP2pProductCategoriesDao.getCategoryQuestionnaireCount(categoryId);
			List<LtP2pCategoryQuestionnaire>  lines = ltP2pProductCategoriesDao.getCategoryQuestionnaireData(categoryId);
			dataTable.setData(lines );
			dataTable.setRecordsFiltered(count);
			dataTable.setRecordsTotal(count);
			return dataTable;
		} catch (Exception e) {
			logger.error("Error in /API/productcategories/categoryquestionnairedataTable", e);
			e.printStackTrace();
		}
		return dataTable;
	}*/

}
