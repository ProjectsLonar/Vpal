package com.lonar.vendor.vendorportal.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lonar.vendor.vendorportal.dao.LtMastDivisionEmployeeGradeDao;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtMastDivisionEmployeeGrade;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.repository.LtMastDivisionEmployeeGradeRepository;

@Service
public class LtMastDivisionEmployeeGradeServiceImpl implements LtMastDivisionEmployeeGradeService,CodeMaster {
	@Autowired
	LtMastDivisionEmployeeGradeDao ltP2pDivisionEmployeeGradeDao;

	@Autowired
	LtMastDivisionEmployeeGradeRepository ltP2pDivisionEmployeeGradeRepository;
	
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	@Override
	public List<LtMastDivisionEmployeeGrade> findByDivisionId(Long divisionId) throws ServiceException {
		// TODO Auto-generated method stub
		return ltP2pDivisionEmployeeGradeDao.findByDivisionId(divisionId);
	}

	@Override
	public List<LtMastDivisionEmployeeGrade> findByGrade(String grade) throws ServiceException {
		// TODO Auto-generated method stub
		return ltP2pDivisionEmployeeGradeDao.findByGrade(grade);
	}

	@Override
	public List<LtMastDivisionEmployeeGrade> findAllActive() throws ServiceException {
		// TODO Auto-generated method stub
		return ltP2pDivisionEmployeeGradeDao.findAllActive();
	}

	@Override
	public List<LtMastDivisionEmployeeGrade> findActiveLikeDivisionName(String divisionName) throws ServiceException {
		// TODO Auto-generated method stub
		return ltP2pDivisionEmployeeGradeDao.findActiveLikeDivisionName(divisionName);
	}

	@Override
	public List<LtMastDivisionEmployeeGrade> findByDivisionIdANDGrade(Long divisionId, String grade) throws ServiceException {
		// TODO Auto-generated method stub
		return ltP2pDivisionEmployeeGradeDao.findByDivisionIdANDGrade(divisionId, grade);
	}

	@Override
	public List<LtMastDivisionEmployeeGrade> getAll() throws ServiceException {
		// TODO Auto-generated method stub
		return ltP2pDivisionEmployeeGradeDao.getAll();
	}

	@Override
	public LtMastDivisionEmployeeGrade getLtP2pDivisionEmployeeGradeByID(Long id) throws ServiceException {
		// TODO Auto-generated method stub
		return ltP2pDivisionEmployeeGradeDao.getLtP2pDivisionEmployeeGradeByID(id);
	}

	@Override
	public ResponseEntity<Status> save(LtMastDivisionEmployeeGrade ltP2pDivisionEmployeeGrade) throws ServiceException {

		Status status = new Status();
		String notnull = status.getMessage() == null ? "" : status.getMessage();
		
		List<LtMastDivisionEmployeeGrade> ltP2pDivisionEmployeeGradeList = ltP2pDivisionEmployeeGradeDao
					.findByDivisionIdANDGrade(ltP2pDivisionEmployeeGrade.getDivisionId(),
							ltP2pDivisionEmployeeGrade.getGrade());
			if (!ltP2pDivisionEmployeeGradeList.isEmpty()
					&& (ltP2pDivisionEmployeeGrade.getDivEmployeeGradeId() == null ? true
							: !ltP2pDivisionEmployeeGrade.getDivEmployeeGradeId()
									.equals(ltP2pDivisionEmployeeGradeList.get(0).getDivEmployeeGradeId()))) {

				status.setCode(FAIL);
				status.setMessage("Division with same grade already exists.");
				return new ResponseEntity<Status>(status, HttpStatus.OK);
			}
			ltP2pDivisionEmployeeGrade.setCreatedBy(ltP2pDivisionEmployeeGrade.getLastUpdateLogin());
			ltP2pDivisionEmployeeGrade.setLastUpdatedBy(ltP2pDivisionEmployeeGrade.getLastUpdateLogin());
			ltP2pDivisionEmployeeGrade.setLastUpdateDate(new Date());
			ltP2pDivisionEmployeeGrade.setCreationDate(new Date());
			ltP2pDivisionEmployeeGradeRepository.save(ltP2pDivisionEmployeeGrade);
			if(ltP2pDivisionEmployeeGrade.getDivEmployeeGradeId()!=null) {
				status=ltMastCommonMessageService.getCodeAndMessage(INSERT_SUCCESSFULLY);
				if( status.getMessage()==null)
				{
					status.setCode(SUCCESS);
					status.setMessage("Error in finding message! The action is completed successfully.");
				}
			}
			else {
				status=ltMastCommonMessageService.getCodeAndMessage(INSERT_FAIL);
				return new ResponseEntity<Status>(status, HttpStatus.OK);
				
			}
			return new ResponseEntity<Status>(status, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Status> update(LtMastDivisionEmployeeGrade ltP2pDivisionEmployeeGrade)
			throws ServiceException {
		Status status = new Status();
		String notnull = status.getMessage() == null ? "" : status.getMessage();
		
		List<LtMastDivisionEmployeeGrade> ltP2pDivisionEmployeeGradeList = ltP2pDivisionEmployeeGradeDao
					.findByDivisionIdANDGrade(ltP2pDivisionEmployeeGrade.getDivisionId(),
							ltP2pDivisionEmployeeGrade.getGrade());
			if (!ltP2pDivisionEmployeeGradeList.isEmpty()
					&& (ltP2pDivisionEmployeeGrade.getDivEmployeeGradeId() == null ? true
							: !ltP2pDivisionEmployeeGrade.getDivEmployeeGradeId()
									.equals(ltP2pDivisionEmployeeGradeList.get(0).getDivEmployeeGradeId()))) {

				status.setCode(FAIL);
				status.setMessage("Division with same grade already exists.");
				return new ResponseEntity<Status>(status, HttpStatus.OK);
			}
			ltP2pDivisionEmployeeGrade.setCreatedBy(ltP2pDivisionEmployeeGrade.getLastUpdateLogin());
			ltP2pDivisionEmployeeGrade.setLastUpdatedBy(ltP2pDivisionEmployeeGrade.getLastUpdateLogin());
			ltP2pDivisionEmployeeGrade.setLastUpdateDate(new Date());
			ltP2pDivisionEmployeeGrade.setCreationDate(new Date());
			ltP2pDivisionEmployeeGradeRepository.save(ltP2pDivisionEmployeeGrade);
			if(ltP2pDivisionEmployeeGrade.getDivEmployeeGradeId()!=null) {
				status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_SUCCESSFULLY);
				if( status.getMessage()==null)
				{
					status.setCode(SUCCESS);
					status.setMessage("Error in finding message! The action is completed successfully.");
				}
			}
			else {
				status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_FAIL);
				return new ResponseEntity<Status>(status, HttpStatus.OK);
				
			}
			return new ResponseEntity<Status>(status, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Status> delete(Long id) throws ServiceException {
		Status status = new Status();
		ltP2pDivisionEmployeeGradeRepository.delete(id);
			if (!ltP2pDivisionEmployeeGradeRepository.exists(id)) {
				status=ltMastCommonMessageService.getCodeAndMessage(DELETE_SUCCESSFULLY);
				if( status.getMessage()==null)
				{
					status.setCode(SUCCESS);
					status.setMessage("Error in finding message! The action is completed successfully.");
				}
			} else {
				status=ltMastCommonMessageService.getCodeAndMessage(DELETE_FAIL);
				if( status.getMessage()==null)
				{
					status.setCode(SUCCESS);
					status.setMessage("Error in finding message! The action is completed unsuccessfully.");
				}
				
			}
			return new ResponseEntity<Status>(status, HttpStatus.OK);
	
	}

	@Override
	public Long getCount(LtMastDivisionEmployeeGrade input) throws ServiceException {
		return ltP2pDivisionEmployeeGradeDao.getCount(input);
	}

	@Override
	public List<LtMastDivisionEmployeeGrade> getDatatableRecords(LtMastDivisionEmployeeGrade input)
			throws ServiceException {
		if(input.getColumnNo()==1 && input.getSort().equals("desc"))
		{ input.setColumnNo(11); }
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
		if(input.getColumnNo()==0)
		{
			input.setColumnNo(8);
		}
		return ltP2pDivisionEmployeeGradeDao.getDataTableRecords(input);
	}

}
