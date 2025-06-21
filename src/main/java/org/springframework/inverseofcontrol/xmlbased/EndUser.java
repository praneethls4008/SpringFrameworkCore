package org.springframework.inverseofcontrol.xmlbased;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EndUser {


    public static void main(String []args){

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Computer computer = (Computer) applicationContext.getBean("computer");
        computer.performTask();
    }
}
