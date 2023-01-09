package com.lonar.vendor.vendorportal.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.lonar.vendor.vendorportal.model.LtMastRoles;

@Repository
public class LtMastRolesDaoImpl implements LtMastRolesDao {

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
	public List<LtMastRoles> findByRole(String rolename) {
		 String sqlQuery = " SELECT ROLE_ID,ROLE_NAME,ROLE_DESC FROM lt_mast_roles r WHERE UPPER(r.ROLE_NAME) like ? ";
		   return jdbcTemplate.query(sqlQuery, new Object[]{ "%"+rolename.toUpperCase()+"%"}, new RowMapper<LtMastRoles>(){
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
	public List<LtMastRoles> findRoleByCompany(String rolename, Long companyId) {
		 String sqlQuery = " SELECT ROLE_ID,ROLE_NAME,ROLE_DESC FROM lt_mast_roles r "
		 		+ " WHERE UPPER(r.ROLE_NAME) like ? AND r.COMPANY_ID = ?  ";
		   return jdbcTemplate.query(sqlQuery, new Object[]{ "%"+rolename.toUpperCase()+"%",companyId}, new RowMapper<LtMastRoles>(){
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
