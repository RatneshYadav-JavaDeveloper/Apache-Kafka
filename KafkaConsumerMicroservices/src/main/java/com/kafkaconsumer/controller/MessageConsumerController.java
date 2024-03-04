/**
 * 
 */
package com.kafkaconsumer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kafkaconsumer.service.ConsumeMesageService;

/**
*
* @author Ratnesh
* @DateTime 01-Mar-2024 1:18:04 pm
*
**/
@RestController
@RequestMapping("/v1")
public class MessageConsumerController {

	
	@Autowired ConsumeMesageService consumeMesageService;
	
	@GetMapping("/consume")
	public ResponseEntity<String> consumerMessageController(@RequestParam("message") String message){
		String receivedMessage=consumeMesageService.consumeMessage(message);
		return new ResponseEntity<>(receivedMessage,HttpStatus.OK);
	}
}
