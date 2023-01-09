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
import com.lonar.vendor.vendorportal.model.LtVendCompanyMgmtDdetails;
import com.lonar.vendor.vendorportal.model.ServiceException;

@Repository
@PropertySource(value = "classpath:queries/vendCompanyMgmtMasterQueries.properties", ignoreResourceNotFound = true)
public class LtVendCompanyMgmtDdetailsDaoImpl implements LtVendCompanyMgmtDdetailsDao{

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
	public List<LtVendCompanyMgmtDdetails> getBycompanyId(Long companyId) {
		String query = env.getProperty("getVendCompanyMgmtDdetailsBycompanyId");
		
		List<LtVendCompanyMgmtDdetails> list = (List<LtVendCompanyMgmtDdetails>) 
				jdbcTemplate.query(query , new Object[]{ companyId},
		new  BeanPropertyRowMapper<LtVendCompanyMgmtDdetails>(LtVendCompanyMgmtDdetails.class));
		return list;
	}

	@Override
	public LtVendCompanyMgmtDdetails getById(Long id) {
		String query = env.getProperty("getVendCompanyMgmtDdetailsById");
		
		List<LtVendCompanyMgmtDdetails> list = (List<LtVendCompanyMgmtDdetails>) 
				jdbcTemplate.query(query , new Object[]{ },
		new  BeanPropertyRowMapper<LtVendCompanyMgmtDdetails>(LtVendCompanyMgmtDdetails.class));
		return list.get(0);
	}

	@Override
	public List<LtVendCompanyMgmtDdetails> getAll() {
		String query = env.getProperty("getAllVendCompanyMgmtDdetails");
		
		List<LtVendCompanyMgmtDdetails> list = (List<LtVendCompanyMgmtDdetails>) 
				jdbcTemplate.query(query , new Object[]{ },
		new  BeanPropertyRowMapper<LtVendCompanyMgmtDdetails>(LtVendCompanyMgmtDdetails.class));
		return list;
	}

	@Override
	public List<LtVendCompanyMgmtDdetails> getAllActive() {
		String query = env.getProperty("getAllActiveVendCompanyMgmtDdetails");
		
		List<LtVendCompanyMgmtDdetails> list = (List<LtVendCompanyMgmtDdetails>) 
				jdbcTemplate.query(query , new Object[]{ },
		new  BeanPropertyRowMapper<LtVendCompanyMgmtDdetails>(LtVendCompanyMgmtDdetails.class));
		return list;
	}

	@Override
	public List<LtCompanyVenMgmtInclude> getManagementBycompanyId(Long companyId, Long vendorId)
			throws ServiceException {
		String query = env.getProperty("getVendCompanyMgmtDdetailsBycompanyIdVendorId");
		
		List<LtCompanyVenMgmtInclude> list = (List<LtCompanyVenMgmtInclude>) 
				jdbcTemplate.query(query , new Object[]{ companyId,vendorId},
		new  BeanPropertyRowMapper<LtCompanyVenMgmtInclude>(LtCompanyVenMgmtInclude.class));
		return list;
	}

}
