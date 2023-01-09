package com.lonar.vendor.vendorportal.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.lonar.vendor.vendorportal.model.LtMastEmployees;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;



public interface LtMastEmployeesService {

	public ResponseEntity findBySupervisorEmpId(Long supervisorEmpId) throws ServiceException;

	public ResponseEntity findByEmployeeNumber(String employeeNumber) throws ServiceException;

	public ResponseEntity findByOfficialEmail(String officialEmail) throws ServiceException;

	public ResponseEntity findByPosition(String position) throws ServiceException;

	public ResponseEntity findAllActive() throws ServiceException;

	public ResponseEntity findLikeFirstName(String firstName) throws ServiceException;

	public ResponseEntity findLikeName(String name) throws ServiceException;
	
	public List<LtMastEmployees>  findByActiveLikeName(String name) throws ServiceException;

	public ResponseEntity findUserNotEmployeeId() throws ServiceException;

	public ResponseEntity findByCostCenterId(Long costCenterId) throws ServiceException;
	
	public ResponseEntity findByEmployeeName(String name) throws ServiceException;

	public String checkDetails(LtMastEmployees ltMastEmployees) throws ServiceException;

	public ResponseEntity getEmployeeDetailsByUserID(Long userId) throws ServiceException;

	public ResponseEntity checkDetailsUpdate(LtMastEmployees ltMastEmployees) throws ServiceException;

	public ResponseEntity getByEmpId(Long no) throws ServiceException;

	public ResponseEntity getLikeNameByDivisionId(String name, String divisionId)  throws ServiceException;

	public Status save(LtMastEmployees ltMastEmployees, MultipartFile[] files) throws ServiceException;

	public Status update(LtMastEmployees ltMastEmployees,MultipartFile[] files) throws ServiceException;

	public ResponseEntity findAll() throws ServiceException;

	public ResponseEntity getLtMastEmployeesByID(Long parseLong) throws ServiceException;

	public Long getCount(LtMastEmployees input) throws ServiceException;

	public List<LtMastEmployees> getDatatableRecords(LtMastEmployees input) throws ServiceException;

	public ResponseEntity getLtMastEmployeesBySuperWID(long employeeId)throws ServiceException;

	public Status updateProfile(MultipartFile[] files, LtMastEmployees emp) throws ServiceException;

	public ResponseEntity<Status> delete(Long id) throws ServiceException;
	
}
