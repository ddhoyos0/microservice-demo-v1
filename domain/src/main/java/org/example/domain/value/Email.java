package org.example.domain.value;

import org.example.generic.domain.ValueObject;

import java.util.Objects;

public class Email implements ValueObject<String> {
    private final String value;

    public Email(String value) {
        this.value = Objects.requireNonNull(value);
        if (this.value.isEmpty()) {
            throw new IllegalArgumentException("The email is empty");
        }

        if (this.value.length() > 300) {
            throw new IllegalArgumentException("The email is greater than 300");
        }
    }

    @Override
    public String value() {
        return value;
    }
}
