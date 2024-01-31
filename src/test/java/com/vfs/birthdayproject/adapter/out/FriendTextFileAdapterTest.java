package com.vfs.birthdayproject.adapter.out;

import com.vfs.birthdayproject.domain.model.Friend;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
public class FriendTextFileAdapterTest {

    @Autowired
    private FriendTextFileAdapter adapter;

    @Test
    public void shouldAdapterReturnsAllFriendsInDataBase() {
        //when
        Collection<Friend> friends = adapter.getAllFriends();
        // given
        assertTrue(friends.stream().anyMatch(friend -> friend.firstName().equals("Name 1")));
        assertTrue(friends.stream().anyMatch(friend -> friend.firstName().equals("Name 2")));
        assertTrue(friends.stream().anyMatch(friend -> friend.firstName().equals("Name 3")));
    }
}
