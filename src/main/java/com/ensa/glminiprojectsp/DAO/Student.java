package com.ensa.glminiprojectsp.DAO;

import java.util.ArrayList;

import jakarta.persistence.*;

@Entity
@Table(name = "Student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int code;

    @Column(name="first_name")
    String firstName;

    @Column(name="last_name")
    String lastName;

    @ManyToOne
    Major major;
    @OneToMany(mappedBy = "student")
    ArrayList<Score> scores;

    public Student() { }

    public Student(String firstName, String lastName, Major major) {
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
