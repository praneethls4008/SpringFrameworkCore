package org.springframework.inverseofcontrol.annotationbased.cpu;

import org.springframework.inverseofcontrol.common.cpu.CPU;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


//by default camelcase @Component("amdCpu")
@Component("Amd_CPU")
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
