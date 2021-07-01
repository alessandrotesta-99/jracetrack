package it.unicam.cs.pa.jraceTrack;

public class PlayerInteractive extends DefaultBasePlayer<TrackLocation2D>{

    public PlayerInteractive(String name) {
        super(name);
    }

    @Override
    public TypePlayer getType() {
        return TypePlayer.INTERACTIVE;
    }
}
