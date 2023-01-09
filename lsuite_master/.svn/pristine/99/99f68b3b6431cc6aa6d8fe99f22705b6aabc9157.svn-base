package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lonar.vendor.vendorportal.model.LtCompanyVenMgmtInclude;
import com.lonar.vendor.vendorportal.model.LtVendCompanySistConcern;
import com.lonar.vendor.vendorportal.model.ServiceException;

@Repository
@PropertySource(value = "classpath:queries/vendCompanySistConcernQueries.properties", ignoreResourceNotFound = true)
public class LtVendCompanySistConcernDaoImpl implements LtVendCompanySistConcernDao{

	@Autowired
	private Environment env;

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	} 
	
	private JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	@Override
	public List<LtVendCompanySistConcern> getBycompanyId(Long companyId) throws ServiceException {
		String query = env.getProperty("getLtVendCompanySistConcernBycompanyId");
		List<LtVendCompanySistConcern> list = (List<LtVendCompanySistConcern>) 
				jdbcTemplate.query(query , new Object[]{ companyId},
		new  BeanPropertyRowMapper<LtVendCompanySistConcern>(LtVendCompanySistConcern.class));
		return list;
	}

	@Override
	public LtVendCompanySistConcern getById(Long id) throws ServiceException {
		String query = env.getProperty("getLtVendCompanySistConcernById");
		List<LtVendCompanySistConcern> list = (List<LtVendCompanySistConcern>) 
				jdbcTemplate.query(query , new Object[]{ id },
		new  BeanPropertyRowMapper<LtVendCompanySistConcern>(LtVendCompanySistConcern.class));
		return list.get(0);
	}

	@Override
	public List<LtVendCompanySistConcern> getAll() throws ServiceException {
		String query = env.getProperty("getAllLtVendCompanySistConcern");
		List<LtVendCompanySistConcern> list = (List<LtVendCompanySistConcern>) 
				jdbcTemplate.query(query , new Object[]{ },
		new  BeanPropertyRowMapper<LtVendCompanySistConcern>(LtVendCompanySistConcern.class));
		return list;
	}

	@Override
	public List<LtVendCompanySistConcern> getAllActive() throws ServiceException {
		String query = env.getProperty("getAllActiveLtVendCompanySistConcern");
		List<LtVendCompanySistConcern> list = (List<LtVendCompanySistConcern>) 
				jdbcTemplate.query(query , new Object[]{ },
		new  BeanPropertyRowMapper<LtVendCompanySistConcern>(LtVendCompanySistConcern.class));
		return list;
	}

	@Override
	public List<LtCompanyVenMgmtInclude> getCompanyVenSisConcernBycompanyId(Long companyId) throws ServiceException {
		String query = env.getProperty("getCompanyVenSisConcernBycompanyId");
		List<LtCompanyVenMgmtInclude> list = (List<LtCompanyVenMgmtInclude>) 
				jdbcTemplate.query(query , new Object[]{ companyId},
		new  BeanPropertyRowMapper<LtCompanyVenMgmtInclude>(LtCompanyVenMgmtInclude.class));
		return list;
	}

}
