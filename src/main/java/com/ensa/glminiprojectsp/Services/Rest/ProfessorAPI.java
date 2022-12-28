package com.ensa.glminiprojectsp.Services.Rest;

import com.ensa.glminiprojectsp.Beans.Professor;
import com.ensa.glminiprojectsp.Services.MySQLConnector;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProfessorAPI {
    @GetMapping("/professors")
    @ResponseBody
    public List<Professor> getAllProfessors() {
        return MySQLConnector.getInstance().getAllProfessors();
    }
}