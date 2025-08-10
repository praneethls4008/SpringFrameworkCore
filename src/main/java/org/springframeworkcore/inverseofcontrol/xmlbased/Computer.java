package org.springframeworkcore.inverseofcontrol.xmlbased;

import org.springframeworkcore.inverseofcontrol.common.cpu.CPU;
import org.springframeworkcore.inverseofcontrol.common.tasks.Tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Computer {

    public String gpu;
    public String ram;
    public String speaker;

    public CPU cpu;
    public ExecutorService taskManager;


    public void init(){
        System.out.println("xmlBased init method");
    }

    public void destroy(){
        System.out.println("xmlBased destroy method");
    }

    public Computer(CPU cpu, String gpu, String ram, String speaker) {
        this.cpu = cpu;
        this.gpu = gpu;
        this.ram = ram;
        this.speaker = speaker;
        System.out.println("CPU used: " + this.cpu );
        this.taskManager = this.cpu.executor();

    }

    public Computer(CPU cpu){
        this.cpu = cpu;
        System.out.println("CPU used: " + this.cpu );
        this.taskManager = this.cpu.executor();
        
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
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
