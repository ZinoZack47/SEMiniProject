package com.ensa.glminiprojectsp.DAO;

public enum AssessmentMethods {
    CC,
    PW, // practical work - TP
    PP;

    public float getPercentage() {
        return switch (this) {
            case CC -> 0.3f;
            case PW -> 0.2f;
            case PP -> 0.5f;
        };
    }
}
