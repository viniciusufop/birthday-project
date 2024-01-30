package com.vfs.birthdayproject.domain.model;

import com.vfs.birthdayproject.fixture.FriendBuilderFixture;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageTest {

    @Test
    public void shouldReturnsHappyBirthdayMessage() {
        // given
        final String firstName = "Vinicius";
        final FriendBuilderFixture friendBuilder = new FriendBuilderFixture();
        final Friend friend = friendBuilder.setFirstName(firstName).build();
        // when
        final Message message = new HappyBirthdayMessage(friend);
        // then
        assertEquals("Happy birthday!", message.getSubject());
        assertEquals("Happy birthday, dear " + firstName + "!", message.getBody());
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
        final Message message = new ReminderBirthdayMessage(friend, birthFriend);
        // then
        assertEquals("Birthday Reminder", message.getSubject());
        assertEquals("Dear Vinicius\nToday is John Snow's birthday.\n\t\tDon't forget to send him a message !", message.getBody());
    }
}
