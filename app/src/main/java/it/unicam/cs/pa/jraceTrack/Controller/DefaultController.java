package it.unicam.cs.pa.jraceTrack.Controller;

import it.unicam.cs.pa.jraceTrack.Model.TrackLocation2D;
import it.unicam.cs.pa.jraceTrack.Model.Race;
import it.unicam.cs.pa.jraceTrack.Model.Player;
import it.unicam.cs.pa.jraceTrack.Model.Track;
import it.unicam.cs.pa.jraceTrack.Model.Color;
import it.unicam.cs.pa.jraceTrack.Model.Car;
import it.unicam.cs.pa.jraceTrack.Model.DefaultStateCar;
import it.unicam.cs.pa.jraceTrack.Model.TypePlayer;
import it.unicam.cs.pa.jraceTrack.Model.Reader.ObjectReader;
import it.unicam.cs.pa.jraceTrack.Model.Reader.PlayerReaderTXT;
import it.unicam.cs.pa.jraceTrack.Model.Reader.TrackReaderTXT;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class DefaultController implements Controller<TrackLocation2D> {

    private final Race<TrackLocation2D> race;
    private final ObjectReader<TrackLocation2D> readerTrack;
    private final ObjectReader<TrackLocation2D> readerPlayers;

    public DefaultController(Race<TrackLocation2D> race, ObjectReader<TrackLocation2D> readerTrack, ObjectReader<TrackLocation2D> readerPlayers){
        this.race = race;
        this.readerTrack = readerTrack;
        this.readerPlayers = readerPlayers;
    }

    public DefaultController(Race<TrackLocation2D> race, String nameFileTrack, String nameFilePlayers){
        this(race, new TrackReaderTXT(race,nameFileTrack), new PlayerReaderTXT(race, nameFilePlayers));
    }

    @Override
    public void newGame() {
        this.race.getPlayers().get(new Random().nextInt(getPlayers().size())).setTurn(true);
        race.start();
    }

    @Override
    public void finish() {
        race.finish();
    }

    @Override
    public boolean isStart() {
        return race.isStart();
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
    public List<Car<TrackLocation2D>> getCars(Track<TrackLocation2D> track) {
        return track.getCars();
    }

    @Override
    public void addCar(Track<TrackLocation2D> track, Car<TrackLocation2D> car, Color color) {
        race.addCar(car);
        car.setColor(color);
    }

    @Override
    public void removeCar(Car<TrackLocation2D> car) {
        race.removeCar(car);
    }

    @Override
    public void addPlayer(Player<TrackLocation2D> player) {
        race.createPlayer(player.getType());
    }

    @Override
    public void removePlayer(Player<TrackLocation2D> player) {
        race.removePlayer(player);
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
    public void moveUp(TrackLocation2D loc, Player<TrackLocation2D> player) {
        if(player.getType().equals(TypePlayer.BOT))
            player.moveUp(null);
        else if(player.getType().equals(TypePlayer.INTERACTIVE))
            player.moveUp(loc);
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
    public int getTurnPlayer(Player<TrackLocation2D> player) {
        return player.getTurn();
    }

    @Override
    public void loadTrack() throws IOException {
        readerTrack.read();
    }

    @Override
    public void loadPlayers() throws IOException {
        readerPlayers.read();
    }

    @Override
    public String getRepresentation(int i) {
        return null; //todo
    }

    @Override
    public Race<TrackLocation2D> getRace() {
        return race;
    }

    @Override
    public List<TrackLocation2D> getCarPath(Car<TrackLocation2D> car) {
        return car.getPath();
    }
}
