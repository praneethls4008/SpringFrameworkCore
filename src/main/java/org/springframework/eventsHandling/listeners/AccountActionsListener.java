package org.springframework.eventsHandling.listeners;

import org.springframework.context.event.EventListener;
import org.springframework.eventsHandling.events.LoggedInEvent;
import org.springframework.eventsHandling.events.LoggedOutEvent;
import org.springframework.eventsHandling.events.NewMemberEvent;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;


@Component
public class AccountActionsListener {

    @Async("asyncExecutor")
    @EventListener
    public void memeberLoggedIn(LoggedInEvent event){
        System.out.println("Logged In Event listened by "+ event.getSource().getClass().getSimpleName() + " : {name: " + event.getName() + ", id: " + event.getId() + "}");
    }

    @Async("asyncExecutor")
    @EventListener
    public void memeberLoggedOut(LoggedOutEvent event){
        System.out.println("Logged Out Event listened by "+ event.getSource().getClass().getSimpleName() + " : {name: " + event.getName() + ", id: " + event.getId() + "}");
    }

    @Async("asyncExecutor")
    @EventListener
    public void newMemeberEvent(NewMemberEvent event){
        System.out.println("New Member Event listened by "+ event.getSource().getClass().getSimpleName() + " : {name: " + event.getName() + ", id: " + event.getId() + "}");
    }
}
