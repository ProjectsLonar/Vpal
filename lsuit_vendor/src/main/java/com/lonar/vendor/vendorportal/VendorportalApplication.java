package com.lonar.vendor.vendorportal;

import org.apache.coyote.http11.AbstractHttp11Protocol;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.datatables.repository.DataTablesRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.lonar.vendor.vendorportal.common.AppConfig;
import com.lonar.vendor.vendorportal.model.FileStorageProperties;

@SpringBootApplication(exclude = { ErrorMvcAutoConfiguration.class })
@EnableConfigurationProperties({ FileStorageProperties.class })
@ComponentScan("com.lonar.vendor.vendorportal")
@EnableJpaRepositories(repositoryFactoryBeanClass = DataTablesRepositoryFactoryBean.class)
public class VendorportalApplication extends SpringBootServletInitializer {

/*	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		//return application.sources(VendorportalApplication.class);
		return application.sources(new Class[] { VendorportalApplication.class,  AppConfig.class });
	}

	public static void main(String[] args) {
		//SpringApplication.run(new Class[] { VendorportalApplication.class, AppConfig.class }, args);
		SpringApplication.run(VendorportalApplication.class, args);
	}*/
	
	 @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(new Class[] { VendorportalApplication.class,  AppConfig.class });
	    	// return application.sources( VendorportalApplication.class);
	    }
		
		public static void main(String[] args) {
			SpringApplication.run(VendorportalApplication.class, args);
			//SpringApplication.run(new Class[] { VendorportalApplication.class,  AppConfig.class });
		}
		
		
		//Tomcat large file upload connection reset
	    //http://www.mkyong.com/spring/spring-file-upload-and-connection-reset-issue/
	    @Bean
		public TomcatEmbeddedServletContainerFactory tomcatEmbedded() {
			TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();
			tomcat.addConnectorCustomizers((TomcatConnectorCustomizer) connector -> {
				if ((connector.getProtocolHandler() instanceof AbstractHttp11Protocol<?>)) {
					// -1 means unlimited
					((AbstractHttp11Protocol<?>) connector.getProtocolHandler()).setMaxSwallowSize(-1);
				}
			});
			return tomcat;
		}

}

