package com.jay.chat_ai_backend;

import com.jay.chat_ai_backend.conversations.ConversationDao;
import com.jay.chat_ai_backend.profiles.Gender;
import com.jay.chat_ai_backend.profiles.Profile;
import com.jay.chat_ai_backend.profiles.ProfileDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChatAiBackendApplication implements CommandLineRunner {

	@Autowired
	private ProfileDao profileDao;

	@Autowired
	private ConversationDao conversationDao;

	public static void main(String[] args) {
		SpringApplication.run(ChatAiBackendApplication.class, args);
	}

	public void run(String... args){
		System.out.println("my chat app is running");

		profileDao.deleteAll();
		conversationDao.deleteAll();

		Profile profile = new Profile(
				"1",
				"Jay",
				"Wang",
				41,
				"Taiwan",
				Gender.MALE,
				"programmer",
				"jay.jpg",
				"my name is Jay"
		);
		profileDao.save(profile);

		Profile profile2 = new Profile(
				"2",
				"Chieh",
				"hahaman",
				30,
				"Taiwan",
				Gender.MALE,
				"guitarist",
				"jay.jpg",
				"my name is hahaman"
		);
		profileDao.save(profile2);
		profileDao.findAll().forEach(System.out::println);

//		Conversation conversation = new Conversation(
//				"1",
//				profile.id(),
//				List.of(
//						new ChatMessage("hi", profile.id(), LocalDateTime.now()))
//		);
//
//		conversationDao.save(conversation);
//		conversationDao.findAll().forEach(System.out::println);

	}
}
