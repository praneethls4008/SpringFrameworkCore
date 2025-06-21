package org.springframework.inverseofcontrol.javabased;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EndUser {


    public static void main(String []args){

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);
//        CPU cpu = (CPU) applicationContext.getBean("amdCpu");
//        Computer computer = new Computer(cpu);
//        computer.performTask();

        Computer computer = (Computer) applicationContext.getBean("computer");
        computer.performTask();
    }
}
