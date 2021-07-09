package it.unicam.cs.pa.jraceTrack.Controller;

import it.unicam.cs.pa.jraceTrack.Model.*;
import it.unicam.cs.pa.jraceTrack.Model.Reader.ObjectReader;
import it.unicam.cs.pa.jraceTrack.Model.Reader.PlayerReaderTXT;
import it.unicam.cs.pa.jraceTrack.Model.Reader.TrackReaderTXT;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public class DefaultController implements Controller<TrackLocation2D> {

    private final Race<TrackLocation2D> race;
    private final ObjectReader<TrackLocation2D> readerTrack;
    private final ObjectReader<TrackLocation2D> readerPlayers;

    public DefaultController() {
        this.race = new DefaultRace<>();
        this.readerTrack = new TrackReaderTXT(race);
        this.readerPlayers = new PlayerReaderTXT(race);
    }

    @Override
    public void newGame() {
        race.start();
    }

    @Override
    public void finish() {
        race.finish();
    }

    @Override
    public List<Player<TrackLocation2D>> getPlayers() {
        return race.getPlayers();
    }

    @Override
    public Track<TrackLocation2D> getTrack() {
        return race.getTrack();
    }

    @Override
    public List<Car<TrackLocation2D>> getCars() {
        return getTrack().getCars();
    }

    @Override
    public void addCar(Track<TrackLocation2D> track, Car<TrackLocation2D> car, Color color) {
        getTrack().addCar(car);
        car.setColor(color);
    }

    @Override
    public void removeCar(Car<TrackLocation2D> car) {
        getTrack().getCars().removeIf(c -> c.equals(car));
    }

    @Override
    public void addPlayer(Player<TrackLocation2D> player) {
        race.createPlayer(player.getType());
    }

    @Override
    public void removePlayer(Player<TrackLocation2D> player) {
        race.getPlayers().removeIf(p -> p.equals(player));
    }

    @Override
    public void setWinnerPlayer(Player<TrackLocation2D> player) {
        race.setWinnerPlayer(player);
    }

    @Override
    public Player<TrackLocation2D> getWinner() {
        return race.getWinner();
    }

    @Override
    public List<DefaultStateCar> getStatusCars() {
        return getTrack().getStatusCars();
    }

    @Override
    public DefaultStateCar getStatus(TrackLocation2D loc) {
        return getTrack().getStatusAt(loc);
    }

    @Override
    public boolean isGameOver() {
        return getTrack().isGameOver();
    }

    @Override
    public void moveUp(TrackLocation2D loc) {
        //todo
    }

    @Override
    public Car<TrackLocation2D> getCarAt(TrackLocation2D loc) {
        return getTrack().getCarAt(loc);
    }

    @Override
    public Set<TrackLocation2D> getNextLocs(TrackLocation2D loc) {
        return getTrack().getNextLocs(loc);
    }

    @Override
    public void loadTrack(String name) throws IOException {
        readerTrack.read(name);
    }

    @Override
    public void loadPlayers(String name) throws IOException {
        readerPlayers.read(name);
    }
}
