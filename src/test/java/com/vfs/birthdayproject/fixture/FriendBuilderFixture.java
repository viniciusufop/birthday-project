package com.vfs.birthdayproject.fixture;

import com.vfs.birthdayproject.domain.model.Friend;

import java.time.OffsetDateTime;

public final class FriendBuilderFixture {
    String firstName = "";
    String lastName = "";
    String email = "";
    OffsetDateTime birthday = OffsetDateTime.now();

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

    public FriendBuilderFixture setBirthday(OffsetDateTime birthday){
        this.birthday = birthday;
        return this;
    }

    public Friend build() {
        return new Friend(firstName, lastName, email, birthday);
    }
}
