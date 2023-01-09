package com.lonar.UserManagement.web.dao;

import java.util.List;

import com.lonar.UserManagement.common.BusinessException;
import com.lonar.UserManagement.web.model.LtMastAuditRecords;
import com.lonar.UserManagement.web.model.LtMastRoles;
import com.lonar.UserManagement.web.model.LtMastUserRoles;
import com.lonar.UserManagement.web.model.LtMastUsers;
import com.lonar.UserManagement.web.model.Menu;

public interface LtMastUsersDao {

/*	List<LtMastUsers> getAllUsers();
	List<LtMastUsers> getUserNamePassword(String userName, String password);*/
	List<LtMastUsers> findByUserName(String userName);
	/*	List<LtMastUsers> findByEmail(String emailID);
	List<LtMastUsers> findAllActive();
	List<LtMastUsers> findByUserNameAndEmailId(String username, String emailID);
//	UserWithRolePojo findUserWithRoleDetails(Long userID);
	List<LtMastUsers> findByEmployeeId(Long employeeId);
	List<LtMastUsers> getByUserId(Long userId);*/
	
	Long getLtMastUsersCount(LtMastUsers input, Long companyId);
	List<LtMastUsers> getLtMastUsersDatatableRecords(LtMastUsers input, Long companyId);
	List<LtMastUsers> findByActiveLikeUserName(String userName);
	LtMastUsers getLtMastUsersByID(Long id);
	List<LtMastRoles> getActiveRoles();
	List<LtMastUsers> findByAdId(String userName);
	
	Long getUserRoleCount(LtMastUserRoles input);
	List<LtMastUserRoles> getUserRoleList(LtMastUserRoles input);
	
	//List<LtMastUsers> findByUserNameForOauth(String userName);
	
	public List<Menu> findMenu(Long userId, Long companyId);

	List<LtMastUsers> findVendorByUserName(String upperCase);

	List<LtMastUsers> findActiveLikeEmail(String email) throws Exception;

	LtMastUsers getForAuditByID(Long userId) throws BusinessException;

	void updateAuditId(float auditId, Long userId)  throws BusinessException;

	List<LtMastAuditRecords> getLtMastUserAudit(Long userId) throws BusinessException;

	LtMastUsers getForAuditByID1(Long userId) throws BusinessException;

	LtMastUsers update(LtMastUsers user) throws BusinessException;

	Long getLtMastUsersUtilityCount(LtMastUsers input) throws BusinessException;

	List<LtMastUsers> getLtMastUsersUtilityDataTable(LtMastUsers input) throws BusinessException;
}
