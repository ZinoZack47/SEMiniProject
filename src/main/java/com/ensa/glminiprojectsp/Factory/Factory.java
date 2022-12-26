package com.ensa.glminiprojectsp.Factory;

import com.ensa.glminiprojectsp.Beans.Major;
import com.ensa.glminiprojectsp.Beans.Person;
import com.ensa.glminiprojectsp.Beans.Professor;
import com.ensa.glminiprojectsp.Beans.Student;

public class Factory {
    private Factory() {};
    private static Person makePerson(String option) {
        switch (option) {
            case "s", "S", "student" -> {
                return new Student();
            }
            case "p", "P", "professor" -> {
                return new Professor();
            }
        }
        return null;
    }
    private static Person makePerson(String option, String id, String firstName, String lastName) {
        switch (option) {
            case "s", "S", "student" -> {
                return new Student(id, firstName, lastName);
            }
            case "p", "P", "professor" -> {
                return new Professor(id, firstName, lastName);
            }
        }
        return null;
    }
    public static Student makeStudent(String id, String firstName, String lastName, Major major) {
        return new Student(id, firstName, lastName, major);
    }
    public static Professor makeProfessor(String id, String firstName, String lastName, String specialty) {
        return new Professor(id, firstName, lastName, specialty);
    }
}
