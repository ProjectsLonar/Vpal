package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lonar.vendor.vendorportal.model.LtCompanyVenMgmtMisc;
import com.lonar.vendor.vendorportal.model.LtCompanyVenMgmtMiscQues;
import com.lonar.vendor.vendorportal.model.LtVendCompanyMiscellaneous;
import com.lonar.vendor.vendorportal.model.ServiceException;

@Repository
@PropertySource(value = "classpath:queries/vendCompanyMiscellaneousMasterQueries.properties", ignoreResourceNotFound = true)
public class LtVendCompanyMiscellaneousDaoImpl implements LtVendCompanyMiscellaneousDao{

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
	public LtVendCompanyMiscellaneous getBycompanyId(Long companyId) {
		String query = env.getProperty("getVendCompanyMiscellaneousBycompanyId");
		
		List<LtVendCompanyMiscellaneous> list = (List<LtVendCompanyMiscellaneous>) 
				jdbcTemplate.query(query , new Object[]{ companyId},
			 new  BeanPropertyRowMapper<LtVendCompanyMiscellaneous>(LtVendCompanyMiscellaneous.class));
		if(list.isEmpty())
			return null;
		else
			return list.get(0);
	}

	@Override
	public List<LtVendCompanyMiscellaneous> getAll() {
		String query = env.getProperty("getAllVendCompanyMiscellaneous");
		
		List<LtVendCompanyMiscellaneous> list = (List<LtVendCompanyMiscellaneous>) 
				jdbcTemplate.query(query , new Object[]{ },
		new  BeanPropertyRowMapper<LtVendCompanyMiscellaneous>(LtVendCompanyMiscellaneous.class));
		return list;
	}

	@Override
	public List<LtVendCompanyMiscellaneous> getAllActive() {
		String query = env.getProperty("getAllActiveVendCompanyMiscellaneous");
		
		List<LtVendCompanyMiscellaneous> list = (List<LtVendCompanyMiscellaneous>) 
				jdbcTemplate.query(query , new Object[]{ },
		new  BeanPropertyRowMapper<LtVendCompanyMiscellaneous>(LtVendCompanyMiscellaneous.class));
		return list;
	}

	@Override
	public LtVendCompanyMiscellaneous getById(Long id) throws ServiceException {
		String query = env.getProperty("getVendCompanyMiscellaneousById");
		
		List<LtVendCompanyMiscellaneous> list = (List<LtVendCompanyMiscellaneous>) 
				jdbcTemplate.query(query , new Object[]{id },
		new  BeanPropertyRowMapper<LtVendCompanyMiscellaneous>(LtVendCompanyMiscellaneous.class));
		if(!list.isEmpty())
		return list.get(0);
		else return null;
	}

	@Override
	public LtCompanyVenMgmtMisc getManagementBycompanyId(Long companyId, Long vendorId) throws ServiceException {
		String query = env.getProperty("getMiscManagementByCompanyVendorId");
		List<LtCompanyVenMgmtMisc> list = (List<LtCompanyVenMgmtMisc>) 
				jdbcTemplate.query(query , new Object[]{companyId, vendorId},
		new  BeanPropertyRowMapper<LtCompanyVenMgmtMisc>(LtCompanyVenMgmtMisc.class));
		if(!list.isEmpty())
		return list.get(0);
		else return null;
	}

	@Override
	public List<LtCompanyVenMgmtMiscQues> getQuestionByCompanyVendor(Long companyId, Long vendorId)
			throws ServiceException {
		String query = env.getProperty("getCompanyVenMgmtMiscQuesByCompanyVendorId");
		
		List<LtCompanyVenMgmtMiscQues> list = (List<LtCompanyVenMgmtMiscQues>) 
				jdbcTemplate.query(query , new Object[]{companyId, vendorId},
		new  BeanPropertyRowMapper<LtCompanyVenMgmtMiscQues>(LtCompanyVenMgmtMiscQues.class));
		return list;
	}

	@Override
	public LtVendCompanyMiscellaneous getVendorMasterBycompanyId(Long companyId) throws ServiceException {
		String query = env.getProperty("getMiscVendorMasterBycompanyId");
		
		List<LtVendCompanyMiscellaneous> list = (List<LtVendCompanyMiscellaneous>) 
				jdbcTemplate.query(query , new Object[]{ companyId},
			 new  BeanPropertyRowMapper<LtVendCompanyMiscellaneous>(LtVendCompanyMiscellaneous.class));
		if(list.isEmpty())
			return null;
		else
			return list.get(0);
	}

}
