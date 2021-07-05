package it.unicam.cs.pa.jraceTrack;

import java.util.Objects;

public abstract class DefaultBasePlayer implements Player<TrackLocation2D>{

    private String name;
    private int turn;
    private Car<TrackLocation2D> car;
    private boolean yourTurn;
    private boolean winner;

    public DefaultBasePlayer() {
        this.turn = 0;
        this.yourTurn = false;
        this.winner = false;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name){
        this.name = name;
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
    public abstract void moveUp(TrackLocation2D p);

    @Override
    public int getTurn() {
        return turn;
    }

    @Override
    public void setTurn(boolean turn){
        this.yourTurn = turn;
        if(this.isMyTurn())
            this.turn++;
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
