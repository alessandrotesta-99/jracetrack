package it.unicam.cs.pa.jraceTrack;

public class PlayerBot extends DefaultBasePlayer<TrackLocation2D>{


    public PlayerBot(String name, Car<TrackLocation2D> car) {
        super(name, car);
    }

    @Override
    public TypePlayer getType() {
        return TypePlayer.BOT;
    }
}
