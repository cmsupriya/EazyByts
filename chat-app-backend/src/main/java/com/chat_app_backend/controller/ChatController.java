package com.chat_app_backend.controller;

import com.chat_app_backend.dto.ChatMessage;
import com.chat_app_backend.dto.PrivateChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import java.security.Principal;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ChatController {

    private final SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public ChatMessage publicChat(ChatMessage msg, Principal principal) {
        msg.setSender(principal != null ? principal.getName() : "anonymous");
        return msg;
    }

    @MessageMapping("/private")
    public void privateChat(PrivateChatMessage msg, Principal principal) {
        String toUser = msg.getTarget();
        msg.setSender(principal != null ? principal.getName() : "anonymous");
        msg.setTimestamp(msg.getTimestamp());
        simpMessagingTemplate.convertAndSendToUser(toUser, "/queue/private", msg);
    }
}
