/**
 * 
 */
package com.kafkaproducer.controller;

import java.net.URI;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafkaproducer.service.MessageDrivenService;
import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;

/**
*
* @author Ratnesh
* @DateTime 29-Feb-2024 4:29:50 pm
*
**/
@RestController
@RequestMapping("/v1")
public class KafkaProducerController {


	@Autowired KafkaTemplate<String, String> kafkaTemplate;




	/**
	 * @implNote: controller to produce the message.
	 * @param: message
	 * {@link: http://localhost:8081/v1/produce?message=firstMessage}
	 * **/
	//@GetMapping("/produce")
	@PostConstruct
	public ResponseEntity<Void> produceMessageController(){
		
		EventHandler eventHandler = new MessageDrivenService("event-topic", kafkaTemplate);
		EventSource.Builder builder = new EventSource.Builder(eventHandler, URI.create("https:stream.wikimedia.org/v2/stream/recentchange"));
		EventSource eventSource = builder.build();
		eventSource.start();
		return null;
	}
}
