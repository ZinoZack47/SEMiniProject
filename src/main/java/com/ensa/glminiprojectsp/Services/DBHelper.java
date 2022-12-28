package com.ensa.glminiprojectsp.Services;

import com.ensa.glminiprojectsp.Beans.*;

import java.util.ArrayList;

public interface DBHelper {
    ArrayList<Student> getAllStudents();
    ArrayList<Professor> getAllProfessors();
    Person findById(String id);
    Major findMajorById(int code);
    Account findAccountByUserId(String userId);

    void updateProfessor(String id, Professor professor);
    void addAccount(Account account);

}
