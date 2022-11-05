package org.example.domain.value;

import org.example.generic.domain.Identity;

public class DirectoryId extends Identity {

    public DirectoryId() {
    }

    public DirectoryId(String id) {
        super(id);
    }

    public static DirectoryId of(String id) {
        return new DirectoryId(id);
    }
}
