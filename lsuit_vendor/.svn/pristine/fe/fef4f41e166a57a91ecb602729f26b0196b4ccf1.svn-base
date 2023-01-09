package com.lonar.vendor.vendorportal.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.lonar.vendor.vendorportal.model.CustomeDataTable;
import com.lonar.vendor.vendorportal.model.LtMastProductCategories;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

public interface LtMastProductCategoriesService {

	public List<LtMastProductCategories> findByCategoryName(String categoryName) throws Exception;

	public List<LtMastProductCategories> findAllActive() throws Exception;

	public List<LtMastProductCategories> findActiveLikeCategoryName(String categoryName) throws Exception;

	public List<LtMastProductCategories> findLikeCategoryName(String categoryName) throws Exception;

	public List<LtMastProductCategories> findBycategoryCode(String categoryCode) throws Exception;

	public Long getNextCodeSequence() throws Exception;
	
	//ResponseEntity<Status> saveCategoryQuestionnaire(LtP2pCategoryQuestionnaire categoryQuestionnaire);
	
	//ResponseEntity<Status> deleteCategoryQuestionnaireById(Long conditnTemplateId);
	
	//ResponseEntity<LtP2pCategoryQuestionnaire> getCategoryQuestionnaireById(Long conditnTemplateId);
	
	CustomeDataTable categoryquestionnairedataTable(Long categoryId );

	public List<LtMastProductCategories> findAll() throws ServiceException;

	public LtMastProductCategories getById(Long id) throws ServiceException;

	public ResponseEntity<Status> save(LtMastProductCategories ltMastProductCategories) throws ServiceException;

	public ResponseEntity<Status> update(LtMastProductCategories ltMastProductCategories) throws ServiceException;

	public ResponseEntity<Status> delete(Long id) throws ServiceException;

	public Long getCount(LtMastProductCategories input) throws ServiceException;

	public List<LtMastProductCategories> getDataTable(LtMastProductCategories input) throws ServiceException;
}