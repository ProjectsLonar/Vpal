package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lonar.vendor.vendorportal.model.LtMastAttachmentType;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.repository.LtMastAttachmentTypeRepository;
import com.lonar.vendor.vendorportal.repository.LtMastBusinessNatureRepository;

@Repository
@PropertySource(value = "classpath:queries/attachmentTypeMasterQueries.properties", ignoreResourceNotFound = true)
public class LtMastAttachmentTypeDaoImpl implements LtMastAttachmentTypeDao{

	@Autowired
	LtMastAttachmentTypeRepository ltMastAttachmentTypeRepository;
	
	@Autowired
	LtMastBusinessNatureRepository 	ltMastBusinessNatureRepository;
	
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
	public Long getCount(LtMastAttachmentType input, Long companyId) throws ServiceException {
		String query = env.getProperty("getCountLtMastAttachmentType");
		 
		 String code=null;
		   if(input.getModule()!=null)
		   {code="%"+input.getModule().toUpperCase()+"%";}
		   
		   String name=null;
		   if(input.getAttachmentName()!=null)
		   {name="%"+input.getAttachmentName().toUpperCase()+"%";}
		   
		   String desc=null;
		   if(input.getDescription()!=null)
		   {desc="%"+input.getDescription().toUpperCase()+"%";}
		   
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
				query, new Object[] {companyId, code,name,status,input.getStDate(),input.getEnDate() }, String.class);
		return Long.parseLong(count);
	}

	@Override
	public List<LtMastAttachmentType> getDataTable(LtMastAttachmentType input, Long companyId) throws ServiceException {
		String query = env.getProperty("getLtMastAttachmentTypeDatatableRecords");
		 
		 String code=null;
		   if(input.getModule()!=null)
		   {code="%"+input.getModule().toUpperCase()+"%";}
		   
		   String name=null;
		   if(input.getAttachmentName()!=null)
		   {name="%"+input.getAttachmentName().toUpperCase()+"%";}
		   
		   String desc=null;
		   if(input.getDescription()!=null)
		   {desc="%"+input.getDescription().toUpperCase()+"%";}
		   
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
			List<LtMastAttachmentType> list = (List<LtMastAttachmentType>) 
					jdbcTemplate.query(query , new Object[]{companyId, code,name,status,
							input.getStDate(),input.getEnDate(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
						
							input.getColumnNo(),input.getColumnNo(),
							input.getStart()+input.getLength(),input.getStart()+1},
				 new  BeanPropertyRowMapper<LtMastAttachmentType>(LtMastAttachmentType.class));
				return list;
	}

	@Override
	public List<LtMastAttachmentType> findAll(Long companyId) throws ServiceException {
		String query = env.getProperty("getAllLtMastAttachmentType");
		List<LtMastAttachmentType> list=   jdbcTemplate.query(query, new Object[]{companyId }, 
		 new BeanPropertyRowMapper<LtMastAttachmentType>(LtMastAttachmentType.class)); 
		return list;
	}

	@Override
	public List<LtMastAttachmentType> findAllActive(Long companyId) throws ServiceException {
		String query = env.getProperty("getAllActiveLtMastAttachmentType");
		List<LtMastAttachmentType> list=   jdbcTemplate.query(query, new Object[]{companyId }, 
		 new BeanPropertyRowMapper<LtMastAttachmentType>(LtMastAttachmentType.class)); 
		return list;
	}

	@Override
	public LtMastAttachmentType getLtMastAttachmentTypeByID(Long id) throws ServiceException {
		String query = env.getProperty("getLtMastAttachmentTypeByID");
		LtMastAttachmentType list=   jdbcTemplate.queryForObject(query, new Object[]{id }, 
				new BeanPropertyRowMapper<LtMastAttachmentType>(LtMastAttachmentType.class));
		return list;
	}

	@Override
	public List<LtMastAttachmentType> getLtMastAttachmentTypeByCompID(Long id) throws ServiceException {
		String query = env.getProperty("getAllActiveLtMastAttachmentType");
		List<LtMastAttachmentType> list=   jdbcTemplate.query(query, new Object[]{id }, 
		 new BeanPropertyRowMapper<LtMastAttachmentType>(LtMastAttachmentType.class)); 
		return list;
	}

	@Override
	public List<LtMastAttachmentType> findActiveLikeName(String name, Long companyId) throws ServiceException {
		String query = env.getProperty("findActiveLtMastAttachmentTypeLikeName");
		List<LtMastAttachmentType> list=   jdbcTemplate.query(query, new Object[]{"%"+name+"%",companyId }, 
		 new BeanPropertyRowMapper<LtMastAttachmentType>(LtMastAttachmentType.class)); 
		return list;
	}

	@Override
	public LtMastAttachmentType save(LtMastAttachmentType ltMastAttachmentType) throws ServiceException {
		return ltMastAttachmentTypeRepository.save(ltMastAttachmentType);
	}

	@Override
	public List<LtMastAttachmentType> getByName(String attachmentName, String moduleCode, Long companyId)
			throws ServiceException {
		String query = env.getProperty("findActiveLtMastAttachmentTypeLikeNameAndModule");
		List<LtMastAttachmentType> list=   jdbcTemplate.query(query, new Object[]{attachmentName,moduleCode,companyId }, 
		 new BeanPropertyRowMapper<LtMastAttachmentType>(LtMastAttachmentType.class)); 
		return list;
	}

	@Override
	public LtMastAttachmentType update(LtMastAttachmentType ltMastAttachmentType) throws ServiceException {
		return ltMastAttachmentTypeRepository.save(ltMastAttachmentType);
	}

	@Override
	public LtMastAttachmentType delete(Long id) throws ServiceException {
		if( ltMastAttachmentTypeRepository.exists(id) ) {
			ltMastAttachmentTypeRepository.delete(id);
			return null;
		}
		return ltMastAttachmentTypeRepository.findOne(id);
	}

	@Override
	public List<LtMastAttachmentType> listAllActiveByModule(String module, Long companyId) throws ServiceException {
		String query = env.getProperty("listAllActiveAttachmentTypeByModule");
		List<LtMastAttachmentType> list=   jdbcTemplate.query(query, new Object[]{module.toUpperCase(),companyId }, 
		 new BeanPropertyRowMapper<LtMastAttachmentType>(LtMastAttachmentType.class)); 
		return list;
	}

}
