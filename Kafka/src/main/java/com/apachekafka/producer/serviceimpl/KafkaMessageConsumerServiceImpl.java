package com.apachekafka.producer.serviceimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.apachekafka.producer.service.KafkaMessageConsumerService;

@Service
public class KafkaMessageConsumerServiceImpl implements KafkaMessageConsumerService {

	public static final Logger LOGGER = LoggerFactory.getLogger(KafkaMessageConsumerServiceImpl.class);
	
	/**
	 * @implNote : by @kafkaListener annotation, subscribed the topics "newTopic"
	 * whenever any message produce on this topic, consumeMessage method consume 
	 * that message by the help of @kafkaListener annotation. 
	 * 
	 * @param newTopic to @kafkaListener , message.
	 * 
	 * **/
	@KafkaListener(topics = "newTopic" , groupId = "myGroup")
	@Override
	public void consumeMessage(String message) {
		// TODO Auto-generated method stub
		LOGGER.info("Message Received : "+message);
	}

}
