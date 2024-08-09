package com.jay.chat_ai_backend.conversations;

import com.jay.chat_ai_backend.profiles.ProfileDao;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
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

    //start a conversation
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

    @GetMapping("/conversion/{conversationId}")
    public Conversation getConversation(@PathVariable String conversationId) {

        return conversationDao.findById(conversationId)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "unable to find the conversation"));

    }

    //add a new message to the given conversation
    @PostMapping("/conversion/{conversationId}")
    public Conversation addNewMessage(@PathVariable String conversationId, @RequestBody ChatMessage chatMessage) {
        //1. check if the conversation id exist
        Conversation conversation = conversationDao.findById(conversationId)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "unable to find the conversation"));

        //2. check if the sender id( profile id) exist
        profileDao.findById(chatMessage.senderId())
                .orElseThrow( () ->
                        new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "unable to find the profile id: " + chatMessage.senderId()));



        //3.create a new message for adding to the conversation
        ChatMessage newMessage = new ChatMessage(
                chatMessage.messageText(),
                chatMessage.senderId(),
                LocalDateTime.now()
        );
        //4. save the message to conversation
        conversation.message().add(newMessage);
        conversationDao.save(conversation);

        return conversation;

    }

    public record createChatRequest(String profileId) {}

}
