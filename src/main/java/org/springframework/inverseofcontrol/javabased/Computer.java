package org.springframework.inverseofcontrol.javabased;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.inverseofcontrol.common.cpu.CPU;
import org.springframework.inverseofcontrol.common.tasks.Tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Computer implements InitializingBean,DisposableBean {


    public CPU cpu;
    public ExecutorService taskManager;

    //init method after bean instantiated @postinit
    @Override
    public void afterPropertiesSet(){
        System.out.println("Inside afterPropertiesSet method");
    }

    //before destroying bean @predestroy
    @Override
    public void destroy(){
        System.out.println("Inside destroy method");
    }


    public Computer(CPU cpu){
        this.cpu = cpu;
        System.out.println("CPU used: " + this.cpu );
        this.taskManager = this.cpu.executor();
        
    }




    public void performTask(){
        List<Future<String>> futureTasks  = new ArrayList<>();

        //add tasks
        for(int i=1; i<=4; i++) {
            futureTasks.add(this.taskManager.submit(Tasks.createTask(i)));
        }


        //get tasks
        for(Future<String> future: futureTasks){
            String threadName = "";
            try{
                threadName = future.get(2, TimeUnit.SECONDS);
            } catch (TimeoutException e) {
                System.err.println(threadName +" time out (cancelling task)");
                future.cancel(true);
            } catch (Exception e) {

                e.printStackTrace();

            }
        }

        this.taskManager.shutdown();


    }




}
