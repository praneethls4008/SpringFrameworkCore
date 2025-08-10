package org.springframeworkcore.inverseofcontrol.annotationbased;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

@Configuration
//@PropertySource("application.propertiesw")
@ComponentScan(basePackages = "org/springframework/inverseofcontrol/annotationbased")
public class ComponentConfiguration {

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties(Environment env) throws IOException {
        String profile = env.getActiveProfiles().length > 0 ? env.getActiveProfiles()[0] : "qa";
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        configurer.setLocation(new ClassPathResource("application-" + profile + ".properties"));
        return configurer;
    }

}
