package com.chatGpt.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.chatGpt.dto.ChatRequest;
import com.chatGpt.dto.ChatResponse;
import com.chatGpt.dto.Choice;
import com.chatGpt.dto.GPTMessage;
import com.chatGpt.exception.ChatgptException;
import com.chatGpt.property.ChatgptProperties;

@Service
public class DefaultChatgptService implements ChatgptService {
  private static final Logger log = LoggerFactory.getLogger(DefaultChatgptService.class);
  
  protected final ChatgptProperties chatgptProperties;
  
  private final String URL = "https://api.openai.com/v1/chat/completions";
  private final String DALLE_URL = "https://api.openai.com/v1/images/generations";

  
  
  private final String AUTHORIZATION;
  
  public DefaultChatgptService(ChatgptProperties chatgptProperties) {
    this.chatgptProperties = chatgptProperties;
    this.AUTHORIZATION = "Bearer " + chatgptProperties.getApiKey();
  }
  
  
  
  
  public String sendMessage(String message) {
	  List<GPTMessage> msg1 =  new ArrayList<GPTMessage>();
	 
	  GPTMessage msg = new GPTMessage();
	  
	  msg.setRole("user");
	  msg.setContent(message);
	  msg1.add(msg);
	  
    ChatRequest chatRequest = new ChatRequest(this.chatgptProperties.getModel(), msg1, this.chatgptProperties.getMaxTokens(), this.chatgptProperties.getTemperature(), this.chatgptProperties.getTopP());
//    System.out.println(chatRequest.getModel());
//    System.out.println(chatRequest.getMessages().getContent());
//    System.out.println(chatRequest.getMessages().getRole());
//    
//    System.out.println("builidng http req");
//    HttpEntity<ChatRequest> buildHttpEntity = buildHttpEntity(chatRequest);
//    
//    System.out.println(buildHttpEntity.getBody().getMessages().getContent());
    ChatResponse chatResponse = getResponse(buildHttpEntity(chatRequest));
    try {
      return ((Choice)chatResponse.getChoices().get(0)).getMessage().getContent();
    } catch (Exception e) {
      log.error("parse chatgpt message error", e);
      throw e;
    } 
  }
  
  public ResponseEntity<String> generateImage(String prompt) {
      HttpHeaders headers = new HttpHeaders();
      headers.setContentType(MediaType.parseMediaType("application/json; charset=UTF-8"));
      headers.add("Authorization", this.AUTHORIZATION);

      // Create the request body
      int n = 1;
      String size = "1024x1024";
      String requestBody = String.format("{\"prompt\":\"%s\", \"n\":%d, \"size\":\"%s\"}", prompt, n, size);

      HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

      RestTemplate restTemplate = new RestTemplate();
      try {
          // Make the POST request to the DALL-E API
    	   ResponseEntity<String> externalApiResponse = restTemplate.exchange(DALLE_URL, HttpMethod.POST, entity, String.class);
    	   log.info("DALL-E response: {}", externalApiResponse);
          return new ResponseEntity<>(externalApiResponse.getBody(), HttpStatus.OK);
      } catch (Exception e) {
          log.error("Error calling DALL-E API", e);
          throw new RuntimeException("Error calling DALL-E API", e);
      }
  }
  
  
  public String sendMessage1(List<GPTMessage> msg) {
//	  List<Message> msg1 =  new ArrayList<Message>();
	 
//	  Message msg = new Message();
//	  
//	  msg.setRole("user");
//	  msg.setContent(message);
//	  msg1.add(msg);
	  
    ChatRequest chatRequest = new ChatRequest(this.chatgptProperties.getModel(), msg, this.chatgptProperties.getMaxTokens(), this.chatgptProperties.getTemperature(), this.chatgptProperties.getTopP());
//    System.out.println(chatRequest.getModel());
//    System.out.println(chatRequest.getMessages().getContent());
//    System.out.println(chatRequest.getMessages().getRole());
//    
//    System.out.println("builidng http req");
//    HttpEntity<ChatRequest> buildHttpEntity = buildHttpEntity(chatRequest);
//    
//    System.out.println(buildHttpEntity.getBody().getMessages().getContent());
    ChatResponse chatResponse = getResponse(buildHttpEntity(chatRequest));
    try {
      return ((Choice)chatResponse.getChoices().get(0)).getMessage().getContent();
    } catch (Exception e) {
      log.error("parse chatgpt message error", e);
      throw e;
    } 
  }
  
  
  public ChatResponse sendChatRequest(ChatRequest chatRequest) {
    return getResponse(buildHttpEntity(chatRequest));
  }
  
  public HttpEntity<ChatRequest> buildHttpEntity(ChatRequest chatRequest) {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.parseMediaType("application/json; charset=UTF-8"));
    headers.add("Authorization", this.AUTHORIZATION);
    return new HttpEntity(chatRequest, (MultiValueMap)headers);
  }
  
  public ChatResponse getResponse(HttpEntity<ChatRequest> chatRequestHttpEntity) {
    log.info("request url: {}, httpEntity: {}", "https://api.openai.com/v1/chat/completions", chatRequestHttpEntity);
    RestTemplate restTemplate = new RestTemplate();
//    ResponseEntity<ChatResponse> responseEntity = restTemplate.postForEntity("https://api.openai.com/v1/chat/completions", chatRequestHttpEntity, ChatResponse.class, new Object[0]);
    ResponseEntity<ChatResponse> responseEntity = restTemplate.postForEntity("https://api.openai.com/v1/chat/completions", chatRequestHttpEntity, ChatResponse.class);

    if (responseEntity.getStatusCode().isError()) {
      log.error("error response status: {}", responseEntity);
      throw new ChatgptException("error response status :" + responseEntity.getStatusCode().value());
    } 
    log.info("response: {}", responseEntity);
    return (ChatResponse)responseEntity.getBody();
  }
}
