package com.lonar.vendor.vendorportal.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.lonar.vendor.vendorportal.model.LtMastSubDivisions;
import com.lonar.vendor.vendorportal.model.ServiceException;


@Component
@PropertySource(value = "classpath:queries/subDivisionMasterQueries.properties", ignoreResourceNotFound = true)
public class LtMastSubDivisionsDaoImpl implements LtMastSubDivisionsDao 
{
	
	@Autowired
	private Environment env;


	/*@PersistenceContext(name = "em")
	private EntityManager em;*/

	private JdbcTemplate jdbcTemplate;
	@Autowired
	public void setDataSource(DataSource dataSource) 
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	@Override
	public List<LtMastSubDivisions> findAllActive() throws ServiceException 
	{
		
		String query = env.getProperty("findAllActiveLtMastSubDivisions");
		List<LtMastSubDivisions> list = (List<LtMastSubDivisions>) 
				 jdbcTemplate.query(query , new Object[]{ },
						 new  BeanPropertyRowMapper<LtMastSubDivisions>(LtMastSubDivisions.class));
		return list;
		
	}

	@Transactional
	@Override
	public List<LtMastSubDivisions> findByDivisionId(Long divisionId) throws ServiceException 
	{
		
		String query = env.getProperty("findByDivisionId");
				
		List<LtMastSubDivisions> list = (List<LtMastSubDivisions>) 
				 jdbcTemplate.query(query , new Object[]{ divisionId},
						 new  BeanPropertyRowMapper<LtMastSubDivisions>(LtMastSubDivisions.class));
		
		return list;
	}

	@Transactional
	@Override
	public List<LtMastSubDivisions> checkDetails(LtMastSubDivisions ltMastSubDivisions) throws ServiceException 
	{
		
		
		String query = env.getProperty("checkDetailsLtMastSubDivisions").toString();				
		
		return jdbcTemplate.query(query,new Object[]{ ltMastSubDivisions.getSubDivisionCode(),ltMastSubDivisions.getSubDivisionName(),
				ltMastSubDivisions.getDivisionId()}, 
				 new RowMapper<LtMastSubDivisions>(){
					@Override
					public LtMastSubDivisions mapRow(ResultSet rs, int row) throws SQLException {
						LtMastSubDivisions ltMastSubDivisions = new LtMastSubDivisions();
						ltMastSubDivisions.setSubDivisionId(rs.getLong("SUB_DIVISION_ID"));
						ltMastSubDivisions.setSubDivisionCode(rs.getString("SUB_DIVISION_CODE"));
						ltMastSubDivisions.setSubDivisionName(rs.getString("SUB_DIVISION_NAME"));
						ltMastSubDivisions.setDivisionName(rs.getString("DIVISION_NAME"));
						return ltMastSubDivisions;
					}
		});
	}

	@Transactional
	@Override
	public List<LtMastSubDivisions> findActiveByDivisionId(Long divisionId) throws ServiceException 
	{
		
		String query = env.getProperty("findActiveByDivisionId");
		List<LtMastSubDivisions> list = (List<LtMastSubDivisions>) 
		 jdbcTemplate.query(query , new Object[]{ divisionId},
				 new  BeanPropertyRowMapper<LtMastSubDivisions>(LtMastSubDivisions.class));
		
		return list;
	}

}