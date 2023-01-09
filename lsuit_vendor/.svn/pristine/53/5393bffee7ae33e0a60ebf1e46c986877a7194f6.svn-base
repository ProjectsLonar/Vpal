package com.lonar.vendor.vendorportal.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.lonar.vendor.vendorportal.model.LtMastRoleModules;

@Repository
public class LtMastRoleModulesDaoImpl implements LtMastRoleModulesDao{

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
	public List<LtMastRoleModules> findByRoleIdANDModuleId(Long roleId, Long moduleId) {
		 String sqlQuery = " SELECT * FROM lt_mast_role_modules lm WHERE lm.ROLE_ID=? and lm.MODULE_ID=? ";
		 
			return jdbcTemplate.query(sqlQuery,new Object[]{roleId,moduleId}, new RowMapper<LtMastRoleModules>(){
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

}
