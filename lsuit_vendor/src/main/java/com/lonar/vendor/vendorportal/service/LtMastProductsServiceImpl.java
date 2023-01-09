package com.lonar.vendor.vendorportal.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.lonar.vendor.vendorportal.dao.LtMastProductsDao;
import com.lonar.vendor.vendorportal.dao.LtMastSysVariablesDao;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtMastProductCategories;
import com.lonar.vendor.vendorportal.model.LtMastProducts;
import com.lonar.vendor.vendorportal.model.LtMastGroupProducts;
import com.lonar.vendor.vendorportal.model.LtMastProductDivisions;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.model.SysVariableWithValues;
import com.lonar.vendor.vendorportal.repository.LtMastProductDivisionsRepository;
import com.lonar.vendor.vendorportal.repository.LtMastProductsRepository;
import com.lonar.vendor.vendorportal.repository.LtMastGroupProductsRepository;

@Service
public class LtMastProductsServiceImpl implements LtMastProductsService,CodeMaster {
	@Autowired
	LtMastProductsDao ltP2pProductsDao;

	@Autowired
	LtMastSysVariablesDao ltMastSysVariablesDao;
	
	@Autowired
	LtMastProductsRepository ltP2pProductsRepository;
	
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	@Autowired
	LtMastSysVariablesService ltMastSysVariablesService;
	
	@Autowired
	LtMastGroupProductsRepository ltP2pGroupProductsRepository;
	
	@Autowired
	LtMastProductDivisionsRepository ltMastProductDivisionsRepository;
	
	@Override
	public List<LtMastProducts> findByProductCode(String productCode) throws Exception {
		return ltP2pProductsDao.findByProductCode(productCode);
	}

	@Override
	public List<LtMastProducts> findByProductName(String productName) throws Exception {
		return ltP2pProductsDao.findByProductName(productName);
	}

	@Override
	public List<LtMastProducts> findAllActive() throws ServiceException {
		return ltP2pProductsDao.findAllActive();
	}

	@Override
	public List<LtMastProducts> findByCategoryIdAndGlAccountId(Long categoryId, Long glaccountId) throws Exception {
		return ltP2pProductsDao.findByCategoryIdAndGlAccountId(categoryId, glaccountId);
	}

	@Override
	public List<LtMastProducts> findActiveLikeName(String productName) throws ServiceException {
		return ltP2pProductsDao.findActiveLikeName(productName);
	}

	@Override
	public List<LtMastProducts> findByGlAccountId(Long glAccountId) throws Exception {
		return ltP2pProductsDao.findByGlAccountId(glAccountId);
	}

	@Override
	public List<LtMastProducts> findActiveLikeProductNameWithCategoryId(String productName, long categoryId)
			throws Exception {
		return ltP2pProductsDao.findActiveLikeProductNameWithCategoryId(productName, categoryId);
	}

	@Override
	public List<LtMastProductCategories> findLikeProductCategoryLineType(String lineType, String categoryName)
			throws Exception {
		return ltP2pProductsDao.findLikeProductCategoryLineType(lineType, categoryName);
	}

	@Override
	public List<LtMastProducts> findLikeNameWithProductCategory(String productName, Long categoryId) throws Exception {
		return ltP2pProductsDao.findLikeNameWithProductCategory(productName, categoryId);
	}

	@Override
	public List<LtMastProducts> findBySubCategoryId(Long subCategoryId) throws Exception {
		return ltP2pProductsDao.findBySubCategoryId(subCategoryId);
	}

	@Override
	public Long getNextCodeSequence() throws Exception {
		return ltP2pProductsDao.getNextCodeSequence();
	}

	@Override
	public ResponseEntity<List<LtMastProducts>> getAll() throws ServiceException {
		return ltP2pProductsDao.getAll();
	}

	@Override
	public ResponseEntity<LtMastProducts> findOne(Long id) throws ServiceException {
		LtMastProducts ltMastProducts =  ltP2pProductsDao.findOne(id);
		String saveDirectory = null;
		List<SysVariableWithValues> sysVariableWithValuesList=
				ltMastSysVariablesDao.getBySysVariableName("FILE_OPEN_PATH",ltMastProducts.getCompanyId());
		
		if(sysVariableWithValuesList!=null)
		{
			if(sysVariableWithValuesList.get(0).getLtMastSysVariableValues().get(0)!=null)
			{
				saveDirectory=sysVariableWithValuesList.get(0).getLtMastSysVariableValues().get(0).getUserValue();
			}
			else
			{
				saveDirectory=sysVariableWithValuesList.get(0).getLtMastSysVariables().getSystemValue();
			}
		}
		String myFile = FilenameUtils.getBaseName(ltMastProducts.getProductImage())
            + "." + FilenameUtils.getExtension(ltMastProducts.getProductImage());
		ltMastProducts.setProductImage(myFile);
		ltMastProducts.setProductImagePath(saveDirectory+myFile);
		return new ResponseEntity<LtMastProducts>(ltMastProducts, HttpStatus.OK);
		
	}

	@Override
	public ResponseEntity<Status> save(LtMastProducts ltMastProducts, MultipartFile uploadfile)
			throws ServiceException
	{
		Status status = new Status();
		List<LtMastProducts> ltP2pProductsList = ltP2pProductsDao
				.findByProductName(ltMastProducts.getProductName());

		if (!ltP2pProductsList.isEmpty() && (ltMastProducts.getProductId() == null ? true
				: !ltMastProducts.getProductId().equals(ltP2pProductsList.get(0).getProductId()))) {
			status.setCode(FAIL);
			status.setMessage("Product name already exists.");
			return new ResponseEntity<Status>(status, HttpStatus.OK);

		}
		ltMastProducts.setCreationDate(new Date());
		ltMastProducts.setLastUpdateDate(new Date());
		ltMastProducts.setCreatedBy(ltMastProducts.getLastUpdateLogin());
		ltMastProducts.setLastUpdatedBy(ltMastProducts.getLastUpdateLogin());
		ltMastProducts = ltP2pProductsRepository.save(ltMastProducts);
		if(ltMastProducts.getProductId()!=null) {
			if(uploadfile!=null) {
			if(saveImage(ltMastProducts,uploadfile)) {
			status=ltMastCommonMessageService.getCodeAndMessage(INSERT_SUCCESSFULLY);
			if( status.getMessage()==null)
			{
				status.setCode(SUCCESS);
				status.setMessage("Error in finding message! The action is completed successfully.");
			}
			status.setData(ltMastProducts.getProductId());
		}else
		{
			status=ltMastCommonMessageService.getCodeAndMessage(INSERT_FAIL);
			return new ResponseEntity<Status>(status, HttpStatus.OK);
			
		}
		return new ResponseEntity<Status>(status, HttpStatus.OK);
		}else {
			status=ltMastCommonMessageService.getCodeAndMessage(INSERT_SUCCESSFULLY);
			if( status.getMessage()==null)
			{
				status.setCode(SUCCESS);
				status.setMessage("Error in finding message! The action is completed successfully.");
			}
			status.setData(ltMastProducts.getProductId());
			return new ResponseEntity<Status>(status, HttpStatus.OK);
		}
		}
		else {
			status=ltMastCommonMessageService.getCodeAndMessage(INSERT_FAIL);
			return new ResponseEntity<Status>(status, HttpStatus.OK);
		}
	}

	private boolean saveImage(LtMastProducts ltMastProducts, MultipartFile uploadfile) 
	{
		String saveDirectory =null;
		String fileExtentions = ".jpeg,.jpg,.png,.bmp,.pdf";
		String extension;
		try {
			SysVariableWithValues sysVariableWithValues=
					ltMastSysVariablesService.getBySysVariableName("FILE_UPLOAD_FOLDER_PATH",ltMastProducts.getCompanyId());
		
			if(sysVariableWithValues!=null)
			{
				if(sysVariableWithValues.getLtMastSysVariableValues().get(0)!=null)
				{
					saveDirectory=sysVariableWithValues.getLtMastSysVariableValues().get(0).getUserValue();
				}
				else
				{
					saveDirectory=sysVariableWithValues.getLtMastSysVariables().getSystemValue();
				}
			}
			File serverFile = new File( saveDirectory + "ProductImages/");
			if (!serverFile.isDirectory())
				serverFile.mkdir();
			byte[] bytes = uploadfile.getBytes();
			String[] fileFrags = uploadfile.getOriginalFilename().split("\\.");
			extension = fileFrags[fileFrags.length - 1];
			if (!fileExtentions.contains(extension)) {
				//fileUploadMsg = messageSource.getMessage("validfiletype", null, "Default", Locale.getDefault());
				return false;
			} 
			else 
			{
				serverFile = new File(new String(saveDirectory + "ProductImages/"
						 + uploadfile.getOriginalFilename()).replaceAll("amp;", ""));
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				ltMastProducts.setProductImage(new String(
						"/ProductImages/" + uploadfile.getOriginalFilename()).replaceAll("amp;", ""));
				LtMastProducts ltMastProducts1 = ltP2pProductsRepository.save(ltMastProducts);
				if(ltMastProducts1.getProductImage()!=null) {
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
		
	}

	@Override
	public ResponseEntity<Status> saveProductDivision(LtMastProductDivisions ltP2pProductDivisions)
			throws ServiceException {
		Status status = new Status();
		ltP2pProductDivisions.setCreationDate(new Date());
		ltP2pProductDivisions.setLastUpdateDate(new Date());
		ltP2pProductDivisions.setCreatedBy(ltP2pProductDivisions.getLastUpdateLogin());
		ltP2pProductDivisions.setLastUpdatedBy(ltP2pProductDivisions.getLastUpdateLogin());
		ltP2pProductDivisions = ltMastProductDivisionsRepository.save(ltP2pProductDivisions);
		if(ltP2pProductDivisions.getProductDivisionId()!=null) {
			
			status=ltMastCommonMessageService.getCodeAndMessage(INSERT_SUCCESSFULLY);
			if( status.getMessage()==null)
			{
				status.setCode(SUCCESS);
				status.setMessage("Error in finding message! The action is completed successfully.");
			}
			status.setData(ltP2pProductDivisions.getProductDivisionId());
		}else
		{
			status=ltMastCommonMessageService.getCodeAndMessage(INSERT_FAIL);
			return new ResponseEntity<Status>(status, HttpStatus.OK);
			
		}
		return new ResponseEntity<Status>(status, HttpStatus.OK);
		
		
	}

	@Override
	public ResponseEntity<Status> saveGroupProducts(LtMastGroupProducts ltP2pGroupProducts) throws ServiceException {
		Status status = new Status();
		ltP2pGroupProducts.setCreationDate(new Date());
		ltP2pGroupProducts.setLastUpdateDate(new Date());
		ltP2pGroupProducts.setCreatedBy(ltP2pGroupProducts.getLastUpdateLogin());
		ltP2pGroupProducts.setLastUpdatedBy(ltP2pGroupProducts.getLastUpdateLogin());
		ltP2pGroupProducts = ltP2pGroupProductsRepository.save(ltP2pGroupProducts);
		if(ltP2pGroupProducts.getGroupProductsId()!=null) {
			
			status=ltMastCommonMessageService.getCodeAndMessage(INSERT_SUCCESSFULLY);
			if( status.getMessage()==null)
			{
				status.setCode(SUCCESS);
				status.setMessage("Error in finding message! The action is completed successfully.");
			}
			status.setData(ltP2pGroupProducts.getGroupProductsId());
		}else
		{
			status=ltMastCommonMessageService.getCodeAndMessage(INSERT_FAIL);
			return new ResponseEntity<Status>(status, HttpStatus.OK);
			
		}
		return new ResponseEntity<Status>(status, HttpStatus.OK);
		
	}

	@Override
	public Long getCount(LtMastProducts input) throws ServiceException {
		return ltP2pProductsDao.getCount(input);
	}

	@Override
	public List<LtMastProducts> getDataTable(LtMastProducts input) throws ServiceException {
		if(input.getColumnNo()==1 && input.getSort().equals("desc"))
		{ input.setColumnNo(11); }
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
		if(input.getColumnNo()==0 )
		{ input.setColumnNo(7); }
		List<LtMastProducts> list= ltP2pProductsDao.getDataTable(input);
		return list;
	}

	@Override
	public ResponseEntity<Status> update(LtMastProducts ltMastProducts, MultipartFile multipartFile)
			throws ServiceException {
		Status status = new Status();
		List<LtMastProducts> ltP2pProductsList = ltP2pProductsDao
				.findByProductName(ltMastProducts.getProductName());

		if (!ltP2pProductsList.isEmpty() && (ltMastProducts.getProductId() == null ? true
				: !ltMastProducts.getProductId().equals(ltP2pProductsList.get(0).getProductId()))) {
			status.setCode(FAIL);
			status.setMessage("Product name already exists.");
			return new ResponseEntity<Status>(status, HttpStatus.OK);

		}
		ltMastProducts.setLastUpdateDate(new Date());
		ltMastProducts.setLastUpdatedBy(ltMastProducts.getLastUpdateLogin());
		ltMastProducts = ltP2pProductsRepository.save(ltMastProducts);
		if(ltMastProducts.getProductId()!=null) {
			if(multipartFile!=null) {
			if(saveImage(ltMastProducts,multipartFile)) {
			status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_SUCCESSFULLY);
			if( status.getMessage()==null)
			{
				status.setCode(SUCCESS);
				status.setMessage("Error in finding message! The action is completed successfully.");
			}
			status.setData(ltMastProducts.getProductId());
		}else
		{
			status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_FAIL);
			return new ResponseEntity<Status>(status, HttpStatus.OK);
			
		}
		return new ResponseEntity<Status>(status, HttpStatus.OK);
		}else {
			status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_SUCCESSFULLY);
			if( status.getMessage()==null)
			{
				status.setCode(SUCCESS);
				status.setMessage("Error in finding message! The action is completed successfully.");
			}
			status.setData(ltMastProducts.getProductId());
			return new ResponseEntity<Status>(status, HttpStatus.OK);
		}
		}
		else {
			status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_FAIL);
			return new ResponseEntity<Status>(status, HttpStatus.OK);
		}
	}

}
