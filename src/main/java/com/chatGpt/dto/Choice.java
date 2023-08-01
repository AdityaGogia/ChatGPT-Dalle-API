package com.chatGpt.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Choice {
//  private String text;
  
  private Integer index;
  
//  private String logprobs;
  
  @JsonProperty("finish_reason")
  private String finishReason;
  
  private GPTMessage message;
  
  @JsonProperty("finish_reason")
  public void setFinishReason(String finishReason) {
    this.finishReason = finishReason;
  }
}
