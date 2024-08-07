package com.jay.chat_ai_backend.conversations;

import java.time.LocalDateTime;

public record CatMessage(
        String messageText,
        String senderId,
        LocalDateTime sendTime
) {
}
