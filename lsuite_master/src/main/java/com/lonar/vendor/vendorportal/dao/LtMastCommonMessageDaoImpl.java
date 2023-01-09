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

import com.lonar.vendor.vendorportal.model.LtMastCommonMessage;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.repository.LtMastCommonMessageRepository;

@Repository
@PropertySource(value = "classpath:queries/commonMessageQueries.properties", ignoreResourceNotFound = true)
public class LtMastCommonMessageDaoImpl implements LtMastCommonMessageDao
{
	@Autowired
	private Environment env;
	
	/*@PersistenceContext(name = "em")
	private EntityManager em;*/
	
	private JdbcTemplate jdbcTemplate;
	
	private JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	@Autowired
	LtMastCommonMessageRepository ltMastCommonMessageRepository;
	
	@Autowired
	public void setDataSource(DataSource dataSource)
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	} 
	
	@Transactional
	@Override
	public List<LtMastCommonMessage> getMsgcode(String messageCode) throws ServiceException 
	{
		String query = env.getProperty("getMsgcode");
	
		List<LtMastCommonMessage> list=   jdbcTemplate.query(query, new Object[]{ messageCode }, 
					 new BeanPropertyRowMapper<LtMastCommonMessage>(LtMastCommonMessage.class));
		
		return list;
	}

	@Transactional
	@Override
	public LtMastCommonMessage getByMessageCode(Integer code) throws ServiceException 
	{
		String query = env.getProperty("getByMessageCode");
		
		List<LtMastCommonMessage> list=   jdbcTemplate.query(query, new Object[]{ code }, 
					 new BeanPropertyRowMapper<LtMastCommonMessage>(LtMastCommonMessage.class));
		if( !list.isEmpty())
		{	return list.get(0); }
		else
			return null;
	}

	@Override
	public List<LtMastCommonMessage> getAllMessages() throws ServiceException 
	{
		//String query = env.getProperty("getAllMessages");
		String query = "SELECT * FROM LT_MAST_COMMON_MESSAGES l";
		List<LtMastCommonMessage> list=   jdbcTemplate.query(query, new Object[]{  }, 
					 new BeanPropertyRowMapper<LtMastCommonMessage>(LtMastCommonMessage.class));
		
		return list;
	}

	@Override
	public List<LtMastCommonMessage> listLtMastCommonMessage() throws ServiceException {
		String query = env.getProperty("listLtMastCommonMessage");
	
		List<LtMastCommonMessage> list=   jdbcTemplate.query(query, new Object[]{ }, 
					 new BeanPropertyRowMapper<LtMastCommonMessage>(LtMastCommonMessage.class));
		
			return list;
	}

	@Override
	public LtMastCommonMessage getByID(Long id) throws ServiceException {
		String query = env.getProperty("getByID");
		
		List<LtMastCommonMessage> list=   jdbcTemplate.query(query, new Object[]{ id }, 
					 new BeanPropertyRowMapper<LtMastCommonMessage>(LtMastCommonMessage.class));
		if( !list.isEmpty())
		{	return list.get(0); }
		else
			return null;
	}

	@Override
	public boolean update(LtMastCommonMessage mastCommonMessage) throws ServiceException 
	{
		if(ltMastCommonMessageRepository.save(mastCommonMessage)!=null)
		return true;
		else
			return false;
	}

	@Override
	public List<LtMastCommonMessage> getCommonMessageDataTable(LtMastCommonMessage input) throws ServiceException {
		String query = env.getProperty("getCommonMessageDataTable");
	
		   String msgCode=null;
		   if(input.getMessageCode()!=null && !input.getMessageCode().equals(""))
		   {msgCode="%"+input.getMessageCode().trim().toUpperCase()+"%";}
		   
		   String msgName=null;
		   if(input.getMessageName()!=null  && !input.getMessageName().equals(""))
		   {msgName="%"+input.getMessageName().trim().toUpperCase()+"%";}
		   
		   String msgDesc=null;
		   if(input.getMessageDesc()!=null && !input.getMessageDesc().equals(""))
		   {msgDesc="%"+input.getMessageDesc().trim().toUpperCase()+"%";}
		   
		   
		   String status=null;
		   if(input.getStatus()!=null && !input.getStatus().equals("")) 
		   {status="%"+input.getStatus().toUpperCase()+"%";}
			
			if(input.getStDate() == null || input.getStDate().trim().equals(""))
			{
				input.setStDate(null);
			}
			if(input.getEnDate() == null || input.getEnDate().trim().equals(""))
			{
				input.setEnDate(null);
			}
			
			if(input.getColumnNo()==0)
			{
				input.setColumnNo(2);
			}
		
			
	return (List<LtMastCommonMessage>) 
			jdbcTemplate.query(query , new Object[]{msgCode,msgName,msgDesc,status,
					input.getStDate(),input.getEnDate(),
					input.getColumnNo(),input.getColumnNo(),
					input.getColumnNo(),input.getColumnNo(),
					input.getColumnNo(),input.getColumnNo(),
					input.getColumnNo(),input.getColumnNo(),
					input.getColumnNo(),input.getColumnNo(),
					input.getColumnNo(),input.getColumnNo(),
					input.getLength() +input.getStart(),input.getStart()+1},
		 new  BeanPropertyRowMapper<LtMastCommonMessage>(LtMastCommonMessage.class));
	}

	@Override
	public Long getCount(LtMastCommonMessage input) throws ServiceException 
	{
		String query = env.getProperty("getCountLtMastCommonMessage");
		
		String msgCode=null;
		   if(input.getMessageCode()!=null && !input.getMessageCode().equals(""))
		   {msgCode="%"+input.getMessageCode().trim().toUpperCase()+"%";}
		   
		   String msgName=null;
		   if(input.getMessageName()!=null  && !input.getMessageName().equals(""))
		   {msgName="%"+input.getMessageName().trim().toUpperCase()+"%";}
		   
		   String msgDesc=null;
		   if(input.getMessageDesc()!=null && !input.getMessageDesc().equals(""))
		   {msgDesc="%"+input.getMessageDesc().trim().toUpperCase()+"%";}
		   
		   
		   String status=null;
		   if(input.getStatus()!=null && !input.getStatus().equals("")) 
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
					query, new Object[] {msgCode,msgName,msgDesc,status,
							input.getStDate(),input.getEnDate()}, String.class);

			return Long.parseLong(count);
	}

	@Override
	public LtMastCommonMessage getByMessageName(String messageName) throws ServiceException {
		String query = env.getProperty("getByMessageName");
		
		List<LtMastCommonMessage> list=   jdbcTemplate.query(query, new Object[]{ messageName }, 
					 new BeanPropertyRowMapper<LtMastCommonMessage>(LtMastCommonMessage.class));
		if( !list.isEmpty())
		{	return list.get(0); }
		else
			return null;
	}

}
