package it.unicam.cs.pa.jraceTrack.Controller;

import it.unicam.cs.pa.jraceTrack.Model.TrackLocation2D;
import it.unicam.cs.pa.jraceTrack.Model.Race;
import it.unicam.cs.pa.jraceTrack.Model.Player;
import it.unicam.cs.pa.jraceTrack.Model.Track;
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
import java.util.Stack;

public class DefaultController implements Controller<TrackLocation2D> {

    private final Race<TrackLocation2D> race;
    private final ObjectReader<TrackLocation2D> readerTrack;
    private final ObjectReader<TrackLocation2D> readerPlayers;
    private final Stack<Player<TrackLocation2D>> playersStack;

    public DefaultController(Race<TrackLocation2D> race, ObjectReader<TrackLocation2D> readerTrack, ObjectReader<TrackLocation2D> readerPlayers){
        this.race = race;
        this.readerTrack = readerTrack;
        this.readerPlayers = readerPlayers;
        this.playersStack = new Stack<>();
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
        race.getPlayers().stream().filter(p -> !p.isMyTurn()).forEach(playersStack::add);
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
    public void setWinnerPlayer(List<Player<TrackLocation2D>> players) {
        race.setWinnerPlayer(players);
    }

    @Override
    public Player<TrackLocation2D> getWinner() {
        return race.getWinner();
    }

    @Override
    public List<DefaultStateCar> getStatusCars(Track<TrackLocation2D> track) {
        return track.getStatusCars();
    }

    @Override
    public DefaultStateCar getStatus(TrackLocation2D loc, Track<TrackLocation2D> track) {
        return track.getStatusAt(loc);
    }

    @Override
    public void moveUp(TrackLocation2D loc, Player<TrackLocation2D> player) {
        if(player.getType().equals(TypePlayer.BOT))
            player.moveUp(null);
        else if(player.getType().equals(TypePlayer.INTERACTIVE))
            player.moveUp(loc);
        player.setTurn(false);
        playersStack.pop().setTurn(true);
    }

    @Override
    public Set<TrackLocation2D> getNextLocs(TrackLocation2D loc, Track<TrackLocation2D> track) {
        return track.getNextLocs(loc);
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
    public Race<TrackLocation2D> getRace() {
        return race;
    }

    @Override
    public List<TrackLocation2D> getCarPath(Car<TrackLocation2D> car) {
        return car.getPath();
    }
}
