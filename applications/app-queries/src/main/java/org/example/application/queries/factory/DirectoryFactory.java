package org.example.application.queries.factory;

import org.example.application.queries.adapter.repo.DirectoryModelView;
import org.example.domain.events.DirectoryCreated;

public final class DirectoryFactory {

    public static DirectoryModelView modelView(DirectoryCreated event) {
        var document = new DirectoryModelView();
        document.setId(event.aggregateRootId());
        document.setName(event.getName().value());
        document.setEmail(event.getEmail().value());
        document.setUserId(event.getUserId().value());
        return document;
    }
}
