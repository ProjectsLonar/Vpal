package com.lonar.vendor.vendorportal.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lonar.vendor.vendorportal.dao.LtVendCompanyDao;
import com.lonar.vendor.vendorportal.dao.LtVendCompanySistConcernDao;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtCompanyVenMgmtInclude;
import com.lonar.vendor.vendorportal.model.LtVendCompanySistConcern;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.repository.LtCompanyVenMgmtIncludeRepository;
import com.lonar.vendor.vendorportal.repository.LtVendCompanySistConcernRepository;

@Service
public class LtVendCompanySistConcernServiceImpl implements LtVendCompanySistConcernService,CodeMaster{

	@Autowired
	LtVendCompanyDao ltVendCompanyDao;
	
	@Autowired
	LtVendCompanySistConcernDao ltVendCompanySistConcernDao;
	
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	@Autowired
	LtVendCompanySistConcernRepository ltVendCompanySistConcernRepository;
	 
	@Autowired
	LtCompanyVenMgmtIncludeRepository ltCompanyVenMgmtIncludeRepository;
	
	@Override
	public List<LtVendCompanySistConcern> getBycompanyId(Long companyId) throws ServiceException {
		return ltVendCompanySistConcernDao.getBycompanyId(companyId);
	}

	@Override
	public LtVendCompanySistConcern getById(Long id) throws ServiceException {
		return ltVendCompanySistConcernDao.getById(id);
	}

	@Override
	public List<LtVendCompanySistConcern> getAll() throws ServiceException {
		return ltVendCompanySistConcernDao.getAll();
	}

	@Override
	public List<LtVendCompanySistConcern> getAllActive() throws ServiceException {
		return ltVendCompanySistConcernDao.getAllActive();
	}

	@Override
	public ResponseEntity<Status> save(LtVendCompanySistConcern ltVendCompanySistConcern) throws ServiceException {
		Status status = new Status();
		if(ltVendCompanySistConcern.getLastUpdateLogin() == null )
		{
			status=ltMastCommonMessageService.getCodeAndMessage(INPUT_IS_EMPTY);
			if( status.getMessage()==null) {
				status.setCode(EXCEPTION);
				status.setMessage("Error in finding message! The action is completed unsuccessfully.");
			}
		}
		//ltVendCompanySistConcern.setStartDate(new Date());
		ltVendCompanySistConcern.setCreationDate(new Date());
		ltVendCompanySistConcern.setLastUpdateDate(new Date());
		ltVendCompanySistConcern.setCreatedBy(ltVendCompanySistConcern.getLastUpdateLogin());
		ltVendCompanySistConcern.setLastUpdateLogin(ltVendCompanySistConcern.getLastUpdateLogin());
		ltVendCompanySistConcern.setLastUpdatedBy(ltVendCompanySistConcern.getLastUpdateLogin()); 
		ltVendCompanySistConcern = ltVendCompanySistConcernRepository.save(ltVendCompanySistConcern);
			if(ltVendCompanySistConcern.getCompSistConcernsId()!=null)
			{
				status=ltMastCommonMessageService.getCodeAndMessage(INSERT_SUCCESSFULLY);
				if( status.getMessage()==null) {
					status.setCode(SUCCESS);
					status.setMessage("Error in finding message! The action is completed successfully.");
				}
				status.setData(ltVendCompanySistConcern.getCompSistConcernsId());
			}
			else
			{
				status=ltMastCommonMessageService.getCodeAndMessage(INSERT_FAIL);
				if( status.getMessage()==null) {
					status.setCode(EXCEPTION);
					status.setMessage("Error in finding message! The action is completed unsuccessfully.");
				}
			}
		    return new ResponseEntity<Status>(status, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Status> update(LtVendCompanySistConcern ltVendCompanySistConcern)
			throws ServiceException {
		Status status = new Status();
		if(ltVendCompanySistConcern.getCompSistConcernsId()!=null) {
		
			if(ltVendCompanySistConcern.getIncludeVendor().equals("N") 
					&& ltVendCompanySistConcern.getMandatoryTab().equals("Y")) {
				status.setCode(INPUT_IS_EMPTY);
				status.setMessage("Please include the Tab to make it mandatory!");
				 return new ResponseEntity<Status>(status, HttpStatus.OK);
			}
			
			ltVendCompanySistConcern.setLastUpdateDate(new Date());
			ltVendCompanySistConcern.setStartDate(new Date());
			ltVendCompanySistConcern.setLastUpdateLogin(ltVendCompanySistConcern.getLastUpdateLogin());
			ltVendCompanySistConcern.setLastUpdatedBy(ltVendCompanySistConcern.getLastUpdateLogin()); 
			ltVendCompanySistConcern = ltVendCompanySistConcernRepository.save(ltVendCompanySistConcern);
			if(ltVendCompanySistConcern.getCompSistConcernsId()!=null)
			{
				updateCompanyVenSistConcern(ltVendCompanySistConcern.getCompanyId());
				status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_SUCCESSFULLY);
				if( status.getMessage()==null) {
					status.setCode(SUCCESS);
					status.setMessage("Error in finding message! The action is completed successfully.");
				}
			}
			else
			{
				status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_FAIL);
				if( status.getMessage()==null) {
					status.setCode(EXCEPTION);
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

	private void updateCompanyVenSistConcern(Long companyId) throws ServiceException {
		List<LtVendCompanySistConcern> ltVendCompanySistConcern = ltVendCompanySistConcernDao.getBycompanyId(companyId);
		List<LtCompanyVenMgmtInclude> list = ltVendCompanySistConcernDao.getCompanyVenSisConcernBycompanyId(companyId);
		if(!list.isEmpty()) {
			for(LtCompanyVenMgmtInclude ltCompanyVenMgmtInclude : list ) {
				String vendorStatus = ltVendCompanyDao.getVendorStatus(ltCompanyVenMgmtInclude.getVendorId());
				if(vendorStatus.equals("VENDOR_ACTIVE")) {
					if(ltVendCompanySistConcern.get(0).getIncludeVendor().equals("Y")) {
						ltCompanyVenMgmtInclude.setSistIncludeVendor(ltVendCompanySistConcern.get(0).getIncludeVendor());
						ltCompanyVenMgmtInclude.setSistMandatoryTab(ltVendCompanySistConcern.get(0).getMandatoryTab());
						ltCompanyVenMgmtInclude.setLastUpdateDate(new Date());
						ltCompanyVenMgmtIncludeRepository.save(ltCompanyVenMgmtInclude);
					}
				}else {
					ltCompanyVenMgmtInclude.setSistIncludeVendor(ltVendCompanySistConcern.get(0).getIncludeVendor());
					ltCompanyVenMgmtInclude.setSistMandatoryTab(ltVendCompanySistConcern.get(0).getMandatoryTab());
					ltCompanyVenMgmtInclude.setLastUpdateDate(new Date());
					ltCompanyVenMgmtIncludeRepository.save(ltCompanyVenMgmtInclude);
				}
			}
		}
	}

	@Override
	public ResponseEntity<Status> delete(long id) throws ServiceException {
		Status status = new Status();
		ltVendCompanySistConcernRepository.delete(id);
		if (!ltVendCompanySistConcernRepository.exists(id))
		{
			status=ltMastCommonMessageService.getCodeAndMessage(DELETE_SUCCESSFULLY);
			if( status.getMessage()==null) {
				status.setCode(SUCCESS);
				status.setMessage("Error in finding message! The action is completed successfully.");
			}
		} 
		else 
		{
			status=ltMastCommonMessageService.getCodeAndMessage(ENTITY_CANNOT_DELETE);
			if( status.getMessage()==null) {
				status.setCode(EXCEPTION);
				status.setMessage("Error in finding message! The action is completed unsuccessfully.");
			}
		} 
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}

}
