package it.unicam.cs.pa.jraceTrack.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DefaultRace<L extends TrackLocation2D> implements Race<TrackLocation2D>{

    private final List<Player<TrackLocation2D>> players;
    private Track<TrackLocation2D> track;
    private boolean state;

    /**
     * Costruttore che permette di costruire una gara con le configurazioni iniziali settate manualmente senza
     * l'uso di un file di configurazione iniziale.
     *
     * @param track il tracciato di gara.
     * @param numberOfPlayers il numero di giocatori.
     * @param typePlayer il tipo dei giocatori.
     */
    public DefaultRace(Track<TrackLocation2D> track, int numberOfPlayers, TypePlayer typePlayer) {
        //todo aggiungere eccezione: il numero dei giocatori deve essere minore o uguale della larghezza. {controller}
        this.players = new ArrayList<>(numberOfPlayers);
         this.track = track;
        for(int i = 0; i < numberOfPlayers; i++)
            createPlayer(typePlayer);
        setInit(players);
        this.start();
    }

    /**
     * Costruttore che permette di costruire una gara senza settare niente manualmente.
     * Il tracciato e i giocatori vengono settati tramite un file di configurazione iniziale.
     */
    public DefaultRace() {
        this.players = new ArrayList<>();
        this.start();
    }

    private void setInit(List<Player<TrackLocation2D>> players) {
        for (int i = 0; i< players.size(); i++){
            if(this.players.get(i).getCar() == null){
                Car<TrackLocation2D> car = this.getTrack().createCar();
                this.addCar(car);
                this.players.get(i).setCar(car);
            }
        }
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
    public void createTrack(List<TrackLocation2D> start, List<TrackLocation2D> finish, List<TrackLocation2D> walls) {
        this.track = new DefaultTrack2D<>(start, finish, walls);
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
    public void addPlayer(Player<TrackLocation2D> p) {
        if(p.getType() == TypePlayer.BOT && this.players.stream().allMatch(pl -> pl.getType().equals(TypePlayer.BOT))
           || p.getType() == TypePlayer.INTERACTIVE && this.players.stream().allMatch(pl -> pl.getType().equals(TypePlayer.INTERACTIVE))
                || players.stream().noneMatch(player -> player.getName().equals(p.getName())))
            this.players.add(p);
       else
           throw new IllegalArgumentException("ERROR: impossible to add players with different types or same name.");
    }

    @Override
    public void removePlayer(Player<TrackLocation2D> p) {
        this.players.remove(p);
    }

    @Override
    public void addCar(Car<TrackLocation2D> c) {
        if(!this.getTrack().getStart().contains(c.getLocation()) || getTrack().getCarAt(c.getLocation()) != null)
            throw new IllegalArgumentException("ERROR: this location is not valid.");
        track.addCar(c);
    }

    @Override
    public void removeCar(Car<TrackLocation2D> c) {
        this.track.getCars().removeIf(car -> car.equals(c));
    }

    @Override
    public Player<TrackLocation2D> getWinner() {
        return this.players
                .stream()
                .sequential()
                .filter(Player::isWinner)
                .findFirst().orElse(null);
    }

    @Override
    public void setWinnerPlayer(Player<TrackLocation2D> player) {
        if(this.getTrack().getFinish().contains(player.getCar().getLocation())){
            player.setWinner(true);
            this.finish();
        }
    }
}
