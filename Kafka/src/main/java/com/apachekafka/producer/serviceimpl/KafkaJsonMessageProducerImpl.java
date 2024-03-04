/**
 * 
 */
package com.apachekafka.producer.serviceimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.apachekafka.model.User;
import com.apachekafka.producer.service.KafkaJsonMessageProducerService;

/**
*
* @author Ratnesh
* @DateTime 28-Feb-2024 10:22:13 am
*
**/
@Service
public class KafkaJsonMessageProducerImpl implements KafkaJsonMessageProducerService {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(KafkaJsonMessageProducerImpl.class);
	
	@Autowired 
	private KafkaTemplate<String, User> kafkaTemplate;

	/**
	 * @implNote: method to produce the JsonMessage, using java User object.
	 * @param User
	 *  
	 * **/
	@Override
	public void jsonMessageProducer(User user) {
		// TODO Auto-generated method stub
		LOGGER.info(user.toString());
		Message<User> message = MessageBuilder.withPayload(user).setHeader(KafkaHeaders.TOPIC, "newJSONTopic").build();
		kafkaTemplate.send(message);
	}

}
