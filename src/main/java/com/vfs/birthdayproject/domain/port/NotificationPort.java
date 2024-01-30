package com.vfs.birthdayproject.domain.port;

import com.vfs.birthdayproject.domain.model.Friend;
import com.vfs.birthdayproject.domain.model.Message;

public interface NotificationPort {

    void sendMessage(Friend friend, Message message);
}
