package it.unicam.cs.pa.jraceTrack.Model;

import java.util.Objects;

public abstract class DefaultBasePlayer implements Player<TrackLocation2D>{

    private String name;
    private int turn;
    private Car<TrackLocation2D> car;
    private boolean yourTurn;
    private boolean winner;
    private final int id;
    private static int lastID = 0;

    public DefaultBasePlayer() {
        this.turn = 0;
        this.yourTurn = false;
        this.winner = false;
        lastID++;
        this.id = lastID;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultBasePlayer that = (DefaultBasePlayer) o;
        return turn == that.turn && yourTurn == that.yourTurn && winner == that.winner && id == that.id && Objects.equals(name, that.name) && Objects.equals(car, that.car);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, turn, car, yourTurn, winner, id);
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", turn=" + turn +
                ", car=" + car +
                ", yourTurn=" + yourTurn +
                ", winner=" + winner +
                "}\n";
    }
}
