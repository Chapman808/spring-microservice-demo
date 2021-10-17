/**
 * 
 */
package com.chapman.microservicedemo.messageprocessor.service;


import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
/**
 * @author Anthony Chapman
 *
 */
@Service
public class MessageProcessor {
	
	Logger logger = LoggerFactory.getLogger(MessageProcessor.class);

	/**
	 * @param message
	 * @return
	 */
	public void process(String message) {
		//json parsing
		JSONObject jsonMessage = new JSONObject(message);
		String messageText = jsonMessage.getString("message");
		String keyword = jsonMessage.getString("keyword");
		String substitutionWord = jsonMessage.getString("substitutionWord");
		
		String processedMessage = messageText.replaceAll(keyword, substitutionWord);
		logger.info("Processed message: {}", processedMessage);
	}

}
