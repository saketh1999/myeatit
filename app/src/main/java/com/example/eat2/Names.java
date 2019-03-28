package com.example.eat2;

public class Names {
    private String customerId;
    private String name;
    private String password;
    private String phoneNumber;

    public Names(String customerId, String name, String password, String phoneNumber) {
        this.customerId = customerId;
        this.name = name;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }


    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}






