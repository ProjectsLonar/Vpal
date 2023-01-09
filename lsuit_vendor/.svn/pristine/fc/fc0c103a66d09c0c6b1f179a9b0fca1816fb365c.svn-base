package com.lonar.vendor.vendorportal.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.lonar.vendor.vendorportal")
@EnableJpaRepositories("com.lonar.vendor.vendorportal.repository")
@Configuration
@PropertySource({ "classpath:persistence.properties" })
//@EnableResourceServer
public class OAuth2ResourceServerConfig /*extends ResourceServerConfigurerAdapter*/ {

    @Autowired
    private Environment env;

   /* @Override
    public void configure(final HttpSecurity http) throws Exception {
        // @formatter:off
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
		    .and()
		    .authorizeRequests().anyRequest().permitAll();
	// @formatter:on		
    }

    @Override
    public void configure(final ResourceServerSecurityConfigurer config) {
        config.tokenServices(tokenServices());
    }    
    
    @Bean
    @Primary
    public DefaultTokenServices tokenServices() {
        final DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        defaultTokenServices.setTokenStore(tokenStore());
        return defaultTokenServices;
    }

    @Bean
    public TokenStore tokenStore() {
        return new JdbcTokenStore(dataSource());
    }*/
    // JDBC token store configuration

    /*@Bean
    public DataSource dataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
        dataSource.setUrl(env.getProperty("jdbc.url"));
        dataSource.setUsername(env.getProperty("jdbc.user"));
        dataSource.setPassword(env.getProperty("jdbc.pass"));
        return dataSource;
    }*/


    
}
