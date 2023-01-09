package com.lonar.vendor.vendorportal.service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.jdo.annotations.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.lonar.vendor.vendorportal.dao.LtMastBranchesDao;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtMastBranches;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.repository.LtMastBranchesRepository;


@Service
public class LtMastBranchesServiceImpl implements LtMastBranchesService,CodeMaster {
	@Autowired
	LtMastBranchesDao ltMastBranchesDao;
	
	//@Autowired
	//LtMastEmployeesDao ltMastEmployeesDao;

	@Autowired
	private MessageSource messageSource;
	
	
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	@Autowired
	LtMastBranchesRepository ltMastBranchesRepository;

	@Transactional
	@Override
	public List<LtMastBranches> findByBranchCode(String branchCode) throws ServiceException {
		return  ltMastBranchesDao.findByBranchCode(branchCode);
	}

	@Transactional
	@Override
	public List<LtMastBranches> findByBranchName(String branchName) throws ServiceException {
		return  ltMastBranchesDao.findByBranchName(branchName);
	}

	@Transactional
	@Override
	public List<LtMastBranches> findAllActive() throws ServiceException {
		List<LtMastBranches> ltMastBranches = null;
		
			ltMastBranches =ltMastBranchesDao.findAllActive();
			
		return ltMastBranches;
		
	}

	@Transactional
	@Override
	public List<LtMastBranches> findActiveLikeBranchName(String branchName) throws ServiceException
	{
		List<LtMastBranches> ltMastBranches = ltMastBranchesDao.findActiveLikeBranchName(branchName);
		
		for (LtMastBranches ltMastBranches2 : ltMastBranches)
		{
			LtMastBranches ltMastBranchesReporting = new LtMastBranches();
			if (ltMastBranches2.getReportingBranch() != null)
			{
				
				ltMastBranchesReporting = ltMastBranchesDao.getLtMastBranchesByID(ltMastBranches2.getReportingBranch());
				if (ltMastBranchesReporting != null)
				{
					ltMastBranches2.setReportingBranchName(ltMastBranchesReporting.getBranchName()+
							" ( "+ltMastBranchesReporting.getBranchCode()+" )");			
				} 
			}
			
		}
		
		return ltMastBranches;
	
	}

	@Transactional
	@Override
	public String isFeildsExists(LtMastBranches ltMastBranches) throws ServiceException {
		// TODO Auto-generated method stub
		String status = null;
		{
			List<LtMastBranches> branchList = ltMastBranchesDao.isFeildsExists(ltMastBranches);
			for (LtMastBranches branch : branchList) 
			{
				
				if (ltMastBranches.getBranchCode() == null
						|| ltMastBranches.getBranchCode().equals(branch.getBranchCode()))
				{
					/*if (ltMastBranches.getBranchId() != branch.getBranchId())
						status = messageSource.getMessage("Location code already exists", null,
								"Location code already exists", Locale.getDefault());
					else*/
						return status;
				}
				else if(ltMastBranches.getBranchName().equals(branch.getBranchName()))
				{
					if (ltMastBranches.getBranchId() != branch.getBranchId())
						status = messageSource.getMessage("Location Name already exists", null,
								"Location Name is already Exists", Locale.getDefault());
						else return status;
					
				}
				else if ( ltMastBranches.getGstRegNo().equals(branch.getGstRegNo())) 
				{
					if (ltMastBranches.getBranchId() != branch.getBranchId())
					status = messageSource.getMessage("Gst number is already Exists", null,
							"Gst Number is already Exists", Locale.getDefault());
					else return status;
				}
			}
		}
		return status;
	}
	
	@Transactional
	@Override
	public String isGstExists(LtMastBranches ltMastBranches) throws ServiceException {
		// TODO Auto-generated method stub
		String status = null;
		{
			List<LtMastBranches> branchList = ltMastBranchesDao.updateBranch(ltMastBranches);
			
			for (LtMastBranches branch : branchList) {
				
				
				 if ((ltMastBranches.getGstRegNo() == null
						|| ltMastBranches.getGstRegNo().equals(branch.getGstRegNo()))
						|| ltMastBranches.getBranchCode().equals(branch.getBranchCode())) {
					status = messageSource.getMessage("Gst number is already Exists", null,
							"Gst Number is already Exists", Locale.getDefault());
				}
			}
		}
		return status;
	}

	@Transactional
	@Override
	public List<LtMastBranches> updateBranches(LtMastBranches ltMastBranches) throws ServiceException {
		// TODO Auto-generated method stub
		return ltMastBranchesDao.isFeildsExists(ltMastBranches);
	}

	@Transactional
	@Override
	public List<LtMastBranches> checkAlreadyUsed(LtMastBranches ltMastBranch) throws ServiceException {
		// TODO Auto-generated method stub
		return ltMastBranchesDao.checkAlreadyUsed(ltMastBranch);
	}

	@Transactional
	@Override
	public List<LtMastBranches> findAll() throws ServiceException 
	{
		List<LtMastBranches> ltMastBranches = null;
		
		ltMastBranches = ltMastBranchesDao.findAll();
			
		return ltMastBranches;
		
	}

	@Transactional
	@Override
	public LtMastBranches getLtMastBranchesByID(Long branchId) throws ServiceException 
	{		
		LtMastBranches ltMastBranch= ltMastBranchesDao.getLtMastBranchesByID(branchId);
		if(ltMastBranch!=null)
		{
			LtMastBranches ltMastBranchesReporting = new LtMastBranches();
			if (ltMastBranch.getReportingBranch() != null)
			{
				ltMastBranchesReporting = ltMastBranchesDao.getLtMastBranchesByID(ltMastBranch.getReportingBranch());
				if (ltMastBranchesReporting != null)
				{
					ltMastBranch.setReportingBranchName(ltMastBranchesReporting.getBranchName());
					ltMastBranch.setReportingBranchCode(ltMastBranchesReporting.getBranchCode());
			
				} 
			}
		}
		return ltMastBranch;
	}

	@Transactional
	@Override
	public Long getCount(LtMastBranches input) throws ServiceException {
		
		return ltMastBranchesDao.getCount(input);
	}

	@Transactional
	@Override
	public List<LtMastBranches> getBranchDataTableRecords(LtMastBranches input) throws ServiceException
	{
		if(input.getColumnNo()==3 && input.getSort().equals("desc"))
		{ input.setColumnNo(13); }
		if(input.getColumnNo()==4 && input.getSort().equals("desc"))
		{ input.setColumnNo(14); }
		if(input.getColumnNo()==5 && input.getSort().equals("desc"))
		{ input.setColumnNo(15); }
		if(input.getColumnNo()==6 && input.getSort().equals("desc"))
		{ input.setColumnNo(16); }
		if(input.getColumnNo()==7 && input.getSort().equals("desc"))
		{ input.setColumnNo(37); }
		if(input.getColumnNo()==8 && input.getSort().equals("desc"))
		{ input.setColumnNo(18); }
		if(input.getColumnNo()==14 && input.getSort().equals("desc"))
		{ input.setColumnNo(24); }
		if(input.getColumnNo()==17 && input.getSort().equals("desc"))
		{ input.setColumnNo(27); }
		if(input.getColumnNo()==18 && input.getSort().equals("desc"))
		{ input.setColumnNo(28); }
		
		List<LtMastBranches> list = ltMastBranchesDao.getBranchDataTableRecords(input);
		for (Iterator iterator = list.iterator(); iterator.hasNext();) 
		{
			LtMastBranches ltMastBranches = (LtMastBranches) iterator.next();
			if(ltMastBranches.getReportingBranch()!=null)
			{
				LtMastBranches branch= ltMastBranchesDao.getLtMastBranchesByID(ltMastBranches.getReportingBranch());
			
				if(branch != null){
				ltMastBranches.setReportingBranchName(branch.getBranchName()+" ( "+branch.getBranchCode()+" )");
				}
			}
			
		}
		return list;
	}

	@Override
	public ResponseEntity<Status> save(LtMastBranches ltMastBranches,BindingResult bindingResult) throws ServiceException {
		Status status = new Status();
		if (bindingResult.hasErrors()) {
			for(ObjectError objectError : bindingResult.getAllErrors()){
				status.setCode(VALIDATION);
				if(objectError.getCode().toString().equals("notnull")) {
					status.setMessage(messageSource.getMessage(objectError.getDefaultMessage().toString(), null, "Default", Locale.getDefault()));
					return new ResponseEntity<Status>(status, HttpStatus.OK);
				}
			}
		}
		
		String branchObj = null;
	
		
			ltMastBranches.setCreatedBy(ltMastBranches.getLastUpdateLogin());
			ltMastBranches.setLastUpdatedBy(ltMastBranches.getLastUpdateLogin());
			ltMastBranches.setLastUpdateLogin(ltMastBranches.getLastUpdateLogin());
			ltMastBranches.setLastUpdateDate(new Date());
			branchObj = isFeildsExists(ltMastBranches);

			if (branchObj == null) {
				ltMastBranches = ltMastBranchesRepository.save(ltMastBranches);
				status=ltMastCommonMessageService.getCodeAndMessage(INSERT_SUCCESSFULLY);
				if( status.getMessage()==null) {
					status.setCode(SUCCESS);
					status.setMessage("Error in finding message! The action is completed successfully.");
				}
			} else {
				//status=ltMastCommonMessageService.getCodeAndMessage(Data_Exist);
				status.setMessage(branchObj);
				return new ResponseEntity<Status>(status, HttpStatus.OK);
			}
			return new ResponseEntity<Status>(status, HttpStatus.OK);

		

	}

	@Override
	public ResponseEntity<Status> update(LtMastBranches ltMastBranches) throws ServiceException {
		Status status = new Status();
		String stat = null;
		
			if (ltMastBranches.getBranchId() == null) {
				status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_FAIL);
				if(status.getMessage()==null)
				{
					status.setCode(EXCEPTION);
					status.setMessage("Error in finding message! The action was unsuccessful");
				}
				return new ResponseEntity<Status>(status, HttpStatus.OK);
			} 
			else 
			{
				String str = isFeildsExists(ltMastBranches);
				if (str == null) {
					ltMastBranches.setLastUpdateDate(new Date());

					ltMastBranches.setLastUpdatedBy(ltMastBranches.getLastUpdateLogin());
					ltMastBranches = ltMastBranchesRepository.save(ltMastBranches);
					status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_SUCCESSFULLY);
					if(status.getMessage()==null)
					{
						status.setCode(SUCCESS);
						status.setMessage("Error in finding message! The action is completed successfully.");
					}
				}
				else 
				{
					stat = isFeildsExists(ltMastBranches);
					status=ltMastCommonMessageService.getCodeAndMessage(Data_Exist);
					status.setMessage(stat);

				}
				return new ResponseEntity<Status>(status, HttpStatus.OK);
			}
	

	}

	@Override
	public ResponseEntity<Status> delete(String id) throws ServiceException {
		Status status=new Status();
		
			if (ltMastBranchesRepository.exists(Long.parseLong(id)))
			{
				LtMastBranches ltMastBranch=ltMastBranchesRepository.findOne(Long.parseLong(id));
				List<LtMastBranches> ltMastBranchesList=checkAlreadyUsed(ltMastBranch);
				if(ltMastBranchesList.isEmpty())
				{
					ltMastBranchesRepository.delete(Long.parseLong(id));
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
					return new ResponseEntity<Status>(status,HttpStatus.OK);
				}
			} 
			else
			{
				status=ltMastCommonMessageService.getCodeAndMessage(NO_RESULT);
				return new ResponseEntity<Status>(status,HttpStatus.OK);
			}

		
		return new ResponseEntity<Status>(status,HttpStatus.OK);
	}

	
}
