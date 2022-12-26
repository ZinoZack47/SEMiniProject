package com.ensa.glminiprojectsp.Beans;

public enum AssessmentMethod {
    CC,
    PW, // practical work - TP
    PP;

    float percentage;
    public float getPercentage() {
        return percentage;
    }
    public void setPercentage(float percentage) {
        this.percentage = percentage;
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