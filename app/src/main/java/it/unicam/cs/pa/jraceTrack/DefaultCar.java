package it.unicam.cs.pa.jraceTrack;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

/**
 * Implementazione di default di una macchina.
 * @param <> locazione della macchina.
 * @param <S> stato della macchina.
 */
public class DefaultCar<S extends Stato> implements Car<Point2D,S>{

    private final Track track;
    private final Player player;
    private final Point2D location;
    private final Color color;
    private final S status;
    //percorso totale della macchina.
    private final Set<Point2D> path;

    public DefaultCar(Track track, Player player, Color color, Point2D location, S status) {
        this.track = track;
        this.player = player;
        this.color = color;
        this.location = location;
        this.status = status;
        this.path = new HashSet<>();
    }

    @Override
    public Track getTrack() {
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
    public Point2D getLocation() {
        return this.location;
    }

    @Override
    public Set<Point2D> getPath() {
        return path;
    }

    @Override
    public S getStatus() {
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
        return false;
    }
}
