package it.unicam.cs.pa.jraceTrack;

import java.util.*;

public class DefaultRace<L extends TrackLocation2D> implements Race<TrackLocation2D>{

    private final List<Player<TrackLocation2D>> players;
    private Track<TrackLocation2D> track;
    private List<Rule> rules;
    private boolean state;

    public DefaultRace(Track<TrackLocation2D> track, Player<TrackLocation2D>... players) {
        this.rules = new ArrayList<>();
        this.players = new ArrayList<>(players.length);
        createTrack(track);
        Arrays.stream(players).forEach(this::addPlayer);
        setInit(players);
        this.start();
    }

    private void setInit(Player<TrackLocation2D> ... players) {
        for (int i = 0; i< players.length; i++){
            Car<TrackLocation2D> car = new DefaultCar<>(this.getTrack());
            this.addCar(car);
            this.players.get(i).setCar(car);
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
    public void createTrack(Track<TrackLocation2D> track) {
        this.track = track;
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
    public void setWinnerPlayer(Player<TrackLocation2D> player) {
        if(this.getTrack().getFinish().contains(player.getCar().getLocation())){
            player.setWinner(true);
            this.finish();
        }
    }
}
