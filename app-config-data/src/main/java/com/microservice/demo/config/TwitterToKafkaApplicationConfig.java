package com.microservice.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "twitter-to-kafka-serv")
public class TwitterToKafkaApplicationConfig {
    private List<String> twitterKeywords;

    public List<String> getTwitterKeywords() {
        return twitterKeywords;
    }

    public void setTwitterKeywords(List<String> twitterKeywords) {
        this.twitterKeywords = twitterKeywords;
    }

    private List<String> welcomeMessage;

    public List<String> getWelcomeMessage() {
        return welcomeMessage;
    }

    public void setWelcomeMessage(List<String> welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
    }

}
