package com.jay.chat_ai_backend.conversations;

import com.jay.chat_ai_backend.profiles.ProfileDao;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.UUID;

@RestController
public class ConversationController {

    private final ConversationDao conversationDao;

    private final ProfileDao profileDao;

    public ConversationController(ConversationDao conversationDao, ProfileDao profileDao) {
        this.conversationDao = conversationDao;
        this.profileDao = profileDao;
    }

    @PostMapping("/conversion")
    public Conversation createNewConversation(@RequestBody createChatRequest request) {

        //find if the profile id exist
        profileDao.findById(request.profileId())
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        //if the profile id exist save the conversation
        Conversation conversation = new Conversation(
                UUID.randomUUID().toString(),
                request.profileId(),
                new ArrayList<>()
        );

        conversationDao.save(conversation);
        return conversation;
    }

    public record createChatRequest(String profileId) {}

}
