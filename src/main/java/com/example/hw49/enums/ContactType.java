package com.example.hw49.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ContactType {

    EMAIL("Email"),
    TELEGRAM("TELEGRAM"),
    PHONE_NUMBER("Phone number"),
    FACEBOOK_LINK("Facebook link"),
    LINKEDIN_LINK("Linkedin link");

    private String type;
}
