package it.unicam.cs.pa.jraceTrack;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Implementazione di default di una macchina.
 * @param <L> locazione della macchina.
 */
public class DefaultCar<L extends TrackLocation2D> implements Car<TrackLocation2D>{

    private final Track<TrackLocation2D> track;
    private TrackLocation2D location;
    private final Color color;
    private DefaultStateCar status;
    private int currentVelocity;
    private final List<TrackLocation2D> path;

    public DefaultCar(Track<TrackLocation2D> track, Color color) {
        this.track = track;
        this.color = color;
        this.location = track.getStart().get(0);
        this.status = DefaultStateCar.IN_RACE;
        this.path = new LinkedList<>();
        this.currentVelocity = 0;
        this.path.add(this.location);
    }

    @Override
    public Track<TrackLocation2D> getTrack() {
        return this.track;
    }

    @Override
    public void moveUp(TrackLocation2D nextDestination) {
        Objects.requireNonNull(nextDestination);
        if(this.track.getNextLocs(this).contains(nextDestination) && this.track.getCarAt(nextDestination) == null)
            this.setLocation(nextDestination);
        else
            throw new IllegalArgumentException("ERROR: this point is invalid.");
        path.add(nextDestination);
        setCurrentVelocity(Math.abs(getDistanceX()), Math.abs(getDistanceY()));
        if(this.hitsWall())
            this.isCrashed();
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
    public TrackLocation2D getLastCheckPoint() {
        if(path.size() == 1)
            return path.get(0);
        else
            return path.get((path.size())-2);
    }

    @Override
    public TrackLocation2D getLocation() {
        return this.location;
    }

    @Override
    public void setLocation(TrackLocation2D l) {
        this.location = l;
    }

    @Override
    public int getCurrentVelocity() {
        return currentVelocity;
    }

    @Override
    public List<TrackLocation2D> getPath() {
        return this.path;
    }

    @Override
    public DefaultStateCar getStatus() {
        return this.status;
    }

    @Override
    public void isCrashed() {
        this.status = DefaultStateCar.CRASHED;
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public boolean hitsWall() {
        return this.getTrack().getWalls()
                .stream()
                .filter(p -> p.equals(this.getLocation()))
                .collect(Collectors.toSet())
                .isEmpty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultCar<?> that = (DefaultCar<?>) o;
        return Objects.equals(track, that.track) && Objects.equals(location, that.location) && Objects.equals(color, that.color) && status == that.status && Objects.equals(currentVelocity, that.currentVelocity) && Objects.equals(path, that.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(track, color, path);
    }
}
