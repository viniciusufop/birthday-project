package com.vfs.birthdayproject.domain.rule;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DayTest {

    @Test
    public void shouldReturnsTrueWhenIsMyBirthday() {
        // given
        final LocalDate birthday = LocalDate.now().withYear(1988).withMonth(6).withDayOfMonth(29);
        // when
        final boolean isBirthday = Day.isBirthDay(LocalDate.now().withMonth(6).withDayOfMonth(29), birthday);
        // then
        assertTrue(isBirthday);
    }

    @Test
    public void shouldReturnsFalseWhenIsNotMyBirthday() {
        // given
        final LocalDate birthday = LocalDate.now().withYear(1988).withMonth(6).withDayOfMonth(29);
        // when
        final boolean isBirthday = Day.isBirthDay(LocalDate.now().withMonth(6).withDayOfMonth(12), birthday);
        // then
        assertFalse(isBirthday);
    }

    @Test
    public void shouldReturnsTrueWhenIsFev28AndMyBirthdayIsFev29() {
        // given
        final LocalDate birthday = LocalDate.now().withYear(2000).withMonth(2).withDayOfMonth(29);
        // when
        final boolean isBirthday = Day.isBirthDay(LocalDate.now().withMonth(2).withDayOfMonth(28), birthday);
        // then
        assertTrue(isBirthday);
    }
}
