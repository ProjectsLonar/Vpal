package com.lonar.UserManagement.web.service;

import java.io.IOException;
import java.util.List;

import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;

import com.lonar.UserManagement.common.BusinessException;
import com.lonar.UserManagement.common.ServiceException;
import com.lonar.UserManagement.web.model.CustomeDataTable;
import com.lonar.UserManagement.web.model.LtMastAuditRecords;
import com.lonar.UserManagement.web.model.LtMastRoles;
import com.lonar.UserManagement.web.model.LtMastUserRoles;
import com.lonar.UserManagement.web.model.LtMastUsers;
import com.lonar.UserManagement.web.model.Status;

public interface LtMastUsersService {

/*	public List<LtMastUsers> getUserNamePassword(String userName, String password) throws Exception;

	public List<LtMastUsers> findAllUsers() throws Exception;

	public List<LtMastUsers> findByUserName(String userName) throws Exception;
	
	public List<LtMastUsers> findByAdId(String userName) throws Exception;

	public List<LtMastUsers> findByEmail(String emailID) throws Exception;

	public List<LtMastUsers> findAllActive() throws Exception;

	public List<LtMastUsers> findByUserNameAndEmailId(String username, String emailID) throws Exception;

	public LtMastUsers getByUserId(Long userId) throws Exception;

	public UserWithRolePojo findUserWithRoleDetails(Long userID) throws Exception;

	public List<LtMastUsers> findByEmployeeId(Long employeeId) throws Exception;

	

	public String checkDuplicate(LtMastUsers ltMastUsers) throws Exception;*/

	//public Long getLtMastUsersCount(LtMastUsers input) throws Exception;

	//public List<LtMastUsers> getLtMastUsersDatatableRecords(LtMastUsers input) throws Exception;
	
	

	public List<LtMastUsers> findByActiveLikeUserName(String userName) throws Exception;
	public void SendUsersByID(Environment env, String id) throws Exception;
	
	Status saveUser(LtMastUsers user);
	Status updateUser(LtMastUsers user) throws IOException,BusinessException;
	
	CustomeDataTable getLtMastUsersDataTable(LtMastUsers input, Long companyId);
	ResponseEntity<LtMastUsers> getLtMastUsersByID(Long id);
	ResponseEntity<List<LtMastRoles>> getActiveRoles();
	ResponseEntity saveUserRole(LtMastUserRoles userRole);
	CustomeDataTable getUsersRoleDataTable(LtMastUserRoles input);
	public Status deleteById(Long id);
	public List<LtMastAuditRecords> getLtMastUserAudit(Long cityId) throws ServiceException;
	public CustomeDataTable getLtMastUsersUtilityDataTable(LtMastUsers input) throws ServiceException;
	
}
