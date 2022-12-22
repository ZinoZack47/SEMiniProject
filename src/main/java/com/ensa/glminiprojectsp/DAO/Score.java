package com.ensa.glminiprojectsp.DAO;

public class Score {
    int code;
    float value;
    AssessmentMethod method;
    ModuleElement moduleElement;

    public Score() { }

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
