package com.ensa.glminiprojectsp;

import com.ensa.glminiprojectsp.DAO.*;
import com.ensa.glminiprojectsp.Observers.ProfessorObserver;
import com.ensa.glminiprojectsp.Services.MySQLConnector;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

import java.util.ArrayList;

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
        professor = (Professor)MySQLConnector.getInstance(env).findById(id);
        assertThat(professor.getLastName()).isEqualTo("Watson");
        System.out.println(professor);
        po.setObserved(professor);
        professor.attach(po);
        professor.setLastName("Williams");
        professor = (Professor)MySQLConnector.getInstance(env).findById(id);
        assertThat(professor.getLastName()).isEqualTo("Williams");
        System.out.println(professor);
    }


}
