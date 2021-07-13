package it.unicam.cs.pa.jraceTrack.Model;

public class PlayerInteractive extends DefaultBasePlayer{

    public PlayerInteractive() {
        super();
    }

    @Override
    public TypePlayer getType() {
        return TypePlayer.INTERACTIVE;
    }

    @Override
    public void moveUp(TrackLocation2D p) {
        setTurn(true);
        this.getCar().moveUp(p);
        setTurn(false);
    }
}
