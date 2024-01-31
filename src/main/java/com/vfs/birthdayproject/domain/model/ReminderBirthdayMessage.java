package com.vfs.birthdayproject.domain.model;

import static java.lang.String.format;

public class ReminderBirthdayMessage extends Message {
    private final static String DEFAULT_SUBJECT = "Birthday Reminder";
    private final static String BASED_BODY = "Dear %s\nToday is %s %s's birthday.\n\t\tDon't forget to send him a message !";

    public ReminderBirthdayMessage(Friend friend, Friend birthdayPerson) {
        super(DEFAULT_SUBJECT, format(BASED_BODY, friend.firstName(), birthdayPerson.firstName(), birthdayPerson.lastName()));
    }
}
