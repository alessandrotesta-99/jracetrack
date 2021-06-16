package it.unicam.cs.pa.jraceTrack;

public abstract class DefaultBasePlayer<L extends Point2D, S extends DefaultStateCar> implements Player<Point2D, DefaultStateCar>{

    private final String name;
    private int turn;
    private final Car<Point2D, DefaultStateCar> car;
    private boolean yourTurn;
    private boolean winner;


    public DefaultBasePlayer(String name, Car<Point2D, DefaultStateCar> car) {
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
    public Car<Point2D, DefaultStateCar> getCar() {
        return this.car;
    }

    @Override
    public abstract TypePlayer getType();

    @Override
    public DefaultStateCar getStatus() {
        return this.getCar().getStatus();
    }

    @Override
    public void moveUp(Point2D p) {
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
