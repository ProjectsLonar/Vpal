package com.lonar.vendor.vendorportal.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lonar.vendor.vendorportal.CommonMethod;
import com.lonar.vendor.vendorportal.dao.LtMastAuditRecordsDao;
import com.lonar.vendor.vendorportal.dao.LtMastCityDao;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtMastAuditRecords;
import com.lonar.vendor.vendorportal.model.LtMastCity;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.repository.LtMastCityRepository;

@Service
public class LtMastCityServiceImpl implements LtMastCityService,CodeMaster{

	@Autowired
	CommonMethod commonMethod;
	
	@Autowired
	LtMastCityDao LtMastCityDao;
	
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	@Autowired
	LtMastCityRepository ltMastCityRepository;
	
	@Autowired
	LtMastAuditRecordsDao ltMastAuditRecordsDao;
	
	@Override
	public Long getCount(LtMastCity input) throws ServiceException {

		return LtMastCityDao.getCount(input);
	}

	@Override
	public List<LtMastCity> getCityDataTableRecords(LtMastCity input) throws ServiceException 
	{
		if(input.getColumnNo()==1 && input.getSort().equals("desc"))
		{
			input.setColumnNo(11);
		}
		if(input.getColumnNo()==2 && input.getSort().equals("desc"))
		{
			input.setColumnNo(12);
		}
		if(input.getColumnNo()==3 && input.getSort().equals("desc"))
		{
			input.setColumnNo(13);
		}
		if(input.getColumnNo()==4 && input.getSort().equals("desc"))
		{
			input.setColumnNo(14);
		}
		if(input.getColumnNo()==5 && input.getSort().equals("desc"))
		{
			input.setColumnNo(15);
		}
		if(input.getColumnNo()==6 && input.getSort().equals("desc"))
		{
			input.setColumnNo(16);
		}
		
		if(input.getColumnNo()==7 && input.getSort().equals("asc"))
		{
			input.setColumnNo(17);
		}
		if(input.getColumnNo()==8 && input.getSort().equals("asc"))
		{
			input.setColumnNo(18);
		}
		if(input.getColumnNo()==9 && input.getSort().equals("asc"))
		{
			input.setColumnNo(19);
		}
		return LtMastCityDao.getCityDataTableRecords(input);
		
	}
	
	@Override
	public ResponseEntity<Status> delete(Long id) throws ServiceException {
		
		Status status = new Status();
		ltMastCityRepository.delete(id);
		if(ltMastCityRepository.exists(id)) {
		status=ltMastCommonMessageService.getCodeAndMessage(DELETE_FAIL);
		if(status.getMessage()==null)
		{
			status.setCode(EXCEPTION);
			status.setMessage("Error in finding message! The action was unsuccessful");
		}
		}else {
			status=ltMastCommonMessageService.getCodeAndMessage(DELETE_SUCCESSFULLY);
			if(status.getMessage()==null)
			{
				status.setCode(EXCEPTION);
				status.setMessage("Error in finding message! The action was successful");
			}
		}
		 return new ResponseEntity<Status>(status, HttpStatus.OK);	
	}

	@Override
	public ResponseEntity<Status> update(LtMastCity ltMastCity) throws ServiceException, IOException {
		
		Status status = new Status();
		if(ltMastCity.getCityId()!=null)
		{
			LtMastCity cityCode = LtMastCityDao.getByCityCode(ltMastCity.getCityCode().trim(),ltMastCity.getStateId());
			
			if(cityCode!=null && !(cityCode.getCityId().equals(ltMastCity.getCityId())))
			{
				status.setCode(FAIL);
				status.setMessage("City code already exists.");
				return new ResponseEntity<Status>(status, HttpStatus.OK);
			}
			
			LtMastCity cityName = LtMastCityDao.getByCityName(ltMastCity.getCityName().trim(),ltMastCity.getStateId());
			if(cityName!=null && !(cityName.getCityId().equals(ltMastCity.getCityId())))
			{
				status.setCode(FAIL);
				status.setMessage("City Name already exists.");
				return new ResponseEntity<Status>(status, HttpStatus.OK);
			}
			ltMastCity.setLastUpdateLogin(ltMastCity.getLastUpdateLogin());
			ltMastCity.setLastUpdatedBy(ltMastCity.getLastUpdateLogin());
			ltMastCity.setLastUpdateDate(new Date());
			
			LtMastCity ltMastCityBase = LtMastCityDao.getForAuditByID(ltMastCity.getCityId());
			
			ltMastCity= ltMastCityRepository.save(ltMastCity);
			
			LtMastCity ltMastCityWork = LtMastCityDao.getForAuditByID(ltMastCity.getCityId());
			float auditId = commonMethod.saveAudit(ltMastCityBase,ltMastCityWork);
			LtMastCityDao.updateAuditId(auditId,ltMastCity.getCityId());
			
			if(ltMastCity.getCityId()!=null)
			{
					status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_SUCCESSFULLY);
					if(status.getMessage()==null)
					{
						status.setCode(UPDATE_SUCCESSFULLY);
						status.setMessage("Error in finding message! The action was successful");
					}
			}
			else
			{
				status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_FAIL);
				if(status.getMessage()==null)
				{
					status.setCode(UPDATE_FAIL);
					status.setMessage("Error in finding message! The action was unsuccessful");
				}
			}
			
		}
		else
		{
			status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_FAIL);
			if(status.getMessage()==null)
			{
				status.setCode(EXCEPTION);
				status.setMessage("Error in finding message! The action was unsuccessful");
			}
		}
	    return new ResponseEntity<Status>(status, HttpStatus.OK);
		
	}

	@Override
	public ResponseEntity<Status> save(LtMastCity ltMastCity) throws ServiceException, IOException {
		Status status = new Status();
		LtMastCity cityCode = LtMastCityDao.getByCityCode(ltMastCity.getCityCode().trim(),ltMastCity.getStateId());
		if(cityCode !=null ) 
		{
			if( !(cityCode.getCityId().equals(ltMastCity.getCityId()) ) ) {
			status.setCode(FAIL);
			status.setMessage("City code already exists.");
			return new ResponseEntity<Status>(status, HttpStatus.OK);
		}
		}
		
		LtMastCity cityName = LtMastCityDao.getByCityName(ltMastCity.getCityName().trim(),ltMastCity.getStateId());
		if(cityName !=null ) {
			if( !(cityCode.getCityId().equals(ltMastCity.getCityId()) ) ) {
			
			status.setCode(FAIL);
			status.setMessage("City Name already exists.");
			return new ResponseEntity<Status>(status, HttpStatus.OK);
		}
		}
		
		ltMastCity.setCreatedBy(ltMastCity.getLastUpdateLogin());
		ltMastCity.setLastUpdateLogin(ltMastCity.getLastUpdateLogin());
		ltMastCity.setLastUpdatedBy(ltMastCity.getLastUpdateLogin());
		ltMastCity.setCreationDate(new Date());
		ltMastCity.setLastUpdateDate(new Date());
		
		ltMastCity= ltMastCityRepository.save(ltMastCity);
		
		LtMastCity ltMastCityWork = LtMastCityDao.getForAuditByID(ltMastCity.getCityId());
		
		float auditId = commonMethod.saveAudit(null,ltMastCityWork);
		LtMastCityDao.updateAuditId(auditId,ltMastCity.getCityId());
		
		if(ltMastCity.getCityId()!=null)
		{
				status=ltMastCommonMessageService.getCodeAndMessage(INSERT_SUCCESSFULLY);
				if(status.getMessage()==null)
				{
					status.setCode(INSERT_SUCCESSFULLY);
					status.setMessage("Error in finding message! The action was successful");
				}
				status.setData(ltMastCity.getCityId());
		}
		else
		{
			status=ltMastCommonMessageService.getCodeAndMessage(INSERT_FAIL);
			if(status.getMessage()==null)
			{
				status.setCode(INSERT_FAIL);
				status.setMessage("Error in finding message! The action was unsuccessful");
			}
		}
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}

	@Override
	public List<LtMastCity> findAll() throws ServiceException {
		
		return LtMastCityDao.findAll();
	}

	@Override
	public List<LtMastCity> findAllActive() throws ServiceException {
		
		return LtMastCityDao.findAllActive();
	}

	@Override
	public LtMastCity getByID(Long id) throws ServiceException {
		
		return LtMastCityDao.getById(id);
	}

	@Override
	public List<LtMastCity> findActiveLikeCityName(String city) throws ServiceException {
		
		return LtMastCityDao.findActiveLikeCityName(city);
	}
	
	
	private void saveAudit(LtMastCity ltMastCityBase, LtMastCity ltMastCityWork) {
		/*LtMastAudit ltMastAudit = new LtMastAudit();
		DiffNode diff = ObjectDifferBuilder.buildDefault().compare(ltMastCityWork, ltMastCityBase);

		List<String> list  = new ArrayList<String>();
		diff.visit(new DiffNode.Visitor()
		{
		   public void node(DiffNode node, Visit visit)
		   {
		       final Object baseValue = node.canonicalGet(ltMastCityBase);
		       final Object workingValue = node.canonicalGet(ltMastCityWork);
		       final String message = node.getPath() + " changed from " + 
		                              baseValue + " to " + workingValue;
		       list.add(message);
		      // ltMastAudit.setDifference(ltMastAudit.getDifference()+message);
		   }
		});

		ltMastAudit.setDifference(list.subList(1, list.size()).toString());
		if(ltMastCityBase!=null) {
		ltMastAudit.setOldEntity(ltMastCityBase.toString());
		}
		ltMastAudit.setNewEntity(ltMastCityWork.toString());
		ltMastAudit.setCreationDate(new Date());
		ltMastAudit.setCreatedBy(ltMastCityWork.getLastUpdateLogin());
		ltMastAudit.setMasterName(ltMastCityWork.getClass().getName());

		ltMastAuditRepository.save(ltMastAudit);*/

		}

	@Override
	public List<LtMastAuditRecords> getLtMastCityAudit(Long cityId) throws ServiceException 
	{
		return LtMastCityDao.getLtMastCityAudit(cityId);
	}

	@Override
	public List<LtMastAuditRecords> getDifference(LtMastCity ltMastCity) throws ServiceException, IOException {
		LtMastCity ltMastCityBase = LtMastCityDao.getForAuditByID(ltMastCity.getCityId());
		//float auditId = commonMethod.saveAudit(ltMastCityBase,ltMastCity);
		
		return commonMethod.getDifference(ltMastCityBase,ltMastCity);
		
		//List<LtMastAuditRecords> list = ltMastAuditRecordsDao.getByAuditId(auditId);
		//return list;
	}
	
}
