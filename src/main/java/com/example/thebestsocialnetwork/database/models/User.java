package com.example.thebestsocialnetwork.database.models;

import database.Model;
import database.columns.StringColumn;


public class User extends Model {

    public final StringColumn id = new StringColumn("id");
    public final StringColumn firstName = new StringColumn("first_name");
    public final StringColumn lastName = new StringColumn("last_name");
    public final StringColumn email = new StringColumn("email");
    public final StringColumn passwordHash = new StringColumn("password_hash");

    @Override
    public String getTableName() {
        return "users";
    }

    public User(String firstName, String lastName, String email, String password) {
        super("112113");
        this.id.setValue("112113");
        this.firstName.setValue(firstName);
        this.lastName.setValue(lastName);
        this.email.setValue(email);
        this.passwordHash.setValue(password);
    }

}
