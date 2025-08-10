package com.app1.app1.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.app1.app1.dtos.User;
import com.app1.app1.dtos.UserDto;
import com.app1.app1.service.CacheService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class App1Controller {

    /**
     * Using Rest Template
     * 
     */
    @Autowired
    RestTemplate restTemplate;
    
    @Autowired
    CacheService cacheService;

    @RequestMapping(path = "/getApp1Name", method = RequestMethod.GET)
    public String app1Name() {
        String app2Name = restTemplate.getForObject("http://APP2", String.class);
        return "App1Controller ".concat(app2Name);
    }

    /**
     * Using Web client
     * 
     * 
     */
    private WebClient webClient;

    public App1Controller(@LoadBalanced WebClient.Builder builder) {
        webClient = builder.baseUrl("http://APP2").build();
        User user = new User("Dinesh", "dineshal"); 
        
        ModelMapper mapper = new ModelMapper();
        UserDto dto = mapper.map(user, UserDto.class);
        System.out.println(dto.getUser());
        System.out.println(dto.getUserid());

    }

    @RequestMapping(path = "/getApp1NameWithClient", method = RequestMethod.GET)
    public String app1NameWithClient() {
        String app2Name = webClient.get().uri("/getApp2Name").retrieve().bodyToMono(String.class)
                .map(mapper -> "App2Name " + mapper).block();
        return "App1Controller ".concat(app2Name);
    }
    
    @RequestMapping(path = "/cacheServ", method = RequestMethod.GET)
    public void setCacheService() {
    	cacheService.putValue("Dinesh", "Hai this is Dinesh", 30000);
    }
    
    @RequestMapping(path = "/cacheServe", method = RequestMethod.GET)
    public void getCacheService() {
    	Object obj = cacheService.getValue("Dinesh", Object.class);
    	log.info("Cache Value >>>>>> {}", obj);   	
    }
}
