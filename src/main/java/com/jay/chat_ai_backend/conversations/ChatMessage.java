package com.jay.chat_ai_backend.conversations;

import java.time.LocalDateTime;

public record ChatMessage(
        String messageText,                         //message
        String senderId,                            //sender's profile id
        LocalDateTime sendTime                      //send time
) {
}
