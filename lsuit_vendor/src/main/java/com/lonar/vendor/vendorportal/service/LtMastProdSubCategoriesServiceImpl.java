package com.lonar.vendor.vendorportal.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lonar.vendor.vendorportal.dao.LtMastProdSubCategoriesDao;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.CustomeDataTable;
import com.lonar.vendor.vendorportal.model.FilterTry;
import com.lonar.vendor.vendorportal.model.LtMastCostCenters;
import com.lonar.vendor.vendorportal.model.LtMastProdSubCategories;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.repository.LtMastProdSubCategoriesRepository;


@Service
public class LtMastProdSubCategoriesServiceImpl implements LtMastProdSubCategoriesService,CodeMaster
{

	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	@Autowired
	LtMastProdSubCategoriesDao ltP2pProdSubCategoriesDao;
	
	@Autowired
	LtMastProdSubCategoriesRepository  ltP2pProdSubCategoriesRepository;
	
	@Override
	public List<LtMastProdSubCategories> findAllActive() throws Exception {
		return null;
	}

	@Override
	public  LtMastProdSubCategories  findByCategoryId(Long id) throws Exception{   
			List<LtMastProdSubCategories> list = ltP2pProdSubCategoriesDao.findByCategoryId(id);
			if(list != null && list.size() > 0){
				return list.get(0);
			}
				return null;
	}

	@Override
	public List<LtMastProdSubCategories> getAll() throws Exception{
		return ltP2pProdSubCategoriesDao.getAll();
	}

	@Override
	public List<LtMastProdSubCategories> findBySubCategoryName(String name) throws Exception {
		return ltP2pProdSubCategoriesDao.findBySubCategoryName(name);
	}

	@Override
	public List<LtMastProdSubCategories> getByProdSubCategory(FilterTry filterOb) throws Exception{
		return ltP2pProdSubCategoriesDao.getByProdSubCategory(filterOb);
	}

	@Override
	public List<LtMastProdSubCategories> findLikeSubCategoryName(String name) throws Exception {
		return ltP2pProdSubCategoriesDao.findLikeSubCategoryName(name);
	}

	@Override
	public List<LtMastProdSubCategories> findActiveLikeSubCategoryName(String name) throws Exception{
		return ltP2pProdSubCategoriesDao.findActiveLikeSubCategoryName(name);
	}

	@Override
	public List<LtMastProdSubCategories> findActiveLikeSubCategoryNameWithCategoryId(String name, Long categoryId) throws ServiceException {
		return ltP2pProdSubCategoriesDao.findActiveLikeSubCategoryNameWithCategoryId(name, categoryId);
	}

	@Override
	public List<LtMastProdSubCategories> findCategoryId(Long categoryId) throws Exception {
		return ltP2pProdSubCategoriesDao.findCategoryId(categoryId);
	}

	@Override
	public CustomeDataTable getDataTabledetails(Long subprodCatId) throws Exception {
		Long count = (long) 0;
		//List<LtP2pProdSubcatPayterms> lines = null;
		CustomeDataTable dataTable = new CustomeDataTable();
		count = ltP2pProdSubCategoriesDao.getProdSubcatPaytermsDataTableCount(subprodCatId);
		//lines =  ltP2pProdSubCategoriesDao.getAllProdSubcatPayterms(subprodCatId);
		//dataTable.setData(lines );
		dataTable.setRecordsFiltered(count);
		dataTable.setRecordsTotal(count);
		return dataTable;
	}

	@Override
	public LtMastProdSubCategories findByPaytermId(Long id) throws Exception {
		return null;
	}

	@Override
	public ResponseEntity<Status> save(LtMastProdSubCategories ltMastProdSubCategories) throws ServiceException
	{
		Status status = new Status();
		
		
		if(ltMastProdSubCategories.getSubCategoryId()==null) {
			ltMastProdSubCategories.setCreatedBy(ltMastProdSubCategories.getCreatedBy());
			ltMastProdSubCategories.setCreationDate(new Date());
		}
		ltMastProdSubCategories.setLastUpdateLogin((ltMastProdSubCategories.getLastUpdateLogin()));
		
		ltMastProdSubCategories = ltP2pProdSubCategoriesRepository.save(ltMastProdSubCategories);
		if(ltMastProdSubCategories.getSubCategoryId()!=null) {
		status=ltMastCommonMessageService.getCodeAndMessage(INSERT_SUCCESSFULLY);
		if( status.getMessage()==null)
		{
			status.setCode(SUCCESS);
			status.setMessage("Error in finding message! The action is completed successfully.");
		}
		}else {
			status=ltMastCommonMessageService.getCodeAndMessage(INSERT_FAIL);
		}
		status.setData(ltMastProdSubCategories.getSubCategoryId());
		return new ResponseEntity<Status>(status, HttpStatus.OK);
		
	}

	@Override
	public ResponseEntity<Status> update(LtMastProdSubCategories ltMastProdSubCategories) throws ServiceException {
		Status status = new Status();
		
		if(ltMastProdSubCategories.getSubCategoryId()!=null) {
			
			ltMastProdSubCategories.setLastUpdatedBy(ltMastProdSubCategories.getLastUpdateLogin());
			ltMastProdSubCategories.setLastUpdateDate(new Date());
		ltMastProdSubCategories.setLastUpdateLogin((ltMastProdSubCategories.getLastUpdateLogin()));
		
		ltMastProdSubCategories = ltP2pProdSubCategoriesRepository.save(ltMastProdSubCategories);
		if(ltMastProdSubCategories.getSubCategoryId()!=null) {
		status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_SUCCESSFULLY);
		if( status.getMessage()==null)
		{
			status.setCode(SUCCESS);
			status.setMessage("Error in finding message! The action is completed successfully.");
		}
		}else {
			status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_FAIL);
		}
		
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}else
	{
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}
	}

	@Override
	public ResponseEntity<Status> delete(Long id) throws ServiceException {
		Status status = new Status();
		if (ltP2pProdSubCategoriesRepository.exists(id)) 
		{
			ltP2pProdSubCategoriesRepository.delete(id);
			status=ltMastCommonMessageService.getCodeAndMessage(DELETE_SUCCESSFULLY);
			if(status.getMessage()==null)
			{
				status.setCode(SUCCESS);
				status.setMessage("Error in finding message! The action is completed successfully.");
			}
							
		}
		else 
		{
				status=ltMastCommonMessageService.getCodeAndMessage(ENTITY_CANNOT_DELETE);
		}
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}

	@Override
	public Long getCount(LtMastProdSubCategories input) throws ServiceException {
		// TODO Auto-generated method stub
		return ltP2pProdSubCategoriesDao.getCount(input);
	}

	@Override
	public List<LtMastProdSubCategories> getDataTable(LtMastProdSubCategories input) throws ServiceException {
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
		if(input.getColumnNo()==8 && input.getSort().equals("asc"))
		{ input.setColumnNo(18); }
		List<LtMastProdSubCategories> list= ltP2pProdSubCategoriesDao.getDataTable(input);
		return list;
	}

	@Override
	public List<LtMastProdSubCategories> getLikeSubCategoryNameAndCategory(String trim, String id)
			throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

}
