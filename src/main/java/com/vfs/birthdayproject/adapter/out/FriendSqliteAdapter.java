package com.vfs.birthdayproject.adapter.out;

import com.vfs.birthdayproject.domain.model.Friend;
import com.vfs.birthdayproject.domain.port.FriendPort;
import com.vfs.birthdayproject.infrastructure.repository.FriendRepository;
import com.vfs.birthdayproject.infrastructure.repository.entity.FriendEntity;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

@Component // this is a component outside the domain scope, so we create the bean directly
public class FriendSqliteAdapter implements FriendPort {

    private final FriendRepository repository;

    public FriendSqliteAdapter(FriendRepository repository) {
        this.repository = repository;
    }

    @Override
    public Collection<Friend> getAllFriends() {
        return repository.findAll().stream().map(FriendEntity::buildDomain).collect(Collectors.toList());
    }
}
