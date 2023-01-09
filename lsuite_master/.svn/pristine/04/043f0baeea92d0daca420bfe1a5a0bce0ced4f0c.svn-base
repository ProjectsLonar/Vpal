package com.lonar.vendor.vendorportal.service;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.jdo.annotations.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lonar.vendor.vendorportal.config.ResourceServerWebConfig;
import com.lonar.vendor.vendorportal.dao.LtMastCommonMessageDao;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtMastCommonMessage;
import com.lonar.vendor.vendorportal.model.LtMastLogger;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.repository.LtMastCommonMessageRepository;
import com.lonar.vendor.vendorportal.repository.LtMastLoggerRepository;



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
	
	@Autowired
	LtMastCommonMessageRepository ltMastCommonMessageRepository;
	
	@Transactional
	@Override
	public LtMastCommonMessage getMsgcode(String messageCode) throws ServiceException 
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
	public LtMastCommonMessage getByMessageCode(String code) throws ServiceException 
	{
		return ltMastCommonMessageDao.getByMessageCode(Integer.parseInt(code));
	}

	@Transactional
	@Override
	public Map<Integer, String> getAllMessages() throws ServiceException 
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
		status.setMessage(ResourceServerWebConfig.messages.get(code));
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
			e.printStackTrace();
			status.setCode(EXCEPTION);
			status.setMessage("Error in finding message! The action was unsuccessful");
			
		}
		return status;
	}

	@Transactional
	@Override
	public List<LtMastCommonMessage> listLtMastCommonMessage() throws ServiceException{
		List<LtMastCommonMessage> ltMastCommonMessageList = ltMastCommonMessageDao.listLtMastCommonMessage();
		return ltMastCommonMessageList;
		
	}

	@Transactional
	@Override
	public ResponseEntity getByID(Long id) throws ServiceException{
		LtMastCommonMessage ltMastCommonMessage = null;
	
			ltMastCommonMessage =ltMastCommonMessageDao.getByID(id);
			return new ResponseEntity(ltMastCommonMessage, HttpStatus.OK);
	}

	@Transactional
	@Override
	public Status update(LtMastCommonMessage mastCommonMessage) throws ServiceException
	{
		Status status = new Status();
		mastCommonMessage.setLastUpdateDate(new Date());
		mastCommonMessage.setLastUpdatedBy(mastCommonMessage.getLastUpdateLogin());
		if(ltMastCommonMessageDao.update(mastCommonMessage))
		{
			ResourceServerWebConfig.messages.put(Integer.parseInt(mastCommonMessage.getMessageCode()), mastCommonMessage.getMessageDesc());
				status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_SUCCESSFULLY);
		}
		else
		{
			status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_FAIL);
		}
		return status;
	}

	@Override
	public List<LtMastCommonMessage> getCommonMessageDataTable(LtMastCommonMessage input) throws ServiceException
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
	public Long getCount(LtMastCommonMessage input) throws ServiceException 
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

	@Override
	public ResponseEntity<Status> save(LtMastCommonMessage ltMastCommonMessage) throws ServiceException {
		Status status = new Status();
		
			if(ltMastCommonMessage.getMessageCode()==null || ltMastCommonMessage.getMessageName()==null ||
					ltMastCommonMessage.getStartDate()==null || ltMastCommonMessage.getCreatedBy()==null || ltMastCommonMessage.getCreationDate()==null)
			{
				status.setCode(INSERT_FAIL);
				status.setMessage("Please fill all the mandatory fields");
				return new ResponseEntity<Status>(status, HttpStatus.OK);
			}
			else
			{
				if(ltMastCommonMessage.getStatus()==null)
				{
					status.setCode(INSERT_FAIL);
					status.setMessage("Please select the Status");
					
				}
				ltMastCommonMessage.setCreationDate(new Date());
				ltMastCommonMessage.setLastUpdateDate(new Date());
				ltMastCommonMessage.setCreatedBy(ltMastCommonMessage.getLastUpdateLogin());
				ltMastCommonMessage.setLastUpdatedBy(ltMastCommonMessage.getLastUpdateLogin());
				
				LtMastCommonMessage mastCommonMessage=ltMastCommonMessageService.
						getMsgcode(ltMastCommonMessage.getMessageCode());
				
				if(mastCommonMessage != null)
				{
					status=ltMastCommonMessageService.getCodeAndMessage(INSERT_FAIL);
					status.setMessage("Message code already exists.");
					
				}
				else
				{
					LtMastCommonMessage mastCommonMessage1=ltMastCommonMessageDao.
							getByMessageName(ltMastCommonMessage.getMessageName());
					if(mastCommonMessage1!=null) {
						status=ltMastCommonMessageService.getCodeAndMessage(INSERT_FAIL);
						status.setMessage("Message name already exists.");
					}else {
						ltMastCommonMessage=ltMastCommonMessageRepository.save(ltMastCommonMessage);
						if(ltMastCommonMessage!=null)
						{
							//P2PApplicationConfiguration.messageList.put(Integer.parseInt(ltMastCommonMessage.getMessageCode()), ltMastCommonMessage.getMessageDesc());
							status=ltMastCommonMessageService.getCodeAndMessage(INSERT_SUCCESSFULLY);
						}
					}
					
				}
				
			
			}
	
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Status> updateMessage(LtMastCommonMessage mastCommonMessage) throws ServiceException {
		Status status = new Status();
		LtMastCommonMessage commonMessage=null;
		
			if(mastCommonMessage.getMessageId()==null || mastCommonMessage.getMessageCode()==null || mastCommonMessage.getMessageName()==null ||
					mastCommonMessage.getStartDate()==null )
			{
				status=ltMastCommonMessageService.getCodeAndMessage(INPUT_IS_EMPTY);
				return new ResponseEntity<Status>(status, HttpStatus.OK);

			}
			else
			{
				commonMessage=ltMastCommonMessageService.getMsgcode(mastCommonMessage.getMessageCode());
				if( ( commonMessage.getMessageId().equals(mastCommonMessage.getMessageId())) || (commonMessage==null))
				{
					status = ltMastCommonMessageService.update(mastCommonMessage);
				}
				else
				{
					status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_FAIL);
				}
				return new ResponseEntity<Status>(status, HttpStatus.OK);
			}
		
		
	}

	@Override
	public ResponseEntity<Status> delete(String id) throws ServiceException {
		Status status = new Status();
		
			if(id!=null )
			{
				if(ltMastCommonMessageRepository.exists(Long.parseLong(id)))
				{
					ltMastCommonMessageRepository.delete(Long.parseLong(id));
					status.setCode(DELETE_SUCCESSFULLY);
					status.setMessage("The record has been deleted successfully.");

					return new ResponseEntity<Status>(status, HttpStatus.OK);
				}
			}
			else
			{
				status.setCode(ENTITY_CANNOT_DELETE);
				status.setMessage("This record is already in use so cannot be deleted.");		
			}
			return new ResponseEntity<Status>(status, HttpStatus.OK);
		
	}

}
