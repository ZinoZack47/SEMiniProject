package com.ensa.glminiprojectsp;

import com.ensa.glminiprojectsp.Services.MySQLConnector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class GlMiniProjectSpApplication {
    public static void main(String[] args) {

        ConfigurableApplicationContext context =
                SpringApplication.run(GlMiniProjectSpApplication.class, args);
        Environment env = context.getEnvironment();
        MySQLConnector.getInstance(env);
    }

}
