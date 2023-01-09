package com.lonar.UserManagement.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lonar.UserManagement.common.BusinessException;
import com.lonar.UserManagement.web.model.AuthTokenInfo;
import com.lonar.UserManagement.web.model.CodeMaster;
import com.lonar.UserManagement.web.model.LtMastUsers;
import com.lonar.UserManagement.web.model.Status;


@Repository("userDao")
public class UserDaoImpl implements UserDao ,CodeMaster{

	@PersistenceContext(name = "em")
	private EntityManager em;
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) throws BusinessException{
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	} 
	
	private JdbcTemplate getJdbcTemplate() throws BusinessException{
		return jdbcTemplate;
	}
	
	Map<Long, LtMastUsers> userMap = new HashMap<>();
	
	@Override
	public LtMastUsers getUserById(Long id) throws BusinessException{
		String query = " SELECT * FROM LT_MAST_USERS WHERE USER_ID = ? ";
		List<LtMastUsers> users =   jdbcTemplate.query(query , new Object[]{id }, 
				new  BeanPropertyRowMapper<LtMastUsers>(LtMastUsers.class));
		if(users.size() > 0) {
			return users.get(0);	
		}
		return null;
	}

	@Override
	public Long addNewUser(LtMastUsers user) throws BusinessException{
		userMap.put(user.getUserId(), user);
		return user.getUserId();
	}

	@Override
	public Long removeUser(Long userId) throws BusinessException{
		userMap.remove(userId);
		return userId;
	}
	
	@Override
	public List<LtMastUsers> getUserList() throws BusinessException{
		String query = " SELECT * FROM LT_MAST_USERS";
		List<LtMastUsers> users =   jdbcTemplate.query(query , 
				new  BeanPropertyRowMapper<LtMastUsers>(LtMastUsers.class));
		return users;
	}

	@Override
	@Transactional
	public LtMastUsers findByUserName(String username) throws BusinessException{
		String query = " SELECT * FROM LT_MAST_USERS WHERE upper(USER_NAME) = ? ";
		List<LtMastUsers> users =   jdbcTemplate.query(query , new Object[]{username.toUpperCase() }, 
				new  BeanPropertyRowMapper<LtMastUsers>(LtMastUsers.class));
		if(users.size() > 0) {
			return users.get(0);	
		}
		return null;
	}

	@Override
	@Transactional
	public void saveLoginToken(AuthTokenInfo tokenInfo) {
		try {
		jdbcTemplate.update("delete from my_token_details where refresh_token = ? ", 
				new Object[] {tokenInfo.getRefresh_token()});
		
		String query = " insert into my_token_details " + 
				"	(access_token , refresh_token , access_token_date, refresh_token_date, access_token_expire_in) " + 
				"	values ( ?, ?, sysdate , sysdate , ? ) ";
		
		jdbcTemplate.update(query, new Object[]{ tokenInfo.getAccess_token(), tokenInfo.getRefresh_token(),
				 tokenInfo.getExpires_in() } );
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	@Transactional
	public void updateLoginToken(AuthTokenInfo tokenInfo, String token) throws BusinessException{
		String query = " update my_token_details " + 
				" set access_token = ? , " + 
				" old_access_token = ?, access_token_date = sysdate " + 
				" where refresh_token  = ?  ";
		jdbcTemplate.update(query, new Object[]{ tokenInfo.getAccess_token(), token,  tokenInfo.getRefresh_token() } );
	}
	

	@Override
	@Transactional
	public AuthTokenInfo getTokenTimeDifferance(String accessToken) throws BusinessException{
		String query = "Select (sysdate - access_token_date)*60*60*24 as differance_time, refresh_token from my_token_details where access_token = ? ";
		//String query = "Select timestampdiff(second, access_token_date, ? ) as differance_time, refresh_token from my_token_details where access_token = ? "; 
		List<AuthTokenInfo>  infos = jdbcTemplate.query(query, new Object[]{ accessToken }, new RowMapper(){
		  		@Override
		  		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		  			AuthTokenInfo info = new AuthTokenInfo();
		  			info.setRefresh_token(rs.getString("refresh_token"));
		  			info.setExpires_in(rs.getInt("differance_time"));
		  			return info;
		  		}
		  });
		if(infos.size() > 0) {
			return infos.get(0);
		}
		return null;  
	}

	@Override
	@Transactional
	public AuthTokenInfo getOldTokenTimeDifferance(String oldToken) throws BusinessException{
		String query = "Select (sysdate - access_token_date)*60*60*24 as differance_time, access_token from my_token_details where old_access_token = ?";
		//String query = "Select timestampdiff(second, access_token_date, ? ) as differance_time, access_token from my_token_details where old_access_token = ? "; 
		List<AuthTokenInfo>  infos = jdbcTemplate.query(query, new Object[]{ oldToken }, new RowMapper(){
		  		@Override
		  		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		  			AuthTokenInfo info = new AuthTokenInfo();
		  			info.setAccess_token(rs.getString("access_token"));
		  			info.setExpires_in(rs.getInt("differance_time"));
		  			return info;
		  		}
		  });
		if(infos.size() > 0) {
			return infos.get(0);
		}
		return null;  
	}

	@Override
	public List<LtMastUsers> findByUserNameAndEmailId(String userName, String emailId) throws BusinessException {
		String query = " SELECT * FROM LT_MAST_USERS l WHERE upper(l.USER_NAME) = ? " + 
				" AND upper(l.EMAIL)= ? AND l.START_DATE <=SYSDATE AND ( l.END_DATE IS NULL OR l.END_DATE >= SYSDATE ) ";
		List<LtMastUsers> users =   jdbcTemplate.query(query , new Object[]{userName.toUpperCase(),emailId.toUpperCase() }, 
				new  BeanPropertyRowMapper<LtMastUsers>(LtMastUsers.class));
		return users;
	}

	@Override
	public boolean changePasswordUtility(Long userId, String password) throws BusinessException {
		String query = " update LT_MAST_USERS " + 
				" set PASSWORD = ? , " + 
				" STATUS = ?, LAST_UPDATE_DATE = sysdate " + 
				" where USER_ID  = ?  ";
		int res = jdbcTemplate.update(query, new Object[]{ password, "ACTIVE",  userId } );
		if(res!=0) {
			return true;
		}else
			return false;
	}

	@Override
	public void setPackageVariables(Long userId,Long companyId) throws BusinessException {
		Status status = new Status();
	//	ProcedureCall procedureCall= new ProcedureCall();
			StoredProcedureQuery query = em
				    .createStoredProcedureQuery("LT_VPAL_COMMON_PKG.set_global_variables")
				    .registerStoredProcedureParameter(1, Long.class, 
					         ParameterMode.IN)
				    .registerStoredProcedureParameter(2, Long.class, 
					         ParameterMode.IN)
				    .registerStoredProcedureParameter(3, String.class, 
				         ParameterMode.OUT)
			        .registerStoredProcedureParameter(4, String.class, 
			         ParameterMode.OUT)
				    .setParameter(1, userId)
				    .setParameter(2, companyId);
				query.execute();

				if(query.getOutputParameterValue(3).toString().trim().equals("ERROR")){
					status.setCode(FAIL);
				}
				else if(query.getOutputParameterValue(3).toString().trim().equals("SUCCESS")){
					status.setCode(SUCCESS);
					if(query.getOutputParameterValue(4)!=null) {
					status.setMessage(query.getOutputParameterValue(4).toString());
					}
					
				}
				
	}
	
}
