package com.lonar.vendor.vendorportal.security;
import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.lonar.vendor.vendorportal.dao.UserDao;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ResourceServerFilter implements  javax.servlet.Filter{

	private static final String HEADER_AUTHORIZATION = "Authorization";
	private static final String projectName = "/UserManagement";
	 
	private UserDao userDao;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException { }

	@Override
	public void doFilter(ServletRequest httpServletRequest, ServletResponse httpResponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)httpServletRequest;
		final HttpServletResponse response = (HttpServletResponse) httpResponse;
		MutableHttpServletRequest mutableRequest = new MutableHttpServletRequest(request);
		
		if(userDao == null){
            ServletContext servletContext = request.getServletContext();
            WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
            userDao = webApplicationContext.getBean(UserDao.class);
        }
		
		String requestUri = request.getRequestURI();
	    try {
	    	if(!requestUri.equals(projectName+"/oauth/token") 
	    			&& !requestUri.equals(projectName+"/oauth/check_token") 
	    			&& !requestUri.equals(projectName+"/oauth/dologin") 
	    			&& !requestUri.equals(projectName+"/oauth/changePassword")
	    			&& !requestUri.equals(projectName+"/oauth/changePasswordUtility")
	    			&& !requestUri.equals(projectName+"/oauth/resetPassword")
	    			&& !requestUri.contains(projectName+"/oauth/emailValidater/")
	    			&& !requestUri.equals(projectName+"/oauth/changePasswordByReset")
	    			&& !requestUri.equals(projectName+"/oauth/tokenextend") ) { 
	    		
	    		
	    		String authToken = request.getHeader("access_token");
	    		//request.setAttribute(HEADER_AUTHORIZATION, authToken);
	    		
	    		
	    		mutableRequest.putHeader(HEADER_AUTHORIZATION, "Bearer "+authToken);
	    		AuthTokenInfo tokenTime =  userDao.getTokenTimeDifferance(authToken);
	    		if(tokenTime != null &&  tokenTime.getExpires_in() > 1800)  {
	    			response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid token.");
	    			return ;
	    		}else if(tokenTime != null && tokenTime.getExpires_in() > 18000 )  {
	    			chain.doFilter(mutableRequest, response);
				}else if(tokenTime == null) {
					tokenTime =  userDao.getOldTokenTimeDifferance(authToken);
					if(tokenTime != null && tokenTime.getExpires_in() < 100 ) {
						mutableRequest.putHeader(HEADER_AUTHORIZATION, "Bearer "+tokenTime.getAccess_token());
						response.setHeader("access_token", tokenTime.getAccess_token());
						chain.doFilter(mutableRequest, response);
					}else {
						response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid token.");
			            return ;			
					}
				}else {
					response.setHeader("access_token", authToken);
					chain.doFilter(mutableRequest, response);
				}
	    	}else {
	    		chain.doFilter(mutableRequest, response);
	    	}
	    	
        } catch (Exception e) {
        	e.printStackTrace();
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid token.");
            return ;
        }
	}
	
	private void setResponceToken(String token) {
		
		
	}
	
	

	@Override
	public void destroy() { }
	
}
