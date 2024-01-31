package com.vfs.birthdayproject.fixture;

import com.vfs.birthdayproject.domain.model.Friend;

import java.time.LocalDate;
import java.time.OffsetDateTime;

public final class FriendBuilderFixture {
    String firstName = "";
    String lastName = "";
    String email = "";
    LocalDate birthday = LocalDate.now();

    public FriendBuilderFixture setFirstName(String firstName){
        this.firstName = firstName;
        return this;
    }

    public FriendBuilderFixture setLastName(String lastName){
        this.lastName = lastName;
        return this;
    }

    public FriendBuilderFixture setEmail(String email){
        this.email = email;
        return this;
    }

    public FriendBuilderFixture setBirthday(LocalDate birthday){
        this.birthday = birthday;
        return this;
    }

    public Friend build() {
        return new Friend(firstName, lastName, email, birthday);
    }
}
