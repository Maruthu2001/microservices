package com.auth.check.json_check.configs.BeanInitDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DummyBeanClass {

    private final Logger logger = LoggerFactory.getLogger(this.getClass()); 
    
    public void initMethodCheck() {
        logger.info("Init Bean Destroy Method called using bean inMethod");
    }
    
    public void destroyMethodCheck() {
        logger.info("After Bean Destroy Method called using bean destroyMethod");
    }
}
