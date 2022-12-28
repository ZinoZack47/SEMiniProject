package com.ensa.glminiprojectsp.Services.Rest;

import com.ensa.glminiprojectsp.Beans.Student;
import com.ensa.glminiprojectsp.Services.MySQLConnector;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentAPI {
    @GetMapping("/students")
    @ResponseBody
    public List<Student> getAllStudents() {
        return MySQLConnector.getInstance().getAllStudents();
    }
}
