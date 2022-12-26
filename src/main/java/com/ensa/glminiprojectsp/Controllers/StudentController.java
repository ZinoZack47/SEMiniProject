package com.ensa.glminiprojectsp.Controllers;

import com.ensa.glminiprojectsp.Beans.Student;
import com.ensa.glminiprojectsp.Services.MySQLConnector;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    @GetMapping("/students")
    @ResponseBody
    public List<Student> getAllStudents() {
        return MySQLConnector.getInstance().getAllStudents();
    }
}
