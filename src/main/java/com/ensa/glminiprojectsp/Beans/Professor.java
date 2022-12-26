package com.ensa.glminiprojectsp.Beans;

import com.ensa.glminiprojectsp.Observers.Observer;

import java.util.ArrayList;

public class Professor extends Person {
    String specialty;
    ArrayList<ModuleElement> moduleElements = new ArrayList<>();

    public Professor() { }
    public Professor(String id, String firstName, String lastName)  {
        super(id, firstName, lastName);
    }
    public Professor(String id, String firstName, String lastName, String specialty) {
        this(id, firstName, lastName);
        this.specialty = specialty;
    }

    @Override
    public void setId(String id) {
        String oldId = super.getId();
        super.setId(id);
        notifyObservers(oldId);
    }

    @Override
    public void setFirstName(String firstName) {
        super.setFirstName(firstName);
        notifyObservers(id);
    }

    @Override
    public void setLastName(String lastName) {
        super.setLastName(lastName);
        notifyObservers(id);
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
        this.notifyObservers(id);
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

    //Observers
    ArrayList<Observer> observers = new ArrayList<>();
    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }
    public void notifyObservers(String id) {
        for (Observer observer : observers) {
            observer.update(id);
        }
    }
}
