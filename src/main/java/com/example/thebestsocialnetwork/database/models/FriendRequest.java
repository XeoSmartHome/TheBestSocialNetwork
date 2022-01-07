package com.example.thebestsocialnetwork.database.models;

import database.Model;
import database.columns.StringColumn;

public class FriendRequest extends Model {

    public final StringColumn from = new StringColumn("from");
    public final StringColumn to = new StringColumn("to");
    public final StringColumn status = new StringColumn("status");

    public FriendRequest(String id, String from, String to) {
        super(id);
        this.from.setValue(from);
        this.to.setValue(to);
    }

    @Override
    public String getTableName() {
        return "friendships";
    }
}
