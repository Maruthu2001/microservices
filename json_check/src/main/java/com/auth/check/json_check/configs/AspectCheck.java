package com.auth.check.json_check.configs;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class AspectCheck {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    // Define a Pointcut that matches all public methods in the 'com.example.demo.service' package
    @org.aspectj.lang.annotation.Pointcut("execution(public * com.auth.check.json_check.controller.usercontroller.*.*(..))")
    public void applicationServiceMethods() {
        // This is an empty method used to define the pointcut
    }

    // @Before advice that runs before the methods matching the 'applicationServiceMethods' pointcut
    @Before("applicationServiceMethods()")
    public void logMethodEntry(JoinPoint joinPoint) {
        logger.info("Entering method: {} with arguments: {}",
                    joinPoint.getSignature().toShortString(), Arrays.toString(joinPoint.getArgs()));
    }

    // @AfterReturning advice that runs after a method matching the pointcut returns successfully
    @AfterReturning(pointcut = "applicationServiceMethods()", returning = "result")
    public void logMethodExit(JoinPoint joinPoint, Object result) {
        logger.info("Exiting method: {} with result: {}", joinPoint.getSignature().toShortString(), result);
    }

    // @Around advice that surrounds the execution of methods matching the pointcut
    @Around("applicationServiceMethods()")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed(); // Execute the original method
        long endTime = System.currentTimeMillis();
        logger.info("Method {} execution time: {} ms", joinPoint.getSignature().toShortString(), (endTime - startTime));
        return result;
    }

    // Example of @AfterThrowing advice (logs exceptions thrown by service methods)
    @org.aspectj.lang.annotation.AfterThrowing(pointcut = "applicationServiceMethods()", throwing = "e")
    public void logException(JoinPoint joinPoint, Throwable e) {
        logger.error("Exception in method {}: {}", joinPoint.getSignature().toShortString(), e.getMessage());
    }
}