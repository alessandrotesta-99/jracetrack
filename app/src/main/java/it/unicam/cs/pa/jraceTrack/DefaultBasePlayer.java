package it.unicam.cs.pa.jraceTrack;

import java.util.Objects;
import java.util.Random;

public abstract class DefaultBasePlayer<L extends TrackLocation2D> implements Player<TrackLocation2D>{

    private final String name;
    private int turn;
    private Car<TrackLocation2D> car;
    private boolean yourTurn;
    private boolean winner;

    public DefaultBasePlayer(String name) {
        this.name = name;
        this.turn = 0;
        this.yourTurn = false;
        this.winner = false;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Car<TrackLocation2D> getCar() {
        return this.car;
    }

    @Override
    public void setCar(Car<TrackLocation2D> car){
        Objects.requireNonNull(car);
        this.car = car;
    }

    @Override
    public abstract TypePlayer getType();

    @Override
    public DefaultStateCar getStatus() {
        return this.getCar().getStatus();
    }

    @Override
    public void moveUp(TrackLocation2D p) {
        if(this.getType() == TypePlayer.BOT){
            int nextPositions = this.getCar().getLocation().getNextLocations(this.getCar()).size();
            int randomElement = new Random().nextInt(nextPositions);
            int count = 0;
            for(TrackLocation2D t : this.getCar().getLocation().getNextLocations(this.getCar())){
                if(count == randomElement)
                    this.getCar().moveUp(t);
                count++;
            }
        }
        else if(this.getType() == TypePlayer.INTERACTIVE)
            this.getCar().moveUp(p);
    }

    @Override
    public int getTurn() {
        if(this.isMyTurn())
            turn++;
        return turn;
    }

    @Override
    public void setTurn(boolean turn){
        this.yourTurn = turn;
    }

    @Override
    public boolean isMyTurn() {
        return yourTurn;
    }

    @Override
    public void setWinner(boolean flag){
        this.winner = flag;
    }

    @Override
    public boolean isWinner(){
        return this.winner;
    }
}
