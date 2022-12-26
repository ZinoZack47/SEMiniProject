package com.ensa.glminiprojectsp;

import com.ensa.glminiprojectsp.DAO.*;
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
    void sayHi()
    {
        System.out.println("Test Library Locked and Loaded");
    }
    @Test
    void databaseConnect()
    {
        assertThat(MySQLConnector.getInstance(env).connect()).isEqualTo(true);
    }
    @Test
    void testGetProfessors() {
        ArrayList<Professor> professors = MySQLConnector.getInstance(env).getAllProfessors();
        assertThat(professors).isNotEmpty();
        professors.forEach(p -> System.out.println("Pr. " + p.getFirstName() + " " + p.getLastName()));
    }

}
