package net.liceo.bar.exercicioexame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class NumberApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(NumberApplication.class.getResource("number-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 500);
        stage.setTitle("Numbers!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}