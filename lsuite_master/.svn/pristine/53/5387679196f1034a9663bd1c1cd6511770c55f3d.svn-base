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
import org.springframework.transaction.annotation.Transactional;

import com.lonar.vendor.vendorportal.model.LtMastBranches;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.reports.ReportParameters;


@Repository
@PropertySource(value = "classpath:queries/branchMasterQueries.properties", ignoreResourceNotFound = true)
public class LtMastBranchesDaoImpl implements LtMastBranchesDao 
{
	@Autowired
	private Environment env;
	
	/*@PersistenceContext(name = "em")
	private EntityManager em;*/

	private JdbcTemplate jdbcTemplate;

	private JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Transactional
	@Override
	public List<LtMastBranches> findByBranchCode(String branchCode) throws ServiceException {
		String query = env.getProperty("findByBranchCode");
		
		List<LtMastBranches> list=   jdbcTemplate.query(query, new Object[]{"%"+branchCode+"%" }, 
		 new BeanPropertyRowMapper<LtMastBranches>(LtMastBranches.class)); 
		return list;
	
	}

	@Transactional
	@Override
	public List<LtMastBranches> findByBranchName(String branchName) throws ServiceException {
		String query = env.getProperty("findByBranchName");

		List<LtMastBranches> list=   jdbcTemplate.query(query, new Object[]{"%"+branchName+"%" }, 
		 new BeanPropertyRowMapper<LtMastBranches>(LtMastBranches.class)); 
		return list;
	}

	@Transactional
	@Override
	public List<LtMastBranches> findAllActive(Long companyId) throws ServiceException {
		String query = env.getProperty("findAllActive");
		
		List<LtMastBranches> list=   jdbcTemplate.query(query, new Object[]{ companyId }, 
		 new BeanPropertyRowMapper<LtMastBranches>(LtMastBranches.class)); 
		return list;
	}

	@Transactional
	@Override
	public List<LtMastBranches> findActiveLikeBranchName(String branchName, Long companyId) throws ServiceException {
		String query = env.getProperty("findActiveLikeBranchName");
		
		List<LtMastBranches> list=   jdbcTemplate.query(query, new Object[]{"%"+branchName.toUpperCase()+"%",
				"%"+branchName.toUpperCase()+"%", companyId }, 
		 new BeanPropertyRowMapper<LtMastBranches>(LtMastBranches.class)); 
		
		return list;

	}

	@Override
	@Transactional
	public List<LtMastBranches> isFeildsExists(LtMastBranches ltMastBranches) throws ServiceException 
	{
		String query = env.getProperty("isFeildsExists");
		
		return jdbcTemplate.query(query, new Object[] { ltMastBranches.getBranchCode(), ltMastBranches.getGstRegNo(),
				ltMastBranches.getBranchName(),ltMastBranches.getCompanyId() },

				new RowMapper<LtMastBranches>() {
					@Override
					public LtMastBranches mapRow(ResultSet rs, int row) throws SQLException {
						LtMastBranches branchefields = new LtMastBranches();
						branchefields.setBranchCode(rs.getString("branch_code"));
						branchefields.setGstRegNo(rs.getString("gst_reg_no"));
						branchefields.setBranchId(rs.getLong("branch_id"));
						branchefields.setBranchName(rs.getString("BRANCH_NAME"));
						return branchefields;
					}

				}

		);
	}
	
	@Override
	@Transactional
	public List<LtMastBranches> updateBranch(LtMastBranches ltMastBranches) throws ServiceException {
		String query = env.getProperty("updateBranch");
		
		return jdbcTemplate.query(query, new Object[] { ltMastBranches.getGstRegNo() },

				new RowMapper<LtMastBranches>() {
					@Override
					public LtMastBranches mapRow(ResultSet rs, int row) throws SQLException {
						LtMastBranches branchefields = new LtMastBranches();
						branchefields.setGstRegNo(rs.getString("gst_reg_no"));
						return branchefields;
					}

				}

		);
	}

	@Override
	public List<LtMastBranches> checkAlreadyUsed(LtMastBranches ltMastBranch) throws ServiceException 
	{
		String query = env.getProperty("checkAlreadyUsed");
		
		List<LtMastBranches> list=   jdbcTemplate.query(query, new Object[]{ltMastBranch.getBranchId() }, 
		 new BeanPropertyRowMapper<LtMastBranches>(LtMastBranches.class)); 
		return list;
	}

	@Override
	public LtMastBranches findByBranchId(Long branchId) throws ServiceException 
	{
		String query = env.getProperty("findByBranchId");
	
		List<LtMastBranches> list=   jdbcTemplate.query(query, new Object[]{branchId }, 
		 new BeanPropertyRowMapper<LtMastBranches>(LtMastBranches.class)); 
		
		if(!list.isEmpty())
		return list.get(0);
		else
			return null;
	}

	@Override
	public List<LtMastBranches> findAll(Long companyId) throws ServiceException {
		String query = env.getProperty("findAll");
		// String query = "SELECT * FROM LT_MAST_BRANCHES l ";
		List<LtMastBranches> list = jdbcTemplate.query(query, new Object[] { companyId },
				new BeanPropertyRowMapper<LtMastBranches>(LtMastBranches.class));

		return list;
	}

	@Override
	public LtMastBranches getLtMastBranchesByID(Long branchId) throws ServiceException {
		String query = env.getProperty("getLtMastBranchesByID");
		
		
		List<LtMastBranches> list=   jdbcTemplate.query(query, new Object[]{branchId }, 
		 new BeanPropertyRowMapper<LtMastBranches>(LtMastBranches.class)); 
	
		if(!list.isEmpty())
		return list.get(0);
		else
			return null;
	}

	@Override
	public Long getCount(Long companyId, LtMastBranches input) throws ServiceException
	{
		String query = env.getProperty("getLtMastBranchesCount");
		String branchCode=null;
		
		String companyName = null;
		 if(input.getCompanyName()!=null)
		   { companyName="%"+input.getCompanyName().toUpperCase()+"%";}
		 
		   if(input.getBranchCode()!=null)
		   { branchCode="%"+input.getBranchCode().toUpperCase()+"%";}
		   
		   String branchName=null;
		   if(input.getBranchName()!=null)
		   {branchName="%"+input.getBranchName().toUpperCase()+"%";}
		   
		   String city=null;
		   if(input.getCity()!=null) 
		   {city="%"+input.getCity().toUpperCase()+"%";}
			   
		   String stat=null;
		   if(input.getStateName()!=null) 
		   {stat="%"+input.getStateName().toUpperCase()+"%";}
		   
		   String country=null;
		   if(input.getCountry()!=null) 
		   {country="%"+input.getCountry().toUpperCase()+"%";}
		   
		   String status=null;
		   if(input.getStatus()!=null) 
		   {status="%"+input.getStatus().toUpperCase()+"%";}
			
		   if(input.getStDate() == null || input.getStDate().trim().equals(""))
		   {input.setStDate(null);}
		   
		   if(input.getEnDate() == null || input.getEnDate().trim().equals(""))
		   {input.setEnDate(null);}
		   
		   String count  = (String)getJdbcTemplate().queryForObject(
					query, new Object[] {companyId, companyName,branchCode,branchName,city,
							country,stat,status,input.getStDate(),input.getEnDate()}, String.class);
		
			return Long.parseLong(count);
	
	}

	@Override
	public List<LtMastBranches> getBranchDataTableRecords(Long companyId, LtMastBranches input) throws ServiceException 
	{
		String query = env.getProperty("getBranchDataTableRecords");
		
		String companyName = null;
		 if(input.getCompanyName()!=null && !input.getCompanyName().equals(""))
		   { companyName="%"+input.getCompanyName().toUpperCase()+"%";}
		
		String branchCode=null;
		   if(input.getBranchCode()!=null && !input.getBranchCode().equals(""))
		   { branchCode="%"+input.getBranchCode().toUpperCase()+"%";}
		   
		   String branchName=null;
		   if(input.getBranchName()!=null && !input.getBranchName().equals(""))
		   {branchName="%"+input.getBranchName().toUpperCase()+"%";}
		   
		   String city=null;
		   if(input.getCity()!=null && !input.getCity().equals("")) 
		   {city="%"+input.getCity().toUpperCase()+"%";}
			   
		   String stat=null;
		   if(input.getStateName()!=null && !input.getStateName().equals("")) 
		   {stat="%"+input.getStateName().toUpperCase()+"%";}
		   
		   String country=null;
		   if(input.getCountry()!=null && !input.getCountry().equals("")) 
		   {country="%"+input.getCountry().toUpperCase()+"%";}
		   
		   String status=null;
		   if(input.getStatus()!=null && !input.getStatus().equals("")) 
		   {status="%"+input.getStatus().toUpperCase()+"%";}
			
		   if(input.getStDate() == null || input.getStDate().trim().equals(""))
		   {input.setStDate(null);}
		   
		   if(input.getEnDate() == null || input.getEnDate().trim().equals(""))
		   {input.setEnDate(null);}
		   
		   if(input.getColumnNo()==0)
		   {
			   input.setColumnNo(1);
		   }
	
		   return jdbcTemplate.query(query, new Object[] {companyId, companyName,branchCode,branchName,city,
					country,stat,status,input.getStDate(),input.getEnDate(),
					
					input.getColumnNo(),input.getColumnNo(),
					input.getColumnNo(),input.getColumnNo(),
					input.getColumnNo(),input.getColumnNo(),
					input.getColumnNo(),input.getColumnNo(),
					input.getColumnNo(),input.getColumnNo(),
					input.getColumnNo(),input.getColumnNo(),
					input.getColumnNo(),input.getColumnNo(),
					input.getColumnNo(),input.getColumnNo(),
					input.getColumnNo(),input.getColumnNo(),
					input.getColumnNo(),input.getColumnNo(),
					input.getStart()+input.getLength(),input.getStart()+1},

			new RowMapper<LtMastBranches>() {
				@Override
				public LtMastBranches mapRow(ResultSet rs, int row) throws SQLException {
					LtMastBranches ltMastBranches = new LtMastBranches();
					ltMastBranches.setBranchId(rs.getLong("BRANCH_ID"));
					ltMastBranches.setBranchCode(rs.getString("BRANCH_CODE"));
					ltMastBranches.setBranchName(rs.getString("BRANCH_NAME"));
					ltMastBranches.setCity(rs.getString("CITY"));
					ltMastBranches.setStateName(rs.getString("state_name"));
					ltMastBranches.setCountry(rs.getString("country"));
					ltMastBranches.setBranchType(rs.getString("BRANCH_TYPE"));
					ltMastBranches.setManagerName(rs.getString("MANAGER_NAME"));
					ltMastBranches.setGstRegNo(rs.getString("GST_REG_NO"));
					ltMastBranches.setManagerOfficalEmailId(rs.getString("OFFICIAL_EMAIL"));
					ltMastBranches.setRegion(rs.getString("REGION"));
					ltMastBranches.setStatus(rs.getString("status"));
					//ltMastBranches.setReportingBranchName(rs.getString(""));BRANCH_TYPE
					ltMastBranches.setOpeningDate(rs.getDate("OPENING_DATE"));
					ltMastBranches.setStartDate(rs.getDate("START_DATE"));
					ltMastBranches.setEndDate(rs.getDate("END_DATE"));
				//	ltMastBranches.setReportingBranch(rs.getLong("REPORTING_BRANCH"));
					ltMastBranches.setCompanyName(rs.getString("COMPANY_NAME"));
					return ltMastBranches;
					
				}

			}

	);
		
	
	}

	@Override
	public List<LtMastBranches> getAllActiveBillingAddress(Long companyId) throws ServiceException {
		String query = env.getProperty("getAllBranchActiveBillingAddress");

		List<LtMastBranches> list=   jdbcTemplate.query(query, new Object[]{ companyId }, 
		 new BeanPropertyRowMapper<LtMastBranches>(LtMastBranches.class)); 
		return list;
	}

	@Override
	public List<LtMastBranches> getAllActiveShippingAddress(Long companyId) throws ServiceException {
		String query = env.getProperty("getAllActiveShippingAddress");

		List<LtMastBranches> list=   jdbcTemplate.query(query, new Object[]{ companyId }, 
		 new BeanPropertyRowMapper<LtMastBranches>(LtMastBranches.class)); 
		return list;
	}

	@Override
	public List<LtMastBranches> getAllActiveBillingAddrByBuyer(Long id) throws ServiceException {
		String query = env.getProperty("getAllActiveBillingAddrByBuyer");

		List<LtMastBranches> list=   jdbcTemplate.query(query, new Object[]{ id}, 
		 new BeanPropertyRowMapper<LtMastBranches>(LtMastBranches.class)); 
		return list;
	}

	@Override
	public List<LtMastBranches> getAllActiveShippingAddrByBuyer(Long id) throws ServiceException {
		String query = env.getProperty("getAllActiveShippingAddrByBuyer");

		List<LtMastBranches> list=   jdbcTemplate.query(query, new Object[]{ id}, 
		 new BeanPropertyRowMapper<LtMastBranches>(LtMastBranches.class)); 
		return list;
	}

	@Override
	public List<LtMastBranches> getLtMastBranchesByCompID(Long id) throws ServiceException {
		String query = env.getProperty("getLtMastBranchesByCompID");
		
		List<LtMastBranches> list=   jdbcTemplate.query(query, new Object[]{id }, 
		 new BeanPropertyRowMapper<LtMastBranches>(LtMastBranches.class)); 
		
			return list;
	}

	@Override
	public List<LtMastBranches> getLtMastLikeNameByCompanyId(Long id, String trim) throws ServiceException {
		String query = env.getProperty("getLtMastLikeNameByCompanyId");
		
		List<LtMastBranches> list=   jdbcTemplate.query(query, new Object[]{"%"+trim.toUpperCase()+"%","%"+trim.toUpperCase()+"%", id }, 
		 new BeanPropertyRowMapper<LtMastBranches>(LtMastBranches.class)); 
			return list;
	}

	@Override
	public LtMastBranches getForAuditByID(Long branchId) throws ServiceException {
		String query = env.getProperty("getBranchForAuditByID");
		List<LtMastBranches> list=   jdbcTemplate.query(query, new Object[]{branchId }, 
		 new BeanPropertyRowMapper<LtMastBranches>(LtMastBranches.class)); 
		if(!list.isEmpty())
		return list.get(0);
		else
			return null;
	}

	@Override
	public List<LtMastBranches> getDataForReport(ReportParameters reportParameters) throws ServiceException {
		String query = env.getProperty("getLtMastBranchesDataForReport");
		List<LtMastBranches> list=   jdbcTemplate.query(query, new Object[]{reportParameters.getStatus(),
				reportParameters.getStartDate(),reportParameters.getEndDate(),reportParameters.getCompanyId()  }, 
		 new BeanPropertyRowMapper<LtMastBranches>(LtMastBranches.class)); 
		
			return list;
	}

}
