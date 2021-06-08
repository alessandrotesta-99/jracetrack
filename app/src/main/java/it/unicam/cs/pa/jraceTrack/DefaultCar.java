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
        //calcola la velocita prima di fare il movimento.
        int velocityBeforeMovement = 0;
        if(this.getLastCheckPoint() != null && this.vector.getY() != 0)
            velocityBeforeMovement = this.getLocation().getX() - this.getLastCheckPoint().getX();
        //controllare se il punto inserito è nei prossimi punti disponibili
        //se si selezionalo --ok
        if(this.track.getNextLocs(this).contains(nextDestination) && this.track.getCarAt(nextDestination) == null)
            this.setLocation(nextDestination);
        else
            throw new IllegalArgumentException("ERROR: this point is invalid.");
        //aggiungere il punto al path
        path.add(nextDestination);
        //velocita corrente
        currentVelocity = this.getLocation().getX() - this.getLastCheckPoint().getX();
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

    private void accelerate() {
        //todo 6 quadretti è la massima velocità.
        this.vector = new Point2D(3, currentVelocity);
    }

    private void brake() {
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
    public int countMovement(Predicate<? super Point2D> p) {
        return 0;
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
