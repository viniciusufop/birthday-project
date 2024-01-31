package com.vfs.birthdayproject.domain.rule;

import java.time.LocalDate;
import java.time.Month;

public final class Day {

    private Day(){}

    public static boolean isBirthDay(final LocalDate date, final LocalDate birthDay){
        if (date.getMonth().equals(birthDay.getMonth()) && date.getDayOfMonth() == birthDay.getDayOfMonth())
            return true;
        return date.getMonth().equals(birthDay.getMonth()) && date.getMonth().equals(Month.FEBRUARY) &&
                birthDay.getDayOfMonth() == 29 && date.getDayOfMonth() == 28;
    }

}
