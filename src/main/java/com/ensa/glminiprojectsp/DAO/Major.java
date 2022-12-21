package com.ensa.glminiprojectsp.DAO;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name = "Major")
public class Major {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int code;
    @Column(name = "name")
    String name;

    @OneToMany(mappedBy="major")
    ArrayList<Module> modules;

    public Major() { }

    public Major(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addModule(Module module) {
        this.modules.add(module);
    }

    public void removeModule(Module module) {
        this.modules.remove(module);
    }

    public void resetModules() {
        this.modules.clear();
    }
}

