package org.springframeworkcore.eventsHandling;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframeworkcore.eventsHandling.business.Admin;
import org.springframeworkcore.eventsHandling.business.User;
import org.springframeworkcore.eventsHandling.configuration.EventsConfig;

public class RunApp {
    public static void main(String[] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EventsConfig.class);
        context.registerShutdownHook();

        User user = (User) context.getBean("User");
        Admin admin = (Admin) context.getBean("Admin");

        user.setId("u1");
        user.setName("praneeth");

        admin.setId("a1");
        admin.setName("admin1");

        user.newMember();
        user.logIn();
        user.logOut();

        admin.newMember();
        admin.logIn();
        admin.logOut();

        context.close();


    }
}
