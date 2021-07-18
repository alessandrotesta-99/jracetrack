package it.unicam.cs.pa.jraceTrack.Model;

import it.unicam.cs.pa.jraceTrack.Model.Location.DefaultLocation;

import java.util.Objects;
import java.util.logging.Logger;

public abstract class DefaultBasePlayer implements Player<DefaultLocation>{

    private String name;
    private int turn;
    private Car<DefaultLocation> car;
    private boolean yourTurn;
    private boolean winner;
    private final int id;
    private static int lastID = 0;
    private static final Logger logger = Logger.getGlobal();

    public DefaultBasePlayer() {
        this.turn = 0;
        this.yourTurn = false;
        this.winner = false;
        lastID++;
        this.id = lastID;
        logger.finest("giocatore creato correttamente.");
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
    public Car<DefaultLocation> getCar() {
        return this.car;
    }

    @Override
    public void setCar(Car<DefaultLocation> car){
        Objects.requireNonNull(car);
        this.car = car;
    }

    @Override
    public abstract TypePlayer getType();

    @Override
    public abstract void moveUp(DefaultLocation p);

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
