package com.ensa.glminiprojectsp;

import com.ensa.glminiprojectsp.Beans.*;
import com.ensa.glminiprojectsp.Observers.ProfessorObserver;
import com.ensa.glminiprojectsp.Services.MySQLConnector;
import com.ensa.glminiprojectsp.Utils.PasswordHash;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class GlMiniProjectSpApplicationTests {
    @Autowired
    Environment env;

    @Test
    void testTest()
    {
        System.out.println("Test Library Locked and Loaded");
    }
    @Test
    void testDatabaseConnect()
    {
        assertThat(MySQLConnector.getInstance(env).connect()).isEqualTo(true);
    }
    @Test
    void testGetProfessors() {
        ArrayList<Professor> professors = MySQLConnector.getInstance(env).getAllProfessors();
        assertThat(professors).isNotEmpty();
        professors.forEach(System.out::println);
    }

    @Test
    void testGetProfessorAndStudent() {
        String id = "Q01234";
        Person person = MySQLConnector.getInstance(env).findById(id);
        assertThat(person).isNotNull();
        assertThat(person.getFirstName()).isEqualTo("Emily");
        id = "E261207252";
        person = MySQLConnector.getInstance(env).findById(id);
        assertThat(person).isNotNull();
        assertThat(person.getFirstName()).isEqualTo("Zach");
    }
    @Test
    void testProfessorObserver() {
        String id = "Q01234";
        Professor professor = (Professor)MySQLConnector.getInstance(env).findById(id);
        ProfessorObserver po = new ProfessorObserver(MySQLConnector.getInstance(), professor);
        professor.attach(po);
        professor.setLastName("Watson");
        professor = (Professor)MySQLConnector.getInstance().findById(id);
        assertThat(professor.getLastName()).isEqualTo("Watson");
        System.out.println(professor);
        po.setObserved(professor);
        professor.attach(po);
        professor.setLastName("Williams");
        professor = (Professor)MySQLConnector.getInstance().findById(id);
        assertThat(professor.getLastName()).isEqualTo("Williams");
        System.out.println(professor);
    }

    @Test
    void testPasswordHacher() {
        final char[] password = "123456789".toCharArray();
        final char[] passNo = "123458683".toCharArray();
        byte[] salt = PasswordHash.getInstance().generateSalt();
        byte[] hashedPassWithSalt = PasswordHash.getInstance().hashPassword(password, salt);
        System.out.println("Hashed Pass: " + Arrays.toString(hashedPassWithSalt));
        assertThat(hashedPassWithSalt.length).isLessThan(255);
        assertThat(PasswordHash.getInstance().verifyPassword(password, hashedPassWithSalt)).isEqualTo(true);
        assertThat(PasswordHash.getInstance().verifyPassword(passNo, hashedPassWithSalt)).isEqualTo(false);
    }

    @Test
    void testAddAccount() {
        final char[] username = "W213231".toCharArray();
        final char[] password = "1233232".toCharArray();
        final byte[] salt = PasswordHash.getInstance().generateSalt();
        final byte[] hashedPassword = PasswordHash.getInstance().hashPassword(password, salt);
        Account account = new Account(username, hashedPassword, true);
        MySQLConnector.getInstance(env).addAccount(account);
    }

    @Test
    void testVerifyPasswordFromDatabase() {
        String username = "W213231";
        final char[] password = "1233232".toCharArray();
        Account account = MySQLConnector.getInstance(env).findAccountByUserId(username);
        byte[] hashedPassword = account.getHashedPassword();
        assertThat(PasswordHash.getInstance().verifyPassword(password, hashedPassword)).isEqualTo(true);
    }

    @Test
    void testVerifyPasswordFromDatabaseFalse() {
        String username = "W213231";
        final char[] password = "1233272".toCharArray();
        Account account = MySQLConnector.getInstance(env).findAccountByUserId(username);
        byte[] hashedPassword = account.getHashedPassword();
        assertThat(PasswordHash.getInstance().verifyPassword(password, hashedPassword)).isEqualTo(false);
    }

    @Test
    void testDeleteProfessors() {
        ArrayList<String> list = new ArrayList<>();
        list.add("W90234");
        list.add("W90123");
        MySQLConnector.getInstance(env).deleteProfessorsByIds(String.join(",", list));
    }
}
