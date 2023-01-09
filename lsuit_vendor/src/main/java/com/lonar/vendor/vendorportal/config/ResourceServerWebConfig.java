
package com.lonar.vendor.vendorportal.config;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.lonar.vendor.vendorportal.model.LtMastCommonMessage;
import com.lonar.vendor.vendorportal.model.LtMastSysVariables;
import com.lonar.vendor.vendorportal.repository.LtMastCommonMessageRepository;
import com.lonar.vendor.vendorportal.service.LtMastCommonMessageService;
import com.lonar.vendor.vendorportal.service.LtMastSysVariablesService;

@Configuration
@EnableWebMvc
public class ResourceServerWebConfig extends WebMvcConfigurerAdapter {

	  @Autowired
	  LtMastCommonMessageRepository LtMastCommonMessageRepository;
	  
	  @Autowired
	   LtMastCommonMessageService ltMastCommonMessageService;
	  
	  @Autowired
	  LtMastSysVariablesService ltMastSysVariablesService;
	  
	   public static Map<Integer,String> messages=new HashMap<Integer,String>();
	   
	   public static Map<String,String> sysVariableMap=new HashMap<String,String>();
	  
    @Bean
    public Map getAllMessages()
	{
		try
		{
		  //Map<Integer,String> messages=new HashMap<Integer,String>();
			//List<LtMastCommonMessage> messageList = (List<LtMastCommonMessage>) LtMastCommonMessageRepository.findAll();
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
    
    @Bean
    public Map getAllProperties()
	{
		try
		{
		  //Map<Integer,String> messages=new HashMap<Integer,String>();
			List<LtMastSysVariables> sysVariableList = ltMastSysVariablesService.getSysvariableProperties();
			 Iterator<LtMastSysVariables> itr=sysVariableList.iterator();
				while(itr.hasNext())
				{
					LtMastSysVariables ltMastSysVariables=itr.next();
					sysVariableMap.put(ltMastSysVariables.getVariableCode(),ltMastSysVariables.getSystemValue());
				}
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
        return messages;
    }
    
   /* @Bean
    public int call() {
    	TimerTask timerTask = new MyTimerTask();
        //running timer task as daemon thread
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(timerTask, 0, 10*1000);
        //cancel after sometime
        try {
            Thread.sleep(120000);
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        timer.cancel();
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		return 0;
    }*/
}
