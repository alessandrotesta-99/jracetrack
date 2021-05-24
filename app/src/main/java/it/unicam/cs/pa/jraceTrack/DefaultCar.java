package it.unicam.cs.pa.jraceTrack;

import java.util.LinkedList;
import java.util.function.Predicate;

/**
 * Implementazione di default di una macchina.
 * @param <L> locazione della macchina.
 * @param <S> stato della macchina.
 */
public class DefaultCar<L extends Point2D, S extends State> implements Car<Point2D,State>{

    private final Track<Point2D,State> track;
    private final Player player;
    private final Point2D location;
    private final Color color;
    private final State status;
    //percorso totale della macchina.
    private final LinkedList<Point2D> path;

    public DefaultCar(Track<Point2D,State> track, Player player, Color color, Point2D location, S status) {
        this.track = track;
        this.player = player;
        this.color = color;
        this.location = location;
        this.status = status;
        this.path = new LinkedList<>();
    }

    @Override
    public Track<Point2D,State> getTrack() {
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
    public Point2D moveUp() {
        return null;
    }

    @Override
    public Point2D getLastCheckPoint() {
        return path.getLast();
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
    public State getStatus() {
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
        return this.getStatus().equals(State.CRASHED);
    }
}
