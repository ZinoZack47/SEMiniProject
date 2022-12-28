package com.ensa.glminiprojectsp.Beans;

public class Account {
    int code;
    char[] username = new char[32];
    byte[] hashedPassword = new byte[255];
    boolean isAdmin = false;

    public Account() { }

    public Account(char[] username, byte[] hashedPassword, boolean isAdmin) {
        this(0, username, hashedPassword, isAdmin);
    }

    public Account(int code, char[] username, byte[] hashedPassword, boolean isAdmin) {
        this.code = code;
        this.username = username;
        this.hashedPassword = hashedPassword;
        this.isAdmin = isAdmin;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public char[] getUsername() {
        return username;
    }

    public void setUsername(char[] username) {
        this.username = username;
    }

    public byte[] getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(byte[] hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
