package org.springframeworkcore.eventsHandling.listeners;

import org.springframework.context.event.*;
import org.springframework.stereotype.Component;

@Component
public class SpringContextListener {

    @EventListener
    public void contextStarted(ContextStartedEvent event){
        System.out.println("Spring Context Started");
    }

    @EventListener
    public void contextRefreshed(ContextRefreshedEvent event){
        System.out.println("Spring Context Refreshed");
    }

    @EventListener
    public void contextStopped(ContextStoppedEvent event){
        System.out.println("Spring Context Stopped");
    }

    @EventListener
    public void contextClosed(ContextClosedEvent event){
        System.out.println("Spring Context closed");
    }
}
