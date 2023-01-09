package com.lonar.vendor.vendorportal.config;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.lonar.vendor.vendorportal.model.LtMastCommonMessage;
import com.lonar.vendor.vendorportal.repository.*;
import com.lonar.vendor.vendorportal.service.LtMastCommonMessageService;

@Configuration
@EnableWebMvc
@ComponentScan({ "com.lonar.vendor.vendorportal" })
public class ResourceServerWebConfig extends WebMvcConfigurerAdapter {
	  //LtMastCommonMessageDaoImpl   commonMessageDao = new LtMastCommonMessageDaoImpl();

	 @Autowired
	 LtMastCommonMessageService ltMastCommonMessageService;
	 
	  @Autowired
	  LtMastCommonMessageRepository ltMastCommonMessageRepository;
	 
	   public static Map<Integer,String> messages = new HashMap<Integer,String>();
	  
    @Bean
    public Map getAllMessages() {
		try
		{
		  //Map<Integer,String> messages=new HashMap<Integer,String>();
			//List<LtMastCommonMessage> messageList = (List<LtMastCommonMessage>) ltMastCommonMessageRepository.findAll();
			List<LtMastCommonMessage> messageList = ltMastCommonMessageService.listLtMastCommonMessage();
			 Iterator<LtMastCommonMessage> itr=messageList.iterator();
				while(itr.hasNext())
				{
					LtMastCommonMessage ltMastCommonMessage=itr.next();
					messages.put(Integer.parseInt(ltMastCommonMessage.getMessageCode()),ltMastCommonMessage.getMessageDesc());
				}
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
        return messages;
    }
}
