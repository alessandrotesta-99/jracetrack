package it.unicam.cs.pa.jraceTrack;

import java.util.*;

public class DefaultRace<L extends TrackLocation2D> implements Race<TrackLocation2D>{

    private final List<Player<TrackLocation2D>> players;
    private Track<TrackLocation2D> track;
    private List<Rule> rules;
    private boolean state;

    public DefaultRace(Track<TrackLocation2D> track, int numberOfPlayers, TypePlayer typePlayer) {
        this.rules = new ArrayList<>();
        this.players = new ArrayList<>(numberOfPlayers);
        createTrack(track);
        for(int i = 0; i < numberOfPlayers; i++)
            createPlayer(typePlayer);
        setInit(players);
        this.start();
    }

    private void setInit(List<Player<TrackLocation2D>> players) {
        for (int i = 0; i< players.size(); i++){
            Car<TrackLocation2D> car = this.getTrack().createCar();
            this.addCar(car);
            this.players.get(i).setCar(car);
            }
        this.players.get(new Random().nextInt(players.size())).setTurn(true);
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
    public void createTrack(Track<TrackLocation2D> track) {
        this.track = track;
    }

    @Override
    public void createPlayer(TypePlayer typePlayer) {
        if(typePlayer == TypePlayer.BOT)
            this.addPlayer(new PlayerBot());
        else if(typePlayer == TypePlayer.INTERACTIVE)
            this.addPlayer(new PlayerInteractive());
    }

    @Override
    public void addPlayer(Player<TrackLocation2D> p) {
        if(p.getType() == TypePlayer.BOT && this.players.stream().allMatch(pl -> pl.getType().equals(TypePlayer.BOT))
           || p.getType() == TypePlayer.INTERACTIVE && this.players.stream().allMatch(pl -> pl.getType().equals(TypePlayer.INTERACTIVE)))
            this.players.add(p);
       else
           throw new IllegalArgumentException("ERROR: impossible to add players with different types.");
    }

    @Override
    public void removePlayer(Player<TrackLocation2D> p) {
        this.players.remove(p);
    }

    @Override
    public void addCar(Car<TrackLocation2D> c) {
        if(!this.getTrack().getStart().contains(c.getLocation()) || getTrack().getCarAt(c.getLocation()) != null)
            throw new IllegalArgumentException("ERROR: this location is not valid.");
        c.setLocation(locationInit());
        c.getPath().add(locationInit());
        track.addCar(c);
    }

    private TrackLocation2D locationInit(){
        TrackLocation2D pos;
        TrackLocation2D randomElement = this.getTrack().getStart().get(new Random().nextInt(this.getTrack().getStart().size()));
        pos = (TrackLocation2D) FactoryLocation.createPoint(randomElement.getX(),randomElement.getY());
        while (getTrack().getCarAt(pos) != null)
            pos = new TrackLocation2D(randomElement.getX(), randomElement.getY());
        return pos;
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
    public void setWinnerPlayer(Player<TrackLocation2D> player) {
        if(this.getTrack().getFinish().contains(player.getCar().getLocation())){
            player.setWinner(true);
            this.finish();
        }
    }
}
