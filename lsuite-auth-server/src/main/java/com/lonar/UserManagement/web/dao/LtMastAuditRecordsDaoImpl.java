package com.lonar.UserManagement.web.dao;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lonar.UserManagement.common.ServiceException;
import com.lonar.UserManagement.web.model.LtMastAuditRecords;

@Repository
@PropertySource(value = "classpath:queries/auditRecordsQueries.properties", ignoreResourceNotFound = true)
public class LtMastAuditRecordsDaoImpl implements LtMastAuditRecordsDao{

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private Environment env;
	
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
	public void save(LtMastAuditRecords ltMastAuditRecords) throws ServiceException {
		int res=0;
		res=jdbcTemplate.update(" INSERT INTO  LT_MAST_AUDIT_RECORDS"
				+ " (AUDIT_RECORD_ID,AUDIT_ID,CREATED_BY,CREATION_DATE,VALUE_NAME,OLD_VALUE,NEW_VALUE,REASON) "
				+ " VALUES (LT_MAST_AUDIT_REC_S.NEXTVAL,?,?,?,?,?,?,?) ",
				ltMastAuditRecords.getAuditId(),ltMastAuditRecords.getCreatedBy(),new Date(),ltMastAuditRecords.getValueName(),
				ltMastAuditRecords.getOldValue(),ltMastAuditRecords.getNewValue(),ltMastAuditRecords.getReason());
	
		
	}

	@Override
	public Long getCount(LtMastAuditRecords input, Long auditId) throws ServiceException {
		String query = env.getProperty("getCountOfLtMastAuditRecords");
		
		String valueName=null;
		if(input.getValueName()!=null && !input.getValueName().equals("")) 
		{valueName="%"+input.getValueName().trim().toUpperCase()+"%";}
		   
		String oldValue=null;
		if(input.getOldValue()!=null && !input.getOldValue().equals("")) 
		{oldValue="%"+input.getOldValue().trim().toUpperCase()+"%";}
		
		String newVal=null;
		if(input.getNewValue()!=null && !input.getNewValue().equals("")) 
		{newVal="%"+input.getNewValue().trim().toUpperCase()+"%";}
		
		
		String empName=null;
		if(input.getEmployeeName()!=null && !input.getEmployeeName().equals("")) 
		{empName="%"+input.getEmployeeName().toUpperCase()+"%";}
		
		 if(input.getStDate() == null || input.getStDate().trim().equals("")) {
			    input.setStDate(null);
		}
		 
		String count  = (String)getJdbcTemplate().queryForObject(
				query, new Object[] {auditId,valueName,oldValue,newVal,empName,input.getStDate()}, String.class);

		
		return Long.parseLong(count);
	}

	@Override
	public List<LtMastAuditRecords> getLtMastAuditRecordsData(LtMastAuditRecords input, Long auditId)
			throws ServiceException {
		
		   
		String valueName=null;
		if(input.getValueName()!=null && !input.getValueName().equals("")) 
		{valueName="%"+input.getValueName().trim().toUpperCase()+"%";}
		   
		String oldValue=null;
		if(input.getOldValue()!=null && !input.getOldValue().equals("")) 
		{oldValue="%"+input.getOldValue().trim().toUpperCase()+"%";}
		
		String newVal=null;
		if(input.getNewValue()!=null && !input.getNewValue().equals("")) 
		{newVal="%"+input.getNewValue().trim().toUpperCase()+"%";}
		
		
		String empName=null;
		if(input.getEmployeeName()!=null && !input.getEmployeeName().equals("")) 
		{empName="%"+input.getEmployeeName().toUpperCase()+"%";}
		
		 if(input.getStDate() == null || input.getStDate().trim().equals("")) {
			    input.setStDate(null);
		}
		 
		if(input.getColumnNo()==0)	
		{
			input.setColumnNo(2);
		}
			
		String query = env.getProperty("geLtMastAuditRecordstData");
			
			return (List<LtMastAuditRecords>) 
					jdbcTemplate.query(query , new Object[]{auditId,valueName,oldValue,newVal,empName,input.getStDate(),
							
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							
							input.getLength() + input.getStart(),input.getStart()+1},
				 new  BeanPropertyRowMapper<LtMastAuditRecords>(LtMastAuditRecords.class));
	}

}
