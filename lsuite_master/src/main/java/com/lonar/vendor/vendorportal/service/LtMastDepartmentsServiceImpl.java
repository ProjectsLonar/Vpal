package com.lonar.vendor.vendorportal.service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lonar.vendor.vendorportal.dao.LtMastDepartmentsDao;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtMastDepartments;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

@Service
public class LtMastDepartmentsServiceImpl implements LtMastDepartmentsService, CodeMaster {

	@Autowired
	LtMastDepartmentsDao ltMastDepartmentsDao;

	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;

	@Override
	public Long getCount(LtMastDepartments input, Long companyId) throws ServiceException {
		return ltMastDepartmentsDao.getCount(input, companyId);
	}

	@Override
	public List<LtMastDepartments> getDataTable(LtMastDepartments input, Long companyId) throws ServiceException {

		if (input.getColumnNo() == 1 && input.getSort().equals("asc")) {
			input.setColumnNo(11);
		}
		if (input.getColumnNo() == 2 && input.getSort().equals("desc")) {
			input.setColumnNo(12);
		}
		if (input.getColumnNo() == 3 && input.getSort().equals("desc")) {
			input.setColumnNo(13);
		}
		if (input.getColumnNo() == 4 && input.getSort().equals("desc")) {
			input.setColumnNo(14);
		}
		if (input.getColumnNo() == 5 && input.getSort().equals("desc")) {
			input.setColumnNo(15);
		}
		if (input.getColumnNo() == 6 && input.getSort().equals("desc")) {
			input.setColumnNo(16);
		}
		if (input.getColumnNo() == 7 && input.getSort().equals("desc")) {
			input.setColumnNo(17);
		}
		if (input.getColumnNo() == 0) {
			input.setColumnNo(1);
		}

		List<LtMastDepartments> depList = ltMastDepartmentsDao.getDataTable(input, companyId);
		return depList;
	}

	@Override
	public ResponseEntity<Status> save(LtMastDepartments ltMastDepartments) throws ServiceException {
		Status status = new Status();
		String chkDuplicate = checkDuplicate(ltMastDepartments);
		if (chkDuplicate == null) {

			ltMastDepartments.setCreationDate(new Date());
			ltMastDepartments.setLastUpdateDate(new Date());
			ltMastDepartments.setLastUpdatedBy(ltMastDepartments.getLastUpdateLogin());
			ltMastDepartments = ltMastDepartmentsDao.save(ltMastDepartments);
			if (ltMastDepartments.getDepartmentId() != null) {
				status = ltMastCommonMessageService.getCodeAndMessage(INSERT_SUCCESSFULLY);
			} else {
				status = ltMastCommonMessageService.getCodeAndMessage(INSERT_FAIL);
			}
		} else {
			status.setCode(FAIL);
			status.setMessage(chkDuplicate);
		}
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}

	private String checkDuplicate(LtMastDepartments ltMastDepartments) throws ServiceException {
		List<LtMastDepartments> ltMastDepartment = ltMastDepartmentsDao.getByName(ltMastDepartments.getDepartmentName(),
				ltMastDepartments.getCompanyId());
		if (!ltMastDepartment.isEmpty()) {
			if (!ltMastDepartment.get(0).getDepartmentId().equals(ltMastDepartments.getDepartmentId())) {
				return "Department name already exists";
			}
		}

		ltMastDepartment = ltMastDepartmentsDao.getByCode(ltMastDepartments.getDepartmentCode(),
				ltMastDepartments.getCompanyId());
		if (!ltMastDepartment.isEmpty()) {
			if (!ltMastDepartment.get(0).getDepartmentId().equals(ltMastDepartments.getDepartmentId())) {
				return "Department code already exists";
			}
		}
		return null;
	}

	@Override
	public ResponseEntity<Status> update(LtMastDepartments ltMastDepartments) throws ServiceException {
		Status status = new Status();
		String chkDuplicate = checkDuplicate(ltMastDepartments);
		if (chkDuplicate == null) {

			ltMastDepartments.setLastUpdateDate(new Date());
			ltMastDepartments.setLastUpdatedBy(ltMastDepartments.getLastUpdateLogin());
			ltMastDepartments = ltMastDepartmentsDao.update(ltMastDepartments);
			if (ltMastDepartments.getDepartmentId() != null) {
				status = ltMastCommonMessageService.getCodeAndMessage(UPDATE_SUCCESSFULLY);
			} else {
				status = ltMastCommonMessageService.getCodeAndMessage(UPDATE_FAIL);
			}
		} else {
			status.setCode(FAIL);
			status.setMessage(chkDuplicate);
		}
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Status> delete(Long id) throws ServiceException {
		Status status = new Status();
		LtMastDepartments ltMastDepartments = ltMastDepartmentsDao.delete(id);
		if (ltMastDepartments == null) {
			status = ltMastCommonMessageService.getCodeAndMessage(DELETE_SUCCESSFULLY);
		} else {
			status = ltMastCommonMessageService.getCodeAndMessage(DELETE_FAIL);
		}
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}

	@Override
	public LtMastDepartments findById(Long id) throws ServiceException {
		// TODO Auto-generated method stub
		return ltMastDepartmentsDao.findById(id);
	}

	@Override
	public List<LtMastDepartments> getAll() throws ServiceException {
		// TODO Auto-generated method stub
		return ltMastDepartmentsDao.getAll();
	}

	@Override
	public List<LtMastDepartments> getLikeName(String name, Long companyId) throws ServiceException {
		// TODO Auto-generated method stub
		return ltMastDepartmentsDao.getLikeName(name, companyId);
	}

}
