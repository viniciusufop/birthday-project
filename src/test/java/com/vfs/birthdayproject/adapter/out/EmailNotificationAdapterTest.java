package com.vfs.birthdayproject.adapter.out;

import com.vfs.birthdayproject.domain.model.Friend;
import com.vfs.birthdayproject.domain.model.HappyBirthdayMessage;
import com.vfs.birthdayproject.domain.model.Message;
import com.vfs.birthdayproject.fixture.FriendBuilderFixture;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmailNotificationAdapterTest {

    private final EmailNotificationAdapter adapter = new EmailNotificationAdapter();

    @Test
    public void shouldProcessNotificationMessage(){
        // given
        final FriendBuilderFixture builder = new FriendBuilderFixture();
        final Friend friend = builder.build();
        final Message message = new HappyBirthdayMessage(friend);
        // when
        assertDoesNotThrow(() -> adapter.sendMessage(friend, message));
        // then
        assertTrue(true);
    }
}
