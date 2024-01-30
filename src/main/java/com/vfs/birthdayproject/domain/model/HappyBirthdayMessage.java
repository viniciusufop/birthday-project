package com.vfs.birthdayproject.domain.model;

import static java.lang.String.format;

public class HappyBirthdayMessage extends Message{
    private final static String DEFAULT_SUBJECT = "Happy birthday!";
    public HappyBirthdayMessage(Friend friend) {
        super(DEFAULT_SUBJECT, format("Happy birthday, dear %s!", friend.getFirstName()));
    }
}
