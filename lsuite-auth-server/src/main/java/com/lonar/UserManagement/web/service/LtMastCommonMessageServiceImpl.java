package com.lonar.UserManagement.web.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.jdo.annotations.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lonar.UserManagement.security.ResourceServerConfiguration;
import com.lonar.UserManagement.web.dao.LtMastCommonMessageDao;
import com.lonar.UserManagement.web.model.CodeMaster;
import com.lonar.UserManagement.web.model.LtMastCommonMessage;
import com.lonar.UserManagement.web.model.LtMastLogger;
import com.lonar.UserManagement.web.model.Status;
import com.lonar.UserManagement.web.repository.LtMastLoggerRepository;


@Service
public  class LtMastCommonMessageServiceImpl implements LtMastCommonMessageService,CodeMaster
{

	private  Map<Integer,String> messages;
	
	@Autowired
	LtMastLoggerRepository ltMastLoggerRepository;
	
	@Autowired
	LtMastCommonMessageDao  ltMastCommonMessageDao;
	
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	@Transactional
	@Override
	public LtMastCommonMessage getMsgcode(String messageCode) throws Exception 
	{
		LtMastCommonMessage ltMastCommonMessages=null;
		List<LtMastCommonMessage> list= ltMastCommonMessageDao.getMsgcode(messageCode);
		for(LtMastCommonMessage commonMessages:list)
		{
			if(commonMessages.getMessageCode().equals(messageCode))
			{
				ltMastCommonMessages= commonMessages;
			}
			
		}
		return ltMastCommonMessages;
	}

	@Transactional
	@Override
	public LtMastCommonMessage getByMessageCode(String code) throws Exception 
	{
		return ltMastCommonMessageDao.getByMessageCode(Integer.parseInt(code));
	}

	@Transactional
	@Override
	public Map<Integer, String> getAllMessages() throws Exception 
	{
		messages=new HashMap<Integer,String>();
		List<LtMastCommonMessage> messageList= ltMastCommonMessageDao.getAllMessages();
		Iterator<LtMastCommonMessage> itr=messageList.iterator();
		while(itr.hasNext())
		{
			LtMastCommonMessage ltMastCommonMessage=itr.next();
			messages.put(Integer.parseInt(ltMastCommonMessage.getMessageCode()),ltMastCommonMessage.getMessageDesc());
		}
		return messages;
	}

	@Transactional
	@Override
	public Status getCodeAndMessage(Integer code) 
	{
		Status status=new Status();
		try{
		status.setCode(code);
		status.setMessage(ResourceServerConfiguration.messages.get(code));
		if(status.getMessage()==null)
		{
			if(code==UPDATE_SUCCESSFULLY) {
				status.setCode(UPDATE_SUCCESSFULLY);
				status.setMessage("Error in finding message! The action was successful");
			}else if(code==UPDATE_FAIL) {
				status.setCode(UPDATE_FAIL);
				status.setMessage("Error in finding message! The action was unsuccessful");
			}else if(code==DELETE_FAIL) {
				status.setCode(DELETE_FAIL);
				status.setMessage("Error in finding message! The action was unsuccessful");
			}else if(code==DELETE_SUCCESSFULLY) {
				status.setCode(DELETE_SUCCESSFULLY);
				status.setMessage("Error in finding message! The action was successful");
			}else if(code==INSERT_SUCCESSFULLY) {
				status.setCode(INSERT_SUCCESSFULLY);
				status.setMessage("Error in finding message! The action was successful");
			}else if(code==INSERT_FAIL) {
				status.setCode(INSERT_FAIL);
				status.setMessage("Error in finding message! The action was unsuccessful");
			}
		}
		}catch(Exception e)
		{
			status.setCode(EXCEPTION);
			status.setMessage("Error in finding message! The action was unsuccessful");
			
		}
		return status;
	}

	@Transactional
	@Override
	public List<LtMastCommonMessage> listLtMastCommonMessage() throws Exception{
		return ltMastCommonMessageDao.listLtMastCommonMessage();
	}

	@Transactional
	@Override
	public LtMastCommonMessage getByID(Long id) throws Exception{
		return ltMastCommonMessageDao.getByID(id);
	}

	@Transactional
	@Override
	public Status update(LtMastCommonMessage mastCommonMessage) throws Exception
	{
		Status status = new Status();
		mastCommonMessage.setLastUpdateDate(new Date());
		mastCommonMessage.setLastUpdatedBy(mastCommonMessage.getLastUpdateLogin());
		if(ltMastCommonMessageDao.update(mastCommonMessage))
		{
			//AppConfig.messageList.put(Integer.parseInt(mastCommonMessage.getMessageCode()), mastCommonMessage.getMessageDesc());
				status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_SUCCESSFULLY);
		}
		else
		{
			status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_FAIL);
		}
		return status;
	}

	@Override
	public List<LtMastCommonMessage> getCommonMessageDataTable(LtMastCommonMessage input) throws Exception
	{
		if(input.getColumnNo()==7 && input.getSort().equals("desc"))
		{ input.setColumnNo(17); }
		if(input.getColumnNo()==2 && input.getSort().equals("desc"))
		{ input.setColumnNo(12); }
		if(input.getColumnNo()==3 && input.getSort().equals("desc"))
		{ input.setColumnNo(13); }
		if(input.getColumnNo()==4 && input.getSort().equals("desc"))
		{ input.setColumnNo(14); }
		if(input.getColumnNo()==5 && input.getSort().equals("desc"))
		{ input.setColumnNo(15); }
		if(input.getColumnNo()==6 && input.getSort().equals("desc"))
		{ input.setColumnNo(16); }
		return ltMastCommonMessageDao.getCommonMessageDataTable(input);
	}

	@Override
	public Long getCount(LtMastCommonMessage input) throws Exception 
	{
		return ltMastCommonMessageDao.getCount(input);
	}

	@Override
	public void saveLog(Exception e) {
		try{
			LtMastLogger ltMastLogger = new LtMastLogger();
			ltMastLogger.setCode(INTERNAL_SERVER_ERROR);
			ltMastLogger.setExceptionCause(e.getCause().toString());
			ltMastLogger.setMessage(e.getMessage());
			ltMastLogger.setClassName(e.getClass().toString());
			ltMastLogger.setLastUpdateDate(new Date());
			ltMastLogger = ltMastLoggerRepository.save(ltMastLogger);
		}catch(Exception e1) {
			e1.printStackTrace();
		}
	}

}
