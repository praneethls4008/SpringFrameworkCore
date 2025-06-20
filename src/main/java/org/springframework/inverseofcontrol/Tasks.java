package org.springframework.inverseofcontrol;

import java.util.concurrent.Callable;

public class Tasks {

    public static Callable<String> createTask(int taskNo){
        return ()->{
            String currentThreadName = "Task "+taskNo;
            Thread.currentThread().setName(currentThreadName);

            System.out.println(currentThreadName + " started");

            try{
                Thread.sleep(9000);
            }catch (InterruptedException ie){
                System.out.println(currentThreadName + " interrupted");
                Thread.currentThread().interrupt();
            }

            System.out.println(currentThreadName + " completed");

            return currentThreadName;
        };
    }
}
