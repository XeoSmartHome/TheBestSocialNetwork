package com.example.thebestsocialnetwork;

import com.example.thebestsocialnetwork.database.models.User;
import database.Session;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/social_network", "postgres", "12345678");
            Session session = new Session(connection);

            User user = new User("Claudiu", "Neamtu", "test", "test");

            user.save(connection);

            user.remove(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}