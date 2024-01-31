package com.vfs.birthdayproject.infrastructure.repository.entity;

import com.vfs.birthdayproject.domain.model.Friend;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.Objects;

import static java.time.format.DateTimeFormatter.ISO_DATE;

@Entity(name = "FRIENDS")
public class FriendEntity {

    @Id
    @EmbeddedId
    private FriendKey key;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "BIRTHDAY")
    private String birthday;

    public FriendEntity() {
    }

    public FriendEntity(FriendKey key, String email, LocalDate birthday) {
        this.key = key;
        this.email = email;
        this.birthday = birthday.format(ISO_DATE);
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

    public LocalDate getBirthday() {
        return LocalDate.parse(birthday, ISO_DATE);
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday.format(ISO_DATE);
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
        return new Friend(key.getFirstName(), key.getLastName(), email, getBirthday());
    }
}
