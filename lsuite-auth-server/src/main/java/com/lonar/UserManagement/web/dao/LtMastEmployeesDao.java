package com.lonar.UserManagement.web.dao;

import java.util.List;

import com.lonar.UserManagement.web.model.LtMastEmployees;

public interface LtMastEmployeesDao {

	public List<LtMastEmployees> findBySupervisorEmpId(Long supervisorEmpId) throws Exception;

	public List<LtMastEmployees> findByEmployeeNumber(String employeeNumber) throws Exception;

	public List<LtMastEmployees> findByOfficialEmail(String officialEmail) throws Exception;

	public List<LtMastEmployees> findByPosition(String position) throws Exception;

	public List<LtMastEmployees> findAllActive() throws Exception;

	public List<LtMastEmployees> findLikeFirstName(String firstName) throws Exception;

	public List<LtMastEmployees> findLikeName(String name) throws Exception;
	
	public  List<LtMastEmployees> findByActiveLikeName(String name) throws Exception;

	public List<LtMastEmployees> findUserNotEmployeeId() throws Exception;

	public List<LtMastEmployees> findByCostCenterId(Long costCenterId) throws Exception;

	public List<LtMastEmployees> findByEmployeeName(String name) throws Exception;

	public List<LtMastEmployees> checkDetails(LtMastEmployees ltMastEmployees) throws Exception;

	public List<LtMastEmployees> getEmployeeDetailsByUserID(Long userId) throws Exception;

	public List<LtMastEmployees> getByEmpId(Long no) throws Exception;

	public List<LtMastEmployees> getLikeNameByDivisionId(String name, String divisionId) throws Exception;

	public LtMastEmployees getByEmployeeNumber(String employeeNumber) throws Exception;

	public LtMastEmployees getByofficialEmail(String officialEmail) throws Exception;

	public LtMastEmployees getByPersonalEmail(String personalEmail) throws Exception;

	public LtMastEmployees getByPassportNumber(String passportNo) throws Exception;

	public LtMastEmployees getByPanNumber(String panNo) throws Exception;

	//public Long save(LtMastEmployees ltMastEmployees) throws Exception;

	public boolean updatePath(LtMastEmployees ltMastEmployees) throws Exception;

	public boolean delete(Long employeeId) throws Exception;

	public boolean update(LtMastEmployees ltMastEmployees)  throws Exception;

	public List<LtMastEmployees> findAll()  throws Exception;

	public LtMastEmployees getLtMastEmployeesByID(Long empId) throws Exception;

	public Long getCount(LtMastEmployees input) throws Exception;

	public List<LtMastEmployees> getDatatableRecords(LtMastEmployees input) throws Exception;

	public List<LtMastEmployees> getLtMastEmployeesBySuperWID(long employeeId)throws Exception;

	public List<LtMastEmployees> getByEmpIdV1(Long employeeId) throws Exception;

	public List<LtMastEmployees> getByEmpIdForEmail(Long longValue) throws Exception;

}
