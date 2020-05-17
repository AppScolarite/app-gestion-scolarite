package com.javafx.ourproject.appgestionscolarite;

import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppGestionScolariteApplication {

    public static void main(String[] args) {
        Application.launch(HomeStartup.class, args);
    }

}
