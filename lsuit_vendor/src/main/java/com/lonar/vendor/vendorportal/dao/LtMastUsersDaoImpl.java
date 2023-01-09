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

import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtMastUsers;
import com.lonar.vendor.vendorportal.model.ServiceException;


@Component
@PropertySource(value = "classpath:queries/userMasterQueries.properties", ignoreResourceNotFound = true)
public class LtMastUsersDaoImpl implements LtMastUsersDao, CodeMaster
{
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private Environment env;
	
	private JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
/*	@Override
	public List<LtMastUsers> getUserNamePassword(String userName, String password){
		  String sqlQuery = env.getProperty("getUserNamePassword");
		  //String sqlQuery="SELECT USER_ID,USER_NAME,LOGINFAILUREATTEMPT,PASSWORD,PASSWORD_DATE,EMPLOYEE_ID,EMAIL FROM lt_mast_users r WHERE LOWER(r.USER_NAME) like ? and r.PASSWORD = ? ";
		   return jdbcTemplate.query(sqlQuery, new Object[]{ "%"+userName.toLowerCase(),"%"+password}, new RowMapper<LtMastUsers>(){
			@Override
			public LtMastUsers mapRow(ResultSet rs, int row)
					throws SQLException {
				    LtMastUsers users=new LtMastUsers();
				    users.setUserId(rs.getLong("USER_ID"));
				    users.setUserName(rs.getString("USER_NAME"));
					return users;
			}
			
		   });
	}	
*/
	@Override
	public List<LtMastUsers> findByAdId(String adId) {
		String query =  "SELECT * FROM LT_MAST_USERS WHERE UPPER(AD_ID) = ? ";
		return  jdbcTemplate.query(query, new Object[]{ adId.toUpperCase() }, 
				new BeanPropertyRowMapper(LtMastUsers.class));
	}
	

	
	@Override
	public List<LtMastUsers> findByUserName(String userName) {
		String sqlQuery = env.getProperty("findByUserName");
		  /* return jdbcTemplate.query(sqlQuery, new Object[]{ userName.toLowerCase(), userName.toUpperCase()}, 
				   new RowMapper<LtMastUsers>(){
			@Override
			public LtMastUsers mapRow(ResultSet rs, int row)
					throws SQLException {
				    LtMastUsers users=new LtMastUsers();
				    users.setUserId(rs.getLong("USER_ID"));
				    users.setUserName(rs.getString("USER_NAME"));
				    users.setLoginFailureAttempt(rs.getLong("LOGINFAILUREATTEMPT"));
				    users.setPassword(rs.getString("PASSWORD"));
				    users.setPasswordDate(rs.getDate("PASSWORD_DATE"));
				    users.setEmployeeId(rs.getLong("EMPLOYEE_ID"));
				    users.setEmail(rs.getString("EMAIL"));
				    users.setChangePwd(rs.getString("CHANGE_PWD"));
				    users.setCreatedBy(rs.getLong("CREATED_BY"));
				    users.setEmployeeId(rs.getLong("EMPLOYEE_ID"));
				    users.setStartDate(rs.getDate("START_DATE"));
				    users.setStatus(rs.getString("STATUS"));
				    users.setLastUpdateLogin(rs.getLong("LAST_UPDATE_LOGIN"));
				    users.setCreationDate(rs.getDate("CREATION_DATE"));
				    users.setEmployeeName(rs.getString("EMPLOYEE_NAME"));
				    users.setVendorId(rs.getLong("VENDOR_ID"));
					return users;
				}
				
		   });*/
		// String query = env.getProperty("findByUserNameAndEmailId");
			List<LtMastUsers> list=  jdbcTemplate.query(sqlQuery, new Object[]{userName.toLowerCase(), userName.toUpperCase()}, 
			 new BeanPropertyRowMapper<LtMastUsers>(LtMastUsers.class)); 
			return list;
		
	}
	
	@Override
	public Long getLtMastUsersCount(LtMastUsers input)
	{
		String query = env.getProperty("getLtMastUsersCount");
		
		String uname = null;
		 if(input.getUserName()!=null)
		   { uname="%"+input.getUserName().trim().toUpperCase()+"%";}
		 
		 if(input.getStDate() == null || input.getStDate().trim().equals(""))
		   {input.setStDate(null);}
		   
		 if(input.getEnDate() == null || input.getEnDate().trim().equals(""))
		   {input.setEnDate(null);}
		   
		 String status=null;
		   if(input.getStatus()!=null) 
		   {status="%"+input.getStatus().trim().toUpperCase()+"%";}
		   
		   String email = null;
		   if(input.getEmail()!=null)
		   { email="%"+input.getEmail().trim().toUpperCase()+"%";}
		   			
		  
		   Long count  = getJdbcTemplate().queryForObject(
					query, new Object[] {uname,input.getStDate(),input.getEnDate(),status,email}, Long.class);
		
			return count;
	}

	@Override
	public List<LtMastUsers> getLtMastUsersDatatableRecords(LtMastUsers input) {
		String query = env.getProperty("getLtMastUsersDataTableRecords");
		if(input.getSort() != null && input.getSort().equals("desc")) {
			input.setColumnNo( input.getColumnNo() == 1 ? 11 
								: input.getColumnNo() == 2 ? 12 
								: input.getColumnNo() == 3 ? 13 
								: input.getColumnNo() == 4 ? 14 
								: input.getColumnNo() == 5 ? 15 
								: input.getColumnNo() == 8 ? 18 : input.getColumnNo());
		}
		String uname = null;
		 if(input.getUserName()!=null && !input.getUserName().equals("")){ 
			 uname="%"+input.getUserName().trim().toUpperCase()+"%";
		 }
		 if(input.getStDate() == null || input.getStDate().trim().equals("")) {
		    input.setStDate(null);
		 }
		 if(input.getEnDate() == null || input.getEnDate().trim().equals("")){ 
			 input.setEnDate(null);
		 }
		 String status=null;
		 if(input.getStatus()!=null && !input.getStatus().equals("")){ 
		   status="%"+input.getStatus().trim().toUpperCase()+"%";
		 }
		 String email = null;
		 if(input.getEmail()!=null && !input.getEmail().equals("")) {
		    email="%"+input.getEmail().trim().toUpperCase()+"%";
		 }  
		 if(input.getColumnNo()==0) {
			   input.setColumnNo(8);
		 }
	
		List<LtMastUsers> list = (List<LtMastUsers>) 
				jdbcTemplate.query(query , new Object[]{uname,input.getStDate(),input.getEnDate(),
						   status,email,
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							(input.getStart()+input.getLength()),(input.getStart()+1)},
			 new  BeanPropertyRowMapper<LtMastUsers>(LtMastUsers.class));
			return list;
		
	}
	@Override
	  public List<LtMastUsers> findByActiveLikeUserName(String userName){
			String sqlQuery = env.getProperty("findByLikeActiveUserName");
			List<LtMastUsers> list=   jdbcTemplate.query(sqlQuery, new Object[]{ "%"+userName.toUpperCase()+"%" }, 
					 new BeanPropertyRowMapper<LtMastUsers>(LtMastUsers.class)); 
			return list;
			
		}

	  @Override
	  public LtMastUsers getLtMastUsersByID(Long id) {
		  String sqlQuery = env.getProperty("get_user_details_by_id");
		  LtMastUsers user =  jdbcTemplate.queryForObject(sqlQuery, new Object[]{ id}, 
					 new BeanPropertyRowMapper<LtMastUsers>(LtMastUsers.class)); 
			return user;
	  }

	

	


	@Override
	public List<LtMastUsers> findVendorByUserName(String userName) {
		
		//String query = env.getProperty("getAllLtMastCompany");
		String query = " SELECT mu.*, em.DIVISION_ID," + 
				" VENDOR_NAME as employee_name  " + 
				" FROM LT_MAST_USERS mu,LT_MAST_VENDORS em  " + 
				" WHERE upper(USER_NAME) = ? " + 
				" AND mu.VENDOR_ID = em.VENDOR_ID(+)   ";
		List<LtMastUsers> list = (List<LtMastUsers>) 
				jdbcTemplate.query(query , new Object[]{userName.toUpperCase() },
			 new  BeanPropertyRowMapper<LtMastUsers>(LtMastUsers.class));
		return list;
	}

	@Override
	public List<LtMastUsers> findActiveLikeEmail(String email) throws Exception {
		String sqlQuery = env.getProperty("findActiveLikeEmail");
		 
			List<LtMastUsers> list=  jdbcTemplate.query(sqlQuery, new Object[]{ email}, 
			 new BeanPropertyRowMapper<LtMastUsers>(LtMastUsers.class)); 
			return list;
	}

	@Override
	public boolean updateUser(Long vendorId) throws ServiceException {
		
		//String query = "UPDATE LT_MAST_USERS SET STATUS = 'INACTIVE', END_DATE = ? WHERE VENDOR_ID = ? ";
		String query = "DELETE FROM  LT_MAST_USERS  WHERE VENDOR_ID = ? ";
		int res= 0;
		res = jdbcTemplate.update(query,vendorId);
		
		if(res!=0)
			return true;
		else
			return false;
		
	}
	  
	  
	
 
}
