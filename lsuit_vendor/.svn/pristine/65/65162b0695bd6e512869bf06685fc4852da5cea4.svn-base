package com.lonar.vendor.vendorportal.csvupload;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
@PropertySource(value = "classpath:sysRequestQueries.properties", ignoreResourceNotFound = true)
public class LtMastSysRequestsDaoImpl implements LtMastSysRequestsDao
{
	@Autowired
	private Environment env;
	
	@PersistenceContext(name = "em")
	private EntityManager em;

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
	public Long getCount(LtMastSysRequests input) throws Exception 
	{
		String query = env.getProperty("getLtMastSysRequestsCount");
	
		String reqId=null;
		if(input.getRequestId()!=null  )
		{ reqId = "%"+input.getRequestId()+"%"; }
		
		String reqName=null;
		if(input.getRequestName()!=null && !input.getRequestName().equals(""))
		{ reqName = "%"+input.getRequestName().trim().toUpperCase()+"%"; }
		
		String requstorName=null;
		if(input.getRequestorName()!=null && !input.getRequestorName().equals(""))
		{ requstorName = "%"+input.getRequestorName().trim().toUpperCase()+"%"; }
		
		String fileName=null;
		if(input.getFileName()!=null && !input.getFileName().equals(""))
		{ fileName = "%"+input.getFileName().trim().toUpperCase()+"%"; }
		
		String phase=null;
		if(input.getPhase()!=null && !input.getPhase().equals(""))
		{ phase = "%"+input.getPhase().trim().toUpperCase()+"%"; }
		
		String status=null;
		if(input.getStatus()!=null && !input.getStatus().equals("")) 
		{status="%"+input.getStatus().toUpperCase()+"%";}
			
		if(input.getStDate() == null || input.getStDate().trim().equals(""))
		{input.setStDate(null);}
		   
		if(input.getEnDate() == null || input.getEnDate().trim().equals(""))
		{input.setEnDate(null);}
		   
	   
		   
		if(input.getEnDate() == null || input.getEnDate().trim().equals(""))
		{input.setEnDate(null);}
		   
		   String count  = (String)getJdbcTemplate().queryForObject(
				   query, new Object[] {reqId,reqName,requstorName,
						   input.getStDate(),input.getEnDate(),fileName,phase, status}, String.class);
		
			return Long.parseLong(count);
	}

	@Override
	public List<LtMastSysRequests> getLtMastSysRequestsDataTableRecords(LtMastSysRequests input) throws Exception
	{
		String query = env.getProperty("getLtMastSysRequestsDataTableRecords");
		
		String reqId=null;
		if(input.getRequestId()!=null  )
		{ reqId = "%"+input.getRequestId()+"%"; }
		
		String reqName=null;
		if(input.getRequestName()!=null && !input.getRequestName().equals(""))
		{ reqName = "%"+input.getRequestName().trim().toUpperCase()+"%"; }
		
		String requstorName=null;
		if(input.getRequestorName()!=null && !input.getRequestorName().equals(""))
		{ requstorName = "%"+input.getRequestorName().trim().toUpperCase()+"%"; }
		
		String fileName=null;
		if(input.getFileName()!=null && !input.getFileName().equals(""))
		{ fileName = "%"+input.getFileName().trim().toUpperCase()+"%"; }
		
		String phase=null;
		if(input.getPhase()!=null && !input.getPhase().equals(""))
		{ phase = "%"+input.getPhase().trim().toUpperCase()+"%"; }
		
		String status=null;
		if(input.getStatus()!=null && !input.getStatus().equals("")) 
		{status="%"+input.getStatus().toUpperCase()+"%";}
			
		if(input.getStDate() == null || input.getStDate().trim().equals(""))
		{input.setStDate(null);}
		   
		if(input.getEnDate() == null || input.getEnDate().trim().equals(""))
		{input.setEnDate(null);}
		   
	    if(input.getColumnNo()==0)
		{
			input.setColumnNo(9);
		}
	    
	
		   return jdbcTemplate.query(query, new Object[] { reqId,reqName,requstorName,
				   input.getStDate(),input.getEnDate(),fileName,phase, status,
					input.getColumnNo(),input.getColumnNo(),
					input.getColumnNo(),input.getColumnNo(),
					input.getColumnNo(),input.getColumnNo(),
					input.getColumnNo(),input.getColumnNo(),
					input.getColumnNo(),input.getColumnNo(),
					input.getColumnNo(),input.getColumnNo(),
					input.getColumnNo(),input.getColumnNo(),
					input.getColumnNo(),input.getColumnNo(),
					input.getColumnNo(),input.getColumnNo(),
					input.getStart()+input.getLength(),input.getStart()+1},

			new RowMapper<LtMastSysRequests>() {
				@Override
				public LtMastSysRequests mapRow(ResultSet rs, int row) throws SQLException {
					LtMastSysRequests ltMastSysRequests = new LtMastSysRequests();
					ltMastSysRequests.setRequestId(rs.getLong("REQUEST_ID"));
					ltMastSysRequests.setRequestName(rs.getString("REQUEST_NAME"));
					ltMastSysRequests.setRequestorName(rs.getString("REQUESTOR_NAME"));
					ltMastSysRequests.setStartDate(rs.getDate("ACTUAL_START_DATE"));
					ltMastSysRequests.setEndDate(rs.getDate("ACTUAL_END_DATE"));
					ltMastSysRequests.setFileName(rs.getString("FILE_NAME"));
					ltMastSysRequests.setPhase(rs.getString("PHASE"));
					ltMastSysRequests.setStatus(rs.getString("STATUS"));
					
					return ltMastSysRequests;
					
				}

			}

	);
	}

	@Override
	public Long getLtMastSysRequestReportCount(LtMastSysRequestReport input,Long reqId) throws Exception 
	{
		String query = env.getProperty("getLtMastSysRequestReportCount");
		
		String code=null;
		if(input.getCode()!=null && input.getCode().equals(""))
		{ code = "%"+input.getCode().trim().toUpperCase()+"%"; }
		
		String desc=null;
		if(input.getDescription()!=null && input.getDescription().equals(""))
		{ desc = "%"+input.getDescription().trim().toUpperCase()+"%"; }
		
		String status=null;
		if(input.getStatus()!=null && input.getStatus().equals(""))
		{ status = "%"+input.getStatus().trim().toUpperCase()+"%"; }
			
		String error=null;
		if(input.getErrorCode()!=null && input.getErrorCode().equals(""))
		{ error = "%"+input.getErrorCode().trim().toUpperCase()+"%"; }
		
		String msg=null;
		if(input.getErrorMessage()!=null && input.getErrorMessage().equals(""))
		{ msg = "%"+input.getErrorMessage().trim().toUpperCase()+"%"; }
		   
		   String count  = (String)getJdbcTemplate().queryForObject(
				   query, new Object[] {reqId,input.getRequestId(),code,desc,status,error,msg}, String.class);
		
			return Long.parseLong(count);
	}

	@Override
	public List<LtMastSysRequestReport> getLtMastSysRequestReportDataTableRecords(LtMastSysRequestReport input,Long reqId)
			throws Exception 
	{
		String query = env.getProperty("getLtMastSysRequestReportDataTableRecords");
		
		String code=null;
		if(input.getCode()!=null && !input.getCode().equals(""))
		{ code = "%"+input.getCode().trim().toUpperCase()+"%"; }
		
		String desc=null;
		if(input.getDescription()!=null && !input.getDescription().equals(""))
		{ desc = "%"+input.getDescription().trim().toUpperCase()+"%"; }
		
		String status=null;
		if(input.getStatus()!=null && !input.getStatus().equals(""))
		{ status = "%"+input.getStatus().trim().toUpperCase()+"%"; }
			
		String error=null;
		if(input.getErrorCode()!=null && !input.getErrorCode().equals(""))
		{ error = "%"+input.getErrorCode().trim().toUpperCase()+"%"; }
		
		String msg=null;
		if(input.getErrorMessage()!=null && !input.getErrorMessage().equals(""))
		{ msg = "%"+input.getErrorMessage().trim().toUpperCase()+"%"; }
		   
	    if(input.getColumnNo()==0)
		{
			input.setColumnNo(8);
		}
	    
		
		   return jdbcTemplate.query(query, new Object[] { reqId,input.getRequestId(),code,desc,status,error,msg,
					input.getColumnNo(),input.getColumnNo(),
					input.getColumnNo(),input.getColumnNo(),
					input.getColumnNo(),input.getColumnNo(),
					input.getColumnNo(),input.getColumnNo(),
					input.getColumnNo(),input.getColumnNo(),
					input.getColumnNo(),input.getColumnNo(),
					input.getColumnNo(),input.getColumnNo(),
					
					input.getStart()+input.getLength(),input.getStart()+1},

			new RowMapper<LtMastSysRequestReport>() {
				@Override
				public LtMastSysRequestReport mapRow(ResultSet rs, int row) throws SQLException {
					LtMastSysRequestReport ltMastSysRequestReport = new LtMastSysRequestReport();
					ltMastSysRequestReport.setRequestId(rs.getLong("REQUEST_ID"));
					ltMastSysRequestReport.setCode(rs.getString("CODE"));
					ltMastSysRequestReport.setDescription(rs.getString("DESCRIPTION"));
					ltMastSysRequestReport.setStatus(rs.getString("STATUS"));
					ltMastSysRequestReport.setErrorCode(rs.getString("ERROR_CODE"));
					ltMastSysRequestReport.setErrorMessage(rs.getString("ERROR_MESSAGE"));
					
					return ltMastSysRequestReport;
					
				}

			}

	);
	}

	
}
