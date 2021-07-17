package it.unicam.cs.pa.jraceTrack.View;

import it.unicam.cs.pa.jraceTrack.Model.TrackLocation2D;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class JavaFXView  implements View<TrackLocation2D> {

    private final Stage primaryStage;

    public JavaFXView(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @Override
    public void open() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/test.fxml")));
        primaryStage.setTitle("RaceTrack");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    @Override
    public void close() throws IOException {

    }
}
