package com.jay.chat_ai_backend.profiles;


import org.springframework.data.annotation.Id;

//@Id is not need because the id file already exist
public record Profile(
        @Id String id,
        String firstname,
        String lastname,
        int age,
        String country,
        Gender gender,
        String bio,
        String imageUrl,
        String personality
) {
}
