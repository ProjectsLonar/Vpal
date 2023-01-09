package com.lonar.vendor.vendorportal.service;

import java.io.IOException;
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

import com.lonar.vendor.vendorportal.CommonMethod;
import com.lonar.vendor.vendorportal.dao.LtMastBranchesDao;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtMastBranches;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.repository.LtMastAuditRecordsRepository;
import com.lonar.vendor.vendorportal.repository.LtMastAuditRepository;
import com.lonar.vendor.vendorportal.repository.LtMastBranchesRepository;


@Service
public class LtMastBranchesServiceImpl implements LtMastBranchesService,CodeMaster {
	@Autowired
	LtMastBranchesDao ltMastBranchesDao;
	
	@Autowired
	LtMastAuditRepository ltMastAuditRepository;
	
	@Autowired
	LtMastAuditRecordsRepository ltMastAuditRecordsRepository;

	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	CommonMethod commonMethod;
	
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
	public List<LtMastBranches> findAllActive(Long companyId) throws ServiceException {
		List<LtMastBranches> ltMastBranches = null;
		
			ltMastBranches =ltMastBranchesDao.findAllActive(companyId);
			
		return ltMastBranches;
		
	}

	@Transactional
	@Override
	public List<LtMastBranches> findActiveLikeBranchName(String branchName, Long companyId) throws ServiceException
	{
		List<LtMastBranches> ltMastBranches = ltMastBranchesDao.findActiveLikeBranchName(branchName, companyId);
		
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
					if (!branch.getBranchId().equals(ltMastBranches.getBranchId()))
						status = messageSource.getMessage("Location code already exists", null,
								"Location code already exists", Locale.getDefault());
					else
						return status;
				}
				else if(ltMastBranches.getBranchName().equals(branch.getBranchName()))
				{
					if (!branch.getBranchId().equals(ltMastBranches.getBranchId()))
						status = messageSource.getMessage("Location Name already exists", null,
								"Location Name is already Exists", Locale.getDefault());
						else return status;
					
				}
				else if ( ltMastBranches.getGstRegNo().equals(branch.getGstRegNo())) 
				{
					if (!branch.getBranchId().equals(ltMastBranches.getBranchId()))
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
	public List<LtMastBranches> findAll(Long companyId) throws ServiceException 
	{
		List<LtMastBranches> ltMastBranches = null;
		ltMastBranches = ltMastBranchesDao.findAll(companyId);
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
	public Long getCount(Long companyId, LtMastBranches input) throws ServiceException {
		
		return ltMastBranchesDao.getCount(companyId, input);
	}

	@Transactional
	@Override
	public List<LtMastBranches> getBranchDataTableRecords(Long companyId, LtMastBranches input) throws ServiceException
	{

		if(input.getSort()==null) {
			input.setSort("desc");
		}
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
		if(input.getColumnNo()==8 && input.getSort().equals("desc"))
		{ input.setColumnNo(18); }
		if(input.getColumnNo()==9 && input.getSort().equals("desc"))
		{ input.setColumnNo(19); }
		if(input.getColumnNo()==10 && input.getSort().equals("desc"))
		{ input.setColumnNo(20); }
		if(input.getColumnNo()==0 && input.getSort().equals("asc"))
		{ input.setColumnNo(11); }
	
		
		List<LtMastBranches> list = ltMastBranchesDao.getBranchDataTableRecords(companyId, input);
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
	public ResponseEntity<Status> save(LtMastBranches ltMastBranches,BindingResult bindingResult) throws ServiceException, IOException {
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
				if(ltMastBranches.getBranchId()!=null) {
				LtMastBranches ltMastBranchesWork = ltMastBranchesDao.getForAuditByID(ltMastBranches.getBranchId());
				//commonMethod.saveAudit(null,ltMastBranchesWork);
				}
				
				status=ltMastCommonMessageService.getCodeAndMessage(INSERT_SUCCESSFULLY);
				if( status.getMessage()==null) {
					status.setCode(INSERT_SUCCESSFULLY);
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
	public ResponseEntity<Status> update(LtMastBranches ltMastBranches) throws ServiceException, IOException {
		Status status = new Status();
		String stat = null;
		
			if (ltMastBranches.getBranchId() == null) {
				status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_FAIL);
				if(status.getMessage()==null)
				{
					status.setCode(UPDATE_FAIL);
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
					//LtMastBranches ltMastBranchesBase = ltMastBranchesDao.getForAuditByID(ltMastBranches.getBranchId());
					//LtMastBranches ltMastBranchesWork = ltMastBranches;
					
					
					
					ltMastBranches = ltMastBranchesRepository.save(ltMastBranches);
					
					//LtMastBranches ltMastBranchesWork = ltMastBranchesDao.getForAuditByID(ltMastBranches.getBranchId());
					
					//commonMethod.saveAudit(ltMastBranchesBase,ltMastBranchesWork);
					
					status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_SUCCESSFULLY);
					if(status.getMessage()==null)
					{
						status.setCode(UPDATE_SUCCESSFULLY);
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

	/*private void saveAudit(LtMastBranches ltMastBranchesBase, LtMastBranches ltMastBranchesWork) {
		
		
		 LtMastAudit ltMastAudit = new LtMastAudit();
			ltMastAudit.setCreationDate(new Date());
			ltMastAudit.setCreatedBy(ltMastBranchesWork.getLastUpdatedBy());
			ltMastAudit.setMasterName(ltMastBranchesWork.getClass().getName());
			if(ltMastBranchesBase!=null) {
			ltMastAudit.setOldEntity(ltMastBranchesBase+"");
			}
			ltMastAudit.setNewEntity(ltMastBranchesWork+"");
			
			ltMastAudit = ltMastAuditRepository.save(ltMastAudit);
			final float auditId = ltMastAudit.getAuditId();
			
		DiffNode diff = ObjectDifferBuilder.buildDefault().compare(ltMastBranchesWork, ltMastBranchesBase);
		List<String> list  = new ArrayList<String>();
		diff.visit(new DiffNode.Visitor()
		{
		    public void node(DiffNode node, Visit visit)
		    {
		    	
		        final Object baseValue = node.canonicalGet(ltMastBranchesBase);
		        final Object workingValue = node.canonicalGet(ltMastBranchesWork);
		        final String message = node.getPath() + " changed from " + 
		                               baseValue + " to " + workingValue;
		        //ltMastAudit.setDifference(list.subList(1, list.size()).toString());
				//if(ltMastBranchesBase!=null) {
				//ltMastAudit.setOldEntity(ltMastBranchesBase.toString());
			//	}
				//ltMastAudit.setNewEntity(ltMastBranchesWork.toString());
		        LtMastAuditRecords ltMastAuditRecords = new LtMastAuditRecords();
		        ltMastAuditRecords.setCreationDate(new Date());
		        ltMastAuditRecords.setCreatedBy(ltMastBranchesWork.getLastUpdatedBy());
		        ltMastAuditRecords.setValueName(node.getPath()+"");
		        ltMastAuditRecords.setOldValue(baseValue+"");
		        ltMastAuditRecords.setNewValue(workingValue+"");
		        ltMastAuditRecords.setAuditId(auditId);
				
				ltMastAuditRecordsRepository.save(ltMastAuditRecords);
		       // list.add(message);
		        //ltMastAudit.setDifference(ltMastAudit.getDifference()+message);
		    }
		});
		
		
	}*/

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
						status.setCode(DELETE_SUCCESSFULLY);
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

	@Override
	public List<LtMastBranches> getAllActiveBillingAddress(Long companyId) throws ServiceException {
		// TODO Auto-generated method stub
		return ltMastBranchesDao.getAllActiveBillingAddress(companyId);
	}

	@Override
	public List<LtMastBranches> getAllActiveShippingAddress(Long companyId) throws ServiceException {
		return ltMastBranchesDao.getAllActiveShippingAddress(companyId);
	}

	@Override
	public List<LtMastBranches> getAllActiveBillingAddrByBuyer(Long id) throws ServiceException {
		return ltMastBranchesDao.getAllActiveBillingAddrByBuyer(id);
	}

	@Override
	public List<LtMastBranches> getAllActiveShippingAddrByBuyer(Long id) throws ServiceException {
		return ltMastBranchesDao.getAllActiveShippingAddrByBuyer(id);
	}

	@Override
	public List<LtMastBranches> getLtMastBranchesByCompID(Long id) throws ServiceException {
		return ltMastBranchesDao.getLtMastBranchesByCompID(id);
	}

	@Override
	public List<LtMastBranches> getLtMastLikeNameByCompanyId(Long id, String trim) throws ServiceException {
		return ltMastBranchesDao.getLtMastLikeNameByCompanyId(id,trim);
	}

	
}
