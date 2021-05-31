package it.unicam.cs.pa.jraceTrack;

public class PlayerInteractive extends DefaultBasePlayer<Point2D, DefaultStateCar>{

    public PlayerInteractive(String name, Car<Point2D, DefaultStateCar> car) {
        super(name, car);
    }

    @Override
    public TypePlayer getType() {
        return TypePlayer.INTERACTIVE;
    }
}
