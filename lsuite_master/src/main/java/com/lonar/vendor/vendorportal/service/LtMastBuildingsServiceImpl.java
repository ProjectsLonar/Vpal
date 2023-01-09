package com.lonar.vendor.vendorportal.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lonar.vendor.vendorportal.dao.LtMastBuildingsDao;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtMastBuildings;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.repository.LtMastBuildingsRepository;




@Service
public class LtMastBuildingsServiceImpl implements LtMastBuildingsService,CodeMaster
{
	
	
	@Autowired
	LtMastBuildingsDao  ltP2pBuildingsDao ; 
	
	@Autowired
	LtMastBuildingsRepository ltP2pBuildingsRepository;
	
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	@Override
	public List<LtMastBuildings> findByBuildingCode(String buildingCode) throws ServiceException
	{
		
		return ltP2pBuildingsDao.findByBuildingCode(buildingCode);
	}

	/*@Override
	public ResponseEntity<LtP2pBuildings> findByBuildingId(Long branchId) 
	{ 
		List<LtP2pBuildings> buildings = ltP2pBuildingsDao.findByBranchId(branchId);
		
      if(buildings != null && buildings.size() > 0){
    	  ResponseEntity<LtP2pBuildings> entity = new ResponseEntity<LtP2pBuildings>(  HttpStatus.OK);
    	return new ResponseEntity<LtP2pBuildings>(HttpStatus.OK);
      }else{
    	  
      }
    	  ResponseEntity<List<LtP2pBuildings>>
		return ;
	}*/

	@Override
	public List<LtMastBuildings> findAllActive() throws ServiceException
	{	
			return ltP2pBuildingsDao.findAllActive();
	}

	

	@Override
	public Integer getLtP2pBuildingsCount() throws Exception  {
		return ltP2pBuildingsDao.getLtP2pBuildingsCount();
	}

	@Override
	public List<LtMastBuildings> searchBuildings(LtMastBuildings ob)throws ServiceException 	{
		return ltP2pBuildingsDao.searchBuildings(ob);
	}

	@Override
	public ResponseEntity<Status> saveBuildings(LtMastBuildings ltP2pBuildings) throws ServiceException{
		Status status = new Status();
		
		LtMastBuildings building = ltP2pBuildingsDao.getByBuildingCode(ltP2pBuildings.getBuildingCode());
		if(building!=null && !(building.getBuildingId().equals(ltP2pBuildings.getBuildingId()))) {
			status.setCode(FAIL);
			status.setMessage("Building code already exists.");
			return new ResponseEntity<Status>(status, HttpStatus.OK);
		}
		
	/*	building = ltP2pBuildingsDao.getByBuildingName(ltP2pBuildings.getBuildingName());
		if(building!=null && !(building.getBuildingId().equals(ltP2pBuildings.getBuildingId()))) {
			status.setCode(FAIL);
			status.setMessage("Building name already exists.");
			return new ResponseEntity<Status>(status, HttpStatus.OK);
		}*/
		
		if(ltP2pBuildings.getStartDate()==null || ltP2pBuildings.getLastUpdateLogin() == null )
		{
			status=ltMastCommonMessageService.getCodeAndMessage(INPUT_IS_EMPTY);
			if( status.getMessage()==null) {
				status.setCode(EXCEPTION);
				status.setMessage("Error in finding message! The action is completed unsuccessfully.");
			}
		}
		ltP2pBuildings.setCreationDate(new Date());
		ltP2pBuildings.setLastUpdateDate(new Date());
		ltP2pBuildings.setCreatedBy(ltP2pBuildings.getLastUpdateLogin());
		ltP2pBuildings.setLastUpdateLogin(ltP2pBuildings.getLastUpdateLogin());
		ltP2pBuildings.setLastUpdatedBy(ltP2pBuildings.getLastUpdateLogin()); 
		ltP2pBuildings = ltP2pBuildingsRepository.save(ltP2pBuildings);
			if(ltP2pBuildings.getBuildingId()!=null)
			{
				status=ltMastCommonMessageService.getCodeAndMessage(INSERT_SUCCESSFULLY);
				if( status.getMessage()==null) {
					status.setCode(INSERT_SUCCESSFULLY);
					status.setMessage("Error in finding message! The action is completed successfully.");
				}
			}
			else
			{
				status=ltMastCommonMessageService.getCodeAndMessage(INSERT_FAIL);
				if( status.getMessage()==null) {
					status.setCode(INSERT_FAIL);
					status.setMessage("Error in finding message! The action is completed unsuccessfully.");
				}
			}
		    return new ResponseEntity<Status>(status, HttpStatus.OK);
		
	}

	@Override
	public ResponseEntity<LtMastBuildings> findByBuildingId(Long id)throws ServiceException  
	{
		List<LtMastBuildings> buildings =  ltP2pBuildingsDao.findByBuildingId(id);
		ResponseEntity<LtMastBuildings> entity =null;
		if(buildings != null && buildings.size() > 0 ){
		     entity = new ResponseEntity<LtMastBuildings>(buildings.get(0), HttpStatus.OK);
			return entity;
		}else{
			 entity = new ResponseEntity<LtMastBuildings>(HttpStatus.NO_CONTENT);
		    return entity;
		}
		
	}

	
	
	

	@Override
	public List<LtMastBuildings> findAllBuildingAddr(String addr) throws ServiceException
	{
		return ltP2pBuildingsDao.findAllBuildingAddr(addr);
	}

	@Override
	public List<LtMastBuildings> findActiveLikeBuildingAddr(String buildingaddr) throws ServiceException 
	{
		return ltP2pBuildingsDao.findActiveLikeBuildingAddr(buildingaddr);
	}
	
	

	@Override
	public List<LtMastBuildings> findByActiveLikeBuildingName(String buildingName) throws ServiceException {
		
		return ltP2pBuildingsDao.findByActiveLikeBuildingName(buildingName);
	}

	@Override
	public List<LtMastBuildings> findByLikeBuildingName(String buildingName) throws ServiceException {
		return ltP2pBuildingsDao.findByLikeBuildingName(buildingName);
	}
	
	@Override
	public List<LtMastBuildings> getBuildingsByBranchId(Long branchId) throws ServiceException{
		return 	ltP2pBuildingsDao.getBuildingsByBranchId(branchId);
	}

	@Override
	public ResponseEntity<Status> updateBuildings(LtMastBuildings ltP2pBuildings) throws ServiceException {
		Status status = new Status();
		if(ltP2pBuildings.getBuildingId()!=null) {
		
			LtMastBuildings building = ltP2pBuildingsDao.getByBuildingCode(ltP2pBuildings.getBuildingCode());
			if(building!=null && !(building.getBuildingId().equals(ltP2pBuildings.getBuildingId()))) {
				status.setCode(FAIL);
				status.setMessage("Building code already exists.");
				return new ResponseEntity<Status>(status, HttpStatus.OK);
			}
			
		ltP2pBuildings.setLastUpdateDate(new Date());
		ltP2pBuildings.setLastUpdateLogin(ltP2pBuildings.getLastUpdateLogin());
		ltP2pBuildings.setLastUpdatedBy(ltP2pBuildings.getLastUpdateLogin()); 
		ltP2pBuildings = ltP2pBuildingsRepository.save(ltP2pBuildings);
			if(ltP2pBuildings.getBuildingId()!=null)
			{
				status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_SUCCESSFULLY);
				if( status.getMessage()==null) {
					status.setCode(UPDATE_SUCCESSFULLY);
					status.setMessage("Error in finding message! The action is completed successfully.");
				}
			}
			else
			{
				status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_FAIL);
				if( status.getMessage()==null) {
					status.setCode(UPDATE_FAIL);
					status.setMessage("Error in finding message! The action is completed unsuccessfully.");
				}
			}
		}else {
			status=ltMastCommonMessageService.getCodeAndMessage(INPUT_IS_EMPTY);
			if( status.getMessage()==null) {
				status.setCode(EXCEPTION);
				status.setMessage("Error in finding message! The action is completed unsuccessfully.");
			}
		}
		    return new ResponseEntity<Status>(status, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Status> deleteBuildings(Long id) throws ServiceException
	{
		Status status = new Status();
		ltP2pBuildingsRepository.delete(id);
		if (!ltP2pBuildingsRepository.exists(id))
		{
			status=ltMastCommonMessageService.getCodeAndMessage(DELETE_SUCCESSFULLY);
			if( status.getMessage()==null) {
				status.setCode(DELETE_SUCCESSFULLY);
				status.setMessage("Error in finding message! The action is completed successfully.");
			}
		} 
		else 
		{
			status=ltMastCommonMessageService.getCodeAndMessage(ENTITY_CANNOT_DELETE);
			if( status.getMessage()==null) {
				status.setCode(ENTITY_CANNOT_DELETE);
				status.setMessage("Error in finding message! The action is completed unsuccessfully.");
			}
		} 
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}

	@Override
	public Long getCount(LtMastBuildings input) throws ServiceException {
		// TODO Auto-generated method stub
		return ltP2pBuildingsDao.getCount(input);
	}

	@Override
	public List<LtMastBuildings> getDatatableRecords(LtMastBuildings input) throws ServiceException {
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
		if(input.getColumnNo()==0)
		{
			input.setColumnNo(9);
		}
		List<LtMastBuildings> list=  ltP2pBuildingsDao.getDatatableRecords(input);
		
		return list;
	}
}
