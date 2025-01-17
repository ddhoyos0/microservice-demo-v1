package org.example.application.queries.adapter.repo;

import java.util.Date;

public class TransactionModelView {
    private String id;
    private Date date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "TransactionModelView{" +
                "id='" + id + '\'' +
                ", date=" + date +
                '}';
    }
}
