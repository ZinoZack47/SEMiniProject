package com.ensa.glminiprojectsp.DAO;

import jakarta.persistence.*;

@Entity
@Table(name = "Score")
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int code;
    @Column(name = "value")
    float value;
    @Column(name="method")
    AssessmentMethod method;

    @ManyToOne
    ModuleElement moduleElement;

    public Score() { }

    public Score(float value, AssessmentMethod method, ModuleElement moduleElement) {
        this.value = value;
        this.method = method;
        this.moduleElement = moduleElement;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public AssessmentMethod getMethod() {
        return method;
    }

    public void setMethod(AssessmentMethod method) {
        this.method = method;
    }

    public ModuleElement getModuleElement() {
        return moduleElement;
    }

    public void setModuleElement(ModuleElement moduleElement) {
        this.moduleElement = moduleElement;
    }
}
