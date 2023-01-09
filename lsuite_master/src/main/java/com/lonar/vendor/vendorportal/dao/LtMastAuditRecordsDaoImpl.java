package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lonar.vendor.vendorportal.model.LtMastAuditRecords;
import com.lonar.vendor.vendorportal.model.LtMastBranches;
import com.lonar.vendor.vendorportal.model.ServiceException;

@Repository
public class LtMastAuditRecordsDaoImpl implements LtMastAuditRecordsDao{

	private JdbcTemplate jdbcTemplate;
	
	private JdbcTemplate getJdbcTemplate() {
		// TODO Auto-generated method stub
		return jdbcTemplate;
	}
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	} 
	
	@Override
	public boolean update(Long auditRecordId, String reason) throws ServiceException {
		int res=0;
		res=jdbcTemplate.update(" UPDATE LT_MAST_AUDIT_RECORDS SET REASON = ?  WHERE AUDIT_RECORD_ID = ? ",reason,auditRecordId);
		if(res!=0)
			return true;
		else
			return false;
	}

	@Override
	public List<LtMastAuditRecords> getByAuditId(float auditId) throws ServiceException {
		String query = " select mar.AUDIT_ID,mar.AUDIT_RECORD_ID,akv.VALUE_NAME as MASTER_NAME,akvv.VALUE_NAME VALUE_NAME, \r\n" + 
				" mar.OLD_VALUE,mar.NEW_VALUE,mar.CREATION_DATE,mu.USER_NAME,mar.REASON \r\n" + 
				" FROM  LT_MAST_AUDIT_RECORDS mar,LT_MAST_AUDIT ma, LT_MAST_AUDIT_KEY_VALUE akv, LT_MAST_AUDIT_KEY_VALUE akvv,LT_MAST_USERS mu  \r\n" + 
				" WHERE mar.AUDIT_ID = ma.AUDIT_ID(+) AND mar.AUDIT_ID = ?\r\n" + 
				" AND ma.MASTER_NAME = akv.KEY_NAME AND mar.VALUE_NAME = akvv.KEY_NAME AND mar.CREATED_BY= mu.USER_ID ";
		
		List<LtMastAuditRecords> list=   jdbcTemplate.query(query, new Object[]{auditId }, 
		 new BeanPropertyRowMapper<LtMastAuditRecords>(LtMastAuditRecords.class)); 
		return list;
	}

	@Override
	public ResponseEntity<LtMastAuditRecords> getByMaster(String masterName) throws ServiceException {
		String query = "  ";
		
		List<LtMastAuditRecords> list=   jdbcTemplate.query(query, new Object[]{masterName.toUpperCase() }, 
		 new BeanPropertyRowMapper<LtMastAuditRecords>(LtMastAuditRecords.class)); 
		return null;
	}

}
