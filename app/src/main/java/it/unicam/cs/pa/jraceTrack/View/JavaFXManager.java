package it.unicam.cs.pa.jraceTrack.View;

import it.unicam.cs.pa.jraceTrack.Controller.Controller;
import it.unicam.cs.pa.jraceTrack.Model.TrackLocation2D;
import it.unicam.cs.pa.jraceTrack.MyFactoryControllerManager;
import javafx.application.Application;
import javafx.stage.Stage;


public class JavaFXManager extends Application {

    private final static String FILE_TRACK = "track.txt";
    private final static String FILE_PLAYERS = "players.txt";
    //todo
    protected static final Controller<TrackLocation2D> controller = MyFactoryControllerManager.getInstance().createController(FILE_TRACK);

    @Override
    public void start(Stage primaryStage) throws Exception {
        controller.loadTrack();
        controller.loadPlayers();
        View<TrackLocation2D> view = new JavaFXView(primaryStage);
        view.open();
    }
}
