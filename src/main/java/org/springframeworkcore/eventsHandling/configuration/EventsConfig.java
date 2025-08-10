package org.springframeworkcore.eventsHandling.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

@EnableAsync
@Configuration
@ComponentScan(basePackages = "org/springframeworkcore/eventsHandling")
public class EventsConfig {

    @Bean(name="asyncExecutor")
    public Executor executor(){

        int cores = Runtime.getRuntime().availableProcessors();
        int corePoolSize = cores;
        int maxPoolSize = cores*2;
        int queueCapacity = 500;

        System.out.println("Available cores: "+ cores);
        System.out.println("Core Pool Size: "+ corePoolSize);
        System.out.println("Max Pool Size: "+ maxPoolSize);

        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setThreadNamePrefix("cpuAwareAsync-");

//        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
//        executor.setWaitForTasksToCompleteOnShutdown(true);
//        executor.setAwaitTerminationSeconds(30);

        executor.initialize();
        return executor;
    }
}
