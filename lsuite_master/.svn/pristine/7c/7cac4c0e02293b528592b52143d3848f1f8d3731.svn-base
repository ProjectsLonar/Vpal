package com.lonar.vendor.vendorportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.datatables.repository.DataTablesRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.lonar.vendor.vendorportal.config.AppConfig;
import com.lonar.vendor.vendorportal.security.AuthorizationServerConfiguration;
import com.lonar.vendor.vendorportal.security.ResourceServerConfiguration;


@SpringBootApplication
@ComponentScan("com.lonar.vendor.vendorportal")
@EnableJpaRepositories(repositoryFactoryBeanClass = DataTablesRepositoryFactoryBean.class)
public class VendorportalApplication extends SpringBootServletInitializer {
	
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(new Class[] { VendorportalApplication.class,  AppConfig.class });
    	// return application.sources( VendorportalApplication.class);
    }
	
	public static void main(String[] args) {
		/*SpringApplication.run(new Class[] {VendorportalApplication.class
				 },
				args);*/
		
		SpringApplication.run(new Class[] {VendorportalApplication.class,
				AuthorizationServerConfiguration.class,
				ResourceServerConfiguration.class },
				args);
		//SpringApplication.run(new Class[] { VendorportalApplication.class,  AppConfig.class });
	}
	

}

