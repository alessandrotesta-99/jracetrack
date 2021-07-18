package it.unicam.cs.pa.jraceTrack.Model;

import it.unicam.cs.pa.jraceTrack.Model.Location.DefaultLocation;

import java.util.Random;
import java.util.Set;

/**
 * Implementazione per un giocatore bot.
 */
public class PlayerBot extends DefaultBasePlayer{

    public PlayerBot() {
        super();
    }

    @Override
    public TypePlayer getType() {
        return TypePlayer.BOT;
    }

    @Override
    public void moveUp(DefaultLocation p) {
        Set<DefaultLocation> nextLocs = this.getCar().getTrack().getNextLocs(this.getCar().getLocation());
        int intLocs = nextLocs.size();
        int randomElement = new Random().nextInt(intLocs);
        int count = 0;
        for (DefaultLocation t : nextLocs) {
            if (count == randomElement)
                this.getCar().moveUp(t);
            count++;
        }
    }
}
