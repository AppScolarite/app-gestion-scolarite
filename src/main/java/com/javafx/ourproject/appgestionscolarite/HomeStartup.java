package com.javafx.ourproject.appgestionscolarite;

import com.javafx.ourproject.Repositories.BrancheRepository;
import com.javafx.ourproject.Services.BranchServiceImpl;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.hibernate.engine.spi.SessionDelegatorBaseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.util.List;
import java.util.Objects;


public class HomeStartup extends Application {

    private double x, y;
    private ConfigurableApplicationContext applicationContext;
    private Parent root;

    @Autowired
    private BrancheRepository brancheRepository;

    @Override
    public void init() throws IOException {
        applicationContext = new SpringApplicationBuilder(AppGestionScolariteApplication.class).run();
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

        System.out.println("just testing hibernate");
        System.out.println(brancheRepository.findById(1).orElseThrow(() -> new RuntimeException("MyyCustomException")));

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
