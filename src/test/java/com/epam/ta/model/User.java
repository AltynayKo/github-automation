package com.epam.ta.model;

import java.util.Objects;

public class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUserName() {
        return this.username;
    }

    public String getUserPassword() {
        return this.password;
    }

    @Override
    public String toString() {
        return "User{"+
                "username = " + username + '\'' +
                ", password = " + password + '\''+
                "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof User)) return false;
        User user = (User) obj;
        return Objects.equals(getUserName(), user.getUserName()) &&
                Objects.equals(getUserPassword(), user.getUserPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserName(), getUserPassword());
    }
}
