package it.unicam.cs.pa.jraceTrack;

public abstract class DefaultBasePlayer<L extends TrackLocation2D> implements Player<TrackLocation2D>{

    private final String name;
    private int turn;
    private final Car<TrackLocation2D> car;
    private boolean yourTurn;
    private boolean winner;


    public DefaultBasePlayer(String name, Car<TrackLocation2D> car) {
        this.name = name;
        this.turn = 0;
        this.yourTurn = false;
        this.car = car;
        this.winner = false;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Car<TrackLocation2D> getCar() {
        return this.car;
    }

    @Override
    public abstract TypePlayer getType();

    @Override
    public DefaultStateCar getStatus() {
        return this.getCar().getStatus();
    }

    @Override
    public void moveUp(TrackLocation2D p) {
        this.getCar().moveUp(p);
    }

    @Override
    public int getTurn() {
        if(this.isMyTurn())
            turn++;
        return turn;
    }

    @Override
    public void setTurn(boolean turn){
        this.yourTurn = turn;
    }

    @Override
    public boolean isMyTurn() {
        return yourTurn;
    }

    @Override
    public void setWinner(boolean flag){
        this.winner = flag;
    }

    @Override
    public boolean isWinner(){
        return this.winner;
    }
}
