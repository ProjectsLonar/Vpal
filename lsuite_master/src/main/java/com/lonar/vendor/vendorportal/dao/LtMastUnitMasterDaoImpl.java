package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lonar.vendor.vendorportal.model.LtMastPositionMaster;
import com.lonar.vendor.vendorportal.model.LtMastUnitMaster;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.repository.LtMastUnitMasterRepository;

@Repository
@PropertySource(value = "classpath:queries/unitMasterQueries.properties", ignoreResourceNotFound = true)
public class LtMastUnitMasterDaoImpl implements LtMastUnitMasterDao{

	@Autowired
	LtMastUnitMasterRepository ltMastUnitMasterRepository;
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private Environment env;
	
	private JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	} 
	
	@Override
	public Long getCount(LtMastUnitMaster input, Long companyId) throws ServiceException {
		String query = env.getProperty("getCountLtMastUnitMaster");
		 
		   String code=null;
		   if(input.getUnitCode()!=null)
		   {code="%"+input.getUnitCode().toUpperCase()+"%";}
		   
		   String name=null;
		   if(input.getUnitName()!=null)
		   {name="%"+input.getUnitName().toUpperCase()+"%";}
		   
		   String desc=null;
		   if(input.getUnitDesc()!=null)
		   {desc="%"+input.getUnitDesc().toUpperCase()+"%";}
		   
		   String status=null;
		   if(input.getStatus()!=null) 
		   {status="%"+input.getStatus().toUpperCase()+"%";}
		   
			if(input.getStDate() == null || input.getStDate().trim().equals(""))
			{
				input.setStDate(null);
			}
			if(input.getEnDate() == null || input.getEnDate().trim().equals(""))
			{
				input.setEnDate(null);
			}
		String count  = (String)getJdbcTemplate().queryForObject(
				query, new Object[] {companyId, code,name,desc,status,input.getStDate(),input.getEnDate() }, String.class);
		return Long.parseLong(count);
	}

	@Override
	public List<LtMastUnitMaster> getDataTable(LtMastUnitMaster input, Long companyId) throws ServiceException {
		String query = env.getProperty("getLtMastUnitMasterDatatableRecords");
		 
		String code=null;
		   if(input.getUnitCode()!=null)
		   {code="%"+input.getUnitCode().toUpperCase()+"%";}
		   
		   String name=null;
		   if(input.getUnitName()!=null)
		   {name="%"+input.getUnitName().toUpperCase()+"%";}
		   
		   String desc=null;
		   if(input.getUnitDesc()!=null)
		   {desc="%"+input.getUnitDesc().toUpperCase()+"%";}
		   
		   String status=null;
		   if(input.getStatus()!=null) 
		   {status="%"+input.getStatus().toUpperCase()+"%";}
		   
			if(input.getStDate() == null || input.getStDate().trim().equals(""))
			{
				input.setStDate(null);
			}
			if(input.getEnDate() == null || input.getEnDate().trim().equals(""))
			{
				input.setEnDate(null);
			}
			List<LtMastUnitMaster> list = (List<LtMastUnitMaster>) 
					jdbcTemplate.query(query , new Object[]{companyId, code,name,desc,status,
							input.getStDate(),input.getEnDate(),
							
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							
							input.getStart()+input.getLength(),input.getStart()+1},
				 new  BeanPropertyRowMapper<LtMastUnitMaster>(LtMastUnitMaster.class));
				return list;
	}

	@Override
	public LtMastUnitMaster save(LtMastUnitMaster ltMastUnitMaster) throws ServiceException {
		return ltMastUnitMasterRepository.save(ltMastUnitMaster);
	}

	@Override
	public LtMastUnitMaster update(LtMastUnitMaster ltMastUnitMaster) throws ServiceException {
		return ltMastUnitMasterRepository.save(ltMastUnitMaster);
	}

	@Override
	public LtMastPositionMaster delete(Long id) throws ServiceException {
		if( ltMastUnitMasterRepository.exists(id) ) {
			ltMastUnitMasterRepository.delete(id);
			return null;
		}
		return new LtMastPositionMaster();
	}

	@Override
	public LtMastUnitMaster findById(Long id) throws ServiceException {
		String query = env.getProperty("findLtMastUnitMasterById");
		LtMastUnitMaster list=   jdbcTemplate.queryForObject(query, new Object[]{id }, 
				new BeanPropertyRowMapper<LtMastUnitMaster>(LtMastUnitMaster.class));
		return list;
	}

	@Override
	public List<LtMastUnitMaster> getAll() throws ServiceException {
		String query = env.getProperty("getAllLtMastUnitMaster");
		List<LtMastUnitMaster> list=   jdbcTemplate.query(query, new Object[]{ }, 
		 new BeanPropertyRowMapper<LtMastUnitMaster>(LtMastUnitMaster.class)); 
		return list;
	}

	@Override
	public List<LtMastUnitMaster> getLikeUnitName(String unit, Long companyId) throws ServiceException {
		String query = env.getProperty("getLtMastUnitMasterLikePositionName");
		List<LtMastUnitMaster> list=   jdbcTemplate.query(query, new Object[]{ "%"+unit.toUpperCase()+"%", 
				"%"+unit.toUpperCase()+"%",companyId}, 
		 new BeanPropertyRowMapper<LtMastUnitMaster>(LtMastUnitMaster.class)); 
		return list;
	}

	@Override
	public List<LtMastUnitMaster> getByUnitName(String unitName, Long companyId) throws ServiceException {
		String query = env.getProperty("getLtMastUnitMasterByUnitName");
		List<LtMastUnitMaster> list=   jdbcTemplate.query(query, new Object[]{ unitName.toUpperCase(), 
				companyId}, 
		 new BeanPropertyRowMapper<LtMastUnitMaster>(LtMastUnitMaster.class)); 
		return list;
	}

	@Override
	public List<LtMastUnitMaster> getByUnitCode(String unitCode, Long companyId) throws ServiceException {
		String query = env.getProperty("getLtMastUnitMasterByUnitCode");
		List<LtMastUnitMaster> list=   jdbcTemplate.query(query, new Object[]{ unitCode.toUpperCase(), 
				companyId}, 
		 new BeanPropertyRowMapper<LtMastUnitMaster>(LtMastUnitMaster.class)); 
		return list;
	}

	@Override
	public List<LtMastUnitMaster> getAllActive(Long companyId) throws ServiceException {
		String query = env.getProperty("getAllActiveLtMastUnitMaster");
		List<LtMastUnitMaster> list=   jdbcTemplate.query(query, new Object[]{ companyId}, 
		 new BeanPropertyRowMapper<LtMastUnitMaster>(LtMastUnitMaster.class)); 
		return list;
	}

}
