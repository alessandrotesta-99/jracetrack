package it.unicam.cs.pa.jraceTrack;

import java.util.*;

public class DefaultTrack2D<L> implements Track<Point2D> {

    private static final int DEFAULT_WIDTH = 20;
    private static final int DEFAULT_LENGTH = 20;
    private final Car[][] track;
    private final List<Car> cars;
    private final LinkedList<Point2D> walls;
    private final int width;
    private final int length;
    //todo da fare
    private final Point2D start = null;
    private final Point2D finish = null;

    /**
     * Costruttore che crea un circuito con dimensioni di default.
     * todo - aggiungere i muri di default.
     */
    public DefaultTrack2D(){
        this(DEFAULT_WIDTH, DEFAULT_LENGTH);
    }

    /**
     * Costruttore che crea un circuito con una certa lunghezza, una certa larghezza
     * e un insieme di muri.
     * @param width larghezza del circuito
     * @param length lunghezza del circuito
     * @param walls muri del circuito
     */
    public DefaultTrack2D(int width, int length, Point2D... walls) {
        this.isValidTrack(width);
        this.width = width;
        this.length = length;
        this.walls = new LinkedList<>();
        this.cars = new ArrayList<>();
        //todo - un po di dubbi ma penso sia cosi
        this.track = new Car[width][length];
        //crea un nuovo punto per ogni muro. un muro è un punto quindi ha due coordinate: x, y.
        //ogni muro viene aggiunto alla lista di tutti i muri.
        Arrays.stream(walls).forEach(w -> new Point2D(w.getX(), w.getY()));
        Arrays.stream(walls).forEach(this::addWall);
    /*    if(this.isCircle()){
            this.setStart(this.getFinish());
            this.setFinish(this.getStart());
        }
        */
        //aggiungere il numero di macchine????
    }

    @Override
    public List<Car> getCars() {
        return cars;
    }

    @Override
    public Car getCarAt(Point2D location) {
       return track[location.getX()][location.getY()];
    }

    @Override
    public Track nextTrack(Rule apply) {
        return null;
    }

    @Override
    public Point2D getStart() {
        return null;
    }

    @Override
    public Point2D getFinish() {
        return null;
    }

    @Override
    public void setStart(LineSegment finish) {

    }

    @Override
    public void setFinish(LineSegment start) {

    }

    @Override
    public Set<Point2D> getNextLocs(Car c) {
        return null;
    }

    @Override
    public LinkedList<Point2D> getWalls() {
        return walls;
    }

    @Override
    public void addWall(Point2D position) {
        this.walls.add(position);
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
}
