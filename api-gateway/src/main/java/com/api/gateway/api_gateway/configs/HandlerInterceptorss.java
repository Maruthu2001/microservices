package com.api.gateway.api_gateway.configs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HandlerInterceptorss implements HandlerInterceptor {

	Logger log = LoggerFactory.getLogger(HandlerInterceptorss.class);
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.info("Api gateway called");
		return true;
	}
	
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handObject, ModelAndView modelAndView) throws Exception {
        log.info("Post Handle Methods called!!!...");       
    }
    

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handObject, Exception ex) throws Exception {        
        log.info("After Completion Methods called!!!...");       
    }
}
