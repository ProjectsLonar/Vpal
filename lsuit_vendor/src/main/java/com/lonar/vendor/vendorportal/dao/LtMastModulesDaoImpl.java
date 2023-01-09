package com.lonar.vendor.vendorportal.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.lonar.vendor.vendorportal.model.LtMastModules;

@Repository
public class LtMastModulesDaoImpl implements LtMastModulesDao{

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
	public List<LtMastModules> findByModuleName(String moduleName) {
		 String sqlQuery = " SELECT MODULE_ID,MODULE_CODE,MODULE_NAME,MODULE_URL,SEQUENCE_NUMBER "
		 		+ " FROM Lt_Mast_Modules l WHERE UPPER(l.MODULE_NAME) like ? ";
	     return jdbcTemplate.query(sqlQuery,new Object[]{ "%"+moduleName.toUpperCase()+"%" }, 
				 new RowMapper<LtMastModules>(){
					@Override
					public LtMastModules mapRow(ResultSet rs, int row)
							throws SQLException {
						LtMastModules modules=new LtMastModules();
						modules.setModuleId(rs.getLong("MODULE_ID"));
						modules.setModuleName(rs.getString("MODULE_NAME"));
						return modules;
					}
		   
	   });
	}

}
