package com.auth.check.json_check.service.eventservicelistener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.auth.check.json_check.service.customevent.CustomEvent;

@Component
public class EventServiceListner {

    private static final Logger logger = LoggerFactory.getLogger(EventServiceListner.class);

    @EventListener
    public void getAndSetEvents(CustomEvent ce) {
        logger.info("Event Name : -> {}", ce.getEventName());
    }
}
