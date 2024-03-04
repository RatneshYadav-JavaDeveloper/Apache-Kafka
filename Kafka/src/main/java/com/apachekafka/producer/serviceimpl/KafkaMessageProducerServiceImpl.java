package com.apachekafka.producer.serviceimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.apachekafka.producer.service.KafkaMessageProducerService;

@Service
public class KafkaMessageProducerServiceImpl implements KafkaMessageProducerService {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaMessageProducerServiceImpl.class);
	
	@Autowired
	private KafkaTemplate< String, String> kafkaTemplate;
	
	/**
	 * @implNote : method to send the message to the topic subscribed consumer.
	 * @param message
	 * **/
	@Override
	public void produceMessage(String message) {
		// TODO Auto-generated method stub
		LOGGER.info(String.format("Message Sent %s", message));
		kafkaTemplate.send("newTopic",message);
		
	}


}
