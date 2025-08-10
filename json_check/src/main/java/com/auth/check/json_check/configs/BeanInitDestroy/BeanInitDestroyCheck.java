package com.auth.check.json_check.configs.BeanInitDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanInitDestroyCheck implements InitializingBean, DisposableBean {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private ApplicationContext applicationContext;

    @Bean(initMethod = "initMethodCheck", destroyMethod = "destroyMethodCheck")
    public DummyBeanClass DummyBeanClass() {
        logger.info("Bean Name...... {}", applicationContext.getBean(BeanInitDestroyCheck.class).getClass().getSimpleName());
        return new DummyBeanClass();
    }
    
    @Override //Destroy
    public void destroy() throws Exception {
        logger.info("Destroy Bean Method called using disposable bean interface");        
    }

    @Override //Initializing
    public void afterPropertiesSet() throws Exception {
        logger.info("AfterPropertiesSet Bean Method called using initializing bean interface");
    }
   
}
