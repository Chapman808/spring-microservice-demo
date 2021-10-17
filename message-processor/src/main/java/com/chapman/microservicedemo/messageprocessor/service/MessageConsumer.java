/**
 * 
 */
package com.chapman.microservicedemo.messageprocessor.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class MessageConsumer {
	
	@Autowired KafkaTemplate<String,String> kafkaTemplate;	
	@Autowired MessageProcessor messageProcessor;

	@KafkaListener(topics = "toMessageProcessor",  groupId = "demo")
	public void consume (String message) {
		messageProcessor.process(message);
	}
}
