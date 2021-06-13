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
        this.vector = new Point2D(0, currentVelocity);
        this.currentVelocity = 0;
        this.path.add(this.location);
    }


    @Override
    public Track<Point2D, DefaultStateCar> getTrack() {
        return this.track;
    }

    @Override
    public void moveUp(Point2D nextDestination) {
        //gestire eccezioni --ok
        Objects.requireNonNull(nextDestination);
        //calcola la velocita prima di fare il movimento. --not ok
        int velocityBeforeMovement = 0;
        if(this.vector.getY() != 0)
            velocityBeforeMovement = this.getLocation().getX() - this.getLastCheckPoint().getX();
        //controllare se il punto inserito è nei prossimi punti disponibili
        //se si selezionalo --ok
        if(this.track.getNextLocs(this).contains(nextDestination) && this.track.getCarAt(nextDestination) == null)
            this.setLocation(nextDestination);
        else
            throw new IllegalArgumentException("ERROR: this point is invalid.");
        path.add(nextDestination);
        setCurrentVelocity();
        //switch:
        //3 casi
        //accellera
        if(currentVelocity > velocityBeforeMovement)
            this.accelerate();
        //frena
        else if(currentVelocity < velocityBeforeMovement || velocityBeforeMovement == 0)
            this.brake();
        //rimane stabile
        else
            this.vector = new Point2D(2, currentVelocity);
        //controlla se la macchina è nel circuito.
        if(this.hitsWall())
            this.setStatus(DefaultStateCar.CRASHED);
    }

    private void setCurrentVelocity() {
        int distanceX = this.getLocation().getX() - this.getLastCheckPoint().getX();
        int distanceY = this.getLocation().getY() - this.getLastCheckPoint().getY();
        if(distanceX >= distanceY)
            currentVelocity = Math.abs(distanceX);
        else
            currentVelocity = Math.abs(distanceY);
    }

    private void accelerate() {
        //todo 6 quadretti è il massimo. && refactoring.
        if(this.path.size() == 2)
            this.vector = new Point2D(1,currentVelocity);
        else
            if(vector.getX() == 1){
                if(this.getLocation().getX() - this.getLastCheckPoint().getX() == 1
                        || this.getLocation().getY() - this.getLastCheckPoint().getY() == 1)
                    this.vector = new Point2D(2,currentVelocity);
                else if(this.getLocation().getX() - this.getLastCheckPoint().getX() == 2
                        ||this.getLocation().getY() - this.getLastCheckPoint().getY() == 2)
                    this.vector = new Point2D(3,currentVelocity);
            }
            else if(vector.getX() == 2){
                if(this.getLocation().getX() < this.getLastCheckPoint().getX()
                        || this.getLocation().getY() < this.getLastCheckPoint().getY())
                    this.vector = new Point2D(1,currentVelocity);
                else
                    this.vector = new Point2D(3, currentVelocity);
            }
            else if(vector.getX() == 3){
                if(this.getLocation().getX() - this.getLastCheckPoint().getX() == 1
                        || this.getLocation().getY() - this.getLastCheckPoint().getY() == 1)
                    this.vector = new Point2D(2,currentVelocity);
                else if(this.getLocation().getX() - this.getLastCheckPoint().getX() == 2
                        || this.getLocation().getY() - this.getLastCheckPoint().getY() == 2)
                    this.vector = new Point2D(1,currentVelocity);
            }
        this.vector = new Point2D(this.getVector().getX(), currentVelocity);


        /*    if(this.getLocation().getX() == this.getLastCheckPoint().getX()
                    || this.getLocation().getY() - this.getLastCheckPoint().getY() == currentVelocity)
                this.vector = new Point2D(2,currentVelocity);
            else if (this.getLocation().getX() - this.getLastCheckPoint().getX() == 2
                    || this.getLocation().getY() - this.getLastCheckPoint().getY() == 2)
                this.vector = new Point2D(3,currentVelocity);
            else if(this.getLocation().getX() - this.getLastCheckPoint().getX() == 0
                    || this.getLocation().getY() - this.getLastCheckPoint().getY() == 0 )
                this.vector = new Point2D(this.getVector().getX(), currentVelocity);
       */
    }

    private void brake() {
        //todo
        this.vector = new Point2D(1, currentVelocity);
    }

    @Override
    public Point2D getLastCheckPoint() {
        if(path.size() == 1)
            return path.get(0);
        else
            return path.get((path.size()-1)-1);
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

        //spostarsi sull asse x di un numero uguale a:
        // 1. freni, quindi: (lunghezza segmento tra punto corrente e punto corrente -1) - 1.
        //2. accelleri, quindi: (lunghezza segmento tra punto corrente e punto corrente -1) + 1.
        //3. rimani alla stessa velocita, quindi:  (lunghezza segmento tra punto corrente e punto corrente -1) + 0.

        //spostarsi sull asse y di un numero uguale a:
        //1. freni, quindi:  (lunghezza segmento tra punto corrente e punto corrente -1) + 1 o +2 o +3.
        //2. accelleri, quindi:  (lunghezza segmento tra punto corrente e punto corrente -1) +1 o +2 o +3.
        //3. rimani alla stessa velocita, quindi:  (lunghezza segmento tra punto corrente e punto corrente -1) +1 o +2 o +3.

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
