package it.unicam.cs.pa.jraceTrack;

import java.util.*;

public class DefaultRace<L extends TrackLocation2D> implements Race<TrackLocation2D>{

    //todo aggiungere metodo per controllare se il giocatore ha vinto.

    private final List<Player<TrackLocation2D>> players;
    private Track<TrackLocation2D> track;
    private List<Rule> rules;
    private boolean state;

    public DefaultRace() {
        this.rules = new ArrayList<>();
        this.players = new ArrayList<>();
        this.track = null;
        this.start();
    }

    @Override
    public List<Player<TrackLocation2D>> getPlayers() {
        return this.players;
    }

    @Override
    public Track<TrackLocation2D> getTrack() {
        return this.track;
    }

    @Override
    public void start() {
        this.state = true;
       //TODO dubbi se lasciare qui
    }

    @Override
    public void finish() {
        this.state = false;
        //TODO dubbi se lasciare qui
    }

    @Override
    public boolean isStart() {
        return state;
    }

    @Override
    public Track<TrackLocation2D> createTrack(int width, List<TrackLocation2D> start, List<TrackLocation2D> finish, TrackLocation2D... walls) {
        return this.track = new DefaultTrack2D<>(start,finish,walls);
    }

    @Override
    public void addPlayer(Player<TrackLocation2D> p) {
        //aggiungere eccezioni se inserisci un bot e un giocatore interattivo
        this.players.add(p);
    }

    @Override
    public void removePlayer(Player<TrackLocation2D> p) {
        this.players.remove(p);
    }

    @Override
    public void addCar(Track<TrackLocation2D> t, Car<TrackLocation2D> c) {
        t.addCar(c);
    }

    @Override
    public void removeCar(Car<TrackLocation2D> c) {

    }

    @Override
    public List<Rule> getListRule() {
        return rules;
    }

    @Override
    public void setListRule(List<Rule> rule) {
        this.rules = rule;
    }

    @Override
    public Player<TrackLocation2D> getWinner() {
        return null;
    }

    @Override
    public void setWinnerPlayer(boolean flag, Player<TrackLocation2D> player) {
        if(!player.isWinner())
            player.setWinner(true);
    }
}
