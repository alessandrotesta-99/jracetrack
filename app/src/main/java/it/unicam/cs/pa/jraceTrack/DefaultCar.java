package it.unicam.cs.pa.jraceTrack;

import java.util.*;
import java.util.function.Predicate;

/**
 * Implementazione di default di una macchina.
 * @param <L> locazione della macchina.
 * @param <S> stato della macchina.
 */
public class DefaultCar<L extends Point2D, S extends DefaultStateCar> implements Car<Point2D, DefaultStateCar>{

    private final Track<Point2D, DefaultStateCar> track;
    private final Player player;
    private Point2D location;
    private final Color color;
    private DefaultStateCar status;
    //vettore composto da due numeri, uno che indica lo spostamento destra-sinistra e uno lo spostamento alto-basso.
    //1. distanza tra un punto e un altro nell asse x. (spostamento destra-sinistra)
    //2. indica dove è ora nell asse y. (spostamento alto-basso).
 //   private final HashMap<Integer,Integer> vector;
    //1. distanza tra un punto e un altro nell asse x. (spostamento destra-sinistra)
    private int lengthLineSegment;
    //percorso totale della macchina.
    private final List<Point2D> path;

    public DefaultCar(Track<Point2D, DefaultStateCar> track, Player player, Color color, Point2D location) {
        this.track = track;
        this.player = player;
        this.color = color;
        this.location = location;
        this.status = DefaultStateCar.IN_RACE;
        this.path = new LinkedList<>();
        this.lengthLineSegment = 0;
    }


    @Override
    public Track<Point2D, DefaultStateCar> getTrack() {
        return this.track;
    }

    @Override
    public Player getPlayer() {
        return this.player;
    }

    @Override
    public Point2D accelerate(Rule r) {
        return null;
    }

    @Override
    public Point2D brake(Rule r) {
        return null;
    }

    @Override
    public void moveUp(Point2D nextDestination) {
        //gestire eccezioni
        Objects.requireNonNull(nextDestination);
        //mostrare i prossimi punti
        Set<Point2D> s = track.getNextLocs(this);
        //controllare se il punto inserito è nei prossimi punti disponibili
        //se si selezionalo
        if(s.contains(nextDestination) && this.track.getCarAt(nextDestination) == null)
            this.setLocation(nextDestination);
        else
            //TODO da vedere meglio se lanciare un eccezione.
            throw new IllegalArgumentException("ERROR: this point is invalid.");
        //aggiungere il punto al path
        path.add(nextDestination);
        lengthLineSegment = this.getLastCheckPoint().getX() - this.getLocation().getX();
        //controlla se la macchina è nel circuito.
        if(this.hitsWall())
            this.setStatus(DefaultStateCar.CRASHED);
    }

    @Override
    public Point2D getLastCheckPoint() {
        return path.get(path.size() - 1);
    }

    @Override
    public void setLastCheckPoint(Point2D p) {
        this.path.set(path.size()-1,p);
    }

    @Override
    public Point2D getLocation() {
        return this.location;
    }

    @Override
    public void setLocation(Point2D l) {
        this.location = l;
    }

    @Override
    public List<Point2D> getPath() {
        return this.path;
    }

    @Override
    public DefaultStateCar getStatus() {
        return this.status;
    }

    @Override
    public void setStatus(DefaultStateCar status) {
        this.status = status;
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public int countMovement(Predicate<? super Point2D> p) {
        return 0;
    }

    @Override
    public boolean hitsWall() {
        return false;
    }

}
