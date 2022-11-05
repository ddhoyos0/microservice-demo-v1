package org.example.domain.command;

import org.example.domain.value.DirectoryId;
import org.example.domain.value.Email;
import org.example.domain.value.Name;
import org.example.domain.value.UserId;
import org.example.generic.domain.Command;

public class CreateDirectoryCommand extends Command {
    private final DirectoryId id;
    private final Name name;
    private final Email email;
    private final UserId userId;

    public CreateDirectoryCommand(DirectoryId id, Name name, Email email, UserId userId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.userId = userId;
    }

    public DirectoryId getId() {
        return id;
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
