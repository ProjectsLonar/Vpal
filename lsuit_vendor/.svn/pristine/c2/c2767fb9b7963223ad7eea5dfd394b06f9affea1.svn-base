package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import com.lonar.vendor.vendorportal.model.LtMastProductCategories;
import com.lonar.vendor.vendorportal.model.ServiceException;


public interface LtMastProductCategoriesDao {

	public List<LtMastProductCategories> findByCategoryName(String categoryName) throws Exception;

	public List<LtMastProductCategories> findAllActive() throws Exception;

	public List<LtMastProductCategories> findActiveLikeCategoryName(String categoryName) throws Exception;

	public List<LtMastProductCategories> findLikeCategoryName(String categoryName) throws Exception;

	public List<LtMastProductCategories> findBycategoryCode(String categoryCode) throws Exception;

	public Long getNextCodeSequence() throws Exception;

	public List<LtMastProductCategories> findAll() throws ServiceException;

	public LtMastProductCategories getById(Long id) throws ServiceException;

	public Long getCount(LtMastProductCategories input) throws ServiceException;

	public List<LtMastProductCategories> getDataTable(LtMastProductCategories input) throws ServiceException;
	
	//LtP2pCategoryQuestionnaire getConditionTemplateById(Long conditionTemplateId)throws Exception;
	
	//List<LtP2pCategoryQuestionnaire> getCategoryQuestionnaireData(Long categoryId)throws Exception;
	//Long getCategoryQuestionnaireCount(Long categoryId)throws Exception;
}
