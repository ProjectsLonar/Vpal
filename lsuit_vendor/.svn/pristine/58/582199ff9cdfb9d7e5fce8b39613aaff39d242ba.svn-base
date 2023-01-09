package com.lonar.vendor.vendorportal.dao;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.lonar.vendor.vendorportal.model.LtMastVendorBanks;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.reports.ReportParameters;
import com.lonar.vendor.vendorportal.repository.LtMastVendorBanksRepository;

@Component
@PropertySource(value = "classpath:queries/vendorBanksQueries.properties", ignoreResourceNotFound = true)
public class LtMastVendorBanksDaoImpl implements LtMastVendorBanksDao
{

	
	@Autowired
	private Environment env;
	
	@Autowired
	LtMastVendorBanksRepository ltMastVendorBanksRepository;
	
	private JdbcTemplate jdbcTemplate;
	@Autowired
	public void setDataSource(DataSource dataSource)
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Transactional
	@Override
	public List<LtMastVendorBanks> getAllVendorBanks() throws ServiceException 
	{
		String query = env.getProperty("listVendorBanks");
		List<LtMastVendorBanks> list=   jdbcTemplate.query(query, new Object[]{ }, 
		new BeanPropertyRowMapper<LtMastVendorBanks>(LtMastVendorBanks.class)); 
	return list;
	}

	@Transactional
    @Override
    public List<LtMastVendorBanks> findByVendorIdWithAddressId(Long vendorId, Long vendorAddId) throws ServiceException
    {
		String query = env.getProperty("findByVendorIdWithAddressId");
        List<LtMastVendorBanks> list=   jdbcTemplate.query(query, new Object[]{vendorId, vendorAddId}, 
                     new BeanPropertyRowMapper<LtMastVendorBanks>(LtMastVendorBanks.class)); 
              return list;
            
    }
	
	
	@Transactional
	@Override
	public LtMastVendorBanks getVendorBankByBankId(Long vendorBankId) throws ServiceException
	{
		String query = env.getProperty("getVendorBankByBankId");
		
	List<LtMastVendorBanks> list=   jdbcTemplate.query(query, new Object[]{vendorBankId }, 
			 new BeanPropertyRowMapper<LtMastVendorBanks>(LtMastVendorBanks.class)); 
	 if(!list.isEmpty())
		 return list.get(0);
	 else
		 return null;
	}

	@Transactional
	@Override
	public LtMastVendorBanks getVendorBankByVendorId(Long vendorId) throws ServiceException
	{
		String query = env.getProperty("getVendorBankByVendorId");
			List<LtMastVendorBanks> list=   jdbcTemplate.query(query, new Object[]{vendorId }, 
					 new BeanPropertyRowMapper<LtMastVendorBanks>(LtMastVendorBanks.class)); 
			 if(!list.isEmpty())
				 return list.get(0);
			 else
				 return null;
	}

	@Transactional
	@Override
	public Long save(LtMastVendorBanks ltMastVendorBanks) throws ServiceException 
	{
		ltMastVendorBanks.setCreationDate(new Date());
		ltMastVendorBanks.setLastUpdateDate(new Date());
		ltMastVendorBanks.setCreatedBy(ltMastVendorBanks.getLastUpdateLogin());
		ltMastVendorBanks.setLastUpdatedBy(ltMastVendorBanks.getLastUpdateLogin());
		ltMastVendorBanks = ltMastVendorBanksRepository.save(ltMastVendorBanks);

		return ltMastVendorBanks.getVendorBankId();
		
		/*String query = env.getProperty("saveVendorBanks");
		
		int res=jdbcTemplate.update(/*" INSERT INTO LT_MAST_VENDOR_BANKS (VENDOR_ID,VENDOR_ADD_ID,BANK_NAME, "
				+ " BANK_BRANCH, IFSC_CODE, BRANCH_ADDRESS, BANK_ACCOUNT_NO, Start_Date, End_Date, Created_by,"
				+ " Creation_date, Last_update_login, Last_updated_by, Last_update_date ) "
     		+ " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?) "
				
     		query,
     		ltMastVendorBanks.getVendorId(),ltMastVendorBanks.getVendorAddId(),ltMastVendorBanks.getBankName(),
     		ltMastVendorBanks.getBankBranch(),ltMastVendorBanks.getIfscCode(),ltMastVendorBanks.getBranchAddress(),
     		ltMastVendorBanks.getBankAccountNo(),ltMastVendorBanks.getStartDate(),ltMastVendorBanks.getEndDate(),
     		ltMastVendorBanks.getCreatedBy(),ltMastVendorBanks.getCreationDate(),ltMastVendorBanks.getLastUpdateLogin(),
     		ltMastVendorBanks.getLastUpdatedBy(),ltMastVendorBanks.getLastUpdateDate());
		
		if(res==1)
			return true;
		else
			return false;*/
	}

	@Transactional
	@Override
	public boolean update(LtMastVendorBanks ltMastVendorBanks) throws ServiceException 
	{
		ltMastVendorBanks.setLastUpdateDate(new Date());
		ltMastVendorBanks.setLastUpdatedBy(ltMastVendorBanks.getLastUpdateLogin());
		String query = env.getProperty("updateVendorBanks");
		int res=jdbcTemplate.update(query,
     		ltMastVendorBanks.getVendorId(),ltMastVendorBanks.getVendorAddId(),ltMastVendorBanks.getBankName(),
     		ltMastVendorBanks.getBankBranch(),ltMastVendorBanks.getIfscCode(),ltMastVendorBanks.getBranchAddress(),
     		ltMastVendorBanks.getBankAccountNo(),ltMastVendorBanks.getStartDate(),ltMastVendorBanks.getEndDate(),
     		ltMastVendorBanks.getCreatedBy(),ltMastVendorBanks.getCreationDate(),ltMastVendorBanks.getLastUpdateLogin(),
     		ltMastVendorBanks.getLastUpdatedBy(),ltMastVendorBanks.getLastUpdateDate(),ltMastVendorBanks.getMicrNo(),
     		ltMastVendorBanks.getInvoiceCurrency(),ltMastVendorBanks.getAccountType(),ltMastVendorBanks.getVendorBankId());
		if(res==1)
			return true;
		else
			return false;
	}

	@Override
	public boolean delete(Long vendorBankId) throws ServiceException 
	{
		String query = env.getProperty("deleteVendorBanks");
		int res=jdbcTemplate.update(query,vendorBankId);
		if(res==1)
			return true;
		else
			return false;
	}

	@Override
	public List<LtMastVendorBanks> getAllVendorBankByVendorId(Long vendorId) throws ServiceException
	{
		String query = env.getProperty("getAllVendorBankByVendorId");
			List<LtMastVendorBanks> list=   jdbcTemplate.query(query, new Object[]{vendorId }, 
					 new BeanPropertyRowMapper<LtMastVendorBanks>(LtMastVendorBanks.class)); 
			 if(!list.isEmpty())
				 return list;
			 else return null;
	}

	@Override
	public boolean deleteByVendorId(Long vendorId) throws ServiceException
	{
		String query = env.getProperty("deleteByVendorIdVendorBanks");
		int res=jdbcTemplate.update(query,vendorId);
		if(res==1)
			return true;
		else
			return false;
	}

	@Override
	public List<LtMastVendorBanks> getDataForReport(ReportParameters reportParameters) throws ServiceException {
		String query = env.getProperty("getLtMastVendorBanksDataForReport");
		
		List<LtMastVendorBanks> list=   jdbcTemplate.query(query, new Object[]{reportParameters.getCompanyId(),
				reportParameters.getVendorId(),reportParameters.getStatus(),
				reportParameters.getAddressCode(),reportParameters.getAddressState()}, 
				 new BeanPropertyRowMapper<LtMastVendorBanks>(LtMastVendorBanks.class));
		return list; 
	}

	@Override
	public Long getLtMastVendorBanksCount(Long vendorAddressId, LtMastVendorBanks input) throws ServiceException {
		String query = env.getProperty("getLtMastVendorBanksCount");
		 
		String bankName=null;
		   if(input.getBankName()!=null && !input.getBankName().equals(""))
		   {bankName="%"+input.getBankName().trim().toUpperCase() + "%";}
		   
		   String location=null;
		   if(input.getBankBranch()!=null && !input.getBankBranch().equals(""))
		   {location="%"+input.getBankBranch().trim().toUpperCase()+"%";}
		   
		   String accNo=null;
		   if(input.getBankAccountNo()!=null && !input.getBankAccountNo().equals("")) 
		   {accNo="%"+input.getBankAccountNo().trim().toUpperCase()+"%";}
		   
		   String ifsc=null;
		   if(input.getIfscCode()!=null &&  !input.getIfscCode().equals("")) 
		   {ifsc="%"+input.getIfscCode().trim().trim().toUpperCase()+"%";}
		   
		   
		   String addr=null;
		   if(input.getBranchAddress()!=null &&  !input.getBranchAddress().equals("")) 
		   {addr="%"+input.getBranchAddress().trim().trim().toUpperCase()+"%";}
		   
		   
			if(input.getStDate() == null || input.getStDate().trim().equals(""))
			{
				input.setStDate(null);
			}
			if(input.getEnDate() == null || input.getEnDate().trim().equals(""))
			{
				input.setEnDate(null);
			}
		
	String count  = jdbcTemplate.queryForObject(query, new Object[] {vendorAddressId,bankName,location,accNo,ifsc,addr,
			input.getStDate(),input.getEnDate()}, String.class);

	return Long.parseLong(count);
	}

	@Override
	public List<LtMastVendorBanks> getLtMastVendorBanksDataTable(Long vendorAddressId, LtMastVendorBanks input)
			throws ServiceException {
		String query = env.getProperty("getLtMastVendorBanksDataTable");
		
		   String bankName=null;
		   if(input.getBankName()!=null && !input.getBankName().equals(""))
		   {bankName="%"+input.getBankName().trim().toUpperCase() + "%";}
		   
		   String location=null;
		   if(input.getBankBranch()!=null && !input.getBankBranch().equals(""))
		   {location="%"+input.getBankBranch().trim().toUpperCase()+"%";}
		   
		   String accNo=null;
		   if(input.getBankAccountNo()!=null && !input.getBankAccountNo().equals("")) 
		   {accNo="%"+input.getBankAccountNo().trim().toUpperCase()+"%";}
		   
		   String ifsc=null;
		   if(input.getIfscCode()!=null &&  !input.getIfscCode().equals("")) 
		   {ifsc="%"+input.getIfscCode().trim().trim().toUpperCase()+"%";}
		   
		   
		   String addr=null;
		   if(input.getBranchAddress()!=null &&  !input.getBranchAddress().equals("")) 
		   {addr="%"+input.getBranchAddress().trim().trim().toUpperCase()+"%";}
		   
		   
			if(input.getStDate() == null || input.getStDate().trim().equals(""))
			{
				input.setStDate(null);
			}
			if(input.getEnDate() == null || input.getEnDate().trim().equals(""))
			{
				input.setEnDate(null);
			}
			
			 
			List<LtMastVendorBanks> list = (List<LtMastVendorBanks>) 
					jdbcTemplate.query(query , new Object[]{vendorAddressId,bankName,location,accNo,ifsc,addr,
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
				 new  BeanPropertyRowMapper<LtMastVendorBanks>(LtMastVendorBanks.class));
				return list;
	}

}
