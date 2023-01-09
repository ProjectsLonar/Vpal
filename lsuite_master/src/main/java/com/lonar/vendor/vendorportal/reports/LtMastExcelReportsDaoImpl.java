package com.lonar.vendor.vendorportal.reports;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lonar.vendor.vendorportal.model.LtMastReportRequest;
import com.lonar.vendor.vendorportal.model.ServiceException;

@Repository
@PropertySource(value = "classpath:queries/reportQueries.properties", ignoreResourceNotFound = true)
public class LtMastExcelReportsDaoImpl implements LtMastExcelReportsDao{

	@Autowired
	private Environment env;

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	} 
	
	private JdbcTemplate getJdbcTemplate() {
		// TODO Auto-generated method stub
		return jdbcTemplate;
	}
	
	@Override
	public List<LtMastMasterReportMap> getHeader(String masterName) throws ServiceException 
	{
		String query = env.getProperty("getLtMastMasterReportMapHeader");
		
		List<LtMastMasterReportMap> list = (List<LtMastMasterReportMap>) 
				jdbcTemplate.query(query , new Object[]{ masterName.trim().toUpperCase()},
			 new  BeanPropertyRowMapper<LtMastMasterReportMap>(LtMastMasterReportMap.class));
		return list;

		
	}

	@Override
	public Long getCount(LtMastReportRequest input,Long companyId) throws ServiceException {
		String query = env.getProperty("getLtMastReportRequestCount");
		 
		System.out.println("input.getRequestId() "+input.getRequestId());
			String reqId=null;
			if(input.getRequestIdStr()!=null && !input.getRequestIdStr().equals(" ") )
			{reqId="%"+input.getRequestIdStr()+"%";}
		   
		   String requestName=null;
		   if(input.getRequestName()!=null && !input.getRequestName().equals(" ") && !input.getRequestName().isEmpty())
		   {requestName="%"+input.getRequestName().toUpperCase()+"%";}
		   
		   String fileName=null;
		   if(input.getFileName()!=null && !input.getFileName().equals(" ") && !input.getFileName().isEmpty())
		   {fileName="%"+input.getFileName().toUpperCase()+"%";}
		   
		   String filePath=null;
		   if(input.getFilePath()!=null && !input.getFilePath().equals(" ") && !input.getFilePath().isEmpty())
		   {filePath="%"+input.getFilePath().toUpperCase()+"%";}
		   
		   if(input.getReqDate() == null || input.getReqDate().trim().equals(""))
			{
				input.setReqDate(null);
			}
		   
		   if(input.getCompDate() == null || input.getCompDate().trim().equals(""))
			{
				input.setCompDate(null);
			}
		   
		   String status=null;
		   if(input.getStatus()!=null && !input.getStatus().equals(" ") && !input.getStatus().isEmpty()) 
		   {status="%"+input.getStatus().toUpperCase()+"%";}
		   
		   String empName=null;
		   if(input.getRequestorName()!=null && !input.getRequestorName().equals(" ") && !input.getRequestorName().isEmpty()) 
		   {empName="%"+input.getRequestorName().toUpperCase()+"%";}
			
		   System.out.println("reqId "+reqId);
			
		String count  = (String)getJdbcTemplate().queryForObject(
			query, new Object[] {companyId,reqId,requestName,fileName,input.getReqDate(),input.getCompDate(),status,empName }, String.class);

		
		return Long.parseLong(count);
	}

	@Override
	public List<LtMastReportRequest> getReportRequestDataTableRecords(LtMastReportRequest input,Long companyId)
			throws ServiceException {
		String query = env.getProperty("getLtMastReportRequestDatatableRecords");
		
		String reqId=null;
		if(input.getRequestIdStr()!=null && !input.getRequestIdStr().equals(" ") )
		{reqId="%"+input.getRequestIdStr()+"%";}
	   
	   String requestName=null;
	   if(input.getRequestName()!=null && !input.getRequestName().equals(" ") && !input.getRequestName().isEmpty())
	   {requestName="%"+input.getRequestName().toUpperCase()+"%";}
	   
	   String fileName=null;
	   if(input.getFileName()!=null && !input.getFileName().equals(" ") && !input.getFileName().isEmpty())
	   {fileName="%"+input.getFileName().toUpperCase()+"%";}
	   
	   String filePath=null;
	   if(input.getFilePath()!=null && !input.getFilePath().equals(" ") && !input.getFilePath().isEmpty())
	   {filePath="%"+input.getFilePath().toUpperCase()+"%";}
	   
	   if(input.getReqDate() == null || input.getReqDate().trim().equals(""))
		{
			input.setReqDate(null);
		}
	   
	   if(input.getCompDate() == null || input.getCompDate().trim().equals(""))
		{
			input.setCompDate(null);
		}
	   
	   String status=null;
	   if(input.getStatus()!=null && !input.getStatus().equals(" ") && !input.getStatus().isEmpty()) 
	   {status="%"+input.getStatus().toUpperCase()+"%";}
	   
	   String empName=null;
	   if(input.getRequestorName()!=null && !input.getRequestorName().equals(" ") && !input.getRequestorName().isEmpty()) 
	   {empName="%"+input.getRequestorName().toUpperCase()+"%";}
		
	   if(input.getColumnNo()==0) {
		   input.setColumnNo(12);
	   }
	   
			List<LtMastReportRequest> list = (List<LtMastReportRequest>) 
					jdbcTemplate.query(query , new Object[]{companyId,reqId,requestName,fileName,input.getReqDate(),input.getCompDate(),
							status,empName,
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							
							input.getStart()+input.getLength(),input.getStart()+1},
				 new  BeanPropertyRowMapper<LtMastReportRequest>(LtMastReportRequest.class));
			
				return list;
	}

}
