package org.example.application.queries.adapter.repo;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class DirectoryModelView {
    private String id;
    private String name;
    private String email;
    private String userId;
    private Set<TransactionModelView> transactionModelViews;

    public Set<TransactionModelView> getTransactionModelViews() {
        if(Objects.isNull(transactionModelViews)){
            return new HashSet<>();
        }
        return transactionModelViews;
    }

    public void setTransactionModelViews(Set<TransactionModelView> transactionModelViews) {
        this.transactionModelViews = transactionModelViews;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "DirectoryModelView{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", userId='" + userId + '\'' +
                ", transactionModelViews=" + transactionModelViews +
                '}';
    }
}
