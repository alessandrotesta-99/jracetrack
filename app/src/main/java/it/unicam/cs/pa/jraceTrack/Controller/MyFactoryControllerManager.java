package it.unicam.cs.pa.jraceTrack.Controller;

import it.unicam.cs.pa.jraceTrack.Model.DefaultRace;
import it.unicam.cs.pa.jraceTrack.Model.Location.DefaultLocation;

public class MyFactoryControllerManager implements ControllerManager<DefaultLocation> {

    private static MyFactoryControllerManager instance;


    private MyFactoryControllerManager() {
    }

    public static MyFactoryControllerManager getInstance(){
        if(instance == null)
            instance = new MyFactoryControllerManager();
        return instance;
    }

    @Override
    public Controller<DefaultLocation> createController() {
        return new DefaultController(new DefaultRace(), "track.txt", "players.txt");
    }
}
