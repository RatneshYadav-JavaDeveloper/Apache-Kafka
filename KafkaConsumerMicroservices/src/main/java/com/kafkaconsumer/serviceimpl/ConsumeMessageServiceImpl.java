/**
 * 
 */
package com.kafkaconsumer.serviceimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.kafkaconsumer.service.ConsumeMesageService;

/**
*
* @author Ratnesh
* @DateTime 01-Mar-2024 1:24:42 pm
*
**/
@Service
public class ConsumeMessageServiceImpl implements ConsumeMesageService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ConsumeMessageServiceImpl.class);
	
	@KafkaListener(topics = "even-topic",groupId = "event-group")
	@Override
	public String consumeMessage(String message) {
		return message;
	}
}
