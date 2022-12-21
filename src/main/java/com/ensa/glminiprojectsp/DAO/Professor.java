package com.ensa.glminiprojectsp.DAO;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name = "Professor")
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int code;

    @Column(name="first_name")
    String firstName;

    @Column(name="last_name")
    String lastName;

    @Column(name="specialty")
    String specialty;

    @OneToMany(mappedBy = "professor")
    ArrayList<ModuleElement> moduleElements = new ArrayList<>();

    @OneToOne(mappedBy = "professor")
    Account account;

    public Professor() { }
    public Professor(int code, String firstName, String lastName, String specialty) {
        this.code = code;
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialty = specialty;
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

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public void addModuleElement(ModuleElement moduleElement) {
        this.moduleElements.add(moduleElement);
    }

    public void removeModuleElement(ModuleElement moduleElement) {
        this.moduleElements.remove(moduleElement);
    }

    public void resetModuleElements() {
        this.moduleElements.clear();
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
