/**
 * 
 */
package com.kafkaproducer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;

/**
*
* @author Ratnesh
* @DateTime 29-Feb-2024 3:32:10 pm
*
**/
public class MessageDrivenService implements EventHandler{

	public static final Logger LOGGER = LoggerFactory.getLogger(MessageDrivenService.class);
	
	@Autowired RestTemplate restTemplate;
	
	private String topic;	
    private KafkaTemplate<String, String> kafkaTemplate;

	
	/**
	 * @param topic
	 * @param kafkaTemplate
	 */
	public MessageDrivenService(String topic, KafkaTemplate<String, String> kafkaTemplate) {
		this.topic = topic;
		this.kafkaTemplate = kafkaTemplate;
	}


	@Override
	public void onOpen() throws Exception {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onClosed() throws Exception {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onMessage(String event, MessageEvent messageEvent) throws Exception {
		// TODO Auto-generated method stub
		//LOGGER.info(String.format("Message Produced %s", messageEvent.getData()));
		kafkaTemplate.send("event-topic", messageEvent.getData());
		restTemplate.getForObject("http://localhost:8080/v1/consume?message="+messageEvent.getData(),String.class);
		
	}


	@Override
	public void onComment(String comment) throws Exception {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onError(Throwable t) {
		// TODO Auto-generated method stub
		
	}
	
	

}
