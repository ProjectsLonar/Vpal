package com.lonar.vendor.vendorportal.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lonar.vendor.vendorportal.dao.LtVendCompanyAttachmentsDao;
import com.lonar.vendor.vendorportal.dao.LtVendCompanyDao;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtCompanyVenMgmtAttachment;
import com.lonar.vendor.vendorportal.model.LtVendCompanyAttachments;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.repository.LtCompanyVenMgmtAttachmentRepository;
import com.lonar.vendor.vendorportal.repository.LtVendCompanyAttachmentsRepository;

@Service
public class LtVendCompanyAttachmentsServiceImpl implements LtVendCompanyAttachmentsService, CodeMaster{

	@Autowired
	LtVendCompanyDao ltVendCompanyDao;
	
	@Autowired
	LtVendCompanyAttachmentsDao ltVendCompanyAttachmentsDao;
	
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	@Autowired
	LtVendCompanyAttachmentsRepository LtVendCompanyAttachmentsRepository;
	
	@Autowired
	LtCompanyVenMgmtAttachmentRepository ltCompanyVenMgmtAttachmentRepository;
	
	@Override
	public List<LtVendCompanyAttachments> getBycompanyId(Long companyId) throws ServiceException {
		return ltVendCompanyAttachmentsDao.getBycompanyId( companyId);
	}

	@Override
	public LtVendCompanyAttachments getById(Long id) throws ServiceException {
		return ltVendCompanyAttachmentsDao.getById( id);
	}

	@Override
	public List<LtVendCompanyAttachments> getAll() throws ServiceException {
		return ltVendCompanyAttachmentsDao.getAll();
	}

	@Override
	public List<LtVendCompanyAttachments> getAllActive() throws ServiceException {
		return ltVendCompanyAttachmentsDao.getAllActive();
	}

	@Override
	public ResponseEntity<Status> save(LtVendCompanyAttachments ltVendCompanyAttachments) throws ServiceException {
		Status status = new Status();
		if( ltVendCompanyAttachments.getLastUpdateLogin() == null )
		{
			status=ltMastCommonMessageService.getCodeAndMessage(INPUT_IS_EMPTY);
			if( status.getMessage()==null) {
				status.setCode(EXCEPTION);
				status.setMessage("Error in finding message! The action is completed unsuccessfully.");
			}
		}
		ltVendCompanyAttachments.setCreationDate(new Date());
		ltVendCompanyAttachments.setLastUpdateDate(new Date());
	
		ltVendCompanyAttachments.setCreatedBy(ltVendCompanyAttachments.getLastUpdateLogin());
		ltVendCompanyAttachments.setLastUpdateLogin(ltVendCompanyAttachments.getLastUpdateLogin());
		ltVendCompanyAttachments.setLastUpdatedBy(ltVendCompanyAttachments.getLastUpdateLogin()); 
		ltVendCompanyAttachments = LtVendCompanyAttachmentsRepository.save(ltVendCompanyAttachments);
			if(ltVendCompanyAttachments.getCompAttachmentId()!=null)
			{
				LtVendCompanyAttachmentsThread vendCompanyAttachmentsThread =
						new LtVendCompanyAttachmentsThread(ltVendCompanyAttachments.getCompanyId(),
								ltVendCompanyAttachmentsDao,ltCompanyVenMgmtAttachmentRepository,ltVendCompanyDao);
				Thread t1 =new Thread(vendCompanyAttachmentsThread);  
				t1.start();
				//updateCompanyVendAttachments(ltVendCompanyAttachments.getCompanyId());
				status=ltMastCommonMessageService.getCodeAndMessage(INSERT_SUCCESSFULLY);
				if( status.getMessage()==null) {
					status.setCode(SUCCESS);
					status.setMessage("Error in finding message! The action is completed successfully.");
				}
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

	private void updateCompanyVendAttachments(Long companyId) throws ServiceException {
		List<LtVendCompanyAttachments> ltVendCompanyAttachments = ltVendCompanyAttachmentsDao.getBycompanyId(companyId);
		
		List<LtCompanyVenMgmtAttachment> list = ltVendCompanyAttachmentsDao.getCompanyVendAttachmentByCompanyId(companyId);
		if(!list.isEmpty()) {
			for(LtCompanyVenMgmtAttachment ltCompanyVenMgmtAttachment : list) {
				
				Long vendorId = ltCompanyVenMgmtAttachment.getVendorId();
				if(ltVendCompanyAttachmentsDao.deleteCompanyVendAttachmentByVendorCompanyId(companyId,vendorId)) {
					
					for(LtVendCompanyAttachments ltVendCompanyAttachment : ltVendCompanyAttachments) {
						LtCompanyVenMgmtAttachment companyVenMgmtAttachment = new LtCompanyVenMgmtAttachment();
						companyVenMgmtAttachment.setCompAttachmentId(ltVendCompanyAttachment.getCompAttachmentId());
						companyVenMgmtAttachment.setCompanyId(companyId);
						companyVenMgmtAttachment.setVendorId(vendorId);
						companyVenMgmtAttachment.setIncludeVendor(ltVendCompanyAttachment.getIncludeVendor());
						companyVenMgmtAttachment.setMandatoryTab(ltVendCompanyAttachment.getMandatoryTab());
						companyVenMgmtAttachment.setAttachmentName(ltVendCompanyAttachment.getAttachmentName());
					//	companyVenMgmtAttachment.setAttachmentMandatory(ltVendCompanyAttachment.get);
						companyVenMgmtAttachment.setCreationDate(new Date());
						companyVenMgmtAttachment.setLastUpdateDate(new Date());
				
						ltCompanyVenMgmtAttachmentRepository.save(companyVenMgmtAttachment);
					}
					
				}
				
				
			}
		}
		
		
		
	}

	@Override
	public ResponseEntity<Status> update(LtVendCompanyAttachments ltVendCompanyAttachments) throws ServiceException {
		Status status = new Status();
		if(ltVendCompanyAttachments.getCompAttachmentId()!=null) {
		
			ltVendCompanyAttachments.setLastUpdateDate(new Date());
			ltVendCompanyAttachments.setLastUpdateLogin(ltVendCompanyAttachments.getLastUpdateLogin());
			ltVendCompanyAttachments.setLastUpdatedBy(ltVendCompanyAttachments.getLastUpdateLogin()); 
			ltVendCompanyAttachments = LtVendCompanyAttachmentsRepository.save(ltVendCompanyAttachments);
			if(ltVendCompanyAttachments.getCompAttachmentId()!=null)
			{
				LtVendCompanyAttachmentsThread vendCompanyAttachmentsThread =
						new LtVendCompanyAttachmentsThread(ltVendCompanyAttachments.getCompanyId(),
								ltVendCompanyAttachmentsDao,ltCompanyVenMgmtAttachmentRepository,ltVendCompanyDao);
				Thread t1 =new Thread(vendCompanyAttachmentsThread);  
				t1.start(); 
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

	@Override
	public ResponseEntity<Status> delete(Long id) throws ServiceException {
		Status status = new Status();
		LtVendCompanyAttachments ltVendCompanyAttachment= LtVendCompanyAttachmentsRepository.findOne(id);
		LtVendCompanyAttachmentsRepository.delete(id);
		if (!LtVendCompanyAttachmentsRepository.exists(id))
		{
			LtVendCompanyAttachmentsThread vendCompanyAttachmentsThread =
					new LtVendCompanyAttachmentsThread(ltVendCompanyAttachment.getCompanyId(),
							ltVendCompanyAttachmentsDao,ltCompanyVenMgmtAttachmentRepository,ltVendCompanyDao);
			Thread t1 =new Thread(vendCompanyAttachmentsThread);  
			t1.start(); 
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
