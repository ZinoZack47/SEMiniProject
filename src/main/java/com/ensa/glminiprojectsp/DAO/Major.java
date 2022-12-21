package com.ensa.glminiprojectsp.DAO;

import java.util.ArrayList;

public class Major {
    int code;
    String name;
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
