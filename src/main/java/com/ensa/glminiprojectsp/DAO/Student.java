package com.ensa.glminiprojectsp.DAO;

import java.util.ArrayList;

public class Student {
    int code;
    String firstName;
    String lastName;
    Major major;
    ArrayList<Score> scores;
    public Student() { }

    public Student(int code, String firstName, String lastName, Major major) {
        this.code = code;
        this.firstName = firstName;
        this.lastName = lastName;
        this.major = major;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }
}
