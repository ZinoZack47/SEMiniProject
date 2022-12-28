package com.ensa.glminiprojectsp.Utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

public class PasswordHash {
    private PasswordHash() {}
    private static final PasswordHash instance = new PasswordHash();

    public static PasswordHash getInstance() {
        return instance;
    }

    private static final int SALT_LENGTH = 32;
    private static final String HASH_ALGORITHM = "SHA-256";

    public byte[] generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[SALT_LENGTH];
        random.nextBytes(salt);
        return salt;
    }

    public byte[] hashPassword(char[] password, byte[] salt) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(HASH_ALGORITHM);
            messageDigest.update(salt);
            byte[] passwordHash = messageDigest.digest(new String(password).getBytes(StandardCharsets.UTF_8));
            byte[] hashWithSalt = new byte[salt.length + passwordHash.length];

            System.arraycopy(salt, 0, hashWithSalt, 0, salt.length);
            System.arraycopy(passwordHash, 0, hashWithSalt, salt.length, passwordHash.length);
            return hashWithSalt;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing password: " + e.getMessage(), e);
        }
    }

     public boolean verifyPassword(char[] password, byte[] hashWithSalt) {
        try {
            int saltLength = hashWithSalt.length / 2;
            byte[] salt = new byte[saltLength];
            System.arraycopy(hashWithSalt, 0, salt, 0, saltLength);
            byte[] hash = new byte[saltLength];
            System.arraycopy(hashWithSalt, saltLength, hash, 0, saltLength);
            MessageDigest messageDigest = MessageDigest.getInstance(HASH_ALGORITHM);
            messageDigest.update(salt);
            byte[] passwordHash = messageDigest.digest(new String(password).getBytes(StandardCharsets.UTF_8));
            return Arrays.equals(passwordHash, hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error verifying password: " + e.getMessage(), e);
        }
    }
}
