package com.vfs.birthdayproject.adapter.out;

import com.vfs.birthdayproject.domain.model.Friend;
import com.vfs.birthdayproject.infrastructure.repository.FriendRepository;
import com.vfs.birthdayproject.infrastructure.repository.entity.FriendEntity;
import com.vfs.birthdayproject.infrastructure.repository.entity.FriendKey;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.OffsetDateTime;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FriendSqliteAdapterTest {

    @Mock
    private FriendRepository repository;
    @InjectMocks
    private FriendSqliteAdapter adapter;

    @Test
    public void shouldAdapterReturnsAllFriendsInDataBase() {
        // given
        when(repository.findAll()).thenReturn(List.of(buildEntity("1"), buildEntity("2"), buildEntity("3")));
        //when
        Collection<Friend> friends = adapter.getAllFriends();
        // given
        assertTrue(friends.stream().anyMatch(friend -> friend.getFirstName().equals("Name 1")));
        assertTrue(friends.stream().anyMatch(friend -> friend.getFirstName().equals("Name 2")));
        assertTrue(friends.stream().anyMatch(friend -> friend.getFirstName().equals("Name 3")));
    }

    private FriendEntity buildEntity(String id) {
        return new FriendEntity(new FriendKey("Name " + id, ""), id + "@mail.com", OffsetDateTime.now());
    }
}
