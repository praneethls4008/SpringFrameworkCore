package org.springframework.eventsHandling.events;

import org.springframework.context.ApplicationEvent;


public class LoggedInEvent extends ApplicationEvent {

    String name;
    String id;

    public LoggedInEvent(Object eventStartedBy, String name, String id){
        super(eventStartedBy);
        this.name = name;
        this.id = id;
        System.out.println("Logged In Event invoked by "+ eventStartedBy.getClass().getSimpleName() + " : {name: " + name + ", id: " + id + "}");
    }


    public String getName() { return this.name; }
    public String getId() { return this.id; }
}
