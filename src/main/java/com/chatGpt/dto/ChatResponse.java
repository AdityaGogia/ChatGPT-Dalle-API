package com.chatGpt.dto;

import java.time.LocalDate;
import java.util.List;

public class ChatResponse {
  private String id;
  
  private String object;
  
  private LocalDate created;
  
  private String model;
  
  private List<Choice> choices;
  
  private Usage usage;
  
  public void setId(String id) {
    this.id = id;
  }
  
  public void setObject(String object) {
    this.object = object;
  }
  
  public void setCreated(LocalDate created) {
    this.created = created;
  }
  
  public void setModel(String model) {
    this.model = model;
  }
  
  public void setChoices(List<Choice> choices) {
    this.choices = choices;
  }
  
  public void setUsage(Usage usage) {
    this.usage = usage;
  }
  
  public boolean equals(Object o) {
    if (o == this)
      return true; 
    if (!(o instanceof ChatResponse))
      return false; 
    ChatResponse other = (ChatResponse)o;
    if (!other.canEqual(this))
      return false; 
    Object this$id = getId(), other$id = other.getId();
    if ((this$id == null) ? (other$id != null) : !this$id.equals(other$id))
      return false; 
    Object this$object = getObject(), other$object = other.getObject();
    if ((this$object == null) ? (other$object != null) : !this$object.equals(other$object))
      return false; 
    Object this$created = getCreated(), other$created = other.getCreated();
    if ((this$created == null) ? (other$created != null) : !this$created.equals(other$created))
      return false; 
    Object this$model = getModel(), other$model = other.getModel();
    if ((this$model == null) ? (other$model != null) : !this$model.equals(other$model))
      return false; 
    Object this$choices = (Object)getChoices(), other$choices = (Object)other.getChoices();
    //    Object<Choice> this$choices = (Object<Choice>)getChoices(), other$choices = (Object<Choice>)other.getChoices();
    if ((this$choices == null) ? (other$choices != null) : !this$choices.equals(other$choices))
      return false; 
    Object this$usage = getUsage(), other$usage = other.getUsage();
    return !((this$usage == null) ? (other$usage != null) : !this$usage.equals(other$usage));
  }
  
  protected boolean canEqual(Object other) {
    return other instanceof ChatResponse;
  }
  
  public int hashCode() {
    int PRIME = 59;
    int result = 1;
    Object $id = getId();
    result = result * 59 + (($id == null) ? 43 : $id.hashCode());
    Object $object = getObject();
    result = result * 59 + (($object == null) ? 43 : $object.hashCode());
    Object $created = getCreated();
    result = result * 59 + (($created == null) ? 43 : $created.hashCode());
    Object $model = getModel();
    result = result * 59 + (($model == null) ? 43 : $model.hashCode());
    Object $choices = (Object)getChoices();
//    Object<Choice> $choices = (Object<Choice>)getChoices();
    result = result * 59 + (($choices == null) ? 43 : $choices.hashCode());
    Object $usage = getUsage();
    return result * 59 + (($usage == null) ? 43 : $usage.hashCode());
  }
  
  public String toString() {
    return "ChatResponse(id=" + getId() + ", object=" + getObject() + ", created=" + getCreated() + ", model=" + getModel() + ", choices=" + getChoices() + ", usage=" + getUsage() + ")";
  }
  
  public String getId() {
    return this.id;
  }
  
  public String getObject() {
    return this.object;
  }
  
  public LocalDate getCreated() {
    return this.created;
  }
  
  public String getModel() {
    return this.model;
  }
  
  public List<Choice> getChoices() {
    return this.choices;
  }
  
  public Usage getUsage() {
    return this.usage;
  }
}
