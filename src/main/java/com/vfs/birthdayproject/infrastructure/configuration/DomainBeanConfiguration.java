package com.vfs.birthdayproject.infrastructure.configuration;

import com.vfs.birthdayproject.domain.port.FriendPort;
import com.vfs.birthdayproject.domain.port.NotificationPort;
import com.vfs.birthdayproject.domain.usecase.SendHappyBirthdayMessageUseCase;
import com.vfs.birthdayproject.domain.usecase.SendReminderBirthdayMessageUseCase;
import com.vfs.birthdayproject.domain.usecase.impl.SendHappyBirthdayMessageUseCaseImpl;
import com.vfs.birthdayproject.domain.usecase.impl.SendReminderBirthdayMessageUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * These domain configuration are external to evict to use spring inside the domain path
 */
@Configuration
public class DomainBeanConfiguration {

    @Bean
    public SendHappyBirthdayMessageUseCase sendHappyBirthdayMessageUseCase(
            final FriendPort friendPort,
            final NotificationPort notificationPort) {
        return new SendHappyBirthdayMessageUseCaseImpl(friendPort, notificationPort);
    }

    @Bean
    public SendReminderBirthdayMessageUseCase sendReminderBirthdayMessageUseCase(
            final FriendPort friendPort,
            final NotificationPort notificationPort) {
        return new SendReminderBirthdayMessageUseCaseImpl(friendPort, notificationPort);
    }
}
