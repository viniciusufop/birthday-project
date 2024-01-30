package com.vfs.birthdayproject.domain.usecase.impl;

import com.vfs.birthdayproject.domain.model.Friend;
import com.vfs.birthdayproject.domain.model.ReminderBirthdayMessage;
import com.vfs.birthdayproject.domain.port.FriendPort;
import com.vfs.birthdayproject.domain.port.NotificationPort;
import com.vfs.birthdayproject.domain.usecase.SendReminderBirthdayMessageUseCase;

import java.time.OffsetDateTime;
import java.util.Collection;

public class SendReminderBirthdayMessageUseCaseImpl implements SendReminderBirthdayMessageUseCase {
    private final FriendPort friendPort;
    private final NotificationPort notificationPort;

    public SendReminderBirthdayMessageUseCaseImpl(FriendPort friendPort, NotificationPort notificationPort) {
        this.friendPort = friendPort;
        this.notificationPort = notificationPort;
    }

    @Override
    public void execute(OffsetDateTime datetime) {
        final Collection<Friend> friends = friendPort.getAllFriends();
        final Collection<Friend> friendsMakeBirthdayToday = friends.stream().filter(friend -> friend.isMyBirthday(datetime)).toList();
        friendsMakeBirthdayToday.forEach(birthdayPerson -> sendReminderMessage(birthdayPerson, excludeBirthdayPerson(friends, birthdayPerson)));
    }

    private void sendReminderMessage(Friend birthdayPerson, Collection<Friend> friends) {
        friends.forEach(friend -> notificationPort.sendMessage(friend, new ReminderBirthdayMessage(friend, birthdayPerson)));
    }

    private Collection<Friend> excludeBirthdayPerson(Collection<Friend> friends, Friend birthdayPerson) {
        return friends.stream().filter(friend -> !friend.equals(birthdayPerson)).toList();
    }
}
