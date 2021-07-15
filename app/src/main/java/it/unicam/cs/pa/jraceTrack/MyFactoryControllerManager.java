package it.unicam.cs.pa.jraceTrack;

import it.unicam.cs.pa.jraceTrack.Controller.Controller;
import it.unicam.cs.pa.jraceTrack.Controller.DefaultController;
import it.unicam.cs.pa.jraceTrack.Model.DefaultRace;
import it.unicam.cs.pa.jraceTrack.Model.TrackLocation2D;

public class MyFactoryControllerManager implements ControllerManager<TrackLocation2D> {

    private static MyFactoryControllerManager instance;
    //todo da vedere se lasciare static.
    private final static String FILE_TRACK = "track.txt";
    private final static String FILE_PLAYERS = "players.txt";


    private MyFactoryControllerManager() {
    }

    public static MyFactoryControllerManager getInstance(){
        if(instance == null)
            instance = new MyFactoryControllerManager();
        return instance;
    }

    @Override
    public Controller<TrackLocation2D> createController() {
        return new DefaultController(new DefaultRace<>(), FILE_TRACK, FILE_PLAYERS);
    }
}
