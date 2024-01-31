package com.vfs.birthdayproject.domain.model;

import java.time.LocalDate;
import java.time.Month;
import java.util.Objects;

public class Friend {

    private final String firstName;
    private final String lastName;
    private final String email;
    private final LocalDate birthday;

    public Friend(String firstName, String lastName, String email, LocalDate birthday) {
        //TODO validate and return error for invalid friends data
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthday = birthday;
    }

    public boolean isMyBirthday(LocalDate currentDate) {
        if (currentDate.getMonth().equals(birthday.getMonth()) && currentDate.getDayOfMonth() == birthday.getDayOfMonth())
            return true;
        return currentDate.getMonth().equals(birthday.getMonth()) && currentDate.getMonth().equals(Month.FEBRUARY) &&
                birthday.getDayOfMonth() == 29 && currentDate.getDayOfMonth() == 28;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Friend friend = (Friend) o;
        return Objects.equals(firstName, friend.firstName) && Objects.equals(lastName, friend.lastName) && Objects.equals(email, friend.email) && Objects.equals(birthday, friend.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, birthday);
    }
}
