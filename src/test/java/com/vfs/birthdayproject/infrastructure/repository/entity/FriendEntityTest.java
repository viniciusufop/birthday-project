package com.vfs.birthdayproject.infrastructure.repository.entity;

import com.vfs.birthdayproject.domain.model.Friend;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FriendEntityTest {

    @Test
    public void shouldFriendTestBuildFriend() {
        // given
        final String firstName = "John";
        final String lastName = "Test";
        final String email = "=john.test@email.com";
        final LocalDate birthday = LocalDate.now();
        final FriendEntity entity = new FriendEntity(new FriendKey(firstName, lastName), email, birthday);
        // when
        final Friend friend = entity.buildDomain();
        // then
        assertEquals(firstName, friend.firstName());
        assertEquals(lastName, friend.lastName());
        assertEquals(email, friend.email());
        assertEquals(birthday, friend.birthday());
    }
}
