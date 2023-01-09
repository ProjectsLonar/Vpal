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
		// TODO Auto-generated method stub
		return jdbcTemplate;
	}
	
	@Override
	public List<LtVendCompanyCoc> getBycompanyId(Long companyId) throws ServiceException {
		String query = env.getProperty("getLtVendCompanyCocBycompanyId");
		
		/*List<LtVendCompanyCoc> list = (List<LtVendCompanyCoc>) 
				jdbcTemplate.query(query , new Object[]{ companyId},
			 new  BeanPropertyRowMapper<LtVendCompanyCoc>(LtVendCompanyCoc.class));
			return list;*/
	
		
		return jdbcTemplate.query(query, new Object[] {companyId  },

				new RowMapper<LtVendCompanyCoc>() {
					@Override
					public LtVendCompanyCoc mapRow(ResultSet rs, int row) throws SQLException {
						LtVendCompanyCoc ltVendCompanyCoc = new LtVendCompanyCoc();
						ltVendCompanyCoc.setCompConductId(rs.getLong("COMP_CONDUCT_ID"));
						ltVendCompanyCoc.setCompanyId(rs.getLong("COMPANY_ID"));
						ltVendCompanyCoc.setCodeConductId(rs.getString("CODE_CONDUCT_ID"));
						ltVendCompanyCoc.setIncludeVendor(rs.getString("INCLUDE_VENDOR"));
						ltVendCompanyCoc.setMandatoryTab(rs.getString("MANDATORY_TAB"));
						ltVendCompanyCoc.setStartDate(rs.getDate("START_DATE"));
						
						return ltVendCompanyCoc;
					}

				}

		);
	}

	@Override
	public LtVendCompanyCoc getById(Long id) throws ServiceException {
		String query = env.getProperty("getLtVendCompanyCocById");
		
		List<LtVendCompanyCoc> list = (List<LtVendCompanyCoc>) 
				jdbcTemplate.query(query , new Object[]{ },
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
	public List<LtCompanyVenMgmtCoc> getManagementBycompanyVendorId(Long companyId, Long vendorId) throws ServiceException {
		String query = env.getProperty("getCompanyVenMgmtCocByCompanyVendor");
		List<LtCompanyVenMgmtCoc> list = (List<LtCompanyVenMgmtCoc>) 
				jdbcTemplate.query(query , new Object[]{ companyId,vendorId },
		 new  BeanPropertyRowMapper<LtCompanyVenMgmtCoc>(LtCompanyVenMgmtCoc.class));
		return list;
	}

	@Override
	public List<LtCompanyVenMgmtCoc> getManagementBycompanyId(Long companyId) throws ServiceException {
		String query = env.getProperty("getCompanyVenMgmtCocByCompany");
		List<LtCompanyVenMgmtCoc> list = (List<LtCompanyVenMgmtCoc>) 
				jdbcTemplate.query(query , new Object[]{ companyId },
		 new  BeanPropertyRowMapper<LtCompanyVenMgmtCoc>(LtCompanyVenMgmtCoc.class));
		return list;
	}

	@Override
	public boolean updateCompanyVendCoc(Long companyId) throws ServiceException {
		int res=0;
		String query = " UPDATE LT_COMPANY_VEN_MGMT_COC " + 
				" SET INCLUDE_VENDOR = 'N',MANDATORY_TAB = 'N' " + 
				" WHERE VENDOR_ID IN ( SELECT VENDOR_ID FROM LT_MAST_VENDORS WHERE COMPANY_ID = ? AND ( STATUS = 'INVITED' OR STATUS = 'VENDOR_DRAFT' ) ) ";
		 res=jdbcTemplate.update(query,companyId);
	
		if(res!=0)
			return true;
		else
			return false;
	}

	@Override
	public List<LtVendCompanyCoc> getBycompanyAndVendorId(Long companyId,Long venId) throws ServiceException {
		String query = env.getProperty("getLtVendCompanyCocBycompanyVendorId");
		
		List<LtVendCompanyCoc> list = (List<LtVendCompanyCoc>) 
				jdbcTemplate.query(query , new Object[]{ companyId, venId},
			 new  BeanPropertyRowMapper<LtVendCompanyCoc>(LtVendCompanyCoc.class));
			return list;
	}

}
