package com.ensa.glminiprojectsp.Services;

import com.ensa.glminiprojectsp.DAO.Student;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class APICommunicator {
    private APICommunicator() {};
    private static APICommunicator instance;
    public static APICommunicator getInstance() {
        if (instance == null) {
            instance = new APICommunicator();
        }
        return instance;
    }
}
