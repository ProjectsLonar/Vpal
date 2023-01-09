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
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.repository.LtMastPositionMasterRepository;
import com.lonar.vendor.vendorportal.service.LtMastPositionMasterDao;

@Repository
@PropertySource(value = "classpath:queries/positionMasterQueries.properties", ignoreResourceNotFound = true)
public class LtMastPositionMasterDaoImpl implements LtMastPositionMasterDao {

	@Autowired
	LtMastPositionMasterRepository ltMastPositionMasterRepository;
	
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
	public Long getCount(LtMastPositionMaster input, Long companyId) throws ServiceException {
		String query = env.getProperty("getCountLtMastPositionMaster");
		 
		 String code=null;
		   if(input.getPositionCode()!=null)
		   {code="%"+input.getPositionCode().toUpperCase()+"%";}
		   
		   String name=null;
		   if(input.getPositionName()!=null)
		   {name="%"+input.getPositionName().toUpperCase()+"%";}
		   
		   String desc=null;
		   if(input.getPositionDesc()!=null)
		   {desc="%"+input.getPositionDesc().toUpperCase()+"%";}
		   
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
	public List<LtMastPositionMaster> getDataTable(LtMastPositionMaster input, Long companyId) throws ServiceException {
		String query = env.getProperty("getLtMastPositionDatatableRecords");
		 
		   String code=null;
		   if(input.getPositionCode()!=null)
		   {code="%"+input.getPositionCode().toUpperCase()+"%";}
		   
		   String name=null;
		   if(input.getPositionName()!=null)
		   {name="%"+input.getPositionName().toUpperCase()+"%";}
		   
		   String desc=null;
		   if(input.getPositionDesc()!=null)
		   {desc="%"+input.getPositionDesc().toUpperCase()+"%";}
		   
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
			if(input.getColumnNo()==0) {
				input.setColumnNo(8);
			}
			List<LtMastPositionMaster> list = (List<LtMastPositionMaster>) 
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
				 new  BeanPropertyRowMapper<LtMastPositionMaster>(LtMastPositionMaster.class));
				return list;
	}

	@Override
	public LtMastPositionMaster save(LtMastPositionMaster ltMastPositionMaster) throws ServiceException {
		
		return ltMastPositionMasterRepository.save(ltMastPositionMaster);
	}

	@Override
	public LtMastPositionMaster update(LtMastPositionMaster ltMastPositionMaster) throws ServiceException {
		return ltMastPositionMasterRepository.save(ltMastPositionMaster);
	}

	@Override
	public LtMastPositionMaster delete(Long id) throws ServiceException {
		if( ltMastPositionMasterRepository.exists(id) ) {
			 ltMastPositionMasterRepository.delete(id);
			 return null;
		}
		return ltMastPositionMasterRepository.findOne(id);
	}

	@Override
	public LtMastPositionMaster findById(Long id) throws ServiceException {
		String query = env.getProperty("findLtMastPositionMasterById");
		LtMastPositionMaster list=   jdbcTemplate.queryForObject(query, new Object[]{id }, 
				new BeanPropertyRowMapper<LtMastPositionMaster>(LtMastPositionMaster.class));
		return list;
	}

	@Override
	public List<LtMastPositionMaster> getAll() throws ServiceException {
		String query = env.getProperty("getAllLtMastPositionMaster");
		List<LtMastPositionMaster> list=   jdbcTemplate.query(query, new Object[]{ }, 
		 new BeanPropertyRowMapper<LtMastPositionMaster>(LtMastPositionMaster.class)); 
		return list;
	}

	@Override
	public List<LtMastPositionMaster> getLikePositionName(String position, Long companyId) throws ServiceException {
		String query = env.getProperty("getLtMastPositionMasterLikePositionName");
		List<LtMastPositionMaster> list=   jdbcTemplate.query(query, new Object[]{ "%"+position.toUpperCase()+"%", 
				"%"+position.toUpperCase()+"%",companyId}, 
		 new BeanPropertyRowMapper<LtMastPositionMaster>(LtMastPositionMaster.class)); 
		return list;
	}

	@Override
	public List<LtMastPositionMaster> getByPositionName(String positionName, Long companyId) throws ServiceException {
		String query = env.getProperty("getLtMastPositionMasterByPositionName");
		List<LtMastPositionMaster> list=   jdbcTemplate.query(query, new Object[]{ positionName.toUpperCase(), 
				companyId}, 
		 new BeanPropertyRowMapper<LtMastPositionMaster>(LtMastPositionMaster.class)); 
		return list;
	}

	@Override
	public List<LtMastPositionMaster> getByPositionCode(String positionCode, Long companyId) throws ServiceException {
		String query = env.getProperty("getLtMastPositionMasterByPositionCode");
		List<LtMastPositionMaster> list=   jdbcTemplate.query(query, new Object[]{ positionCode.toUpperCase(), 
				companyId}, 
		 new BeanPropertyRowMapper<LtMastPositionMaster>(LtMastPositionMaster.class)); 
		return list;
	}

	

}
