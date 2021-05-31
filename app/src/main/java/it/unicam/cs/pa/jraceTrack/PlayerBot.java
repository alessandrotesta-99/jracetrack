package it.unicam.cs.pa.jraceTrack;

public class PlayerBot extends DefaultBasePlayer<Point2D, DefaultStateCar>{


    public PlayerBot(String name, Car<Point2D, DefaultStateCar> car) {
        super(name, car);
    }

    @Override
    public TypePlayer getType() {
        return TypePlayer.BOT;
    }
}
