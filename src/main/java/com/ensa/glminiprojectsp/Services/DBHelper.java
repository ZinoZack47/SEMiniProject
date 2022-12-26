package com.ensa.glminiprojectsp.Services;

import com.ensa.glminiprojectsp.Beans.*;

import java.util.ArrayList;

public interface DBHelper {
    ArrayList<Student> getAllStudents();
    ArrayList<Professor> getAllProfessors();
    Person findById(String id);
    Major findMajorById(int code);
    void updateProfessor(String id, Professor professor);

}
