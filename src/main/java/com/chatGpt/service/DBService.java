package com.chatGpt.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.chatGpt.dto.Message;
import com.chatGpt.dto.ResponseImage;

@Service
public class DBService {

	@Value("${dbsUrl}")
	private String dbsUrl;

	private final RestTemplate restTemplate;

	public DBService() {
		this.restTemplate = new RestTemplate();
	}

	

	public ResponseEntity<Message> savingTransaction(ResponseImage responseModel, String conversationId, String text) {
		String url = dbsUrl + "/addMessage";

		Message ms = new Message();
		ms.setConversationID(conversationId);
		ms.setAiContent(responseModel.getMessage());
		ms.setUserContent(text);
		
		
	
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<Message> request = new HttpEntity<>(ms, headers);
		
	    return restTemplate.postForEntity(url, request, Message.class);

		
	}

}
