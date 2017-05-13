package com.example.haams.testforserver.data;

/**
 * Created by haams on 2017-05-12.
 */

public class Admin {
    private String name;
    private double age;
    private String password;

    public Admin(String name, double age, String password) {
        this.name = name;
        this.age = age;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public double getAge() {
        return age;
    }

    public String getPassword() {
        return password;
    }
}
