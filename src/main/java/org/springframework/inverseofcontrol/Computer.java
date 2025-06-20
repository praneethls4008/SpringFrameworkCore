package org.springframework.inverseofcontrol;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Computer {

    public CPU cpu;
    public ExecutorService taskManager;
    
    public Computer(){
        this.cpu = new AmdCPU();
        //CPU cpu = new IntelCPU();
        this.taskManager = this.cpu.executor();
        
    }




    public void performTask(){
        List<Future<String>> futureTasks  = new ArrayList<>();

        //add tasks
        for(int i=1; i<=10; i++) {
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
