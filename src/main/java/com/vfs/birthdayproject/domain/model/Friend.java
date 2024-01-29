package com.vfs.birthdayproject.domain.model;

import java.time.Month;
import java.time.OffsetDateTime;

public class Friend {

    private final String firstName;
    private final String lastName;
    private final String email;
    private final OffsetDateTime birthday;

    public Friend(String firstName, String lastName, String email, OffsetDateTime birthday) {
        //TODO validate and return error for invalid friends data
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthday = birthday;
    }

    public boolean isMyBirthday(OffsetDateTime currentDate) {
        if (currentDate.getMonth().equals(birthday.getMonth()) && currentDate.getDayOfMonth() == birthday.getDayOfMonth())
            return true;
        return currentDate.getMonth().equals(birthday.getMonth()) && currentDate.getMonth().equals(Month.FEBRUARY) &&
                birthday.getDayOfMonth() == 29 && currentDate.getDayOfMonth() == 28;
    }
}
