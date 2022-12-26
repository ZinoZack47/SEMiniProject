package com.ensa.glminiprojectsp;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.ensa.glminiprojectsp.Beans.Student;
import com.ensa.glminiprojectsp.Services.MySQLConnector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;

@SpringBootTest
public class RestAPITest {
    @Autowired
    private Environment env;
    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testGetStudents() throws Exception {
        MySQLConnector.getInstance(env);
        mockMvc.perform(get("/api/students"))
           .andExpect(status().isOk())
           .andExpect(jsonPath("$[0].id").value("E126947851"))
           .andExpect(jsonPath("$[0].firstName").value("David"))
           .andExpect(jsonPath("$[1].id").value("E205549207"))
           .andExpect(jsonPath("$[1].firstName").value("Cathy"));
    }
}
