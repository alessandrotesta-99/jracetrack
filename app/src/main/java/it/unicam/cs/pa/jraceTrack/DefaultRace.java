package it.unicam.cs.pa.jraceTrack;

import java.util.*;
import java.util.stream.Collectors;

public class DefaultRace<L extends Point2D, S extends DefaultStateCar> implements Race<Point2D,DefaultStateCar>{

    private final List<Player<Point2D, DefaultStateCar>> players;
    private Track<Point2D, DefaultStateCar> track;
    private boolean state;

    public DefaultRace() {
        this.players = new ArrayList<>();
        this.track = null;
        this.start();
    }

    @Override
    public List<Player<Point2D, DefaultStateCar>> getPlayers() {
        return this.players;
    }

    @Override
    public Track<Point2D, DefaultStateCar> getTrack() {
        return this.track;
    }

    @Override
    public void start() {
        //fai partire il tempo (se voglio)

        //assegna il turno a uno dei giocatori in maniera randomica.
        Random r = new Random();
        Player<Point2D, DefaultStateCar> p1 = players.get(r.nextInt(players.size()));
        p1.setTurn(true);
        //se è il turno di un giocatore far vedere a lui i prossimi punti.
     //   p1.getCar().getLocation().getNextPoint(0);
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
    public List<DefaultStateCar> getStatus() {
        return this.getTrack().getCars().stream().map(Car::getStatus).collect(Collectors.toList());
    }

    @Override
    public Track<Point2D, DefaultStateCar> createTrack(int width, List<Point2D> start, List<Point2D> finish, Point2D... walls) {
        return this.track = new DefaultTrack2D<>(start,finish,walls);
    }

    @Override
    public void addPlayer(Player<Point2D, DefaultStateCar> p) {
        //aggiungere eccezioni se inserisci un bot e un giocatore interattivo
        this.players.add(p);
    }

    @Override
    public void getStatistics() {

    }

    @Override
    public List<Rule> getListRule() {
        return null;
    }
}
