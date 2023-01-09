package com.lonar.vendor.vendorportal.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lonar.vendor.vendorportal.dao.LtMastUserLocationDao;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtMastTaxes;
import com.lonar.vendor.vendorportal.model.LtMastUserLocation;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.repository.LtMastUserLocationRepository;

@Service
public class LtMastUserLocationServiceImpl implements LtMastUserLocationService , CodeMaster{

	@Autowired
	LtMastUserLocationDao ltMastUserLocationDao;
	
	@Autowired
	LtMastUserLocationRepository ltMastUserLocationRepository;
	
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	@Override
	public List<LtMastUserLocation> getAllLtMastUserLocation() throws ServiceException {
		return ltMastUserLocationDao.getAllLtMastUserLocation();
	}

	@Override
	public List<LtMastUserLocation> findAllActive() throws ServiceException {
		return ltMastUserLocationDao.findAllActive();
	}

	@Override
	public LtMastUserLocation getByID(Long id) throws ServiceException {
		return ltMastUserLocationDao.getByID(id);
	}

	@Override
	public List<LtMastUserLocation> listAllActiveUserLocationByLocId(Long id) throws ServiceException {
		return ltMastUserLocationDao.listAllActiveUserLocationByLocId(id);
	}
	
	@Override
	public List<LtMastUserLocation> listAllActiveUserLocationByUserId(Long id) throws ServiceException {
		return ltMastUserLocationDao.listAllActiveUserLocationByUserId(id);
	}

	
	@Override
	public ResponseEntity<Status> save(LtMastUserLocation ltMastUserLocation) throws ServiceException {
		Status status = new Status();
		List<LtMastUserLocation> userLocationList = ltMastUserLocationDao.listAllActiveUserLocationByUserId(ltMastUserLocation.getUserId());
		if(!userLocationList.isEmpty())
		{
			status.setCode(FAIL);
			status.setMessage("Location for user already associated.");
			return new ResponseEntity<Status>(status, HttpStatus.OK);
		}
	
		ltMastUserLocation.setCreatedBy(ltMastUserLocation.getLastUpdateLogin());
		ltMastUserLocation.setLastUpdateLogin(ltMastUserLocation.getLastUpdateLogin());
		ltMastUserLocation.setLastUpdatedBy(ltMastUserLocation.getLastUpdateLogin()); 
		ltMastUserLocation.setCreationDate(new Date());
		ltMastUserLocation.setLastUpdateDate(new Date());
		ltMastUserLocation = ltMastUserLocationRepository.save(ltMastUserLocation);
		if(ltMastUserLocation.getUserLocationId()!=null)
		{
				status=ltMastCommonMessageService.getCodeAndMessage(INSERT_SUCCESSFULLY);
				if(status.getMessage()==null)
				{
					status.setCode(SUCCESS);
					status.setMessage("Error in finding message! The action was successful");
				}
		}
		else
		{
			status=ltMastCommonMessageService.getCodeAndMessage(INSERT_FAIL);
			if(status.getMessage()==null)
			{
				status.setCode(EXCEPTION);
				status.setMessage("Error in finding message! The action was unsuccessful");
			}
		}
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Status> update(LtMastUserLocation ltMastUserLocation) throws ServiceException {
		Status status = new Status();
		if(ltMastUserLocation.getUserLocationId()!=null) {
			
			/*List<LtMastUserLocation> userLocationList = ltMastUserLocationDao.listAllActiveUserLocationByUserId(ltMastUserLocation.getUserId());
			if(!userLocationList.isEmpty())
			{
				status.setCode(FAIL);
				status.setMessage("Location for user already associated.");
				return new ResponseEntity<Status>(status, HttpStatus.OK);
			}*/
			
			
			ltMastUserLocation.setLastUpdateLogin(ltMastUserLocation.getLastUpdateLogin());
			ltMastUserLocation.setLastUpdatedBy(ltMastUserLocation.getLastUpdateLogin()); 
			ltMastUserLocation.setLastUpdateDate(new Date());
			ltMastUserLocation = ltMastUserLocationRepository.save(ltMastUserLocation);
		if(ltMastUserLocation.getUserLocationId()!=null)
		{
			status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_SUCCESSFULLY);
			if(status.getMessage()==null)
			{
				status.setCode(SUCCESS);
				status.setMessage("Error in finding message! The action was successful");
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
		}else
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
	public ResponseEntity<Status> delete(Long id) throws ServiceException {
		Status status = new Status();
		ltMastUserLocationRepository.delete(id);
		if(ltMastUserLocationRepository.exists(id)) {
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
	public Long getCount(LtMastUserLocation input) throws ServiceException {
		return ltMastUserLocationDao.getCount(input);
	}

	@Override
	public List<LtMastUserLocation> getDatatableRecords(LtMastUserLocation input) throws ServiceException {
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
		if(input.getColumnNo()==7 && input.getSort().equals("desc"))
		{
			input.setColumnNo(17);
		}
		if(input.getColumnNo()==0)
		{
			input.setColumnNo(9);
		}
		List<LtMastUserLocation> list=  ltMastUserLocationDao.getDatatableRecords(input);
		
		return list;
	}

	
	

}
