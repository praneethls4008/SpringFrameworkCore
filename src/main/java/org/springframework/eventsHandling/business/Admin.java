package org.springframework.eventsHandling.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.eventsHandling.events.LoggedInEvent;
import org.springframework.eventsHandling.events.LoggedOutEvent;
import org.springframework.eventsHandling.events.NewMemberEvent;
import org.springframework.stereotype.Component;

@Component("Admin")
public class Admin {
    String name;
    String id;

    ApplicationEventPublisher eventPublisher;

    public Admin(){}

    @Autowired
    public Admin(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
        System.out.println("Autowired ApplicationEventPublisher in admin");

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void logIn(){
        System.out.println("Logged In Event Published By Admin: {name: " + name + ", id: " + id + "}");
        eventPublisher.publishEvent(new LoggedInEvent(this, this.name, this.id));
    }
    public void logOut(){
        System.out.println("Logged Out Event Published By Admin: {name: " + name + ", id: " + id + "}");
        eventPublisher.publishEvent(new LoggedOutEvent(this, this.name, this.id));
    }
    public void newMember(){
        System.out.println("New Memeber Event Published By Admin: {name: " + name + ", id: " + id + "}");
        eventPublisher.publishEvent(new NewMemberEvent(this, this.name, this.id));
    }


}


