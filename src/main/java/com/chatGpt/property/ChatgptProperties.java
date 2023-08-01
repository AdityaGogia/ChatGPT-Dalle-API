package com.chatGpt.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "chatgpt")
public class ChatgptProperties {
  private String apiKey = "";
  
  private String model ="gpt-3.5-turbo-16k";
  

//  private String model ="gpt-4-32k";

  
//  32768
  private Integer maxTokens = 16768;
		  //Integer.valueOf(300);
  
  private Double temperature = Double.valueOf(0.0D);
  
  private Double topP = Double.valueOf(1.0D);
  
  public String getApiKey() {
    return this.apiKey;
  }
  
  public void setApiKey(String apiKey) {
    this.apiKey = apiKey;
  }
  
  public String getModel() {
    return this.model;
  }
  
  public void setModel(String model) {
    this.model = model;
  }
  
  public Integer getMaxTokens() {
    return this.maxTokens;
  }
  
  public void setMaxTokens(Integer maxTokens) {
    this.maxTokens = maxTokens;
  }
  
  public Double getTemperature() {
    return this.temperature;
  }
  
  public void setTemperature(Double temperature) {
    this.temperature = temperature;
  }
  
  public Double getTopP() {
    return this.topP;
  }
  
  public void setTopP(Double topP) {
    this.topP = topP;
  }
}
