package com.micoservice.demo.runner.impl;

import com.micoservice.demo.listner.TwitterKafkaStatusListner;
import com.micoservice.demo.runner.StreamRunner;
import com.microservice.demo.config.TwitterToKafkaApplicationConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import twitter4j.TwitterException;

import java.util.Random;
@Component
public class MockKafkaStreamRunner implements StreamRunner {

    private static final Logger LOG = LoggerFactory.getLogger(TwitterKafkaStreamRunner.class);

    private TwitterToKafkaApplicationConfig twitterToKafkaApplicationConfig;

    private TwitterKafkaStatusListner twitterKafkaStatusListner;


    private static final Random RANDOM = new Random();

    private static final String [] WORDS = new String[] {
            "Lorem",
            "dolor",
            "massa",
            "libero"
    };



//    public MockKafkaStreamRunner(TwitterKafkaStatusListner twitterKafkaStatusListner, TwitterToKafkaApplicationConfig twitterToKafkaApplicationConfig) {
//        this.twitterKafkaStatusListner = twitterKafkaStatusListner;
//        this.twitterToKafkaApplicationConfig = twitterToKafkaApplicationConfig;
//    }

    @Override
    public void start() throws TwitterException {

    }
}
