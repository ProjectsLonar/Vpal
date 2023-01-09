package com.lonar.vendor.vendorportal.service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.jdo.annotations.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lonar.vendor.vendorportal.dao.LtMastCostCentersDao;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtMastCostCenters;
import com.lonar.vendor.vendorportal.model.LtMastEmployees;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.repository.LtMastCostCentersRepository;
import com.lonar.vendor.vendorportal.repository.LtMastEmployeesRepository;


@Service
public  class LtMastCostCentersServiceImpl implements LtMastCostCentersService,CodeMaster {
	@Autowired
	LtMastCostCentersDao ltMastCostCentersDao;
	@Autowired
	private MessageSource messageSource;
	@Autowired
	LtMastCostCentersRepository ltMastCostCentersRepository;
	@Autowired
	LtMastEmployeesRepository ltMastEmployeesRepository;
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	@Transactional
	@Override
	public List<LtMastCostCenters> findByCostCenterCode(String costCenterCode) throws ServiceException{
		return ltMastCostCentersDao.findByCostCenterCode(costCenterCode);
	}

	@Transactional
	@Override
	public List<LtMastCostCenters> findByCostCenterName(String costCenterName) throws ServiceException{
		return ltMastCostCentersDao.findByCostCenterName(costCenterName);
	}

	@Transactional
	@Override
	public ResponseEntity<List<LtMastCostCenters>> findAllActive() throws ServiceException{
		List<LtMastCostCenters> ltMastCostCenters = null;
	
			ltMastCostCenters = ltMastCostCentersDao.findAllActive();
			for (LtMastCostCenters ltMastCostCenters2 : ltMastCostCenters) {
				LtMastEmployees ltMastEmployees = new LtMastEmployees();
				if (ltMastCostCenters2.getApproverId() != null) {
					if (ltMastEmployeesRepository.exists(ltMastCostCenters2.getApproverId())) {
						ltMastEmployees = ltMastEmployeesRepository.findOne(ltMastCostCenters2.getApproverId());
					}
				}

			}	
			return new ResponseEntity<List<LtMastCostCenters>>(ltMastCostCenters, HttpStatus.OK);
	}

	@Transactional
	@Override
	public List<LtMastCostCenters> findByActiveLikeCostCentersName(String costCentersName) throws ServiceException{
		List<LtMastCostCenters> ltMastCostCenters = null;
		
			ltMastCostCenters = ltMastCostCentersDao.findByActiveLikeCostCentersName(costCentersName);
			for (LtMastCostCenters ltMastCostCenters2 : ltMastCostCenters) {
				LtMastEmployees ltMastEmployees = new LtMastEmployees();
				if (ltMastCostCenters2.getApproverId() != null) {
					if (ltMastEmployeesRepository.exists(ltMastCostCenters2.getApproverId())) {
						ltMastEmployees = ltMastEmployeesRepository.findOne(ltMastCostCenters2.getApproverId());
					}
				}

			}
			return ltMastCostCenters;
	
	}

	@Transactional
	@Override
	public List<LtMastCostCenters> findByLikeCostCentersName(String costCentersName) throws ServiceException{
		List<LtMastCostCenters> ltMastCostCenters = new ArrayList<LtMastCostCenters>();
		
			ltMastCostCenters = ltMastCostCentersDao.findByActiveLikeCostCentersName(costCentersName);
		
			
			return ltMastCostCenters;
			
		
	}

	@Transactional
	@Override
	public String checkDetails(LtMastCostCenters ltMastCostCenters,String flag) throws ServiceException
	{
		String stat=null;
		List<LtMastCostCenters> costCenterList = ltMastCostCentersDao.checkDetails(ltMastCostCenters);
		for(LtMastCostCenters costCenters:costCenterList)
		{
			
			if(costCenters.getCostCenterName().equals(ltMastCostCenters.getCostCenterName()))
			{
				if(costCenters.getCostCenterId()!=ltMastCostCenters.getCostCenterId())
				{
					if(!flag.equals("update")){
					stat=messageSource.getMessage("Cost Center Name already Exists", null,
							"Cost Center Name already Exists", Locale.getDefault());
					}
				}
			}
			else if(costCenters.getCostCenterCode().equals(ltMastCostCenters.getCostCenterCode()))
			{
				if(costCenters.getCostCenterId()!=ltMastCostCenters.getCostCenterId())
				{
					if(!flag.equals("update")){
					stat=messageSource.getMessage("Cost Center Code already Exists", null,
							"Cost Center Code already Exists", Locale.getDefault());
					}
				}
			}
		}
		return stat;
	}

	@Transactional
	@Override
	public List<LtMastCostCenters> getDataTable(LtMastCostCenters input) throws ServiceException 
	{
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
		List<LtMastCostCenters> list= ltMastCostCentersDao.getDataTable(input);
		return list;
	}

	@Transactional
	@Override
	public Long getCount(LtMastCostCenters input) throws ServiceException {
		return ltMastCostCentersDao.getCount(input);
	}

	@Transactional
	@Override
	public LtMastCostCenters getLtMastCostCentersByID(Long costCentersID) throws ServiceException 
	{
		LtMastCostCenters ltMastCostCenters = null;
		
		ltMastCostCenters = ltMastCostCentersDao.getLtMastCostCentersByID(costCentersID);
		
		
		return ltMastCostCenters;
	}

	@Override
	public ResponseEntity<List<LtMastCostCenters>> getAll() throws ServiceException {

		List<LtMastCostCenters> ltMastCostCenters = new ArrayList<LtMastCostCenters>();
			ltMastCostCenters = (List<LtMastCostCenters>) ltMastCostCentersRepository.findAll();
			for (LtMastCostCenters ltMastCostCenters2 : ltMastCostCenters) {
				LtMastEmployees ltMastEmployees = new LtMastEmployees();
				if (ltMastCostCenters2.getApproverId() != null) {
					if (ltMastEmployeesRepository.exists(ltMastCostCenters2.getApproverId())) {
						ltMastEmployees = ltMastEmployeesRepository.findOne(ltMastCostCenters2.getApproverId());
					}
				}

			}
			if (ltMastCostCenters.isEmpty()) {
				return new ResponseEntity<List<LtMastCostCenters>>(ltMastCostCenters, HttpStatus.OK);
			}
		return new ResponseEntity<List<LtMastCostCenters>>(ltMastCostCenters, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Status> save(LtMastCostCenters ltMastCostCenters) throws ServiceException {
		Status status = new Status();
		new HttpHeaders();
		String stat=null;

			stat=checkDetails(ltMastCostCenters,"save");
			if(stat==null)
			{
				ltMastCostCenters.setCreatedBy(ltMastCostCenters.getLastUpdateLogin());
				ltMastCostCenters.setLastUpdatedBy(ltMastCostCenters.getLastUpdateLogin());
				ltMastCostCenters.setLastUpdateLogin(ltMastCostCenters.getLastUpdateLogin());
				ltMastCostCenters.setCreationDate(new Date());
				ltMastCostCenters.setLastUpdateDate(new Date());
				ltMastCostCenters = ltMastCostCentersRepository.save(ltMastCostCenters);
		
				status=ltMastCommonMessageService.getCodeAndMessage(INSERT_SUCCESSFULLY);
				if( status.getMessage()==null)
				{
					status.setCode(SUCCESS);
					status.setMessage("Error in finding message! The action is completed successfully.");
				}
				return new ResponseEntity<Status>(status, HttpStatus.OK);
			}
			else
			{
				status=ltMastCommonMessageService.getCodeAndMessage(INSERT_FAIL);
				status.setMessage(stat);
				return new ResponseEntity<Status>(status, HttpStatus.OK);
				
			}
		
	}

	@Override
	public ResponseEntity<Status> update(LtMastCostCenters ltMastCostCenters) throws ServiceException {

		Status status = new Status();
		new HttpHeaders();
		String stat=null;

			if(ltMastCostCenters.getCostCenterId()!=null)
			{
				stat=checkDetails(ltMastCostCenters,"update");
				if(stat==null)
				{
					ltMastCostCenters.setLastUpdatedBy(ltMastCostCenters.getLastUpdateLogin());
					ltMastCostCenters.setLastUpdateLogin(ltMastCostCenters.getLastUpdateLogin());
					ltMastCostCenters.setLastUpdateDate(new Date());
					ltMastCostCenters = ltMastCostCentersRepository.save(ltMastCostCenters);
				
					status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_SUCCESSFULLY);
					if(status.getMessage()==null)
					{
						status.setCode(SUCCESS);
						status.setMessage("Error in finding message! The action is completed successfully.");
					}
					
				}
				else
				{
					status=ltMastCommonMessageService.getCodeAndMessage(Data_Exist);
					status.setMessage(stat);					
				}
			}
			else
			{
				status=ltMastCommonMessageService.getCodeAndMessage(INPUT_IS_EMPTY);
			}
			return new ResponseEntity<Status>(status, HttpStatus.OK);
			
		
	}

	@Override
	public ResponseEntity<Status> delete(String id) throws ServiceException {
		Status status=new Status();
		
			if (ltMastCostCentersRepository.exists(Long.parseLong(id))) {
				ltMastCostCentersRepository.delete(Long.parseLong(id));
			} 
			else 
			{
				status=ltMastCommonMessageService.getCodeAndMessage(NO_RESULT);
				return new ResponseEntity<Status>(status,HttpStatus.OK);
			}
			status=ltMastCommonMessageService.getCodeAndMessage(DELETE_SUCCESSFULLY);
			if(status.getMessage()==null)
			{
				status.setCode(SUCCESS);
				status.setMessage("Error in finding message! The action is completed successfully.");
			}
			return new ResponseEntity<Status>(status,HttpStatus.OK);
	}

}
