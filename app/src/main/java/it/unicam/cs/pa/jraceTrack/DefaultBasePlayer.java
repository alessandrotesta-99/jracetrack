package it.unicam.cs.pa.jraceTrack;

public class DefaultBasePlayer implements Player<Point2D, DefaultStateCar>{

    private final String name;
    private int turn;



    public DefaultBasePlayer(String name) {
        this.name = name;
        this.turn = 0;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Car<Point2D, DefaultStateCar> getCar() {
        return null;
    }

    @Override
    public TypePlayer getType() {
        return null;
    }

    @Override
    public DefaultStateCar getStatus() {
        return null;
    }

    @Override
    public Point2D accelerate(Rule r) {
        return null;
    }

    @Override
    public Point2D brake(Rule r) {
        return null;
    }

    @Override
    public int getTurn() {
        if(this.isMyTurn())
            turn++;
        return turn;
    }

    @Override
    public boolean isMyTurn() {
        return false;
    }
}
