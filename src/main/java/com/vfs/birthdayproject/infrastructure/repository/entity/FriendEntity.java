package com.vfs.birthdayproject.infrastructure.repository.entity;

import com.vfs.birthdayproject.domain.model.Friend;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.OffsetDateTime;
import java.util.Objects;

@Entity(name = "FRIENDS")
public class FriendEntity {

    @Id
    @EmbeddedId
    private FriendKey key;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "BIRTHDAY")
    private OffsetDateTime birthday;

    public FriendEntity() {
    }

    public FriendEntity(FriendKey key, String email, OffsetDateTime birthday) {
        this.key = key;
        this.email = email;
        this.birthday = birthday;
    }

    public FriendKey getKey() {
        return key;
    }

    public void setKey(FriendKey key) {
        this.key = key;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public OffsetDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(OffsetDateTime birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FriendEntity that = (FriendEntity) o;
        return Objects.equals(key, that.key) && Objects.equals(email, that.email) && Objects.equals(birthday, that.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, email, birthday);
    }

    public Friend buildDomain() {
        return new Friend(key.getFirstName(), key.getLastName(), email, birthday);
    }
}
