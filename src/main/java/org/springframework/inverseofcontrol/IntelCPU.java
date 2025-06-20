package org.springframework.inverseofcontrol;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class IntelCPU implements CPU {

    @Override
    public ExecutorService executor() {
        return Executors.newFixedThreadPool(2);
    }
}
