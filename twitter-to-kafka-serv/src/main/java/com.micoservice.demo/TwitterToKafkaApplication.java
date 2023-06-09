package com.micoservice.demo;

import com.micoservice.demo.runner.StreamRunner;
import com.microservice.demo.config.TwitterToKafkaApplicationConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

@SpringBootApplication
@ComponentScan(basePackages = "com.micoservice.demo")
public class TwitterToKafkaApplication implements CommandLineRunner {
    private static final Logger LOG = LoggerFactory.getLogger(TwitterToKafkaApplication.class);

    private TwitterToKafkaApplicationConfig twitterToKafkaApplicationConfig;

    private StreamRunner streamRunner;

    public TwitterToKafkaApplication(TwitterToKafkaApplicationConfig twitterToKafkaApplicationConfig, StreamRunner streamRunner) {
        this.twitterToKafkaApplicationConfig = twitterToKafkaApplicationConfig;
        this.streamRunner = streamRunner;
    }

    public static void main(String[] args) {
        SpringApplication.run(TwitterToKafkaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        LOG.info("App Start..........");
        LOG.info(Arrays.toString(twitterToKafkaApplicationConfig.getTwitterKeywords().toArray(new String[] {})));
        LOG.info(Arrays.toString(twitterToKafkaApplicationConfig.getWelcomeMessage().toArray(new String[] {})));
        streamRunner.start();
    }
}
