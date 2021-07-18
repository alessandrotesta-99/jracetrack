package it.unicam.cs.pa.jraceTrack.Model;

import it.unicam.cs.pa.jraceTrack.Model.Location.DefaultLocation;

/**
 * Implementazione di un giocatore interattivo.
 */
public class PlayerInteractive extends DefaultBasePlayer{

    public PlayerInteractive() {
        super();
    }

    @Override
    public TypePlayer getType() {
        return TypePlayer.INTERACTIVE;
    }

    @Override
    public void moveUp(DefaultLocation p) {
        this.getCar().moveUp(p);
    }
}
