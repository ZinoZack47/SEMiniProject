package com.ensa.glminiprojectsp.Services;

public class APICommunicator {
    private static APICommunicator instance;
    public static APICommunicator getInstance() {
        if (instance == null) {
            instance = new APICommunicator();
        }
        return instance;
    }
}
