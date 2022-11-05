package org.example.domain;

import org.example.domain.events.DirectoryCreated;
import org.example.generic.domain.EventChange;

import java.util.HashMap;

public class DirectoryEventChange extends EventChange {

    public DirectoryEventChange(Directory directory) {
        apply((DirectoryCreated event) -> {
            directory.name = event.getName();
            directory.email = event.getEmail();
            directory.userId = event.getUserId();
            directory.transactions = new HashMap<>();
        });
    }
}
