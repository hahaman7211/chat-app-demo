package com.jay.chat_ai_backend;

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

	public static void main(String[] args) {
		SpringApplication.run(ChatAiBackendApplication.class, args);
	}

	public void run(String... args){
		System.out.println("my chat app is running");

		Profile profile = new Profile(
				"2",
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
		profileDao.findAll().forEach(System.out::println);

	}
}
