package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lonar.vendor.vendorportal.model.LtMastStates;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.reports.ReportParameters;

@Repository
@PropertySource(value = "classpath:queries/stateMasterQueries.properties", ignoreResourceNotFound = true)
public class LtMastStatesDaoImpl implements LtMastStatesDao 
{
	@Autowired
	private Environment env;
	
	private JdbcTemplate jdbcTemplate;
	
	private JdbcTemplate getJdbcTemplate() {
		// TODO Auto-generated method stub
		return jdbcTemplate;
	}
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	} 

	@PersistenceContext(name = "em")
	private EntityManager em;
	
	@Override
	public Long getCount(LtMastStates input) throws ServiceException {
		String query = env.getProperty("getCountLtMastStates");
		 
		String stateCode=null;
		   if(input.getStateCode()!=null && !input.getStateCode().equals(" ") && !input.getStateCode().isEmpty())
		   {stateCode="%"+input.getStateCode().toUpperCase()+"%";}
		   
		   String stateName=null;
		   if(input.getStateName()!=null && !input.getStateName().equals(" ") && !input.getStateName().isEmpty())
		   {stateName="%"+input.getStateName().toUpperCase()+"%";}
		   
		   String gstState=null;
		   if(input.getGstStateCode()!=null &&  !input.getGstStateCode().equals(" ") && !input.getGstStateCode().isEmpty())
		   {gstState="%"+input.getGstStateCode().toUpperCase()+"%";}
		   
		   String stateType=null;
		   if(input.getStateType()!=null && !input.getStateType().equals(" ") && !input.getStateType().isEmpty())
		   {stateType="%"+input.getStateType().toUpperCase()+"%";}
		   
		   String status=null;
		   if(input.getStatus()!=null && !input.getStatus().equals(" ") && !input.getStatus().isEmpty()) 
		   {status="%"+input.getStatus().toUpperCase()+"%";}
		   
			if(input.getStDate() == null || input.getStDate().trim().equals(""))
			{
				input.setStDate(null);
			}
			if(input.getEnDate() == null || input.getEnDate().trim().equals(""))
			{
				input.setEnDate(null);
			}
			
		String count  = (String)getJdbcTemplate().queryForObject(
				query, new Object[] {stateCode,stateName,stateType,gstState,status,
						input.getStDate(),input.getEnDate() }, String.class);

		
		return Long.parseLong(count);
	}

	@Override
	public List<LtMastStates> getStateDataTableRecords(LtMastStates input) throws ServiceException {
		String query = env.getProperty("getLtMastStatesDatatableRecords");
		 
		String stateCode=null;
		   if(input.getStateCode()!=null && !input.getStateCode().equals(" ") && !input.getStateCode().isEmpty())
		   {stateCode="%"+input.getStateCode().toUpperCase()+"%";}
		   
		   String stateName=null;
		   if(input.getStateName()!=null && !input.getStateName().equals(" ") && !input.getStateName().isEmpty())
		   {stateName="%"+input.getStateName().toUpperCase()+"%";}
		   
		   String gstState=null;
		   if(input.getGstStateCode()!=null &&  !input.getGstStateCode().equals(" ") && !input.getGstStateCode().isEmpty())
		   {gstState="%"+input.getGstStateCode().toUpperCase()+"%";}
		   
		   String stateType=null;
		   if(input.getStateType()!=null && !input.getStateType().equals(" ") && !input.getStateType().isEmpty())
		   {stateType="%"+input.getStateType().toUpperCase()+"%";}
		   
		   String status=null;
		   if(input.getStatus()!=null && !input.getStatus().equals(" ") && !input.getStatus().isEmpty()) 
		   {status="%"+input.getStatus().toUpperCase()+"%";}
		   
			if(input.getStDate() == null || input.getStDate().trim().equals(""))
			{
				input.setStDate(null);
			}
			if(input.getEnDate() == null || input.getEnDate().trim().equals(""))
			{
				input.setEnDate(null);
			}
			if(input.getColumnNo() == 0) {
				input.setColumnNo(9);
			}
			List<LtMastStates> list = (List<LtMastStates>) 
					jdbcTemplate.query(query , new Object[]{stateCode,stateName,stateType,gstState,status,
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
				 new  BeanPropertyRowMapper<LtMastStates>(LtMastStates.class));
			
				return list;
	}

	@Override
	public List<LtMastStates> findAll() throws ServiceException {
		String query = env.getProperty("findAllLtMastStates");
		
		List<LtMastStates> list=   jdbcTemplate.query(query, new Object[]{ }, 
				 new BeanPropertyRowMapper<LtMastStates>(LtMastStates.class)); 
		 
		return list;
	}

	@Override
	public List<LtMastStates> findAllActive() throws ServiceException {
		String query = env.getProperty("findAllActiveLtMastStates");
		
		List<LtMastStates> list=   jdbcTemplate.query(query, new Object[]{ }, 
				 new BeanPropertyRowMapper<LtMastStates>(LtMastStates.class)); 
		 
		return list;
	}

	@Override
	public LtMastStates getByID(Long id) throws ServiceException {
		String query = env.getProperty("getLtMastStatesByID");
		
		List<LtMastStates> list=   jdbcTemplate.query(query, new Object[]{ id}, 
				 new BeanPropertyRowMapper<LtMastStates>(LtMastStates.class)); 
		 if(!list.isEmpty())
		return list.get(0);
		 else return null;
	}

	@Override
	public List<LtMastStates> findActiveLikeStateName(String state) throws ServiceException {
		String query = env.getProperty("findActiveLikeStateName");
		
		List<LtMastStates> list=   jdbcTemplate.query(query, new Object[]{"%"+state.toUpperCase().trim()+"%" }, 
				 new BeanPropertyRowMapper<LtMastStates>(LtMastStates.class)); 
		 
		return list;
	}

	@Override
	public LtMastStates getByStateCode(String stateCode) throws ServiceException {
		String query = env.getProperty("getByStateCode");
		
		List<LtMastStates> list=   jdbcTemplate.query(query, new Object[]{stateCode.toUpperCase().trim() }, 
				 new BeanPropertyRowMapper<LtMastStates>(LtMastStates.class)); 
		if(!list.isEmpty()) 
		return list.get(0);
		else return null;
	}

	@Override
	public LtMastStates getByStateName(String name) throws ServiceException {
		String query = env.getProperty("getStatesByStateName");
		
		List<LtMastStates> list=   jdbcTemplate.query(query, new Object[]{name.toUpperCase().trim() }, 
				 new BeanPropertyRowMapper<LtMastStates>(LtMastStates.class)); 
		if(!list.isEmpty()) 
		return list.get(0);
		else return null;
	}

	@Override
	public LtMastStates getByGstStateCode(String gstStateCode) throws ServiceException {
		String query = env.getProperty("getStatesByGstStateCode");
		List<LtMastStates> list=   jdbcTemplate.query(query, new Object[]{gstStateCode.toUpperCase().trim() }, 
				 new BeanPropertyRowMapper<LtMastStates>(LtMastStates.class)); 
		if(!list.isEmpty()) 
		return list.get(0);
		else return null;
	}

	@Override
	public List<LtMastStates> getDataForReport(ReportParameters reportParameters) throws ServiceException {
		String query = env.getProperty("getLtMastStatesDataForReport");
		
		List<LtMastStates> list=   jdbcTemplate.query(query, new Object[]{ reportParameters.getStatus(),reportParameters.getStartDate(),reportParameters.getEndDate() }, 
				 new BeanPropertyRowMapper<LtMastStates>(LtMastStates.class)); 
		 
		return list;
	}

}
