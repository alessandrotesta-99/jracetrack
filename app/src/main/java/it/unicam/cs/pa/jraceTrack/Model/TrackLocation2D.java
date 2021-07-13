package it.unicam.cs.pa.jraceTrack.Model;

import java.util.Set;
import java.util.Objects;

/**
 * Classe che ha la responsabilit&agrave; di specificare, nel circuito 2D, una locazione nel piano
 * composta da due coordinate.
 * Un oggetto {@link TrackLocation2D} pu&ograve; indicare: i bordi del circuito, i punti che rappresentano il punto di
 * partenza e il punto di arrivo, e tutto il cammino percorso dalla macchina in gara.
 * Questa classe non pu&ograve; essere estesa da altre classi. Nel caso si volesse implementare un diverso modo
 * di locazione, creare una nuova classe che implementi L'interfaccia per la locazione.
 */
public final class TrackLocation2D implements Location<TrackLocation2D> {


    private final int x;
    private final int y;

    public TrackLocation2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public Set<TrackLocation2D> getNextLocations(Car<TrackLocation2D> c){
        if(c.getCurrentVelocity() == 0)
            return calculateAdjacentPoints(c.getLocation().getX(), c.getLocation().getY());
        else
            return calculateNextPoints(c);
    }

    private Set<TrackLocation2D> calculateAdjacentPoints(int x, int y){
       return Set.of(new TrackLocation2D(x,y),
                new TrackLocation2D(x, y + 1),
                new TrackLocation2D(x + 1, y),
                new TrackLocation2D(x - 1, y),
                new TrackLocation2D(x - 1, y - 1),
                new TrackLocation2D(x - 1, y + 1),
                new TrackLocation2D(x, y - 1),
                new TrackLocation2D(x + 1, y + 1),
                new TrackLocation2D(x + 1, y - 1));
    }

    private Set<TrackLocation2D> calculateNextPoints(Car<TrackLocation2D> c) {
        if (c.getLocation().getY() < c.getLastCheckPoint().getY())
            return calculateAdjacentPoints(c.getLocation().getX(), c.getLocation().getY() - c.getCurrentVelocity());
        if (c.getLocation().getY() > c.getLastCheckPoint().getY())
            return calculateAdjacentPoints(c.getLocation().getX(), c.getLocation().getY() + c.getCurrentVelocity());
        if(c.getLocation().getX() < c.getLastCheckPoint().getX() &&
                c.getLocation().getY() == c.getLastCheckPoint().getY())
            return calculateAdjacentPoints(c.getLocation().getX() - c.getCurrentVelocity(), c.getLocation().getY());
        if(c.getLocation().getX() > c.getLastCheckPoint().getX()
                && c.getLocation().getY() == c.getLastCheckPoint().getY())
            return calculateAdjacentPoints(c.getLocation().getX() + c.getCurrentVelocity(), c.getLocation().getY());
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrackLocation2D point = (TrackLocation2D) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "{" +
                "x=" + x +
                ", y=" + y +
                "}";
    }
}
