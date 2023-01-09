package com.lonar.vendor.vendorportal.dao;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lonar.vendor.vendorportal.model.LtPoLines;
import com.lonar.vendor.vendorportal.model.ServiceException;

@Repository
@PropertySource(value = "classpath:queries/poLineQueries.properties", ignoreResourceNotFound = true)
public class LtPoLinesDaoImpl implements LtPoLinesDao{

	@Autowired
	private Environment env;
	
	private JdbcTemplate jdbcTemplate;
	
	private JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public Long getLtPoLinesCount(Long headerId, LtPoLines input) throws ServiceException {
		String query = env.getProperty("getLtPoLinesCountByHeaderId");
		 
		 String lineNumber=null;
		   if(input.getLineNum()!=null && !input.getLineNum().equals(""))
		   {lineNumber="%"+input.getLineNum()+"%";}
		   
		   String proCode=null;
		   if(input.getProductCode()!=null ) 
		   {proCode="%"+input.getProductCode().toUpperCase()+"%";}
		   
		   String quantity=null;
		   if(input.getQuantity()!=null ) 
		   {proCode="%"+input.getQuantity()+"%";}
		   
		   String category=null;
		   if(input.getProductCategory()!=null ) 
		   {proCode="%"+input.getProductCategory().toUpperCase()+"%";}
		   
		   if(input.getpDate() == null || input.getpDate().trim().equals(""))
			{
				input.setpDate(null);
			}
			
			if(input.getColumnNo()==0)
			{
				input.setColumnNo(9);
			}
		   
		String count  = (String)getJdbcTemplate().queryForObject(
				query, new Object[] {headerId,lineNumber,proCode,quantity,category,}, String.class);

		return Long.parseLong(count);
	}

	@Override
	public List<LtPoLines> getLtPoLinesDataTable(Long headerId, LtPoLines input) throws ServiceException {
		String query = env.getProperty("getLtPoLinesDataTableByHeaderId");
		
		   String lineNumber=null;
		   if(input.getLineNum()!=null && !input.getLineNum().equals(""))
		   {lineNumber="%"+input.getLineNum()+"%";}
		   
		   String proCode=null;
		   if(input.getProductCode()!=null ) 
		   {proCode="%"+input.getProductCode().toUpperCase()+"%";}
		   
		   String quantity=null;
		   if(input.getQuantity()!=null ) 
		   {proCode="%"+input.getQuantity()+"%";}
		   
		   String category=null;
		   if(input.getProductCategory()!=null ) 
		   {proCode="%"+input.getProductCategory().toUpperCase()+"%";}
		   
		   if(input.getpDate() == null || input.getpDate().trim().equals(""))
			{
				input.setpDate(null);
			}
			
			if(input.getColumnNo()==0)
			{
				input.setColumnNo(9);
			}
			
			List<LtPoLines> list = (List<LtPoLines>) 
					jdbcTemplate.query(query , new Object[]{headerId,lineNumber,proCode,quantity,category,
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
						
						
							input.getStart()+input.getLength(),input.getStart()},
				 new  BeanPropertyRowMapper<LtPoLines>(LtPoLines.class));
				return list;
	}

	@Override
	public List<LtPoLines> getAllPoLinesByHeaderId(Long headerId) throws ServiceException {
		String query = env.getProperty("getAllPoLinesByHeaderId");
		List<LtPoLines> list=   jdbcTemplate.query(query, new Object[]{ headerId }, 
				 new BeanPropertyRowMapper<LtPoLines>(LtPoLines.class)); 
		return list;
	}

	@Override
	public LtPoLines getPoLinesByPolineId(Long poLineId) throws ServiceException {
		String query = env.getProperty("getPoLinesByPolineId");
		LtPoLines ltPoLine =   jdbcTemplate.queryForObject(query, new Object[]{poLineId }, 
				new BeanPropertyRowMapper<LtPoLines>(LtPoLines.class));
		return ltPoLine;
	}

	@Override
	public boolean updateFlage(Long ltPoLineId) throws ServiceException {
		String query =" UPDATE LT_PO_LINES SET FLAG=? ,LAST_UPDATE_DATE= ? WHERE PO_LINE_ID=?";
		int res=jdbcTemplate.update(query, 1,new Date(),ltPoLineId);
		if(res!=0)
			return true;
		else
			return false;
	}

}
