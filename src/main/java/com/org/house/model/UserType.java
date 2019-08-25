package com.org.house.model;

public enum UserType {
    USER, OWNER, MASTER;

    @Override
    public String toString() {
        return name();
    }
}
