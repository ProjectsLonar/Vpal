package com.lonar.UserManagement.web.dao;

import java.rmi.ServerException;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import org.springframework.stereotype.Component;

import com.lonar.UserManagement.web.model.LtMastRoles;

@Component
@PropertySource(value = "classpath:queries/roleMasterQueries.properties", ignoreResourceNotFound = true)
public class LtMastRolesDaoImpl implements LtMastRolesDao {

	@PersistenceContext(name = "em")
	private EntityManager em;
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private Environment env;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private JdbcTemplate getJdbcTemplate() {
		// TODO Auto-generated method stub
		return jdbcTemplate;
	}
	
	@Override
	public List<LtMastRoles> findByRole(String rolename,Long companyId) throws ServerException {
		
		    String sqlQuery = env.getProperty("findByRole");
		   return jdbcTemplate.query(sqlQuery, new Object[]{ rolename.toUpperCase(),companyId}, new RowMapper<LtMastRoles>(){
			@Override
			public LtMastRoles mapRow(ResultSet rs, int row)
					throws SQLException {
					LtMastRoles roles=new LtMastRoles();
					roles.setRoleId(rs.getLong("ROLE_ID"));
					roles.setRoleName(rs.getNString("ROLE_NAME"));
					roles.setRoleDesc(rs.getString("ROLE_DESC"));
					return roles;
				}
				
		   });
		
	}

	@Override
	public List<LtMastRoles> findAllActive(Long companyId) throws ServerException {
		 String sqlQuery = env.getProperty("findAllActive");
		   return jdbcTemplate.query(sqlQuery,  new Object[]{ companyId},new RowMapper<LtMastRoles>(){
			@Override
			public LtMastRoles mapRow(ResultSet rs, int row)
					throws SQLException {
					LtMastRoles roles=new LtMastRoles();
					roles.setRoleId(rs.getLong("ROLE_ID"));
					roles.setRoleName(rs.getNString("ROLE_NAME"));
					roles.setRoleDesc(rs.getString("ROLE_DESC"));
					return roles;
				}
				
		   });
	}


	@Override
	public List<LtMastRoles> findInRoleId(List<Long> roleID) throws ServerException {
		return null;
	}

	
	
	@Override
	public List<LtMastRoles> findByActiveLikeRoleName(String roleName,Long companyId)
			throws ServerException {
		
		   String sqlQuery = env.getProperty("findByActiveLikeRoleName");
		   return jdbcTemplate.query(sqlQuery,  new Object[]{ "%"+roleName.toLowerCase()+"%",companyId},new RowMapper<LtMastRoles>(){
			@Override
			public LtMastRoles mapRow(ResultSet rs, int row)
					throws SQLException {
					LtMastRoles roles=new LtMastRoles();
					roles.setRoleId(rs.getLong("ROLE_ID"));
					roles.setRoleName(rs.getNString("ROLE_NAME"));
					roles.setRoleDesc(rs.getString("ROLE_DESC"));
					return roles;
				}
				
		   });
	}

	
	
	@Override
	public List<LtMastRoles> findByLikeRoleName(String roleName,Long companyId)
			throws ServerException {
		   String sqlQuery = env.getProperty("findByLikeRoleName");
		  //String sqlQuery="SELECT ROLE_ID,ROLE_NAME,ROLE_DESC FROM lt_mast_roles r WHERE LOWER(r.ROLE_NAME) like ? ";
		   return jdbcTemplate.query(sqlQuery, new Object[]{ "%"+roleName.toLowerCase()+"%",companyId},new RowMapper<LtMastRoles>(){
			@Override
			public LtMastRoles mapRow(ResultSet rs, int row)
					throws SQLException {
					LtMastRoles roles=new LtMastRoles();
					roles.setRoleId(rs.getLong("ROLE_ID"));
					roles.setRoleName(rs.getString("ROLE_NAME"));
					roles.setRoleDesc(rs.getString("ROLE_DESC"));
					
					return roles;
				}
				
		   });
	}

	@Override
	public Long getLtMastRolesCount(LtMastRoles input,Long companyId)  {
		String query = env.getProperty("getLtMastRolesCount");
		
		String name=null;
		if(input.getRoleName()!= null && !input.getRoleName().equals(""))
		{name = "%"+input.getRoleName().trim().toUpperCase()+"%" ;}
		
		String desc=null;
		if(input.getRoleDesc()!= null && !input.getRoleDesc().equals(""))
		{desc = "%"+input.getRoleDesc().trim().toUpperCase()+"%" ;}
		
		
		String status=null;
		if(input.getStatus()!= null && !input.getStatus().equals(""))
		{status = "%"+input.getStatus().toUpperCase().trim()+"%" ;}
		
		if(input.getStrStartDate() == null || input.getStrStartDate().trim().equals(""))
		{input.setStrStartDate(null);}
		   
		if(input.getStrEndDate() == null || input.getStrEndDate().trim().equals(""))
		{input.setStrEndDate(null);}
		   
		String count  = (String)getJdbcTemplate().queryForObject(
				query, new Object[] {companyId,name,desc,status,input.getStrStartDate() ,input.getStrEndDate() }, String.class);

		
		return Long.parseLong(count);
	}

	@Override
	public List<LtMastRoles> getLtMastRolesDataTable(LtMastRoles input,Long companyId) {
		if(input.getSort()==null) {
			input.setSort("desc");
		}
		if(input.getColumnNo()==null )
		{
			input.setColumnNo(0);
		}
		
		if(input.getColumnNo()==2 && input.getSort().equals("desc"))
		{
			input.setColumnNo(12);
		}
		if(input.getColumnNo()==3 && input.getSort().equals("desc"))
		{
			input.setColumnNo(13);
		}
		if(input.getColumnNo()==4 && input.getSort().equals("desc"))
		{
			input.setColumnNo(14);
		}
		if(input.getColumnNo()==5 && input.getSort().equals("desc"))
		{
			input.setColumnNo(15);
		}
		if(input.getColumnNo()==6 && input.getSort().equals("desc"))
		{
			input.setColumnNo(16);
		}
		
		String name=null;
		if(input.getRoleName()!= null && !input.getRoleName().equals(""))
		{name = "%"+input.getRoleName().trim().toUpperCase()+"%" ;}
		
		String desc=null;
		if(input.getRoleDesc()!= null && !input.getRoleDesc().equals(""))
		{desc = "%"+input.getRoleDesc().trim().toUpperCase()+"%" ;}
		
		
		String status=null;
		if(input.getStatus()!= null && !input.getStatus().equals(""))
		{status = "%"+input.getStatus().toUpperCase().trim()+"%" ;}
		
		if(input.getStrStartDate() == null || input.getStrStartDate().trim().equals(""))
		{input.setStrStartDate(null);}
		   
		if(input.getStrEndDate() == null || input.getStrEndDate().trim().equals(""))
		{input.setStrEndDate(null);}
		   
		   
		if(input.getColumnNo()==0)	
		{
			input.setColumnNo(7);
		}
			String query = env.getProperty("getLtMastRolesDataTable");
			
			return (List<LtMastRoles>) 
					jdbcTemplate.query(query , new Object[]{companyId,name,desc,status,input.getStrStartDate() ,
							input.getStrEndDate(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							
							input.getLength() + input.getStart(),input.getStart()+1
							},
				 new  BeanPropertyRowMapper<LtMastRoles>(LtMastRoles.class));
	}

	@Override
	public LtMastRoles getRolesByID(Long id) throws ServerException {
		String query = env.getProperty("getLtMastRolesByID");
		List<LtMastRoles> list=   jdbcTemplate.query(query, new Object[]{ id}, 
				 new BeanPropertyRowMapper<LtMastRoles>(LtMastRoles.class)); 
		if(list.isEmpty())
			return null;
		else
				return list.get(0);
	}

	@Override
	public List<LtMastRoles> findAll(Long companyId) throws ServerException {
		 String sqlQuery = env.getProperty("findAll");
		   return jdbcTemplate.query(sqlQuery,  new Object[]{ companyId},new RowMapper<LtMastRoles>(){
			@Override
			public LtMastRoles mapRow(ResultSet rs, int row)
					throws SQLException {
					LtMastRoles roles=new LtMastRoles();
					roles.setRoleId(rs.getLong("ROLE_ID"));
					roles.setRoleName(rs.getNString("ROLE_NAME"));
					roles.setRoleDesc(rs.getString("ROLE_DESC"));
					return roles;
				}
				
		   });
	}
	
	
	
	
}
