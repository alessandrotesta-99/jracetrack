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
    public void createTrack(Track<TrackLocation2D> track) {
        Objects.requireNonNull(track);
        this.track = track;
    }

    @Override
    public void addPlayer(Player<TrackLocation2D> p) {
        if(p.getType() == TypePlayer.BOT)
            this.players.add(new PlayerBot(p.getName(),p.getCar()));
        else
            this.players.add(new PlayerInteractive(p.getName(), p.getCar()));
        //aggiungere eccezioni se inserisci un bot e un giocatore interattivo todo
        this.players.add(p);
    }

    @Override
    public void removePlayer(Player<TrackLocation2D> p) {
        this.players.remove(p);
    }

    @Override
    public void addCar(Car<TrackLocation2D> c) {
        if(this.track.getCars().contains(c))
            throw new IllegalArgumentException("ERROR: this car already exists.");
        track.addCar(c);
    }

    @Override
    public void removeCar(Car<TrackLocation2D> c) {
        this.track.getCars().removeIf(car -> car.equals(c));
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
        return this.players
                .stream()
                .filter(Player::isWinner)
                .findFirst().orElse(null);
    }

    @Override
    public void setWinnerPlayer(boolean flag, Player<TrackLocation2D> player) {
        //todo
        if(!player.isWinner())
            player.setWinner(true);
    }
}
