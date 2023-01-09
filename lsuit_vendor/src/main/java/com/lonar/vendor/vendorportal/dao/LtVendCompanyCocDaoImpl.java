package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lonar.vendor.vendorportal.model.LtCompanyVenMgmtCoc;
import com.lonar.vendor.vendorportal.model.LtVendCompanyCoc;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.repository.LtVendCompanyCocRepository;

@Repository
@PropertySource(value = "classpath:queries/vendCompanyCocMasterQueries.properties", ignoreResourceNotFound = true)
public class LtVendCompanyCocDaoImpl implements LtVendCompanyCocDao {

	@Autowired
	LtVendCompanyCocRepository ltVendCompanyCocRepository;
	
	
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
	public List<LtVendCompanyCoc> getBycompanyId(Long companyId) throws ServiceException {
		String query = env.getProperty("getLtVendCompanyCocBycompanyId");
		
		List<LtVendCompanyCoc> list = (List<LtVendCompanyCoc>) 
				jdbcTemplate.query(query , new Object[]{ companyId},
			 new  BeanPropertyRowMapper<LtVendCompanyCoc>(LtVendCompanyCoc.class));

		
			return list;
	}

	@Override
	public LtVendCompanyCoc getById(Long id) throws ServiceException {
		String query = env.getProperty("getLtVendCompanyCocById");
		
		List<LtVendCompanyCoc> list = (List<LtVendCompanyCoc>) 
				jdbcTemplate.query(query , new Object[]{id },
			 new  BeanPropertyRowMapper<LtVendCompanyCoc>(LtVendCompanyCoc.class));

		
			return list.get(0);
	}

	@Override
	public List<LtVendCompanyCoc> getAll() throws ServiceException {
		String query = env.getProperty("getAllLtVendCompanyCoc");
		
		List<LtVendCompanyCoc> list = (List<LtVendCompanyCoc>) 
				jdbcTemplate.query(query , new Object[]{ },
			 new  BeanPropertyRowMapper<LtVendCompanyCoc>(LtVendCompanyCoc.class));

		
			return list;
	}

	@Override
	public List<LtVendCompanyCoc> getAllActive() throws ServiceException {
		String query = env.getProperty("getAllActiveLtVendCompanyCoc");
		
		List<LtVendCompanyCoc> list = (List<LtVendCompanyCoc>) 
				jdbcTemplate.query(query , new Object[]{ },
		 new  BeanPropertyRowMapper<LtVendCompanyCoc>(LtVendCompanyCoc.class));
		return list;
	}

	@Override
	public boolean delete(Long compConductId) throws ServiceException {
		int res=0;
		 res=jdbcTemplate.update(" DELETE FROM LT_VEND_COMPANY_COC "
				+ "  WHERE Comp_Conduct_Id = ? ",compConductId);
		if(res!=0)
			return true;
		else
			return false;
	}

	@Override
	public boolean update(LtVendCompanyCoc ltVendCompanyCoc) throws ServiceException {
		
		ltVendCompanyCoc = ltVendCompanyCocRepository.save(ltVendCompanyCoc);
		if(ltVendCompanyCoc.getCompConductId()!=null)
			return true;
		else
			return false;
		
	}

	@Override
	public List<LtCompanyVenMgmtCoc> getManagementBycompanyId(Long companyId, Long vendorId) throws ServiceException {
		String query = env.getProperty("getCompanyVenMgmtCocByCompanyVendor");
		
		List<LtCompanyVenMgmtCoc> list = (List<LtCompanyVenMgmtCoc>) 
				jdbcTemplate.query(query , new Object[]{ companyId,vendorId },
		 new  BeanPropertyRowMapper<LtCompanyVenMgmtCoc>(LtCompanyVenMgmtCoc.class));

		return list;
	}

}
