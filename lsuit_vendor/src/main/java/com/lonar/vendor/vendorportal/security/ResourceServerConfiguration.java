package com.lonar.vendor.vendorportal.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;


@Configuration
@EnableResourceServer
@EnableWebSecurity
public class ResourceServerConfiguration  extends ResourceServerConfigurerAdapter{

	   @Autowired
	   private UserDetailsService userDetailsService;
	   
	   
	  
	
	  /*  @Value("${signing-key:oui214hmui23o4hm1pui3o2hp4m1o3h2m1o43}")
	    private String signingKey;*/

	    public ResourceServerConfiguration() {
	        super();
	    }
	    
	   
	    // global security concerns

	    @Bean
	    public AuthenticationProvider authProvider() {
	        final DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	        authProvider.setUserDetailsService(userDetailsService);
	        authProvider.setPasswordEncoder(passwordEncoder());
	        return authProvider;
	    }

	    @Autowired
	    public void configureGlobal(final AuthenticationManagerBuilder auth) {
	        auth.authenticationProvider(authProvider());
	    }
	    
	    @Override
	    public void configure(final HttpSecurity http) throws Exception {
	    	 http
	         .exceptionHandling()
	         	  //.and().addFilterBefore(new ResourceServerFilter(), BasicAuthenticationFilter.class)
	         	  .and()
	             .authorizeRequests()
	             .antMatchers("/oauth/**").permitAll()
	             .antMatchers("/API/**").permitAll()
	             .antMatchers("/**").permitAll()
	             .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	             .and()//
	             .csrf().disable();
	    }
	    
	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new PasswordEncoder() {
	            @Override
	            public String encode(CharSequence rawPassword) {
	                return rawPassword.toString();
	            }
	            @Override
	            public boolean matches(CharSequence rawPassword, String encodedPassword) {
	                //return rawPassword.toString().equals(encodedPassword);
	                return true;
	            }
	        };
	    }
}
