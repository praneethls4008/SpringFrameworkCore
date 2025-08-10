package org.springframeworkcore.inverseofcontrol.javabased;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframeworkcore.inverseofcontrol.common.cpu.AmdCPU;
import org.springframeworkcore.inverseofcontrol.common.cpu.CPU;
import org.springframeworkcore.inverseofcontrol.common.cpu.IntelCPU;

@Configuration
public class BeanConfiguration {

    @Bean
    public AmdCPU amdCpu(){
        return new AmdCPU();
    }

    @Bean
    public IntelCPU intelCpu(){
        return new IntelCPU();
    }

    @Bean
    public Computer computer(@Qualifier("amdCpu") CPU cpu){
        return new Computer(cpu);
    }
}
