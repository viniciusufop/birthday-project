package com.vfs.birthdayproject.infrastructure.repository;

import com.vfs.birthdayproject.infrastructure.repository.entity.FriendEntity;
import com.vfs.birthdayproject.infrastructure.repository.entity.FriendKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendRepository extends JpaRepository<FriendEntity, FriendKey> {
}
