package com.apachekafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apachekafka.model.User;
import com.apachekafka.producer.service.KafkaJsonMessageProducerService;
import com.apachekafka.producer.service.KafkaMessageProducerService;

@RestController
@RequestMapping("/v1")
public class KafkaMessageController {

	@Autowired KafkaMessageProducerService messageProducerService;
	@Autowired KafkaJsonMessageProducerService jsonMessageProducerService;
	
	
	
	/**
	 * @implNote : controller to send the message to the subscribed topic consumer.
	 * @param : message
	 * {@link : http://localhost:8080/v1/publish?message=welcome to kafka message}
	 * **/
	@GetMapping("/publish")
	public ResponseEntity<String> sendMessageToConsumer(@RequestParam("message") String message){
		messageProducerService.produceMessage(message);
		return ResponseEntity.ok(message);
	}
	
	/**
	 * @implNote : controller to send the JSON Object as message to the subscribed topic consumer.
	 * @param : User
	 * {@link : http://localhost:8080/v1/publish/json}
	 * **/
	@PostMapping("/publish/json")
	public ResponseEntity<String> sendJSONMessageToConsumer(@RequestBody User user){
		jsonMessageProducerService.jsonMessageProducer(user);
		return ResponseEntity.ok(user.toString());
	}
}
