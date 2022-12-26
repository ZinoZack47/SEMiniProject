package com.ensa.glminiprojectsp.DAO;

import java.util.ArrayList;

public class Module {
    int code;
    String name;
    Semester semester;
    ArrayList<Major> majors;

    public Module() { }

    public Module(int code, String name, Semester semester) {
        this.code = code;
        this.name = name;
        this.semester = semester;
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

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public void addMajor(Major major) {
        this.majors.add(major);
    }

    public void removeMajor(Major major) {
        this.majors.remove(major);
    }

    public void resetMajors() {
        this.majors.clear();
    }

}
