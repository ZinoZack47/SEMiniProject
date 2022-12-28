package com.ensa.glminiprojectsp.Services;

import com.ensa.glminiprojectsp.Beans.*;
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
            resultSet.next();
            String name = resultSet.getString("name");
            return new Major(code, name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Account findAccountByUserId(String userId) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Account WHERE username = ?");
            statement.setString(1, userId);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            int code = resultSet.getInt("code");
            char[] username = resultSet.getString("username").toCharArray();
            byte[] hashedPassword = resultSet.getBytes("hashed_password");
            boolean isAdmin = resultSet.getBoolean("is_admin");
            return new Account(code, username, hashedPassword, isAdmin);
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
                var student = (Student)Factory.makePerson("s");
                student.setId(resultSet.getString("id"));
                student.setFirstName(resultSet.getString("first_name"));
                student.setLastName(resultSet.getString("last_name"));
                student.setMajor(findMajorById(resultSet.getInt("major_code")));
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
                var professor = (Professor)Factory.makePerson("p");
                professor.setId(resultSet.getString("id"));
                professor.setFirstName(resultSet.getString("first_name"));
                professor.setLastName(resultSet.getString("last_name"));
                professor.setSpecialty(resultSet.getString("specialty"));
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
            if (!resultSet.next()) {
                statement = connection.prepareStatement("SELECT * FROM Student WHERE id = ?");
                statement.setString(1, id);
                resultSet = statement.executeQuery();

                if (!resultSet.next())
                    return null;

                Student student = (Student)Factory.makePerson("S");
                student.setFirstName(resultSet.getString("first_name"));
                student.setLastName(resultSet.getString("last_name"));
                student.setMajor(findMajorById(resultSet.getInt("major_code")));
                return student;
            }
            Professor professor = (Professor)Factory.makePerson("P");
            professor.setFirstName(resultSet.getString("first_name"));
            professor.setLastName(resultSet.getString("last_name"));
            professor.setSpecialty(resultSet.getString("specialty"));
            return professor;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateProfessor(String id, Professor professor) {
        try {
            String query = "UPDATE Professor " +
                    "SET id = ?," +
                    "first_name = ?," +
                    "last_name = ?," +
                    "specialty = ? " +
                    "WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, professor.getId());
            statement.setString(2, professor.getFirstName());
            statement.setString(3, professor.getLastName());
            statement.setString(4, professor.getSpecialty());
            statement.setString(5, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addAccount(Account account) {
        try {
            String query = "INSERT INTO Account(username, hashed_password, is_admin) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, String.valueOf(account.getUsername()));
            statement.setBytes(2, account.getHashedPassword());
            statement.setBoolean(3, account.isAdmin());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
