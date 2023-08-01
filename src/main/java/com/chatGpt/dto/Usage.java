package com.chatGpt.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Usage {
  @JsonProperty("prompt_tokens")
  private Integer promptTokens;
  
  @JsonProperty("completion_tokens")
  private Integer completionTokens;
  
  @JsonProperty("total_tokens")
  private Integer totalTokens;
  
  @JsonProperty("prompt_tokens")
  public void setPromptTokens(Integer promptTokens) {
    this.promptTokens = promptTokens;
  }
  
  @JsonProperty("completion_tokens")
  public void setCompletionTokens(Integer completionTokens) {
    this.completionTokens = completionTokens;
  }
  
  @JsonProperty("total_tokens")
  public void setTotalTokens(Integer totalTokens) {
    this.totalTokens = totalTokens;
  }
  
  public boolean equals(Object o) {
    if (o == this)
      return true; 
    if (!(o instanceof Usage))
      return false; 
    Usage other = (Usage)o;
    if (!other.canEqual(this))
      return false; 
    Object this$promptTokens = getPromptTokens(), other$promptTokens = other.getPromptTokens();
    if ((this$promptTokens == null) ? (other$promptTokens != null) : !this$promptTokens.equals(other$promptTokens))
      return false; 
    Object this$completionTokens = getCompletionTokens(), other$completionTokens = other.getCompletionTokens();
    if ((this$completionTokens == null) ? (other$completionTokens != null) : !this$completionTokens.equals(other$completionTokens))
      return false; 
    Object this$totalTokens = getTotalTokens(), other$totalTokens = other.getTotalTokens();
    return !((this$totalTokens == null) ? (other$totalTokens != null) : !this$totalTokens.equals(other$totalTokens));
  }
  
  protected boolean canEqual(Object other) {
    return other instanceof Usage;
  }
  
  public int hashCode() {
    int PRIME = 59;
    int result = 1;
    Object $promptTokens = getPromptTokens();
    result = result * 59 + (($promptTokens == null) ? 43 : $promptTokens.hashCode());
    Object $completionTokens = getCompletionTokens();
    result = result * 59 + (($completionTokens == null) ? 43 : $completionTokens.hashCode());
    Object $totalTokens = getTotalTokens();
    return result * 59 + (($totalTokens == null) ? 43 : $totalTokens.hashCode());
  }
  
  public String toString() {
    return "Usage(promptTokens=" + getPromptTokens() + ", completionTokens=" + getCompletionTokens() + ", totalTokens=" + getTotalTokens() + ")";
  }
  
  public Integer getPromptTokens() {
    return this.promptTokens;
  }
  
  public Integer getCompletionTokens() {
    return this.completionTokens;
  }
  
  public Integer getTotalTokens() {
    return this.totalTokens;
  }
}
