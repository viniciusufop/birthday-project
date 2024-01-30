package com.vfs.birthdayproject.domain.usecase;

import java.time.OffsetDateTime;

public interface SendHappyBirthdayMessageUseCase {

    void execute(OffsetDateTime dateTime);
}
