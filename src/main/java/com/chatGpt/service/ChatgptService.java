package com.chatGpt.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.chatGpt.dto.ChatRequest;
import com.chatGpt.dto.ChatResponse;
import com.chatGpt.dto.GPTMessage;

public interface ChatgptService {
	
  String sendMessage(String paramString);
  
  String sendMessage1(List<GPTMessage> paramString);
  
  ChatResponse sendChatRequest(ChatRequest paramChatRequest);
  
  ResponseEntity<String> generateImage(String prompt);
}
