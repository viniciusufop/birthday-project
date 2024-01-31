package com.vfs.birthdayproject.domain.rule;

public final class Year {
    private Year() {
    }

    public static boolean isLeapYear(int year) {
        if (year < 1582) return false;
        if (year % 400 == 0) return true;
        if (year % 4 != 0) return false;
        return year % 100 != 0;
    }
}
