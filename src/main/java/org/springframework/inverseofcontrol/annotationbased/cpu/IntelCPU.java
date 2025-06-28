package org.springframework.inverseofcontrol.annotationbased.cpu;

import org.springframework.context.annotation.Lazy;
import org.springframework.inverseofcontrol.common.cpu.CPU;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//by default camelcase @Component("intelCpu")
@Component("Intel_CPU")
@Lazy
public class IntelCPU implements CPU {

    @Override
    public ExecutorService executor() {
        return Executors.newFixedThreadPool(2);
    }

    @Override
    public String toString() {
        return "IntelCPU";
    }

}
