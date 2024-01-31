package com.vfs.birthdayproject.adapter.in.util;

import com.vfs.birthdayproject.adapter.in.exception.InvalidInputDataException;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.vfs.birthdayproject.adapter.in.util.InConstants.INPUT_DATE_DEFAULT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LocalDateMapperTest {

    private final LocalDateMapper mapper = new LocalDateMapper();
    @Test
    public void shouldReturnsCurrentDateWhenInputDateIsEmpty() throws InvalidInputDataException {
        // given
        LocalDate current = LocalDate.now();
        // when
        LocalDate localDate = mapper.getLocalDateBasedInInputDate(INPUT_DATE_DEFAULT);
        // then
        assertEquals(current, localDate);
    }

    @Test
    public void shouldReturnsInformedDataWhenInputDateIsValid() throws InvalidInputDataException {
        // given
        String inputDate = "2012-05-12";
        // when
        LocalDate localDate = mapper.getLocalDateBasedInInputDate(inputDate);
        // then
        assertEquals(inputDate, localDate.format(DateTimeFormatter.ISO_DATE));
    }

    @Test
    public void shouldThrowsInvalidInputDataExceptionWhenInputDateIsInvalid() {
        // given
        LocalDate current = LocalDate.now();
        // when
        InvalidInputDataException ex = assertThrows(InvalidInputDataException.class, () -> mapper.getLocalDateBasedInInputDate("Invalid"));
        // then
        assertEquals("Invalid inputDate parameter [Invalid]. The standard is YYYY-MM-DD.", ex.getMessage());
    }
}
