package com.micoservice.demo.runner.impl;

import com.micoservice.demo.listner.TwitterKafkaStatusListner;
import com.micoservice.demo.runner.StreamRunner;
import com.microservice.demo.config.TwitterToKafkaApplicationConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import twitter4j.FilterQuery;
import twitter4j.TwitterException;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;

import javax.annotation.PreDestroy;
import java.util.Arrays;


@Component
public class TwitterKafkaStreamRunner implements StreamRunner {

    private static final Logger LOG = LoggerFactory.getLogger(TwitterKafkaStreamRunner.class);

    private TwitterKafkaStatusListner twitterKafkaStatusListner;

//    @Qualifier("mybean")
//    @Autowired
    private TwitterToKafkaApplicationConfig twitterToKafkaApplicationConfig;


    public TwitterKafkaStreamRunner(TwitterKafkaStatusListner twitterKafkaStatusListner, TwitterToKafkaApplicationConfig twitterToKafkaApplicationConfig) {
        this.twitterKafkaStatusListner = twitterKafkaStatusListner;
        this.twitterToKafkaApplicationConfig = twitterToKafkaApplicationConfig;
    }

    private TwitterStream twitterStream;

    @Override
    public void start() throws TwitterException {
        twitterStream =  new TwitterStreamFactory().getInstance();
        twitterStream.addListener(twitterKafkaStatusListner);
        addFilter();
    }

    @PreDestroy
    public void shutdown(){
        if(twitterStream != null){
            twitterStream.shutdown();
        }
    }

    private void addFilter() {
        String [] keywords = twitterToKafkaApplicationConfig.getTwitterKeywords().toArray(new String[0]);
        FilterQuery filterQuery = new FilterQuery(keywords);
        twitterStream.filter(filterQuery);
        LOG.info("Started filtrting the keywords ........ {}", Arrays.toString(keywords));
    }

}
