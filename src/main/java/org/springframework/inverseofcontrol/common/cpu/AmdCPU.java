package org.springframework.inverseofcontrol.common.cpu;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



public class AmdCPU implements CPU {

    @Override
    public ExecutorService executor() {
        return Executors.newFixedThreadPool(4);
    }

    @Override
    public String toString() {
        return "AmdCPU";
    }
}
