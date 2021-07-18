package it.unicam.cs.pa.jraceTrack.Model;

import it.unicam.cs.pa.jraceTrack.Model.Location.DefaultLocation;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.awt.Color;
/**
 * Implementazione di default di una macchina.
 */
public class DefaultCar implements Car<DefaultLocation>{

    private final Track<DefaultLocation> track;
    private DefaultLocation location;
    private Color color;
    private DefaultStateCar status;
    private int currentVelocity;
    private final List<DefaultLocation> path;
    private static int lastID = 0;
    private final int id;
    private static final Logger logger = Logger.getGlobal();

    public DefaultCar(Track<DefaultLocation> track) {
        Objects.requireNonNull(track);
        this.track = track;
        this.status = DefaultStateCar.IN_RACE;
        this.currentVelocity = 0;
        this.path = new LinkedList<>();
        lastID++;
        this.id = lastID;
        logger.finest("macchina creata correttamente.");
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public Track<DefaultLocation> getTrack() {
        return this.track;
    }

    @Override
    public void moveUp(DefaultLocation nextDestination) {
        Objects.requireNonNull(nextDestination);
        if(this.track.getNextLocs(this.getLocation()).contains(nextDestination) && this.track.getCarAt(nextDestination) == null)
            this.setLocation(nextDestination);
        else
            throw new IllegalArgumentException("ERROR: this point is invalid.");
        path.add(nextDestination);
        setCurrentVelocity(Math.abs(getDistanceX()), Math.abs(getDistanceY()));
        if(this.hitsWall())
            this.setStatus();
        checkStateCar();
    }

    private void checkStateCar() {
        if(getStatus() != DefaultStateCar.CRASHED)
            this.track.addCar(this);
    }

    private int getDistanceY() {
        return Math.subtractExact(this.getLocation().getY(), this.getLastCheckPoint().getY());
    }

    private int getDistanceX() {
        return Math.subtractExact(this.getLocation().getX(), this.getLastCheckPoint().getX());
    }

    private void setCurrentVelocity(int distanceX, int distanceY) {
        currentVelocity = Math.abs(Math.max(distanceX, distanceY));
    }

    @Override
    public DefaultLocation getLastCheckPoint() {
        if(path.size() == 1)
            return path.get(0);
        else
            return path.get((path.size())-2);
    }

    @Override
    public DefaultLocation getLocation() {
        return this.location;
    }

    @Override
    public void setLocation(DefaultLocation l) {
        this.location = l;
    }

    @Override
    public int getCurrentVelocity() {
        return currentVelocity;
    }

    @Override
    public List<DefaultLocation> getPath() {
        return this.path;
    }

    @Override
    public DefaultStateCar getStatus() {
        return this.status;
    }

    @Override
    public void setStatus() {
        logger.finest("La macchina è andata a muro.");
        this.status = DefaultStateCar.CRASHED;
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public boolean hitsWall() {
        return !this.getTrack().getWalls()
                .stream()
                .filter(p -> p.equals(this.getLocation()))
                .collect(Collectors.toSet())
                .isEmpty();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultCar that = (DefaultCar) o;
        return getId() == that.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "\n{" +
                "id=" + id +
                ", track=" + track +
                ", location=" + location +
                ", color=" + color +
                ", status=" + status +
                ", currentVelocity=" + currentVelocity +
                ", path=" + path +
                '}';
    }
}
