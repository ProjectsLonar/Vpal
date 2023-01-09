package com.lonar.vendor.vendorportal.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.lonar.vendor.vendorportal.model.LtMastEmailtoken;
import com.lonar.vendor.vendorportal.repository.LtMastEmailtokenRepository;


@Component

@PropertySource(value = "classpath:queries/emailTokenQueries.properties", ignoreResourceNotFound = true)
public class LtMastEmailtokenDaoImpl implements LtMastEmailtokenDao 
{
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private Environment env;
	
	@Autowired
	public void setDataSource(DataSource dataSource)
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	private JdbcTemplate getJdbcTemplate() {
		// TODO Auto-generated method stub
		return jdbcTemplate;
	} 

	@Autowired
	LtMastEmailtokenRepository ltMastEmailtokenRepository;
	
	
	@Override
	public List<LtMastEmailtoken> findByEmailtokenid(Long emailtokenid)
			throws Exception {
		String sqlQuery = env.getProperty("findByEmailtokenid");
		//String sqlQuery="SELECT * FROM lt_expense_emailtoken r WHERE EMAIL_TOKEN_ID=? ";
		  return jdbcTemplate.query(sqlQuery, new Object[]{emailtokenid}, new RowMapper<LtMastEmailtoken>(){
				@Override
				public LtMastEmailtoken mapRow(ResultSet rs, int row)
						throws SQLException {
						LtMastEmailtoken tokens=new LtMastEmailtoken();
						tokens.setEmailTokenId(Long.parseLong(rs.getString("EMAIL_TOKEN_ID").toString()));
						tokens.setEmailUserId(rs.getLong("EMAIL_USER_ID"));
						tokens.setTokenId(rs.getString("TOKEN_ID"));
						return tokens;
					}
		  });
	}

	@Override
	public List<LtMastEmailtoken> findByTokenid(String tokenid)
			throws Exception,ParseException {
		String sqlQuery = env.getProperty("findByTokenid");
			//String sqlQuery="SELECT * FROM lt_expense_emailtoken r WHERE TOKEN_ID=? ";
			  return jdbcTemplate.query(sqlQuery, new Object[]{tokenid}, new RowMapper<LtMastEmailtoken>(){
					@Override
					public LtMastEmailtoken mapRow(ResultSet rs, int row)
							throws SQLException {
							LtMastEmailtoken tokens=new LtMastEmailtoken();
							tokens.setTokenId(rs.getString("TOKEN_ID"));
							tokens.setEmailUserId(rs.getLong("EMAIL_USER_ID"));
							tokens.setSendDate(rs.getDate("SEND_DATE"));
							tokens.setExpiredWithin(rs.getLong("EXPIRED_WITHIN"));
							tokens.setEmailTokenId(rs.getLong("EMAIL_TOKEN_ID"));
												
							return tokens;
						}
			  });
	}			  

	@Override
	public List<LtMastEmailtoken> findAllActive() throws Exception 
	{
		String sqlQuery = env.getProperty("findAllActive");
				String query = "SELECT * FROM lt_expense_emailtoken e " + 
						" WHERE (e.EMAIL_STATUS = 'SENDING' OR e.EMAIL_STATUS = 'Fail to Send') " ; 
						//" AND (e.FAILURECOUNT IS NULL OR e.FAILURECOUNT <=5) ";
				
				List<LtMastEmailtoken> list=   jdbcTemplate.query(query, new Object[]{ }, 
						 new BeanPropertyRowMapper<LtMastEmailtoken>(LtMastEmailtoken.class)); 
				
				return list;
			
	}

	

	@Override
	public Long makeEntryInEmailToken(LtMastEmailtoken ltMastEmailtoken) throws Exception 
	{
		/*GeneratedKeyHolder holder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator()
		{
		    @Override
		    public PreparedStatement createPreparedStatement(Connection con) throws SQLException 
		    {
		    	
		        PreparedStatement statement = con.prepareStatement
		        (" INSERT INTO lt_expense_emailtoken "
		        + " (SEND_DATE,EXPIRED_WITHIN,SEND_TO,"
		        + "EMAIL_OBJECT,EMAIL_STATUS,EMAIL_TITLE,EMAIL_TEMPLATE,TOKEN_ID,EMAIL_USER_ID )"
		       + " VALUES(?,?,?,?,?,?,?,?,?) ", Statement.RETURN_GENERATED_KEYS);
		        statement.setTimestamp(1, new Timestamp(ltMastEmailtoken.getSendDate().getTime()));
		        statement.setLong(2, ltMastEmailtoken.getExpiredWithin());
		        statement.setString(3, ltMastEmailtoken.getSendTo());
		        statement.setString(4, ltMastEmailtoken.getEmailObject());
		        statement.setString(5, ltMastEmailtoken.getEmailStatus());
		        statement.setString(6, ltMastEmailtoken.getEmailTitle());
		        statement.setString(7, ltMastEmailtoken.getEmailTemplate());
		        statement.setString(8, ltMastEmailtoken.getTokenId());
		        if(ltMastEmailtoken.getEmailUserId()!=null)
		        {
		        statement.setLong(9, ltMastEmailtoken.getEmailUserId());
		        }
		        else
		        {
		        	 statement.setLong(9, 0);
		        }
		        
		       
		       
		        return statement;
		    }
		}, holder);
*/
		//Long primaryKey = holder.getKey().longValue();
		LtMastEmailtoken emailtoken =ltMastEmailtokenRepository.save(ltMastEmailtoken);
		return emailtoken.getEmailTokenId();
		
	}


	@Override
	public List<LtMastEmailtoken> getByStatus(String status) throws Exception 
	{
		String query = env.getProperty("getByStatus");
		//String query = " SELECT *  FROM lt_expense_emailtoken a WHERE a.EMAIL_STATUS= ?  ";
			
		List<LtMastEmailtoken> list=   jdbcTemplate.query(query, new Object[]{ status}, 
			 new BeanPropertyRowMapper<LtMastEmailtoken>(LtMastEmailtoken.class)); 
		
		return list;
	}


	@Override
	public void updateEmailToken(String status) throws Exception 
	{
		String sqlQuery = env.getProperty("updateEmailToken");
		int res=jdbcTemplate.update(sqlQuery,status);
		
		/*if(res==1)
			return true;
		else
			return false;*/
		
	}


	@Override
	public void updateStatus(Long tokenId, String status, Long count) throws Exception {
	
		String sqlQuery = env.getProperty("updateStatus");
		int res=jdbcTemplate.update(sqlQuery,status, count , tokenId );
	}


	

	@Override
	public List<LtMastEmailtoken> getDataTable(LtMastEmailtoken input) throws Exception {
		String query = env.getProperty("getEmailtokenDataTable");
		
		String sendDate=null;
		if(input.getSnDate()!=null)
		{sendDate="%"+input.getSnDate()+"%";}
						  
		String tokenId=null;
		if(input.getEmailTokenId()!=null)
		{tokenId="%"+input.getEmailTokenId()+"%";}
							
		String emailStatus=null;
		if(input.getEmailStatus()!=null && !input.getEmailStatus().equals("")) 
		{emailStatus="%"+input.getEmailStatus().toUpperCase()+"%";}
						   
		String emailTitle=null;
		if(input.getEmailTitle()!=null && !input.getEmailTitle().equals("")) 
		{emailTitle="%"+input.getEmailTitle().toUpperCase()+"%";}
						    
		String sendTo=null;
		if(input.getSendTo()!=null && !input.getSendTo().equals("")) 
		{sendTo="%"+input.getSendTo().toUpperCase()+"%";}
			   
				
		if(input.getColumnNo()==0)
		{
			input.setColumnNo(12);
		}
				
			
		return (List<LtMastEmailtoken>) 
				jdbcTemplate.query(query , new Object[]{tokenId,sendDate,emailStatus,sendTo,emailTitle,
						input.getColumnNo(),input.getColumnNo(),
						input.getColumnNo(),input.getColumnNo(),
						input.getColumnNo(),input.getColumnNo(),
						input.getColumnNo(),input.getColumnNo(),
						input.getColumnNo(),input.getColumnNo(),
						input.getStart()+input.getLength(),input.getStart()+1},
			 new  BeanPropertyRowMapper<LtMastEmailtoken>(LtMastEmailtoken.class));
	}

	@Override
	public Long getCount(LtMastEmailtoken input) throws Exception {
		String query = env.getProperty("getCountEmailtoken");
		
		String sendDate=null;
		if(input.getSnDate()!=null)
		{sendDate="%"+input.getSnDate()+"%";}
				  
					String tokenId=null;
					if(input.getEmailTokenId()!=null)
					{tokenId="%"+input.getEmailTokenId()+"%";}
					
					String emailStatus=null;
				    if(input.getEmailStatus()!=null) 
				   {emailStatus="%"+input.getEmailStatus().toUpperCase()+"%";}
				   
				    String emailTitle=null;
				    if(input.getEmailTitle()!=null && !input.getEmailTitle().equals("")) 
				   {emailTitle="%"+input.getEmailTitle().toUpperCase()+"%";}
				    
				    String sendTo=null;
				    if(input.getSendTo()!=null) 
				   {sendTo="%"+input.getSendTo().toUpperCase()+"%";}
	   
		
		
		String count  = (String)getJdbcTemplate().queryForObject(
				query, new Object[] {tokenId,sendDate,emailStatus,emailTitle,sendTo}, String.class);

		
		return Long.parseLong(count);
}

	@Override
	public LtMastEmailtoken getLtMastEmailtokenById(String emailtokenid) {
		String query = env.getProperty("getLtMastEmailtokenById");
		//String query = "SELECT * FROM LT_EXPENSE_EMAILTOKEN ee WHERE ee.EMAIL_TOKEN_ID=?";
		
		List<LtMastEmailtoken> list=   jdbcTemplate.query(query, new Object[]{emailtokenid}, 
		 new BeanPropertyRowMapper<LtMastEmailtoken>(LtMastEmailtoken.class)); 
		if(!list.isEmpty())
			return list.get(0);
		else
			return null;
	}


}
