package com.vfs.birthdayproject.domain.model;

import com.vfs.birthdayproject.fixture.FriendBuilderFixture;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class FriendTest {

    @Test
    public void shouldReturnsTrueWhenIsMyBirthday() {
        // given
        final LocalDate birthday = LocalDate.now().withYear(1988).withMonth(6).withDayOfMonth(29);
        final FriendBuilderFixture friendBuilder = new FriendBuilderFixture();
        final Friend friend = friendBuilder.setBirthday(birthday).build();
        // when
        final boolean isMyBirthday = friend.isMyBirthday(LocalDate.now().withMonth(6).withDayOfMonth(29));
        // then
        assertTrue(isMyBirthday);
    }

    @Test
    public void shouldReturnsFalseWhenIsNotMyBirthday() {
        // given
        final LocalDate birthday = LocalDate.now().withYear(1988).withMonth(6).withDayOfMonth(29);
        final FriendBuilderFixture friendBuilder = new FriendBuilderFixture();
        final Friend friend = friendBuilder.setBirthday(birthday).build();
        // when
        final boolean isMyBirthday = friend.isMyBirthday(LocalDate.now().withMonth(6).withDayOfMonth(12));
        // then
        assertFalse(isMyBirthday);
    }

    @Test
    public void shouldReturnsTrueWhenIsFev28AndMyBirthdayIsFev29() {
        // given
        final LocalDate birthday = LocalDate.now().withYear(2000).withMonth(2).withDayOfMonth(29);
        final FriendBuilderFixture friendBuilder = new FriendBuilderFixture();
        final Friend friend = friendBuilder.setBirthday(birthday).build();
        // when
        final boolean isMyBirthday = friend.isMyBirthday(LocalDate.now().withMonth(2).withDayOfMonth(28));
        // then
        assertTrue(isMyBirthday);
    }
}


