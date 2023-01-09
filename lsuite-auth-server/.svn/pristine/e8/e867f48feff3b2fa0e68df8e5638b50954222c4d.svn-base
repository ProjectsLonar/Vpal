package com.lonar.UserManagement.web.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.lonar.UserManagement.web.model.LtMastUserRoles;
import com.lonar.UserManagement.web.model.Status;
import com.lonar.UserManagement.web.model.UserMolule;
import com.lonar.UserManagement.web.model.UserRoleWithRoleName;
import com.lonar.UserManagement.web.repository.LtMastUserRolesRepository;

@Component
@PropertySource(value = "classpath:queries/userRolesQueries.properties", ignoreResourceNotFound = true)
public class LtMastUserRolesDaoImpl implements LtMastUserRolesDao{

	@Autowired
	LtMastUserRolesRepository ltMastUserRolesRepository;
	
	@PersistenceContext(name = "em")
	private EntityManager em;
	
   private JdbcTemplate jdbcTemplate;
   
   @Autowired
   private Environment env;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/*@Override
	public List<LtMastUserRoles> findByUserIdAndRoleId(Long userID, Long roleID) throws Exception {
		   String sqlQuery = env.getProperty("findByUserIdAndRoleId");
		   return jdbcTemplate.query(sqlQuery, new Object[]{userID,roleID}, new RowMapper<LtMastUserRoles>(){
			@Override
			public LtMastUserRoles mapRow(ResultSet rs, int row)
					throws SQLException {
					LtMastUserRoles roles=new LtMastUserRoles();
					roles.setRoleId(rs.getLong("ROLE_ID"));
					roles.setUserRoleId(rs.getLong("USER_ROLE_ID"));
					roles.setUserId(rs.getLong("USER_ID"));
					return roles;
				}
		   });
	}
*/
	@Override
	public List<LtMastUserRoles> findByUserId(Long userID) throws Exception{
		String query = env.getProperty("getByUserIdRoles");
		List<LtMastUserRoles> list=   jdbcTemplate.query(query, new Object[]{ userID}, 
				 new BeanPropertyRowMapper<LtMastUserRoles>(LtMastUserRoles.class)); 
				return list;
	}


	@Override
	public List<UserMolule> findByUserIdGetRoleName(Long userId) throws Exception{
		return null; 
	}

	
	@Override
	public List<LtMastUserRoles> findAllActive() throws Exception{
		String query = env.getProperty("getByUserIdRoles");
		List<LtMastUserRoles> list=   jdbcTemplate.query(query, new Object[]{ }, 
				 new BeanPropertyRowMapper<LtMastUserRoles>(LtMastUserRoles.class)); 
				return list;
	}

	/*@Override
	public List<LtMastUserRoles> findByUserIdWithList(Long userID) throws Exception{
		String sqlQuery = env.getProperty("findByUserIdWithList");
		   return jdbcTemplate.query(sqlQuery,new Object[]{userID}, new RowMapper<LtMastUserRoles>() {
			@Override
			public LtMastUserRoles mapRow(ResultSet rs, int row)
					throws SQLException {
					LtMastUserRoles roles=new LtMastUserRoles();
					roles.setUserId(rs.getLong("USER_ID"));
					roles.setUserRoleId(rs.getLong("USER_ROLE_ID"));
					return roles;
				}
	
			}); 
	}*/

	
	
	@Override
	public List<UserRoleWithRoleName> findListWithRoleNameModuleName(Long userId) throws Exception{
		// TODO Auto-generated method stub
		return em.createNamedQuery("LtMastUserRoles.findListWithRoleNameModuleName").setParameter("userId", userId).getResultList();
	}

	@Override
	public List<LtMastUserRoles> findByRoleId(Long roleId) throws Exception{
		// TODO Auto-generated method stub
		return em.createNamedQuery("LtMastUserRoles.findByRoleId").setParameter("roleId", roleId).getResultList();
	}

	@Override
	public List<String> findAllActiveRoleName(Long userID) throws Exception{
		
		String sqlQuery = env.getProperty("findAllActiveRoleName");
		
		   return jdbcTemplate.query(sqlQuery,new Object[]{userID}, new RowMapper<String>() {
			@Override
			public String mapRow(ResultSet rs, int row) throws SQLException {
				return rs.getString(1);
				}
	
			});
	
	}

	@Transactional
	@Override
	public List<LtMastUserRoles> getByUserId(Long userId) throws Exception 
	{
		String sqlQuery = env.getProperty("getByUserIdRoles");
		
		List<LtMastUserRoles> list=   jdbcTemplate.query(sqlQuery, new Object[]{  userId }, 
				 new BeanPropertyRowMapper<LtMastUserRoles>(LtMastUserRoles.class)); 
		 
		if(!list.isEmpty())
		{
			for(LtMastUserRoles ltMastUserRoles:list)
			{
				ltMastUserRoles.getRoleId();
				ltMastUserRoles.getUserRoleId();
				ltMastUserRoles.getStartDate();
				ltMastUserRoles.getEndDate();
			}
			
		}
		return list ;
	}

	@Override
	public List<LtMastUserRoles> findByUserIdAndRoleId(Long userID, Long roleID) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LtMastUserRoles> findByUserIdWithList(Long userID) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
	// NEW API
	@Override
	public Status saveUserRole(LtMastUserRoles userRole) {
		Status status = new Status();
		try {
			userRole.setLastUpdateDate(new Date());
			userRole.setCreationDate(new Date());
			LtMastUserRoles usersRoles = ltMastUserRolesRepository.save(userRole);
			   status.setCode(200);
			   status.setData(usersRoles.getUserRoleId());
			   status.setMessage("Data inserted successfully");
		}catch(Exception e) {
			e.printStackTrace();
			status.setMessage("User role creation fail");
		}
		   return status;
	}

	@Override
	public List<LtMastUserRoles> getRoleByUserId(Long userId) throws Exception {
		String query = "select ur.*, rol.ROLE_DESC, rol.ROLE_NAME \r\n" + 
				" from LT_MAST_USER_ROLES ur, LT_MAST_ROLES rol\r\n" + 
				" Where ur.ROLE_ID = rol.ROLE_ID\r\n" + 
				" AND ur.USER_ID = ? ";
		
		List<LtMastUserRoles> list=   jdbcTemplate.query(query, new Object[]{  userId }, 
				 new BeanPropertyRowMapper<LtMastUserRoles>(LtMastUserRoles.class)); 
		
		
		return list;
	}

	@Override
	public Status updateUserRole(LtMastUserRoles userRole) throws Exception {
		Status status = new Status();
		try {
			userRole.setLastUpdateDate(new Date());
			userRole.setCreationDate(new Date());
			LtMastUserRoles usersRoles = ltMastUserRolesRepository.save(userRole);
			   status.setCode(200);
			   status.setData(usersRoles.getUserRoleId());
			   status.setMessage("Data updated successfully");
		}catch(Exception e) {
			e.printStackTrace();
			status.setMessage("User role updation fail");
		}
		   return status;
	}

	@Override
	public LtMastUserRoles getUserRoleById(Long userId) throws Exception {
		String query = " select ur.*, rol.ROLE_DESC, rol.ROLE_NAME  " + 
				" from LT_MAST_USER_ROLES ur, LT_MAST_ROLES rol " + 
				" Where ur.ROLE_ID = rol.ROLE_ID " + 
				" AND ur.USER_ROLE_ID = ? ";
		
		List<LtMastUserRoles> list=   jdbcTemplate.query(query, new Object[]{  userId }, 
				 new BeanPropertyRowMapper<LtMastUserRoles>(LtMastUserRoles.class)); 
		if(!list.isEmpty())
		return list.get(0);
		else
			return null;
	}

	@Override
	public boolean chkDuplicate(LtMastUserRoles userRole) throws Exception {
		String query = env.getProperty("chkforDuplicateRoleForUser");
		List<LtMastUserRoles> list=   jdbcTemplate.query(query, new Object[]{ userRole.getUserId(),userRole.getRoleId()}, 
				 new BeanPropertyRowMapper<LtMastUserRoles>(LtMastUserRoles.class)); 
		if(list.isEmpty())
				return true;
		else
			return false;
	}
}
