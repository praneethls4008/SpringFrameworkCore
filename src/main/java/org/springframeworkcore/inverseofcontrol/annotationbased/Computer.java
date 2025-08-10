package org.springframeworkcore.inverseofcontrol.annotationbased;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframeworkcore.inverseofcontrol.common.cpu.CPU;
import org.springframeworkcore.inverseofcontrol.common.tasks.Tasks;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

//by default camelcase @Component("computer")
@Component("Computer")
public class Computer {


    public CPU cpu;
    public ExecutorService taskManager;

    @PostConstruct
    public void postConstruct(){
        System.out.println("Inside PostConstruct method");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("Inside Pre destroy method");
    }

    //@Autowired
    public Computer(@Value("${cpu.bean.name}") String cpu, ApplicationContext context){
        this.cpu = (CPU) context.getBean(cpu);
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
