package com.ensa.glminiprojectsp.DAO;

import jakarta.persistence.*;

@Entity
@Table(name="ModuleElement")
public class ModuleElement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int code;
    @ManyToOne
    private Module module;
    @Column(name="coefficient")
    private float coefficient;
    @ManyToOne
    private Professor professor;
    @Column(name="validated")
    private boolean validated;

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
