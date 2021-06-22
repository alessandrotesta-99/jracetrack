package it.unicam.cs.pa.jraceTrack;

public class PlayerInteractive extends DefaultBasePlayer<TrackLocation2D>{

    public PlayerInteractive(String name, Car<TrackLocation2D> car) {
        super(name, car);
    }

    @Override
    public TypePlayer getType() {
        return TypePlayer.INTERACTIVE;
    }
}
