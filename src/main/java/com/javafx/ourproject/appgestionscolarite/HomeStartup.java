package com.javafx.ourproject.appgestionscolarite;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;


public class HomeStartup extends Application {

    private double x, y;
    private ConfigurableApplicationContext applicationContext;
    private Parent root;

    @Override
    public void init() throws IOException {
        applicationContext = new SpringApplicationBuilder(HomeStartup.class).run();
//        root = FXMLLoader.load(getClass().getClassLoader().getResource("src/main/java/com/javafx/ourproject/Fxml_Ui/Home.fxml"));
//        root = FXMLLoader.load(getClass().getResource("home.fxml"));
        URL url = new File("src/main/java/com/javafx/ourproject/Fxml_Ui/Home.fxml").toURI().toURL();
        root = FXMLLoader.load(url);
        root.setOnMousePressed(event -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("com/javafx/ourproject/Fxml_Ui/Home.fxml"));
        primaryStage.setScene(new Scene(root));
        //set stage borderless
        primaryStage.initStyle(StageStyle.UNDECORATED);

        //drag it here
        root.setOnMousePressed(event -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });
        root.setOnMouseDragged(event -> {

            primaryStage.setX(event.getScreenX() - x);
            primaryStage.setY(event.getScreenY() - y);

        });
        primaryStage.show();

        applicationContext.publishEvent(new StageReadyEvent(primaryStage));
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void stop() {
        applicationContext.close();
        Platform.exit();
    }

    static class StageReadyEvent extends ApplicationEvent {
        public StageReadyEvent(Stage stage) {
            super(stage);
        }

        public Stage getStage() {

            return ((Stage) this.getSource());
        }
    }
}
