package it.unicam.cs.pa.jraceTrack.Model;

import it.unicam.cs.pa.jraceTrack.MyFactoryControllerManager;

import java.util.Random;
import java.util.Set;

public class PlayerBot extends DefaultBasePlayer{


    public PlayerBot() {
        super();
    }

    @Override
    public TypePlayer getType() {
        return TypePlayer.BOT;
    }

    @Override
    public void moveUp(TrackLocation2D p) {
        Set<TrackLocation2D> nextLocs = this.getCar().getTrack().getNextLocs(this.getCar().getLocation());
        int intLocs = nextLocs.size();
        int randomElement = new Random().nextInt(intLocs);
        int count = 0;
        for (TrackLocation2D t : nextLocs) {
            if (count == randomElement)
                this.getCar().moveUp(t);
            count++;
        }
    }
}
