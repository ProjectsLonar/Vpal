package com.lonar.vendor.vendorportal.config;


import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.datatables.repository.DataTablesRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@EntityScan("com.lonar.vendor.vendorportal")
@PropertySource({ "classpath:persistence.properties" })
@EnableJpaRepositories(repositoryFactoryBeanClass = DataTablesRepositoryFactoryBean.class, basePackages = "com.lonar.vendor.vendorportal.repository")
public class AppConfig {

    @Autowired
    private Environment env;
	
	@Autowired
	private LocalContainerEntityManagerFactoryBean entityManagerFactory;
	
    
	@Bean
  	public DataSource dataSource() {
		
		final DriverManagerDataSource dataSource = new DriverManagerDataSource();
	      dataSource.setDriverClassName(env.getProperty("db.driver"));
	      dataSource.setUrl(env.getProperty("db.url"));
	      dataSource.setUsername(env.getProperty("db.username"));
	      dataSource.setPassword(env.getProperty("db.password"));
	      return dataSource;
		
  		//org.apache.tomcat.jdbc.pool.DataSource dataSource = new org.apache.tomcat.jdbc.pool.DataSource();
	/*	org.apache.tomcat.jdbc.pool.DataSource dataSource = new org.apache.tomcat.jdbc.pool.DataSource();
		
  		PoolProperties properties = new PoolProperties();
  		properties.setUrl(env.getProperty("db.url"));
  		properties.setDriverClassName(env.getProperty("db.driver"));
  		properties.setInitSQL("ALTER SESSION SET CURRENT_SCHEMA = " + env.getProperty("db.schema"));
  		properties.setUsername(env.getProperty("db.username"));
  		//properties.setPassword(decrypt(env.getProperty("db.password")));
  		properties.setPassword(env.getProperty("db.password"));
  		properties.setJmxEnabled(true);
  		properties.setTestWhileIdle(false);
  		properties.setTestOnBorrow(true);
  		properties.setValidationQuery("select 1 from dual");
  		properties.setTestOnReturn(false);
  		properties.setValidationInterval(30000);
  		properties.setTimeBetweenEvictionRunsMillis(30000);
  		properties.setMaxActive(100);
  		properties.setInitialSize(10);
  		properties.setMaxWait(10000);
  		properties.setRemoveAbandonedTimeout(60);
  		properties.setMinEvictableIdleTimeMillis(30000);
  		properties.setMinIdle(10);
  		properties.setLogAbandoned(true);
  		properties.setRemoveAbandoned(true);
  		properties.setJdbcInterceptors("org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;"
  				+ "org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer");
  		dataSource.setPoolProperties(properties);
  		return dataSource;*/
  	}
    
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();

		entityManagerFactory.setDataSource(dataSource());

		// Classpath scanning of @Component, @Service, etc annotated class
		entityManagerFactory.setPackagesToScan(env.getProperty("entitymanager.packagesToScan"));

		// Vendor adapter
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		entityManagerFactory.setJpaVendorAdapter(vendorAdapter);

		// Hibernate properties
		Properties additionalProperties = new Properties();
		additionalProperties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
		additionalProperties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		additionalProperties.put("hibernate.show_sql", false);
		additionalProperties.put("hibernate.hbm2ddl.auto","none"); // env.getProperty("hibernate.hbm2ddl.auto")

		entityManagerFactory.setJpaProperties(additionalProperties);

		return entityManagerFactory;
	}

	/**
	 * Declare the transaction manager.
	 */
	@Bean
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory.getObject());
		return transactionManager;
	}

	/**
	 * PersistenceExceptionTranslationPostProcessor is a bean post processor
	 * which adds an advisor to any bean annotated with Repository so that any
	 * platform-specific exceptions are caught and then rethrown as one Spring's
	 * unchecked data access exceptions (i.e. a subclass of
	 * DataAccessException).
	 */
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
	
	
	
	
}
