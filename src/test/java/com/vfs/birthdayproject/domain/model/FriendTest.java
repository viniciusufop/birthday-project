package com.vfs.birthdayproject.domain.model;

import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class FriendTest {

    @Test
    public void shouldReturnsTrueWhenIsMyBirthday() {
        // given
        final String firstName = "Vinicius";
        final String lastName = "Souza";
        final String email = "vinicius_ufop@yahoo.com.br";
        final OffsetDateTime birthday = OffsetDateTime.now().withYear(1988).withMonth(6).withDayOfMonth(29);
        final Friend friend = new Friend(firstName, lastName, email, birthday);
        // when
        final boolean isMyBirthday = friend.isMyBirthday(OffsetDateTime.now().withMonth(6).withDayOfMonth(29));
        // then
        assertTrue(isMyBirthday);
    }

    @Test
    public void shouldReturnsFalseWhenIsNotMyBirthday() {
        final String firstName = "Vinicius";
        final String lastName = "Souza";
        final String email = "vinicius_ufop@yahoo.com.br";
        final OffsetDateTime birthday = OffsetDateTime.now().withYear(1988).withMonth(6).withDayOfMonth(29);
        final Friend friend = new Friend(firstName, lastName, email, birthday);
        assertFalse(friend.isMyBirthday(OffsetDateTime.now().withMonth(6).withDayOfMonth(12)));
    }

    @Test
    public void shouldReturnsTrueWhenIsFev28AndMyBirthdayIsFev29() {
        // given
        final String firstName = "Vinicius";
        final String lastName = "Souza";
        final String email = "vinicius_ufop@yahoo.com.br";
        final OffsetDateTime birthday = OffsetDateTime.now().withYear(2000).withMonth(2).withDayOfMonth(29);
        // when
        final Friend friend = new Friend(firstName, lastName, email, birthday);
        // then
        assertTrue(friend.isMyBirthday(OffsetDateTime.now().withMonth(2).withDayOfMonth(28)));
    }

    @Test
    public void shouldReturnsHappyBirthdayMessage() {
        // given
        final String firstName = "Vinicius";
        final String lastName = "Souza";
        final String email = "vinicius_ufop@yahoo.com.br";
        final OffsetDateTime birthday = OffsetDateTime.now().withYear(2000).withMonth(2).withDayOfMonth(29);
        // when
        final Friend friend = new Friend(firstName, lastName, email, birthday);
        final Message message = friend.buildHappyBirthdayMessage();
        // then
        assertEquals("Happy birthday!", message.subject());
        assertEquals("Happy birthday, dear " + firstName + "!", message.body());
    }

    @Test
    public void shouldReturnsReminderBirthdayMessage() {
        // given
        final String firstName = "Vinicius";
        final String lastName = "Souza";
        final String email = "vinicius_ufop@yahoo.com.br";
        final OffsetDateTime birthday = OffsetDateTime.now();
        final Friend friend = new Friend(firstName, lastName, email, birthday);

        final String friendFirstName = "John";
        final String friendLastName = "Snow";
        final String friendEmail = "vinicius_ufop@yahoo.com.br";
        final OffsetDateTime friendBirthday = OffsetDateTime.now();
        final Friend birthFriend = new Friend(friendFirstName, friendLastName, friendEmail, friendBirthday);
        // when
        final Message message = friend.buildReminderBirthdayMessage(birthFriend);
        // then
        assertEquals("Birthday Reminder", message.subject());
        assertEquals("Dear Vinicius\nToday is John Snow's birthday.\n\t\tDon't forget to send him a message !", message.body());
    }
}


