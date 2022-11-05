package org.example.domain.events;

import org.example.domain.value.Email;
import org.example.domain.value.Name;
import org.example.domain.value.UserId;
import org.example.generic.domain.DomainEvent;

public class DirectoryCreated extends DomainEvent {
    private final Name name;
    private final Email email;
    private final UserId userId;


    public DirectoryCreated(Name name, Email email, UserId userId) {
        super("org.example.DirectoryCreated");
        this.name = name;
        this.userId = userId;
        this.email = email;
    }

    public Name getName() {
        return name;
    }

    public Email getEmail() {
        return email;
    }

    public UserId getUserId() {
        return userId;
    }
}
