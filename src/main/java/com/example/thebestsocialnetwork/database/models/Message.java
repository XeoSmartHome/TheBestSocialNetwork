package com.example.thebestsocialnetwork.database.models;

import database.Model;
import database.columns.StringColumn;

public class Message extends Model {

    public final StringColumn from = new StringColumn("from");
    public final StringColumn to = new StringColumn("to");
    public final StringColumn message = new StringColumn("message");
    public final StringColumn parent = new StringColumn("parent");

    public Message(String id) {
        super(id);
    }

    @Override
    public String getTableName() {
        return "messages";
    }
}
