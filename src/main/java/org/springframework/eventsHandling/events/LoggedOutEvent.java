package org.springframework.eventsHandling.events;

import org.springframework.context.ApplicationEvent;

public class LoggedOutEvent extends ApplicationEvent {

    String name;
    String id;

    public LoggedOutEvent(Object eventStartedBy, String name, String id){
        super(eventStartedBy);
        this.name = name;
        this.id = id;
        System.out.println("Logged Out Event invoked "+ eventStartedBy.getClass().getSimpleName() + " : {name: " + name + ", id: " + id + "}");
    }

    public String getName() { return this.name; }
    public String getId() { return this.id; }
}
