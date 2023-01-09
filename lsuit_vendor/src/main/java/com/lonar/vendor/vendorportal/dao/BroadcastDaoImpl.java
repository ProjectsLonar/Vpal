package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.StatusCodeName;

@Repository
public class BroadcastDaoImpl implements BroadcastDao{
	
	private JdbcTemplate jdbcTemplate;
	
	private JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<String> getMailIdByStatus(String status) throws ServiceException {
		String query = "select PRIMARY_EMAIL from LT_MAST_VENDORS where STATUS like ? ";
		List<String>list=jdbcTemplate.queryForList(query, new Object[] { status} ,String.class);
		 return list;
	}

	@Override
	public List<StatusCodeName> getAllStatus() throws ServiceException {
		String query = "select DISTINCT cmv.value_name as statusName , v.status as statusCode "
		+" from LT_MAST_VENDORS v,LT_MAST_COMN_MASTER_VALUES cmv "
		+" where v.status = cmv.value_code(+)";
		
		List<StatusCodeName> list = jdbcTemplate.query(query, 
				 new BeanPropertyRowMapper<StatusCodeName>(StatusCodeName.class)); 
		
		
		 return list;
	}

	@Override
	public List<String> getAllMailId() throws ServiceException {
		String query = "select PRIMARY_EMAIL from LT_MAST_VENDORS";
		List<String>list=jdbcTemplate.queryForList(query ,String.class);
		 return list;
	}
}
