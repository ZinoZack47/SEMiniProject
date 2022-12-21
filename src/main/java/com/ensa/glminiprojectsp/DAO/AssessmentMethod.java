package com.ensa.glminiprojectsp.DAO;

public enum AssessmentMethod {
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
//
//String s = "S2";
//if (Arrays.stream(Semester.values()).anyMatch(e -> e.name().equals(s))) {
//    Semester semester = Semester.valueOf(s);
//    // do something with the semester enum element
//} else {
//    // handle invalid input
//}