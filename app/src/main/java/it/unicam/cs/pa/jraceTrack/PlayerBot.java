package it.unicam.cs.pa.jraceTrack;

public class PlayerBot extends DefaultBasePlayer<TrackLocation2D>{


    public PlayerBot(String name) {
        super(name);
    }

    @Override
    public TypePlayer getType() {
        return TypePlayer.BOT;
    }
}
