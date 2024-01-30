package com.vfs.birthdayproject.domain.usecase.impl;

import com.vfs.birthdayproject.domain.model.Friend;
import com.vfs.birthdayproject.domain.port.FriendPort;
import com.vfs.birthdayproject.domain.port.NotificationPort;
import com.vfs.birthdayproject.domain.usecase.SendHappyBirthdayMessageUseCase;

import java.time.OffsetDateTime;
import java.util.Collection;

public class SendHappyBirthdayMessageUseCaseImpl implements SendHappyBirthdayMessageUseCase {
    private final FriendPort friendPort;
    private final NotificationPort notificationPort;

    public SendHappyBirthdayMessageUseCaseImpl(FriendPort friendPort, NotificationPort notificationPort) {
        this.friendPort = friendPort;
        this.notificationPort = notificationPort;
    }

    @Override
    public void execute(OffsetDateTime dateTime) {
        final Collection<Friend> friends = friendPort.getAllFriends();
        friends.stream()
                .filter(friend -> friend.isMyBirthday(dateTime))
                .forEach(friend -> notificationPort.sendMessage(friend, friend.buildHappyBirthdayMessage()));
    }
}
