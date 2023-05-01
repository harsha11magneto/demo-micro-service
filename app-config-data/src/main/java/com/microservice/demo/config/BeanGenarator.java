package com.microservice.demo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanGenarator {

    @Bean(name = "mybean")
    public TwitterToKafkaApplicationConfig getTwitterToKafkaApplicationConfigBean(){
        return new TwitterToKafkaApplicationConfig();
    }
}
