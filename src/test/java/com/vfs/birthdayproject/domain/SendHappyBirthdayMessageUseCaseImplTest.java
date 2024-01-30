package com.vfs.birthdayproject.domain;

import com.vfs.birthdayproject.domain.model.Friend;
import com.vfs.birthdayproject.domain.port.FriendPort;
import com.vfs.birthdayproject.domain.port.NotificationPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.OffsetDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
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
        final String firstName = "Vinicius";
        final String lastName = "Souza";
        final String email = "vinicius_ufop@yahoo.com.br";
        final OffsetDateTime birthday = OffsetDateTime.now().withMonth(1).withDayOfMonth(1);
        final Friend friend = new Friend(firstName, lastName, email, birthday);

        final String friendFirstName = "John";
        final String friendLastName = "Snow";
        final String friendEmail = "vinicius_ufop@yahoo.com.br";
        final OffsetDateTime friendBirthday = OffsetDateTime.now().withMonth(12);
        final Friend birthFriend = new Friend(friendFirstName, friendLastName, friendEmail, friendBirthday);

        OffsetDateTime dateTime = OffsetDateTime.now().withMonth(1).withDayOfMonth(1);
        when(friendPort.getAllFriends()).thenReturn(List.of(friend, birthFriend));
        // when
        assertDoesNotThrow(() -> service.execute(dateTime));
        // then
        verify(notificationPort).sendMessage(friend, friend.buildHappyBirthdayMessage());
    }
}
