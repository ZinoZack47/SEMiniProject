package com.ensa.glminiprojectsp.DAO;

public class ModuleElement {
    Module module;
    float coefficient;
    Professor professor;

    public ModuleElement() { }

    public ModuleElement(Module module, float coefficient, Professor professor) {
        this.module = module;
        this.coefficient = coefficient;
        this.professor = professor;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public float getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(float coefficient) {
        this.coefficient = coefficient;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
}
