package org.springframework.inverseofcontrol.common.cpu;

import java.util.concurrent.ExecutorService;

public interface CPU {

    //dependency
    public ExecutorService executor();

}
