package it.unicam.cs.pa.jraceTrack;

import java.util.Random;

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
        //todo trovare un modo per eliminare il parametro.
        int nextPositions = this.getCar().getLocation().getNextLocations(this.getCar()).size();
        int randomElement = new Random().nextInt(nextPositions);
        int count = 0;
        for (TrackLocation2D t : this.getCar().getLocation().getNextLocations(this.getCar())) {
            if (count == randomElement)
                this.getCar().moveUp(t);
            count++;
        }
    }
}
