package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lonar.vendor.vendorportal.model.LtMastDivisionEmployeeGrade;
import com.lonar.vendor.vendorportal.model.ServiceException;

@Repository
@PropertySource(value = "classpath:queries/divisionEmpGradeMasterQueries.properties", ignoreResourceNotFound = true)
public class LtMastDivisionEmployeeGradeDaoImpl implements LtMastDivisionEmployeeGradeDao {

	@Autowired
	private Environment env;

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource)
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private JdbcTemplate getJdbcTemplate() {
		// TODO Auto-generated method stub
		return jdbcTemplate;
	}

	@Override
	public List<LtMastDivisionEmployeeGrade> findByDivisionId(Long divisionId) throws ServiceException{
		String query = env.getProperty("findDivisionEmployeeGradeByDivisionId");
		
		List<LtMastDivisionEmployeeGrade> list=   jdbcTemplate.query(query, new Object[]{ divisionId }, 
				 new BeanPropertyRowMapper<LtMastDivisionEmployeeGrade>(LtMastDivisionEmployeeGrade.class)); 
		 
		
		return list;
	}

	@Override
	public List<LtMastDivisionEmployeeGrade> findByGrade(String grade) throws ServiceException{
		String query = env.getProperty("findByGradeDivisionEmployeeGrade");
		
		List<LtMastDivisionEmployeeGrade> list=   jdbcTemplate.query(query, new Object[]{ grade }, 
				 new BeanPropertyRowMapper<LtMastDivisionEmployeeGrade>(LtMastDivisionEmployeeGrade.class)); 
	
		return list;
	}

	@Override
	public List<LtMastDivisionEmployeeGrade> findAllActive() throws ServiceException{
		String query = env.getProperty("findAllActiveDivisionEmployeeGrade");
		
		List<LtMastDivisionEmployeeGrade> list=   jdbcTemplate.query(query, new Object[]{  }, 
				 new BeanPropertyRowMapper<LtMastDivisionEmployeeGrade>(LtMastDivisionEmployeeGrade.class)); 
	
		return list;
	}

	@Override
	public List<LtMastDivisionEmployeeGrade> findActiveLikeDivisionName(String divisionName) throws ServiceException{
		String query = env.getProperty("findDivisionEmployeeGradeActiveLikeDivisionName");
		
		List<LtMastDivisionEmployeeGrade> list=   jdbcTemplate.query(query, new Object[]{ "%"+divisionName.trim().toUpperCase()+"%" }, 
				 new BeanPropertyRowMapper<LtMastDivisionEmployeeGrade>(LtMastDivisionEmployeeGrade.class)); 
	
		return list;
	}

	@Override
	public List<LtMastDivisionEmployeeGrade> findByDivisionIdANDGrade(Long divisionId, String grade) throws ServiceException {
		String query = env.getProperty("findDivisionEmployeeGradeByDivisionIdANDGrade");
		
		List<LtMastDivisionEmployeeGrade> list=   jdbcTemplate.query(query, new Object[]{divisionId,grade  }, 
				 new BeanPropertyRowMapper<LtMastDivisionEmployeeGrade>(LtMastDivisionEmployeeGrade.class)); 
	
		return list;
	}

	@Override
	public List<LtMastDivisionEmployeeGrade> getAll() throws ServiceException {
		String query = env.getProperty("findAllDivisionEmployeeGrade");
		
		List<LtMastDivisionEmployeeGrade> list=   jdbcTemplate.query(query, new Object[]{}, 
				 new BeanPropertyRowMapper<LtMastDivisionEmployeeGrade>(LtMastDivisionEmployeeGrade.class)); 
	
		return list;
	}

	@Override
	public LtMastDivisionEmployeeGrade getLtP2pDivisionEmployeeGradeByID(Long id) throws ServiceException {
		String query = env.getProperty("getDivisionEmployeeGradeByID");
		
		List<LtMastDivisionEmployeeGrade> list=   jdbcTemplate.query(query, new Object[]{ id }, 
				 new BeanPropertyRowMapper<LtMastDivisionEmployeeGrade>(LtMastDivisionEmployeeGrade.class)); 
	
		return list.get(0);
	}

	@Override
	public Long getCount(LtMastDivisionEmployeeGrade input) throws ServiceException {
		String query = env.getProperty("getCountDivisionEmployeeGrade");
		 
		 String divName=null;
		   if(input.getDivisionName()!=null)
		   {divName="%"+input.getDivisionName()+"%";}
		   
		   String divCode=null;
		   if(input.getDivisionCode()!=null)
		   {divCode="%"+input.getDivisionCode().toUpperCase()+"%";}
		   
		   String grade=null;
		   if(input.getGrade()!=null)
		   {grade="%"+input.getGrade().toUpperCase()+"%";}
		   
		   String minAmt=null;
		   if(input.getMinAmount()!=null)
		   {minAmt="%"+Double.valueOf(input.getMinAmount()).intValue()+"%";}
		   
		   String maxAmt=null;
		   if(input.getMaxAmount()!=null)
		   {maxAmt="%"+Double.valueOf(input.getMaxAmount()).intValue()+"%";}
		   
		   
			if(input.getStDate() == null || input.getStDate().trim().equals(""))
			{
				input.setStDate(null);
			}
			if(input.getEnDate() == null || input.getEnDate().trim().equals(""))
			{
				input.setEnDate(null);
			}
			
		String count  = (String)getJdbcTemplate().queryForObject(
				query, new Object[] {divName,divCode,grade,minAmt,maxAmt,
						input.getStDate(),input.getEnDate() }, String.class);

		
		return Long.parseLong(count);
	}

	@Override
	public List<LtMastDivisionEmployeeGrade> getDataTableRecords(LtMastDivisionEmployeeGrade input)
			throws ServiceException {
		String query = env.getProperty("getDivisionEmployeeGradeDatatableRecords");
		 
		String divName=null;
		   if(input.getDivisionName()!=null)
		   {divName="%"+input.getDivisionName().toUpperCase()+"%";}
		   
		   String divCode=null;
		   if(input.getDivisionCode()!=null)
		   {divCode="%"+input.getDivisionCode().toUpperCase()+"%";}
		   
		   String grade=null;
		   if(input.getGrade()!=null)
		   {grade="%"+input.getGrade().toUpperCase()+"%";}
		   
		   String minAmt=null;
		   if(input.getMinAmount()!=null)
		   {minAmt="%"+Double.valueOf(input.getMinAmount()).intValue()+"%";}
		   
		   String maxAmt=null;
		   if(input.getMaxAmount()!=null)
		   {maxAmt="%"+Double.valueOf(input.getMaxAmount()).intValue()+"%";}
	
		   
			if(input.getStDate() == null || input.getStDate().trim().equals(""))
			{
				input.setStDate(null);
			}
			if(input.getEnDate() == null || input.getEnDate().trim().equals(""))
			{
				input.setEnDate(null);
			}
			
			
			List<LtMastDivisionEmployeeGrade> list = (List<LtMastDivisionEmployeeGrade>) 
					jdbcTemplate.query(query , new Object[]{divName,divCode,grade,minAmt,maxAmt,
							input.getStDate(),input.getEnDate(),
							
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							
							input.getStart()+input.getLength(),input.getStart()+1},
				 new  BeanPropertyRowMapper<LtMastDivisionEmployeeGrade>(LtMastDivisionEmployeeGrade.class));
				return list;
	}
	
	

}
