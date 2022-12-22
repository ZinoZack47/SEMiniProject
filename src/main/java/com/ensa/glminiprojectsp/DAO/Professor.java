package com.ensa.glminiprojectsp.DAO;

import java.util.ArrayList;

public class Professor extends Person {
    String specialty;
    ArrayList<ModuleElement> moduleElements = new ArrayList<>();
    Account account;

    public Professor() { }

    public Professor(String id, String firstName, String lastName, String specialty) {
        super(id, firstName, lastName);
        this.specialty = specialty;
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
