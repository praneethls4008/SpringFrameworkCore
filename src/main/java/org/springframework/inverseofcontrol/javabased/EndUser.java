package org.springframework.inverseofcontrol.javabased;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EndUser {


    public static void main(String []args){

        AbstractApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);

        //used to register context shutdown, usually end on jvm shutdown
        applicationContext.registerShutdownHook();
        //        CPU cpu = (CPU) applicationContext.getBean("amdCpu");
//        Computer computer = new Computer(cpu);
//        computer.performTask();

        Computer computer = (Computer) applicationContext.getBean("computer");
        computer.performTask();

        //immediately shutdowns context, might throw IllegalStateException if used before
        //applicationContext.close();


    }
}
