package com.vfs.birthdayproject.adapter.out;

import com.vfs.birthdayproject.domain.model.Friend;
import com.vfs.birthdayproject.domain.model.Message;
import com.vfs.birthdayproject.domain.port.NotificationPort;
import org.springframework.stereotype.Component;

@Component // this is a component outside the domain scope, so we create the bean directly
public class EmailNotificationAdapter implements NotificationPort {
    @Override
    public void sendMessage(Friend friend, Message message) {
        // In this case we need to create dependencies that allows us to send an email
        System.out.printf(
                """
                <-- Simulate send a Message -->
                To: %s
                Subject: %s
                Body: %s
                                
                <-- End of the Message -->
                %n""",
                friend.email(),
                message.getSubject(),
                message.getBody()
        );
    }
}
