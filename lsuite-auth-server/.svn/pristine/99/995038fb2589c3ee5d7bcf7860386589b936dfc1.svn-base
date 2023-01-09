package com.lonar.UserManagement.web.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lonar.UserManagement.common.BusinessException;
import com.lonar.UserManagement.common.CommonMethod;
import com.lonar.UserManagement.common.ServiceException;
import com.lonar.UserManagement.web.dao.LtMastEmailtokenDao;
import com.lonar.UserManagement.web.dao.LtMastUserRolesDao;
import com.lonar.UserManagement.web.dao.LtMastUsersDao;
import com.lonar.UserManagement.web.model.CodeMaster;
import com.lonar.UserManagement.web.model.CustomeDataTable;
import com.lonar.UserManagement.web.model.LtMastAudit;
import com.lonar.UserManagement.web.model.LtMastAuditRecords;
import com.lonar.UserManagement.web.model.LtMastEmailtoken;
import com.lonar.UserManagement.web.model.LtMastRoles;
import com.lonar.UserManagement.web.model.LtMastUserRoles;
import com.lonar.UserManagement.web.model.LtMastUsers;
import com.lonar.UserManagement.web.model.Status;
import com.lonar.UserManagement.web.repository.LtMastAuditRecordsRepository;
import com.lonar.UserManagement.web.repository.LtMastAuditRepository;
import com.lonar.UserManagement.web.repository.LtMastUserRolesRepository;
import com.lonar.UserManagement.web.repository.LtMastUsersRepository;

import de.danielbechler.diff.ObjectDifferBuilder;
import de.danielbechler.diff.node.DiffNode;
import de.danielbechler.diff.node.Visit;


@Transactional
@Service
@PropertySource(value = "classpath:serverurl.properties", ignoreResourceNotFound = true)
public class LtMastUsersServiceImpl implements LtMastUsersService,CodeMaster {

	@Autowired
	LtMastAuditRepository ltMastAuditRepository;
	
	@Autowired
	LtMastAuditRecordsRepository ltMastAuditRecordsRepository;
	
	@Autowired
	CommonMethod commonMethod;
	
	@Autowired
	private Environment env;
	
	@Autowired
	private LtMastUsersDao ltMastUsersDao;

	@Autowired
	LtMastUserRolesDao ltMastUserRolesDao;
	
	@Autowired
	LtMastUserRolesRepository ltMastUserRolesRepository;
	
	@Autowired
	private LtMastEmailtokenDao ltMastEmailtokenDao;
	
	@Autowired
	private LtMastUsersRepository ltMastUsersRepository;
	
	@Autowired
	private LtMastUserRolesRepository userRoleRepository;
	
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;


	@Override
	public List<LtMastUsers> findByActiveLikeUserName(String userName) throws Exception {
		return ltMastUsersDao.findByActiveLikeUserName(userName);
	}

	@Override
	public void SendUsersByID(Environment env,String id) throws Exception 
	{
		LtMastUsers ltMastUsers = null;
		ltMastUsers = ltMastUsersRepository.findOne(Long.parseLong(id));
		if (ltMastUsers.getStatus().equals("UNVERIFYEMAIL")) 
		{
		ltMastUsers = ltMastUsersRepository.findOne(Long.parseLong(id));
		String token = new CommonMethod().getToken();
		final String emailID = ltMastUsers.getEmail();
		final String userName = ltMastUsers.getUserName();
		final String userID = ltMastUsers.getUserId().toString();
		LtMastEmailtoken ltMastEmailtoken = new LtMastEmailtoken();
		ltMastEmailtoken.setEmailTitle("Thanks For Registering at LEXA Application");
		ltMastEmailtoken.setEmailTemplate("emailValid");
		ltMastEmailtoken.setSendTo(emailID);
		ltMastEmailtoken.setEmailObject("Name=" + userName + "," + "userId=" + userID + "," +"#$#$" + "action_url="
				+ env.getProperty("CLIENT_URL_REST_EMIALVALIDATEURL"));
		ltMastEmailtoken.setExpiredWithin(86400L);
		ltMastEmailtoken
				.setSendDate(new CommonMethod().convertStringtoSqlDateTime(new CommonMethod().getTodayDate()));
		ltMastEmailtoken.setTokenId(token);
		ltMastEmailtoken.setEmailUserId(Long.parseLong(userID));
		ltMastEmailtoken.setEmailStatus("SENDING");
		ltMastEmailtoken.setFailureCount(0L);
		
		
			ltMastEmailtokenDao.makeEntryInEmailToken(ltMastEmailtoken);
		
	 }
	}


//===============================================================================
	
	@Override
	public CustomeDataTable getLtMastUsersDataTable(LtMastUsers input,Long companyId) {
		CustomeDataTable customeDataTable = new CustomeDataTable();
		Long count = ltMastUsersDao.getLtMastUsersCount(input,companyId);
	    customeDataTable.setRecordsTotal(count);
	    customeDataTable.setRecordsFiltered(count);
	    List<LtMastUsers> ltMastCompanyList= ltMastUsersDao.getLtMastUsersDatatableRecords(input,companyId);
	    customeDataTable.setData(ltMastCompanyList);	
		return customeDataTable;
	}

	@Override
	@Transactional
	public Status saveUser(LtMastUsers user) {
		Status status = new Status();
		try {
			List<LtMastUsers> list =ltMastUsersDao.findActiveLikeEmail(user.getEmail());
			if(!list.isEmpty()) {
				status.setMessage("User for email address already exists.");
				status.setCode(FAIL);
				 return status;
			}
			
		   list =ltMastUsersDao.findByActiveLikeUserName(user.getUserName());
			if(!list.isEmpty()) {
				status.setMessage("Username already exists.");
				status.setCode(FAIL);
				 return status;
			}
			
			  user.setLastUpdateDate(new Date());
			   user.setCreationDate(new Date());
			   user.setStatus("UNVERIFYEMAIL");
			   LtMastUsers users = ltMastUsersRepository.save(user);
			   if(users.getUserId()!=null) {
					String token = new CommonMethod().getToken();
				   LtMastEmailtoken ltMastEmailtoken = new LtMastEmailtoken();
					ltMastEmailtoken.setEmailTitle("Thanks For Registering at V-PAL Application");
					ltMastEmailtoken.setEmailTemplate("emailValid");
					ltMastEmailtoken.setSendTo(user.getEmail());
					ltMastEmailtoken.setEmailObject("Name=" + user.getUserName() + ",#$#$" + "userId=" + user.getUserId() + "," +"#$#$" + "action_url="
							+ env.getProperty("CLIENT_URL_REST_EMIALVALIDATEURL"));
					ltMastEmailtoken.setExpiredWithin(86400L);
					ltMastEmailtoken
							.setSendDate(new CommonMethod().convertStringtoSqlDateTime(new CommonMethod().getTodayDate()));
					ltMastEmailtoken.setTokenId(token);
					ltMastEmailtoken.setEmailUserId(user.getUserId());
					ltMastEmailtoken.setEmailStatus("SENDING");
					ltMastEmailtoken.setFailureCount(0L);
					try
					{
						ltMastEmailtokenDao.makeEntryInEmailToken(ltMastEmailtoken);
					}
					catch(Exception e)
					{
						e.printStackTrace();
						throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
					}
				   
			   status=ltMastCommonMessageService.getCodeAndMessage(INSERT_SUCCESSFULLY);
				if( status.getMessage()==null)
				{
					status.setCode(SUCCESS);
					status.setMessage("Error in finding message! The action is completed successfully.");
				}
				status.setData(users.getUserId());
			   }else {
				   status=ltMastCommonMessageService.getCodeAndMessage(INSERT_FAIL);
					if( status.getMessage()==null)
					{
						status.setCode(FAIL);
						status.setMessage("Error in finding message! The action is completed unsuccessfully.");
					}
			   }
		}catch(Exception e) {
			e.printStackTrace();
			status.setMessage("User creation fail");
		}
		   return status;
	}

	@Override
	public ResponseEntity<LtMastUsers> getLtMastUsersByID(Long id) {
		LtMastUsers user = ltMastUsersDao.getLtMastUsersByID(id); 
		return new ResponseEntity<LtMastUsers>(user, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<LtMastRoles>> getActiveRoles() {
		List<LtMastRoles> roles = ltMastUsersDao.getActiveRoles();
		return new ResponseEntity<List<LtMastRoles>>(roles, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Status> saveUserRole(LtMastUserRoles userRole) {
		if(userRole.getUserRoleId() == null) {
			userRole.setCreationDate(new Date());
		}
		userRole.setLastUpdateDate(new Date());
		userRoleRepository.save(userRole);
		return new ResponseEntity<Status>(HttpStatus.OK);
	}

	@Override
	public CustomeDataTable getUsersRoleDataTable(LtMastUserRoles input) {
		
		CustomeDataTable customeDataTable = new CustomeDataTable();
		Long count = ltMastUsersDao.getUserRoleCount(input);
	    customeDataTable.setRecordsTotal(count);
	    customeDataTable.setRecordsFiltered(count);
	    List<LtMastUserRoles> usersRole= ltMastUsersDao.getUserRoleList(input);
	    customeDataTable.setData(usersRole);	
		return customeDataTable;
	}

	@Override	 
	public Status updateUser(LtMastUsers user) throws IOException,BusinessException {
		Status status = new Status();
		
		 user.setLastUpdateDate(new Date());
		 user.setCreationDate(new Date());
		 LtMastUsers base = ltMastUsersDao.getForAuditByID(user.getUserId());
		
		 LtMastUsers ltMastUsers = ltMastUsersDao.update(user);
		  
		 LtMastUsers ltMastUsersWork = ltMastUsersDao.getForAuditByID(ltMastUsers.getUserId());
		
		 //if(user.getFlag()!=null) {
		// if(!user.getFlag().toUpperCase().equals("CHECK")) {
			 
			 float auditId = commonMethod.saveAudit(base,ltMastUsersWork,base.getAuditId(),2L);
			 ltMastUsersDao.updateAuditId(auditId,user.getUserId());
		// }
		// }
		if(user.getUserId()!=null) {					
				status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_SUCCESSFULLY);
				if( status.getMessage()==null)
				{
					status.setCode(SUCCESS);
					status.setMessage("Error in finding message! The action is completed successfully.");
				}
				status.setData(user.getUserId());
		}else {
					 status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_FAIL);
					if( status.getMessage()==null){
							status.setCode(FAIL);
							status.setMessage("Error in finding message! The action is completed unsuccessfully.");
					}
		}
		
		 return status;
	}



	@Transactional(propagation =Propagation.REQUIRES_NEW)
	private LtMastUsers saveUsers(LtMastUsers user) {
		LtMastUsers ltMastUsers = ltMastUsersRepository.save(user);
		return ltMastUsers;
	}

	

	@Override
	public Status deleteById(Long id) {
		Status status= new Status();
		LtMastUsers ltMastUsers = null;
		try {
			if (ltMastUsersRepository.exists(id)) {
				ltMastUsers = ltMastUsersRepository.findOne(id);
				if (ltMastUsers.getStatus().equals("UnVerifyEmail")) {
					List<LtMastUserRoles> ltP2pUserRolesList = ltMastUserRolesDao
							.findByUserIdWithList(id);
					for (LtMastUserRoles ltP2pUserRoles : ltP2pUserRolesList) {
						ltMastUserRolesRepository.delete(ltP2pUserRoles.getUserRoleId());
					}

				} else if (!ltMastUsers.getStatus().toUpperCase().equals("UNVERIFYEMAIL")
						|| ltMastUserRolesDao.findByUserId(id)!=null) {
					
			
					status=ltMastCommonMessageService.getCodeAndMessage(ENTITY_CANNOT_DELETE);
					return status;
					
				}

				ltMastUsersRepository.delete(id);
			}
		}  catch (Exception e) {
			e.printStackTrace();
			
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}

		status=ltMastCommonMessageService.getCodeAndMessage(DELETE_SUCCESSFULLY);
		if(status.getMessage()==null)
		{
			status.setCode(SUCCESS);
			status.setMessage("Error in finding message! The action is completed successfully.");
		}
		return status;
	}

	@Override
	public List<LtMastAuditRecords> getLtMastUserAudit(Long userId) throws ServiceException {
		return ltMastUsersDao.getLtMastUserAudit(userId);
	}
	
	
	
	public  float saveAudit( Object base,Object work) throws IOException {
		return downcast(base,work);
	}
	
	public  <newClass> float downcast(Object obj1,Object obj2) {
		
		newClass base = (newClass) obj1;
			
			newClass work = (newClass) obj2;
			
			LtMastAudit ltMastAudit = new LtMastAudit();
			ltMastAudit.setCreationDate(new Date());
			ltMastAudit.setCreatedBy(1L);
			ltMastAudit.setMasterName(work.getClass().getName());
			if(base!=null) {
			ltMastAudit.setOldEntity(base+"");
			}
			ltMastAudit.setNewEntity(work+"");
			
			ltMastAudit = ltMastAuditRepository.save(ltMastAudit);
			final float auditId = ltMastAudit.getAuditId();
			
			
		DiffNode diff = ObjectDifferBuilder.buildDefault().compare(work, base);
		diff.visit(new DiffNode.Visitor()
		{
		    public void node(DiffNode node, Visit visit)
		    {
		    	
		        final Object baseValue = node.canonicalGet(base);
		        final Object workingValue = node.canonicalGet(work);
		        final String message = node.getPath() + " changed from " + 
		                               baseValue + " to " + workingValue;
		        LtMastAuditRecords ltMastAuditRecords = new LtMastAuditRecords();
		        ltMastAuditRecords.setCreationDate(new Date());
		        ltMastAuditRecords.setCreatedBy(1L);
		        ltMastAuditRecords.setValueName(node.getPath().toString().replace("/", ""));
		        ltMastAuditRecords.setOldValue(baseValue+"");
		        ltMastAuditRecords.setNewValue(workingValue+"");
		        ltMastAuditRecords.setAuditId(auditId);
				
				ltMastAuditRecordsRepository.save(ltMastAuditRecords);
		    }
		});
		return auditId;
	}
		//}

	@Override
	public CustomeDataTable getLtMastUsersUtilityDataTable(LtMastUsers input) throws ServiceException {
		CustomeDataTable customeDataTable = new CustomeDataTable();
		Long count = ltMastUsersDao.getLtMastUsersUtilityCount(input);
	    customeDataTable.setRecordsTotal(count);
	    customeDataTable.setRecordsFiltered(count);
	    List<LtMastUsers> ltMastCompanyList= ltMastUsersDao.getLtMastUsersUtilityDataTable(input);
	    customeDataTable.setData(ltMastCompanyList);	
		return customeDataTable;
	}
		
	
	
}
