package com.lonar.vendor.vendorportal.service;

import java.util.Date;
import java.util.List;

import javax.jdo.annotations.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lonar.vendor.vendorportal.dao.LtMastEmployeeDelegationDao;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtMastEmployeeDelegation;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.repository.LtMastEmployeeDelegationRepository;

@Service
public class LtMastEmployeeDelegationServiceImpl implements LtMastEmployeeDelegationService,CodeMaster {

	@Autowired
	private LtMastEmployeeDelegationDao ltMastEmployeeDelegationDao;
	
	@Autowired
	private LtMastEmployeeDelegationRepository ltMastEmployeeDelegationRepository;
	
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	@Transactional
	@Override
	public List<LtMastEmployeeDelegation> findByEmployeeId(Long employeeId) throws Exception {
		return ltMastEmployeeDelegationDao.findByEmployeeId(employeeId);
	}

	@Transactional
	@Override
	public List<LtMastEmployeeDelegation> findEmployeeBetween(Long employeeId, Date startDate, Date endDate)
			throws Exception {
		return ltMastEmployeeDelegationDao.findEmployeeBetween(employeeId, startDate, endDate);
	}

	@Transactional
	@Override
	public List<LtMastEmployeeDelegation> findDelegationBetween(Long delegationId, Date startDate, Date endDate)
			throws Exception {
		return ltMastEmployeeDelegationDao.findDelegationBetween(delegationId, startDate, endDate);
	}

	@Transactional
	@Override
	public List<LtMastEmployeeDelegation> findByDelegationId(Long delegationId) throws Exception {
		return ltMastEmployeeDelegationDao.findByDelegationId(delegationId);
	}

	@Transactional
	@Override
	public List<LtMastEmployeeDelegation> findForDelegation(Long employeeId) throws Exception {
		return ltMastEmployeeDelegationDao.findForDelegation(employeeId);
	}

	@Transactional
	@Override
	public List<LtMastEmployeeDelegation> findByEmployeeIdOrderByEmployeeDelegationId(Long employeeId) throws Exception {
		return ltMastEmployeeDelegationDao.findByEmployeeIdOrderByEmployeeDelegationId(employeeId);
	}

	@Transactional
	@Override
	public List<LtMastEmployeeDelegation> findByDelegationIdOrderByEmployeeDelegationId(Long delegationId)
			throws Exception {
		return ltMastEmployeeDelegationDao.findByDelegationIdOrderByEmployeeDelegationId(delegationId);
	}

	@Transactional
	@Override
	public List<LtMastEmployeeDelegation> findForEmployee(Long delegationId) throws Exception {
		return ltMastEmployeeDelegationDao.findForEmployee(delegationId);
	}

	@Override
	public void updateDelegation(Long employeeId,Long delegationId) throws Exception {
		ltMastEmployeeDelegationDao.updateDelegation(employeeId,delegationId);
	}

	@Override
	public List<LtMastEmployeeDelegation> getByCreatedBy(Long userId) throws Exception {
		return ltMastEmployeeDelegationDao.getByCreatedBy(userId);
	}

	@Override
	public List<LtMastEmployeeDelegation> getThirdPartyEmployeeDelegationDataTable(LtMastEmployeeDelegation input)
			throws Exception {
		
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
		return ltMastEmployeeDelegationDao.getThirdPartyEmployeeDelegationDataTable(input);
	}

	@Override
	public Long getThirdPartyCount(LtMastEmployeeDelegation input) throws Exception {
		return ltMastEmployeeDelegationDao.getThirdPartyCount(input);
	}

	@Override
	public Long getCount(LtMastEmployeeDelegation input) throws Exception {
		return ltMastEmployeeDelegationDao.getCount(input);
	}

	@Override
	public List<LtMastEmployeeDelegation> getEmployeeDelegationDataTable(LtMastEmployeeDelegation input)
			throws Exception {
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
		return ltMastEmployeeDelegationDao.getEmployeeDelegationDataTable(input);
	}

	@Override
	public Status save(LtMastEmployeeDelegation ltMastEmployeeDelegation) throws Exception
	{
		Status status = new Status();
		LtMastEmployeeDelegation delegateeDelegation = ltMastEmployeeDelegationDao.checkDelegateeAvailability(ltMastEmployeeDelegation);
		
		if(delegateeDelegation!=null) {
			if(chkDate(ltMastEmployeeDelegation.getStartDate(),ltMastEmployeeDelegation.getEndDate(),
					delegateeDelegation.getStartDate(),delegateeDelegation.getEndDate()))
			{
				status.setMessage("Delegate not available.");
				status.setCode(FAIL);

				return status;
			}
			
		}
		
		LtMastEmployeeDelegation employeeDelegation = ltMastEmployeeDelegationDao.checkEmpDelegation(ltMastEmployeeDelegation);
		
		if(employeeDelegation!=null) {
			if(chkDate(ltMastEmployeeDelegation.getStartDate(),ltMastEmployeeDelegation.getEndDate(),
					employeeDelegation.getStartDate(),employeeDelegation.getEndDate()))
			{
				status.setMessage("Employee have already delegated duties for the period");
				status.setCode(FAIL);
				return status;
			}
			
			
		}
		
		ltMastEmployeeDelegation.setCreatedBy(ltMastEmployeeDelegation.getLastUpdateLogin());
		ltMastEmployeeDelegation.setLastUpdatedBy(ltMastEmployeeDelegation.getLastUpdateLogin());
		ltMastEmployeeDelegation.setCreationDate(new Date());
		ltMastEmployeeDelegation.setLastUpdateDate(new Date());
		ltMastEmployeeDelegation = ltMastEmployeeDelegationRepository.save(ltMastEmployeeDelegation);
	
		if(ltMastEmployeeDelegation.getEmployeeDelegationId()!=null) {
			status=ltMastCommonMessageService.getCodeAndMessage(INSERT_SUCCESSFULLY);
			if( status.getMessage()==null)
			{
				status.setCode(SUCCESS);
				status.setMessage("Error in finding message! The action is completed successfully.");
			}
		}else {
			status=ltMastCommonMessageService.getCodeAndMessage(INSERT_FAIL);
			if( status.getMessage()==null)
			{
				status.setCode(FAIL);
				status.setMessage("Error in finding message! The action is completed unsuccessfully.");
			}
		}
		return status;
	
	}

	private boolean chkDate(Date startDateIn, Date endDateIn, Date startDate2, Date endDate2)
	{
		if( startDateIn.after(startDate2) && startDateIn.before(endDate2)  ) {
			return true;//dnt allow
		}else if(endDateIn.after(startDate2) && endDateIn.before(endDate2)) {
			return true;
		}else if(startDateIn.compareTo(endDate2) > 0 || startDateIn.compareTo(endDate2) < 0 ) {
			return true;
		}else
			return false;
			
				
	}

}
