package com.vfs.birthdayproject.adapter.in.util;

import com.vfs.birthdayproject.adapter.in.exception.InvalidInputDataException;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static java.lang.String.format;

@Component
public class LocalDateMapper {

    public LocalDate getLocalDateBasedInInputDate(String inputDate) throws InvalidInputDataException {
        if (inputDate.isEmpty()) {
            return LocalDate.now();
        } else {
            try {
                return LocalDate.parse(inputDate, DateTimeFormatter.ISO_DATE);
            } catch (DateTimeParseException ex) {
                throw new InvalidInputDataException(format("Invalid inputDate parameter [%s]. The standard is YYYY-MM-DD.", inputDate));
            }
        }
    }
}
