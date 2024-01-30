package com.vfs.birthdayproject.domain.usecase.impl;

import com.vfs.birthdayproject.domain.model.Friend;
import com.vfs.birthdayproject.domain.model.ReminderBirthdayMessage;
import com.vfs.birthdayproject.domain.port.FriendPort;
import com.vfs.birthdayproject.domain.port.NotificationPort;
import com.vfs.birthdayproject.fixture.FriendBuilderFixture;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.OffsetDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SendReminderBirthdayMessageUseCaseImplTest {

    @Mock
    private FriendPort friendPort;
    @Mock
    private NotificationPort notificationPort;
    @InjectMocks
    private SendReminderBirthdayMessageUseCaseImpl service;

    @Test
    public void shouldSendReminderMessageForAllFriendsExceptTheBirthdayPerson() {
        // given
        final OffsetDateTime birthday = OffsetDateTime.now().withMonth(10).withDayOfMonth(5);
        final FriendBuilderFixture friendBuilder = new FriendBuilderFixture();
        final Friend friend = friendBuilder.setBirthday(birthday).setFirstName("Matt").build();
        final OffsetDateTime secondBirthday = OffsetDateTime.now().withMonth(12).withDayOfMonth(6);
        final FriendBuilderFixture secondFriendBuilder = new FriendBuilderFixture();
        final Friend secondFriend = secondFriendBuilder.setBirthday(secondBirthday).setFirstName("John").build();

        final OffsetDateTime friendBirthday = OffsetDateTime.now().withYear(1995).withMonth(1).withDayOfMonth(1);
        final FriendBuilderFixture birthPersonBuilder = new FriendBuilderFixture();
        final Friend birthPerson = birthPersonBuilder.setBirthday(friendBirthday).build();

        OffsetDateTime dateTime = OffsetDateTime.now().withMonth(1).withDayOfMonth(1);
        when(friendPort.getAllFriends()).thenReturn(List.of(friend, birthPerson, secondFriend));
        // when
        assertDoesNotThrow(() -> service.execute(dateTime));

        // then
        verify(notificationPort).sendMessage(eq(friend), eq(new ReminderBirthdayMessage(friend, birthPerson)));
        verify(notificationPort).sendMessage(eq(secondFriend), eq(new ReminderBirthdayMessage(secondFriend, birthPerson)));
    }
}
