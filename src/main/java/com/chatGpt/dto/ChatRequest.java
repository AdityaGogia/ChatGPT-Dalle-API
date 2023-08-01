package com.chatGpt.dto;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatRequest {
	
  private String model;
  
  private List<GPTMessage> messages;
  

  @JsonProperty("max_tokens")
  private Integer maxTokens;
  
  private Double temperature;
  
  @JsonProperty("top_p")
  private Double topP;



@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	ChatRequest other = (ChatRequest) obj;
	return Objects.equals(messages, other.messages) && Objects.equals(model, other.model);
}



public ChatRequest(String model, List<GPTMessage> messages, Integer maxTokens, Double temperature, Double topP) {
	super();
	this.model = model;
	this.messages = messages;
	this.maxTokens = maxTokens;
	this.temperature = temperature;
	this.topP = topP;
}


  
  
  

}
  
//  @JsonProperty("max_tokens")
//  private Integer maxTokens;
//  
//  private Double temperature;
//  
//  @JsonProperty("top_p")
//  private Double topP;
//  
//  public void setModel(String model) {
//    this.model = model;
//  }
//  
//  public void setPrompt(String prompt) {
//    this.prompt = prompt;
//  }
//  
//  @JsonProperty("max_tokens")
//  public void setMaxTokens(Integer maxTokens) {
//    this.maxTokens = maxTokens;
//  }
//  
//  public void setTemperature(Double temperature) {
//    this.temperature = temperature;
//  }
//  
//  @JsonProperty("top_p")
//  public void setTopP(Double topP) {
//    this.topP = topP;
//  }
//  
//  public boolean equals(Object o) {
//    if (o == this)
//      return true; 
//    if (!(o instanceof ChatRequest))
//      return false; 
//    ChatRequest other = (ChatRequest)o;
//    if (!other.canEqual(this))
//      return false; 
//    Object this$maxTokens = getMaxTokens(), other$maxTokens = other.getMaxTokens();
//    if ((this$maxTokens == null) ? (other$maxTokens != null) : !this$maxTokens.equals(other$maxTokens))
//      return false; 
//    Object this$temperature = getTemperature(), other$temperature = other.getTemperature();
//    if ((this$temperature == null) ? (other$temperature != null) : !this$temperature.equals(other$temperature))
//      return false; 
//    Object this$topP = getTopP(), other$topP = other.getTopP();
//    if ((this$topP == null) ? (other$topP != null) : !this$topP.equals(other$topP))
//      return false; 
//    Object this$model = getModel(), other$model = other.getModel();
//    if ((this$model == null) ? (other$model != null) : !this$model.equals(other$model))
//      return false; 
//    Object this$prompt = getPrompt(), other$prompt = other.getPrompt();
//    return !((this$prompt == null) ? (other$prompt != null) : !this$prompt.equals(other$prompt));
//  }
//  
//  protected boolean canEqual(Object other) {
//    return other instanceof ChatRequest;
//  }
//  
//  public int hashCode() {
//    int PRIME = 59;
//    int result = 1;
//    Object $maxTokens = getMaxTokens();
//    result = result * 59 + (($maxTokens == null) ? 43 : $maxTokens.hashCode());
//    Object $temperature = getTemperature();
//    result = result * 59 + (($temperature == null) ? 43 : $temperature.hashCode());
//    Object $topP = getTopP();
//    result = result * 59 + (($topP == null) ? 43 : $topP.hashCode());
//    Object $model = getModel();
//    result = result * 59 + (($model == null) ? 43 : $model.hashCode());
//    Object $prompt = getPrompt();
//    return result * 59 + (($prompt == null) ? 43 : $prompt.hashCode());
//  }
//  
//  public String toString() {
//    return "ChatRequest(model=" + getModel() + ", prompt=" + getPrompt() + ", maxTokens=" + getMaxTokens() + ", temperature=" + getTemperature() + ", topP=" + getTopP() + ")";
//  }
//  
//  public ChatRequest(String model, String prompt, Integer maxTokens, Double temperature, Double topP) {
//    this.model = model;
//    this.message = messgae;
////    this.maxTokens = maxTokens;
//    this.temperature = temperature;
//    this.topP = topP;
//  }
  
//  public String getModel() {
//    return this.model;
//  }
//  
//  public String getPrompt() {
//    return this.prompt;
//  }
//  
//  public Integer getMaxTokens() {
//    return this.maxTokens;
//  }
//  
//  public Double getTemperature() {
//    return this.temperature;
//  }
//  
//  public Double getTopP() {
//    return this.topP;
//  }
//}
