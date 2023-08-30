package com.example.hw49.enums;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ContactType {

    EMAIL("Email"),
    TELEGRAM("TELEGRAM"),
    PHONE_NUMBER("Phone number"),
    FACEBOOK_LINK("Facebook link"),
    LINKEDIN_LINK("Linkedin link");

    private String type;
}
