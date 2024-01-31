package com.vfs.birthdayproject.domain.usecase.impl;

import com.vfs.birthdayproject.domain.model.Friend;
import com.vfs.birthdayproject.domain.model.HappyBirthdayMessage;
import com.vfs.birthdayproject.domain.port.FriendPort;
import com.vfs.birthdayproject.domain.port.NotificationPort;
import com.vfs.birthdayproject.fixture.FriendBuilderFixture;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class SendHappyBirthdayMessageUseCaseImplTest {

    @Mock
    private FriendPort friendPort;
    @Mock
    private NotificationPort notificationPort;
    @InjectMocks
    private SendHappyBirthdayMessageUseCaseImpl service;

    @Test
    public void shouldSendAHappyBirthdayMessageWhenItIsAFriendBirthday() {
        // given
        final LocalDate birthday = LocalDate.now().withMonth(1).withDayOfMonth(1);
        final FriendBuilderFixture friendBuilder = new FriendBuilderFixture();
        final Friend friend = friendBuilder.setBirthday(birthday).build();

        final LocalDate friendBirthday = LocalDate.now().withMonth(12);
        final FriendBuilderFixture birthPersonBuilder = new FriendBuilderFixture();
        final Friend birthPerson = birthPersonBuilder.setBirthday(friendBirthday).build();

        LocalDate dateTime = LocalDate.now().withMonth(1).withDayOfMonth(1);
        when(friendPort.getAllFriends()).thenReturn(List.of(friend, birthPerson));
        // when
        assertDoesNotThrow(() -> service.execute(dateTime));
        // then
        verify(notificationPort).sendMessage(eq(friend), eq(new HappyBirthdayMessage(friend)));
    }
}
