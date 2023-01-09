package com.lonar.vendor.vendorportal.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
//@PropertySource({ "classpath:mail.properties" })
public class AppConfig1 extends WebMvcConfigurerAdapter{

	@Autowired
	private Environment env;
	
	
	
	//public static Map<Integer,String> messageList=new HashMap<Integer,String>();
	
	@Autowired
	private RequestInterceptor requestInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(requestInterceptor);
	}
	
	
	/*@Bean
	public JavaMailSender getMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

		mailSender.setHost(env.getProperty("email.host"));
		//mailSender.setHost("10.91.0.6");
		//mailSender.setPort(Integer.parseInt(env.getProperty("email.port").trim()));
		mailSender.setPort(587);
		//mailSender.setPort(25);
		mailSender.setUsername(env.getProperty("email.username").trim());
		mailSender.setPassword(env.getProperty("email.password").trim());

		//-------------------------aks 21-6---------------------------
		//mailSender.setPort(Optional.ofNullable(env.getProperty("email.port").trim()).map(Integer::valueOf).orElse(125));
		mailSender.setDefaultEncoding("UTF-8");
		
		//-----------------------------------------------------------
		
		
		
		
		
		Properties javaMailProperties = new Properties();
		
	 	javaMailProperties.put("mail.smtp.starttls.enable", env.getProperty("email.smtp.starttls.enable"));
		javaMailProperties.put("mail.smtp.auth", env.getProperty("email.smtp.auth"));
		javaMailProperties.put("mail.transport.protocol", env.getProperty("email.transport.protocol"));
		javaMailProperties.put("mail.debug", env.getProperty("email.debug"));
		javaMailProperties.put("mail.smtp.sendpartial", env.getProperty("email.smtp.sendpartial"));

		mailSender.setJavaMailProperties(javaMailProperties);
		return mailSender;
	}

	@Bean
	public VelocityEngine getVelocityEngine() throws VelocityException, IOException {
		VelocityEngineFactory velocityEngineFactory = new VelocityEngineFactory();
		Properties props = new Properties();
		props.put("resource.loader", "class");
		props.put("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");

		velocityEngineFactory.setVelocityProperties(props);
		return velocityEngineFactory.createVelocityEngine();
	}*/
}
