package com.ensa.glminiprojectsp.Services;

import com.ensa.glminiprojectsp.DAO.Major;
import com.ensa.glminiprojectsp.DAO.Person;
import com.ensa.glminiprojectsp.DAO.Professor;
import com.ensa.glminiprojectsp.DAO.Student;
import com.ensa.glminiprojectsp.Factory.Factory;
import org.springframework.core.env.Environment;

import java.sql.*;
import java.util.ArrayList;

public class MySQLConnector implements DBHelper {
    private final Environment env;
    private Connection connection;

    private MySQLConnector(Environment env) {
        this.env = env;
        if(!this.connect())
            throw new RuntimeException("Connection unsuccessful!");
    };

    private static MySQLConnector instance;
    public static MySQLConnector getInstance(Environment env) {
        if (instance == null) {
            instance = new MySQLConnector(env);
        }
        return instance;
    }

    public static  MySQLConnector getInstance() {
        if(instance == null) {
            throw new NullPointerException("Environment was not set!");
        }
        return instance;
    }

    public boolean connect() {
        if(connection != null)
            return true;
        try {
            String url = env.getProperty("spring.datasource.url");
            String username = env.getProperty("spring.datasource.username");
            String password = env.getProperty("spring.datasource.password");
            Class.forName("com.mysql.cj.jdbc.Driver");
            assert url != null;
            connection = DriverManager.getConnection(url, username, password);
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public Major findMajorById(int code) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Major WHERE code = ?");
            statement.setInt(1, code);
            ResultSet resultSet = statement.executeQuery();
            String name = resultSet.getString("name");
            return new Major(code, name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public ArrayList<Student> getAllStudents() {
        ArrayList<Student> students = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Student");
            while (resultSet.next()) {
                String id  = String.valueOf(resultSet.getInt("id"));
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                Major major = findMajorById(resultSet.getInt("major"));
                var student = Factory.makeStudent(id, firstName, lastName, major);
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public ArrayList<Professor> getAllProfessors() {
        ArrayList<Professor> professors = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Professor");
            while (resultSet.next()) {
                String id  = String.valueOf(resultSet.getString("id"));
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String specialty = resultSet.getString("specialty");
                var professor = Factory.makeProfessor(id, firstName, lastName, specialty);
                professors.add(professor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return professors;
    }

    @Override
    public Person findById(String id) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Professor WHERE id = ?");
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.isBeforeFirst()) {
                statement = connection.prepareStatement("SELECT * FROM Student WHERE id = ?");
                statement.setString(1, id);
                resultSet = statement.executeQuery();
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                Major major = findMajorById(resultSet.getInt("major"));
                return Factory.makeStudent(id, firstName, lastName, major);
            }
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            String specialty = resultSet.getString("specialty");
            return Factory.makeProfessor(id, firstName, lastName, specialty);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
