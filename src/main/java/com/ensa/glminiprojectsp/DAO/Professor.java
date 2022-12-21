package com.ensa.glminiprojectsp.DAO;

import java.util.ArrayList;

public class Professor {
    int code;
    String firstName;
    String lastName;
    String specialty;
    ArrayList<Major> majors = new ArrayList<>();
    ArrayList<ModuleElement> moduleElements = new ArrayList<>();

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

    public void addSector(Major major) {
        this.majors.add(major);
    }

    public void removeSector(Major major) {
        this.majors.remove(major);
    }

    public void resetSectors() {
        this.majors.clear();
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
}
