package com.vfs.birthdayproject.domain.model;

import com.vfs.birthdayproject.fixture.FriendBuilderFixture;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class FriendTest {

    @Test
    public void shouldReturnsTrueWhenIsMyBirthday() {
        // given
        final OffsetDateTime birthday = OffsetDateTime.now().withYear(1988).withMonth(6).withDayOfMonth(29);
        final FriendBuilderFixture friendBuilder = new FriendBuilderFixture();
        final Friend friend = friendBuilder.setBirthday(birthday).build();
        // when
        final boolean isMyBirthday = friend.isMyBirthday(OffsetDateTime.now().withMonth(6).withDayOfMonth(29));
        // then
        assertTrue(isMyBirthday);
    }

    @Test
    public void shouldReturnsFalseWhenIsNotMyBirthday() {
        // given
        final OffsetDateTime birthday = OffsetDateTime.now().withYear(1988).withMonth(6).withDayOfMonth(29);
        final FriendBuilderFixture friendBuilder = new FriendBuilderFixture();
        final Friend friend = friendBuilder.setBirthday(birthday).build();
        // when
        final boolean isMyBirthday = friend.isMyBirthday(OffsetDateTime.now().withMonth(6).withDayOfMonth(12));
        // then
        assertFalse(isMyBirthday);
    }

    @Test
    public void shouldReturnsTrueWhenIsFev28AndMyBirthdayIsFev29() {
        // given
        final OffsetDateTime birthday = OffsetDateTime.now().withYear(2000).withMonth(2).withDayOfMonth(29);
        final FriendBuilderFixture friendBuilder = new FriendBuilderFixture();
        final Friend friend = friendBuilder.setBirthday(birthday).build();
        // when
        final boolean isMyBirthday = friend.isMyBirthday(OffsetDateTime.now().withMonth(2).withDayOfMonth(28));
        // then
        assertTrue(isMyBirthday);
    }

    @Test
    public void shouldReturnsHappyBirthdayMessage() {
        // given
        final String firstName = "Vinicius";
        final FriendBuilderFixture friendBuilder = new FriendBuilderFixture();
        final Friend friend = friendBuilder.setFirstName(firstName).build();
        // when
        final Message message = friend.buildHappyBirthdayMessage();
        // then
        assertEquals("Happy birthday!", message.subject());
        assertEquals("Happy birthday, dear " + firstName + "!", message.body());
    }

    @Test
    public void shouldReturnsReminderBirthdayMessage() {
        // given
        final String firstName = "Vinicius";
        final FriendBuilderFixture friendBuilder = new FriendBuilderFixture();
        final Friend friend = friendBuilder.setFirstName(firstName).build();

        final String friendFirstName = "John";
        final String friendLastName = "Snow";
        final FriendBuilderFixture birthFriendBuilder = new FriendBuilderFixture();
        final Friend birthFriend = birthFriendBuilder.setFirstName(friendFirstName).setLastName(friendLastName).build();
        // when
        final Message message = friend.buildReminderBirthdayMessage(birthFriend);
        // then
        assertEquals("Birthday Reminder", message.subject());
        assertEquals("Dear Vinicius\nToday is John Snow's birthday.\n\t\tDon't forget to send him a message !", message.body());
    }
}


