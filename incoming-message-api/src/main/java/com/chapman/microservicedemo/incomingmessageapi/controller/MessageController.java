/**
 * 
 */
package com.chapman.microservicedemo.incomingmessageapi.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;


/**
 * @author Anthony Chapman
 *
 */
@Slf4j
@RestController
class MessageController {
	
	Logger logger = LoggerFactory.getLogger(MessageController.class);
	
	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;
		
	@PostMapping(
		value = "/sendmessage/",
		consumes = "application/json",
		produces = "application/json"
		)
	public ResponseEntity<String> sendMessage(@RequestBody String message) {
		
		logger.info(message);
		
		kafkaTemplate.send("toMessageProcessor", message);
		
		return new ResponseEntity<String>("Message received.\n", HttpStatus.OK);
		
	}
}