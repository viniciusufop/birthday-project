package com.vfs.birthdayproject.domain.model;

import com.vfs.birthdayproject.domain.rule.Day;

import java.time.LocalDate;

public record Friend(String firstName, String lastName, String email, LocalDate birthday) {

    public boolean isMyBirthday(LocalDate currentDate) {
        return Day.isBirthDay(currentDate, birthday);
    }
}
