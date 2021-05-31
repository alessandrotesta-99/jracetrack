package it.unicam.cs.pa.jraceTrack;

import org.checkerframework.checker.units.qual.C;

import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class DefaultTrack2D<L extends Point2D, S extends DefaultStateCar> implements Track<Point2D, DefaultStateCar> {

    private static final int DEFAULT_WIDTH = 20;
    private static final int DEFAULT_LENGTH = 20;
    private final Map<Car<Point2D, DefaultStateCar>,Point2D> track;
    private final List<Point2D> walls;
    private final int width;
    private final int length;
    //todo trovare una soluzione migliore
    private final List<Point2D> start;
    private final List<Point2D> finish;

    /**
     * Costruttore che crea un circuito con dimensioni di default.
     * todo - aggiungere i muri di default.
     */
 /*   public DefaultTrack2D(){
        this(DEFAULT_WIDTH, DEFAULT_LENGTH);
    }*/

    /**
     * Costruttore che crea un circuito con una certa lunghezza, una certa larghezza
     * e un insieme di muri.
     * @param width larghezza del circuito
     * @param length lunghezza del circuito
     * @param walls muri del circuito
     */
    public DefaultTrack2D(int width, int length, List<Point2D> start, List<Point2D> finish,
                          Point2D... walls) {
        this.isValidTrack(width);
        this.width = width;
        this.length = length;
        this.walls = new LinkedList<>();
        this.track = new HashMap<>();
        //crea un nuovo punto per ogni muro. un muro è un punto quindi ha due coordinate: x, y.
        //ogni muro viene aggiunto alla lista di tutti i muri.
        Arrays.stream(walls).forEach(w -> new Point2D(w.getX(), w.getY()));
        Arrays.stream(walls).forEach(this::addWall);
        //todo studiare una soluzione migliore
        this.start = new ArrayList<>(start);
        this.finish = new ArrayList<>(finish);
       // this.isValidStartFinish();
    }

    @Override
    public List<Car<Point2D, DefaultStateCar>> getCars() {
        return new ArrayList<>(this.track.keySet());
        //todo non so se servirà.
    }

    @Override
    public Car<Point2D, DefaultStateCar> getCarAt(Point2D location) {
        return this.track.keySet().stream().filter(p -> p.getLocation().equals(location)).findFirst().orElse(null);
    }

    @Override
    public Track<Point2D, DefaultStateCar> apply(Point2D l, Rule r) {
        this.track.replace(this.getCarAt(l), l);
        return null;
    }

    @Override
    public List<Point2D> getStart() {
        return this.start;
    }

    @Override
    public List<Point2D> getFinish() {
        return this.finish;
    }

    @Override
    public void addCar(Car<Point2D, DefaultStateCar> c) {
        this.track.putIfAbsent(c, c.getLocation());
    }

    @Override
    public Set<Point2D> getNextLocs(Car<Point2D, DefaultStateCar> c) {
        return c.getLocation().getNextPoint(width, length);
    }

    @Override
    public List<Point2D> getWalls() {
        return walls;
    }

    @Override
    public void addWall(Point2D position) {
        this.walls.add(position);
    }

    @Override
    public DefaultStateCar getStatus(Car<Point2D, DefaultStateCar> c) {
        return c.getStatus();
    }

    /**
     * Metodo che controlla se il circuito ha una larghezza minima di 2 quadretti.
     * @param width larghezza del circuito.
     */
    private void isValidTrack(int width){
        if(width < 2)
            throw new IllegalArgumentException("ERROR: The track is invalid.");
    }

    /**
     * Metodo che controlla se il circuito è circolare.
     * @return true se il circuito è circolare, false altrimenti.
     */
    private boolean isCircle(){
        return start.equals(finish);
    }

    /**
     * Metodo che controlla se il punto di partenza e di arrivo sono validi.
     */
    private void isValidStartFinish() {
        if(!start.get(0).equals(start.get(2)) && finish.get(0).equals(finish.get(2)))
            throw new IllegalStateException("ERROR: the start or finish is invalid.");
    }
}
