package com.vfs.birthdayproject.domain.rule;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class YearTest {

    @Test
    public void shouldReturnsFalseWhenYearIsLessThan1582(){
        assertFalse(Year.isLeapYear(1200));
        assertFalse(Year.isLeapYear(1580));
    }
    @Test
    public void shouldReturnsTrueWhenYearIsMultipleBy400(){
        assertTrue(Year.isLeapYear(1600));
        assertTrue(Year.isLeapYear(2000));
        assertTrue(Year.isLeapYear(2400));
        assertTrue(Year.isLeapYear(2800));
    }

    @Test
    public void shouldReturnsFalseWhenYearIsNotMultipleBy4(){
        assertFalse(Year.isLeapYear(2013));
        assertFalse(Year.isLeapYear(2010));
    }

    @Test
    public void shouldReturnsFalseWhenYearIsMultipleBy4AndIsMultipleBy100(){
        assertFalse(Year.isLeapYear(1700));
        assertFalse(Year.isLeapYear(1800));
        assertFalse(Year.isLeapYear(1900));
    }

    @Test
    public void shouldReturnsTrueWhenYearIsMultipleBy4AndIsNotMultipleBy100(){
        assertTrue(Year.isLeapYear(1704));
        assertTrue(Year.isLeapYear(1812));
        assertTrue(Year.isLeapYear(1940));
    }
}
