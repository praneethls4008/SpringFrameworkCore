package org.springframework.inverseofcontrol;

import java.util.concurrent.ExecutorService;

public interface CPU {

    //dependency
    public ExecutorService executor();

}
