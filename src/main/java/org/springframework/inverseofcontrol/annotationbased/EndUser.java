package org.springframework.inverseofcontrol.annotationbased;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EndUser {


    public static void main(String []args){

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ComponentConfiguration.class);
        Computer computer = (Computer) applicationContext.getBean("Computer");
        computer.performTask();
    }
}
