package com.vfs.birthdayproject.domain.model;

import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
}


