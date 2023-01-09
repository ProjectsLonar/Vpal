package com.lonar.UserManagement.web.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.lonar.UserManagement.web.model.LtMastEmployees;
import com.lonar.UserManagement.web.model.Status;

public interface LtMastEmployeesService {

	public List<LtMastEmployees> findBySupervisorEmpId(Long supervisorEmpId) throws Exception;

	public List<LtMastEmployees> findByEmployeeNumber(String employeeNumber) throws Exception;

	public List<LtMastEmployees> findByOfficialEmail(String officialEmail) throws Exception;

	public List<LtMastEmployees> findByPosition(String position) throws Exception;

	public List<LtMastEmployees> findAllActive() throws Exception;

	public List<LtMastEmployees> findLikeFirstName(String firstName) throws Exception;

	public List<LtMastEmployees> findLikeName(String name) throws Exception;
	
	public List<LtMastEmployees>  findByActiveLikeName(String name) throws Exception;

	public List<LtMastEmployees> findUserNotEmployeeId() throws Exception;

	public List<LtMastEmployees> findByCostCenterId(Long costCenterId) throws Exception;
	
	public List<LtMastEmployees> findByEmployeeName(String name) throws Exception;

	public String checkDetails(LtMastEmployees ltMastEmployees) throws Exception;

	public LtMastEmployees getEmployeeDetailsByUserID(Long userId) throws Exception;

	public List<LtMastEmployees> checkDetailsUpdate(LtMastEmployees ltMastEmployees) throws Exception;

	public List<LtMastEmployees> getByEmpId(Long no) throws Exception;

	public List<LtMastEmployees> getLikeNameByDivisionId(String name, String divisionId)  throws Exception;

	public Status save(LtMastEmployees ltMastEmployees, MultipartFile[] files) throws Exception;

	public Status update(LtMastEmployees ltMastEmployees,MultipartFile[] files) throws Exception;

	public List<LtMastEmployees> findAll() throws Exception;

	public LtMastEmployees getLtMastEmployeesByID(Long parseLong) throws Exception;

	public Long getCount(LtMastEmployees input) throws Exception;

	public List<LtMastEmployees> getDatatableRecords(LtMastEmployees input) throws Exception;

	public List<LtMastEmployees> getLtMastEmployeesBySuperWID(long employeeId)throws Exception;

	public Status updateProfile(MultipartFile[] files, LtMastEmployees emp) throws Exception;
	
}
