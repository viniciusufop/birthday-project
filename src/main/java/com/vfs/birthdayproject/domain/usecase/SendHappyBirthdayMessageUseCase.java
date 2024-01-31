package com.vfs.birthdayproject.domain.usecase;

import java.time.LocalDate;
import java.time.OffsetDateTime;

public interface SendHappyBirthdayMessageUseCase {

    void execute(LocalDate dateTime);
}
