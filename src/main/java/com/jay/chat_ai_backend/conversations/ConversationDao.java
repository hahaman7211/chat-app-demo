package com.jay.chat_ai_backend.conversations;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConversationDao extends MongoRepository<Conversation, String> {
}
