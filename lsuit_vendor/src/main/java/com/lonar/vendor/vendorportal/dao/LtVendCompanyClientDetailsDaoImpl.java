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
import com.lonar.vendor.vendorportal.model.LtVendCompanyClientDetails;
import com.lonar.vendor.vendorportal.model.ServiceException;

@Repository
@PropertySource(value = "classpath:queries/vendCompClientMasterQueries.properties", ignoreResourceNotFound = true)
public class LtVendCompanyClientDetailsDaoImpl implements LtVendCompanyClientDetailsDao{


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
	public List<LtVendCompanyClientDetails> getBycompanyId(Long companyId) throws ServiceException {
		String query = env.getProperty("getVendCompanyClientDetailsBycompanyId");
		
		List<LtVendCompanyClientDetails> list = (List<LtVendCompanyClientDetails>) 
				jdbcTemplate.query(query , new Object[]{companyId },
		new  BeanPropertyRowMapper<LtVendCompanyClientDetails>(LtVendCompanyClientDetails.class));
		return list;
	}

	@Override
	public List<LtVendCompanyClientDetails> getAllActive() throws ServiceException {
		String query = env.getProperty("getAllActiveVendCompanyClientDetails");
		
		List<LtVendCompanyClientDetails> list = (List<LtVendCompanyClientDetails>) 
				jdbcTemplate.query(query , new Object[]{ },
		new  BeanPropertyRowMapper<LtVendCompanyClientDetails>(LtVendCompanyClientDetails.class));
		return list;
	}

	@Override
	public List<LtVendCompanyClientDetails> getAll() throws ServiceException {
		String query = env.getProperty("getAllVendCompanyClientDetails");
		
		List<LtVendCompanyClientDetails> list = (List<LtVendCompanyClientDetails>) 
				jdbcTemplate.query(query , new Object[]{ },
		new  BeanPropertyRowMapper<LtVendCompanyClientDetails>(LtVendCompanyClientDetails.class));
		return list;
	}

	@Override
	public LtVendCompanyClientDetails getById(Long id) throws ServiceException {
		String query = env.getProperty("getVendCompanyClientDetailsById");
		
		List<LtVendCompanyClientDetails> list = (List<LtVendCompanyClientDetails>) 
				jdbcTemplate.query(query , new Object[]{ },
		new  BeanPropertyRowMapper<LtVendCompanyClientDetails>(LtVendCompanyClientDetails.class));
		return list.get(0);
	}

	

	@Override
	public List<LtCompanyVenMgmtInclude> getManagementBycompanyId(Long companyId, Long vendorId)
			throws ServiceException {
		String query = env.getProperty("getCompanyVenMgmtClientIncludeByCompanyVendor");
		
		List<LtCompanyVenMgmtInclude> list = (List<LtCompanyVenMgmtInclude>) 
				jdbcTemplate.query(query , new Object[]{ companyId , vendorId },
		new  BeanPropertyRowMapper<LtCompanyVenMgmtInclude>(LtCompanyVenMgmtInclude.class));
		
		return list;
	}

}
