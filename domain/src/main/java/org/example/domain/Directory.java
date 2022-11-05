package org.example.domain;

import org.example.domain.events.DirectoryCreated;
import org.example.domain.value.DirectoryId;
import org.example.domain.value.Email;
import org.example.domain.value.Name;
import org.example.domain.value.TransactionId;
import org.example.domain.value.UserId;
import org.example.generic.domain.AggregateRoot;
import org.example.generic.domain.DomainEvent;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Directory extends AggregateRoot<DirectoryId> {
    protected Name name;
    protected Email email;
    protected UserId userId;
    protected Map<TransactionId, Transaction> transactions;

    public Directory(DirectoryId id, Name name, Email email, UserId userId) {
        super(id);
        subscribe(new DirectoryEventChange(this));
        appendChange(new DirectoryCreated(name, email, userId));
    }

    private Directory(DirectoryId id) {
        super(id);
        subscribe(new DirectoryEventChange(this));
    }

    public static Directory from(DirectoryId id, List<DomainEvent> events) {
        var directory = new Directory(id);
        events.forEach(directory::appendChange);
        return directory;
    }

    public Transaction getTransactionById(Transaction id) {
        return transactions.get(id);
    }

    public Collection<Transaction> transactions() {
        return transactions.values();
    }

    public Name name() {
        return name;
    }

    public UserId userId() {
        return userId;
    }

    public Email email() {
        return email;
    }
}
