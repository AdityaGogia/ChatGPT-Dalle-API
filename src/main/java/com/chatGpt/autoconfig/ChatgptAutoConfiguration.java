package com.chatGpt.autoconfig;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.chatGpt.property.ChatgptProperties;
import com.chatGpt.service.ChatgptService;
import com.chatGpt.service.DefaultChatgptService;

@Configuration
@EnableConfigurationProperties({ChatgptProperties.class})
public class ChatgptAutoConfiguration {
  private static final Logger log = LoggerFactory.getLogger(ChatgptAutoConfiguration.class);
  
  @Autowired
  private ChatgptProperties chatgptProperties;
  
  public ChatgptAutoConfiguration() {
    log.debug("chatgpt-springboot-starter loaded.");
  }
  
  @Bean
  @ConditionalOnMissingBean({ChatgptService.class})
  public ChatgptService chatgptService() {
    return (ChatgptService)new DefaultChatgptService(this.chatgptProperties);
  }
  
}
