package com.lonar.vendor.vendorportal.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Date;
import java.util.List;

import javax.jdo.annotations.Transactional;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lonar.vendor.vendorportal.dao.LtMastEmployeesDao;
import com.lonar.vendor.vendorportal.dao.LtMastModulesDao;
import com.lonar.vendor.vendorportal.dao.LtMastRoleModulesDao;
import com.lonar.vendor.vendorportal.dao.LtMastRolesDao;
import com.lonar.vendor.vendorportal.dao.LtMastUsersDao;
import com.lonar.vendor.vendorportal.dao.LtMastVendorAgreementsDao;
import com.lonar.vendor.vendorportal.dao.LtMastVendorBanksDao;
import com.lonar.vendor.vendorportal.dao.LtMastVendorClientsDao;
import com.lonar.vendor.vendorportal.dao.LtMastVendorContactsDao;
import com.lonar.vendor.vendorportal.dao.LtMastVendorHsnSacCodesDao;
import com.lonar.vendor.vendorportal.dao.LtMastVendorManagementsDao;
import com.lonar.vendor.vendorportal.dao.LtMastVendorMiscInfoDao;
import com.lonar.vendor.vendorportal.dao.LtMastVendorMiscQuestionsDao;
import com.lonar.vendor.vendorportal.dao.LtMastVendorSisterConcernsDao;
import com.lonar.vendor.vendorportal.dao.LtMastVendorsAddressDao;
import com.lonar.vendor.vendorportal.dao.LtMastVendorsDao;
import com.lonar.vendor.vendorportal.dao.LtVendCompanyAttachmentsDao;
import com.lonar.vendor.vendorportal.dao.LtVendCompanyClientDetailsDao;
import com.lonar.vendor.vendorportal.dao.LtVendCompanyCocDao;
import com.lonar.vendor.vendorportal.dao.LtVendCompanyMgmtDdetailsDao;
import com.lonar.vendor.vendorportal.dao.LtVendCompanyMiscellaneousDao;
import com.lonar.vendor.vendorportal.dao.LtVendCompanySistConcernDao;
import com.lonar.vendor.vendorportal.dao.LtVendMiscQuestionsDao;
import com.lonar.vendor.vendorportal.dao.LtVendorApprovalDao;
import com.lonar.vendor.vendorportal.model.LtCompanyVenMgmtAttachment;
import com.lonar.vendor.vendorportal.model.LtCompanyVenMgmtCoc;
import com.lonar.vendor.vendorportal.model.LtCompanyVenMgmtInclude;
import com.lonar.vendor.vendorportal.model.LtCompanyVenMgmtMisc;
import com.lonar.vendor.vendorportal.model.LtCompanyVenMgmtMiscQues;
import com.lonar.vendor.vendorportal.model.LtMastEmailtoken;
import com.lonar.vendor.vendorportal.model.LtMastEmployees;
import com.lonar.vendor.vendorportal.model.LtMastModules;
import com.lonar.vendor.vendorportal.model.LtMastRoleModules;
import com.lonar.vendor.vendorportal.model.LtMastRoles;
import com.lonar.vendor.vendorportal.model.LtMastUserRoles;
import com.lonar.vendor.vendorportal.model.LtMastUsers;
import com.lonar.vendor.vendorportal.model.LtMastVendorAddress;
import com.lonar.vendor.vendorportal.model.LtMastVendorAgreements;
import com.lonar.vendor.vendorportal.model.LtMastVendorBanks;
import com.lonar.vendor.vendorportal.model.LtMastVendorClients;
import com.lonar.vendor.vendorportal.model.LtMastVendorContacts;
import com.lonar.vendor.vendorportal.model.LtMastVendorHsnSacCodes;
import com.lonar.vendor.vendorportal.model.LtMastVendorManagements;
import com.lonar.vendor.vendorportal.model.LtMastVendorSisterConcerns;
import com.lonar.vendor.vendorportal.model.LtMastVendors;
import com.lonar.vendor.vendorportal.model.LtVendCompanyAttachments;
import com.lonar.vendor.vendorportal.model.LtVendCompanyClientDetails;
import com.lonar.vendor.vendorportal.model.LtVendCompanyCoc;
import com.lonar.vendor.vendorportal.model.LtVendCompanyMgmtDdetails;
import com.lonar.vendor.vendorportal.model.LtVendCompanyMiscellaneous;
import com.lonar.vendor.vendorportal.model.LtVendCompanySistConcern;
import com.lonar.vendor.vendorportal.model.LtVendMiscQuestions;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.model.SysVariableWithValues;
import com.lonar.vendor.vendorportal.model.VendorList;
import com.lonar.vendor.vendorportal.repository.LtCompanyVenMgmtAttachmentRepository;
import com.lonar.vendor.vendorportal.repository.LtCompanyVenMgmtCocRepository;
import com.lonar.vendor.vendorportal.repository.LtCompanyVenMgmtIncludeRepository;
import com.lonar.vendor.vendorportal.repository.LtCompanyVenMgmtMiscQuesRepository;
import com.lonar.vendor.vendorportal.repository.LtCompanyVenMgmtMiscRepository;
import com.lonar.vendor.vendorportal.repository.LtMastEmailtokenRepository;
import com.lonar.vendor.vendorportal.repository.LtMastModulesRepository;
import com.lonar.vendor.vendorportal.repository.LtMastRoleModulesRepository;
import com.lonar.vendor.vendorportal.repository.LtMastRolesRepository;
import com.lonar.vendor.vendorportal.repository.LtMastUserRolesRepository;
import com.lonar.vendor.vendorportal.repository.LtMastUsersRepository;
import com.lonar.vendor.vendorportal.repository.LtMastVendorsRepository;

@Service
@PropertySource(value = "classpath:serverurl.properties", ignoreResourceNotFound = true)
public class LtMastVendorsServiceImpl implements LtMastVendorsService
{
	@Autowired
	private Environment env;
	
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	@Autowired
	LtMastVendorsDao ltMastVendorsDao;
	
	@Autowired
	LtMastEmployeesDao ltMastEmployeesDao;
	
	@Autowired
	LtMastVendorAgreementsDao ltMastVendorAgreementsDao;
	
	@Autowired
	LtMastVendorsAddressDao ltMastVendorsAddressDao;
	
	@Autowired
	LtMastVendorBanksDao ltMastVendorBanksDao;
	
	@Autowired
	LtMastVendorHsnSacCodesDao ltMastVendorHsnSacCodesDao;
	
	@Autowired
	LtMastVendorContactsDao ltMastVendorContactsDao;
	
	@Autowired
	LtMastVendorManagementsDao ltMastVendorManagementsDao;
	
	@Autowired
	LtMastVendorMiscInfoDao ltMastVendorMiscInfoDao;
	
	@Autowired
	LtMastVendorMiscQuestionsDao ltMastVendorMiscQuestionsDao;
	
	@Autowired
	LtMastVendorSisterConcernsDao ltMastVendorSisterConcernsDao;
	
	@Autowired
	LtMastVendorClientsDao ltMastVendorClientsDao;
	
	@Autowired
	LtVendorApprovalDao ltVendorApprovalDao;
	
	LtMastVendorsServiceImpl ltMastVendorsServiceImpl;
	
	@Autowired
	LtMastUsersDao ltMastUsersDao;
	
	@Autowired
	LtVendCompanyCocDao ltVendCompanyCocDao;
	
	@Autowired
	LtCompanyVenMgmtCocRepository ltCompanyVenMgmtCocRepository;
	
	@Autowired
	LtVendCompanyMgmtDdetailsDao ltVendCompanyMgmtDdetailsDao;
	
	@Autowired
	LtVendCompanyClientDetailsDao ltVendCompanyClientDetailsDao;
	
	@Autowired
	LtVendCompanySistConcernDao ltVendCompanySistConcernDao;
	
	@Autowired
	LtCompanyVenMgmtIncludeRepository ltCompanyVenMgmtIncludeRepository;
	
	@Autowired
	LtVendCompanyAttachmentsDao ltVendCompanyAttachmentsDao;
	
	@Autowired
	LtCompanyVenMgmtAttachmentRepository ltCompanyVenMgmtAttachmentRepository;
	
	@Autowired
	LtVendCompanyMiscellaneousDao ltVendCompanyMiscellaneousDao;
	
	@Autowired
	LtCompanyVenMgmtMiscRepository ltCompanyVenMgmtMiscRepository;
	
	@Autowired
	LtVendMiscQuestionsDao ltVendMiscQuestionsDao;
	
	@Autowired
	LtCompanyVenMgmtMiscQuesRepository ltCompanyVenMgmtMiscQuesRepository;
	
	@Autowired
	LtMastVendorsRepository ltMastVendorsRepository;
	
	@Autowired
	LtMastUsersRepository ltMastUsersRepository;
	
	@Autowired
	LtMastRolesRepository ltMastRolesRepository;
	
	@Autowired
	LtMastModulesRepository ltMastModulesRepository;
	
	@Autowired
	LtMastEmailtokenRepository ltMastEmailtokenRepository;
	
	@Autowired
	LtMastRoleModulesRepository ltMastRoleModulesRepository;
	
	@Autowired
	LtMastUserRolesRepository ltMastUserRolesRepository;
	
	private SecureRandom random = new SecureRandom();
	
	@Autowired
	LtMastModulesDao ltMastModulesDao;
	
	@Autowired
	LtMastRolesDao ltMastRolesDao;
	
	@Autowired
	LtMastRoleModulesDao ltMastRoleModulesDao;
	
	@Autowired
	LtMastSysVariablesService ltMastSysVariablesService;
	
	@Transactional
	@Override
	public List<LtMastVendors> getAllVendors() throws ServiceException 
	{
		 List<LtMastVendors> vendorList=ltMastVendorsDao.getAllVendors();
		return vendorList;
	}

	@Transactional
	@Override
	public List<LtMastVendors> getAllActiveVendors() throws ServiceException 
	{
		List<LtMastVendors> vendorList=ltMastVendorsDao.getAllActiveVendors();
		return vendorList;
	}
	
	@Transactional
	@Override
	public List<LtMastVendors> getActiveVendorByName(Long companyId,String vendorName) throws ServiceException
	{
		List<LtMastVendors> vendorList=ltMastVendorsDao.getActiveVendorByName(companyId,vendorName);
		
		return vendorList;
	}
	
	@Transactional
	@Override
	public LtMastVendors getVendorById(Long vendorId) throws ServiceException  
	{
		LtMastVendors vendor=ltMastVendorsDao.getVendorById(vendorId);
		if(vendor!=null) {
		if(vendor.getInitiatorId()!=null)
		{
			List<LtMastEmployees> ltMastEmployees=ltMastEmployeesDao.getByEmpId(vendor.getInitiatorId());
			if(!ltMastEmployees.isEmpty())
			{
				vendor.setInitiatorName(ltMastEmployees.get(0).getFirstName()
						+" "+ltMastEmployees.get(0).getLastName()+"("+ltMastEmployees.get(0).getEmployeeNumber()+")");
			}
		}
		}
		return vendor;
	}

	@Transactional
	@Override
	public Status save(LtMastVendors vendors) throws ServiceException 
	{
		Status status=new Status();
			String chknull=checkNull(vendors);
			if(chknull.equals("null"))
			{
				status=ltMastCommonMessageService.getCodeAndMessage(INPUT_IS_EMPTY);
				if(status.getMessage()==null)
				{
					status.setCode(EXCEPTION);
					status.setMessage("Error in finding message! The action was unsuccessful");
				}
			}
			else
			{
				String chkDuplicate=checkDuplicate(vendors);
				if(chkDuplicate==null)
				{
					List<LtMastEmployees> ltMastEmployees=ltMastEmployeesDao.getByEmpId(vendors.getInitiatorId());
					if(!ltMastEmployees.isEmpty()) {
						vendors.setDivisionId(ltMastEmployees.get(0).getDivisionId());
					}
					Long venId=ltMastVendorsDao.save(vendors);
					if(venId!=null)
					{
						if(!ltVendorApprovalDao.chkForApprovers(venId)) {
						if(!ltMastVendorsDao.loadApprovers(venId,vendors.getCompanyId())){
						
							 
							status=ltMastCommonMessageService.getCodeAndMessage(INTERNAL_SERVER_ERROR);
							if( status.getMessage()==null)
							{
								status.setCode(SUCCESS);
								status.setMessage("Error in finding message! The action is completed unsuccessfully.");
							}
							return status;
						 }
						}
						
						if(loadCompanyDetailsForVendor(venId,vendors.getCompanyId(),vendors.getLastUpdateLogin())) {
						
							status=ltMastCommonMessageService.getCodeAndMessage(INSERT_SUCCESSFULLY);
							if( status.getMessage()==null)
							{
								status.setCode(SUCCESS);
								status.setMessage("Error in finding message! The action is completed successfully.");
							}
							status.setData(venId);
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
				}
				else
				{
					status.setCode(EXCEPTION);
					status.setMessage(chkDuplicate);
				}
			}
			
			return status;
	}
	
	private boolean loadCompanyDetailsForVendor(Long venId, Long companyId, Long lastUpdateLogin) throws ServiceException 
	{
		List<LtVendCompanyCoc> ltVendCompanyCoc = ltVendCompanyCocDao.getBycompanyId(companyId);
		if(!ltVendCompanyCoc.isEmpty()) {
			LtCompanyVenMgmtCoc ltCompanyVenMgmtCoc = new LtCompanyVenMgmtCoc();
			ltCompanyVenMgmtCoc.setCompConductId(ltVendCompanyCoc.get(0).getCompConductId());
			ltCompanyVenMgmtCoc.setCompanyId(companyId);
			ltCompanyVenMgmtCoc.setVendorId(venId);
			ltCompanyVenMgmtCoc.setCodeConductId(ltVendCompanyCoc.get(0).getCodeConductId());
			ltCompanyVenMgmtCoc.setIncludeVendor(ltVendCompanyCoc.get(0).getIncludeVendor());
			ltCompanyVenMgmtCoc.setMandatoryTab(ltVendCompanyCoc.get(0).getMandatoryTab());
			ltCompanyVenMgmtCoc.setStartDate(ltVendCompanyCoc.get(0).getStartDate());
			ltCompanyVenMgmtCoc.setEndDate(ltVendCompanyCoc.get(0).getEndDate());
			ltCompanyVenMgmtCoc.setCreatedBy(ltVendCompanyCoc.get(0).getCreatedBy());
			ltCompanyVenMgmtCoc.setCreationDate(new Date());
			ltCompanyVenMgmtCoc.setLastUpdateDate(new Date());
			ltCompanyVenMgmtCoc.setLastUpdatedBy(ltVendCompanyCoc.get(0).getLastUpdatedBy());
			ltCompanyVenMgmtCoc.setLastUpdateLogin(ltVendCompanyCoc.get(0).getLastUpdateLogin());
			ltCompanyVenMgmtCocRepository.save(ltCompanyVenMgmtCoc);
		}else {
			LtCompanyVenMgmtCoc ltCompanyVenMgmtCoc = new LtCompanyVenMgmtCoc();
			//ltCompanyVenMgmtCoc.setCompConductId(ltVendCompanyCoc.get(0).getCompConductId());
			ltCompanyVenMgmtCoc.setCompanyId(companyId);
			ltCompanyVenMgmtCoc.setVendorId(venId);
			//ltCompanyVenMgmtCoc.setCodeConductId(null);
			ltCompanyVenMgmtCoc.setIncludeVendor("N");
			ltCompanyVenMgmtCoc.setMandatoryTab("N");
			ltCompanyVenMgmtCoc.setStartDate(new Date());
			ltCompanyVenMgmtCoc.setCreatedBy(lastUpdateLogin);
			ltCompanyVenMgmtCoc.setCreationDate(new Date());
			ltCompanyVenMgmtCoc.setLastUpdateDate(new Date());
			ltCompanyVenMgmtCoc.setLastUpdatedBy(lastUpdateLogin);
			ltCompanyVenMgmtCoc.setLastUpdateLogin(lastUpdateLogin);
			ltCompanyVenMgmtCocRepository.save(ltCompanyVenMgmtCoc);
		}
		//===================================================================================================
		LtCompanyVenMgmtInclude ltCompanyVenMgmtInclude = new LtCompanyVenMgmtInclude();
		ltCompanyVenMgmtInclude.setCompanyId(companyId);
		ltCompanyVenMgmtInclude.setVendorId(venId);
		ltCompanyVenMgmtInclude.setCreationDate(new Date());
		ltCompanyVenMgmtInclude.setLastUpdateDate(new Date());
		ltCompanyVenMgmtInclude.setStartDate(new Date());
		
		List<LtVendCompanyMgmtDdetails> ltVendCompanyMgmtDdetails = ltVendCompanyMgmtDdetailsDao.getBycompanyId(companyId);
		if(!ltVendCompanyMgmtDdetails.isEmpty()) {
			ltCompanyVenMgmtInclude.setCompMgmtId(ltVendCompanyMgmtDdetails.get(0).getCompMgmtId());
			ltCompanyVenMgmtInclude.setMgmtIncludeVendor(ltVendCompanyMgmtDdetails.get(0).getIncludeVendor());
			ltCompanyVenMgmtInclude.setMgmtMandatoryTab(ltVendCompanyMgmtDdetails.get(0).getMandatoryTab());
		}
		
		List<LtVendCompanyClientDetails> ltVendCompanyClientDetails = ltVendCompanyClientDetailsDao.getBycompanyId(companyId);
		if(!ltVendCompanyClientDetails.isEmpty()) {
			ltCompanyVenMgmtInclude.setCompClientId(ltVendCompanyClientDetails.get(0).getCompClientId());
			ltCompanyVenMgmtInclude.setClientIncludeVendor(ltVendCompanyClientDetails.get(0).getIncludeVendor());
			ltCompanyVenMgmtInclude.setClientMandatoryTab(ltVendCompanyClientDetails.get(0).getMandatoryTab());
		}
		
		List<LtVendCompanySistConcern> ltVendCompanySistConcern = ltVendCompanySistConcernDao.getBycompanyId(companyId);
		if(!ltVendCompanySistConcern.isEmpty()) {
			ltCompanyVenMgmtInclude.setCompSistConcernsId(ltVendCompanySistConcern.get(0).getCompSistConcernsId());
			ltCompanyVenMgmtInclude.setSistIncludeVendor(ltVendCompanySistConcern.get(0).getIncludeVendor());
			ltCompanyVenMgmtInclude.setSistMandatoryTab(ltVendCompanySistConcern.get(0).getMandatoryTab());
		}
		
		ltCompanyVenMgmtInclude.setCreatedBy(lastUpdateLogin);
		ltCompanyVenMgmtInclude.setLastUpdatedBy(lastUpdateLogin);
		ltCompanyVenMgmtInclude.setLastUpdateLogin(lastUpdateLogin);
		ltCompanyVenMgmtIncludeRepository.save(ltCompanyVenMgmtInclude);
		//======================================================================================================
		List<LtVendCompanyAttachments> ltVendCompanyAttachments = ltVendCompanyAttachmentsDao.getBycompanyId(companyId);
		if(!ltVendCompanyAttachments.isEmpty()) {
			for(LtVendCompanyAttachments ltVendCompanyAttachment : ltVendCompanyAttachments) {
				
				LtCompanyVenMgmtAttachment ltCompanyVenMgmtAttachment = new LtCompanyVenMgmtAttachment();
				ltCompanyVenMgmtAttachment.setCompAttachmentId(ltVendCompanyAttachment.getCompAttachmentId());
				ltCompanyVenMgmtAttachment.setCompanyId(companyId);
				ltCompanyVenMgmtAttachment.setVendorId(venId);
				ltCompanyVenMgmtAttachment.setIncludeVendor(ltVendCompanyAttachment.getInclude_Vendor());
				ltCompanyVenMgmtAttachment.setMandatoryTab(ltVendCompanyAttachment.getMandatoryTab());
				ltCompanyVenMgmtAttachment.setAttachmentName(ltVendCompanyAttachment.getAttachmentName());
				ltCompanyVenMgmtAttachment.setAttachmentMandatory(ltVendCompanyAttachment.getAttachmentMandatory());
				ltCompanyVenMgmtAttachment.setCreationDate(new Date());
				ltCompanyVenMgmtAttachment.setLastUpdateDate(new Date());
				ltCompanyVenMgmtAttachment.setCreatedBy(lastUpdateLogin);
				ltCompanyVenMgmtAttachment.setLastUpdatedBy(lastUpdateLogin);
				ltCompanyVenMgmtAttachment.setLastUpdateLogin(lastUpdateLogin);
				ltCompanyVenMgmtAttachmentRepository.save(ltCompanyVenMgmtAttachment);
			}
		}
		//================================================================================================
		LtVendCompanyMiscellaneous ltVendCompanyMiscellaneous = ltVendCompanyMiscellaneousDao.getBycompanyId(companyId);
		if(ltVendCompanyMiscellaneous!=null) {
				LtCompanyVenMgmtMisc ltCompanyVenMgmtMisc = new LtCompanyVenMgmtMisc();
				ltCompanyVenMgmtMisc.setCompMiscellaneousId(ltVendCompanyMiscellaneous.getCompMiscellaneousId());
				ltCompanyVenMgmtMisc.setCompanyId(companyId);
				ltCompanyVenMgmtMisc.setVendorId(venId);
				ltCompanyVenMgmtMisc.setIncludeVendor(ltVendCompanyMiscellaneous.getIncludeVendor());
				ltCompanyVenMgmtMisc.setMandatoryTab(ltVendCompanyMiscellaneous.getMandatoryTab());
				ltCompanyVenMgmtMisc.setStartDate(ltVendCompanyMiscellaneous.getStartDate());
				ltCompanyVenMgmtMisc.setCreationDate(new Date());
				ltCompanyVenMgmtMisc.setLastUpdateDate(new Date());
				ltCompanyVenMgmtMisc.setLastUpdateLogin(lastUpdateLogin);
				ltCompanyVenMgmtMisc.setCreatedBy(lastUpdateLogin);
				ltCompanyVenMgmtMisc.setLastUpdatedBy(lastUpdateLogin);
				ltCompanyVenMgmtMisc = ltCompanyVenMgmtMiscRepository.save(ltCompanyVenMgmtMisc);
				if(ltCompanyVenMgmtMisc.getCompVenMgmtMiscId()!=null) {
					List<LtVendMiscQuestions> questionList = ltVendMiscQuestionsDao.getBycompanyMiscId(ltVendCompanyMiscellaneous.getCompMiscellaneousId());
					if(!questionList.isEmpty()) {
						for(LtVendMiscQuestions ltVendMiscQuestions : questionList) {
							LtCompanyVenMgmtMiscQues ltCompanyVenMgmtMiscQues = new LtCompanyVenMgmtMiscQues();
							ltCompanyVenMgmtMiscQues.setCompVenMgmtMiscId(ltCompanyVenMgmtMisc.getCompVenMgmtMiscId());
							ltCompanyVenMgmtMiscQues.setMiscQuestionId(ltVendMiscQuestions.getMiscQuestionId());
							ltCompanyVenMgmtMiscQues.setCompMiscellaneousId(ltVendMiscQuestions.getCompMiscellaneousId());
							ltCompanyVenMgmtMiscQues.setQuestion(ltVendMiscQuestions.getQuestion());
							ltCompanyVenMgmtMiscQues.setMandQuestionId(ltVendMiscQuestions.getMandQuestionId());
							ltCompanyVenMgmtMiscQues.setStartDate(ltVendMiscQuestions.getStartDate());
							ltCompanyVenMgmtMiscQues.setEndDate(ltVendMiscQuestions.getEndDate());
							ltCompanyVenMgmtMiscQues.setLastUpdateDate(new Date());
							ltCompanyVenMgmtMiscQues.setCreationDate(new Date());
							
							ltCompanyVenMgmtMiscQuesRepository.save(ltCompanyVenMgmtMiscQues);
						}
					}
				}
			}else {
				LtCompanyVenMgmtMisc ltCompanyVenMgmtMisc = new LtCompanyVenMgmtMisc();
				ltCompanyVenMgmtMisc.setCompMiscellaneousId(null);
				ltCompanyVenMgmtMisc.setCompanyId(companyId);
				ltCompanyVenMgmtMisc.setVendorId(venId);
				ltCompanyVenMgmtMisc.setIncludeVendor("N");
				ltCompanyVenMgmtMisc.setMandatoryTab("N");
				ltCompanyVenMgmtMisc.setStartDate(new Date());
				ltCompanyVenMgmtMisc.setCreationDate(new Date());
				ltCompanyVenMgmtMisc.setLastUpdateDate(new Date());
				ltCompanyVenMgmtMisc = ltCompanyVenMgmtMiscRepository.save(ltCompanyVenMgmtMisc);
			}
		return true;
			
		
	}

	@Transactional
	@Override
	public Status update(LtMastVendors vendors) throws ServiceException 
	{
		Status status=new Status();
			if(vendors.getVendorId()!=null)
			{
				String chknull=checkNull(vendors);
				if(chknull.equals("null"))
				{
					status=ltMastCommonMessageService.getCodeAndMessage(INPUT_IS_EMPTY);
					if(status.getMessage()==null)
					{
						status.setCode(EXCEPTION);
						status.setMessage("Error in finding message! The action was unsuccessful");
					}
				}
				else
				{
					String chkDuplicate=checkDuplicate(vendors);
					if(chkDuplicate==null)
					{
						List<LtMastEmployees> ltMastEmployees=ltMastEmployeesDao.getByEmpId(vendors.getInitiatorId());
						if(!ltMastEmployees.isEmpty()) {
							vendors.setDivisionId(ltMastEmployees.get(0).getDivisionId());
						}
						if(ltMastVendorsDao.update(vendors))
						{
							status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_SUCCESSFULLY);
							if( status.getMessage()==null)
							{
							status.setCode(SUCCESS);
							status.setMessage("Error in finding message! The action is completed successfully.");
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
					}
					else
					{
						status.setCode(EXCEPTION);
						status.setMessage(chkDuplicate);
						return status;
					}
				}	
			
			}
			else
			{
				status=ltMastCommonMessageService.getCodeAndMessage(INPUT_IS_EMPTY);
				if(status.getMessage()==null)
				{
					status.setCode(EXCEPTION);
					status.setMessage("Error in finding message! The action was unsuccessful");
				}
			}
			
		
		return status;
	}
	
	
	
	
	
	@Transactional
	@Override
	public Status delete(Long vendorId) throws ServiceException 
	{
		Status status=new Status();
		
			if(ltMastVendorsDao.delete(vendorId))
			{
				status=returnStatus();
			
				//--------------------------------------------------------------------------------------------
				List<LtMastVendorAgreements> agreementList=ltMastVendorAgreementsDao.
						getAllVendorAgrrementByVendorId(vendorId);
				if( agreementList.size()>0)
				{
					if(ltMastVendorAgreementsDao.deleteByVendor(vendorId))
					{
						status=returnStatus();
					}
					else
					{
						return status=returnErrorStatus();
					}
				}
				//-----------------------------------------------------------------------------------
				List<LtMastVendorAddress> addrList=ltMastVendorsAddressDao.
						getAllVendorsAddressByVendorId(vendorId);
				if( addrList.size()>0)
				{
					if(ltMastVendorsAddressDao.deleteByVendorId(vendorId))
					{
						//--------------------------------------------------------------------------------
						List<LtMastVendorBanks> bankList=ltMastVendorBanksDao.getAllVendorBankByVendorId(vendorId);
						if(bankList!=null)
						 {
							 if(ltMastVendorBanksDao.deleteByVendorId(vendorId))
							 {
								 status=returnStatus();
							 }
							 else
								{
									return status=returnErrorStatus();
								}
						 }
						 //------------------------------------------------------------------------------------
						List<LtMastVendorHsnSacCodes> hsnList=ltMastVendorHsnSacCodesDao.getVendorHsnByVendorId(vendorId);
						if(hsnList!=null)
						{
							if(ltMastVendorHsnSacCodesDao.deleteByvendorId(vendorId))
							{
								status=returnStatus();
							}
							else
							{
								return status=returnErrorStatus();
							}
						}
						//--------------------------------------------------------------------------------------
						List<LtMastVendorContacts> contactList=ltMastVendorContactsDao.getVendorContactByVendorId(vendorId);
						if(contactList!=null)
						{
							if(ltMastVendorContactsDao.deleteByVendorId(vendorId))
							{
								status=returnStatus();
							}
							else
							{
								return status=returnErrorStatus();
							}
						}
						//--------------------------------------------------------------------------------
						status=returnStatus();
					}
					else
					{
						return status=returnErrorStatus();
					}
				}//end of addr delete
				//----------------------------------------------------------------------------------
				List<LtMastVendorClients>  clientList=ltMastVendorClientsDao.getVendorClientsByVendorId(vendorId);
				if(clientList!=null && clientList.size()>0)
				{
					if(ltMastVendorClientsDao.deleteByVendorId(vendorId))
					{
						status=returnStatus();
					}
					else
					{
						return status=returnErrorStatus();
					}
				}
				//---------------------------------------------------------------------------------
				List<LtMastVendorManagements> managList=ltMastVendorManagementsDao.getVendorManagementByVenId(vendorId);
				if(managList!=null && managList.size()>0)
				{
					if(ltMastVendorManagementsDao.deleteByVendorId(vendorId))
					{
						status=returnStatus();
					}
					else
					{
						return status=returnErrorStatus();
					}
				}
				/*//------------------------------------------------------------------------------------------
				List<LtMastVendorMiscInfo> miscInfoList=ltMastVendorMiscInfoDao.getVendorMiscByVenId(vendorId);
				if(miscInfoList!=null && miscInfoList.size()>0)
				{
					if(ltMastVendorMiscInfoDao.deleteByVendorId(vendorId))
					{
						status=returnStatus();
					}
					else
					{
						return status=returnErrorStatus();
					}
				}*/
				//----------------------------------------------------------------------------------------
				List<LtMastVendorSisterConcerns> sisConcernList=ltMastVendorSisterConcernsDao.getVendorSisConcByVenId(vendorId);
				if(sisConcernList!=null && sisConcernList.size()>0)
				{
					if(ltMastVendorSisterConcernsDao.deleteByVendorId(vendorId))
					{
						status=returnStatus();
					}
					else
					{
						return status=returnErrorStatus();
					}
				}
				//------------------------------------------------------------------------------------------
				/*List<LtMastCommunication> commList = ltMastCommunicationDao.getAllCommunicationListByVendorId(vendorId);
				if(commList!=null && commList.size()>0)
				{
					if(ltMastCommunicationDao.deleteByVendorId(vendorId))
					{
						status=returnStatus();
					}
					else
					{
						return status=returnErrorStatus();
					}
				}*/ //----------------------5-4-19-akshay
				
				
				
				ltMastUsersDao.updateUser(vendorId);
			}
			else
			{
				status=ltMastCommonMessageService.getCodeAndMessage(DELETE_FAIL);
				if(status.getMessage()==null)
				{
					status.setCode(EXCEPTION);
					status.setMessage("Error in finding message! The action was unsuccessful");
				}
			}
		return status;
	}
	
	public static String checkNull(LtMastVendors vendors)
	{
		if(vendors.getVendorName()==null || vendors.getStartDate()==null || vendors.getCompanyId()==null ||
				vendors.getCreatedBy()==null || vendors.getCreationDate()==null || vendors.getLastUpdateLogin()==null)
		{
			return "null";
		}
		else
			return "notnull";
		
	}

	public  Status returnStatus() throws ServiceException
	{
		Status status=new Status();
		status=ltMastCommonMessageService.getCodeAndMessage(DELETE_SUCCESSFULLY);
		if( status.getMessage()==null)
		{
			status.setCode(SUCCESS);
			status.setMessage("Error in finding message! The action is completed successfully.");
		}
		return status;
	}
	
	
	public  Status returnErrorStatus() throws ServiceException
	{
		Status status=new Status();
		status=ltMastCommonMessageService.getCodeAndMessage(DELETE_FAIL);
		if(status.getMessage()==null)
		{
			status.setCode(EXCEPTION);
			status.setMessage("Error in finding message! The action was unsuccessful");
		}
		return status;
	}

	
	public String checkDuplicate(LtMastVendors ltMastVendors) throws ServiceException
	{
		String stat=null;
		if(ltMastVendorsDao.getByVendorCode(ltMastVendors))
		{
			return stat="Duplicate Vendor Code.";
		}
		else if(ltMastVendorsDao.getByName(ltMastVendors))
		{
			return stat="Duplicate Vendor Name.";
		}
		else if(ltMastVendors.getPanNo()!=null) {
			 if(ltMastVendorsDao.getByPanNo(ltMastVendors))
			 {
				 return stat="Duplicate Pan number.";
			 }
		}
		else 
		{
			LtMastVendors ltMastVendor = ltMastVendorsDao.getByEMailId(ltMastVendors.getPrimaryEmail(),ltMastVendors.getCompanyId());
			if(ltMastVendor!=null) {
				if(!ltMastVendor.getVendorId().equals(ltMastVendors.getVendorId()))
					return stat="Primary Email already exist.";
			}
			
		}
		return stat;
	}

	@Override
	public Long getLtMastVendorsCount(Long companyId,LtMastVendors input) throws ServiceException {
		return ltMastVendorsDao.getLtMastVendorsCount(companyId,input);
	}

	@Override
	public List<LtMastVendors> getLtMastVendorsDataTable(Long companyId,LtMastVendors input) throws ServiceException {
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
		return ltMastVendorsDao.getLtMastVendorsDataTable(companyId,input);
	}

	@Override
	public List<LtMastVendors> getActiveVendorByNameAndDivId(String vendorName, Long divId) throws ServiceException
	{
		return ltMastVendorsDao.getActiveVendorByNameAndDivId(vendorName,divId);
	}

	@Override
	public List<LtMastVendors> getVendorByDivId(Long divId) throws ServiceException {
		return ltMastVendorsDao.getVendorByDivId(divId);
	}

	@Override
	public Status submitForApproval(Date date, Long vendorId, String state, Object object) throws ServiceException 
	{
		Status status = new Status();
		
		/*status = checkMandatoryTabData(vendorId);
		if(status!=null) {
			return status;
		}*/
		
		
		LtMastVendors vendor = ltMastVendorsDao.getVendorById(vendorId);
		if(vendor.getStatus().equals("VENDOR_ACTIVE"))
		{
			ltMastVendorsDao.upDateStatus(vendorId, NO_ACTION, null);
		}
		
		
		
		if(!ltVendorApprovalDao.chkForApprovers(vendorId)) {
		if(!ltMastVendorsDao.loadApprovers(vendorId,vendor.getCompanyId())){
		
			status=ltMastCommonMessageService.getCodeAndMessage(INTERNAL_SERVER_ERROR);
			if( status.getMessage()==null)
			{
				status.setCode(SUCCESS);
				status.setMessage("Error in finding message! The action is completed unsuccessfully.");
			}
		
		 }
		}
		if(ltMastVendorsDao.submitForApproval(date,vendorId,state,object)) {
			status=ltMastCommonMessageService.getCodeAndMessage(SUBMIT_FOR_APPROVAL);
			if( status.getMessage()==null)
			{
				status.setCode(SUCCESS);
				status.setMessage("Error in finding message! The action is completed successfully.");
			} 
		}else {
			status=ltMastCommonMessageService.getCodeAndMessage(INTERNAL_SERVER_ERROR);
			if( status.getMessage()==null)
			{
				status.setCode(SUCCESS);
				status.setMessage("Error in finding message! The action is completed unsuccessfully.");
			} 
		}
		return status;
	}

	private Status checkMandatoryTabData(Long vendorId) throws ServiceException {
		Status status = new Status();
		
		/*
		LtVendCompanyMiscellaneous ltVendCompanyMiscellaneous =  ltVendCompanyMiscellaneousDao.getBycompanyId(companyId);
		if(ltVendCompanyMiscellaneous!=null) {
			CompanyMgmt companyMgmt = new CompanyMgmt();
		if(ltVendCompanyMiscellaneous.getMandatoryTab().equals("Y")){
			List<LtMastVendorMiscQuestions> list =ltMastVendorMiscQuestionsDao.getVendorMiscQuestionByVenId(vendorId);
			if(list.isEmpty()) {
				status.setCode(FAIL);
				status.setMessage("Please fill mandatory MISC questions answer");
				return status;
			}
		}
		
		}
		List<LtVendCompanyMgmtDdetails> l = ltVendCompanyMgmtDdetailsDao.getBycompanyId(companyId);
		if(!l.isEmpty()) {
			if(l.get(0).getMandatoryTab().equals("Y")) {
			
			}
		}
		
		
		List<LtVendCompanyCoc> l1 = ltVendCompanyCocDao.getBycompanyId(companyId);
		if(!l1.isEmpty()) {
			CompanyMgmt companyMgmt = new CompanyMgmt();
		companyMgmt.setMasterName("LtVendCompanyCoc");
		companyMgmt.setIncludeVendor(l1.get(0).getIncludeVendor());
		companyMgmt.setMandatoryTab(l1.get(0).getMandatoryTab());
		list.add(companyMgmt);
		}
		List<LtVendCompanyClientDetails> l2 = ltVendCompanyClientDetailsDao.getBycompanyId(companyId);
		if(!l2.isEmpty()) {
			CompanyMgmt companyMgmt = new CompanyMgmt(); 
		companyMgmt.setMasterName("LtVendCompanyClientDetails");
		companyMgmt.setIncludeVendor(l2.get(0).getIncludeVendor());
		companyMgmt.setMandatoryTab(l2.get(0).getMandatoryTab());
		list.add(companyMgmt);
		}
		List<LtVendCompanyAttachments> l3 = ltVendCompanyAttachmentsDao.getBycompanyId(companyId);
		if(!l3.isEmpty()) {
			CompanyMgmt companyMgmt = new CompanyMgmt(); 
		companyMgmt.setMasterName("LtVendCompanyAttachments");
		companyMgmt.setIncludeVendor(l3.get(0).getIncludeVendor());
		companyMgmt.setMandatoryTab(l3.get(0).getMandatoryTab());
		list.add(companyMgmt);
		}
		
		List<LtVendCompanySistConcern> l4 = ltVendCompanySistConcernDao.getBycompanyId(companyId);
		if(!l4.isEmpty()) {
			CompanyMgmt companyMgmt = new CompanyMgmt(); 
		companyMgmt.setMasterName("LtVendCompanySistConcern");
		companyMgmt.setIncludeVendor(l4.get(0).getIncludeVendor());
		companyMgmt.setMandatoryTab(l4.get(0).getMandatoryTab());
		list.add(companyMgmt);
		}*/
		
		return status;
	}

	@Override
	public LtMastVendors getStatusVendorById(Long vendorId) throws ServiceException {
		return ltMastVendorsDao.getStatusVendorById(vendorId);
	}

	@Override
	public List<LtMastVendors> getAllVendorsByCompanyId(Long companyId) throws ServiceException {
		List<LtMastVendors> vendorList=ltMastVendorsDao.getAllVendorsByCompanyId(companyId);
		return vendorList;
	}

	@Override
	public LtMastVendors getByEMailId(String primaryEmail,Long companyId) throws ServiceException {
		return ltMastVendorsDao.getByEMailId(primaryEmail,companyId);
	}

	@Override
	public Long getLtMastVendorsCountByInitiatorId(LtMastVendors input, Long initiatorId) throws ServiceException {
		return ltMastVendorsDao.getLtMastVendorsCountByInitiatorId(input,initiatorId);
	}

	@Override
	public List<LtMastVendors> getLtMastVendorsDataTableByInitiatorId(LtMastVendors input, Long initiatorId) throws ServiceException {
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
		return ltMastVendorsDao.getLtMastVendorsDataTableByInitiatorId(input,initiatorId);
	}

	@Override
	public List<LtMastVendors> getAllVendorsByInitiator(Long initiatorId) throws ServiceException {
		 List<LtMastVendors> vendorList=ltMastVendorsDao.getAllVendorsByInitiator(initiatorId);
			return vendorList;
	}

	@Override
	public Status checkRecord(Long venId) throws ServiceException {
		Status status = new Status();
		LtMastVendors list=ltMastVendorsDao.getVendorById(venId);
		if(list==null) {
			status.setCode(FAIL);
		}
		else {
			status.setCode(SUCCESS);
		}
		return status;
	}

	@Override
	public LtMastVendors getPanByvendorbyid(Long vendorId) throws ServiceException {
		return ltMastVendorsDao.getPanByvendorbyid(vendorId);
	}

	@Override
	public Status getCompanyByVendor(Long venId) throws ServiceException {
		return ltMastVendorsDao.getCompanyByVendor(venId);
	}

	@Override
	public String checkforApprovals(Long vendorId) throws ServiceException {
		if( ltVendorApprovalDao.chkForApprovers(vendorId) ) {
			return "present"; 
		}else {
			return "null";
		}
		
	}

	@Override
	public Status getVendorNameById(Long vendorId) throws ServiceException {
		return ltMastVendorsDao.getVendorNameById(vendorId);
	}

	/*@Override
	public ResponseEntity<Status> saveVendorInvite(String vendorsList,MultipartFile[] files) throws ServiceException, JsonParseException, JsonMappingException, IOException {*/
	@Override
	public ResponseEntity<Status> saveVendorInvite(String vendorsList,MultipartFile[] files) throws ServiceException, JsonParseException, JsonMappingException, IOException {
	
	Status status = new Status();
		String sendInvite = "";
		Long vendorId = null;
		JSONParser jsonparser = new JSONParser();
		JSONObject jsonInputObject = null;
		try {
			jsonInputObject =  (JSONObject) jsonparser.parse(vendorsList);
		} catch (org.json.simple.parser.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		VendorList  vendorEmailList  = new ObjectMapper().readValue(vendorsList,VendorList.class);
		List<LtMastVendors> ltMastVendorsList = vendorEmailList.getLtMastVendorsList();
		String vendorEmailId = null;
		try {
			for(LtMastVendors ltMastVendors : ltMastVendorsList) {
				String message = ltMastVendors.getMessage();
				vendorEmailId = ltMastVendors.getRegistrationEmail();
			LtMastVendors vendor = ltMastVendorsDao.getByRegistrationMailId(ltMastVendors.getRegistrationEmail(),ltMastVendors.getCompanyId());
			if(vendor!=null) {
				status.setCode(INSERT_FAIL);
				status.setMessage("Vendor Registration Email address already exists.");
				return new ResponseEntity<Status>(status, HttpStatus.OK);
			}
			ltMastVendors.setCreatedBy(ltMastVendors.getLastUpdateLogin());
			ltMastVendors.setLastUpdatedBy(ltMastVendors.getLastUpdateLogin());
			
			List<LtMastEmployees> ltMastEmployees = ltMastEmployeesDao.getByEmpId(ltMastVendors.getInitiatorId());
			ltMastVendors.setCompanyId(ltMastEmployees.get(0).getCompanyId());
			ltMastVendors.setDivisionId(ltMastEmployees.get(0).getDivisionId());
			ltMastVendors.setPrimaryEmail(ltMastVendors.getRegistrationEmail());
			ltMastVendors = ltMastVendorsRepository.save(ltMastVendors);
			
			if(ltMastVendors.getVendorId()!=null) {
				vendorId = ltMastVendors.getVendorId();
				//----------------------------------------------------------
				if(loadCompanyDetailsForVendor(ltMastVendors.getVendorId(),ltMastVendors.getCompanyId(),ltMastVendors.getLastUpdateLogin())) {
				
				ltMastVendors = ltMastVendorsDao.getVendorById(ltMastVendors.getVendorId());
				String randomPassword = RandomStringUtils.random(8, true, true);
				
				if(ltMastVendorsDao.checkDuplicateUser(ltMastVendors.getRegistrationEmail(),ltMastVendors.getCompanyId())) {
					
					ltMastVendorsRepository.delete(ltMastVendors.getVendorId());
					status.setCode(INSERT_FAIL);
					status.setMessage("Vendor Registration Email address already exists.......");
					return new ResponseEntity<Status>(status, HttpStatus.OK);
				}else {
				
				LtMastUsers ltMastUsers = new LtMastUsers();
				ltMastUsers.setEmail(ltMastVendors.getRegistrationEmail());
				ltMastUsers.setVendorId(ltMastVendors.getVendorId());
				ltMastUsers.setUserName(ltMastVendors.getRegistrationEmail().trim().toUpperCase());
				ltMastUsers.setStatus("INVITED");
				ltMastUsers.setCompanyId(ltMastVendors.getCompanyId());
				ltMastUsers.setChangePwd("Y");
				ltMastUsers.setCreatedBy(ltMastVendors.getCreatedBy());
				ltMastUsers.setCreationDate(new Date());
				ltMastUsers.setLastUpdateDate(new Date());
				ltMastUsers.setLastUpdatedBy(ltMastVendors.getLastUpdatedBy());
				ltMastUsers.setLastUpdateLogin(ltMastVendors.getLastUpdateLogin());
				ltMastUsers.setStartDate(ltMastVendors.getStartDate());
				ltMastUsers.setEndDate(ltMastVendors.getEndDate());
				ltMastUsers.setLoginFailureAttempt(0L);
				String SHA256 = passwordGenater(randomPassword);

				ltMastUsers.setPassword(SHA256);

				ltMastUsers = ltMastUsersRepository.save(ltMastUsers);
				
				LtMastModules ltP2pModules = new LtMastModules();
				List<LtMastModules> ltP2pModulesList = ltMastModulesDao.findByModuleName("Vendor Registration");
				if (ltP2pModulesList.isEmpty()) {
					ltP2pModules.setModuleCode("VendorRegistration");
					ltP2pModules.setModuleName("Vendor Registration");
					ltP2pModules.setModuleUrl("/vendor/vendordataTable");
					ltP2pModules.setModuleGroup("VENDOR");
					ltP2pModules.setCreatedBy(ltMastUsers.getCreatedBy());
					ltP2pModules.setLastUpdateLogin(ltMastUsers.getLastUpdateLogin());
					ltP2pModules.setStartDate(new Date());
					ltP2pModules.setStatus("ACTIVE");
					ltP2pModules.setCreationDate(new Date());
					ltP2pModules.setLastUpdateDate(new Date());
					ltP2pModules = ltMastModulesRepository.save(ltP2pModules);
				} else {
					ltP2pModules = ltP2pModulesList.get(0);
				}
				
				
				LtMastRoles ltP2pRoles = new LtMastRoles();
				//List<LtMastRoles> ltP2pRolesList = ltMastRolesDao.findByRole("INVITE_VENDOR");
				List<LtMastRoles> ltP2pRolesList = ltMastRolesDao.findRoleByCompany("INVITE_VENDOR",ltMastVendors.getCompanyId());
				if (ltP2pRolesList.isEmpty()) {
					ltP2pRoles.setRoleName("INVITE_VENDOR");
					ltP2pRoles.setRoleDesc("Role for vendor");
					ltP2pRoles.setCreatedBy(ltMastUsers.getCreatedBy());
					ltP2pRoles.setLastUpdateLogin(ltMastUsers.getLastUpdateLogin());
					ltP2pRoles.setCreationDate(new Date());
					ltP2pRoles.setStartDate(new Date());
					ltP2pRoles.setLastUpdateDate(new Date());
					ltP2pRoles.setStatus("Active");
					ltP2pRoles = ltMastRolesRepository.save(ltP2pRoles);
				} else {
					ltP2pRoles = ltP2pRolesList.get(0);
				}

				LtMastRoleModules ltP2pRoleModules = new LtMastRoleModules();
				List<LtMastRoleModules> ltP2pRoleModulesList = ltMastRoleModulesDao
						.findByRoleIdANDModuleId(ltP2pRoles.getRoleId(), ltP2pModules.getModuleId());
				if (ltP2pRoleModulesList.isEmpty()) {
					ltP2pRoleModules.setRoleId(ltP2pRoles.getRoleId());
					ltP2pRoleModules.setModuleId(ltP2pModules.getModuleId());
					ltP2pRoleModules.setCreate("Y");
					ltP2pRoleModules.setEdit("Y");
					ltP2pRoleModules.setRead("Y");
					ltP2pRoleModules.setStartDate(new Date());
					ltP2pRoleModules.setCreationDate(new Date());
					ltP2pRoleModules.setLastUpdateDate(new Date());
					ltP2pRoleModules.setCreatedBy(ltMastUsers.getCreatedBy());
					ltP2pRoleModules.setLastUpdateLogin(ltMastUsers.getLastUpdateLogin());
					ltP2pRoleModules = ltMastRoleModulesRepository.save(ltP2pRoleModules);
				}
				LtMastUserRoles ltP2pUserRoles = new LtMastUserRoles();
				ltP2pUserRoles.setUserId(ltMastUsers.getUserId());
				ltP2pUserRoles.setRoleId(ltP2pRoles.getRoleId());
				ltP2pUserRoles.setCreatedBy(ltMastVendors.getCreatedBy());
				ltP2pUserRoles.setLastUpdateLogin(ltMastVendors.getLastUpdateLogin());
				ltP2pUserRoles.setStartDate(new Date());
				ltP2pUserRoles.setCreationDate(new Date());
				ltP2pUserRoles.setLastUpdateDate(new Date());
				ltP2pUserRoles = ltMastUserRolesRepository.save(ltP2pUserRoles);


				String token = getToken();

				String attachmentPath = null;
				if(files.length>0) {
					
					attachmentPath = saveFile(files,ltMastVendors, attachmentPath);
				}
				
				LtMastEmailtoken ltMastEmailtoken = new LtMastEmailtoken();
				ltMastEmailtoken.setEmailTitle("Invitation for Registration as a Vendor for "+ltMastVendors.getCompanyName());
				ltMastEmailtoken.setEmailTemplate("vendorInvite");
				ltMastEmailtoken.setSendTo(ltMastVendors.getRegistrationEmail());
				/*String message = "We are glad to inform you that "+ltMastVendors.getCompanyName()+" is interested in "
						+ " collaborating with you for business. " + 
						" Please use the below credentials to log in.";*/
				ltMastEmailtoken.setMessage(message);
				ltMastEmailtoken.setEmailObject("message= " + message+"," + "#$#$username=" + ltMastUsers.getEmail() 
						+ "#$#$password=" + randomPassword +  "#$#$name=" + ltMastVendors.getVendorName() + ","
						+ "#$#$vendorId=" + ltMastVendors.getVendorId() + "," + "#$#$action_url="
						+ env.getProperty("LOGIN_URL"));
				ltMastEmailtoken.setExpiredWithin(1296000L);
				ltMastEmailtoken.setSendDate(new Date());
				ltMastEmailtoken.setTokenId(token);
				ltMastEmailtoken.setEmailUserId(ltMastVendors.getLastUpdateLogin());
				ltMastEmailtoken.setEmailStatus("SENDING");
				ltMastEmailtoken.setFailureCount(0L);
				ltMastEmailtoken.setAttachmentPath(attachmentPath);
				ltMastEmailtoken = ltMastEmailtokenRepository.save(ltMastEmailtoken);

				if (sendInvite.length() == 0) {
					sendInvite += "Invite link sent to  " + ltMastVendors.getVendorName() + " Email Id";
				} else {
					sendInvite += ", Invite link sent to  " + ltMastVendors.getVendorName() + " Email Id";
				}
				
			//	LtMastVendors vendors = ltMastVendorsDao.getVendorById(ltMastVendors.getVendorId());
				if(!ltVendorApprovalDao.chkForApprovers(ltMastVendors.getVendorId())) {
				if(!ltMastVendorsDao.loadApprovers(ltMastVendors.getVendorId(),ltMastVendors.getCompanyId())){
				
					status=ltMastCommonMessageService.getCodeAndMessage(INTERNAL_SERVER_ERROR);
					if( status.getMessage()==null)
					{
						status.setCode(SUCCESS);
						status.setMessage("Error in finding message! The action is completed unsuccessfully.");
					}
					return new ResponseEntity<Status>(status, HttpStatus.OK);
				 }
				}
			}
			}else{
				status=ltMastCommonMessageService.getCodeAndMessage(INTERNAL_SERVER_ERROR);
				return new ResponseEntity<Status>(status, HttpStatus.OK);
			}
			}
			
			}
			status.setCode(INSERT_SUCCESSFULLY);
			if(ltMastVendorsList.size()<2) {
				status.setMessage(sendInvite);
			}else {
				status.setMessage("Invitations sent successfully!");
			}
			return new ResponseEntity<Status>(status, HttpStatus.OK);
		} catch (NullPointerException e) {
			e.printStackTrace();
			status.setCode(INPUT_IS_EMPTY);
			status.setMessage("inputempty");
			return new ResponseEntity<Status>(status, HttpStatus.OK);

		} catch (Exception e) {
			
			delete(vendorId);
			status.setCode(INTERNAL_SERVER_ERROR);
			if (sendInvite.length() == 0) {
				sendInvite += " User for  " + vendorEmailId+ " already exists";
			}else {
				sendInvite += ", User for  " + vendorEmailId+ " already exists";
			}
			status.setMessage(sendInvite);
			e.printStackTrace();
			//return new ResponseEntity<Status>(status, HttpStatus.OK);

		}
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}

	private String saveFile(MultipartFile[] files, LtMastVendors ltMastVendors,String attachmentType) throws ServiceException {
		Status status=new Status();
		String fileName = null;
		String saveDirectory=null;
		String  attachmentPath = new String();
		SysVariableWithValues sysVariableWithValues=
				ltMastSysVariablesService.getBySysVariableName("FILE_UPLOAD_FOLDER_PATH",ltMastVendors.getCompanyId());
		
		if(sysVariableWithValues!=null)
		{
			if(sysVariableWithValues.getLtMastSysVariableValues().get(0)!=null)
			{
				saveDirectory=sysVariableWithValues.getLtMastSysVariableValues().get(0).getUserValue();
			}
			else
			{
				saveDirectory=sysVariableWithValues.getLtMastSysVariables().getSystemValue();
			}
		}
		File dir = new File(saveDirectory);
		if (!dir.exists())
		{
			 
			dir.mkdirs();
			if(!dir.isDirectory())
			{
				 
				status=ltMastCommonMessageService.getCodeAndMessage(NO_DIRECTIVE_EXISTS);
				if(status.getMessage()==null)
				{
					status.setCode(EXCEPTION);
					status.setMessage("Error in finding message! The action was unsuccessful");
				}
			}
		}	
	
		 
		for(int i =0 ;i< files.length; i++)
		{
			try 
			{
				fileName = files[i].getOriginalFilename();
				byte[] bytes = files[i].getBytes();
				BufferedOutputStream buffStream = 
                    new BufferedOutputStream(new FileOutputStream(new File(saveDirectory + fileName)));
				buffStream.write(bytes);
				buffStream.close();
			 
			} 
			catch (Exception e)
			{
				 
				e.printStackTrace();
			}
			attachmentPath = attachmentPath.concat(saveDirectory + fileName+",");
		}
		return attachmentPath;
	}

	public String passwordGenater(String input) 
	{
		String shaVesion = "SHA-256";
		
		MessageDigest digest = null;
		StringBuffer hexString = new StringBuffer();
		try {
			digest = MessageDigest.getInstance(shaVesion);

			byte[] encodedhash = digest.digest(input.getBytes(StandardCharsets.UTF_8));
				for (int i = 0; i < encodedhash.length; i++) {
					String hex = Integer.toHexString(0xff & encodedhash[i]);
					if (hex.length() == 1)
						hexString.append('0');
						hexString.append(hex);
				}
		} catch (NoSuchAlgorithmException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		return hexString.toString();
	}

	public String getToken() {
		String token = new BigInteger(130, random).toString(32);
		
		return token;
	}

	@Override
	public List<LtMastVendors> getVendorByName(Long companyId, String vendorName) throws ServiceException {
		List<LtMastVendors> vendorList=ltMastVendorsDao.getVendorByName(companyId,vendorName);
		return vendorList;
	}

	@Override
	public Status saveWithAttachment(LtMastVendors ltMastVendor,MultipartFile[] files) throws ServiceException {
		Status status=new Status();
		String chknull=checkNull(ltMastVendor);
		if(chknull.equals("null")){
			status=ltMastCommonMessageService.getCodeAndMessage(INPUT_IS_EMPTY);
		}
		else{
			String chkDuplicate=checkDuplicate(ltMastVendor);
			if(chkDuplicate==null){
				List<LtMastEmployees> ltMastEmployees=ltMastEmployeesDao.getByEmpId(ltMastVendor.getInitiatorId());
				if(!ltMastEmployees.isEmpty()) {
					ltMastVendor.setDivisionId(ltMastEmployees.get(0).getDivisionId());
				}
				Long venId=ltMastVendorsDao.save(ltMastVendor);
				if(venId!=null){
					ltMastVendor.setVendorId(venId);
					if(files.length> 0){
						Status status1 = new Status();
						status1=imageUpload(files,ltMastVendor);
						if(status1.getCode()== INSERT_SUCCESSFULLY){
							if(!ltVendorApprovalDao.chkForApprovers(venId)) {
								if(!ltMastVendorsDao.loadApprovers(venId,ltMastVendor.getCompanyId())){
								
									 
									status=ltMastCommonMessageService.getCodeAndMessage(INTERNAL_SERVER_ERROR);
									return status;
								 }
								}
								
								if(loadCompanyDetailsForVendor(venId,ltMastVendor.getCompanyId(),ltMastVendor.getLastUpdateLogin())) {
								
									status=ltMastCommonMessageService.getCodeAndMessage(INSERT_SUCCESSFULLY);
									status.setData(venId);
								}
						}
						else{
							status=ltMastCommonMessageService.getCodeAndMessage(INSERT_FAIL);
						}
						return status;
					}else {
						if(!ltVendorApprovalDao.chkForApprovers(venId)) {
							if(!ltMastVendorsDao.loadApprovers(venId,ltMastVendor.getCompanyId())){
							
								 
								status=ltMastCommonMessageService.getCodeAndMessage(INTERNAL_SERVER_ERROR);
								return status;
							 }
							}
							
							if(loadCompanyDetailsForVendor(venId,ltMastVendor.getCompanyId(),ltMastVendor.getLastUpdateLogin())) {
							
								status=ltMastCommonMessageService.getCodeAndMessage(INSERT_SUCCESSFULLY);
								status.setData(venId);
							}
						status=ltMastCommonMessageService.getCodeAndMessage(INSERT_SUCCESSFULLY);
						status.setData(venId);
					}
					
				}else{
					status=ltMastCommonMessageService.getCodeAndMessage(INSERT_FAIL);
				}
			}
			else{
				status.setCode(EXCEPTION);
				status.setMessage(chkDuplicate);
			}
		}
		return status;
	}

	private Status imageUpload(MultipartFile[] files, LtMastVendors ltMastVendor) throws ServiceException {
		Status status=new Status();
		String fileName;
		String saveDirectory=null;
		SysVariableWithValues sysVariableWithValues=
				ltMastSysVariablesService.getBySysVariableName("FILE_UPLOAD_FOLDER_PATH",ltMastVendor.getCompanyId());
	
		if(sysVariableWithValues!=null){
			if(sysVariableWithValues.getLtMastSysVariableValues().get(0)!=null){
				saveDirectory=sysVariableWithValues.getLtMastSysVariableValues().get(0).getUserValue();
			}else{
				saveDirectory=sysVariableWithValues.getLtMastSysVariables().getSystemValue();
			}
		}
		File dir = new File(saveDirectory);
		if (!dir.exists())
		{
			dir.mkdirs();
			if(!dir.isDirectory())
			{
				status=ltMastCommonMessageService.getCodeAndMessage(NO_DIRECTIVE_EXISTS);
				return status;
			}
		}	
	
		
		for(int i =0 ;i< files.length; i++)
		{
        try 
        {
            fileName = files[i].getOriginalFilename();
            byte[] bytes = files[i].getBytes();
            BufferedOutputStream buffStream = 
                    new BufferedOutputStream(new FileOutputStream(new File(saveDirectory + fileName)));
            buffStream.write(bytes);
             
            ltMastVendor.setImagePath(fileName);
           if( ltMastVendorsDao.updatePath(ltMastVendor))
           {
        	   buffStream.close();
               status=ltMastCommonMessageService.getCodeAndMessage(INSERT_SUCCESSFULLY);
               status.setData(ltMastVendor.getImagePath());
           }
           else
           {
        	   buffStream.close();
               status=ltMastCommonMessageService.getCodeAndMessage(INSERT_FAIL);
   			  return status;
            }
        	
        } 
        catch (Exception e)
        {
        	e.printStackTrace();
        	 status=ltMastCommonMessageService.getCodeAndMessage(INTERNAL_SERVER_ERROR);
        }
	}
		return status;
	}

	@Override
	public Status updateWithAttachment(LtMastVendors ltMastVendor, MultipartFile[] files) throws ServiceException {
		Status status=new Status();
		if(ltMastVendor.getVendorId()!=null)
		{
			String chknull=checkNull(ltMastVendor);
			if(chknull.equals("null"))
			{
				status=ltMastCommonMessageService.getCodeAndMessage(INPUT_IS_EMPTY);
			}
			else
			{
				String chkDuplicate=checkDuplicate(ltMastVendor);
				if(chkDuplicate==null)
				{
					List<LtMastEmployees> ltMastEmployees=ltMastEmployeesDao.getByEmpId(ltMastVendor.getInitiatorId());
					if(!ltMastEmployees.isEmpty()) {
						ltMastVendor.setDivisionId(ltMastEmployees.get(0).getDivisionId());
					}
					if(ltMastVendorsDao.update(ltMastVendor))
					{
						if(files.length> 0)
						{
							Status status1 = new Status();
							status1=imageUpload(files,ltMastVendor);
							if(status1.getCode()== INSERT_SUCCESSFULLY)
							{
								status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_SUCCESSFULLY);
							}else {
								status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_FAIL);
							}
						}else {
							status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_SUCCESSFULLY);
						}
					}
					else{
						status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_FAIL);
					}
				}
				else{
					status.setCode(EXCEPTION);
					status.setMessage(chkDuplicate);
					return status;
				}
			}	
		
		}
		else
		{
			status=ltMastCommonMessageService.getCodeAndMessage(INPUT_IS_EMPTY);
		}
		
	
	return status;
	}

	@Override
	public Status updateAttachment(Long vendorId, MultipartFile[] files) throws ServiceException {
		Status status = new Status();
		LtMastVendors vendor=ltMastVendorsDao.getVendorById(vendorId);
		if(files.length> 0)
		{
			Status status1 = new Status();
			status1=imageUpload(files,vendor);
			if(status1.getCode()== INSERT_SUCCESSFULLY)
			{
				status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_SUCCESSFULLY);
			}else {
				status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_FAIL);
			}
		}else {
			status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_SUCCESSFULLY);
		}
		return status;
	}

	@Override
	public LtMastVendors getByRegistrationMailId(String registrationEmail, Long companyId) throws ServiceException {
		return ltMastVendorsDao.getByRegistrationMailId(registrationEmail,companyId);
	}

}
