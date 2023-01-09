package com.lonar.vendor.vendorportal.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lonar.vendor.vendorportal.dao.LtVendCompanyDao;
import com.lonar.vendor.vendorportal.dao.LtVendCompanyMgmtDdetailsDao;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtCompanyVenMgmtInclude;
import com.lonar.vendor.vendorportal.model.LtVendCompanyMgmtDdetails;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.repository.LtCompanyVenMgmtIncludeRepository;
import com.lonar.vendor.vendorportal.repository.LtVendCompanyMgmtDdetailsRepository;

@Service
public class LtVendCompanyMgmtDdetailsServiceImpl implements LtVendCompanyMgmtDdetailsService, CodeMaster {

	@Autowired
	LtVendCompanyDao ltVendCompanyDao;
	
	@Autowired
	LtVendCompanyMgmtDdetailsDao ltVendCompanyMgmtDdetailsDao;
	
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	@Autowired
	LtVendCompanyMgmtDdetailsRepository ltVendCompanyMgmtDdetailsRepository;
	
	@Autowired
	LtCompanyVenMgmtIncludeRepository ltCompanyVenMgmtIncludeRepository;
	
	@Override
	public List<LtVendCompanyMgmtDdetails> getBycompanyId(Long companyId) {
		return ltVendCompanyMgmtDdetailsDao.getBycompanyId(companyId);
	}

	@Override
	public LtVendCompanyMgmtDdetails getById(Long id) {
		return ltVendCompanyMgmtDdetailsDao.getById(id);
	}

	@Override
	public List<LtVendCompanyMgmtDdetails> getAll() {
		return ltVendCompanyMgmtDdetailsDao.getAll();
	}

	@Override
	public List<LtVendCompanyMgmtDdetails> getAllActive() {
		return ltVendCompanyMgmtDdetailsDao.getAllActive();
	}

	@Override
	public ResponseEntity<Status> save(LtVendCompanyMgmtDdetails ltVendCompanyMgmtDdetails) {
		Status status = new Status();
		if(ltVendCompanyMgmtDdetails.getLastUpdateLogin() == null )
		{
			status=ltMastCommonMessageService.getCodeAndMessage(INPUT_IS_EMPTY);
			if( status.getMessage()==null) {
				status.setCode(EXCEPTION);
				status.setMessage("Error in finding message! The action is completed unsuccessfully.");
			}
		}
		ltVendCompanyMgmtDdetails.setStartDate(new Date());
		ltVendCompanyMgmtDdetails.setCreationDate(new Date());
		ltVendCompanyMgmtDdetails.setLastUpdateDate(new Date());
		ltVendCompanyMgmtDdetails.setCreatedBy(ltVendCompanyMgmtDdetails.getLastUpdateLogin());
		ltVendCompanyMgmtDdetails.setLastUpdateLogin(ltVendCompanyMgmtDdetails.getLastUpdateLogin());
		ltVendCompanyMgmtDdetails.setLastUpdatedBy(ltVendCompanyMgmtDdetails.getLastUpdateLogin()); 
		ltVendCompanyMgmtDdetails = ltVendCompanyMgmtDdetailsRepository.save(ltVendCompanyMgmtDdetails);
			if(ltVendCompanyMgmtDdetails.getCompMgmtId()!=null)
			{
				status=ltMastCommonMessageService.getCodeAndMessage(INSERT_SUCCESSFULLY);
				if( status.getMessage()==null) {
					status.setCode(SUCCESS);
					status.setMessage("Error in finding message! The action is completed successfully.");
				}
				status.setData(ltVendCompanyMgmtDdetails.getCompMgmtId());
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
	public ResponseEntity<Status> update(LtVendCompanyMgmtDdetails ltVendCompanyMgmtDdetails) throws ServiceException {
		Status status = new Status();
		if(ltVendCompanyMgmtDdetails.getCompMgmtId()!=null) {
		
			if(ltVendCompanyMgmtDdetails.getIncludeVendor().equals("N") 
					&& ltVendCompanyMgmtDdetails.getMandatoryTab().equals("Y")) {
				status.setCode(INPUT_IS_EMPTY);
				status.setMessage("Please include the Tab to make it mandatory!");
				 return new ResponseEntity<Status>(status, HttpStatus.OK);
			}
			ltVendCompanyMgmtDdetails.setLastUpdateDate(new Date());
			ltVendCompanyMgmtDdetails.setStartDate(new Date());
			ltVendCompanyMgmtDdetails.setLastUpdateLogin(ltVendCompanyMgmtDdetails.getLastUpdateLogin());
			ltVendCompanyMgmtDdetails.setLastUpdatedBy(ltVendCompanyMgmtDdetails.getLastUpdateLogin()); 
			ltVendCompanyMgmtDdetails = ltVendCompanyMgmtDdetailsRepository.save(ltVendCompanyMgmtDdetails);
			if(ltVendCompanyMgmtDdetails.getCompMgmtId()!=null)
			{
				updateVendorCompanyMgmt(ltVendCompanyMgmtDdetails.getCompanyId());
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

	private void updateVendorCompanyMgmt(Long companyId) throws ServiceException {
		List<LtVendCompanyMgmtDdetails> ltVendCompanyMgmtDdetails = ltVendCompanyMgmtDdetailsDao.getBycompanyId(companyId);
		List<LtCompanyVenMgmtInclude> list = ltVendCompanyMgmtDdetailsDao.getManagementBycompanyId(companyId);
		if(!list.isEmpty()) {
			for(LtCompanyVenMgmtInclude ltCompanyVenMgmtInclude : list ) {
				String vendorStatus = ltVendCompanyDao.getVendorStatus(ltCompanyVenMgmtInclude.getVendorId());
				if(vendorStatus.equals("VENDOR_ACTIVE")) {
					if(ltVendCompanyMgmtDdetails.get(0).getIncludeVendor().equals("Y")) {
						ltCompanyVenMgmtInclude.setMgmtIncludeVendor(ltVendCompanyMgmtDdetails.get(0).getIncludeVendor());
						ltCompanyVenMgmtInclude.setMgmtMandatoryTab(ltVendCompanyMgmtDdetails.get(0).getMandatoryTab());
						ltCompanyVenMgmtInclude.setLastUpdateDate(new Date());
						ltCompanyVenMgmtIncludeRepository.save(ltCompanyVenMgmtInclude);
					}
				}else {
					ltCompanyVenMgmtInclude.setMgmtIncludeVendor(ltVendCompanyMgmtDdetails.get(0).getIncludeVendor());
					ltCompanyVenMgmtInclude.setMgmtMandatoryTab(ltVendCompanyMgmtDdetails.get(0).getMandatoryTab());
					ltCompanyVenMgmtInclude.setLastUpdateDate(new Date());
					ltCompanyVenMgmtIncludeRepository.save(ltCompanyVenMgmtInclude);
				}
				
				/*ltCompanyVenMgmtInclude.setMgmtIncludeVendor(ltVendCompanyMgmtDdetails.get(0).getIncludeVendor());
				ltCompanyVenMgmtInclude.setMgmtMandatoryTab(ltVendCompanyMgmtDdetails.get(0).getMandatoryTab());
				ltCompanyVenMgmtInclude.setLastUpdateDate(new Date());
				ltCompanyVenMgmtIncludeRepository.save(ltCompanyVenMgmtInclude);*/
			}
		}
		
		
		
	}

	@Override
	public ResponseEntity<Status> delete(Long id) {
		Status status = new Status();
		ltVendCompanyMgmtDdetailsRepository.delete(id);
		if (!ltVendCompanyMgmtDdetailsRepository.exists(id))
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
