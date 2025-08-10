package org.springframeworkcore.eventsHandling.events;

import org.springframework.context.ApplicationEvent;

public class NewMemberEvent extends ApplicationEvent {
    String name;
    String id;

    public NewMemberEvent(Object eventStartedBy, String name, String id){
        super(eventStartedBy);
        this.name = name;
        this.id = id;
        System.out.println("New Meneber Event invoked "+ eventStartedBy.getClass().getSimpleName() +" : {name: " + name + ", id: " + id + "}");
    }

    public String getName() { return this.name; }
    public String getId() { return this.id; }
}
