package com.lonar.vendor.vendorportal.service;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lonar.vendor.vendorportal.dao.LtMastVendorClientsDao;
import com.lonar.vendor.vendorportal.model.LtMastVendorClients;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

@Service
public class LtMastVendorClientsServiceImpl implements LtMastVendorClientsService {

	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;

	@Autowired
	LtMastVendorClientsDao ltMastVendorClientsDao;

	@Transactional
	@Override
	public List<LtMastVendorClients> getAllVendorClients() throws ServiceException {
		List<LtMastVendorClients> ltMastVendorClientsList = new ArrayList<LtMastVendorClients>();

		ltMastVendorClientsList = ltMastVendorClientsDao.getAllVendorClients();

		return ltMastVendorClientsList;
	}

	@Transactional
	@Override
	public List<LtMastVendorClients> getVendorClientsByVendorId(Long vendorClientsId) throws ServiceException {

		List<LtMastVendorClients> ltMastVendorClients = new ArrayList<LtMastVendorClients>();

		ltMastVendorClients = ltMastVendorClientsDao.getVendorClientsByVendorId(vendorClientsId);

		return ltMastVendorClients;
	}

	@Transactional
	@Override
	public LtMastVendorClients getVendorClientsById(Long vendorClientsId) throws ServiceException {

		LtMastVendorClients ltMastVendorClients = new LtMastVendorClients();

		ltMastVendorClients = ltMastVendorClientsDao.getVendorClientsById(vendorClientsId);

		return ltMastVendorClients;
	}

	@Transactional
	@Override
	public Status save(LtMastVendorClients ltMastVendorClients) throws ServiceException {
		Status status = new Status();

		String isChecknull = checkNull(ltMastVendorClients);
		if (isChecknull.equals("null")) {
			status = ltMastCommonMessageService.getCodeAndMessage(INPUT_IS_EMPTY);
			if (status.getMessage() == null) {
				status.setCode(EXCEPTION);
				status.setMessage("Error in finding message! The action was unsuccessful");
			}
		} else {
			if (ltMastVendorClientsDao.save(ltMastVendorClients)) {
				status = ltMastCommonMessageService.getCodeAndMessage(INSERT_SUCCESSFULLY);
				if (status.getMessage() == null) {
					status.setCode(SUCCESS);
					status.setMessage("Error in finding message! The action is completed successfully.");
				}
			} else {
				status = ltMastCommonMessageService.getCodeAndMessage(INSERT_FAIL);
				if (status.getMessage() == null) {
					status.setCode(EXCEPTION);
					status.setMessage("Error in finding message! The action was unsuccessful");
				}
			}
		}

		return status;
	}

	@Transactional
	@Override
	public Status update(LtMastVendorClients ltMastVendorClients) throws ServiceException {
		Status status = new Status();

		if (ltMastVendorClients.getVendorClientsId() != null) {
			String isCheckNull = checkNull(ltMastVendorClients);
			if (isCheckNull.equals("null")) {
				status = ltMastCommonMessageService.getCodeAndMessage(INPUT_IS_EMPTY);
				if (status.getMessage() == null) {
					status.setCode(EXCEPTION);
					status.setMessage("Error in finding message! The action was unsuccessful");
				}
			} else {
				if (ltMastVendorClientsDao.update(ltMastVendorClients)) {
					status = ltMastCommonMessageService.getCodeAndMessage(UPDATE_SUCCESSFULLY);
					if (status.getMessage() == null) {
						status.setCode(SUCCESS);
						status.setMessage("Error in finding message! The action is completed successfully.");
					}
				} else {
					status = ltMastCommonMessageService.getCodeAndMessage(UPDATE_FAIL);
					if (status.getMessage() == null) {
						status.setCode(EXCEPTION);
						status.setMessage("Error in finding message! The action was unsuccessful");
					}
				}
			}

		} else {
			status = ltMastCommonMessageService.getCodeAndMessage(INPUT_IS_EMPTY);
			if (status.getMessage() == null) {
				status.setCode(EXCEPTION);
				status.setMessage("Error in finding message! The action was unsuccessful");
			}
		}

		return status;
	}

	@Transactional
	@Override
	public Status delete(Long vendorClientsId) throws ServiceException {
		Status status = new Status();
		if (ltMastVendorClientsDao.delete(vendorClientsId)) {
			status = ltMastCommonMessageService.getCodeAndMessage(DELETE_SUCCESSFULLY);
			if (status.getMessage() == null) {
				status.setCode(SUCCESS);
				status.setMessage("Error in finding message! The action is completed successfully.");
			}
		} else {
			status = ltMastCommonMessageService.getCodeAndMessage(DELETE_FAIL);
			if (status.getMessage() == null) {
				status.setCode(EXCEPTION);
				status.setMessage("Error in finding message! The action was unsuccessful");
			}
		}
		return status;
	}

	public static String checkNull(LtMastVendorClients ltMastVendorClients) {
		if (ltMastVendorClients.getCreatedBy() == null || ltMastVendorClients.getCreationDate() == null
				|| ltMastVendorClients.getLastUpdateLogin() == null) {
			return "null";
		} else
			return "notnull";

	}

	@Override
	public Status checkRecord(Long venId) throws ServiceException {
		Status status = new Status();
		List<LtMastVendorClients> list = ltMastVendorClientsDao.getVendorClientsByVendorId(venId);
		if (list.isEmpty()) {
			status.setCode(FAIL);
			status.setMessage("Please fill vendor client details");
		} else {
			status.setCode(SUCCESS);
		}
		return status;
	}

	@Override
	public Long getVendorClientsByVendorIdDataTableCount(Long vendorId, LtMastVendorClients input)
			throws ServiceException {
		return ltMastVendorClientsDao.getVendorClientsByVendorIdDataTableCount(vendorId, input);
	}

	@Override
	public List<LtMastVendorClients> getVendorClientsByVendorIdDataTable(Long vendorId, LtMastVendorClients input)
			throws ServiceException {
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
		if (input.getColumnNo() == 8 && input.getSort().equals("desc")) {
			input.setColumnNo(18);
		}
		if (input.getColumnNo() == 9 && input.getSort().equals("asc")) {
			input.setColumnNo(19);
		}
		if (input.getColumnNo() == 0) {
			input.setColumnNo(9);
		}
		return ltMastVendorClientsDao.getVendorClientsByVendorIdDataTable(vendorId, input);
	}

}
