package com.lonar.vendor.vendorportal.service;
import java.util.Date;
import java.util.List;

import javax.jdo.annotations.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.lonar.vendor.vendorportal.dao.LtMastComnMasterDao;
import com.lonar.vendor.vendorportal.dao.LtMastComnMasterValuesDao;
import com.lonar.vendor.vendorportal.model.BusinessException;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.CommonMasterWithValue;
import com.lonar.vendor.vendorportal.model.LtMastComnMaster;
import com.lonar.vendor.vendorportal.model.LtMastComnMasterValues;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.repository.LtMastComnMasterRepository;
import com.lonar.vendor.vendorportal.repository.LtMastComnMasterValuesRepository;

@Service
public  class LtMastComnMasterServiceImpl implements LtMastComnMasterService,CodeMaster
{
	@Autowired
	LtMastComnMasterRepository ltMastComnMasterRepository;
	@Autowired
	LtMastComnMasterService ltMastComnMasterService;
	@Autowired
	LtMastComnMasterValuesRepository ltMastComnMasterValuesRepository;

	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	@Autowired
	LtMastComnMasterDao ltMastComnMasterDao;

	@Autowired
	LtMastComnMasterValuesService ltMastComnMasterValuesService;
	
	@Autowired
	LtMastComnMasterValuesDao ltMastComnMasterValuesDao;

	
	@Transactional
	@Override
	public ResponseEntity findByMasterName(String masterName) throws ServiceException{
		List<LtMastComnMaster> ltMastComnMaster =  ltMastComnMasterDao.findByMasterName(masterName);
		return new ResponseEntity(ltMastComnMaster, HttpStatus.OK); 
	}

	@Transactional
	@Override
	public ResponseEntity findByMasterDesc(String masterDesc) throws ServiceException{
		List<LtMastComnMaster> ltMastComnMaster  =  ltMastComnMasterDao.findByMasterDesc(masterDesc);
		return new ResponseEntity(ltMastComnMaster, HttpStatus.OK); 
	}

	@Transactional
	@Override
	public ResponseEntity findAllActive() throws ServiceException{
		List<LtMastComnMaster> ltMastComnMaster  =  ltMastComnMasterDao.findAllActive();
		return new ResponseEntity(ltMastComnMaster, HttpStatus.OK); 
	}

	@Transactional
	@Override
	public ResponseEntity findActiveLikeName(String masterName) throws ServiceException{
		List<LtMastComnMaster> ltMastComnMaster = ltMastComnMasterDao.findActiveLikeName(masterName);
		return new ResponseEntity(ltMastComnMaster, HttpStatus.OK); 
	}

	@Transactional
	@Override
	public CommonMasterWithValue getById(String id) throws ServiceException {
		return ltMastComnMasterDao.getById(id);
	}

	@Transactional
	@Override
	public List<LtMastComnMaster> getDataTable(LtMastComnMaster input) throws ServiceException 
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
		if(input.getColumnNo()==6 && input.getSort().equals("asc"))
		{
			input.setColumnNo(16);
		}
		if(input.getColumnNo()==0)
		{
			input.setColumnNo(1);
		}
		return ltMastComnMasterDao.getDataTable(input);
	}

	@Transactional
	@Override
	public Long getCount(LtMastComnMaster input) throws ServiceException{
		return ltMastComnMasterDao.getCount(input);
	}

	@Transactional
	@Override
	public ResponseEntity getLtMastComnMasterByID(Long commonMasterId) throws ServiceException {
		LtMastComnMaster ltMastComnMaster = ltMastComnMasterDao.getLtMastComnMasterByID(commonMasterId);
		List<LtMastComnMasterValues> comnMasterValuesList = ltMastComnMasterValuesService.getByValueCode(ltMastComnMaster.getStatus());
		if(!comnMasterValuesList.isEmpty() || comnMasterValuesList.size()>0)
		{
			ltMastComnMaster.setStatus(comnMasterValuesList.get(0).getValueName());
		}
		return new ResponseEntity(ltMastComnMaster, HttpStatus.OK); 
		//return ltMastComnMaster;
	}

	@Override
	public ResponseEntity saveMasterWithValue(CommonMasterWithValue commonMasterWithValue,BindingResult bindingResult)
	{
		Status status = new Status();
		String code=null;
		LtMastComnMaster ltMastComnMaster = commonMasterWithValue.getLtMastComnMaster();
		try 
		{
			List<LtMastComnMaster> ltMastComnMasterList = ltMastComnMasterDao.findActiveLikeName(ltMastComnMaster.getMasterName());
			if(ltMastComnMasterList.size() > 0 )
			{
				status.setCode(EXCEPTION);
				status.setMessage("Master name already exists.");
				return new ResponseEntity<Status>(status, HttpStatus.OK);
			}
			ltMastComnMaster.setStatus(ltMastComnMaster.getStatus().toUpperCase());
			ltMastComnMaster.setCreationDate(new Date());
			ltMastComnMaster.setLastUpdateDate(new Date());
			ltMastComnMaster.setCreatedBy(ltMastComnMaster.getLastUpdateLogin());
			ltMastComnMaster.setLastUpdatedBy(ltMastComnMaster.getLastUpdateLogin());
			ltMastComnMaster = ltMastComnMasterRepository.save(ltMastComnMaster);
			
		
			List<LtMastComnMasterValues> ltMastComnMasterValuesGet = commonMasterWithValue.getLtMastComnMasterValues();
			for (LtMastComnMasterValues ltMastComnMasterValues : ltMastComnMasterValuesGet) 
			{

				code=ltMastComnMasterValuesService.checkCommonMasterValuesDetails(ltMastComnMasterValues);
				if (code==null) 
				{
					
					ltMastComnMasterValues.setMasterId(ltMastComnMaster.getMasterId());
					ltMastComnMasterValues.setCreatedBy(ltMastComnMasterValues.getLastUpdateLogin());
					ltMastComnMasterValues.setCreationDate(new Date());
					ltMastComnMasterValues.setLastUpdateLogin(ltMastComnMasterValues.getLastUpdateLogin());
					ltMastComnMasterValues.setLastUpdateDate(new Date());
					ltMastComnMasterValues.setLastUpdatedBy(ltMastComnMasterValues.getLastUpdateLogin());
					if (ltMastComnMasterValues.getMasterId() == null) 
					{
						status=ltMastCommonMessageService.getCodeAndMessage(INSERT_FAIL);
						return new ResponseEntity<Status>(status, HttpStatus.OK);
					}
				
					ltMastComnMasterValuesRepository.save(ltMastComnMasterValues);
					
					
				} 
				else
				{
					status=ltMastCommonMessageService.getCodeAndMessage(INSERT_FAIL);
					return new ResponseEntity<Status>(status, HttpStatus.OK);
					
				}
	
			}
			status=ltMastCommonMessageService.getCodeAndMessage(INSERT_SUCCESSFULLY);
			if( status.getMessage()==null)
			{
				status.setCode(SUCCESS);
				status.setMessage("Error in finding message! The action is completed successfully.");
			}
			
			return new ResponseEntity<Status>(status, HttpStatus.OK);

		} 
		catch (NullPointerException e) 
		{
			throw new BusinessException(INPUT_IS_EMPTY, null, e);
		}
		catch (Exception e) 
		{
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}

	}

	@Override
	public ResponseEntity<Status> deleteLtMastComnMasterByID(String id) throws NumberFormatException, ServiceException {
		Status status=new Status();
		
			if (ltMastComnMasterRepository.exists(Long.parseLong(id)))
			{
				List<LtMastComnMasterValues> list =  ltMastComnMasterValuesDao.findByMasterId(Long.parseLong(id));
				if (list.isEmpty()) 
				{
					ltMastComnMasterRepository.delete(Long.parseLong(id));
				} 
				else
				{
					List<LtMastComnMasterValues> ltP2pComnMasterValuesList= ltMastComnMasterValuesDao.findByMasterId(Long.parseLong(id));
					if(ltP2pComnMasterValuesList!=null)
					{
						for(LtMastComnMasterValues ltMastComnMasterValues:ltP2pComnMasterValuesList)
						{
							ltMastComnMasterValuesRepository.delete(ltMastComnMasterValues.getComnMasterValuesId());
						}
					}
					ltMastComnMasterRepository.delete(Long.parseLong(id));
				}	
			}
			else
			{
				status=ltMastCommonMessageService.getCodeAndMessage(ENTITY_CANNOT_DELETE);
				return new ResponseEntity<Status>(status,HttpStatus.OK);
					
			} 
			status=ltMastCommonMessageService.getCodeAndMessage(DELETE_SUCCESSFULLY);
			
			return new ResponseEntity<Status>(status,HttpStatus.OK);
		}

	@Override
	public ResponseEntity<Status> updateMasterWithValue(CommonMasterWithValue commonMasterWithValue)
			throws ServiceException {
		Status status = new Status();
		LtMastComnMaster ltMastComnMaster = commonMasterWithValue.getLtMastComnMaster();
		
			if(ltMastComnMaster.getStartDate()==null || ltMastComnMaster.getMasterName()==null ||
					ltMastComnMaster.getLastUpdateLogin() == null )
			{
				status=ltMastCommonMessageService.getCodeAndMessage(INPUT_IS_EMPTY);
				return new ResponseEntity<Status>(status, HttpStatus.OK);
			}
			
			ltMastComnMaster.setStatus(ltMastComnMaster.getStatus());
			ltMastComnMaster.setLastUpdatedBy(ltMastComnMaster.getLastUpdateLogin());
			ltMastComnMaster.setLastUpdateDate(new Date());
			ltMastComnMaster.setLastUpdateLogin(ltMastComnMaster.getLastUpdateLogin());
			ltMastComnMaster = ltMastComnMasterRepository.save(ltMastComnMaster);
			
			List<LtMastComnMasterValues> ltP2pComnMasterValuesList = commonMasterWithValue.getLtMastComnMasterValues();
			if(!ltP2pComnMasterValuesList.isEmpty())
			{
				for (LtMastComnMasterValues ltMastComnMasterValues : ltP2pComnMasterValuesList) 
				{
					if(ltMastComnMasterValues.getMasterId()!=null)
					{
						
						ltMastComnMasterValues.setLastUpdateDate(new Date());
						ltMastComnMasterValues.setLastUpdateLogin(ltMastComnMasterValues.getLastUpdateLogin());
						ltMastComnMasterValues.setLastUpdatedBy(ltMastComnMasterValues.getLastUpdateLogin());
						ltMastComnMasterValuesRepository.save(ltMastComnMasterValues);
					}
					else
					{
						ltMastComnMasterValues.setCreationDate(new Date());
						ltMastComnMasterValues.setMasterId(ltMastComnMaster.getMasterId());
						ltMastComnMasterValues.setCreatedBy(ltMastComnMasterValues.getLastUpdateLogin());
						ltMastComnMasterValues.setLastUpdateDate(new Date());
						//ltMastComnMasterValues.setLastUpdateLogin(ltMastComnMasterValues.getLastUpdateLogin());
						ltMastComnMasterValues.setLastUpdatedBy(ltMastComnMasterValues.getLastUpdateLogin());
						ltMastComnMasterValuesRepository.save(ltMastComnMasterValues);
					}
			
				}
			}
			status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_SUCCESSFULLY);
			if(status.getMessage()==null)
			{
				status.setCode(EXCEPTION);
				status.setMessage("Error in finding message! The action is completed successfully.");
			}
			return new ResponseEntity<Status>(status, HttpStatus.OK);

		}

	@Override
	public ResponseEntity<Status> save(LtMastComnMaster ltMastComnMaster) throws ServiceException {
		Status status = new Status();
		String code=null;
		
			List<LtMastComnMaster> ltMastComnMasterList = ltMastComnMasterDao.findActiveLikeName(ltMastComnMaster.getMasterName());
			if(ltMastComnMasterList.size() > 0 )
			{
				status.setCode(EXCEPTION);
				status.setMessage("Master name already exists.");
				return new ResponseEntity<Status>(status, HttpStatus.OK);
			}
			ltMastComnMaster.setStatus(ltMastComnMaster.getStatus().toUpperCase());
			ltMastComnMaster.setCreationDate(new Date());
			ltMastComnMaster.setLastUpdateDate(new Date());
			ltMastComnMaster.setCreatedBy(ltMastComnMaster.getLastUpdateLogin());
			ltMastComnMaster.setLastUpdatedBy(ltMastComnMaster.getLastUpdateLogin());
			ltMastComnMaster = ltMastComnMasterRepository.save(ltMastComnMaster);
			
			if(ltMastComnMaster.getMasterId()!=null) {
			status=ltMastCommonMessageService.getCodeAndMessage(INSERT_SUCCESSFULLY);
			if( status.getMessage()==null)
			{
				status.setCode(SUCCESS);
				status.setMessage("Error in finding message! The action is completed successfully.");
			}
			status.setData(ltMastComnMaster.getMasterId());
			}
			else
			{
				status=ltMastCommonMessageService.getCodeAndMessage(INSERT_FAIL);
				return new ResponseEntity<Status>(status, HttpStatus.OK);
			}
			return new ResponseEntity<Status>(status, HttpStatus.OK);

		}

	@Override
	public ResponseEntity<Status> update(LtMastComnMaster ltMastComnMaster) throws ServiceException {
		Status status = new Status();
		
			if(ltMastComnMaster.getStartDate()==null || ltMastComnMaster.getMasterName()==null ||
					ltMastComnMaster.getLastUpdateLogin() == null || ltMastComnMaster.getMasterId() == null )
			{
				status=ltMastCommonMessageService.getCodeAndMessage(INPUT_IS_EMPTY);
				return new ResponseEntity<Status>(status, HttpStatus.OK);
			}
			
			
			ltMastComnMaster.setLastUpdatedBy(ltMastComnMaster.getLastUpdateLogin());
			ltMastComnMaster.setLastUpdateDate(new Date());
			ltMastComnMaster.setLastUpdateLogin(ltMastComnMaster.getLastUpdateLogin());
			ltMastComnMaster = ltMastComnMasterRepository.save(ltMastComnMaster);
		
			if(ltMastComnMaster.getMasterId()!=null) {
			status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_SUCCESSFULLY);
			if(status.getMessage()==null)
			{
				status.setCode(EXCEPTION);
				status.setMessage("Error in finding message! The action is completed successfully.");
			}
			}else {
				status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_FAIL);
			}
			return new ResponseEntity<Status>(status, HttpStatus.OK);

	}

	@Override
	public ResponseEntity<Status> delete(Long id) throws ServiceException {
		Status status=new Status();
		ltMastComnMasterValuesRepository.delete(id);
				
		if (! ltMastComnMasterValuesRepository.exists(id)) {
				status=ltMastCommonMessageService.getCodeAndMessage(DELETE_SUCCESSFULLY);
				if(status.getMessage()==null)
				{
					status.setCode(EXCEPTION);
					status.setMessage("Error in finding message! The action is completed successfully.");
				}
		}else {
					status=ltMastCommonMessageService.getCodeAndMessage(ENTITY_CANNOT_DELETE);
					return new ResponseEntity<Status>(status,HttpStatus.OK);
		}
		return new ResponseEntity<Status>(status,HttpStatus.OK);
			
	}

	@Override
	public List<LtMastComnMasterValues> getLikeNameWithMaster(String masterName, String valueName)
			throws ServiceException {
		return ltMastComnMasterValuesDao.getLikeNameWithMaster(masterName,valueName);
	} 
	
}
