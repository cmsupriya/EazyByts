package com.chat_app_backend.dto;
import lombok.Data;
@Data
public class PrivateChatMessage {
  private String sender;
  private String target;
  private String content;
  private String timestamp;
}
