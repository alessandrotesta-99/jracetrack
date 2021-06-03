package it.unicam.cs.pa.jraceTrack;

import java.util.*;

public class DefaultTrack2D<L extends Point2D, S extends DefaultStateCar> implements Track<Point2D, DefaultStateCar> {

    private final Map<Car<Point2D, DefaultStateCar>,Point2D> track;
    private final List<Point2D> walls;
    private final int width;
    //todo trovare una soluzione migliore
    private final List<Point2D> start;
    private final List<Point2D> finish;

    /**
     * Costruttore che crea un circuito con una certa lunghezza, una certa larghezza
     * e un insieme di muri.
     * @param width larghezza del circuito
     * @param walls muri del circuito
     */
    public DefaultTrack2D(int width, List<Point2D> start, List<Point2D> finish,
                          Point2D... walls) {
        this.width = width;
        this.walls = new LinkedList<>();
        this.track = new HashMap<>();
        Arrays.stream(walls).forEach(w -> new Point2D(w.getX(), w.getY()));
        Arrays.stream(walls).forEach(this::addWall);
        //todo studiare una soluzione migliore
        this.start = new ArrayList<>(start);
        this.finish = new ArrayList<>(finish);
        this.isValidTrack(width);
        this.isValidStartFinish();
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
        return c.getLocation().getNextPoint(c,width);
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
        //TODO refactoring.
        if(width >= 2){
            int a = start.get(0).getY();
            int b = start.get(1).getY();
            int distance = Math.abs(b-a);
            if(distance < width)
                throw new IllegalArgumentException("ERROR: The track is invalid.");
        }
        else
            throw new IllegalArgumentException("ERROR: The track is invalid.");
    }

    /**
     * Metodo che controlla se il punto di partenza e di arrivo sono validi.
     */
    private void isValidStartFinish() {
        if(start.get(0).getX() != start.get(1).getX() || finish.get(0).getX() != finish.get(1).getX())
            throw new IllegalStateException("ERROR: the start or finish is invalid.");
    }
}
