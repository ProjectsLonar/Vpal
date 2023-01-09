package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lonar.vendor.vendorportal.model.LtMastDocumentList;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.repository.LtVendCompanyRepository;

@Repository
@PropertySource(value = "classpath:queries/documentListQueries.properties", ignoreResourceNotFound = true)
public class LtMastDocumentListDaoImpl implements LtMastDocumentListDao{

	@Autowired
	private Environment env;

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	LtVendCompanyRepository ltVendCompanyRepository;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	} 
	
	private JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	@Override
	public Long getCount(LtMastDocumentList input,Long companyId) throws ServiceException {
		String query = env.getProperty("getCountLtMastDocumentList");
		
		   String uploadedBy=null;
		   if(input.getUploadedBy()!=null)
		   {uploadedBy="%"+input.getUploadedBy().toUpperCase()+"%";}
		   
		   String fileName=null;
		   if(input.getFileName()!=null)
		   {fileName="%"+input.getFileName().toUpperCase()+"%";}
		   
		   if(input.getStDate() == null || input.getStDate().trim().equals(""))
		   {
				input.setStDate(null);}
			
		
		String count  = (String)getJdbcTemplate().queryForObject(
				query, new Object[] {companyId,fileName,uploadedBy,input.getStDate()}, String.class);

		
		return Long.parseLong(count);
	}

	@Override
	public List<LtMastDocumentList> getDataTableRecords(LtMastDocumentList input,Long companyId) throws ServiceException {
		String query = env.getProperty("getLtMastDocumentListDatatableRecords");
		
		String uploadedBy=null;
		   if(input.getUploadedBy()!=null)
		   {uploadedBy="%"+input.getUploadedBy().toUpperCase()+"%";}
		   
		   String fileName=null;
		   if(input.getFileName()!=null)
		   {fileName="%"+input.getFileName().toUpperCase()+"%";}
		   
		   if(input.getStDate() == null || input.getStDate().trim().equals(""))
		   {
				input.setStDate(null);}
			
			if(input.getColumnNo()==0)
			{
				input.setColumnNo(4);
			}
			
			List<LtMastDocumentList> list = (List<LtMastDocumentList>) 
					jdbcTemplate.query(query , new Object[]{companyId,fileName,uploadedBy,input.getStDate(),
							
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
						
							input.getStart()+input.getLength(),input.getStart()+1},
				 new  BeanPropertyRowMapper<LtMastDocumentList>(LtMastDocumentList.class));
				return list;
	}

	@Override
	public Long getCompanyId(Long lastUpdateLogin) throws ServiceException {
		String query = env.getProperty("getCompanyIdByUserId");
		String count  = (String)getJdbcTemplate().queryForObject(query, new Object[] {lastUpdateLogin}, String.class);

		return Long.parseLong(count);
	}

}
