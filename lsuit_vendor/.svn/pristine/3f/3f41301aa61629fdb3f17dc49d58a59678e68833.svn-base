package com.lonar.vendor.vendorportal.common;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.VelocityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.datatables.repository.DataTablesRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.ui.velocity.VelocityEngineFactory;

@Configuration
@EntityScan("com.lonar.vendor.vendorportal.model")
@PropertySource({ "classpath:persistence.properties" })
@EnableJpaRepositories(repositoryFactoryBeanClass = DataTablesRepositoryFactoryBean.class, basePackages = "com.lonar.vendor.vendorportal.repository")
public class AppConfig {

	@Autowired
	private Environment env;

	@Bean
	public DataSource dataSource() {
		final DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("db.driver"));
		dataSource.setUsername(env.getProperty("db.username"));
		dataSource.setPassword(env.getProperty("db.password"));
		dataSource.setUrl(env.getProperty("db.url"));
		return dataSource;
	}

	@Bean
	public JavaMailSender getMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

		// mailSender.setHost("10.91.0.6");
		// mailSender.setPort(Integer.parseInt(env.getProperty("email.port").trim()));
		// mailSender.setPort(25);
		// mailSender.setUsername("vendorportal1@lonartech.com".trim());
		// mailSender.setPassword("Lonar@123456".trim());
		// email.port : 567

		mailSender.setHost(env.getProperty("email.host"));
		mailSender.setPort(587);
		mailSender.setUsername(env.getProperty("email.username").trim());
		mailSender.setPassword(env.getProperty("email.password").trim());

		// -------------------------aks 21-6---------------------------
		// mailSender.setPort(Optional.ofNullable(env.getProperty("email.port").trim()).map(Integer::valueOf).orElse(125));
		mailSender.setDefaultEncoding("UTF-8");

		// -----------------------------------------------------------
		Properties javaMailProperties = new Properties();

		javaMailProperties.put("mail.smtp.starttls.enable", "true");
		javaMailProperties.put("mail.smtp.auth", "true");
		javaMailProperties.put("mail.transport.protocol", "smtp");
		javaMailProperties.put("mail.debug", "false");
		javaMailProperties.put("mail.smtp.sendpartial", "true");

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
	}
}