package com.auth.check.json_check.configs.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.auth.check.json_check.security.exception.AuthEntryPointJwt;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HandlerIntercept implements HandlerInterceptor {
    
    private static final Logger logger = LoggerFactory.getLogger(AuthEntryPointJwt.class);
    
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handObject) throws Exception {
        logger.info("Pre Handle Methods called!!!...");
        return true;
    }
    
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handObject, ModelAndView modelAndView) throws Exception {
        logger.info("Post Handle Methods called!!!...");       
    }
    

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handObject, Exception ex) throws Exception {        
        logger.info("After Completion Methods called!!!...");       
    }
}
