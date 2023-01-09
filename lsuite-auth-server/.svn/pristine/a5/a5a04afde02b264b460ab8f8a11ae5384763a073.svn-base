package com.lonar.UserManagement.web.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.lonar.UserManagement.web.model.LtMastPasswords;

@Component
public class LtMastPasswordsDaoImpl implements LtMastPasswordsDao{

	//@PersistenceContext(name = "em")
	//private EntityManager em;
	
	@Autowired
	private Environment env;
	
	@PersistenceContext(name = "em")
	private EntityManager em;

	private JdbcTemplate jdbcTemplate;

	private JdbcTemplate getJdbcTemplate() {
		// TODO Auto-generated method stub
		return jdbcTemplate;
	}
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}


	@Override
	public List<LtMastPasswords> findByUserId(Long userID) throws Exception {
		String query=" SELECT * FROM LT_MAST_PASSWORDS l WHERE l.USER_ID = ? ";
		List<LtMastPasswords> list=  jdbcTemplate.query(query, new Object[]{userID}, 
		 new BeanPropertyRowMapper<LtMastPasswords>(LtMastPasswords.class)); 
		return list;
	}

	@Override
	public List<LtMastPasswords> findByUserIdAndPassword(Long userID,
			String password) throws Exception {
		String query=" SELECT * FROM LT_MAST_PASSWORDS l WHERE l.PASSWORD = ? AND l.USER_ID= ?  ";
		List<LtMastPasswords> list=  jdbcTemplate.query(query, new Object[]{userID,"%"+password+"%" }, 
		 new BeanPropertyRowMapper<LtMastPasswords>(LtMastPasswords.class)); 
		return list;
	}

	@Override
	public List<LtMastPasswords> findAllActive() throws Exception {
		String query=" SELECT * FROM LT_MAST_BRANCHES l WHERE  (l.status = 'Active' OR l.status = 'ACTIVE') " 
        +"  AND l.START_DATE <= SYSDATE AND (l.END_DATE IS NULL OR l.endDate >= SYSDATE)";
		List<LtMastPasswords> list=   jdbcTemplate.query(query, new Object[]{ }, 
				 new BeanPropertyRowMapper<LtMastPasswords>(LtMastPasswords.class)); 
		return list;
	}

	

	
	}
