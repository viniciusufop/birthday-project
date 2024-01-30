package com.vfs.birthdayproject.infrastructure.repository.entity;

import com.vfs.birthdayproject.domain.model.Friend;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FriendEntityTest {

    @Test
    public void shouldFriendTestBuildFriend() {
        // given
        final String firstName = "John";
        final String lastName = "Test";
        final String email = "=john.test@email.com";
        final OffsetDateTime birthday = OffsetDateTime.now();
        final FriendEntity entity = new FriendEntity(new FriendKey(firstName, lastName), email, birthday);
        // when
        final Friend friend = entity.buildDomain();
        // then
        assertEquals(firstName, friend.getFirstName());
        assertEquals(lastName, friend.getLastName());
        assertEquals(email, friend.getEmail());
        assertEquals(birthday, friend.getBirthday());
    }
}
