package com.ensa.glminiprojectsp.DAO;

import java.util.ArrayList;

public class Student extends Person {
    Major major;
    ArrayList<Score> scores;

    public Student() { }

    public Student(String id, String firstName, String lastName, Major major) {
        super(id, firstName, lastName);
        this.major = major;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }
}
