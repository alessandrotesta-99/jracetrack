package it.unicam.cs.pa.jraceTrack;

import java.util.*;

/**
 * Implementazione di default di una macchina.
 * @param <L> locazione della macchina.
 * @param <S> stato della macchina.
 */
public class DefaultCar<L extends TrackLocation2D, S extends DefaultStateCar> implements Car<TrackLocation2D>{

    private final Track<TrackLocation2D> track;
    private TrackLocation2D location;
    private final Color color;
    private DefaultStateCar status;
    private TrackLocation2D vector;
    private int currentVelocity;
    private final List<TrackLocation2D> path;

    public DefaultCar(Track<TrackLocation2D> track, Color color) {
        this.track = track;
        this.color = color;
        this.location = track.getStart().get(0);
        this.status = DefaultStateCar.IN_RACE;
        this.path = new LinkedList<>();
        this.vector = FactoryLocation.createPoint(0, currentVelocity);
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
        int velocityBeforeMovement = 0;
        if(this.vector.getY() != 0)
            velocityBeforeMovement = Math.max(Math.abs(getDistanceX()), Math.abs(getDistanceY()));
        if(this.track.getNextLocs(this).contains(nextDestination) && this.track.getCarAt(nextDestination) == null)
            this.setLocation(nextDestination);
        else
            throw new IllegalArgumentException("ERROR: this point is invalid.");
        path.add(nextDestination);
        setCurrentVelocity(Math.abs(getDistanceX()), Math.abs(getDistanceY()));
        checkMove(velocityBeforeMovement);
        //controlla se la macchina è nel circuito.
        if(this.hitsWall())
            this.isCrashed();
    }

    public int getDistanceY() {
        return Math.subtractExact(this.getLocation().getY(), this.getLastCheckPoint().getY());
    }

    public int getDistanceX() {
        return Math.subtractExact(this.getLocation().getX(), this.getLastCheckPoint().getX());
    }

    private void checkMove(int velocityBeforeMovement) {
        if(velocityBeforeMovement == 0 || this.path.size() == 2)
            this.vector = new TrackLocation2D(1, currentVelocity);
        else
            this.move();
     }

    private void setCurrentVelocity(int distanceX, int distanceY) {
        currentVelocity = Math.abs(Math.max(distanceX, distanceY));
    }

    private void move() {
        //todo refactoring e da testare meglio.
        //todo 6 quadretti è il massimo.
        if(vector.getX() == 1){
            //se dal vettore 1 mi sposto in verticale nello stesso vettore deve rimanere quel vettore.
            if((getDistanceX() == 0 || getDistanceY() == 0) && this.getLocation().getY() >= this.getLastCheckPoint().getY() || getDistanceX() == 0 && this.getLocation().getY() < this.getLastCheckPoint().getY())
                this.vector = FactoryLocation.createPoint(1,currentVelocity);
            else if(getDistanceX() == 1 || getDistanceY() == 1)
                this.vector = FactoryLocation.createPoint(2,currentVelocity);
            else if(getDistanceX() == -1 || getDistanceY() == -1)
                this.vector = FactoryLocation.createPoint(2,currentVelocity);
            else if(getDistanceX() == 2 || getDistanceY() == 2)
                this.vector = FactoryLocation.createPoint(3,currentVelocity);
            else if(getDistanceX() == -2 || getDistanceY() == -2)
                this.vector = FactoryLocation.createPoint(3,currentVelocity);
        }
        else if(vector.getX() == 2){
            if((getDistanceX() == 0 || getDistanceY() == 0) && this.getLocation().getY() > this.getLastCheckPoint().getY())
                this.vector = FactoryLocation.createPoint(2,currentVelocity);
            else if(getDistanceX() == 0 && this.getLocation().getY() < this.getLastCheckPoint().getY())
                this.vector = FactoryLocation.createPoint(3, currentVelocity);
            else if(getDistanceX() == 1 || getDistanceY() == 1 || getDistanceY() == -1)
                this.vector = FactoryLocation.createPoint(3,currentVelocity);
            else if(getDistanceX() == -1 )
                this.vector = FactoryLocation.createPoint(2,currentVelocity);
        }
        else if(vector.getX() == 3){
            if((getDistanceX() == 0 || getDistanceY() == 0) && this.getLocation().getY() > this.getLastCheckPoint().getY())
                this.vector = FactoryLocation.createPoint(3,currentVelocity);
            else if(getDistanceX() == 0 && this.getLocation().getY() < this.getLastCheckPoint().getY())
                this.vector = FactoryLocation.createPoint(1, currentVelocity);
            else if(getDistanceX() == 1 || getDistanceY() == 1)
                this.vector = FactoryLocation.createPoint(1,currentVelocity);
            else if(getDistanceX() == -1 || getDistanceY() == -1)
                this.vector = FactoryLocation.createPoint(2,currentVelocity);
            else if(getDistanceX() == 2 || getDistanceY() == 2)
                this.vector = FactoryLocation.createPoint(2,currentVelocity);
            else if(getDistanceX() == -2 || getDistanceY() == -2)
                this.vector = FactoryLocation.createPoint(1, currentVelocity);
        }
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
    public TrackLocation2D getVector() {
        return vector;
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
        return false;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultCar<?, ?> that = (DefaultCar<?, ?>) o;
        return Objects.equals(track, that.track)
                && Objects.equals(location, that.location)
                && Objects.equals(color, that.color)
                && status == that.status && Objects.equals(path, that.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(track, location, color, status, currentVelocity, path);
    }

}
