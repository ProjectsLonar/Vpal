package com.lonar.vendor.vendorportal.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.lonar.vendor.vendorportal.model.LtVendorApproval;
import com.lonar.vendor.vendorportal.model.LtVendorApprovalHistory;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.reports.LtVendorApprovalSummary;
import com.lonar.vendor.vendorportal.reports.ReportParameters;

@Repository
@PropertySource(value = "classpath:queries/vendorApproverQueries.properties", ignoreResourceNotFound = true)
public class LtVendorApprovalDaoImpl implements LtVendorApprovalDao{

	@Autowired
	private Environment env;

	@PersistenceContext(name = "em")
	private EntityManager em;
	
	@Autowired
	LtMastEmployeesDao ltMastEmployeesDao;
	
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
	public boolean updateStatusApproval(LtVendorApprovalHistory approvalHistory) throws ServiceException {
		int res=0;	
		if(approvalHistory.getEmployeeId()!=null ) 
		{
			String query = env.getProperty("updateStatusApproval");
			res = jdbcTemplate.update(query,
					approvalHistory.getStatus(),new Date(),approvalHistory.getVendorApprovalId(),
					approvalHistory.getVendorId(), approvalHistory.getEmployeeId(),approvalHistory.getEmployeeId());
		}
		if(res!=0)
			return true;
		else
			return false;
	}

	@Override
	public boolean updateAllStatusApproval(LtVendorApprovalHistory approvalHistory) throws ServiceException
	{
		String query = env.getProperty("updateAllStatusApproval");
		int res=0;	
			res = jdbcTemplate.update(query,
						approvalHistory.getStatus(),new Date(),approvalHistory.getVendorApprovalId(),
						approvalHistory.getVendorId());
		if(res!=0)
			return true;
		else
			return false;
	}

	@Override
	public List<LtVendorApproval> chkEmpApproval(Long employeeId, Long vendorId) throws ServiceException {
		String query = env.getProperty("chkLtVendorApprovalEmpApproval");

		List<LtVendorApproval> ltExpenseApprovalList = jdbcTemplate.query(query, new Object[]
				{employeeId,vendorId,"APPROVED"},
				new RowMapper<LtVendorApproval>() {
					public LtVendorApproval mapRow(ResultSet rs, int arg1) throws SQLException {
						LtVendorApproval ltVendorApproval = new LtVendorApproval();
						ltVendorApproval.setVendorApprovalId(rs.getLong("VENDOR_APPROVAL_ID"));
						return ltVendorApproval;
					}
				});
	
		return ltExpenseApprovalList;
	}

	@Override
	public LtVendorApproval getVendorApproval(Long vendorId, Long apprId) throws ServiceException 
	{
		String query = env.getProperty("getVendorApproval");

		List<LtVendorApproval> ltExpenseApprovalList = jdbcTemplate.query(query, new Object[] {vendorId,apprId,apprId},
				new RowMapper<LtVendorApproval>() {
					public LtVendorApproval mapRow(ResultSet rs, int arg1) throws SQLException {

						LtVendorApproval ltExpenseApproval = new LtVendorApproval();
						ltExpenseApproval.setVendorApprovalId(rs.getLong("VENDOR_APPROVAL_ID"));
						ltExpenseApproval.setModuleApprovalId(rs.getLong("MODULE_APPROVAL_ID"));
						ltExpenseApproval.setApprovalId(rs.getLong("APPROVAL_ID"));
						ltExpenseApproval.setApprovalLevel(rs.getString("APPROVAL_LEVEL"));
						ltExpenseApproval.setCurrentApprovalLevel(rs.getString("CURRENT_APPROVAL_LEVEL"));
						ltExpenseApproval.setVendorId(rs.getLong("VENDOR_ID"));
						return ltExpenseApproval;
					}
				});
		
		
		if(ltExpenseApprovalList.size() > 0){
			return ltExpenseApprovalList.get(0);
		}
		return null;
	}

	@Override
	public List<LtVendorApproval> getVendorApprovalByVendorId(Long vendorId) throws ServiceException {
		String query = env.getProperty("getVendorApprovalByVendorId");
		
		List<LtVendorApproval> ltExpenseApprovalList = jdbcTemplate.query(query, new Object[] { vendorId },
				new RowMapper<LtVendorApproval>() {
					public LtVendorApproval mapRow(ResultSet rs, int arg1) throws SQLException {

						LtVendorApproval ltExpenseApproval = new LtVendorApproval();
						
						ltExpenseApproval.setVendorApprovalId(rs.getLong("VENDOR_APPROVAL_ID"));
						ltExpenseApproval.setDelegationId(rs.getLong("DELEGATION_ID"));
						ltExpenseApproval.setModuleApprovalId(rs.getLong("MODULE_APPROVAL_ID"));
						ltExpenseApproval.setApprovalId(rs.getLong("APPROVAL_ID"));
						ltExpenseApproval.setApprovalLevel(rs.getString("APPROVAL_LEVEL"));
						ltExpenseApproval.setCurrentApprovalLevel(rs.getString("CURRENT_APPROVAL_LEVEL"));
						ltExpenseApproval.setVendorId(rs.getLong("VENDOR_ID"));
						ltExpenseApproval.setStatus(rs.getString("STATUS"));
						ltExpenseApproval.setStartDate(rs.getDate("START_DATE"));
						ltExpenseApproval.setEndDate(rs.getDate("END_DATE"));
						ltExpenseApproval.setCreatedBy(rs.getLong("CREATED_BY"));
						ltExpenseApproval.setCreationDate(rs.getDate("CREATION_DATE"));
						ltExpenseApproval.setLastUpdateDate(rs.getDate("LAST_UPDATE_DATE"));
						ltExpenseApproval.setLastUpdateLogin(rs.getLong("LAST_UPDATE_LOGIN"));
						ltExpenseApproval.setLastUpdatedBy(rs.getLong("LAST_UPDATED_BY"));
						ltExpenseApproval.setModuleAppEmployeesId(rs.getLong("MODULE_APP_EMPLOYEES_ID"));
						ltExpenseApproval.setApprovalName(rs.getString("approval_Name"));
						ltExpenseApproval.setApprovalLevelName(rs.getString("approval_level_name"));
						return ltExpenseApproval;

					}
				});
		return ltExpenseApprovalList;
	}

	@Override
	public boolean chkForApprovers(Long vendorId) throws ServiceException {
		String query = env.getProperty("chkForApproversForVendor");

		List<LtVendorApproval> ltExpenseApprovalList = jdbcTemplate.query(query, new Object[] {vendorId},
				new RowMapper<LtVendorApproval>() {
					public LtVendorApproval mapRow(ResultSet rs, int arg1) throws SQLException {

						LtVendorApproval ltExpenseApproval = new LtVendorApproval();
						ltExpenseApproval.setVendorApprovalId(rs.getLong("VENDOR_APPROVAL_ID"));
						ltExpenseApproval.setModuleApprovalId(rs.getLong("MODULE_APPROVAL_ID"));
						ltExpenseApproval.setApprovalId(rs.getLong("APPROVAL_ID"));
						ltExpenseApproval.setApprovalLevel(rs.getString("APPROVAL_LEVEL"));
						ltExpenseApproval.setCurrentApprovalLevel(rs.getString("CURRENT_APPROVAL_LEVEL"));
						ltExpenseApproval.setVendorId(rs.getLong("VENDOR_ID"));
						return ltExpenseApproval;
					}
				});
		
		
		if(ltExpenseApprovalList.size() > 0){
			return true;
		}else
			return false;
	}

	@Override
	public boolean submitForApproval(Date submissionDate, Long vendorId, String status, Date approvedDate)
			throws ServiceException {
		int res=0;
		if(submissionDate!=null)
		{
			String query = env.getProperty("submitForApproval1");
			res=jdbcTemplate.update(query,status,new Date(),vendorId);
		}
		else
		{
			String query = env.getProperty("submitVendorForApproval2");
			 res=jdbcTemplate.update(query,status,new Date(),vendorId);
		}
		if(res!=0)
			return true;
		else
			return false;
	}

	@Override
	public String getCurrLevelByVendorApprovalId(Long vendorApprovalId) throws ServiceException {
		String query = env.getProperty("getCurrLevelByVendorApprovalId");
		
		String nextlavel  = (String)getJdbcTemplate().queryForObject(
				query, new Object[] { vendorApprovalId}, String.class);

		return nextlavel;
	}

	@Override
	public List<LtVendorApproval> chkCurrentApprover(Long vendorId) throws ServiceException {
		String query = env.getProperty("chkCurrentApprover");

		List<LtVendorApproval> ltExpenseApprovalList = jdbcTemplate.query(query, new Object[] {vendorId},
				new RowMapper<LtVendorApproval>() {
					public LtVendorApproval mapRow(ResultSet rs, int arg1) throws SQLException {

						LtVendorApproval ltExpenseApproval = new LtVendorApproval();
						
						ltExpenseApproval.setVendorApprovalId(rs.getLong("VENDOR_APPROVAL_ID"));
						ltExpenseApproval.setModuleApprovalId(rs.getLong("MODULE_APPROVAL_ID"));
						ltExpenseApproval.setApprovalId(rs.getLong("APPROVAL_ID"));
						ltExpenseApproval.setApprovalLevel(rs.getString("APPROVAL_LEVEL"));
						ltExpenseApproval.setCurrentApprovalLevel(rs.getString("CURRENT_APPROVAL_LEVEL"));
						
						ltExpenseApproval.setVendorId(rs.getLong("VENDOR_ID"));
						
						return ltExpenseApproval;
					}
				});
	
		return ltExpenseApprovalList;
	}

	@Override
	public boolean updateVendorStatusApproval(LtVendorApprovalHistory approvalHistory) throws ServiceException {
		String query = env.getProperty("updateVendorStatusApproval");
		int res=0;	
		
			res = jdbcTemplate.update(query,
					approvalHistory.getStatus(),new Date(),approvalHistory.getVendorApprovalId(),
					approvalHistory.getVendorId());
		
		if(res!=0)
			return true;
		else
			return false;
	}

	@Override
	public List<LtVendorApproval> getInvoiceApprovalByInvoiceId(Long invoiceId) throws ServiceException {
		String query = env.getProperty("getInvoiceApprovalByInvoiceId");
		
		
		List<LtVendorApproval> ltExpenseApprovalList = jdbcTemplate.query(query, new Object[] { invoiceId },
				new RowMapper<LtVendorApproval>() {
					public LtVendorApproval mapRow(ResultSet rs, int arg1) throws SQLException {

						LtVendorApproval ltVendorApproval = new LtVendorApproval();
						
						ltVendorApproval.setVendorApprovalId(rs.getLong("INVOICE_APPROVAL_ID"));
						ltVendorApproval.setDelegationId(rs.getLong("DELEGATION_ID"));
						ltVendorApproval.setModuleApprovalId(rs.getLong("MODULE_APPROVAL_ID"));
						ltVendorApproval.setApprovalId(rs.getLong("APPROVAL_ID"));
						ltVendorApproval.setApprovalLevel(rs.getString("APPROVAL_LEVEL"));
						ltVendorApproval.setCurrentApprovalLevel(rs.getString("CURRENT_APPROVAL_LEVEL"));
						ltVendorApproval.setVendorId(rs.getLong("INVOICE_HEADER_ID"));
						ltVendorApproval.setStatus(rs.getString("STATUS"));
						ltVendorApproval.setStartDate(rs.getDate("START_DATE"));
						ltVendorApproval.setEndDate(rs.getDate("END_DATE"));
						ltVendorApproval.setCreatedBy(rs.getLong("CREATED_BY"));
						ltVendorApproval.setCreationDate(rs.getDate("CREATION_DATE"));
						ltVendorApproval.setLastUpdateDate(rs.getDate("LAST_UPDATE_DATE"));
						ltVendorApproval.setLastUpdateLogin(rs.getLong("LAST_UPDATE_LOGIN"));
						ltVendorApproval.setLastUpdatedBy(rs.getLong("LAST_UPDATED_BY"));
						ltVendorApproval.setModuleAppEmployeesId(rs.getLong("MODULE_APP_EMPLOYEES_ID"));
						ltVendorApproval.setApprovalName(rs.getString("approval_Name"));
						ltVendorApproval.setApprovalLevelName(rs.getString("approval_level_name"));
						return ltVendorApproval;

					}
				});
		return ltExpenseApprovalList;
	}

	@Override
	public List<LtVendorApprovalSummary> getDataForReport(ReportParameters reportParameters) throws ServiceException {
		String query = env.getProperty("getVendorApprovalSummaryDataForReport");
		List<LtVendorApprovalSummary> list=   jdbcTemplate.query(query, new Object[]{reportParameters.getCompanyId(),
				reportParameters.getVendorId(),reportParameters.getStatus(),reportParameters.getInitiatorId()}, 
				 new BeanPropertyRowMapper<LtVendorApprovalSummary>(LtVendorApprovalSummary.class)); 
		return list;
	}

}
