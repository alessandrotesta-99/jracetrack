package it.unicam.cs.pa.jraceTrack.Model;

import it.unicam.cs.pa.jraceTrack.Model.Location.DefaultLocation;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class DefaultRace implements Race<DefaultLocation>{

    private final List<Player<DefaultLocation>> players;
    private Track<DefaultLocation> track;
    private boolean state;
    private static final Logger logger = Logger.getGlobal();

    /**
     * Costruttore che permette di costruire una gara senza settare niente manualmente.
     * Il tracciato e i giocatori vengono settati tramite un file di configurazione iniziale.
     */
    public DefaultRace() {
        this.players = new ArrayList<>();
        this.start();
        logger.finest("gara creata correttamente.");
    }

    private void setInit(List<Player<DefaultLocation>> players) {
        for (int i = 0; i< players.size(); i++){
            if(this.players.get(i).getCar() == null){
                Car<DefaultLocation> car = this.getTrack().createCar();
                this.addCar(car);
                this.players.get(i).setCar(car);
            }
        }
    }

    @Override
    public List<Player<DefaultLocation>> getPlayers() {
        return this.players;
    }

    @Override
    public Track<DefaultLocation> getTrack() {
        return this.track;
    }

    @Override
    public void start() {
        this.state = true;
    }

    @Override
    public void finish() {
        this.state = false;
    }

    @Override
    public boolean isStart() {
        return state;
    }

    @Override
    public void createTrack(List<DefaultLocation> start, List<DefaultLocation> finish, List<DefaultLocation> walls) {
        this.track = new DefaultTrack(start, finish, walls);
    }

    @Override
    public void createPlayer(TypePlayer typePlayer) {
        if(typePlayer == TypePlayer.BOT)
            this.addPlayer(new PlayerBot());
        else if(typePlayer == TypePlayer.INTERACTIVE)
            this.addPlayer(new PlayerInteractive());
        setInit(players);
    }

    @Override
    public void addPlayer(Player<DefaultLocation> p) {
        if(p.getType() == TypePlayer.BOT && this.players.stream().allMatch(pl -> pl.getType().equals(TypePlayer.BOT))
           || p.getType() == TypePlayer.INTERACTIVE && this.players.stream().allMatch(pl -> pl.getType().equals(TypePlayer.INTERACTIVE))
                || players.stream().noneMatch(player -> player.getName().equals(p.getName()))){
            this.players.add(p);
            logger.finest("giocatore aggiunto alla gara correttamente.");
        }
       else
           throw new IllegalArgumentException("ERROR: impossible to add players with different types or same name.");
    }

    @Override
    public void addCar(Car<DefaultLocation> c) {
        if(!this.getTrack().getStart().contains(c.getLocation()) || getTrack().getCarAt(c.getLocation()) != null)
            throw new IllegalArgumentException("ERROR: this location is not valid.");
        track.addCar(c);
    }

    @Override
    public Player<DefaultLocation> getWinner() {
        return this.players
                .stream()
                .sequential()
                .filter(Player::isWinner)
                .findFirst().orElse(null);
    }

    @Override
    public void setWinnerPlayer(List<Player<DefaultLocation>> players) {
        players
                .stream()
                .sequential()
                .filter(p -> p.getCar().getPath()
                        .stream()
                        .sequential()
                        .anyMatch(point -> this.getTrack().getFinish().contains(point))).findFirst().ifPresent(pl -> pl.setWinner(true));
    }
}
