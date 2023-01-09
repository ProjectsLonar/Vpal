package com.lonar.UserManagement.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.lonar.UserManagement.common.BusinessException;
import com.lonar.UserManagement.web.model.LtMastRoleModules;
import com.lonar.UserManagement.web.model.Menu;
import com.lonar.UserManagement.web.model.ModuleList;
import com.lonar.UserManagement.web.model.RoleModule;

@Component
@PropertySource(value = "classpath:queries/roleModuleMasterQueries.properties", ignoreResourceNotFound = true)
public class LtMastRoleModulesDaoImpl implements LtMastRoleModulesDao{

	@PersistenceContext(name = "em")
	private EntityManager em;
	
	
   private JdbcTemplate jdbcTemplate;
   
   @Autowired
   private Environment env;

	@Autowired
	DataSource dataSource;
  
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public LtMastRoleModulesDaoImpl( DataSource dataSource ) {
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource) ;
	}

   //private NamedParameterJdbcTemplate namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(jdbcTemplate.getDataSource());
	private JdbcTemplate getJdbcTemplate() {
		// TODO Auto-generated method stub
		return jdbcTemplate;
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<LtMastRoleModules> findByRoleIdANDModuleId(Long roleID,Long moduleID) throws BusinessException 
	{
			 String sqlQuery = env.getProperty("findRoleModulesByRoleIdANDModuleId");
			 
			return jdbcTemplate.query(sqlQuery,new Object[]{roleID,moduleID}, new RowMapper<LtMastRoleModules>(){
				@Override
				public LtMastRoleModules mapRow(ResultSet rs, int row)
						throws SQLException {
						LtMastRoleModules roleModules=new LtMastRoleModules();
						roleModules.setRoleFuncId(rs.getLong("ROLE_FUNC_ID"));
						roleModules.setRoleId(rs.getLong("ROLE_ID"));
						roleModules.setModuleId(rs.getLong("MODULE_ID"));
						return roleModules;
					}
					
			   });
				
	}

	@Override
	public List<Long> findByRoleIdOutputModuleID(Long roleID) throws BusinessException {
		return null;
	}

	@Override
	public List<LtMastRoleModules> findByUserIdANDRoleId(List<Long> roleId,
			List<Long> moduleId) throws BusinessException {
		return null;
	}

	@Override
	public List<LtMastRoleModules> findInRoleIdAndModuleIdWithInDate(
			List<Long> roleId, List<Long> moduleId) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List findByRoleIdWithUserId() throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Menu> findMenu(Long userId) throws BusinessException {
		
		 String sqlQuery = env.getProperty("findMenu");
		
		   return jdbcTemplate.query(sqlQuery,new Object[]{userId}, new RowMapper<Menu>(){
			@Override
			public Menu mapRow(ResultSet rs, int row)
					throws SQLException {
					Menu menu=new Menu();
					menu.setModuleId(rs.getLong("MODULE_ID"));
					menu.setModuleName(rs.getString("MODULE_NAME"));
					menu.setModuleCode(rs.getString("MODULE_CODE"));
					menu.setModuleUrl(rs.getString("MODULE_URL"));
					menu.setModuleGroup(rs.getString("MODULE_GROUP"));
					menu.setCreate(rs.getString("CREATE_FLAG"));
					menu.setRead(rs.getString("READ_FLAG"));
					menu.setEdit(rs.getString("EDIT_FLAG"));
					menu.setDelete(rs.getString("DELETE_FLAG"));
					return menu;
				}
				
		   });
	}

	@Override
	public List<Menu> findMenuWithModuleName(Long userId, String moduleName)
			throws BusinessException {
			String sqlQuery = env.getProperty("findMenuWithModuleName");
			//String sqlQuery="Select create_flag,edit_flag ,delete_flag,read_flag from lt_mast_role_modules lmrm,lt_mast_users lmu,lt_mast_modules lmm ,lt_mast_roles lmr,lt_mast_user_roles lmur where lmur.user_id=lmu.USER_ID AND lmrm.MODULE_ID=lmm.MODULE_ID AND lmr.ROLE_ID=lmrm.ROLE_ID AND lmm.MODULE_NAME= ? AND lmu.user_id=? ";
			return jdbcTemplate.query(sqlQuery,new Object[]{userId,moduleName}, new RowMapper<Menu>(){
			@Override
			public Menu mapRow(ResultSet rs, int row)
					throws SQLException {
					Menu menu=new Menu();
					menu.setCreate(rs.getString("CREATE_FLAG"));
					menu.setEdit(rs.getString("EDIT_FLAG"));
					menu.setRead(rs.getString("READ_FLAG"));
					menu.setDelete(rs.getString("DELETE_FLAG"));
					menu.setModuleId(rs.getLong("MODULE_ID"));
					return menu;
				}
				
		   });
	}

	@Override
	public List<LtMastRoleModules> findAllActive() throws BusinessException {
		 String sqlQuery = env.getProperty("findAllActive");
		//String sqlQuery="SELECT * FROM lt_mast_role_modules rm WHERE  UPPER(rm.status)='ACTIVE' ";
		   return jdbcTemplate.query(sqlQuery, new RowMapper<LtMastRoleModules>(){
			@Override
			public LtMastRoleModules mapRow(ResultSet rs, int row)
					throws SQLException {
					LtMastRoleModules roleModules=new LtMastRoleModules();
					roleModules.setRoleId(rs.getLong("ROLE_ID"));
					roleModules.setRoleFuncId(rs.getLong("ROLE_FUNC_ID"));
					roleModules.setModuleId(rs.getLong("MODULE_ID"));
					return roleModules;
				}
				
		   });
	}

	@Override
	public List<RoleModule> findByRoleIdGetModuleName(Long roleId)
			throws BusinessException {
		return null;
	}

	@Override
	public List<LtMastRoleModules> findByRoleId(Long roleId) throws BusinessException {
		 String sqlQuery = env.getProperty("findByRoleId");
		 List<LtMastRoleModules> list=   jdbcTemplate.query(sqlQuery, new Object[]{ roleId}, 
				 new BeanPropertyRowMapper<LtMastRoleModules>(LtMastRoleModules.class)); 
				return list;
		
	}

	@Override
	public List<ModuleList> getModuleListWithUserId(Long userId)
			throws BusinessException {
			return null;
	}

	@Override
    public List<ModuleList> getModuleListWithRoleId(List<Long> roleId)
                    throws BusinessException {
                Map<String, Object> params = new HashMap<>(); 
               params.put("roleId", roleId);
               String sqlQuery = env.getProperty("getModuleListWithRoleId");
               MapSqlParameterSource namedParameters = new MapSqlParameterSource();
               namedParameters.addValue("ROLE_ID", roleId);
              
               return namedParameterJdbcTemplate.query(sqlQuery, namedParameters,new RowMapper<ModuleList>() {
            		   
                    @Override                                                                       
                    public ModuleList mapRow(ResultSet rs, int row)
                                    throws SQLException {
                                    ModuleList roleModules=new ModuleList();
                                    roleModules.setRoleFuncId(rs.getLong("ROLE_FUNC_ID"));
                                    roleModules.setModuleId(rs.getLong("MODULE_ID"));
                                    return roleModules;
                                    
                            }
               });
              
    }

	@Override
	public List<LtMastRoleModules> getByModuleId(Long moduleId) throws BusinessException 
	{
		 String sqlQuery = env.getProperty("getLtMastRoleModulesByModuleId");
		 
			return jdbcTemplate.query(sqlQuery,new Object[]{moduleId}, new RowMapper<LtMastRoleModules>(){
				@Override
				public LtMastRoleModules mapRow(ResultSet rs, int row)
						throws SQLException {
						LtMastRoleModules roleModules=new LtMastRoleModules();
						roleModules.setRoleFuncId(rs.getLong("ROLE_FUNC_ID"));
						roleModules.setRoleId(rs.getLong("ROLE_ID"));
						roleModules.setModuleId(rs.getLong("MODULE_ID"));
						return roleModules;
					}
					
			   });
	}

	@Override
	public boolean checkForDuplicate(LtMastRoleModules ltMastRoleModules) throws BusinessException {
		 String sqlQuery = env.getProperty("checkForDuplicateModuleAgainstRole");
		 
		 List<LtMastRoleModules> list=   jdbcTemplate.query(sqlQuery, new Object[]{ ltMastRoleModules.getRoleId(),ltMastRoleModules.getModuleId()}, 
				 new BeanPropertyRowMapper<LtMastRoleModules>(LtMastRoleModules.class)); 
		 if(list.isEmpty())
			 return true;
		 else
				return false;
	}



	

	
}
