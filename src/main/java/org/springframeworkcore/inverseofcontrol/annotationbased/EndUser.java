package org.springframeworkcore.inverseofcontrol.annotationbased;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Locale;

public class EndUser {


    public static void main(String []args){

        //ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ComponentConfiguration.class);
        //AbstractApplicationContext applicationContext = new AnnotationConfigApplicationContext(ComponentConfiguration.class);

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.getEnvironment().setActiveProfiles("prod");
        applicationContext.register(ComponentConfiguration.class);
        applicationContext.refresh();

        Computer computer = (Computer) applicationContext.getBean("Computer");
        computer.performTask();

        Environment env = applicationContext.getEnvironment();

        System.out.println(env.getProperty("message"));
        applicationContext.registerShutdownHook();


    }
}
