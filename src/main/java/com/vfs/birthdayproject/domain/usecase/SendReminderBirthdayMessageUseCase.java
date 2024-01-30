package com.vfs.birthdayproject.domain.usecase;

import java.time.OffsetDateTime;

public interface SendReminderBirthdayMessageUseCase {

    void execute(OffsetDateTime datetime);
}
