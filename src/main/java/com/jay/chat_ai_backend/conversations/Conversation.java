package com.jay.chat_ai_backend.conversations;

import java.util.List;

public record Conversation(
        String id,                              //conversation id
        String profileId,                       //profile id
        List<ChatMessage> message               //message
) {
}
