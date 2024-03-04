package com.apachekafka.topic.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;



@Configuration
public class KapkaTopicConfig {

	/**
	 * @implNote : creating kafka topics here and it's only accept MAX 249 character for topic name.
	 * @param : TopicName
	 * 
	 * **/
    @Bean
    public NewTopic topicConfig1() {
		return  TopicBuilder.name("newTopic").build();
	}
    
	/**
	 * @implNote : creating kafka topics here for JSON and it's only accept MAX 249 character for topic name.
	 * @param : TopicName
	 * 
	 * **/
    @Bean
    public NewTopic topicConfig2() {
		return  TopicBuilder.name("newJSONTopic").build();
	}
}
