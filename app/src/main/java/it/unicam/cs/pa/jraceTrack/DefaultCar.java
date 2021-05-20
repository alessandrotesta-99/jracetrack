package it.unicam.cs.pa.jraceTrack;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

/**
 * Implementazione di default di una macchina.
 * @param <L> locazione della macchina.
 * @param <S> stato della macchina.
 */
public class DefaultCar<L,S extends Stato> implements Car<LineSegment,S>{

    private final Track track;
    private final Player player;
    private final LineSegment location;
    private final Color color;
    private final S status;
    //percorso totale della macchina.
    private final Set<LineSegment> path;

    public DefaultCar(Track track, Player player, Color color, LineSegment location, S status) {
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
    public LineSegment accelerate(Rule r) {
        return null;
    }

    @Override
    public LineSegment brake(Rule r) {
        return null;
    }

    @Override
    public LineSegment getLocation() {
        return this.location;
    }

    @Override
    public Set<LineSegment> getPath() {
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
    public int countMovement(Predicate<? super LineSegment> p) {
        return 0;
    }

    @Override
    public boolean isCrashed() {
        return false;
    }
}
