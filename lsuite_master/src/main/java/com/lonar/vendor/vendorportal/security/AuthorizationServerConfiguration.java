package com.lonar.vendor.vendorportal.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import com.lonar.vendor.vendorportal.service.MyUserDetailsService;

@Configuration
@EnableAuthorizationServer
@PropertySource({ "classpath:persistence.properties" })
public class AuthorizationServerConfiguration extends  AuthorizationServerConfigurerAdapter {
	
/*	@Autowired
	private Environment env;*/
	
	 @Autowired
	 private DataSource dataSource;
	 
	@Autowired
	private AuthenticationManager authenticationManager;
	
	//private UserDetailsService userDetailsService;
	
	@Autowired
	private MyUserDetailsService userDetailsService;
	
	
   
	public AuthorizationServerConfiguration() {
		super();
	}
	
	/* @Value("${signing-key:oui214hmui23o4hm1pui3o2hp4m1o3h2m1o43}")
	private String signingKey;*/
	
	/*public JwtAccessTokenConverter accessTokenConverter(){
		final JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter();
		accessTokenConverter.setSigningKey(signingKey);
		return accessTokenConverter;
	}*/ //JWT
	 
	@Bean
	public TokenStore tokenStore() {
		//return new InMemoryTokenStore();
		//return new JwtTokenStore(accessTokenConverter());//JWT
		return new JdbcTokenStore(dataSource);
	}
	
	@Bean
	@Primary
	public DefaultTokenServices tokenService() {
		final DefaultTokenServices tokenServices = new DefaultTokenServices();
		tokenServices.setTokenStore(tokenStore());
		tokenServices.setSupportRefreshToken(true);
		return tokenServices;
	}
	
	/*@Bean
	@Primary
	public DataSource dataSource() {
		org.apache.tomcat.jdbc.pool.DataSource dataSource = new org.apache.tomcat.jdbc.pool.DataSource();
	
		PoolProperties properties = new PoolProperties();
		properties.setUrl(env.getProperty("db.url"));
		properties.setDriverClassName(env.getProperty("db.driver"));
		//properties.setInitSQL("ALTER SESSION SET CURRENT_SCHEMA = " + env.getProperty("db.schema"));
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
		properties.setMaxActive(300); //no of db connection
		properties.setInitialSize(10); 
		properties.setMaxWait(10000);
		properties.setRemoveAbandonedTimeout(300);
		properties.setMinEvictableIdleTimeMillis(30000); 
		properties.setMinIdle(5);// query time
		properties.setLogAbandoned(true);
		properties.setRemoveAbandoned(true);
		//properties.setMaxActive(30000);
		properties.setJdbcInterceptors("org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;"
		+ "org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer");
		dataSource.setPoolProperties(properties);
		return dataSource;

	}*/
	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		/*clients.inMemory()
		   .withClient("live-test")
		   .secret("bGl2ZS10ZXN0")
		   .authorizedGrantTypes("password", "refresh_token")
		   .refreshTokenValiditySeconds(3600 * 24)
		   .scopes("um-webapp")
		   //.autoApprove("um-webapp")
		   .accessTokenValiditySeconds(50);*/
		clients.jdbc(dataSource);
	}
	
	@Override
	public void configure(final AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.tokenStore(tokenStore())
			.authenticationManager(authenticationManager)
			.userDetailsService(userDetailsService)
			.allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST);
			//.accessTokenConverter(accessTokenConverter()); //JWT
	}
	
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.checkTokenAccess("permitAll()");
		super.configure(security);
	}
	
}
