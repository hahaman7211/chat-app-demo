package com.jay.chat_ai_backend.conversations;

import java.time.LocalDateTime;

public record ChatMessage(
        String messageText,
        String senderId,
        LocalDateTime sendTime
) {
}
