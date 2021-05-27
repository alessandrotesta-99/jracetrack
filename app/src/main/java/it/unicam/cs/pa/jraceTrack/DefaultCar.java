package it.unicam.cs.pa.jraceTrack;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Implementazione di default di una macchina.
 * @param <L> locazione della macchina.
 * @param <S> stato della macchina.
 */
public class DefaultCar<L extends Point2D, S extends DefaultStateCar> implements Car<Point2D, DefaultStateCar>{

    private final Track<Point2D, DefaultStateCar> track;
    private final Player player;
    private final Point2D location;
    private final Color color;
    private final DefaultStateCar status;
    //vettore composto da due numeri, uno che indica lo spostamento destra-sinistra e uno lo spostamento alto-basso.
    private  List<Point2D> vector;
    //percorso totale della macchina.
    private final LinkedList<Point2D> path;

    public DefaultCar(Track<Point2D, DefaultStateCar> track, Player player, Color color, Point2D location, DefaultStateCar status) {
        this.track = track;
        this.player = player;
        this.color = color;
        this.location = location;
        this.status = status;
        this.path = new LinkedList<>();
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
    public Point2D moveUp(Point2D l) {
        //
        //aggiungere il movimento al path
        return null;
    }

    @Override
    public Point2D getLastCheckPoint() {
        return path.get(path.size() - 1);
    }

    @Override
    public Point2D getLocation() {
        return this.location;
    }

    @Override
    public LinkedList<Point2D> getPath() {
        return this.path;
    }

    @Override
    public DefaultStateCar getStatus() {
        return this.status;
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
    public boolean isCrashed() {
        return this.getStatus().equals(DefaultStateCar.CRASHED);
    }
}
