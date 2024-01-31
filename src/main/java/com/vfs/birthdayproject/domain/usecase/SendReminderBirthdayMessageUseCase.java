package com.vfs.birthdayproject.domain.usecase;

import java.time.LocalDate;
import java.time.OffsetDateTime;

public interface SendReminderBirthdayMessageUseCase {

    void execute(LocalDate datetime);
}
