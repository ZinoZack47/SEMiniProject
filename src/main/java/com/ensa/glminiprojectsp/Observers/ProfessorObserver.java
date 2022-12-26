package com.ensa.glminiprojectsp.Observers;

import com.ensa.glminiprojectsp.Beans.Professor;
import com.ensa.glminiprojectsp.Services.DBHelper;

public class ProfessorObserver implements Observer {
    DBHelper dbWriter;
    Professor professor;

    public ProfessorObserver(DBHelper dbWriter, Professor professor) {
        this.dbWriter = dbWriter;
        this.professor = professor;
    }

    public void setObserved(Professor professor) {
        this.professor = professor;
    }

    @Override
    public void update(int id) {
    }

    @Override
    public void update(String id) {
        dbWriter.updateProfessor(id, professor);
    }
}