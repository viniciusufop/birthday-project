package com.vfs.birthdayproject.domain.model;

import java.util.Objects;

public abstract class Message {

    private final String subject;
    private final String body;

    protected Message(String subject, String body) {
        this.subject = subject;
        this.body = body;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(subject, message.subject) && Objects.equals(body, message.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subject, body);
    }
}
