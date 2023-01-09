package com.lonar.vendor.vendorportal.service;

import java.util.Date;
import java.util.List;

import javax.jdo.annotations.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lonar.vendor.vendorportal.dao.LtMastEmployeeDelegationDao;
import com.lonar.vendor.vendorportal.model.LtMastEmployeeDelegation;

@Service
public class LtMastEmployeeDelegationServiceImpl implements LtMastEmployeeDelegationService {

	@Autowired
	private LtMastEmployeeDelegationDao ltMastEmployeeDelegationDao;
	
	@Transactional
	@Override
	public List<LtMastEmployeeDelegation> findByEmployeeId(Long employeeId) throws Exception {
		// TODO Auto-generated method stub
		return ltMastEmployeeDelegationDao.findByEmployeeId(employeeId);
	}

	@Transactional
	@Override
	public List<LtMastEmployeeDelegation> findEmployeeBetween(Long employeeId, Date startDate, Date endDate)
			throws Exception {
		// TODO Auto-generated method stub
		return ltMastEmployeeDelegationDao.findEmployeeBetween(employeeId, startDate, endDate);
	}

	@Transactional
	@Override
	public List<LtMastEmployeeDelegation> findDelegationBetween(Long delegationId, Date startDate, Date endDate)
			throws Exception {
		// TODO Auto-generated method stub
		return ltMastEmployeeDelegationDao.findDelegationBetween(delegationId, startDate, endDate);
	}

	@Transactional
	@Override
	public List<LtMastEmployeeDelegation> findByDelegationId(Long delegationId) throws Exception {
		// TODO Auto-generated method stub
		return ltMastEmployeeDelegationDao.findByDelegationId(delegationId);
	}

	@Transactional
	@Override
	public List<LtMastEmployeeDelegation> findForDelegation(Long employeeId) throws Exception {
		// TODO Auto-generated method stub
		return ltMastEmployeeDelegationDao.findForDelegation(employeeId);
	}

	@Transactional
	@Override
	public List<LtMastEmployeeDelegation> findByEmployeeIdOrderByEmployeeDelegationId(Long employeeId) throws Exception {
		// TODO Auto-generated method stub
		return ltMastEmployeeDelegationDao.findByEmployeeIdOrderByEmployeeDelegationId(employeeId);
	}

	@Transactional
	@Override
	public List<LtMastEmployeeDelegation> findByDelegationIdOrderByEmployeeDelegationId(Long delegationId)
			throws Exception {
		// TODO Auto-generated method stub
		return ltMastEmployeeDelegationDao.findByDelegationIdOrderByEmployeeDelegationId(delegationId);
	}

	@Transactional
	@Override
	public List<LtMastEmployeeDelegation> findForEmployee(Long delegationId) throws Exception {
		// TODO Auto-generated method stub
		return ltMastEmployeeDelegationDao.findForEmployee(delegationId);
	}

	@Override
	public void updateDelegation(Long employeeId,Long delegationId) throws Exception {
		// TODO Auto-generated method stub
		ltMastEmployeeDelegationDao.updateDelegation(employeeId,delegationId);
	}

	@Override
	public List<LtMastEmployeeDelegation> getByCreatedBy(Long userId) throws Exception {
		// TODO Auto-generated method stub
		return ltMastEmployeeDelegationDao.getByCreatedBy(userId);
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
	public Long getCount(LtMastEmployeeDelegation input) throws Exception {
		// TODO Auto-generated method stub
		return ltMastEmployeeDelegationDao.getCount(input);
	}

}
