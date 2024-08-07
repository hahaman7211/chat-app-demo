package com.jay.chat_ai_backend.profiles;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProfileDao extends MongoRepository<Profile, String> {
}
