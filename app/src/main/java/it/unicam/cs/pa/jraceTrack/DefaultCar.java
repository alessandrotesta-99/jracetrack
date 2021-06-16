package it.unicam.cs.pa.jraceTrack;

import java.util.*;

/**
 * Implementazione di default di una macchina.
 * @param <L> locazione della macchina.
 * @param <S> stato della macchina.
 */
public class DefaultCar<L extends Point2D, S extends DefaultStateCar> implements Car<Point2D, DefaultStateCar>{

    private final Track<Point2D, DefaultStateCar> track;
    private Point2D location;
    private final Color color;
    private DefaultStateCar status;
    //vettore composto da due numeri, uno che indica lo spostamento destra-sinistra e uno lo spostamento alto-basso.
    private Point2D vector;
    //velocita della macchina (lunghezza del segmento).
    private int currentVelocity;
    //percorso totale della macchina.
    private final List<Point2D> path;

    public DefaultCar(Track<Point2D, DefaultStateCar> track, Color color) {
        this.track = track;
        this.color = color;
        this.location = track.getStart().get(0);
        this.status = DefaultStateCar.IN_RACE;
        this.path = new LinkedList<>();
        this.vector = FactoryPoint.createPoint(0, currentVelocity);
        this.currentVelocity = 0;
        this.path.add(this.location);
    }


    @Override
    public Track<Point2D, DefaultStateCar> getTrack() {
        return this.track;
    }

    @Override
    public void moveUp(Point2D nextDestination) {
        Objects.requireNonNull(nextDestination);
        int velocityBeforeMovement = 0;
        if(this.vector.getY() != 0)
            velocityBeforeMovement = Math.max(getDistanceX(), getDistanceY());
        if(this.track.getNextLocs(this).contains(nextDestination) && this.track.getCarAt(nextDestination) == null)
            this.setLocation(nextDestination);
        else
            throw new IllegalArgumentException("ERROR: this point is invalid.");
        path.add(nextDestination);
        setCurrentVelocity(getDistanceX(),getDistanceY());
        checkMove(velocityBeforeMovement);
        //controlla se la macchina è nel circuito.
        if(this.hitsWall())
            this.setStatus(DefaultStateCar.CRASHED);
    }

    public int getDistanceY() {
        return Math.abs(Math.subtractExact(this.getLocation().getY(), this.getLastCheckPoint().getY()));
    }

    public int getDistanceX() {
        return Math.abs(Math.subtractExact(this.getLocation().getX(), this.getLastCheckPoint().getX()));
    }

    private void checkMove(int velocityBeforeMovement) {
        if(velocityBeforeMovement == 0)
            this.vector = new Point2D(1, currentVelocity);
        else
            this.move();
     }

    private void setCurrentVelocity(int distanceX, int distanceY) {
        currentVelocity = Math.abs(Math.max(distanceX, distanceY));
    }

    private void move() {
        //todo 6 quadretti è il massimo.
        if (this.path.size() != 2) {
            if(vector.getX() == 1){
                if(currentVelocity < vector.getY())
                    setVector();
                else
                    setVector(3);
            }else if(vector.getX() == 2)
                setVector();
            else if(vector.getX() == 3)
                setVector(1);
        }else
            this.vector = FactoryPoint.createPoint(1,currentVelocity);
    }

    private void setVector(int x1){
        if (getDistanceX() != 1 && getDistanceY() != 1) {
            if(getDistanceX() == 2 || getDistanceY() == 2
                    && (this.getLocation().getX() != this.getLastCheckPoint().getX()))
                this.vector = FactoryPoint.createPoint(x1,currentVelocity);
            else
                this.vector = FactoryPoint.createPoint(1,currentVelocity);
        } else
            this.vector = FactoryPoint.createPoint(2,currentVelocity);
    }

    private void setVector() {
        //todo da vedere se levare un uguale sposta gli equilibri.
        if(this.getLocation().getX() < this.getLastCheckPoint().getX()
                || this.getLocation().getY() < this.getLastCheckPoint().getY())
            this.vector = FactoryPoint.createPoint(1,currentVelocity);
        else if(this.getLocation().getX() > this.getLastCheckPoint().getX()
                && this.getLocation().getY() != this.getLastCheckPoint().getY()
                || this.getLocation().getY() > this.getLastCheckPoint().getY()
                && this.getLocation().getX() != this.getLastCheckPoint().getX())
            this.vector = FactoryPoint.createPoint(3,currentVelocity);
        else
            this.vector = FactoryPoint.createPoint(this.getVector().getX(), currentVelocity);
    }

    @Override
    public Point2D getLastCheckPoint() {
        if(path.size() == 1)
            return path.get(0);
        else
            return path.get((path.size())-2);
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
    public Point2D getVector() {
        return vector;
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
