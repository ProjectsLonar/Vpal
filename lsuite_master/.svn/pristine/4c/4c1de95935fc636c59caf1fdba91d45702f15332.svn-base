package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lonar.vendor.vendorportal.model.LtMastComnMasterValues;
import com.lonar.vendor.vendorportal.model.ServiceException;


@Repository
@PropertySource(value = "classpath:queries/commonMasterQueries.properties", ignoreResourceNotFound = true)
public class LtMastComnMasterValuesDaoImpl implements LtMastComnMasterValuesDao
{
	@Autowired
	private Environment env;

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource)
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	@Override
	public List<LtMastComnMasterValues> findByValueCode(String valueCode) throws ServiceException{
		String query = env.getProperty("findByValueCode");
	
		
		List<LtMastComnMasterValues> list=   jdbcTemplate.query(query, new Object[]{valueCode }, 
		 new BeanPropertyRowMapper<LtMastComnMasterValues>(LtMastComnMasterValues.class)); 
		return list;
	}

	@Override
	public List<LtMastComnMasterValues> findByValueName(String valueName) throws ServiceException{
		String query = env.getProperty("findByValueName");
	
		List<LtMastComnMasterValues> list=   jdbcTemplate.query(query, new Object[]{valueName.toUpperCase() }, 
		 new BeanPropertyRowMapper<LtMastComnMasterValues>(LtMastComnMasterValues.class)); 
		return list;
		
	}
	
	@Override
	public List<LtMastComnMasterValues> findAllActive() throws ServiceException{
		String query = env.getProperty("findAllActiveLtMastComnMasterValues");
		
		List<LtMastComnMasterValues> list=   jdbcTemplate.query(query, new Object[]{  }, 
				 new BeanPropertyRowMapper<LtMastComnMasterValues>(LtMastComnMasterValues.class)); 
		 
		return list;
	}

	@Transactional
	@Override
	public List<LtMastComnMasterValues> findByMasteridWithValuecode(Long masterId, String valueCode) throws ServiceException{
		String query = env.getProperty("findByMasteridWithValuecode");
	
		List<LtMastComnMasterValues> list=   jdbcTemplate.query(query, new Object[]{ masterId, "%"+valueCode.toUpperCase()+"%"  }, 
				 new BeanPropertyRowMapper<LtMastComnMasterValues>(LtMastComnMasterValues.class)); 
		return list;
	}

	@Transactional
	@Override
	public List<LtMastComnMasterValues> findByMasterId(Long masterId) throws ServiceException{
		String query = env.getProperty("findLtMastComnMasterValuesByMasterId");
		List<LtMastComnMasterValues> list=   jdbcTemplate.query(query, new Object[]{ masterId }, 
				 new BeanPropertyRowMapper<LtMastComnMasterValues>(LtMastComnMasterValues.class)); 
		
		return list;
	}

	@Transactional
	@Override
	public List<LtMastComnMasterValues> findLikeValueNameWithMasterId(Long masterId, String valueName) {
		String query = env.getProperty("findLikeValueNameWithMasterId");
	
		List<LtMastComnMasterValues> list=   jdbcTemplate.query(query, new Object[]{ masterId, "%"+valueName.toUpperCase()+"%"  }, 
				 new BeanPropertyRowMapper<LtMastComnMasterValues>(LtMastComnMasterValues.class)); 
		 return list;
	}

	@Transactional
	@Override
	public List<LtMastComnMasterValues> findByMasteridWithValueTag(Long masterId, String valueTag) throws ServiceException {
		String query = env.getProperty("findByMasteridWithValueTag");
		
		List<LtMastComnMasterValues> list=   jdbcTemplate.query(query, new Object[]{ masterId, "%"+valueTag+"%"  }, 
				 new BeanPropertyRowMapper<LtMastComnMasterValues>(LtMastComnMasterValues.class)); 
		 return list;
	}

	@Transactional
	@Override
	public List<LtMastComnMasterValues> findByMasterNameWithValueCode(String masterName, String valueCode)
			throws ServiceException {
		
		return null;
	}

	@Transactional
	@Override
	public List<LtMastComnMasterValues> getByValueCode(String valueCode) throws ServiceException
	{
		
		if(valueCode!=null)
		{
			String query = env.getProperty("getByValueCode");
	
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
			throws ServiceException 
	{
		String query = env.getProperty("checkCommonMasterValuesDetails");
		List<LtMastComnMasterValues> list=   jdbcTemplate.query(query, new Object[]{ ltMastComnMasterValues.getValueCode() }, 
				 new BeanPropertyRowMapper<LtMastComnMasterValues>(LtMastComnMasterValues.class)); 
		return list;
	}


	@Override
	public List<LtMastComnMasterValues> findByCommanMasterName(String masterName) throws ServiceException {
		String query = env.getProperty("findByCommanMasterName");
		List<LtMastComnMasterValues> list=   jdbcTemplate.query(query, new Object[]{ masterName.trim().toUpperCase()}, 
				 new BeanPropertyRowMapper<LtMastComnMasterValues>(LtMastComnMasterValues.class)); 
		return list;
	}


	@Override
	public List<LtMastComnMasterValues> getByCommonMasterID(String id) throws ServiceException {
		String query = env.getProperty("getByCommonMasterID");
		List<LtMastComnMasterValues> list=   jdbcTemplate.query(query, new Object[]{ id }, 
				 new BeanPropertyRowMapper<LtMastComnMasterValues>(LtMastComnMasterValues.class)); 
		return list;
	}


	@Override
	public List<LtMastComnMasterValues> getLikeNameWithMaster(String masterName, String valueName)
			throws ServiceException {
		String query = env.getProperty("getComnMasterValuesLikeNameWithMaster");
	
		List<LtMastComnMasterValues> list=   jdbcTemplate.query(query, new Object[]{masterName.toUpperCase(),"%"+valueName.toUpperCase()+"%" }, 
		 new BeanPropertyRowMapper<LtMastComnMasterValues>(LtMastComnMasterValues.class)); 
		return list;
	}


	@Override
	public List<LtMastComnMasterValues> getMasterList(String masterName) throws ServiceException {
		String query = env.getProperty("getMasterListForReports");
		List<LtMastComnMasterValues> list=   jdbcTemplate.query(query, new Object[]{ masterName.trim().toUpperCase()}, 
				 new BeanPropertyRowMapper<LtMastComnMasterValues>(LtMastComnMasterValues.class)); 
		return list;
	}
}
