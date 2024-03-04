package com.apachekafka.producer.service;

public interface KafkaMessageProducerService {

	/**
	 * @implNote : method to send the message to the topic subscribed consumer.
	 * @param message
	 * **/
	void produceMessage(String message);
}
