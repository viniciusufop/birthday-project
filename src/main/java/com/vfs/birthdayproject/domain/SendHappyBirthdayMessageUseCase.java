package com.vfs.birthdayproject.domain;

import java.time.OffsetDateTime;

public interface SendHappyBirthdayMessageUseCase {

    void execute(OffsetDateTime dateTime);
}
