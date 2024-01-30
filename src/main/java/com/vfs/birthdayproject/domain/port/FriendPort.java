package com.vfs.birthdayproject.domain.port;

import com.vfs.birthdayproject.domain.model.Friend;

import java.util.Collection;

public interface FriendPort {

    Collection<Friend> getAllFriends();
}
