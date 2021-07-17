package it.unicam.cs.pa.jraceTrack.View;

import it.unicam.cs.pa.jraceTrack.Controller.Controller;
import it.unicam.cs.pa.jraceTrack.Model.TrackLocation2D;
import it.unicam.cs.pa.jraceTrack.MyFactoryControllerManager;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class JavaFXImportFileController {

    public Button btnLoadFile;

    private final FileChooser fileChooser = new FileChooser();

    public TextField txtTrack;

    private File fileTrack;


    public void handleBtnLoadFile(ActionEvent actionEvent) {
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        fileTrack = fileChooser.showOpenDialog(window);
    }

    public void handleBtnLoadFilePlayers(ActionEvent actionEvent) throws IOException {
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        File filePlayers = fileChooser.showOpenDialog(window);
        createController(fileTrack.getPath(), filePlayers.getPath());
        JavaFXManager.controller.loadTrack();
        JavaFXManager.controller.loadPlayers();
        System.out.println(JavaFXManager.controller.getTrack().toString());
        System.out.println(JavaFXManager.controller.getPlayers().toString());
    }

    private void createController(String track, String players){
         MyFactoryControllerManager.getInstance().createController(track);
    }
}
