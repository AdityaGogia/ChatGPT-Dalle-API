package com.chatGpt.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.chatGpt.dto.ChatRequest;
import com.chatGpt.dto.ChatResponse;
import com.chatGpt.dto.Choice;
import com.chatGpt.dto.WaRequest;
import com.chatGpt.exception.ChatgptException;

@Service
public class WAService {
  private static final Logger log = LoggerFactory.getLogger(WAService.class);

  
  private  String URL = "http://api.wolframalpha.com/v2/query?appid=4WXX6T-XY5UXV8RTQ&format=plaintext&output=json&input=";
  //&includepodid=Result
		  //?appid=4WXX6T-XY5UXV8RTQ&includepodid=Result&format=plaintext&input=";
  
  
  public Object sendMessage(String message) {
	  
   WaRequest chatRequest = new WaRequest("4WXX6", message, "Result", "plaintext");
   return  getResponse(message);
  }
  
  public Object sendChatRequest(String chatRequest) {
    return getResponse(chatRequest);
  }
  
  
  public Object getResponse(String msg) {
	  URL=URL+msg;
	  System.out.println(URL);
    log.info("request url: {}, httpEntity: {}", "http://api.wolframalpha.com/v2/query", URL);
    RestTemplate restTemplate = new RestTemplate();
    
    ResponseEntity<Object> responseEntity = restTemplate.getForEntity(URL, Object.class);
    
     return responseEntity.getBody();
  }
}
