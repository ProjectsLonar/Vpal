package com.lonar.UserManagement.web.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.lonar.UserManagement.web.model.LtMastComnMasterValues;

@Component
@PropertySource(value = "classpath:queries/commonMasterQueries.properties", ignoreResourceNotFound = true)
public class LtMastComnMasterValuesDaoImpl implements LtMastComnMasterValuesDao
{
	@Autowired
	private Environment env;
	
	@PersistenceContext(name = "em")
	private EntityManager em;

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource)
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	@Override
	public List<LtMastComnMasterValues> findByValueCode(String valueCode) throws Exception{
		String query = env.getProperty("findByValueCode");
	
		
		List<LtMastComnMasterValues> list=   jdbcTemplate.query(query, new Object[]{"%"+valueCode+"%" }, 
		 new BeanPropertyRowMapper<LtMastComnMasterValues>(LtMastComnMasterValues.class)); 
		return list;
	}

	@Override
	public List<LtMastComnMasterValues> findByValueName(String valueName) throws Exception{
		String query = env.getProperty("findByValueName");
	
		
		List<LtMastComnMasterValues> list=   jdbcTemplate.query(query, new Object[]{"%"+valueName.toUpperCase()+"%" }, 
		 new BeanPropertyRowMapper<LtMastComnMasterValues>(LtMastComnMasterValues.class)); 
		return list;
		
	}
	
	@Override
	public List<LtMastComnMasterValues> findAllActive() throws Exception{
		String query = env.getProperty("findAllActiveLtMastComnMasterValues");
		
		List<LtMastComnMasterValues> list=   jdbcTemplate.query(query, new Object[]{  }, 
				 new BeanPropertyRowMapper<LtMastComnMasterValues>(LtMastComnMasterValues.class)); 
		 
		return list;
	}

	@Transactional
	@Override
	public List<LtMastComnMasterValues> findByMasteridWithValuecode(Long masterId, String valueCode) throws Exception{
		String query = env.getProperty("findByMasteridWithValuecode");
		/*String query = " SELECT * FROM LT_MAST_COMN_MASTER_VALUES b  "
				+ " where (b.status = 'Active' OR b.status = 'ACTIVE') "
				+ " AND ( b.start_date <= SYSDATE "
				+ " AND (b.end_date is null or b.end_date > SYSDATE) ) "
				+ " AND (b.MASTER_ID = ? AND b.VALUE_CODE LIKE ? ) ";*/
				
		
		List<LtMastComnMasterValues> list=   jdbcTemplate.query(query, new Object[]{ masterId, "%"+valueCode+"%"  }, 
				 new BeanPropertyRowMapper<LtMastComnMasterValues>(LtMastComnMasterValues.class)); 
		return list;
	}

	@Transactional
	@Override
	public List<LtMastComnMasterValues> findByMasterId(Long masterId) throws Exception{
		String query = env.getProperty("findLtMastComnMasterValuesByMasterId");
		List<LtMastComnMasterValues> list=   jdbcTemplate.query(query, new Object[]{ masterId }, 
				 new BeanPropertyRowMapper<LtMastComnMasterValues>(LtMastComnMasterValues.class)); 
		
		return list;
	}

	@Transactional
	@Override
	public List<LtMastComnMasterValues> findLikeValueNameWithMasterId(Long masterId, String valueName) {
		String query = env.getProperty("findLikeValueNameWithMasterId");
	/*	String query = " SELECT * FROM LT_MAST_COMN_MASTER_VALUES b  "
				+ " where (b.status = 'Active' OR b.status = 'ACTIVE') "
				+ " AND ( b.start_date <= SYSDATE "
				+ " AND (b.end_date is null or b.end_date > SYSDATE) ) "
				+ " AND (b.MASTER_ID = ? AND b.VALUE_NAME LIKE ? ) ";*/
				
		
		List<LtMastComnMasterValues> list=   jdbcTemplate.query(query, new Object[]{ masterId, "%"+valueName+"%"  }, 
				 new BeanPropertyRowMapper<LtMastComnMasterValues>(LtMastComnMasterValues.class)); 
		 return list;
	}

	@Transactional
	@Override
	public List<LtMastComnMasterValues> findByMasteridWithValueTag(Long masterId, String valueTag) throws Exception {
		String query = env.getProperty("findByMasteridWithValueTag");
		/*String query = " SELECT * FROM LT_MAST_COMN_MASTER_VALUES b  "
				+ " where (b.status = 'Active' OR b.status = 'ACTIVE') "
				+ " AND ( b.start_date <= SYSDATE "
				+ " AND (b.end_date is null or b.end_date > SYSDATE) ) "
				+ " AND (b.MASTER_ID = ? AND b.VALUE_TAG LIKE ? ) ";*/
				
		
		List<LtMastComnMasterValues> list=   jdbcTemplate.query(query, new Object[]{ masterId, "%"+valueTag+"%"  }, 
				 new BeanPropertyRowMapper<LtMastComnMasterValues>(LtMastComnMasterValues.class)); 
		 return list;
	}

	@Transactional
	@Override
	public List<LtMastComnMasterValues> findByMasterNameWithValueCode(String masterName, String valueCode)
			throws Exception {
		
		return null;
	}

	@Transactional
	@Override
	public List<LtMastComnMasterValues> getByValueCode(String valueCode) throws Exception
	{
		
		if(valueCode!=null)
		{
			String query = env.getProperty("getByValueCode");
		/*String query = " SELECT c.VALUE_CODE, c.VALUE_NAME FROM LT_MAST_COMN_MASTER_VALUES c "
				+ " where  UPPER(c.VALUE_CODE) = ? ";*/
		
		List<LtMastComnMasterValues> list=   jdbcTemplate.query(query, new Object[]{ valueCode.toUpperCase() }, 
				 new BeanPropertyRowMapper<LtMastComnMasterValues>(LtMastComnMasterValues.class)); 
	
		return list;
		}
		else
			return null;
	}

	@Transactional
	@Override
	public List<LtMastComnMasterValues> checkCommonMasterValuesDetails(LtMastComnMasterValues ltMastComnMasterValues)
			throws Exception 
	{
		String query = env.getProperty("checkCommonMasterValuesDetails");
		
		List<LtMastComnMasterValues> list=   jdbcTemplate.query(query, new Object[]{ ltMastComnMasterValues.getValueCode() }, 
				 new BeanPropertyRowMapper<LtMastComnMasterValues>(LtMastComnMasterValues.class)); 
		return list;
	}


	@Override
	public List<LtMastComnMasterValues> findByCommanMasterName(String masterName) throws Exception {
		String query = env.getProperty("findByCommanMasterName");
		List<LtMastComnMasterValues> list=   jdbcTemplate.query(query, new Object[]{ masterName.trim().toUpperCase()}, 
				 new BeanPropertyRowMapper<LtMastComnMasterValues>(LtMastComnMasterValues.class)); 
		
		return list;
	}
}
