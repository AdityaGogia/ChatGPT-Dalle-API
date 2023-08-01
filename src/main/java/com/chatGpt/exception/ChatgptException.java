package com.chatGpt.exception;

public class ChatgptException extends RuntimeException {
  public ChatgptException() {}
  
  public ChatgptException(String message) {
    super(message);
  }
}
