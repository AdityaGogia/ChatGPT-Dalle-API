package com.chatGpt.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WaRequest {
  private String appid;
  
  private String input;
  
  private String includepodid;
  
  private String format;
  
public WaRequest(String appid, String input, String includepodid, String format) {
	super();
	this.appid = appid;
	this.input = input;
	this.includepodid = includepodid;
	this.format = format;
}
 
  

}
