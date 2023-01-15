package com.wonkeun.springDesignPattern.builder;

public class ContactBuilder {
    private String firstName;
    private String lastName;
    private String email;

    public ContactBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ContactBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public ContactBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public Contact buildContact() {
        return new Contact(firstName, lastName, email);
    }
}
