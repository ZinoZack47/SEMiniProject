package com.ensa.glminiprojectsp.Factory;

import com.ensa.glminiprojectsp.Beans.Person;
import com.ensa.glminiprojectsp.Beans.Professor;
import com.ensa.glminiprojectsp.Beans.Student;

public class Factory {
    private Factory() {}
    public static Person makePerson(String option) {
        switch (option) {
            case "s", "S", "student" -> {
                return new Student();
            }
            case "p", "P", "professor" -> {
                return new Professor();
            }
        }
        return new Person() {};
    }

    public static Person makePerson(String option, String id, String firstName, String lastName) {
        switch (option) {
            case "s", "S", "student" -> {
                return new Student(id, firstName, lastName);
            }
            case "p", "P", "professor" -> {
                return new Professor(id, firstName, lastName);
            }
        }
        return new Person() {};
    }

}
