/**
 * 
 */
package com.kafkaproducer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
*
* @author Ratnesh
* @DateTime 29-Feb-2024 3:26:51 pm
*
**/
@Configuration
public class TopicConfig {

	@Bean
	public NewTopic createTopic() {
		return TopicBuilder.name("event-topic").build();
	}
}
