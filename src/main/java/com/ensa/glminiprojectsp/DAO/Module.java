package com.ensa.glminiprojectsp.DAO;

public class Module {
    int code;
    String name;
    Semester semester;
    Major major;

    public Module() { }

    public Module(int code, String name, Semester semester, Major major) {
        this.code = code;
        this.name = name;
        this.semester = semester;
        this.major = major;
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

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }
}
