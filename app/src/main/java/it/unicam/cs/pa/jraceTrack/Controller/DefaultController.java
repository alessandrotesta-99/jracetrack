package it.unicam.cs.pa.jraceTrack.Controller;

import it.unicam.cs.pa.jraceTrack.Model.Location.DefaultLocation;
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
import java.util.logging.Logger;

public class DefaultController implements Controller<DefaultLocation> {

    private final Race<DefaultLocation> race;
    private final ObjectReader readerTrack;
    private final ObjectReader readerPlayers;
    private final Stack<Player<DefaultLocation>> playersStack;
    private static final Logger logger = Logger.getGlobal();

    public DefaultController(Race<DefaultLocation> race, ObjectReader readerTrack, ObjectReader readerPlayers){
        this.race = race;
        this.readerTrack = readerTrack;
        this.readerPlayers = readerPlayers;
        this.playersStack = new Stack<>();
        logger.finest("Controller creato.");
    }

    public DefaultController(Race<DefaultLocation> race, String nameFileTrack, String nameFilePlayers){
        this(race, new TrackReaderTXT(race,nameFileTrack), new PlayerReaderTXT(race, nameFilePlayers));
    }

    @Override
    public void newGame() {
        race.start();
        logger.finest("gara iniziata.");
    }

    @Override
    public void finish() {
        race.finish();
        logger.finest("gara finita.");
    }

    @Override
    public boolean isStart() {
        return race.isStart();
    }

    @Override
    public List<Player<DefaultLocation>> getPlayers() {
        race.getPlayers().stream().filter(p -> !p.isMyTurn()).forEach(playersStack::add);
        return race.getPlayers();
    }

    @Override
    public Track<DefaultLocation> getTrack() {
        return race.getTrack();
    }

    @Override
    public List<Car<DefaultLocation>> getCars(Track<DefaultLocation> track) {
        return track.getCars();
    }

    @Override
    public void setWinnerPlayer(List<Player<DefaultLocation>> players) {
        race.setWinnerPlayer(players);
    }

    @Override
    public Player<DefaultLocation> getWinner() {
        return race.getWinner();
    }

    @Override
    public List<DefaultStateCar> getStatusCars(Track<DefaultLocation> track) {
        return track.getStatusCars();
    }

    @Override
    public DefaultStateCar getStatus(DefaultLocation loc, Track<DefaultLocation> track) {
        return track.getStatusAt(loc);
    }

    @Override
    public void moveUp(DefaultLocation loc, Player<DefaultLocation> player) {
        if(player.getType().equals(TypePlayer.BOT))
            player.moveUp(null);
        else if(player.getType().equals(TypePlayer.INTERACTIVE))
            player.moveUp(loc);
        player.setTurn(false);
        playersStack.pop().setTurn(true);
    }

    @Override
    public Set<DefaultLocation> getNextLocs(DefaultLocation loc, Track<DefaultLocation> track) {
        return track.getNextLocs(loc);
    }

    @Override
    public int getTurnPlayer(Player<DefaultLocation> player) {
        return player.getTurn();
    }

    @Override
    public void loadTrack() throws IOException {
        readerTrack.read();
        logger.finest("file tracciato caricato.");
    }

    @Override
    public void loadPlayers() throws IOException {
        readerPlayers.read();
        this.race.getPlayers().get(new Random().nextInt(getPlayers().size())).setTurn(true);
        logger.finest("file giocatori caricato.");
    }

    @Override
    public List<DefaultLocation> getCarPath(Car<DefaultLocation> car) {
        return car.getPath();
    }
}
