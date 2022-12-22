package com.ensa.glminiprojectsp.DAO;

import java.util.ArrayList;

public class ModuleElement {
    int code;
    Module module;
    float coefficient;
    Professor professor;
    AssessmentMethod[] assessmentMethods = new AssessmentMethod[AssessmentMethod.values().length];
    boolean validated;

    public ModuleElement() { }

    public ModuleElement(Module module, float coefficient, Professor professor) {
        this.module = module;
        this.coefficient = coefficient;
        this.professor = professor;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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

    public boolean isValidated() {
        return validated;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }
}
