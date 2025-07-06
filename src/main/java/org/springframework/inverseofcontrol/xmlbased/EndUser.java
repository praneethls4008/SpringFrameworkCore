package org.springframework.inverseofcontrol.xmlbased;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EndUser {


    public static void main(String []args){

        //ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Computer computer = (Computer) applicationContext.getBean("computer");
        computer.performTask();
        computer.setRam("24GB");
        computer.setSpeaker("12V");
        System.out.println(computer.getRam());
        System.out.println(computer.getSpeaker());

        Computer computer2 = applicationContext.getBean(Computer.class);
        System.out.println(computer2.getRam());
        System.out.println(computer2.getSpeaker());
        applicationContext.registerShutdownHook();
    }
}
