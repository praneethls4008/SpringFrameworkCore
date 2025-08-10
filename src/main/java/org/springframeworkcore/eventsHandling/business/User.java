package org.springframeworkcore.eventsHandling.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframeworkcore.eventsHandling.events.LoggedInEvent;
import org.springframeworkcore.eventsHandling.events.LoggedOutEvent;
import org.springframeworkcore.eventsHandling.events.NewMemberEvent;
import org.springframework.stereotype.Component;

@Component("User")
public class User {
    String name;
    String id;
    LoggedInEvent loggedInEvent;
    LoggedOutEvent loggedOutEvent;
    NewMemberEvent newMemberEvent;

    ApplicationEventPublisher eventPublisher;

    public User(){}

    @Autowired
    public User(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
        System.out.println("Autowired ApplicationEventPublisher in user");

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
        System.out.println("Logged In Event Published By User: {name: " + name + ", id: " + id + "}");
        eventPublisher.publishEvent(new LoggedInEvent(this, this.name, this.id));
    }
    public void logOut(){
        System.out.println("Logged Out Event Published By User: {name: " + name + ", id: " + id + "}");
        eventPublisher.publishEvent(new LoggedOutEvent(this, this.name, this.id));
    }
    public void newMember(){
        System.out.println("New Memeber Event Published By User: {name: " + name + ", id: " + id + "}");
        eventPublisher.publishEvent(new NewMemberEvent(this, this.name, this.id));
    }
}
